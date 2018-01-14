<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <style type="text/css">
        .form-horizontal .form-group {
            margin-left: 100px !important;
        }
    </style>
</head>
<body>
 <!-- Begin page -->
 <div id="wrapper">
    <%@ include file="/pages/main/main.jsp" %> 
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="page-title-box">
                                    <h4 class="page-title"><s:if test="appVO.id>0">Update</s:if><s:else>Create</s:else> App</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            App
                                        </li>
                                        <li class="active">
                                            <s:if test="appVO.id>0">Update</s:if><s:else>Create</s:else> App
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- 中心内容  end-->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box">
                                    <h4 class="m-t-0 header-title"><b><s:if test="appVO.id>0">Update</s:if><s:else>Create</s:else></b></h4>
                                    <p class="text-muted m-b-30 font-14">
                                    </p>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="p-20">
                                                <form class="form-horizontal" role="form">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Name</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="name" class="form-control" placeholder="Name"
                                                            value='<s:property value="appVO.name"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <role:RoleEqual roleName="SP,AM,PY,AMP">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Publisher</label>
                                                        <div class="col-md-4">
                                                            <select id="publisherId" class="form-control select2"
                                                                name="appVO.publisherId" style="width:50%">
                                                            </select>
                                                        </div>
                                                    </div>
                                                    </role:RoleEqual>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Platform</label>
                                                        <div class="col-md-4">
                                                            <select id="platform" class="form-control select2"
                                                                name="appVO.platform" >
                                                                <option value="1">Android</option>
                                                                <option value="2">Website</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <role:RoleEqual roleName="SP,AM">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">SubId filter Dsp</label>
                                                        <div class="col-md-2">
                                                            <select class="form-control" style="WIDTH: 120px"
                                                                name="appVO.dspOpType" id="dspOpType">
                                                                <option value="0">All</option>
                                                                <option value="1">Include</option>
                                                                <option value="2">Exclude</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <select id="dsp" class="form-control input-inline input-medium" multiple="multiple"
                                                                name="appVO.dsp" style="width:50%">
                                                            </select>
                                                        </div>
                                                    </div>
                                                    </role:RoleEqual>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">App Categories</label>
                                                        <div class="col-md-2">
                                                            <select id="iab1" class="form-control select2" onchange="selIAB2(this.value);"
                                                                name="publisherVO.iab1" >
                                                                <s:action name="getAllIAB1" namespace="/system" 
                                                                    executeResult="true">
                                                                </s:action>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <select id="iab2" class="form-control input-inline input-medium"
                                                                name="appVO.dsp" style="width:50%">
                                                                <option value="0">--IAB2--</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Url</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="url" class="form-control" placeholder="Url"
                                                            value='<s:property value="appVO.url"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">StoreUrl</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="storeUrl" class="form-control" placeholder="StoreUrl"
                                                            value='<s:property value="appVO.storeUrl"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">PackageName</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="packageName" class="form-control" placeholder="PackageName"
                                                            value='<s:property value="appVO.packageName"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <role:RoleEqual roleName="SP,AM">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">PricePercent</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="pricePercent" class="form-control" placeholder="PricePercent"
                                                            value='<s:property value="appVO.pricePercent"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">ShowPercent</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="showPercent" class="form-control" placeholder="ShowPercent"
                                                            value='<s:property value="appVO.showPercent"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">ClickPercent</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="clickPercent" class="form-control" placeholder="ClickPercent"
                                                            value='<s:property value="appVO.clickPercent"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    </role:RoleEqual>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label"></label>
                                                        <div class="col-md-4">
                                                            <button class="btn btn-primary waves-effect waves-light" 
                                                                    type="button" onclick="savePublisher()">Submit
                                                            </button>
                                                            <a type="button" class="btn btn-default waves-effect m-l-5"
                                                                    href="<%=request.getContextPath()%>/publisher/app!appListPage">
                                                                Cancel
                                                            </a>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end row -->
                                </div> <!-- end card-box -->
                            </div><!-- end col -->
                        </div>
                        <!-- end row -->
                        <!-- 中心内容  end-->
                </div> <!-- content -->
            </div>
