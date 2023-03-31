/*
	Dopetrope by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
*/

showLogin();

fetch("auth/user")
  .then((response) => {
    return response.json();
  })
  .then((result) => {
    if (result.status == "success") {
      document.querySelector("#username").innerHTML = result.data.email;
      // document.querySelector("#login").classList.remove("invisibile");
      showLogout();
    } else {
      // document.querySelector("#logout").classList.remove("invisibile");
    }
  })
  .catch((exception) => {
    alert("로그인 사용자 정보 조회 오류!");
  });

function logout() {
  fetch("auth/logout")
    .then((response) => {
      return response.json();
    })
    .then((result) => {
      alert("로그아웃 성공!");
      showLogin();
      location.reload();
    })
    .catch((exception) => {
      console.log(exception);
    });
}

function showLogin() {
  let el = document.querySelectorAll("#login, #sign-up");
  for (let e of el) {
    e.classList.remove("invisible");
  }

  el = document.querySelectorAll("#logout");
  for (let e of el) {
    e.classList.add("invisible");
  }
}

function showLogout() {
  let el = document.querySelectorAll("#login, #sign-up");
  for (let e of el) {
    e.classList.add("invisible");
  }

  el = document.querySelectorAll("#logout");
  for (let e of el) {
    e.classList.remove("invisible");
  }
}

(function ($) {
  var $window = $(window),
    $body = $("body");

  // Breakpoints.
  breakpoints({
    xlarge: ["1281px", "1680px"],
    large: ["981px", "1280px"],
    medium: ["737px", "980px"],
    small: [null, "736px"],
  });

  // Play initial animations on page load.
  $window.on("load", function () {
    window.setTimeout(function () {
      $body.removeClass("is-preload");
    }, 100);
  });

  // Dropdowns.
  $("#nav > ul").dropotron({
    mode: "fade",
    noOpenerFade: true,
    alignment: "center",
  });

  // Nav.

  // Title Bar.
  $(
    '<div id="titleBar">' + '<a href="#navPanel" class="toggle"></a>' + "</div>"
  ).appendTo($body);

  // Panel.
  $('<div id="navPanel">' + "<nav>" + $("#nav").navList() + "</nav>" + "</div>")
    .appendTo($body)
    .panel({
      delay: 500,
      hideOnClick: true,
      hideOnSwipe: true,
      resetScroll: true,
      resetForms: true,
      side: "left",
      target: $body,
      visibleClass: "navPanel-visible",
    });
})(jQuery);
