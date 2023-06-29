window.nhanVienController = function ($scope, $http) {
  $scope.lstNV = [];
  $scope.lstCV = [];
  $scope.lstCH = [];
  var idUpdate = null;
  $http
    .get("http://localhost:8080/nhan-vien/find-all")
    .then(function (response) {
      $scope.lstNV = response.data;
    });
  $http.get("http://localhost:8080/chuc-vu/find-all").then(function (response) {
    $scope.lstCV = response.data;
  });
  $http
    .get("http://localhost:8080/cua-hang/find-all")
    .then(function (response) {
      $scope.lstCH = response.data;
    });
  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/nhan-vien/find-by-id/" + id)
      .then(function (response) {
        $scope.sdt = response.data.sdt;
        $scope.maNV = response.data.ma;
        $scope.ten = response.data.ten;
        $scope.chucVu = response.data.chucVu.id;
        $scope.cuaHang = response.data.cuaHang.id;
        $scope.ngaySinh = response.data.ngaySinh;
        $scope.gioiTinh = response.data.gioiTinh;
        $scope.tinhTrang = response.data.trangThai.toString();
        $scope.ho = response.data.ho;
        $scope.tenDem = response.data.tenDem;
        $scope.diaChi = response.data.diaChi;
        $scope.matKhau = response.data.matKhau;
        idUpdate = response.data.id;
      });
  };
  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maNV,
      ten: $scope.ten,
      ho: $scope.ho,
      tenDem: $scope.tenDem,
      chucVu: { id: $scope.chucVu },
      cuaHang: { id: $scope.cuaHang },
      ngaySinh: $scope.ngaySinh,
      gioiTinh: $scope.gioiTinh,
      trangThai: $scope.tinhTrang,
      diaChi: $scope.diaChi,
      matKhau: $scope.matKhau,
      sdt: $scope.sdt,
    };
    $http
      .post("http://localhost:8080/nhan-vien/add", JSON.stringify($scope.form))
      .then(function (response) {
        console.log(response);
        alert("Thêm thành công");
      });
  };
  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/nhan-vien/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };
  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maNV,
      ten: $scope.ten,
      ho: $scope.ho,
      tenDem: $scope.tenDem,
      chucVu: { id: $scope.chucVu },
      cuaHang: { id: $scope.cuaHang },
      ngaySinh: $scope.ngaySinh,
      gioiTinh: $scope.gioiTinh,
      trangThai: $scope.tinhTrang,
      diaChi: $scope.diaChi,
      matKhau: $scope.matKhau,
      sdt: $scope.sdt,
    };
    $http
      .put(
        "http://localhost:8080/nhan-vien/update",
        JSON.stringify($scope.form)
      )
      .then(function (response) {
        alert("Sửa thành công");
      });
  };
};
