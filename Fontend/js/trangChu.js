window.kmHotController = function ($scope, $http) {
  $scope.lstProduct = [];
  $scope.lstProductKMH = [];
  $scope.lstProductSPM = [];
  $scope.lstProductSPBanChay = [];
  $http.get("http://localhost:8080/chi-tiet-sp/find-all").then(
    function (response) {
      console.log(response.data);
      $scope.lstProduct = response.data;
      for (var i = 0; i < 4; i++) {
        $scope.lstProductKMH.push(response.data[i]);
      }
      for (var i = 4; i < 8; i++) {
        $scope.lstProductSPM.push(response.data[i]);
      }
      for (var i = 8; i < $scope.lstProduct.length; i++) {
        $scope.lstProductSPBanChay.push(response.data[i]);
      }
    },
    function (error) {
      console.log(error);
    }
  );
};
