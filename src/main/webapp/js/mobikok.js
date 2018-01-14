$(function(){
});
function newMainLoadData(url) {
	window.location.href= url;
}
function getNowFormatDate() {
	//获取当前时间，格式为YYYY-MM-dd
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
function showErrorToast(title,message) {
	toastr.options = {"debug": false,"positionClass": "toast-top-right","onclick": null,"fadeIn": 300,"fadeOut": 1000,"timeOut": 5000,"extendedTimeOut": 1000}
	toastr.error(title, message);
}
function showErrorToastMiddle(title,message) {
	toastr.options = {"debug": false,"positionClass": "toast-middle-middle","onclick": null,"fadeIn": 300,"fadeOut": 1000,"timeOut": 5000,"extendedTimeOut": 1000}
	toastr.error(title, message);
}
function showInfoToastMiddle(message) {
	toastr.options = {"debug": false,"positionClass": "toast-top-right","onclick": null,"fadeIn": 300,"fadeOut": 1000,"timeOut": 5000,"extendedTimeOut": 1000}
	toastr.info(message);
}
//中间显示提示信息
function showInfoToastMiddle(message) {
	toastr.options = {"debug": false,"positionClass": "toast-middle-middle","onclick": null,"fadeIn": 300,"fadeOut": 1000,"timeOut": 5000,"extendedTimeOut": 1000}
	toastr.info(message);
}
/**
	检查选择时间是否在3个月内
	返回“1”表明 开始时间大于结束时间
	返回“2”表明 超过3个月的数据
	
	4/29-7/29或4/30-7/30或4/30-7/31 可以查询
	4/29-7/30或4/29-7/31  不可以查询
 */
function checkTime(startTime,endTime){
	var date1 = startTime.split("-");
	var date2 = endTime.split("-");          
	var myDate1 = new Date(date1[0],date1[1]-1,date1[2]);
	var myDate2 = new Date(date2[0],date2[1]-1,date2[2]);
		if (myDate1 <= myDate2) {
			if (myDate2.getFullYear()==myDate1.getFullYear()) {
 			if((myDate2.getMonth()+1) - (myDate1.getMonth()+1) > 3) {
 				return "2";
 			}else if ((myDate2.getMonth()+1) - (myDate1.getMonth()+1) == 3) {
				if (myDate1.getDate() < myDate2.getDate()) {
					if (myDate1.getFullYear() & 4 == 0) {
						if (myDate1.getMonth()+1 == 2) {
							if(myDate1.getDate() < 29 & myDate2.getDate() - myDate1.getDate() > 0){
			       				return "2";
							}
						}
					}else{
						if (myDate1.getMonth()+1 == 2) {
							if(myDate1.getDate() < 28 & myDate2.getDate() - myDate1.getDate() > 0){
			       				return "2";
							}
						}
					}
					if (myDate1.getMonth()+1 == 4) {
						if(myDate1.getDate() < 30 & myDate2.getDate() - myDate1.getDate() > 0){
		       				return "2";
						}
					}else if (myDate1.getMonth()+1 == 9) {
						if(myDate1.getDate() < 30 & myDate2.getDate() - myDate1.getDate() > 0){
		       				return "2";
						}
					}else if (myDate1.getMonth()+1 != 2){
						if (myDate2.getDate() - myDate1.getDate() > 0) {
		       				return "2";
						}
					}
				}
			}
		} else if (myDate2.getFullYear() - myDate1.getFullYear() == 1) {
			if (myDate2.getMonth()+1 > 3) {
				return "2";
			} else if (myDate1.getMonth()+1 < 10) {
				return "2";
			} else if ((myDate1.getMonth()+1) - (myDate2.getMonth()+1) < 9) {
				return "2";
			}else {
				if (myDate2.getDate() - myDate1.getDate() > 0) {
					return "2";
				}
			}
		} else {
			return "2";
		}
	} else {
		return "1";
	}
}