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
                                    <h4 class="page-title">Manage Adver</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            Adver
                                        </li>
                                        <li class="active">
                                            Manage Adver
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
                                                    <label for="exampleInputEmail2" style="margin:10px 5px 0 0;">BD</label>
                                                    <div style="width:70%">
	                                                    <s:select id="amId" list="employeeList" name="dspVO.employeeId" listKey="id" listValue="name" cssClass="select2" headerKey="0" headerValue="--All--"></s:select>
                                                    </div>
                                                </div>
			                                    <div style="width: 20%;display: -webkit-inline-box;">
                                                    <label for="exampleInputEmail2" style="margin: 10px 5px 0 -30px ;">Status</label>
                                                    <div style="width:70%">
	                                                    <s:select id="status" list="#{'0':'Pending','1':'Approve','2':'Deny','3':'Block' }" cssClass="form-control select2" headerKey="-1" headerValue="--All--"></s:select>
                                                    </div>
                                                </div>
                                                <div class="form-group m-r-10">
                                                    <button type="button" onclick="searchAdver()" class="btn btn-primary waves-effect waves-light btn-md">
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
                                            <th>Company</th>
                                            <th>QQ</th>
                                            <th>Email</th>
                                            <th>Country</th>
                                            <th>Status</th>
                                            <th>BD</th>
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
$("#menu-3,#menu-3 a").addClass("active");
$("#menu-3 ul").addClass("in");
$("#menu-3-1,#menu-3-1 a").addClass("active");
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
               "url":"<%=request.getContextPath()%>/adver/pageList",
               "data":function(d){
                   d.id=$("#id").val();
                   d.name=$("#name").val();
                   d.email=$("#email").val();
                   d.amId=$("#amId").val();
                   d.status=$("#status").val();
               }
           },
           columns: [//对应上面thead里面的序列
               { data: "id" },
               { data: "name" },
               { data: "phone" },
               { data: "company" },
               { data: "qq" },
               { data: "email" },
               { data: "country" },
               { data: "statu" },
               { data: "amName" },
               { data: "status" },
           ],
           columnDefs:[
                       {
               targets: 9,
               render: function (data, type, row, meta) {
            	   var returnString = '<a type="button" class="btn btn-info" onclick=updateAdverVO(' + row.id + ') >Edit</a>';
            	   debugger
            	   if(row.status==0){
                	   returnString +=  '<a type="button" class="btn btn-success" onclick=updateAdverStatus(' + row.id + ',1) >Approve</a>'+
                       '<a type="button" class="btn btn-danger "  onclick=updateAdverStatus(' + row.id + ',2) >Deny </a>';
                   }else if(row.status==1){
                	   returnString +=   '<a type="button" class="btn btn-danger" onclick=updateAdverStatus(' + row.id + ',3) >Block </a>';
                   }else if(row.status==2){
                	   returnString +=   '<a type="button" class="btn btn-success " onclick=updateAdverStatus(' + row.id + ',1) >Approve</a>';
                   }else if(row.status==3){
                	   returnString +=   '<a type="button" class="btn btn-success " onclick=updateAdverStatus(' + row.id + ',1) >Approve</a>';
                   }
                   return returnString;
               }
           },
               { "orderable": false, "targets": 9 },
           ],
      });
    });
    
    function updateAdverVO(id){
    	post('<%=request.getContextPath()%>/adver/update', {"adverVO.id":id});
    }
    
    function searchAdver(){
    	table.ajax.reload();
    }
    
    function updateAdverStatus(id,status){
    	debugger
        var url = "<%=request.getContextPath()%>/adver/updateStatus";
        $.post(url,{"adverVO.id":id,"adverVO.status":status},function(rs){
        	if(rs == 1){
        		showMiddle("Success");
        	}else{
        		showMiddle("Fail");
        	}
        	table.ajax.reload();
        })
    }
</script>
</body>
</html>