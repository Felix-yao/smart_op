<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%>
<s:bean id="Option" name="com.kkgame.adx.tag.action.Option"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" />
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
                                    <h4 class="page-title">银饰</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                        </li>
                                        <li class="active">
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box table-responsive">
                                    <h4 class="m-t-0 header-title"><b></b></h4>
                                    <div class="row">
			                            <div class="col-sm-12">
			                                <form class="form-inline">
			                                    <div class="form-group">
			                                        <label for="exampleInputName2" class="col-md-3 control-label">Date</label>
			                                        <div class="col-md-8">
				                                        <div class="form-control" style="padding:0">
									                  		<div style="width:46%;float:left;height:100%;">
										                  		<input type="text" name="silverDataVO.startTime" id="startDate" readonly="true" style="padding-left:10px;border-radius: 0;width:100%;height:100%;border:1px solid #d2d6de;border-bottom:none;border-top:none;border-left:none;">
									                  		</div>
									                  		<span style="float:left;height:100%;padding-top:7px;background-color: #64c5b1 !important;color:white;">
															   &nbsp;  &nbsp;to&nbsp; &nbsp; 
									                  		</span>
									                  		<div style="overflow:hidden;height:100%;">
															<input type="text" name="silverDataVO.endTime" id="endDate" readonly="true" style="padding-left:10px;border-radius: 0;width:100%;height:100%;border:1px solid #d2d6de;border-bottom:none;border-top:none;border-right:none;">		
									                  		</div>
									                  	</div>
			                                        </div>
			                                    </div>
                                                <div class="form-group m-r-10">
                                                    <button type="button" onclick="search()" class="btn btn-primary waves-effect waves-light btn-md">
	                                                   search
	                                                </button>
                                                </div>
			                                    
			                                </form>
			                            </div>
			                        </div>
			                        <div class="row" style="height: 20px"></div>

                                    <table id="datatable" class="table table-striped table-bordered">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>名字</th>
                                            <th>状态</th>
                                            <th>时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- 中心内容  end-->
                    </div> <!-- container -->
                </div> <!-- content -->
            </div>
            
            <!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content" >
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title" id="myModalLabel"></h4>
						</div>
						<div class="modal-body" id="showDetail">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" onclick="updateLogisticsNumber()">提交</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
</div>

<script src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
	$("#menu-5,#menu-5 a").addClass("active");
	$("#menu-5 ul").addClass("in");
	$("#menu-5-1,#menu-5-1 a").addClass("active");
	$(function(){
		$(".select2").select2();
		if ($("#bdId").length == 0) {
			$("#labelcountry").css("margin","10px 5px 0 0px");
		}
	})

	var dateNow = getNowFormatDate();
	$('#endDate,#startDate').datepicker({
	      autoclose: true,
	  	  format:'yyyy-mm-dd',
	      setDate:dateNow
	    });
	$("#endDate,#startDate").datepicker("setDate", dateNow);
/* $(document).ready(function(){  
	$(".select2.select2-container.select2-container--default.select2-container--above.select2-container--focus").css("width","184px !important")
  }) */
</script>

<script type="text/javascript">
    
	var table ;
    $(document).ready(function() {
     table=$("#datatable").DataTable({
           searching:false,
           serverSide: true,//分页，取数据等等的都放到服务端去
           processing: true,//载入数据的时候是否显示“载入中”
           pageLength: 10,//首次加载的数据条数
           iDisplayLength:"10",
           dom: 'T<"clear">lfrtip',
           ajax:{
               "url":"<%=request.getContextPath()%>/data/silverData",
               "data":function(d){
            	   d.startDate = $("#startDate").val();
            	   d.endDate = $("#endDate").val();
               }
           },
           columns: [//对应上面thead里面的序列
               { data: "id" },
               { data: "name" },
               { data: "status" },
               { data: "createTime" },
           ],
           columnDefs:[
				{
				    targets: 2,
				    render: function (data, type, row, meta) {
				 	   var returnString ="";
				 	    if(row.status==3){
				     	   	returnString =  '已发货';
				        }else if(row.status==4){
				     	   	returnString =  '已拒签';
				        }else{
				        	returnString =  '发货中';
				        }
				        return returnString;
			    }
			        /* CASE Status WHEN 0 THEN '待发货' WHEN 1 THEN '已发货' WHEN 2 THEN '已取消' END statusName, */
				},
           ],
      });
    });
    
    function search(){
    	table.ajax.reload();
    }
    
    function updateStatus(id,status){
        var url = "<%=request.getContextPath()%>/watchInfo/updateStatus";
        $.post(url,{"silverVO.id":id,"silverVO.status":status},function(rs){
        	if(rs != -1){
        		showMiddle("Success");
        	}else{
        		showMiddle("Fail");
        	}
        	table.ajax.reload();
        })
    }
    
    function updateLogisticsNumberPage(id,status){
    	var url = "<%=request.getContextPath()%>/order/silvereditLogisticsNumberPage";
        $.post(url,{"silverVO.id":id},function(rs){
        	debugger
        	if(rs != -1){
        		jQuery("#showDetail").html(jQuery.trim(rs));
        	}else{
        		showMiddle("Fail");
        	}
        })
        $('#myModal').modal({
			keyboard: true
		});
    }
    
    function updateLogisticsNumber(){
    	var id = $("#silverVOId").val();
    	var logisticsNumber = $("#logisticsNumber").val();
    	var url = "<%=request.getContextPath()%>/order/silverupdateLogisticsNumber";
        $.post(url,
        	{"silverVO.id":id,"silverVO.logisticsNumber":logisticsNumber},
        	function(rs){
	        	if(rs != -1){
	        		showMiddle("Success");
	        	}else{
	        		showMiddle("Fail");
	        	}
        });
        table.ajax.reload();
    }
    
    function getLogisticsNumber(id){
    	var url = "<%=request.getContextPath()%>/order/silverlogisticsNumberInfoPage";
        $.post(url,{"silverVO.id":id},function(rs){
        	debugger
        	if(rs != -1){
        		jQuery("#showDetail").html(jQuery.trim(rs));
        	}else{
        		showMiddle("Fail");
        	}
        })
        $('#myModal').modal({
			keyboard: true
		});
    }

   	</script>
</body>
</html>