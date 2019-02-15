<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/video_web/static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/video_web/static/js/videoinfomationAdd.js"></script>
<script type="text/javascript" src="/video_web/static/js/upload.js"></script>

</head>
<body>
	<form  method="post" id="videoAddForm">
	视频名称<input type="text" name="videoName" />
	
	

	<div id="drop_area"></div>
	<input type="text" id="videoAdd_img_url" name="videoImage" />

	视频链接<input type="text" name="videoUrl"/>
	<br />
	电影类型<select id="video_add_type" name="typeId"></select>
	<br />
	<input type="button" id="videoAdd_btn" value="添加"/>
	</form>
</body>
</html>