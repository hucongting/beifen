<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Phone SMS</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	   //短信后倒计时
	  var countdown=60;
	  function settime(obj) {
	    if (countdown == 0) {
	      $(obj).attr("disabled",false);
	      $(obj).attr("mark","1");
	      $(obj).val("获取验证码");
	      countdown = 60;
	      return;
	    } else {
	    	if(countdown == 60){
	    		var phone = $("#phone").val();
	    		$.post("sendSMS?phone="+phone);
	    	}
	      $(obj).attr("disabled", true);
	      $(obj).attr("mark","0");
	      $(obj).val("重新发送(" + countdown + ")");
	      countdown--;
	    }
	    setTimeout(function() {settime(obj) },1000);
	  };
	  
	  
	  //验证输入框和短信验证
	  $(function(){
		  $("#btnyz").click(function(){
			  var yzm = $("#yzm").val();
			  var phone = $("#phone").val();
			  $.post("validateCode?yzm="+yzm+"&phone="+phone,function(result){
				  if(result == "false"){
				  	$("#meg").html("验证码错误");
				  }else{
					  window.location.href="success.jsp";
				  }
			  });
		  });
	  });
	  
</script>


</head>
<body>
	<!-- ${pageContext.request.contextPath }/sendSMS -->
	<form method="POST">
		<input type="text" id="phone" name="phone"/>
		<input type="button" id="btn" value="发送短信验证码" onclick="settime(this)" /><br>
		<input type="text" id="yzm" name="yzm">
		<input type="button" id="btnyz" value="开始验证" /><br>
		<div id="meg"></div>
		
	</form>
</body>
</html>