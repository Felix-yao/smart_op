	$("#dsp").select2({
        ajax: {
          url: getRootPath() + "/system/system!dspSelect2",
          dataType: 'json',
          delay: 250,
          placeholder:'请选择',
          data: function (params) {
            return {
              q: params.term,
            };
          },
          processResults: function (data) {
            console.log(data);
            var parsed = data;
            var arr = [];
            for(var x in parsed){
                arr.push(parsed[x]); //这个应该是个json对象
            }
            console.log(arr);
            return {
              results: arr
            };
          },
          cache: true
        },
        escapeMarkup: function (markup) { return markup; }, 
        minimumInputLength: 1,
    });
	
	$("#publisherId").select2({
        ajax: {
          url: getRootPath() + "/system/system!publisherSelect2",
          dataType: 'json',
          delay: 250,
          placeholder:'请选择',
          data: function (params) {
            return {
              q: params.term,
            };
          },
          processResults: function (data) {
            console.log(data);
            var parsed = data;
            var arr = [];
            for(var x in parsed){
                arr.push(parsed[x]); //这个应该是个json对象
            }
            console.log(arr);
            return {
              results: arr
            };
          },
          cache: true
        },
        escapeMarkup: function (markup) { return markup; }, 
        minimumInputLength: 1,
    });
	
	$("#appId").select2({
        ajax: {
          url: getRootPath() + "/system/system!appSelect2",
          dataType: 'json',
          delay: 250,
          placeholder:'请选择',
          data: function (params) {
            return {
              q: params.term,
            };
          },
          processResults: function (data) {
            console.log(data);
            var parsed = data;
            var arr = [];
            for(var x in parsed){
                arr.push(parsed[x]); //这个应该是个json对象
            }
            console.log(arr);
            return {
              results: arr
            };
          },
          cache: true
        },
        escapeMarkup: function (markup) { return markup; }, 
        minimumInputLength: 1,
    });
	
	$("#countryId").select2({
        ajax: {
          url: getRootPath() + "/system/system!countrySelect2",
          dataType: 'json',
          delay: 250,
          placeholder:'请选择',
          data: function (params) {
            return {
              q: params.term,
            };
          },
          processResults: function (data) {
            console.log(data);
            var parsed = data;
            var arr = [];
            for(var x in parsed){
                arr.push(parsed[x]); //这个应该是个json对象
            }
            console.log(arr);
            return {
              results: arr
            };
          },
          cache: true
        },
        escapeMarkup: function (markup) { return markup; }, 
        minimumInputLength: 1,
    });
	
	$("#adPositionId").select2({
        ajax: {
          url: getRootPath() + "/system/system!adPositionSelect2",
          dataType: 'json',
          delay: 250,
          placeholder:'请选择',
          data: function (params) {
            return {
              q: params.term,
            };
          },
          processResults: function (data) {
            console.log(data);
            var parsed = data;
            var arr = [];
            for(var x in parsed){
                arr.push(parsed[x]); //这个应该是个json对象
            }
            console.log(arr);
            return {
              results: arr
            };
          },
          cache: true
        },
        escapeMarkup: function (markup) { return markup; }, 
        minimumInputLength: 1,
    });
	
	//返回页含有select2 ajax的页面样式不正常增加以下样式
//	$(".select2.select2-container.select2-container--default").removeClass("select2-container--default").addClass("select2-container--bootstrap")
	
//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath() {
	var host = window.location.host;
	if (host == "adx.mobikok.com") {//正式服务器则返回host（有域名情况下）
		return "";
	} else {//（没有域名情况下）
		//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
		var curWwwPath = window.document.location.href;
		//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		//获取主机地址，如： http://localhost:8083
		var localhostPaht = curWwwPath.substring(0, pos);
		//获取带"/"的项目名，如：/uimcardprj
		var projectName = pathName.substring(0,
				pathName.substr(1).indexOf('/') + 1);
		return (localhostPaht + projectName);
	}
}