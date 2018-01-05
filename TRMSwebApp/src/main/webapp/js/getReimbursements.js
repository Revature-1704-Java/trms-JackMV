let reimbursements;

let displayReimb = function addReimbursement(reimbursements) {
  for(let i = 0; i < reimbursements.length; i++) {
    let ul = document.getElementById('requests');
    let li = document.createElement('li');
    let a = document.createElement('a');
    a.setAttribute('href', '#' + i);
    a.innerHTML = '<li>' + reimbursements[i].description + '</li>';
    li.appendChild(a);
    ul.appendChild(li);
  }
}

let xhr = new XMLHttpRequest();
xhr.open('POST', 'http://localhost:5252/TRMS/ViewRequestsServlet');
xhr.onreadystatechange = function() {
  if (xhr.readyState === 4 && xhr.status === 200) {
    reimbursements = JSON.parse(xhr.response);
  }
}
xhr.send();
