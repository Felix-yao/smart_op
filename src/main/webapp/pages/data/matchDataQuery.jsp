<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:bean id="Option" name="com.kkgame.adx.tag.action.Option"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/datepicker3.css">
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
                                    <h4 class="page-title">Match Report</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Report
                                        </li>
                                        <li class="active">
                                            Match Report
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box table-responsive" style="height:auto;">
                                    <h4 class="m-t-0 header-title"><b>search</b></h4>
                                    <div class="row">
			                            <div class="col-sm-12" style="width: 80%;padding-left: 20%;">
			                                <form class="form-horizontal">
			                                    <div class="form-group">
			                                        <label for="exampleInputName2" class="col-md-3 control-label">Date</label>
			                                        <div class="col-md-8">
				                                        <div class="form-control" style="padding:0">
									                  		<div style="width:46%;float:left;height:100%;">
										                  		<input type="text" name="billSearchVO.startTime" id="startDate" readonly="true" style="padding-left:10px;border-radius: 0;width:100%;height:100%;border:1px solid #d2d6de;border-bottom:none;border-top:none;border-left:none;">
									                  		</div>
									                  		<span style="float:left;height:100%;padding-top:7px;background-color: #64c5b1 !important;color:white;">
															   &nbsp;  &nbsp;to&nbsp; &nbsp; 
									                  		</span>
									                  		<div style="overflow:hidden;height:100%;">
															<input type="text" name="billSearchVO.endTime" id="endDate" readonly="true" style="padding-left:10px;border-radius: 0;width:100%;height:100%;border:1px solid #d2d6de;border-bottom:none;border-top:none;border-right:none;">		
									                  		</div>
									                  	</div>
			                                        </div>
			                                    </div>
			                                    <div class="form-group">
                                                    <label for="exampleInputName2" class="col-md-3 control-label">Publisher</label>
                                                    <div class="col-md-8">
                                                            <select id="publisherId" class="form-control select2"
                                                                name="adPositionVO.publisherId" >
                                                            </select>
                                                    </div>
                                                </div>
			                                    <div class="form-group">
                                                    <label for="exampleInputName2" class="col-md-3 control-label">APP</label>
                                                    <div class="col-md-8">
                                                            <select id="appId" class="form-control select2"
                                                                name="adPositionVO.appId" >
                                                            </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputName2" class="col-md-3 control-label">ADPosition</label>
                                                    <div class="col-md-8">
                                                            <select id="adPositionId" class="form-control select2"
                                                                name="adPositionVO.adPositionId" >
                                                            </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputName2" class="col-md-3 control-label">Country</label>
                                                    <div class="col-md-8">
                                                            <select id="countryId" class="form-control select2"
                                                                name="adPositionVO.adPositionId" >
                                                            </select>
                                                    </div>
                                                </div>
			                                    <div class="form-group">
			                                        <label for="exampleInputEmail2" class="col-md-3 control-label">Rows</label>
			                                        <div class="col-md-8 form-inline">
		                                                <div class="checkbox checkbox-custom checkbox-circle">
	                                                        <input id="datebox" type="checkbox" name="searchVO.rowFields"  value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_DATE" />" checked="checked">
		                                                    <label for="datebox">Date</label>
		                                                </div>
		                                                <div class="checkbox checkbox-custom checkbox-circle">
                                                            <input id="publisherbox" type="checkbox" name="searchVO.rowFields"  value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_PUBLISHER" />">
                                                            <label for="publisherbox">Publisher</label>
                                                        </div>
                                                        <div class="checkbox checkbox-custom checkbox-circle">
                                                            <input id="appbox" type="checkbox" name="searchVO.rowFields"  value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_APP" />" >
                                                            <label for="appbox">APP</label>
                                                        </div>
                                                        <div class="checkbox checkbox-custom checkbox-circle">
                                                            <input id="adpositionbox" type="checkbox" name="searchVO.rowFields"  value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_ADPOSITION" />" >
                                                            <label for="adpositionbox">ADPosition</label>
                                                        </div>
                                                        <div class="checkbox checkbox-custom checkbox-circle">
                                                            <input id="countrybox" type="checkbox" name="searchVO.rowFields"  value="<s:property value="@com.kkgame.adx.data.bean.RowFieldVO@ROW_FIELD_COUNTRY" />" >
                                                            <label for="countrybox">Country</label>
                                                        </div>
			                                        </div>
			                                    </div>
                                                <div class="form-group" style="text-align: center;">
                                                    <button type="button" onclick="searchList()" class="btn btn-custom waves-light waves-effect btn-md">
	                                                   search
	                                                </button>
                                                    <button type="button" onclick="resetForm()" class="btn btn-default waves-effect btn-md">
	                                                   reset
	                                                </button>
                                                </div>
			                                    
			                                </form>
			                            </div>
			                        </div>
                                </div>
                            </div>
                        </div>
                        <!-- datatable -->
						<div class="row" id = "dataList">
						</div>
                        <!-- 中心内容  end-->
                    </div> <!-- container -->
                </div> <!-- content -->
            </div>
