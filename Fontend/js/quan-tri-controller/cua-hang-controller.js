window.cuaHangController = function ($scope, $http) {
  $scope.lstCH = [];
  var idUpdate = null;
  $http
    .get("http://localhost:8080/cua-hang/find-all")
    .then(function (response) {
      $scope.lstCH = response.data;
      console.log(response);
    });

  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maCH,
      ten: $scope.tenCH,
      diaChi: $scope.diaChi,
      thanhPho: $scope.thanhPho,
      quocGia: $scope.quocGia,
    };
    $http
      .post("http://localhost:8080/cua-hang/add", JSON.stringify($scope.form))
      .then(function (response) {
        console.log(response);
        alert("Thêm thành công");
        window.location.reload();
      });
  };

  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/cua-hang/find-by-id/" + id)
      .then(function (response) {
        $scope.maCH = response.data.ma;
        $scope.tenCH = response.data.ten;
        $scope.diaChi = response.data.diaChi;
        $scope.thanhPho = response.data.thanhPho;
        $scope.quocGia = response.data.quocGia;
        idUpdate = response.data.id;
      });
  };

  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/cua-hang/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
        window.location.reload();
      });
  };

  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maCH,
      ten: $scope.tenCH,
      diaChi: $scope.diaChiCH,
      thanhPho: $scope.thanhPho,
      quocGia: $scope.quocGia,
    };
    $http
      .put("http://localhost:8080/cua-hang/update", JSON.stringify($scope.form))
      .then(function (response) {
        console.log(response);
        alert("Sửa thành công");
        window.location.reload();
      });
  };
};
