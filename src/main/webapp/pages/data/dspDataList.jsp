<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="col-sm-12">
	<div class="card-box table-responsive">
  		<table id="datatable" class="table table-striped table-bordered">
             <thead>
              <tr>
              	<s:if test="dspDataVO.rowFieldVO.isShowDate==1">
                   <th>Date</th>
              	</s:if>
              	<s:if test="dspDataVO.rowFieldVO.isShowDsp==1">
                   <th>DSP</th>
              	</s:if>
              	<s:if test="dspDataVO.rowFieldVO.isShowCountry==1">
                   <th>Country</th>
              	</s:if>
              	<s:if test="dspDataVO.rowFieldVO.isShowType==1">
                   <th>Type</th>
              	</s:if>
              	<s:if test="dspDataVO.rowFieldVO.isShowWidth==1">
                   <th>Width</th>
              	</s:if>
              	<s:if test="dspDataVO.rowFieldVO.isShowHeight==1">
                   <th>Height</th>
              	</s:if>
                  <th>RequestCount</th>
                  <th>ResponseCount</th>
                  <th>WinNotice</th>
                  <th>ShowCount</th>
                  <th>ClickCount</th>
                  <th>Income</th>
              </tr>
             </thead>
             <tbody>
             </tbody>
         </table>
  	</div>
 </div>
 <script type="text/javascript">
	$(document).ready(function() {
		var table =  $("#datatable").dataTable({
			searching:false,
            serverSide: true,//分页，取数据等等的都放到服务端去
            processing: true,//载入数据的时候是否显示“载入中”
            pageLength: 10,//首次加载的数据条数
            iDisplayLength:"10",
            ajax: {
            	"url":"<%=request.getContextPath()%>/data/dsppage",
            	"data":function(d) {
            		var chk_value="";
        		  	$('input[name="dspdataVO.rowFields"]:checked').each(function(){ 
        		   		chk_value+=$(this).val();
        		   		chk_value+=",";
        		  	});
        		  	d.startDate = $("#startDate").val();
        		  	d.endDate =  $("#endDate").val();
        		  	d.amId = $("#bdId").val();
        		  	d.dspId = $("#dspId").val();
        		  	d.countryId = $("#countryId").val();
        		  	d.type = $("#type").val();
        		  	d.size = $("#size").val();
        		  	d.rowFieldString=chk_value;
            	}
            },	   
            columns: [//对应上面thead里面的序列
                  <s:if test="dspDataVO.rowFieldVO.isShowDate==1">
           		   { data: "statDate" },//字段名字和返回的json序列的key对应
           	   	 </s:if>
                  <s:if test="dspDataVO.rowFieldVO.isShowDsp==1">
           		   { data: "dspName" },//字段名字和返回的json序列的key对应
           	   	 </s:if>
                  <s:if test="dspDataVO.rowFieldVO.isShowCountry==1">
           		   { data: "countryName" },//字段名字和返回的json序列的key对应
           	   	 </s:if>
                  <s:if test="dspDataVO.rowFieldVO.isShowType==1">
           		   { data: "adTypeName" },//字段名字和返回的json序列的key对应
           	   	 </s:if>
                  <s:if test="dspDataVO.rowFieldVO.isShowWidth==1">
           		   { data: "width" },//字段名字和返回的json序列的key对应
           	   	 </s:if>
                  <s:if test="dspDataVO.rowFieldVO.isShowHeight==1">
           		   { data: "height" },//字段名字和返回的json序列的key对应
           	   	 </s:if>
                   { data: "dspRequests" },
                   { data: "dspSends" },
                   { data: "winNotices" },
                   { data: "realImpressions" },
                   { data: "realClicks"},
                   { data: "revenue"},
            ],
            columnDefs:[
					{
					    targets: -2,
					    render: function (data, type, row, meta) {
					        if (row.realClicks == undefined) {
								return "0";
							}else{
								return row.realClicks
							}
					    }
					},
					{
					    targets: -1,
					    render: function (data, type, row, meta) {
					        if (row.revenue == undefined) {
								return "0";
							}else{
								return row.revenue
							}
					    }
					},
            ]
        });
	});
	
	function  convertNUM(beforeCountTest) {  
	     var  tempValueStr =  new  String(beforeCountTest);  
	     if  ((tempValueStr.indexOf('E') != -1) || (tempValueStr.indexOf('e') != -1)){  
	         var  regExp =  new  RegExp( '^((\\d+.?\\d+)[Ee]{1}(\\d+))$', 'ig' );  
	         var  result = regExp.exec(tempValue);  
	         var  resultValue = "";  
	         var  power =  "" ;  
	         if  (result !=  null ){  
	            resultValue = result[2];  
	            power = result[3];  
	            result = regExp.exec(tempValueStr);  
	        }  
	         if  (resultValue !=  "" ) {  
	             if  (power !=  "" ) {  
	                 var  powVer = Math.pow(10, power);  
	                resultValue = resultValue * powVer;  
	            }  
	        }  
	        return resultValue;  
	    } else{
	    	return beforeCountTest;
	    }
	}
	</script>