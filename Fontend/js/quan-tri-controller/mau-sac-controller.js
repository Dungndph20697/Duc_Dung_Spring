window.mauSacController = function ($scope, $http) {
  $scope.lstMS = [];
  var idUpdate = null;
  $http.get("http://localhost:8080/mau-sac/find-all").then(function (response) {
    $scope.lstMS = response.data;
  });
  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/mau-sac/find-by-id/" + id)
      .then(function (response) {
        $scope.maMS = response.data.ma;
        $scope.tenMS = response.data.ten;
        idUpdate = response.data.id;
      });
  };
  $scope.addMauSac = function () {
    $scope.form = {
      ma: $scope.maMS,
      ten: $scope.tenMS,
    };
    $http
      .post("http://localhost:8080/mau-sac/add", JSON.stringify($scope.form))
      .then(function (response) {
        alert("Thêm thành công");
      });
  };
  $scope.removeMauSac = function (id) {
    $http
      .delete("http://localhost:8080/mau-sac/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
      });
  };
  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      ma: $scope.maMS,
      ten: $scope.tenMS,
    };
    $http
      .put("http://localhost:8080/mau-sac/update", JSON.stringify($scope.form))
      .then(false, function (response) {
        alert("Sửa thành công");
      });
  };
};
