var nameCount = 0;
var ageCount = 0;
function addName(){
	nameCount = nameCount+1;
	var newText = document.createElement("input");
	newText.setAttribute("value","newName".concat(nameCount));
	document.getElementById("dynamicDiv").appendChild(newText);
}
function addAge(){
	ageCount = ageCount+1;
	var newText = document.createElement("input");
	newText.setAttribute("value","newAge".concat(ageCount));
	document.getElementById("dynamicDiv").appendChild(newText);
}
function addElement(element){
	var selection = document.getElementById("mySelection");
	var selectedValue = selection.options[selection.selectedIndex].value;
	if(selectedValue == 'name'){
		addName();
		
	}else if(selectedValue == 'age'){
		addAge();
	}
}