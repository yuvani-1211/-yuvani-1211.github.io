// Include truYum form validation functions here
function validform (inputtxt){
	
	var name = document.myform.name.value;
	var price = document.myform.price.value;
	var date = document.myform.date.value;
	if (name == null || name == "") {
		alert("Name can't be blank");
		return false;
	} else if ( name.length < 2) {
		alert("name should have more than 2  characters.");
		return false;
	}
	else if (date == null || date == "") {
		alert("Date of Launcher can't be blank");
		return false;
	}
	else if (inputtxt.value.match(/^[0-9.]+$/)) {
        return true;
    } else {
    	
        alert("Please input numeric characters only");
        return false;
    }
		return true;
}
