<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <s:bean id="Option" name="com.kkgame.adx.tag.action.Option"/> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>

<body>
	 <div class="col-sm-12">
	      <div class="card-box table-responsive">
	          <table id="datatable" class="table table-striped table-bordered">
	              <thead>
	                  <tr>
                        <s:if test="searchVO.rowFieldVO.isShowDate==1">
                            <th>Date</th>
                        </s:if>
                        <s:if test="searchVO.rowFieldVO.isShowPublisher==1">
                            <th>Publisher</th>
                        </s:if>
                        <s:if test="searchVO.rowFieldVO.isShowApp==1">
                            <th>App</th>
                        </s:if>
                        <s:if test="searchVO.rowFieldVO.isShowADPosition==1">
                            <th>ADPosition</th>
                        </s:if>
                        <s:if test="searchVO.rowFieldVO.isShowCountry==1">
                            <th>Country</th>
                        </s:if>
                        <th>Request</th>
                        <th>Response</th>
                        <th>Ratio(Response/Request)</th>
                        <th>WinNotice</th>
                        <th>WinNoticeRatio</th>
                        <th>Show</th>
                        <th>Click</th>
                    </tr>
	              </thead>
	              <tbody>
	              </tbody>
	          </table>
	      </div>
	  </div>

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
               "url":"<%=request.getContextPath()%>/data/matchpage",
               "data":function(d){
            	   debugger
            	    var chk_value="";
	       		  	$('input[name="searchVO.rowFields"]:checked').each(function(){ 
	       		   		chk_value+=$(this).val();
	       		   		chk_value+=",";
	       		  	});
	       		  	d.startDate = $("#startDate").val();
	       		  	d.endDate =  $("#endDate").val();
	       		  	d.publisherId = $("#publisherId").val();
	       		  	d.appId = $("#appId").val();
	       		  	d.countryId = $("#countryId").val();
	       		  	d.adPositionId = $("#adPositionId").val(); 
	       		  	d.rowFieldString=chk_value;
               }
           },
           columns: [//对应上面thead里面的序列
               <s:if test="searchVO.rowFieldVO.isShowDate==1">
                { data: "statDate" },
               </s:if>
               <s:if test="searchVO.rowFieldVO.isShowPublisher==1">
                { data: "publisherName" },
               </s:if>
               <s:if test="searchVO.rowFieldVO.isShowApp==1">
                { data: "appName" },
               </s:if>
               <s:if test="searchVO.rowFieldVO.isShowADPosition==1">
                { data: "adName" },
               </s:if>
               <s:if test="searchVO.rowFieldVO.isShowCountry==1">
                { data: "countryName" },
               </s:if>
               { data: "sspRequests" },
               { data: "sspSends" },
               { data: "matchRatio" },
               { data: "winNotices" },
               { data: "winNoticesRatio" },
               { data: "realImpressions" },
               { data: "realClicks" }
           ],
           columnDefs:[
   					{
   					    targets: -2,
   					    render: function (data, type, row, meta) {
   					        if (row.realImpressions == undefined) {
   								return "0";
   							}else{
   								return row.realImpressions
   							}
   					    }
   					},
   					{
   					    targets: -1,
   					    render: function (data, type, row, meta) {
   					        if (row.realClicks == undefined) {
   								return "0";
   							}else{
   								return row.realClicks
   							}
   					    }
   					},
               ]
           
      });
    });
    
    
</script>
</body>
</html>