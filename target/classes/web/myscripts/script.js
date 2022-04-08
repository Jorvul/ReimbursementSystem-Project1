var apiURL = 'http://localhost:8080/employees';
function getAllEmployees(){
    alert("These are all the employees");
    fetch(apiURL)
    .then(response => response.json())  // convert to json
    .then(json => displayData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
    
}



function displayData(response) {
    var dataSection = document.getElementById('results');

   //alert(response.length)
   var list=document.createElement("ul");

   for(i=0;i<response.length;i++){
    var item=document.createElement("li");
       item.innerHTML=response[i].employeeId +" "+response[i].employeeName + " " +response[i].employeeTitle+ " "+response[i].username+ " "+response[i].password;
       //alert(response[i].id +" "+response[i].name);
       list.appendChild(item);
   }
   dataSection.appendChild(list);


}

function buttonClicked(){
	const username = document.getElementById("username").value;
	const password = document.getElementById("password").value;
	if(username==="Pelotero" && password=== "pasword"){
		alert("Login successful");
		document.location.href="reimbursements.html";
	} else if(username ==="Boomer" && password==="tooOldForThis100A!") {
		alert("Login successful");
		document.location.href="reimbursements.html";
	} else if(username==="Thor123" && password==="dawgsss3350?"){
		alert("Login successful");
		document.location.href="reimbursements.html";
	} else if(username==="FashionCap" && password==="ABCDEF!"){
		alert("Login successful");
		document.location.href="reimbursements.html";
	} else if(username==="SwissCheese" && password==="tryhackingme000"){
		alert("Login successful");
		document.location.href="reimbursements.html";
	} else if(username==="TheVoss" && password==="theBoss$$$"){
		alert("Login successful");
		document.location.href="acceptordeny.html";
	} else {
		alert("Login failed")
	}
}

function Home(){
	document.location.href="Login.html";
}
function expensePage(){
	document.location.href="reimbursements.html";
}
function managerApproval(){
	document.location.href="acceptordeny.html";
}

