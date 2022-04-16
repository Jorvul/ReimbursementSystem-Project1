//get expenses for individual employee
function getExpenseById(){
var apiURL = 'http://localhost:8080/expenses/601';
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
       item.innerHTML=response[i].authorId +" "+response[i].resolverId + " " +response[i].expenseType+ " "+response[i].amount+ " "+response[i].description+ " "+ response[i].submitTime+ " " +response[i].accepted+" "+response[i].result;
       //alert(response[i].id +" "+response[i].name);
       list.appendChild(item);
   }
   dataSection.appendChild(list);


}