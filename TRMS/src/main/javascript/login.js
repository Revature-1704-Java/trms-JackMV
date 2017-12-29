function login() {
  let username = document.getElementById('employeeID').value;
  let password = document.getElementById('employeePassword').value;
  console.log(username);
  console.log(password);
  //validate the username and password here, if valid
  if(true) {
    window.location.href="index.html";
  }
  //else display invalid login message and let them try again
}

let loginButton = document.getElementById("loginBtn");
loginButton.onclick = function() {login();}
