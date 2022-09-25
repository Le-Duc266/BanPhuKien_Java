CREATE DATABASE Db_PhuKienThoiTrang
go
use Db_PhuKienThoiTrang
go

create table Quyen
(
	MaQuyen int identity primary key,
	TenQuyen nvarchar(250),
)
go

create table NhanVien
(
	MaTaiKhoanNV int identity primary key,
	TenTaiKhoan nvarchar(250),
	DiaChi nvarchar(250),
	Cmnd nvarchar(20),
	SoDienThoai nvarchar(10),
	Email nvarchar(250),
	Password nvarchar(50),
	MaQuyen int FOREIGN KEY (MaQuyen) REFERENCES Quyen (MaQuyen),
)
go

create table NguoiDung
(
	MaTaiKhoanND int identity primary key,
	TenTaiKhoan nvarchar(250),
	DiaChi nvarchar(250),
	SoDienThoai nvarchar(10),
	Email nvarchar(250),
	Password nvarchar(50),
)
go

create table DanhMuc
(
	MaDanhMuc int identity primary key,
	TenDanhMuc nvarchar(250),
)
go

create table NhanHang
(
	MaNhanHang int identity primary key,
	TenNhanHang nvarchar(250),
)
go

create table SanPham
(
	MaSanPham int identity primary key,
	TenSanPham nvarchar(250),
	Gia float,
	Anh varchar(250),
	SoLuong int,
	MoTa nvarchar(max),
	NgayTao date,
	MaDanhMuc int FOREIGN KEY (MaDanhMuc) REFERENCES DanhMuc (MaDanhMuc),
	MaNhanHang int FOREIGN KEY (MaNhanHang) REFERENCES NhanHang (MaNhanHang),
)
go

create table Banner
(
	MaBanner int identity primary key,
	Anh varchar(250),
	Vitri int,
)
go

create table HoaDon
(
	MaHoaDon int identity primary key,
	MaTaiKhoanND int FOREIGN KEY (MaTaiKhoanND) REFERENCES NguoiDung (MaTaiKhoanND),
	DiaChi nvarchar(250),
	NgayLap varchar(50),
	TinhTrang int,
	TongTien float,
)
go

create table HoaDonChiTiet
(
	MaHoaDonChiTiet int identity primary key,
	MaHoaDon int FOREIGN KEY (MaHoaDon) REFERENCES HoaDon (MaHoaDon),
	MaSanPham int FOREIGN KEY (MaSanPham) REFERENCES SanPham (MaSanPham),
	SoLuong int,
	GiaTien float,
	ThanhTien float,
)
go

select * from HoaDon

select * from HoaDonChiTiet

select hd.MaHoaDon,hdct.MaHoaDonChiTiet,hd.MaTaiKhoanND,hdct.MaSanPham,sp.TenSanPham,hd.DiaChi,hdct.SoLuong,hdct.GiaTien,hdct.ThanhTien,hd.NgayLap,hd.TongTien from HoaDon hd 
inner join HoaDonChiTiet hdct on hd.MaHoaDon = hdct.MaHoaDon
inner join SanPham sp on hdct.MaSanPham = sp.MaSanPham

Select hdct.*,s.tenSanPham FROM HoaDonChiTiet hdct,SanPham s,HoaDon hd where hdct.maHoaDon=18 and hdct.maSanPham=s.maSanPham and hdct.maHoaDon=hd.maHoaDon