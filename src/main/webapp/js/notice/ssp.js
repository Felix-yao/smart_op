function showErrorToast(title, message) {
	toastr.options = {
		"debug" : false,
		"positionClass" : "toast-top-right",
		"onclick" : null,
		"showDuration" : 300,
		"hideDuration" : 1000,
		"timeOut" : 5000,
		"extendedTimeOut" : 1000
	}
	toastr.error(title, message);
}
function showErrorToastMiddle(title, message) {
	toastr.options = {
		"debug" : false,
		"positionClass" : "toast-middle-middle",
		"onclick" : null,
		"showDuration" : 300,
		"hideDuration" : 1000,
		"timeOut" : 5000,
		"extendedTimeOut" : 1000
	}
	toastr.error(title, message);
}
function showInfoToast(title, message) {
	toastr.options = {
		"debug" : false,
		"positionClass" : "toast-top-right",
		"onclick" : null,
		"showDuration" : 300,
		"hideDuration" : 1000,
		"timeOut" : 5000,
		"extendedTimeOut" : 1000
	}
	toastr.info(message);
}
// 中间显示提示信息
function showInfoToastMiddle(title, message) {
	toastr.options = {
		"debug" : false,
		"positionClass" : "toast-top-center",
		"onclick" : null,
		"showDuration" : 300,
		"hideDuration" : 1000,
		"timeOut" : 5000,
		"extendedTimeOut" : 1000
	}
	toastr.info(message, title);
}
function showMiddle(title,message){
	toastr.options = {
			  "debug": false,
			  "positionClass": "toast-center-center",
			  "onclick": null,
			  "showDuration": "300",
			  "hideDuration": "1000",
			  "timeOut": "5000",
			  "extendedTimeOut": "1000",
			}
	toastr.info(message,title);
}