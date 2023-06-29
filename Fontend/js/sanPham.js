window.sanPhamUseController = function ($scope, $http) {
  // $scope.lstProduct = [];
  // $scope.lstProductShow = [];
  // $scope.lstCategorys = [];
  // getCategory = function () {
  //   $http
  //     .get("http://localhost:8080/dong-sp/find-all")
  //     .then(function (response) {
  //       $scope.lstCategorys = response.data;
  //     });
  // };
  // getCategory();
  // $http.get("http://localhost:3000/products").then(function (response) {
  //   $scope.lstProduct = response.data;

  //   if ($scope.lstCategorys.length == 0) {
  //     $http
  //       .get("http://localhost:8080/dong-sp/find-all")
  //       .then(function (response) {
  //         $scope.lstCategorys = response.data;
  //       });
  //   }

  //   console.log($scope.lstCategorys);
  //   for (var i = 0; i < $scope.lstProduct.length; i++) {
  //     if ($scope.lstProduct[i].loai == $scope.lstCategorys[0].name) {
  //       $scope.lstProductShow.push($scope.lstProduct[i]);
  //     }
  //   }
  //   console.log("fasifhw" + $scope.lstProductShow);
  // });

  // $scope.showProductWhitCategory = function (name) {
  //   $scope.lstProductShow = [];
  //   for (var i = 0; i < $scope.lstProduct.length; i++) {
  //     if ($scope.lstProduct[i].loai == name) {
  //       $scope.lstProductShow.push($scope.lstProduct[i]);
  //     }
  //   }
  // };
  $scope.lstCTSP = [];
  $scope.lstDongSP = [];
  $http
    .get("http://localhost:8080/chi-tiet-sp/find-all")
    .then(function (response) {
      $scope.lstCTSP = response.data;
    });
  $http
    .get("http://localhost:8080/dong-sp/find-all")
    .then(function (response) {
      $scope.lstDongSP = response.data;
    });
};
