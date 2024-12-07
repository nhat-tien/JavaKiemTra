package com.mycompany.javakt.repositories;

import com.mycompany.javakt.models.PhongBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PhongBanRepository {

  public PhongBanRepository() {}

  public List<PhongBan> getAll() {
    String query = "SELECT * FROM phongban";
    List<PhongBan> list = new ArrayList<>();

    try (Connection conn = MysqlConnection.createConnection();
        Statement stm = conn.createStatement(); ) {
      ResultSet rs = stm.executeQuery(query);

      while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
        long MaPB = rs.getLong("MaPB");
        String TenPB = rs.getString("TenPB");
        list.add(new PhongBan(MaPB, TenPB));
      }
      return list;
    } catch (SQLException e) {
      System.out.println("From PhongBanRepo - getAll() " + e.getMessage());
      return list;
    }
  }

  public PhongBan update(PhongBan pb) {

    String sql = "update phongban set tenpb = ? where mapb = ?";
    try (Connection connect = MysqlConnection.createConnection();
        PreparedStatement ps = connect.prepareStatement(sql); ) {
      ps.setString(1, pb.getTenPB());
      ps.setString(2, String.valueOf(pb.getMaPB()));
      ps.executeUpdate();
      return pb;
      // JOptionPane.showMessageDialog("Thông báo","Sua phòng ban thành công
      // !",JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
      System.out.println("From PhongBanRepo - update() " + ex.getMessage());
      return null;
    }
  }

  public PhongBan add(PhongBan pb) {
    String sql = "insert into phongban(TenPB) values (?)";
    try (Connection connect = MysqlConnection.createConnection();
        PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ) {
      ps.setString(1, pb.getTenPB());
      ps.executeUpdate();
      ResultSet keys = ps.getGeneratedKeys();
      keys.next();
      long id = keys.getLong(1);
      pb.setMaPB(id);
      return pb;
    } catch (SQLException ex) {
      // Duplicate key exception
      if(ex.getErrorCode() == 1062) {
        JOptionPane.showMessageDialog(null,"Dữ liệu bị trùng lặp","Warning",JOptionPane.WARNING_MESSAGE);
      }
      System.out.println("From PhongBanRepo - add() " + ex.getMessage());
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
      System.out.println("From PhongBanRepo - delete() " + ex.getMessage());
      return 0;
    }
  }
}

