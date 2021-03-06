<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script src="js/jquery-1.10.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/vue.js"></script>
    <script>
        $(document).ready(function(){
	
            var app1 = new Vue({
                el: "#app1",
                data:{
                    ulist:[]
                },
                methods:{
                    // 检索点击
                    search:function(){
                        // jquery发ajax
                        var that = this;
                        $.ajax({
                        	url:'search.action',
                            type:'get',
                            data:$("#form1").serialize(),
                            dataType:'json',
                            async:false,
                            success:function(data){
                                    // data就是response的 字符串数据： json
                                that.ulist = data;
                            },
                            error:function(){
                                alert("服务器有问题")
                            }
                        });

                    }

                }

            });

			$.get('search.action', null, function(data){
                // data就是response的 字符串数据： json
                app1.ulist = data;
            }, "json");

        });



    </script>
</head>
<body>
<div class="container-fluid"  id="app1">
    <div style="width: 600px;margin: 0px auto">
    <form class="form-horizontal" id="form1">
        <div class="form-group">
            <label for="uname">用户名</label>
            <input type="text" name="uname" id="uname" class="form-control" />
        </div>
        <div class="form-group">
            <label for="psd">密码</label>
            <input type="text" name="password" id="psd" class="form-control" />
        </div>
        <div class="form-group">
            <a class="btn btn-primary" id="pwd" @click="search">查询</a>

        </div>
    </form>
    </div>
    <hr />
    <div>
        <table class="table table-bordered ">
              <tr>
                  <th>id</th>
                  <th>uname</th>
                  <th>password</th>
              </tr>
              <tr v-for="item in ulist">
                    <td>{{item.id}}</td>
                    <td>{{item.uname}}</td>
                    <td>{{item.password}}</td>
            
				<td style="text-align:center">
							<div class="btn-group btn-xs">
								<button type="button" class="btn btn-default btn-xs dropdown-toggle" id="dropdownMenu" data-toggle="dropdown">
									操作
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li>
										<a :href="'updateUserInfo.action?id=' + item.id">修改用户信息
										</a>
									</li>
									<li>
										<a :href="'delete.action?id=' + item.id">删除</a>
									</li>
								</ul>
							</div>
						</td>
						</tr>
        </table>

    </div>
</div>


</body>
</html>