</div>
<script type="text/javascript">
    $("#menu-3,#menu-3 a").addClass("active");
    $("#menu-3 ul").addClass("in");
</script>

<script type="text/javascript">

    $("#dsp").select2();
    $("#platform").select2();
    $("#opType").select2();
    $("#dspOpType").select2();
    <role:RoleEqual roleName="SP,AM,PY,AMP">
    $("#publisherId").select2();
    </role:RoleEqual>
    $("#iab1").select2();
    $("#iab2").select2();
    
    var id = "<s:property value="appVO.id"/>";
    if(id>0){
        //platform
	    var platform    =   "<s:property value="appVO.platform"/>";
	    $("#platform").val(platform).trigger("change");
	    
	    //dsp
	    var dspOpType   =   "<s:property value="appVO.dspOpType"/>";
        $("#dspOpType").val(dspOpType).trigger("change");
        
        var dspsBack = '<s:property value = "appVO.dsps"/>';//获取apiOfferIds格式为,1,2,3,
        if(dspsBack!="" && dspsBack!=null){
        var dspsTemp = dspsBack.split(",");
            for(var i=0;i<dspsTemp.length;i++){
	            $("#dsp").append("<option value='"+dspsTemp[i]+"'>"+dspsTemp[i]+"</option>");
            }
            var dspSelect2 = $("#dsp").select2();
            dspSelect2.val(dspsTemp).trigger("change");
        }
        <role:RoleEqual roleName="SP,AM,PY,AMP">
        //publisher
        var publisherName = '<s:property value = "appVO.publisherName"/>';
        var publisherId   = '<s:property value = "appVO.publisherId"/>';
        if(publisherName != ""){
            $("#publisherId").append("<option value="+publisherId+">"+publisherName+"</option>");
            $("#publisherId").append("<option value=0>---publisher---</option>");
        }else {
            $("#publisherId").append("<option value=0>---publisher---</option>");
        }
        </role:RoleEqual>
        
        var iab1 = '<s:property value = "appVO.iab1"/>';
        var iab2 = '<s:property value = "appVO.iab2"/>';
        
        if(iab1 != ""){
        	$("#iab1").val(iab1).trigger("change");
        }
    }
  
    function savePublisher(){
        var name        =   $('#name').val();
        var platform    =   $('#platform').val();
        var url         =   $('#url').val();
        var storeUrl    =   $('#storeUrl').val();
        var packageName =   $('#packageName').val();
        var iab1        =   $('#iab1').val();
        var iab2        =   $('#iab2').val();
        var publisherId =   $('#publisherId').val();
        var pricePercent=   $('#pricePercent').val();
        var clickPercent=   $('#clickPercent').val();
        var showPercent =   $('#showPercent').val();
        var dsp         =   $('#dsp').val();
        var dspOpType   =   $('#dspOpType').val();        
        
        if(name == ""){
            showMiddle("Name Cannot Be Empty");
            $("#name").focus();
            return false;
        }else if(publisherId == 0 && typeof(publisherId) != "undefined"){
            showMiddle("Please Select Publisher");
            $("#publisherId").focus();
            return false;
        }else if(iab1 == 0){
            showMiddle("Please Select IAB1");
            $("#iab1").focus();
            return false;
        }else if(iab2 == 0){
            showMiddle("Please Select IAB2");
            $("#iab2").focus();
            return false;
        }else if(url == ""){
            showMiddle("url Cannot Be Empty");
            $("#url").focus();
            return false;
        }else if(packageName == ""){
            showMiddle("packageName Cannot Be Empty");
            $("#packageName").focus();
            return false;
        }
        
        var reg1=/^([hH][tT]{2}[pP]:\/\/|[hH][tT]{2}[pP][sS]:\/\/)/;//网址验证
        var reg_0_100 = /^(?:0|[1-9][0-9]?|100)$/;//1-100的正整数验证
        
        if(!reg_0_100.test(pricePercent) && typeof(pricePercent) != "undefined"){//判断输入的是否是1-100的正整数
            showMiddle("Please enter a 0-100 positive integer");
            $("#pricePercent").focus();
            return;
        } else if(!reg_0_100.test(clickPercent) && typeof(clickPercent) != "undefined"){
        	showMiddle("Please enter a 0-100 positive integer");
            $("#clickPercent").focus();
            return;
        } else if(!reg_0_100.test(showPercent) && typeof(showPercent) != "undefined"){
            showMiddle("Please enter a 0-100 positive integer");
            $("#showPercent").focus();
            return;
        } else if(!reg1.test(url)){
            showMiddle("Url not the beginning of http://https://，Or not the web site！");
            $("#url").focus();
            return ;
        } else if(!reg1.test(storeUrl)){
           showMiddle("StoreUrl is not the beginning of http://https://，Or not the web site！");
           $("#storeUrl").focus();
           return ;
        } 
        
        if(typeof(publisherId) == "undefined"){
            publisherId = 0;
        }if(typeof(dspOpType) == "undefined"){
        	dspOpType = 0;
        }if(typeof(pricePercent) == "undefined"){
        	pricePercent = 0;
        }if(typeof(clickPercent) == "undefined"){
        	clickPercent = 0;
        }if(typeof(showPercent) == "undefined"){
        	showPercent = 0;
        }
        
        var dsps = "";
        if(dspOpType!=0){
            dsps = dsp+"";
        }
        
        debugger
        $('#submit').attr("disabled",true);
        if(id>0){
        	var urls =   "<%=request.getContextPath()%>/publisher/app!updateSave";
        	$.post(urls,
                    {"appVO.id":id,             "appVO.name":name,                "appVO.platform":platform,           
                     "appVO.iab1":iab1,         "appVO.iab2":iab2,                "appVO.publisherId":publisherId,
                     "appVO.dsps":dsps,         "appVO.packageName":packageName,  "appVO.dspOpType":dspOpType,
                     "appVO.url":url,           "appVO.storeUrl":storeUrl,
                     "appVO.pricePercent":pricePercent,  "appVO.clickPercent":clickPercent, "appVO.showPercent":showPercent
                     },
                function(response){
	                if(response==-1){
	                    showMiddle("System Error");
	                }else{
	                    showMiddle("Success");
	                }
            })
        }else{
	        var urls =   "<%=request.getContextPath()%>/publisher/app!appSave";
	        post(urls, 
	        		{   "appVO.id":id,             "appVO.name":name,                "appVO.platform":platform,           
		                "appVO.iab1":iab1,         "appVO.iab2":iab2,                "appVO.publisherId":publisherId,
		                "appVO.dsps":dsps,         "appVO.packageName":packageName,  "appVO.dspOpType":dspOpType,
		                "appVO.url":url,           "appVO.storeUrl":storeUrl,        
		                "appVO.pricePercent":pricePercent,  "appVO.clickPercent":clickPercent, "appVO.showPercent":showPercent
                });
        }
    }
    
    function selIAB2(iab1) {
        if(iab1 != 0) {
            jQuery("#iab2").html('<option value="0">--IAB2--</option>');
            url = "<%=request.getContextPath()%>/system/getAllIAB2";
            jQuery.post(url,{"nameVO.name":iab1},
            function(response){
            	jQuery("#iab2").html(jQuery.trim(response));
                if(iab2!=0 && typeof(iab2)!="undefined"){
                    $("#iab2").val(iab2).trigger("change");
                }else{
                    $("#iab2").val(0).trigger("change");
                }
            });
        } else {
            jQuery("#iab2").html('<option value="0">--IAB2--</option>');
        }
    }
    
</script>
<script src="<%=request.getContextPath()%>/js/ajaxselect2Data.js"></script>
</body>
</html>