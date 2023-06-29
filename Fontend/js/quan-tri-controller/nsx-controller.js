window.nsxController = function ($http, $scope) {
  $scope.lstNSX = [];
  var idUpdate = null;
  $http.get("http://localhost:8080/nsx/find-all").then(function (response) {
    $scope.lstNSX = response.data;
  });
  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/nsx/find-by-id/" + id)
      .then(function (response) {
        $scope.maNSX = response.data.ma;
        $scope.tenNSX = response.data.ten;
        idUpdate = response.data.id;
      });
  };
  $scope.addNew = function () {
    $scope.form = {
      ma: $scope.maNSX,
      ten: $scope.tenNSX,
    };
    $http
      .post("http://localhost:8080/nsx/add", JSON.stringify($scope.form))
      .then(function (response) {
        alert("Thêm thành công");
        window.open("/quanTriSP/nsx");
      });
  };
  $scope.update = function () {
    $scope.form = {
      ma: $scope.maNSX,
      ten: $scope.tenNSX,
      id: idUpdate,
    };
    $http
      .put("http://localhost:8080/nsx/update", JSON.stringify($scope.form))
      .then(function (response) {
        alert("Sửa thành công");
        window.open("/quanTriSP/nsx");
      });
  };
  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/nsx/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
        window.open("/quanTriSP/nsx");
      });
  };
};
