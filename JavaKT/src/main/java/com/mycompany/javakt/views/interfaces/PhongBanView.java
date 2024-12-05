package com.mycompany.javakt.views.interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import com.mycompany.javakt.models.PhongBan;

public interface PhongBanView {
  void open();
  void setOnAdd(ActionListener onAdd);
  void setOnEdit(ActionListener onAdd);
  void setOnDelete(ActionListener onAdd);
  void NapdulieuchoTable(List<PhongBan> list);
  void XoaBang();
  void addRow(PhongBan pb);
  String getTenPhongBan();
  String getIdSelected();
  void initEvents();
}
