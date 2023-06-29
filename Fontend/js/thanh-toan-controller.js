window.thanhToanController = function ($scope, $http, $location) {
  $scope.lstGhct = [];
  $scope.tongTien = 0;
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/find-all")
    .then(function (response) {
      $scope.lstGhct = response.data;
      console.log($scope.lstGhct);
    });
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/tong-tien")
    .then(function (response) {
      $scope.tongTien = response.data;
    });

  $scope.thanhToan = function () {
    if ($scope.tenNguoiNhan == null) {
      alert("Tên người nhận không được trống");
    } else if ($scope.sdt == null) {
      alert("Sdt không được trống");
    } else if ($scope.diaChi == null) {
      alert("Địa chỉ không được trống");
    } else {
      $scope.form = {
        tenNguoiNhan: $scope.tenNguoiNhan,
        sdt: $scope.sdt,
        diaChi: $scope.diaChi,
      };
      $http
        .put(
          "http://localhost:8080/gio-hang/update",
          JSON.stringify($scope.form)
        )
        .then(function (response) {
          console.log($scope.form.tenNguoiNhan);
          console.log($scope.form.sdt);
          console.log($scope.form.diaChi);
          alert("Thanh toán thành công");
          window.open("http://127.0.0.1:5502/html/index.html?#/home", "_self");
        });
    }
  };
};
