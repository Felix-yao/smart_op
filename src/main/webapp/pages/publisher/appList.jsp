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
                                    <h4 class="page-title">Manage App</h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            App
                                        </li>
                                        <li class="active">
                                            Manage App
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
			                                    <div style="width: 20%;display: -webkit-inline-box;">
                                                    <label for="exampleInputEmail2" style="margin: 10px 5px 0 0 ;">Status</label>
                                                    <div style="width:70%">
                                                        <select class="form-control select2" id="status">
	                                                        <option value="0">--All--</option>
	                                                        <option value="1">Active</option>
	                                                        <option value="2">Inactive</option>
	                                                    </select>
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
                                            <th>Platform</th>
                                            <th>IAB1</th>
                                            <th>IAB2</th>
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
    	   order: [[ 0, "desc" ]],
           searching:false,
           serverSide: true,//分页，取数据等等的都放到服务端去
           processing: true,//载入数据的时候是否显示“载入中”
           pageLength: 10,//首次加载的数据条数
           iDisplayLength:"10",
           dom: 'T<"clear">lfrtip',
           ajax:{
               "url":"<%=request.getContextPath()%>/publisher/app!appList",
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
               { data: "platformName" },
               { data: "iab1" },
               { data: "iab2" },
               { data: "status" },
               { data: "createTime" },
               { data: "status" }, //占位
           ],
           columnDefs:[
				{
				    targets: 7,
				    render: function (data, type, row, meta) {
				        var returnString = '<a type="button" class="btn btn-info" onclick=updatePublisherVO(' + row.id + ') >Edit</a>';
				        if(row.status==0){
				            returnString +=  '<a type="button" class="btn btn-success"  href="#" onclick=updateAppStatus(' + row.id + ',1) >Active</a>';
				        }else if(row.status==1){
				            returnString +=   '<a type="button" class="btn btn-danger"  href="#" onclick=updateAppStatus(' + row.id + ',2) >Inactive</a>';
				        }else if(row.status==2){
				            returnString +=   '<a type="button" class="btn btn-success "  href="#" onclick=updateAppStatus(' + row.id + ',1) >Active</a>';
				        }
				        return returnString;
				    }
				},
                {
	                targets: 5,
	                render: function (data, type, row, meta) {
	                	var returnString = "";
	                    if(row.status==0){
	                	   returnString +=  "Pending";
	                    }else if(row.status==1){
                   	       returnString +=  "Active";
	                    }else if(row.status==2){
	                    	returnString += "Inactive";
	                    }
	                    return returnString;
	                }
	             },
	                { "orderable": false, "targets": 7 },
	             ],
      });
    });
    
    function updatePublisherVO(id){
    	post('<%=request.getContextPath()%>/publisher/app!appUpdatePage', {"appVO.id":id});
    }
    
    function updateAppStatus(id,status){
        var url = "<%=request.getContextPath()%>/publisher/app!appUpdateStatus";
        $.post(url,{"appVO.id":id,"appVO.status":status},function(rs){
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