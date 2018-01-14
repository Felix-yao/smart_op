<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                                    <h4 class="page-title">Manage Account</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Account
                                        </li>
                                        <li class="active">
                                            Manage Account
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
			                                        <input style="width:120px;" type="text" class="form-control" id="id" placeholder="Id" value="0"
			                                            onkeyup="this.value=this.value.replace(/\D/g,'')">
			                                    </div>
			                                    <div class="form-group m-r-10">
			                                        <label for="exampleInputEmail2">Name</label>
			                                        <input style="width:120px;" type="text" class="form-control" id="name" placeholder="Name"
			                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
			                                    </div>
			                                    <div class="form-group m-r-10">
			                                        <label for="exampleInputEmail2">Email</label>
			                                        <input style="width:120px;" type="text" class="form-control" id="email" placeholder="Email"
			                                            onkeyup="this.value=this.value.replace(/^\s+|\s+$/g,'')">
			                                    </div>
			                                    <div style="width: 20%;display: -webkit-inline-box;">
                                                    <label for="exampleInputEmail2" style="margin: 10px 5px 0 0 ;">Status</label>
                                                    <div style="width:70%">
	                                                    <s:select id="status" list="#{'0':'Pending','1':'Approve','2':'Deny','3':'Block' }" cssClass="form-control select2" headerKey="-1" headerValue="--All--"></s:select>
                                                    </div>
                                                </div>
			                                    <div style="width: 20%;display: -webkit-inline-box;">
                                                    <label for="exampleInputEmail2" style="margin: 10px 5px 0 0 ;">RoleType</label>
                                                    <div style="width:70%">
	                                                    <s:select id="roleType" list="#{'AMA':'BD','AMP':'AM','AM':'OP'}" cssClass="form-control select2" headerKey="" headerValue="--All--"></s:select>
                                                    </div>
                                                </div>
                                                <div class="form-group m-r-10">
                                                    <button type="button" onclick="searchEmployee()" class="btn btn-primary waves-effect waves-light btn-md">
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
                                            <th>Phone</th>
                                            <th>Skype</th>
                                            <th>QQ</th>
                                            <th>Email</th>
                                            <th>Status</th>
                                            <th>RoleType</th>
                                            <th>Manage</th>
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
$("#menu-1,#menu-1 a").addClass("active");
$("#menu-1 ul").addClass("in");
$("#menu-1-1,#menu-1-1 a").addClass("active");
$(function(){
$(".select2").select2();
})
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
               "url":"<%=request.getContextPath()%>/employee/pageList",
               "data":function(d){
                   d.id=$("#id").val();
                   d.name=$("#name").val();
                   d.email=$("#email").val();
                   d.roleType=$("#roleType").val();
                   d.status=$("#status").val();
               }
           },
           columns: [//对应上面thead里面的序列
               { data: "id" },
               { data: "name" },
               { data: "phone" },
               { data: "skype" },
               { data: "qq" },
               { data: "email" },
               { data: "statu" },
               { data: "roleType" },
               { data: "status" },
           ],
           columnDefs:[
                       {
               targets: 8,
               render: function (data, type, row, meta) {
            	   var returnString = '<a type="button" class="btn btn-info" onclick=updateEmployee(' + row.id +',\"' +row.roleType + '\"' +') >Edit</a>';
            	   if(row.status==0){
                	   returnString +=  '<a type="button" class="btn btn-success" onclick=updateEmployeeStatus(' + row.id +',\"' +row.roleType + '\"' + ',1) >Approve</a>'+
                       '<a type="button" class="btn btn-danger "  onclick=updateEmployeeStatus(' + row.id +',\"' +row.roleType + '\"' + ',2) >Deny </a>';
                   }else if(row.status==1){
                	   returnString +=   '<a type="button" class="btn btn-danger" onclick=updateEmployeeStatus(' + row.id +',\"' +row.roleType + '\"' + ',3) >Block </a>';
                   }else if(row.status==2){
                	   returnString +=   '<a type="button" class="btn btn-success " onclick=updateEmployeeStatus(' + row.id +',\"' +row.roleType + '\"' + ',1) >Approve</a>';
                   }else if(row.status==3){
                	   returnString +=   '<a type="button" class="btn btn-success " onclick=updateEmployeeStatus(' + row.id +',\"' +row.roleType + '\"' + ',1) >Approve</a>';
                   }
                   return returnString;
               }
           },
               { "orderable": false, "targets": 8 },
           ],
      });
    });
    
    function updateEmployee(id,roleType){
    	if (roleType == "BD") {
    		roleType = "AMA";
		}else if (roleType == "AM") {
    		roleType = "AMP";
		}else if (roleType == "OP") {
    		roleType = "AM";
		}
    	post('<%=request.getContextPath()%>/employee/update', {"employee.id":id,"employee.roleType":roleType});
    }
    
    function searchEmployee(){
    	table.ajax.reload();
    }
    
    function updateEmployeeStatus(id,roleType,status){
    	if (roleType == "BD") {
    		roleType = "AMA";
		}else if (roleType == "AM") {
    		roleType = "AMP";
		}else if (roleType == "OP") {
    		roleType = "AM";
		}
        var url = "<%=request.getContextPath()%>/employee/updateStatus";
        $.post(url,{"employee.id":id,"employee.roleType":roleType,"employee.status":status},function(rs){
        	if(rs == 1){
        		showMiddle("Success");
        	}else{
        		showMiddle("Fail");
        	}
        	table.ajax.reload(null,false);
        })
    }
</script>
</body>
</html>