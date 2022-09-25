use Db_PhuKienThoiTrang
go

-- thêm quền
insert into Quyen values(N'Quản Lý')
insert into Quyen values(N'Nhân Viên')

--- thêm tài khoản 
insert into NhanVien values(N'Quản Lý 1', N'Hà Nội','1122334455','0123654789','quanly01@gmail.com','quanly01',1)
insert into NhanVien values(N'Nhân Viên 1', N'Hà Nội','6677889911','0147852369','nhavien01@gmail.com','nhanvien01',2)
insert into NguoiDung values(N'Khách hàng 1', N'Hà Nội','0369874125','khachhang01@gmail.com','khachhang01')

----thêm danh mục
insert into DanhMuc values(N'Nước Hoa')
insert into DanhMuc values(N'Đồng Hồ')
insert into DanhMuc values(N'Trang Sức')

----thêm nhà sản xuất
insert into NhanHang values(N'Casio')
insert into NhanHang values(N'Gucci')
insert into NhanHang values(N'Chanel')

---thêm sản phẩm
insert into SanPham values(N'Đồng hồ Gucci YA126447',1500000,'1.jpg',20,'Đồng hồ dành cho nam sang trọng lịch lãm','2021-10-05',2,2)

---thêm banner
insert into Banner values(N'banner1.jpg',1)

select * from Quyen

select * from NhanVien

select * from NguoiDung

select * from DanhMuc

select * from NhanHang

select * from SanPham

select * from Banner