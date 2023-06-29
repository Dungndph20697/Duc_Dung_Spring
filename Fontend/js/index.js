var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/home", {
      templateUrl: "home.html",
      controller: kmHotController,
    })
    .when("/sanPham", {
      templateUrl: "sanPham.html",
      controller: sanPhamUseController,
    })
    .when("/gioiThieu", {
      templateUrl: "gioiThieu.html",
    })
    .when("/gioHang", {
      templateUrl: "gioHang.html",
      controller: gioHangController,
    })
    .when("/thong-tin-don-hang", {
      templateUrl: "thong-tin-don-hang.html",
      controller: thongTinDonHangController,
    })
    .when("/thanh-toan", {
      templateUrl: "thanhToan.html",
      controller: thanhToanController,
    })
    .when("/dangnhap", {
      templateUrl: "dangnhap.html",
    })
    .when("/dangky", {
      templateUrl: "dangky.html",
    })
    .when("/doimatkhau", {
      templateUrl: "doimatkhau.html",
    })
    .when("/detail/:id", {
      templateUrl: "detail.html",
      controller: detailController,
    })
    .when("/quanTriSP", {
      templateUrl: "../html/quan-tri-sp/view-san-pham.html",
      controller: sanPhamController,
    })
    .when("/quanTriSP/san-pham", {
      templateUrl: "../html/quan-tri-sp/view-san-pham.html",
      controller: sanPhamController,
    })
    .when("/quanTriSP/dong-sp", {
      templateUrl: "../html/quan-tri-sp/view-dong-sp.html",
      controller: dongSPController,
    })
    .when("/quanTriSP/nsx", {
      templateUrl: "../html/quan-tri-sp/view-nsx.html",
      controller: nsxController,
    })
    .when("/quanTriSP/mau-sac", {
      templateUrl: "../html/quan-tri-sp/view-mau-sac.html",
      controller: mauSacController,
    })
    .when("/quanTriSP/chi-tiet-sp", {
      templateUrl: "../html/quan-tri-sp/view-chi-tiet-sp.html",
      controller: chiTietSPController,
    })
    .when("/quanTriSP/chuc-vu", {
      templateUrl: "../html/quan-tri-sp/view-chuc-vu.html",
      controller: chuVuController,
    })
    .when("/quanTriSP/cua-hang", {
      templateUrl: "../html/quan-tri-sp/view-cua-hang.html",
      controller: cuaHangController,
    })
    .when("/quanTriSP/khach-hang", {
      templateUrl: "../html/quan-tri-sp/view-khach-hang.html",
      controller: khachHangController,
    })
    .when("/quanTriSP/hoa-don", {
      templateUrl: "../html/quan-tri-sp/view-hoa-don.html",
      controller: hoaDonController,
    })
    .when("/quanTriSP/nhan-vien", {
      templateUrl: "../html/quan-tri-sp/view-nhan-vien.html",
      controller: nhanVienController,
    })
    .when("/quanTriSP/hoa-don-chi-tiet", {
      templateUrl: "../html/quan-tri-sp/view-hoa-don-chi-tiet.html",
      controller: hoaDonChiTietController,
    })
    .when("/quanTriSP/gio-hang", {
      templateUrl: "../html/quan-tri-sp/view-gio-hang.html",
      controller: quanTriGioHangController,
    })
    .when("/category", {
      templateUrl: "category.html",
      controller: categoryController,
    })
    .otherwise({ redirectTo: "home" });
});

angular.module("myApp").directive("selectNgFiles", function () {
  return {
    require: "ngModel",
    link: function postLink(scope, elem, attrs, ngModel) {
      elem.on("change", function (e) {
        var files = elem[0].files;
        ngModel.$setViewValue(files);
      });
    },
  };
});

// app.controller("headerController", headerController);
