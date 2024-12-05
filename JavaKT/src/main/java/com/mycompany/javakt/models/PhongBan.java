
package com.mycompany.javakt.models;

public class PhongBan {

    private long maPB;
    private String tenPB;

    public PhongBan(long maPB, String tenPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
    }

    public PhongBan(String tenPB) {
      this.tenPB = tenPB;
    }

    public long getMaPB() {
        return maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setMaPB(long maPB) {
        this.maPB = maPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }
    
    
    
}
