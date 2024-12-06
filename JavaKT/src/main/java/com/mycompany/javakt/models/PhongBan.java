
package com.mycompany.javakt.models;

public class PhongBan {

    private long maPB;
    private String tenPB;

    public PhongBan(long maPB, String tenPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
    }

    // @Override
    // public String toString() {
    //   return "PhongBan []";
    // }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + (int) (maPB ^ (maPB >>> 32));
      result = prime * result + ((tenPB == null) ? 0 : tenPB.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      PhongBan other = (PhongBan) obj;
      if (maPB != other.maPB)
        return false;
      if (tenPB == null) {
        if (other.tenPB != null)
          return false;
      } else if (!tenPB.equals(other.tenPB))
        return false;
      return true;
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
