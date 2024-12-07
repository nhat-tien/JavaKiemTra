CREATE TABLE phongban (
   MaPB int  NOT NULL AUTO_INCREMENT,
   TenPB varchar(255) UNIQUE,
  PRIMARY KEY(MaPB)
);

CREATE TABLE nhanvien (
   MaNV int NOT NULL AUTO_INCREMENT,
   TenNV varchar(255),
   MucLuong int,
   MaPB int,
  PRIMARY KEY(MaNV),
  FOREIGN KEY (MaPB) REFERENCES phongban(MaPB)
);


