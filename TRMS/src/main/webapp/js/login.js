// function login() {
//   let username = document.getElementById('employeeID').value;
//   let password = document.getElementById('employeePassword').value;
//   let xhr = new XMLHttpRequest();
//
//   xhr.open("POST", "/TRMS/LoginRequestServlet");
//   xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//   xhr.setRequestHeader('employeeID', username);
//   xhr.setRequestHeader('employeePassword', password);
//   xhr.onReadyStateChange = function() {
// 	  console.log('state: ' + xhr.readyState + ' status: ' + xhr.status);
//   }
//   console.log(xhr)
//   xhr.send();
//
//   console.log(username);
//   console.log(password);
//   //validate the username and password here, if valid
//   if(false) {
//     window.location.href="index.html";
//   }
//   //else display invalid login message and let them try again
// }
//
// let loginButton = document.getElementById("loginBtn");
// loginButton.onclick = function() {login();}
