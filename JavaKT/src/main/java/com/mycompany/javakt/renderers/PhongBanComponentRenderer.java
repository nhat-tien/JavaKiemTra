package com.mycompany.javakt.renderers;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.mycompany.javakt.models.PhongBan;

public class PhongBanComponentRenderer extends BasicComboBoxRenderer {

  public Component getListCellRendererComponent(
      JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    if (value instanceof PhongBan) {
      PhongBan pb = (PhongBan) value;
      setText(pb.getTenPB());
    }

    return this;
  }
}
