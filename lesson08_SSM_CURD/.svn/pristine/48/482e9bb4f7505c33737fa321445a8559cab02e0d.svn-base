<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script src="js/jquery-1.10.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/vue.js"></script>
</head>
<body>
<div class="error">${msg}</div>
<div class="container">
    <form class="form-horizontal" id="form1" action="update.action">
      <div class="form-group">
            <label for="uname">id</label>
            <input type="text" disabled="disabled" id="uname" class="form-control" value="${po.id}" />
            <input name="id" value="${po.id}" type="hidden" />
            <input name="version" value="${po.version}" type="hidden" />
        </div>
        <div class="form-group">
            <label for="uname">用户名</label>
            <input type="text" name="uname" id="uname" class="form-control"  value="${po.uname}" />
        </div>
        <div class="form-group">
            <label for="psd">密码</label>
            <input type="text" name="password" id="psd" class="form-control"  value="${po.password}" />
        </div>
        <div class="form-group">
            <button class="btn btn-primary" id="pwd" >更新</button>

        </div>
    </form>
</div>
</body>
</html>