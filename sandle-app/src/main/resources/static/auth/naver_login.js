//##################네이버 로그인#####################

var naverLogin = new naver.LoginWithNaverId({
  clientId: "7IRmDHQjqS4tC67jT8LS",
  callbackUrl: "http://localhost:8080/sandle/auth/login_form.html",
  isPopup: false,
  callbackHandle: true,
});

// Set up event listener for login button
var loginButton = document.getElementById("naverLogin");
loginButton.addEventListener("click", function () {
  naverLogin.login();
});

// Handle login status changes
naverLogin.getLoginStatus(function (status) {
  if (status) {
    // User is logged in, get user information
    var email = naverLogin.user.getEmail();
    var name = naverLogin.user.getName();

    // Send user information to server for processing
    // ...
  } else {
    // User is not logged in
    // ...
  }
});
