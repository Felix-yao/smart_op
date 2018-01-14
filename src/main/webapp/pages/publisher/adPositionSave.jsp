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
                                    <h4 class="page-title"><s:if test="adPositionVO.id>0">Update</s:if><s:else>Create</s:else> ADPosition</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            ADPosition
                                        </li>
                                        <li class="active">
                                            <s:if test="adPositionVO.id>0">Update</s:if><s:else>Create</s:else> ADPosition
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
                                    <h4 class="m-t-0 header-title"><b><s:if test="adPositionVO.id>0">Update</s:if><s:else>Create</s:else></b></h4>
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
                                                            value='<s:property value="adPositionVO.name"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">App</label>
                                                        <div class="col-md-4">
                                                            <select id="appId" class="form-control select2"
                                                                name="adPositionVO.appId" >
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">AdType</label>
                                                        <div class="col-md-4">
                                                            <select id="adType" class="form-control select2"
                                                                name="adPositionVO.adType" >
                                                                <option value="1">banner</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Size</label>
                                                        <div class="col-md-4">
                                                            <select id="size" class="form-control select2"
                                                                name="adPositionVO.size" >
                                                                <option value="0">--Width--</option>
                                                                <option value="1">320x480</option>
                                                                <option value="2">320x50</option>
                                                                <option value="3">300x250</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">BidPrice</label>
                                                        <div class="col-md-4">
                                                            <input type="text" id="bidPrice" class="form-control" placeholder="BidPrice"
                                                            value='<s:property value="adPositionVO.bidPriceString"/>'
                                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Content Categories</label>
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
                                                                name="adPositionVO.dsp" style="width:50%">
                                                                <option value="0">--IAB2--</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <s:if test="adPositionVO.id>0">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Token</label>
                                                        <div class="col-md-4">
                                                            <div class="form-control form-control-static">
                                                            <s:property value="adPositionVO.token"/></div>
                                                            <div class="form-control-focus"> </div>
                                                        </div>
                                                    </div>
                                                    </s:if>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label"></label>
                                                        <div class="col-md-4">
                                                            <button class="btn btn-primary waves-effect waves-light" 
                                                                    type="button" onclick="savePublisher()">Submit
                                                            </button>
                                                            <a type="button" class="btn btn-default waves-effect m-l-5"
                                                                    href="<%=request.getContextPath()%>/publisher/adPosition!adPositionListPage">
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

    $("#adType").select2();
    $("#iab1").select2();
    $("#iab2").select2();
    $("#size").select2();
    var numBidPrice = $("#bidPrice").val();
    $("#bidPrice").val(new Number(numBidPrice));
    var id = "<s:property value="adPositionVO.id"/>";
    if(id>0){
//      app
        var appId = '<s:property value = "adPositionVO.appId"/>';
        var appName   = '<s:property value = "adPositionVO.appName"/>';
        if(appName != ""){
            $("#appId").append("<option value=0>---App---</option>");
            $("#appId").append("<option value="+appId+">"+appName+"</option>");
        }else {
            $("#appId").append("<option value=0>---App---</option>");
        }
        $("#appId").val(appId).trigger("change");
        // iab
        var iab1 = '<s:property value = "adPositionVO.iab1"/>';
        var iab2 = '<s:property value = "adPositionVO.iab2"/>';
        
        if(iab1 != ""){
        	$("#iab1").val(iab1).trigger("change");
        }
        //AdType
        var adType = '<s:property value = "adPositionVO.adType"/>';
        $("#adType").val(adType).trigger("change");
        
        //size
        var size = '<s:property value = "adPositionVO.size"/>';
        $("#size").val(size).trigger("change");
    }
    //创建app成功后传过来的参数
    var appIdBack = "<s:property value="appVO.id"/>";
    if(appIdBack >0){
	    var appNameBack = "<s:property value="appVO.name"/>";
	    if(appNameBack != ""){
            $("#appId").append("<option value=0>---App---</option>");
            $("#appId").append("<option value="+appIdBack+">"+appNameBack+"</option>");
        }else {
            $("#appId").append("<option value=0>---App---</option>");
        }
        $("#appId").val(appIdBack).trigger("change");
    }
  
    function savePublisher(){
    	
        var name  =  $('#name').val();
        var appId =  $('#appId').val();
        var adType =  $('#adType').val();
        var size =  $('#size').val();
        var bidPrice =  $('#bidPrice').val();
        var iab1 =  $('#iab1').val();
        var iab2 =  $('#iab2').val();
        
        if(name == ""){
            showMiddle("Name Cannot Be Empty");
            $("#name").focus();
            return false;
        }else if(appId == null || appId == 0){
            showMiddle("Please Select appId");
            $("#appId").focus();
            return false;
        }else if(size == 0){
            showMiddle("Please Select size");
            return false;
        }else if(bidPrice == ""){
            showMiddle("BidPrice Cannot Be Empty");
            $("#bidPrice").focus();
            return false;
        }else if(iab1 == 0){
            showMiddle("Please Select iab1");
            $("#iab1").focus();
            return false;
        }else if(iab2 == 0){
            showMiddle("Please Select iab2");
            $("#iab2").focus();
            return false;
        }
        
        $('#submit').attr("disabled",true);
        
        var urls =   "<%=request.getContextPath()%>/publisher/adPosition!adPositionSave";
        $.post(urls,
        		{"adPositionVO.id":id,             "adPositionVO.name":name,      "adPositionVO.appId":appId,           
                 "adPositionVO.adType":adType,     "adPositionVO.size":size,    
                 "adPositionVO.bidPrice":bidPrice, "adPositionVO.iab1":iab1,      "adPositionVO.iab2":iab2
                 },
            function(response){
            if(response==-1){
                showMiddle("System Error");
            }else{
                showMiddle("Success");
                $('#submit').attr("disabled",false);
            }
        })
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