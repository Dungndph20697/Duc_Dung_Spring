window.chuVuController = function ($scope, $http) {
  $scope.lstCV = [];
  var idUpdate = null;
  $http
    .get("http://localhost:8080/chuc-vu/find-all")
    .then(function (response) {
      $scope.lstCV = response.data;
      console.log(response);
    });

  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maCV,
      ten: $scope.tenCV,
    };
    $http
      .post("http://localhost:8080/chuc-vu/add", JSON.stringify($scope.form))
      .then(function (response) {
        console.log(response);
        alert("Thêm thành công");
      });
  };

  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/chuc-vu/find-by-id/" + id)
      .then(function (response) {
        $scope.maCV = response.data.ma;
        $scope.tenCV = response.data.ten;
        idUpdate = response.data.id;
      });
  };

  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/chuc-vu/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };

  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maCV,
      ten: $scope.tenCV,
    };
    $http
      .put("http://localhost:8080/chuc-vu/update", JSON.stringify($scope.form))
      .then(function (response) {
        console.log(response);
        alert("Sửa thành công");
      });
  };
};
