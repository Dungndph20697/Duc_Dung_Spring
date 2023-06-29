window.categoryController = function ($scope, $http) {
  $scope.lstCategorys = [];
  var idDelete = null;
  $http.get("http://localhost:3000/categorys").then(function (response) {
    $scope.lstCategorys = response.data;
    console.log($scope.lstCategorys);
  });
  $scope.details = function (id) {
    $http
      .get("http://localhost:3000/categorys/" + id)
      .then(function (response) {
        $scope.name = response.data.name;
        idDelete = response.data.id;
      });
  };
  $scope.addNew = function () {
    if ($scope.name == null) {
      alert("Tên không được trống");
    } else {
      $http
        .post("http://localhost:3000/categorys", {
          name: $scope.name,
        })
        .then(function (response) {
          if (response.status === 201) alert("Thêm thành công");
        });
    }
  };
  $scope.update = function () {
    if (idDelete == null) {
      alert("Bạn chưa chọn sản phẩm nào để sửa");
    } else {
      $http
        .put("http://localhost:3000/categorys/" + idDelete, {
          name: $scope.name,
        })
        .then(function (response) {
          if (response.status === 200) alert("Sửa thành công");
        });
    }
  };
  $scope.delete = function () {
    if (idDelete == null) {
      alert("Bạn chưa chọn sản phẩm cần xoá");
    } else {
      $http
        .delete("http://localhost:3000/categorys/" + idDelete)
        .then(function (response) {
          if (response.status === 200) {
            alert("Xoá thành công");
            idDelete = null;
          }
        });
    }
  };
};
