CREATE TABLE phongban (
   MaPB int  NOT NULL AUTO_INCREMENT,
   TenPB nvarchar(255),
  PRIMARY KEY(MaPB)
);

CREATE TABLE nhanvien (
   MaNV int NOT NULL AUTO_INCREMENT,
   TenNV nvarchar(255),
   MucLuong int,
   MaPB int,
  PRIMARY KEY(MaNV),
  FOREIGN KEY (MaPB) REFERENCES phongban(MaPB)
);


