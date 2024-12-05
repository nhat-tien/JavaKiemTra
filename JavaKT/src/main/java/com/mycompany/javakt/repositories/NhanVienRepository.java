package com.mycompany.javakt.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.javakt.models.NhanVien;
import com.mycompany.javakt.models.PhongBan;

public class NhanVienRepository {

  public NhanVienRepository() {}

  public List<NhanVien> getAll() {
    String query = "SELECT nv.MaNV, nv.TenNV, nv.MucLuong, nv.MaPB, pb.TenPB FROM nhanvien nv LEFT JOIN phongban pb";
    List<NhanVien> list = new ArrayList<>();

    try (Connection conn = MysqlConnection.createConnection();
        Statement stm = conn.createStatement(); ) {
      ResultSet rs = stm.executeQuery(query);

      while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
        long maNV = rs.getLong(1);
        String tenNV = rs.getString(2);
        int mucLuong = rs.getInt("MucLuong");
        String maPB = rs.getString("MaPB");
        String TenPB = rs.getString("TenPB");

        PhongBan pb = new PhongBan(Long.parseLong(maPB), TenPB);

        list.add(new NhanVien(maNV, tenNV, mucLuong, pb));
      }
      return list;
    } catch (SQLException e) {
      System.out.println(e);
      return list;
    }
  }

  public NhanVien update(NhanVien nv) {

    String sql = "update nhanvien set tennv = ?, mucluong = ?, mapb = ? where manv = ?";
    try (Connection connect = MysqlConnection.createConnection();
        PreparedStatement ps = connect.prepareStatement(sql); ) {
      ps.setString(1, nv.getTenNV());
      ps.setInt(2, nv.getMucLuong());
      ps.setLong(3, nv.getPhongBan().getMaPB());
      ps.setLong(4, nv.getMaNV());
      ps.executeUpdate();
      return nv;
    } catch (SQLException ex) {
      System.out.println(ex);
      return null;
    }
  }

  public NhanVien add(NhanVien nv) {
    String sql = "insert into phongban(TenNV, MucLuong, MaPB) values (?, ?, ?)";
    try (Connection connect = MysqlConnection.createConnection();
        PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ) {
      ps.setString(1, nv.getTenNV());
      ps.setInt(2, nv.getMucLuong());
      ps.setLong(3, nv.getPhongBan().getMaPB());
      ps.executeUpdate();
      ResultSet keys = ps.getGeneratedKeys();
      keys.next();
      long id = keys.getLong(1);
      nv.setMaNV(id);
      return nv;
    } catch (SQLException ex) {
      System.out.println(ex);
      return null;
    }
  }

  public int delete(String id) {
    String sql = "delete from phongban where mapb = ?";
    try (Connection connect = MysqlConnection.createConnection();
        PreparedStatement ps = connect.prepareStatement(sql); ) {

      ps.setString(1, id);
      ps.executeUpdate();
      return 1;
    } catch (SQLException ex) {
      System.out.println(ex);
      return 0;
    }
  }
}

