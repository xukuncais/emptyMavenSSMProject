<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
window.onload = function () {
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
    	var path = "ws://localhost:8080/emptyMavenSSMProject/echartsWebSocket";
        websocket = new WebSocket(path);
    }
    else {
        alert('当前浏览器 Not support websocket')
    }
    
    //连接成功建立的回调方法
    websocket.onopen = function () {
        console.log('WebSocket连接成功')
    }
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
    	console.log('接收到服务器信息：'+event.data)
//     	data = JSON.parse(event.data);
    	$("#show").html("websocket接收服务器信息:" + event.data);
    }
    
};

</script>
</head>
<body>
hi ${user.userName}
<div>
	<span id="show"></span>
</div>
</body>
</html>