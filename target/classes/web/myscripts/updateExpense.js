async function AsyncFunc4(data){
	let user = {  accepted:false//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/601',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function AsyncFunc5(data){
	let user = {  accepted:true//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/601',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function AsyncFunc6(data){
	let user = {  accepted:true//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/501',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function emp501Deny(data){
	let user = {  accepted:false//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/501',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function emp201Deny(data){
	let user = {  accepted:false//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/201',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function emp201Approve(data){
	let user = {  accepted:true//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/201',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function emp401Deny(data){
	let user = {  accepted:false//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/401',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function emp401Approve(data){
	let user = {  accepted:true//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/401',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

function ApproveFunc(){
	const user = document.getElementById("empNum").value;
	if(user==="601"){
		AsyncFunc5();
	}if(user==="501"){
		AsyncFunc6();
	}if(user ==="201"){
		emp201Approve();
	}if(user==="401"){
		emp401Approve();
	}
}

function DenyFunc(){
	const user = document.getElementById("empNum").value;
	if(user ==="601"){
		AsyncFunc4();
	}if(user==="501"){
		emp501Deny();
	} if(user==="201"){
		emp201Deny();
	} if(user==="401"){
		emp401Deny();
	}
}
/*function ApproveFunc(){
 document.getElementById('yes').addEventListener("click", function() {
   AsyncFunc5();
})​
}

function DenyFunc(){
 document.getElementById('no').addEventListener("click", function() {
   AsyncFunc4();
}​)​
}*/


function onFormSubmit(){
	const formData = readFormData();
	//insertNewRecord(formData);
	 AsyncFunc(formData);
	 //AsyncFunc2(formData);
	//resetForm();
}
function readFormData(){
	const formData ={};
	formData["empID"]= document.getElementById("empID").value;
	//formData["expense"]= document.getElementById("expense").value;
	//formData["amount"]= document.getElementById("amount").value;
	//formData["description"]= document.getElementById("description").value;
	return formData;
}