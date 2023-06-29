window.quanTriGioHangController = function ($http, $scope) {
  $scope.lstGH = [];
  $scope.lstGHCT = [];
  $http
    .get("http://localhost:8080/gio-hang/find-by-tinh-trang-1")
    .then(function (response) {
      $scope.lstGH = response.data;
      // console.log($scope.lstGH);
    });
  // $http
  //   .get("http://localhost:8080/gio-hang-chi-tiet/cho-xac-nhan")
  //   .then(function (response) {
  //     for (var i = 0; i < $scope.lstGH.length; i++) {
  //       if (response.data[i].gioHang.id == $scope.lstGH[i].id) {
  //         $scope.lstGHCT.push(response.data[i]);
  //       }
  //     }
  //     console.log($scope.lstGHCT);
  //   });
  $http
    .get("http://localhost:8080/gio-hang-chi-tiet/cho-xac-nhan")
    .then(function (response) {
      $scope.lstGHCT = response.data;
      console.log($scope.lstGHCT);
    });

  $scope.xacNhan = function (gioHang) {
    console.log(gioHang);
    $http
      .put("http://localhost:8080/gio-hang/xac-nhan", JSON.stringify(gioHang))
      .then(function (response) {
        alert("Xác nhận thành công");
        window.location.reload();
      });
  };
};
