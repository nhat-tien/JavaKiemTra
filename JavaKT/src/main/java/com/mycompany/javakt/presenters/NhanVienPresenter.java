package com.mycompany.javakt.presenters;

import com.mycompany.javakt.repositories.NhanVienRepository;
import com.mycompany.javakt.repositories.PhongBanRepository;
import com.mycompany.javakt.views.NHANVIEN;
import com.mycompany.javakt.views.interfaces.NhanVienView;

public class NhanVienPresenter {

  private NhanVienView view;
  private NhanVienRepository repository;
  private PhongBanRepository phongBanRepository;

  public NhanVienPresenter() {
    this.view = new NHANVIEN();
    this.repository = new NhanVienRepository();
    this.phongBanRepository = new PhongBanRepository();
    this.view.initEvents();
  }

  public void start() {
    this.view.open();
    this.view.NapdulieuchoTable(repository.getAll());
    this.view.initDataCompobox(phongBanRepository.getAll());
  }
  
}
