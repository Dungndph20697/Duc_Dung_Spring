window.gioHangController = function ($scope, $http) {
  $scope.lstGHCT = [];
  $scope.lstMauSac = [];
  $scope.tongTien = 0;
  $http.get("http://localhost:8080/mau-sac/find-all").then(function (response) {
    $scope.lstMauSac = response.data;
  });
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/find-all")
    .then(function (response) {
      $scope.lstGHCT = response.data;
      console.log($scope.lstGHCT);
    });
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/tong-tien")
    .then(function (response) {
      $scope.tongTien = response.data;
    });
  $scope.remove = function (id) {
    var comfrim = confirm("Bạn chắc chắn muốn xoá chứ?");
    if (comfrim == true) {
      $http
        .delete("http://localhost:8080/gio-hang-chi-tiet/remove/" + id)
        .then(function (response) {
          alert("Xoá thành công");
          window.location.reload();
        });
    }
  };
  $scope.them1SoLuong = function (soLuongThuc) {
    var soLuong = soLuongThuc;
    console.log(soLuong);
    soLuong++;
    $scope.soLuong = soLuong;
  };
  $scope.layIdMS = function (idMS) {
    alert("dasdsa");
    console.log(idMS);
  };
};
