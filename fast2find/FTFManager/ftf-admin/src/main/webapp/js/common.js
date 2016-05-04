/*function Validate(evt,txt) {
	var keyCode = evt.keyCode;
    if (keyCode< 37 || keyCode > 40) {
	txt.value = txt.value.replace(/[^a-zA-Z 0-9\n\r\/]+/g, '');
    }
    return false;
}*/
function Validate(txt) {
	 var invalidChars = /[^a-zA-Z 0-9\n\r\/]+/g 
	    if(invalidChars.test(txt.value)) {
	     txt.value = txt.value.replace(invalidChars,"");
	        }
	}