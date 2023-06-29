window.detailController = function ($scope, $http, $routeParams) {
  var idCTSP = $routeParams.id;
  var donGiaAdd = null;
  $http
    .get("http://localhost:8080/chi-tiet-sp/find-by-id/" + idCTSP)
    .then(function (response) {
      if (response.status === 200) {
        $scope.productDetail = response.data;
        donGiaAdd = $scope.productDetail.giaBan;
      }
    });
  $scope.addGioHang = function () {
    $scope.form = {
      chiTietSP: { id: idCTSP },
      soLuong: 1,
      donGia: donGiaAdd,
    };
    $http
      .post(
        "http://localhost:8080/gio-hang-chi-tiet/add",
        JSON.stringify($scope.form)
      )
      .then(function (response) {
        alert("Thêm thành công");
      });
  };
};
