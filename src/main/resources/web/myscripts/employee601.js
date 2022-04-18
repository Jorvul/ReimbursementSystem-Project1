//get expenses for individual employee
function getExpenseById(){
var apiURL = 'http://localhost:8080/expenses/601';
    alert("These are all your requests");
    fetch(apiURL)
    .then(response => response.json())  // convert to json
    .then(json => displayData1(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}


function displayData1(response) {
    var dataSection = document.getElementById('myExp');
	
   //alert(response.length)
   var list=document.createElement("ol");
   for(i=0;i<response.length;i++){
	var item = document.createElement("li");
      item.innerHTML=response[i].authorId +" "+ response[i].resolverId+" " +response[i].expenseType+" " +response[i].amount+ " "+response[i].description+" "+ response[i].submitTime+ " "+ response[i].accepted+" "+response[i].result;
       //alert(response[i].id +" "+response[i].name);
       list.appendChild(item);
   }
   dataSection.appendChild(list);


}
	
/*function insertNewRecord(response){
	console.log(response)
	const table = document.getElementById("employeeList").getElementsByTagName("tbody")[0];
	const newRow = table.insertRow(table.length);
	cell1 = newRow.insertCell(0);
	cell1.innerHTML= response.authorId;
	cell2 = newRow.insertCell(1);
	cell2.innerHTML = response.resolverId;
	cell3 = newRow.insertCell(2);
	cell3.innerHTML = response.expenseType;
	cell4 = newRow.insertCell(3);
	cell4.innerHTML = response.amount;
	cell5 = newRow.insertCell(4);
	cell5.innerHTML = response.description;
	cell6 = newRow.insertCell(5);
	cell6.innerHTML = new Date().toLocaleString();
	cell7 = newRow.insertCell(6);
	cell7.innerHTML = response.accepted;
	cell8 = newRow.insertCell(7);
	cell8.innerHTML = response.result;
	//cell4 = newRow.insertCell(4);
	//cell4.innerHTML = `<a onclick="onEdit(this)">Accept</a>
						//<a>Decline</a>`;

}*/