window.hoaDonChiTietController = function ($http, $scope) {
  $scope.lstHDCT = [];
  $scope.lstHD = [];
  $scope.lstCTSP = [];
  var idUpdate = null;
  $http
    .get("http://localhost:8080/hoa-don-chi-tiet/find-all")
    .then(function (response) {
      $scope.lstHDCT = response.data;
      console.log(response.data);
    });
  $http.get("http://localhost:8080/hoa-don/find-all").then(function (response) {
    $scope.lstHD = response.data;
  });
  $http
    .get("http://localhost:8080/chi-tiet-sp/find-all")
    .then(function (response) {
      $scope.lstCTSP = response.data;
    });
  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/hoa-don-chi-tiet/find-by-id/" + id)
      .then(function (response) {
        $scope.sanPham = response.data.chiTietSP.id;
        $scope.hoaDon = response.data.hoaDon.id;
        $scope.soLuong = response.data.soLuong;
        $scope.donGia = response.data.donGia;
        idUpdate = response.data.id;
      });
  };
  $scope.addNew = function () {
    $scope.form = {
      chiTietSP: { id: $scope.sanPham },
      hoaDon: { id: $scope.hoaDon },
      soLuong: $scope.soLuong,
      donGia: $scope.donGia,
    };
    console.log($scope.form);
    $http
      .post(
        "http://localhost:8080/hoa-don-chi-tiet/add",
        JSON.stringify($scope.form)
      )
      .then(function (response) {
        alert("Thêm thành công");
      });
  };
  $scope.update = function () {
    $scope.form = {
      chiTietSP: { id: $scope.sanPham },
      hoaDon: { id: $scope.hoaDon },
      soLuong: $scope.soLuong,
      donGia: $scope.donGia,
      id: idUpdate,
    };
    $http
      .put(
        "http://localhost:8080/hoa-don-chi-tiet/update",
        JSON.stringify($scope.form)
      )
      .then(function (response) {
        alert("Sửa thành công");
      });
  };
  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/hoa-don-chi-tiet/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };
};
