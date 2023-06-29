window.quanTriSPController = function ($scope, $http) {
  $scope.lstProduct = [];
  $scope.lstCategorys = [];
  var idDelete = null;
  var imgAdd = null;
  $http.get("http://localhost:3000/products").then(function (response) {
    $scope.lstProduct = response.data;
  });
  $http.get("http://localhost:3000/categorys").then(function (response) {
    $scope.lstCategorys = response.data;
  });
  $scope.details = function (id) {
    $http.get("http://localhost:3000/products/" + id).then(function (response) {
      $scope.name = response.data.ten;
      $scope.giaBan = response.data.giaBan;
      $scope.giaGoc = response.data.giaGoc;
      $scope.loai = response.data.loai;
      $scope.img = response.data.img;
      idDelete = response.data.id;
      console.log(idDelete);
      imgAdd = response.data.img;
      // $scope.fileArray[0].name = response.data.img;
    });
  };
  $scope.chonAnh = function () {
    console.log($scope.layImg);
    // $scope.img = $scope.layImg;
  };
  $scope.addNew = function () {
    if ($scope.name == null) {
      alert("Tên không được trống");
    } else if ($scope.giaBan == null) {
      alert("Giá bán không được trống");
    } else if ($scope.giaGoc == null) {
      alert("Giá gốc không được trống");
    } else if ($scope.loai == null) {
      alert("Loại không được trống");
    } else {
      $http
        .post("http://localhost:3000/products", {
          ten: $scope.name,
          giaBan: $scope.giaBan,
          giaGoc: $scope.giaGoc,
          loai: $scope.loai,
          img: imgAdd,
        })
        .then(function (response) {
          if (response.status === 201) alert("Thêm thành công");
        });
    }
  };
  $scope.update = function () {
    if (idDelete == null) {
      alert("Bạn chưa chọn sản phẩm nào để sửa");
    } else if ($scope.name == null) {
      alert("Tên không được trống");
    } else if ($scope.giaBan == null) {
      alert("Giá bán không được trống");
    } else if ($scope.giaGoc == null) {
      alert("Giá gốc không được trống");
    } else if ($scope.loai == null) {
      alert("Loại không được trống");
    } else {
      $http
        .put("http://localhost:3000/products/" + idDelete, {
          ten: $scope.name,
          giaBan: $scope.giaBan,
          giaGoc: $scope.giaGoc,
          loai: $scope.loai,
          img: imgAdd,
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
        .delete("http://localhost:3000/products/" + idDelete)
        .then(function (response) {
          if (response.status === 200) {
            alert("Xoá thành công");
            idDelete = null;
          }
        });
    }
  };

  $scope.uploadAnh = function () {
    imgAdd = "../images/" + $scope.fileArray[0].name;
    $scope.img = imgAdd;
    console.log($scope.fileArray[0]);
  };
};
