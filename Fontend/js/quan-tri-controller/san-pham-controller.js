window.sanPhamController = function ($scope, $http) {
  $scope.lstSP = [];
  var idUpdate = null;
  $http
    .get("http://localhost:8080/san-pham/find-all")
    .then(function (response) {
      $scope.lstSP = response.data;
      console.log(response);
    });
  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maSP,
      ten: $scope.tenSP,
    };
    $http
      .post("http://localhost:8080/san-pham/add", JSON.stringify($scope.form))
      .then(function (response) {
        console.log(response);
        alert("Thêm thành công");
      });
  };
  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/san-pham/find-by-id/" + id)
      .then(function (response) {
        $scope.maSP = response.data.ma;
        $scope.tenSP = response.data.ten;
        idUpdate = response.data.id;
      });
  };
  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/san-pham/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };
  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maSP,
      ten: $scope.tenSP,
    };
    $http
      .put("http://localhost:8080/san-pham/update", JSON.stringify($scope.form))
      .then(function (response) {
        console.log(response);
        alert("Sửa thành công");
      });
  };
};
