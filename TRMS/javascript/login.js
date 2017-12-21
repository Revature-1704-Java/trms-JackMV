function login() {
  let username = document.getElementById('usn');
  let password = document.getElementById('pwd');
  //validate the username and password here, if valid
  if(true) {
    window.location.href="dashboard.html";
  }
  //else display invalid login message and let them try again
}

let loginButton = document.getElementById("loginBtn");
loginButton.onclick = function() {login();}
