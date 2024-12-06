package com.mycompany.javakt.presenters;

import com.mycompany.javakt.models.NhanVien;
import com.mycompany.javakt.models.PhongBan;
import com.mycompany.javakt.repositories.NhanVienRepository;
import com.mycompany.javakt.repositories.PhongBanRepository;
import com.mycompany.javakt.views.NHANVIEN;
import com.mycompany.javakt.views.interfaces.NhanVienView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class NhanVienPresenter {

  private NhanVienView view;
  private NhanVienRepository repository;
  private PhongBanRepository phongBanRepository;

  public NhanVienPresenter() {
    this.view = new NHANVIEN();
    this.repository = new NhanVienRepository();
    this.phongBanRepository = new PhongBanRepository();
    this.view.setOnAdd((ActionEvent e) -> handleAdd(e));
    this.view.setOnEdit((ActionEvent e) -> handleEdit(e));
    this.view.setOnDelete((ActionEvent e) -> handleDelete(e));
    this.view.setOnChangePhongBan((ActionEvent e) -> handleChange(e));
    this.view.initEvents();
  }

  public void start() {
    this.view.open();
    this.view.NapdulieuchoTable(repository.getAll());
    this.view.initDataCompobox(phongBanRepository.getAll());
  }

  public void handleAdd(ActionEvent event) {
    if (view.getTenNV().trim().equals("")) {
      JOptionPane.showMessageDialog(
          null, "Tên nhân viên không được trống", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    if (view.getMucLuong().trim().equals("")) {
      JOptionPane.showMessageDialog(
          null, "Mức lương không được trống", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    if (!isNumeric(view.getMucLuong().trim())) {
      JOptionPane.showMessageDialog(
          null, "Mức lương không đúng định dạng số", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    NhanVien nv =
        new NhanVien(view.getTenNV().trim(), Integer.parseInt(view.getMucLuong()), view.getMaPB());
    PhongBan pb = view.phongBanSelected();
    NhanVien newNv = repository.add(nv);
    newNv.setPhongBan(pb);
    view.addRow(newNv);
  }

  public void handleEdit(ActionEvent event) {
    if (view.getTenNV().trim().equals("")) {
      JOptionPane.showMessageDialog(
          null, "Tên nhân viên không được trống", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    if (view.getMucLuong().trim().equals("")) {
      JOptionPane.showMessageDialog(
          null, "Mức lương không được trống", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    if (!isNumeric(view.getMucLuong().trim())) {
      JOptionPane.showMessageDialog(
          null, "Mức lương không đúng định dạng số", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    NhanVien nv =
        new NhanVien(
            Long.parseLong(view.getIdSelected()),
            view.getTenNV().trim(),
            Integer.parseInt(view.getMucLuong()),
            view.getMaPB());
    repository.update(nv);
    view.XoaBang();
    view.NapdulieuchoTable(repository.getAll());
  }

  public void handleDelete(ActionEvent event) {
    repository.delete(view.getIdSelected());
    view.XoaBang();
    view.NapdulieuchoTable(repository.getAll());
  }

  public void handleChange(ActionEvent event) {
    PhongBanPresenter presenter = new PhongBanPresenter();
    presenter.start();
    this.view.dispose();
  }

  private boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
