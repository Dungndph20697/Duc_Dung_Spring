window.chiTietSPController = function ($scope, $http) {
  $scope.lstMS = [];
  $scope.lstSP = [];
  $scope.lstDongSP = [];
  $scope.lstNSX = [];
  $scope.lstCTSP = [];
  var imgAdd = null;
  var idUpdate = null;
  $http
    .get("http://localhost:8080/chi-tiet-sp/find-all")
    .then(function (response) {
      $scope.lstCTSP = response.data;
      console.log(response);
    });

  $http.get("http://localhost:8080/dong-sp/find-all").then(function (response) {
    $scope.lstDongSP = response.data;
  });

  $http.get("http://localhost:8080/mau-sac/find-all").then(function (response) {
    $scope.lstMS = response.data;
  });

  $http
    .get("http://localhost:8080/san-pham/find-all")
    .then(function (response) {
      $scope.lstSP = response.data;
    });

  $http.get("http://localhost:8080/nsx/find-all").then(function (response) {
    $scope.lstNSX = response.data;
  });

  $scope.uploadAnh = function () {
    imgAdd = "../../images/" + $scope.fileArray[0].name;
    $scope.img = imgAdd;
  };

  $scope.addNew = function () {
    $scope.form = {
      sanPham: { id: $scope.sanPham },
      nsx: { id: $scope.namSX },
      dongSP: { id: $scope.dongSP },
      mauSac: { id: $scope.mauSac },
      namBH: $scope.namBH,
      soLuongTon: $scope.soLuongTon,
      giaNhap: $scope.giaNhap,
      giaBan: $scope.giaBan,
      anh: imgAdd,
    };
    $http
      .post(
        "http://localhost:8080/chi-tiet-sp/add",
        JSON.stringify($scope.form)
      )
      .then(function (response) {
        alert("Thêm thành công");
        window.location.reload();
      });
  };

  $scope.detail = function (id) {
    $http
      .get("http://localhost:8080/chi-tiet-sp/find-by-id/" + id)
      .then(function (response) {
        $scope.namSX = response.data.nsx.id;
        $scope.mauSac = response.data.mauSac.id;
        $scope.dongSP = response.data.dongSP.id;
        $scope.sanPham = response.data.sanPham.id;
        $scope.namBH = response.data.namBH;
        $scope.soLuongTon = response.data.soLuongTon;
        $scope.giaNhap = response.data.giaNhap;
        $scope.giaBan = response.data.giaBan;
        $scope.img = response.data.anh;
        imgAdd = response.data.anh;
        idUpdate = response.data.id;
        console.log(response.data);
      });
  };

  $scope.update = function () {
    $scope.form = {
      id: idUpdate,
      sanPham: { id: $scope.sanPham },
      nsx: { id: $scope.namSX },
      dongSP: { id: $scope.dongSP },
      mauSac: { id: $scope.mauSac },
      namBH: $scope.namBH,
      soLuongTon: $scope.soLuongTon,
      giaNhap: $scope.giaNhap,
      giaBan: $scope.giaBan,
      anh: imgAdd,
    };
    console.log($scope.form.nsx);
    $http
      .put(
        "http://localhost:8080/chi-tiet-sp/update",
        JSON.stringify($scope.form)
      )
      .then(function (response) {
        alert("Sửa thành công");
        window.location.reload();
      });
  };

  $scope.remove = function (id) {
    $http
      .delete("http://localhost:8080/chi-tiet-sp/remove/" + id)
      .then(function (response) {
        alert("Xoá thành công");
        window.location.reload();
      });
  };

  // $scope.phanTrang = function (soTrang) {
  //   $http
  //     .get("http://localhost:8080/chi-tiet-sp/find-all/" + soTrang.toString())
  //     .then(function (response) {
  //       $scope.lstCTSP = response.data.content;
  //     });
  // };
};