</div>
<script src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
	$("#menu-5,#menu-5 a").addClass("active");
	$("#menu-5 ul").addClass("in");
	$("#menu-5-4,#menu-5-4 a").addClass("active");
	
	$(function(){
		var dateNow = getNowFormatDate();
		$('#endDate,#startDate').datepicker({
		      autoclose: true,
		  	  format:'yyyy-mm-dd',
		      setDate:dateNow
		    });
		$("#endDate,#startDate").datepicker("setDate", dateNow);
	})
	
	function resetForm(){
		var dateNow = getNowFormatDate();
		$("#endDate,#startDate").datepicker("setDate", dateNow);
	}
	
	function searchList() {
        if($("#startDate").val() == "") {
            showInfoToastMiddle("start Date invalid");
            $("#startDate").focus();
            return false;
        }
        if($("#endDate").val() == "") {
            showInfoToastMiddle("end date invalid");
            $("#endDate").focus();
            return false;
        }
        var startDate = $("#startDate").val();
        var endDate = $("#endDate").val();
        if(startDate!="" && endDate!="") {
            var date1 = startDate.split("-");
            var date2 = endDate.split("-");          
            var myDate1 = new Date(date1[0],date1[1]-1,date1[2]);
            var myDate2 = new Date(date2[0],date2[1]-1,date2[2]);
                if (myDate1 > myDate2) {
                    showInfoToastMiddle("date invalid！");
	                return false;
                } 
        }       
        var publisherId     =   $("#publisherId").val();
        var appId           =   $("#appId").val();
        var adPositionId    =   $("#adPositionId").val();
        var countryId       =   $("#countryId").val();
        
        if('undefined'==typeof(publisherId)) {
        	publisherId=0;
        }
        if('undefined'==typeof(appId)) {
        	appId=0;
        }
        if('undefined'==typeof(adPositionId)) {
        	adPositionId=0;
        }
        if('undefined'==typeof(countryId)) {
        	countryId=0;
        }
        
        var chk_value="";
        $('input[name="searchVO.rowFields"]:checked').each(function(){ 
            chk_value+=$(this).val();
            chk_value+=",";
        });
        if(chk_value=="") {
            showInfoToastMiddle("rows invalid！");
            return false;
        }

        var url="<%=request.getContextPath()%>/data/matchlist";
        jQuery("#dataList").html("");
        jQuery.post(url,{
        	"searchVO.rowFieldString":chk_value
        },
        function(response){
            if(response=="-1") {
                showInfoToastMiddle("error","system error");                
            } else {
                jQuery("#dataList").html(jQuery.trim(response));
            }           
        });
    }
	
</script>
<script src="<%=request.getContextPath()%>/js/ajaxselect2Data.js"></script>
</body>
</html>