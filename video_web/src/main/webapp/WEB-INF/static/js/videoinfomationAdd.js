$(function()
{
	//加载视频数据
	 var getVideoType=function()
	 {
		
		 $.ajax({
	         type: "GET",
	         url: "/video_web/videoTyperController/getVideoAll",
	         dataType: "json",
	         success: function(data){
	        	 var str='';
	        	 for(var i=0;i<data.length;i++)
	        		 {
	        		str+="<option name=typeName value='"+data[i].typeId+"'>"+data[i].typeName+"</option>";
	        		 }
	        	
	        	$("#video_add_type").append(str);
	        	console.info(str);
	         }
	     });
	
	 };
	 getVideoType();
	 
	 var dragImgUpload = new DragImgUpload("#drop_area",{
			callback:function (files) {
				//回调函数，可以传递给后台等等
				var file = files[0];
				console.log(file.name);
				var formData = new FormData();
				formData.append('file',file);
				 $.ajax({
			         type: "POST",
			         url: "/video_web/videoInfomationController/photoUpload",
			         data:formData,
			         processData:false,
	                  contentType:false,
	                  cache:false,
			         dataType: "json",
			         success: function(data){
			        		console.info(data);
			        	if(data.code==200)
			        		{
			        		$("#videoAdd_img_url").val(data.msg);
			        		}
			        	
			         }
			     });
			}
		});
	 $("#videoAdd_btn").click(function()
			 {
		 	console.info($('#videoAddForm').serialize());
		 $.ajax({
	                type: "post",
	                dataType: "json",
	                url: "/video_web/videoInfomationController/video_add" ,
	                data: $('#videoAddForm').serialize(),
	                success: function (data) {
	                   
	                    
	                },
	              
	            });
			 });
});