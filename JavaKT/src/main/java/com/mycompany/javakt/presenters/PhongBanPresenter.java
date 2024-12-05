package com.mycompany.javakt.presenters;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.mycompany.javakt.models.PhongBan;
import com.mycompany.javakt.repositories.PhongBanRepository;
import com.mycompany.javakt.views.PHONGBAN;
import com.mycompany.javakt.views.interfaces.PhongBanView;

public class PhongBanPresenter {

  private PhongBanView view;
  private PhongBanRepository repository;

  public PhongBanPresenter() {
    this.view = new PHONGBAN();
    this.repository = new PhongBanRepository();
    this.view.setOnAdd((ActionEvent e) -> handleAdd(e));
    this.view.setOnEdit((ActionEvent e) -> handleEdit(e));
    this.view.setOnDelete((ActionEvent e) -> handleDelete(e));
    this.view.initEvents();
  }
  
  public void start() {
    this.view.open();
    this.view.NapdulieuchoTable(repository.getAll());
  }
  
  public void handleAdd(ActionEvent event) {
    if(view.getTenPhongBan().trim().equals("")) {
      JOptionPane.showMessageDialog(null,"Tên phòng ban không được trống","Warning",JOptionPane.WARNING_MESSAGE);
      return;
    }
    PhongBan pb = new PhongBan(view.getTenPhongBan().trim());
    PhongBan newPb = repository.add(pb);
    view.addRow(newPb);
  }

  public void handleEdit(ActionEvent event) {
    if(view.getTenPhongBan().trim().equals("")) {
      JOptionPane.showMessageDialog(null,"Tên phòng ban không được trống","Warning",JOptionPane.WARNING_MESSAGE);
      return;
    }
    PhongBan pb = new PhongBan(Long.parseLong(view.getIdSelected()), view.getTenPhongBan());
    repository.update(pb);
    view.XoaBang();
    view.NapdulieuchoTable(repository.getAll());
  }

  public void handleDelete(ActionEvent event) {
    repository.delete(view.getIdSelected());
    view.XoaBang();
    view.NapdulieuchoTable(repository.getAll());
  }
}
