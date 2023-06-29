window.thongTinDonHangController = function ($scope, $http) {
  $scope.lstGH2 = [];
  $scope.lstGH1 = [];
  $scope.lstGHCT2 = [];
  $scope.lstGHCT1 = [];
  $scope.lstSP = [];
  $http
    .get("http://localhost:8080/gio-hang/find-by-tinh-trang-2")
    .then(function (response) {
      $scope.lstGH2 = response.data;
    });
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/san-pham-da-mua")
    .then(function (response) {
      $scope.lstSP = response.data;
      console.log($scope.lstSP);
    });
  $http
    .get("http://localhost:8080/gio-hang/find-by-tinh-trang-1")
    .then(function (response) {
      $scope.lstGH1 = response.data;
    });
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/dang-giao")
    .then(function (response) {
      $scope.lstGHCT2 = response.data;
    });
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/cho-xac-nhan")
    .then(function (response) {
      $scope.lstGHCT1 = response.data;
    });
  $scope.daNhanDuocHang = function (gh) {
    $http
      .put(
        "http://localhost:8080/gio-hang/da-nhan-duoc-hang",
        JSON.stringify(gh)
      )
      .then(function (response) {
        alert("Bạn đã nhận hàng");
        window.location.reload();
      });
  };
};
