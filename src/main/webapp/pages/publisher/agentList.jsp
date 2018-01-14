<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:bean id="Option" name="com.kkgame.adx.tag.action.Option"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
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
                                    <h4 class="page-title">Manage Agent</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Publisher
                                        </li>
                                        <li class="active">
                                            Manage Agent
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box table-responsive">
                                    <h4 class="m-t-0 header-title"><b>search</b></h4>
                                    <div class="row">
			                            <div class="col-sm-12">
			                                <form class="form-inline">
			                                    <div class="form-group m-r-10">
			                                        <label for="exampleInputName2">ID</label>
			                                        <input type="text" class="form-control" id="id" placeholder="Id"
			                                            onkeyup="this.value=this.value.replace(/\D/g,'')">
			                                    </div>
			                                    <div class="form-group m-r-10">
			                                        <label for="exampleInputEmail2">Name</label>
			                                        <input type="text" class="form-control" id="name" placeholder="Name"
			                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
			                                    </div>
			                                    <div class="form-group m-r-10">
                                                    <label for="exampleInputEmail2">Email</label>
                                                    <input type="text" class="form-control" id="email" placeholder="Email"
                                                        onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
                                                </div>
                                                <div  style="width: 20%;display: -webkit-inline-box;">
                                                    <label for="exampleInputEmail2"  style="margin: 10px 5px 0 -5px ;">Status</label>
													<div style="width:70%;">
	                                                    <s:select id="status" cssClass="form-control select2"
	                                                    list="#Option.userStatus" listKey="key" listValue="value">
	                                                    </s:select>
													</div>
												</div>
                                                <div class="form-group m-r-10">
                                                    <button type="button" onclick="searchAgent()" class="btn btn-primary waves-effect waves-light btn-md">
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
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Status</th>
                                            <th>CreateTime</th>
                                            <th>Operation</th>
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
</div>
<script type="text/javascript">
$("#menu-0,#menu-0 a").addClass("active");
</script>

<script type="text/javascript">
    
    

    $("#status").select2();
//     $("#status").removeClass("select2-hidden-accessible");
    
    
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
               "url":"<%=request.getContextPath()%>/publisher/agent!agentList",
               "data":function(d){
                   d.id=$("#id").val();
                   d.name=$("#name").val();
                   d.email=$("#email").val();
                   d.status=$("#status").val();
               }
           },
           columns: [//对应上面thead里面的序列
               { data: "id" },
               { data: "name" },
               { data: "email" },
               { data: "statusName" },
               { data: "createTime" },
               { data: "status" }, //占位
           ],
           columnDefs:[
                       {
               targets: 5,
               render: function (data, type, row, meta) {
                   var returnString = '<a type="button" class="btn btn-info" onclick=updateAgentVO(' + row.id + ') >Edit</a>';
                   if(row.status==0){
                	   returnString +=  '<a type="button" class="btn btn-success"  href="#" onclick=updateAgentStatus(' + row.id + ',1) >Approve</a>'+
                       '<a type="button" class="btn btn-danger "  href="#" onclick=updateAgentStatus(' + row.id + ',2) >Deny </a>';
                   }else if(row.status==1){
                	   returnString +=   '<a type="button" class="btn btn-danger"  href="#" onclick=updateAgentStatus(' + row.id + ',3) >Block </a>';
                   }else if(row.status==2){
                	   returnString +=   '<a type="button" class="btn btn-success "  href="#" onclick=updateAgentStatus(' + row.id + ',1) >Approve</a>';
                   }else if(row.status==3){
                	   returnString +=   '<a type="button" class="btn btn-success "  href="#" onclick=updateAgentStatus(' + row.id + ',1) >Approve</a>';
                   }
                   return returnString;
               }
           },
               { "orderable": false, "targets": 5 },
           ],
      });
    });
    
    function updateAgentVO(id){
    	post('<%=request.getContextPath()%>/publisher/agent!agentUpdatePage', {"agentVO.id":id});
    }
    
    function updateAgentStatus(id,status){
        var url = "<%=request.getContextPath()%>/publisher/agent!agentUpdateStatus";
        
        $.post(url,{"agentVO.id":id,"agentVO.status":status},function(rs){
        	if(rs == 1){
        		showMiddle("Success");
        	}else{
        		showMiddle("Fail");
        	}
        	table.ajax.reload(null,false);
        })
    }
    
    function searchAgent(){
    	table.ajax.reload(null,false);
    }
    
    
</script>
</body>
</html>