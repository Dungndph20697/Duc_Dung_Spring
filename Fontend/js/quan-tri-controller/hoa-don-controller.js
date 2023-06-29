window.hoaDonController = function ($http, $scope) {
  $scope.lstHD = [];
  $scope.lstKH = [];
  $scope.lstNV = [];
  var idUpdate = null;
  var khachHangUpdate = null;
  var nhanVienUpdate = null;
  $http.get("http://localhost:8080/hoa-don/find-all").then(function (response) {
    $scope.lstHD = response.data;
    console.log(response.data);
  });
  $http
    .get("http://localhost:8080/khach-hang/find-all")
    .then(function (response) {
      $scope.lstKH = response.data;
    });
  $http
    .get("http://localhost:8080/nhan-vien/find-all")
    .then(function (response) {
      $scope.lstNV = response.data;
    });
  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/hoa-don/find-by-id/" + id)
      .then(function (response) {
        $scope.maHD = response.data.ma;
        $scope.khachHang = response.data.khachHang.id;
        $scope.nhanVien = response.data.nhanVien.id;
        $scope.ngayThanhToan = response.data.ngayThanhToan;
        $scope.ngayShip = response.data.ngayShip;
        $scope.ngayNhan = response.data.ngayNhan;
        $scope.tenNguoiNhan = response.data.tenNguoiNhan;
        $scope.sdt = response.data.sdt;
        $scope.diaChi = response.data.diaChi;
        $scope.tinhTrang = response.data.tinhTrang.toString();
        idUpdate = response.data.id;
        khachHangUpdate = response.data.khachHang;
        nhanVienUpdate = response.data.nhanVien;
      });
  };
  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maHD,
      khachHang: { id: $scope.khachHang },
      nhanVien: { id: $scope.nhanVien },
      ngayNhan: $scope.ngayNhan,
      ngayThanhToan: $scope.ngayThanhToan,
      ngayShip: $scope.ngayShip,
      tenNguoiNhan: $scope.tenNguoiNhan,
      sdt: $scope.sdt,
      diaChi: $scope.diaChi,
      tinhTrang: $scope.tinhTrang,
    };
    $http
      .post("http://localhost:8080/hoa-don/add", $scope.form)
      .then(function (response) {
        alert("Thêm thành công");
      });
  };
  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maHD,
      khachHang: { id: $scope.khachHang },
      nhanVien: { id: $scope.nhanVien },
      ngayNhan: $scope.ngayNhan,
      ngayThanhToan: $scope.ngayThanhToan,
      ngayShip: $scope.ngayShip,
      tenNguoiNhan: $scope.tenNguoiNhan,
      sdt: $scope.sdt,
      diaChi: $scope.diaChi,
      tinhTrang: $scope.tinhTrang,
    };
    $http
      .put("http://localhost:8080/hoa-don/update", $scope.form)
      .then(function (response) {
        alert("Sửa thành công");
      });
  };
  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/hoa-don/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };
};
