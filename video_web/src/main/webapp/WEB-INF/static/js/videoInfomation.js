$(function()
{
	//初始化分页按钮开关
	var flag=1;
	
	//分页按钮加载
	var	 createPage=function(pageCount,current)
	{
		$(".tcdPageCode").createPage({
		        pageCount:pageCount,
		        current:current,
		        backFn:function(p){
		            console.log(p);
		            getVideoPage(p);
		        }
		    });
	};

	//加载视频数据
	 var getVideoPage=function(indexPage)
	 {
		
		 $.ajax({
	         type: "GET",
	         url: "/video_web/videoInfomationController/getVideo?pageIndex="+indexPage,
	         dataType: "json",
	         success: function(data){
	        	
	        	 $("#video_tbody").html("");
	        	 var tr='';
	        	 for(var i=0;i<data.listVideoInfomation.length;i++)
	        		 {
	        		 	tr+="<tr><td><a href='"+data.listVideoInfomation[i].videoId+"'>"+data.listVideoInfomation[i].videoName+"</a></td><td><img src='"+data.listVideoInfomation[i].videoImage+"' /></td></tr>";
	        		 
	        		 }
	        		
	    		    $("#video_tbody").append(tr);
	        		if(flag)
	        			{
	        			createPage(data.pageCount,data.current);
	        			flag=0;
	        			}
	        	
	             
	                  }
		 
	     });
	
	 };
	getVideoPage(1);
	
		
			
		
		 //分页按钮

});