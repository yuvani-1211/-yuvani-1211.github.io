// Include truYum form validation functions here
function validform (inputtxt){
	var numbers = /^[0-9]+$/;
	var name = document.myform.name.value;
	var name = document.myform.price.value;
	var date = document.myform.date.value;
	if (name == null || name == "") {
		alert("Name can't be blank");
		name.focus();
		return false;
	} else if ( name.length < 2) {
		alert("name should have more than 2  characters.");
		return false;
	}
	if (date == null || date == "") {
		alert("Date of Launcher can't be blank");
		date.focus();
		return false;
	}
    if (inputtxt.value.match(numbers)) {
		price.focus();
        return true;
    } else {
        alert('Please input numeric characters only');
        price.focus();
        return false;
    }
		return true;
}
