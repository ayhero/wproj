<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>${title}</title>
</head>
<body>
	<div class="container">
		<div class="row">
		  <div class="col-md-12">
		  	<h4>欢迎</h4>
		  </div>
		</div>
		  
		<div class="row">
		      <div class="col-md-3">
		      	<div class="panel-group" id="accordion">
				  <div class="panel panel-default">
				    <div class="panel-heading">
				      <h4 class="panel-title">
				        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
				          	邮件
				        </a>
				      </h4>
				    </div>
				    <div id="collapseOne" class="panel-collapse collapse in">
				      <div class="panel-body">
					  	<a href="newMail?mail.userFrom=${user.id}" target="content" class="btn btn-block btn-primary">新邮件</a>
					  	<a href="base/success.jsp?mailType=未读邮件" target="content" class="btn btn-block">未读邮件</a>
					  	<a href="mails" target="content" class="btn btn-block">收件箱</a>
					  	<a href="base/success.jsp" target="content" class="btn btn-block">发件箱</a>
				      </div>
				    </div>
				  </div>
				</div>
		      </div>
		      <!-- 中间内容页 -->
		      <div class="col-md-7" style="height:800px;">
		        	<iframe name="content" style="width:100%;height:100%;" frameborder="0">
		        	
		        	</iframe>
		        	
		        	
		        	
		      </div>
		      <div class="col-md-2">
		        	<h4>right side brar</h4>
		      </div>
		    </div>
		</div>
</body>
</html>






