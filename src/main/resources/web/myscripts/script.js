
//get expenses for individual employee
function getExpenseById(){
var apiURL = 'http://localhost:8080/expenses/301';
    alert("These are all your expenses");
    fetch(apiURL)
    .then(response => response.json())  // convert to json
    .then(json => displayData1(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
    
}
function displayData1(response) {
    var dataSection = document.getElementById('myExp');

   //alert(response.length)
   var list=document.createElement("ul");

   for(i=0;i<response.length;i++){
    var item=document.createElement("li");
       item.innerHTML=response[i].authorId +" "+response[i].resolverId + " " +response[i].expenseType+ " "+response[i].amount+ " "+response[i].description+ " "+ response[i].submitTime+ " " +response[i].accepted;
       //alert(response[i].id +" "+response[i].name);
       list.appendChild(item);
   }
   dataSection.appendChild(list);


}





function getAllEmployees(){
var apiURL = 'http://localhost:8080/employees';
    alert("These are all the employees");
    fetch(apiURL)
    .then(response => response.json())  // convert to json
    .then(json => displayData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
    
}
function displayData(response) {
    var dataSection = document.getElementById('exp');

   //alert(response.length)
   var list=document.createElement("ul");

   for(i=0;i<response.length;i++){
    var item=document.createElement("li");
       item.innerHTML=response[i].authorId +" "+response[i].resolverId + " " +response[i].expenseType+ " "+response[i].amount+ " "+response[i].description+ " "+ response[i].submitTime+ " " +response[i].accepted;
       //alert(response[i].id +" "+response[i].name);
       list.appendChild(item);
   }
   dataSection.appendChild(list);


}

//get all expenses
function getAllExpenses(){
	var apiURL = 'http://localhost:8080/expenses';
    alert("These are all the employees requests");
    fetch(apiURL)
    .then(response => response.json())  // convert to json
    .then(json => displayData2(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}
function displayData2(response) {
    var dataSection = document.getElementById('exp');

   //alert(response.length)
   var list=document.createElement("ol");

   for(i=0;i<response.length;i++){
    var item=document.createElement("li");
       item.innerHTML=response[i].authorId +" "+response[i].resolverId + " " +response[i].expenseType+ " "+response[i].amount+ " "+response[i].description+ " "+ response[i].submitTime+ " " +response[i].accepted;
       //alert(response[i].id +" "+response[i].name);
       list.appendChild(item);
   }
   dataSection.appendChild(list);


}
//create expense
async function AsyncFunc(data){
	let user = { authorId:data.employeeID, expenseType:data.expense,amount:data.amount, 
	description:data.description, submitTime:new Date()
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/expenses',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
	
}

async function AsyncFunc1(data){
	let user = { authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	description:data.description, submitTime:new Date().toLocaleString
		
	};
	let response = await fetch('http://localhost:8080/expenses',{ method:'GET',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
	
}
//accept or deny request
function requestDecision(){
	let approve = document.getElementById("yes").value;
	let deny = document.getElementById("no").value;
	let decision = 0;
	if(approve.checked){
		decision = approve.value
		denyAppriveRequest(decision)
	} else if(deny.checked){
		decision = deny.value;
		denyApproveRequest(decision);
	}
}

async function denyApproveRequest(decision){
	let user = { accepted: true
		
	};
	let response = await fetch('http://localhost:8080/employee/{author_id}',{ method:'PUT',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		displayData3(result);
	
}
function displayData3(response) {
    var dataSection = document.getElementById('exp');

   //alert(response.length)
   var list=document.createElement("ul");

   for(i=0;i<response.length;i++){
    var item=document.createElement("li");
       item.innerHTML=response[i].authorId +" "+response[i].resolverId + " " +response[i].expenseType+ " "+response[i].amount+ " "+response[i].description+ " "+ response[i].submitTime+ " " +response[i].accepted;
       //alert(response[i].id +" "+response[i].name);
       list.appendChild(item);
   }
   dataSection.appendChild(list);


}


//login in portal
function buttonClicked(){
	const username = document.getElementById("username").value;
	const password = document.getElementById("password").value;
	if(username==="Pelotero" && password=== "pasword"){
		alert("Hello Mr.Marmol!");
		document.location.href="sample.html";
	} else if(username ==="Boomer" && password==="tooOldForThis100A!") {
		alert("Login successful");
		document.location.href="sample";
	} else if(username==="Thor123" && password==="dawgsss3350?"){
		alert("Login successful");
		document.location.href="sample.html";
	} else if(username==="FashionCap" && password==="ABCDEF!"){
		alert("Login successful");
		document.location.href="sample.html";
	} else if(username==="SwissCheese" && password==="tryhackingme000"){
		alert("Login successful");
		document.location.href="sample.html";
	} else if(username==="TheVoss" && password==="theBoss$$$"){
		alert("Welcome Ms.Hernandez");
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

function getValue(){
	const amount = document.getElementById("amount").value;
	const area = document.getElementById("words").value;
	//const misc = document.getElementById("food").value;
	//document.onclick(misc);
	document.write(amount)
	document.write(area);
	//document.write(misc);
}

function onFormSubmit(){
	const formData = readFormData();
	insertNewRecord(formData);
	 AsyncFunc(formData);
	 AsyncFunc1(formData);
	 
	//resetForm();
}
function readFormData(){
	const formData ={};
	formData["employeeID"]= document.getElementById("employeeID").value;
	formData["expense"]= document.getElementById("expense").value;
	formData["amount"]= document.getElementById("amount").value;
	formData["description"]= document.getElementById("description").value;
	return formData;
}

function insertNewRecord(data){
	const table = document.getElementById("employeeList").getElementsByTagName("tbody")[0];
	const newRow = table.insertRow(table.length);
	cell1 = newRow.insertCell(0);
	cell1.innerHTML= data.employeeID;
	cell2 = newRow.insertCell(1);
	cell2.innerHTML = data.expense;
	cell3 = newRow.insertCell(2);
	cell3.innerHTML = data.amount;
	cell4 = newRow.insertCell(3);
	cell4.innerHTML = data.description;
	cell5 = newRow.insertCell(4);
	cell5.innerHTML = new Date().toLocaleString();
	cell6 = newRow.insertCell(5);
	cell6.innerHTML;
	//cell4 = newRow.insertCell(4);
	//cell4.innerHTML = `<a onclick="onEdit(this)">Accept</a>
						//<a>Decline</a>`;

}

function resetForm(){
	document.getElementById("employeeID").value = "";
	document.getElementById("expense").value = "";
	document.getElementById("amount").value = "";
	document.getElementById("description").value = "";

}

function acceptOrDenyFunc(){
	const reject = document.getElementById("amount").value;
	const accept = document.getElementById("amount").value;
	if(accept <= "$" + 300){
		alert("request accepted");
	} else if (reject > "$" + 300){
		alert("request rejected");
	}
}
function rejectFunc(){
	document.myform.reject.value = "Reject";
}
//function onEdit(td){
	//selectedRow = td.parentElement.parentElement;
	//document.getElementById("employeeID").value = selectedRow.cells[0].innerHTML;
	//document.getElementById("expense").value = selectedRow.cells[1].innerHTML;
	//document.getElementById("amount").value = selectedRow.cells[2].innerHTML;
	//document.getElementById("description").value = selectedRow.cells[3].innerHTML;

//}
//let storedItem = localStorage.getItem("storedItem");
//function onSave(){
	//let item = document.getElementById("employeeID").value;
	//let item2 = document.getElementById("expense").value;
	//let item3 = document.getElementById("amount").value;
	//let item4 = document.getElementById("description").value;
	
	//localStorage.setItem("storedItem", item);
	//.setItem("storedItem", item2);
	//localStorage.setItem("storedItem", item3);
	//localStorage.setItem("storedItem", item4);

//}
function get(){
	localStorage.getItem("storedItem");
}