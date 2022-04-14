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

function denyFunc(){
	const deny = document.getElementById("no").value;
	if(deny==="denied"){
		
	}
}

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