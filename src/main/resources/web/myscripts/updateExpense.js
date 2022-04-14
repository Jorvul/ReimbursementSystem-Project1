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

async function emp301Deny(data){
	let user = {  accepted:false//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/301',{ method:'POST',
	headers:{
		'Content-Type':'application/json'},
		body: JSON.stringify(user)
	});
		
		let result = await response.json();
		alert(result.message);
		
}

async function emp301Approve(data){
	let user = {  accepted:true//authorId:data.employeeId, expenseType:data.expense,amount:data.amount, 
	//description:data.description, submitTime:new Date().toLocaleString
		
	};
	console.log(user)
	let response = await fetch('http://localhost:8080/employee/301',{ method:'POST',
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
	}else if(user==="501"){
		AsyncFunc6();
	}else if(user ==="201"){
		emp201Approve();
	}else if(user==="401"){
		emp401Approve();
	} else if (user==="301"){
		emp301Approve();
	} else{
		alert("Employee ID not in the system");
	}
}

function DenyFunc(){
	const user = document.getElementById("empNum").value;
	if(user ==="601"){
		AsyncFunc4();
	} else if(user==="501"){
		emp501Deny();
	} else if(user==="201"){
		emp201Deny();
	} else if(user==="401"){
		emp401Deny();
	} else if(user ==="301"){
		emp301Deny();
	} else {
		alert("Employee ID not in the system");
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