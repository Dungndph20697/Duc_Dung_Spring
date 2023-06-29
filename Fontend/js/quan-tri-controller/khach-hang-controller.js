window.khachHangController = function ($scope, $http) {
  $scope.lstKH = [];
  var idUpdate = null;
  $http
    .get("http://localhost:8080/khach-hang/find-all")
    .then(function (response) {
      $scope.lstKH = response.data;
      console.log(response.data);
    });

  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maKH,
      ten: $scope.ten,
      tenDem: $scope.tenDem,
      ho: $scope.ho,
      ngaySinh: $scope.ngaySinh,
      sdt: $scope.sdt,
      diaChi: $scope.diaChi,
      thanhPho: $scope.thanhPho,
      quocGia: $scope.quocGia,
      matKhau: $scope.matKhau,
    };
    $http
      .post("http://localhost:8080/khach-hang/add", JSON.stringify($scope.form))
      .then(function (response) {
        alert("Thêm thành công");
      });
  };

  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/khach-hang/find-by-id/" + id)
      .then(function (response) {
        $scope.maKH = response.data.ma;
        $scope.ho = response.data.ho;
        $scope.tenDem = response.data.tenDem;
        $scope.ten = response.data.ten;
        $scope.ngaySinh = response.data.ngaySinh;
        $scope.sdt = response.data.sdt;
        $scope.diaChi = response.data.diaChi;
        $scope.quocGia = response.data.quocGia;
        $scope.thanhPho = response.data.thanhPho;
        $scope.matKhau = response.data.matKhau;
        idUpdate = response.data.id;
      });
  };

  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/khach-hang/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };

  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maKH,
      ten: $scope.ten,
      tenDem: $scope.tenDem,
      ho: $scope.ho,
      ngaySinh: $scope.ngaySinh,
      sdt: $scope.sdt,
      diaChi: $scope.diaChi,
      thanhPho: $scope.thanhPho,
      quocGia: $scope.quocGia,
      matKhau: $scope.matKhau,
    };
    $http
      .put(
        "http://localhost:8080/khach-hang/update",
        JSON.stringify($scope.form)
      )
      .then(function (response) {
        console.log(response);
        alert("Sửa thành công");
      });
  };
};
