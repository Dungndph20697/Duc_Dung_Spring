window.dongSPController = function ($http, $scope) {
  $scope.lstDongSP = [];
  var idUpdate = null;
  $http.get("http://localhost:8080/dong-sp/find-all").then(function (response) {
    $scope.lstDongSP = response.data;
  });
  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/dong-sp/find-by-id/" + id)
      .then(function (response) {
        $scope.tenDongSP = response.data.ten;
        $scope.maDongSP = response.data.ma;
        idUpdate = response.data.id;
      });
  };
  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maDongSP,
      ten: $scope.tenDongSP,
    };
    $http
      .post("http://localhost:8080/dong-sp/add", $scope.form)
      .then(function (response) {
        alert("Thêm thành công");
      });
  };
  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maDongSP,
      ten: $scope.tenDongSP,
    };
    $http
      .put("http://localhost:8080/dong-sp/update", $scope.form)
      .then(function (response) {
        alert("Sửa thành công");
      });
  };
  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/dong-sp/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };
};
