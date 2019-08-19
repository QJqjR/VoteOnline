<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta charset="UTF-8">
    <link rel="stylesheet" href="css/basic.css">
    <link rel="stylesheet" href="css/addvote.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <title>AddOption</title>
</head>
<body>
    <nav id="nav">
        <section class="cen">
        <h1 class="logo"></h1>
               <ul class="link">
                <li ><a href="index.jsp">图文投票</a></li>	
                <li><a href="videoVote.jsp">视频投票</a></li>
                <li><a href="musicVote.jsp">音乐投票</a></li>
                <li class="active"><a href="#">发起投票</a></li>
                <li><a href="myVote.jsp">我的投票</a></li>
                <li><a href="login.jsp">登录</a></li>
                <li><a href="register.jsp">注册</a></li>
            </ul>
        </section>
    </nav>
    <div id="tour">
         <!-- 标题 -->
             <section class="center">
                       <br><br><br>
                    </section>  
                    <!-- 1 -->
                    <figure>
                       <form action="addOption" method="post">
                        <div style="padding-left: 100px;padding-top: 50px">
                      
                          <c:if test="${sessionScope.userStatus ==0}">
    						<h3>您还没有发布投票的权限，点击<a href="#">申请权限！！</a></h3>
   						 </c:if>
    						<c:if  test="${sessionScope.userStatus !=0}"> 
                                <div>
                                        投票主题：<input type="text" style="height: 35px;width:500px;" name="stype" id="stype"><br>
                                    </div>
                                    <div>
                                    	<br>封面图片：<input type="file" style="height: 35px;width:500px;"><br>
                                    </div>
                                    <br>
                                    <div>
                                        投票类别：<select style="height: 35px;width:500px;" name="sselect" value="sselect">
                                                  <option value="tuwen" >图文投票</option>
                                                  <option value="video">视频投票</option>
                                                  <option value="music">音频投票</option>
                                                 </select>
                                    </div>
                                    <br>
                                    <div class="selects">
                                        <div class="select">
                                                选&nbsp;项&nbsp;&nbsp;：<input type="text" style="height: 35px;width:500px;" name="sDescription" id="sDescription"><br><br>
                                                添加文件：<input type="file" style="height: 35px;width:500px;" name="sfile" id="sfile"><br><br>
                                        </div>
                               
                                      <div class="select">
                                                选&nbsp;项&nbsp;&nbsp;：<input type="text" style="height: 35px;width:500px;" name="sDescription" id="sDescription"><br><br>
                                                添加文件：<input type="file" style="height: 35px;width:500px;" name="sfile" id="sfile"><br><br>
                                        </div>

                                    
                                    </div>
                                    <div>
                                            <br><br>
                                            <input type="submit" value="提交" style="margin-left: 50px;margin-right: 20px;height: 35px; width: 150px;background-color: cornflowerblue">
                                            <input type="button" value="增加选项" style="width: 150px;height: 35px;margin-right: 20px; width: 150px;background-color: lightblue" id="more-active" onclick="ready()">
                                            <input type="button" value="删除选项" style="width: 150px;height: 35px;margin-right: 20px; width: 150px;" id="delete-parent" onclick="checkDelete(this)">
                                    </div>
                        </div>
                           </c:if>
                        </form>
                          
                        </figure>
                  
                </div>
            
                
                <script src="js/jquery-1.11.0.min.js"></script>
                <script> //点击更多加载一个选项
                    var selectid=3;    
                    $(document).ready(function() {
                        $("#more-active").click(function() {
                            //console.log("more-active:"+selectid);
                            var html  = `
                            <div class="select">
                                                选&nbsp;项&nbsp;&nbsp;：<input type="text" style="height: 35px;width:500px;" name="sDescription" id="sDescription"><br><br>
                                                添加文件：<input type="file" style="height: 35px;width:500px;" name="sfile" id="sfile"><br><br>
                                        </div>
                               
                            `;
                            console.log(html);
                           $('.selects').append(html);
                        })
                    });
                    
                    </script>
                    <script>
                    //删除选项
                       function checkDelete(obj){
                           var s = $('.select');
                           console.log(s);
                               s.eq(s.length-1).remove();
                        }
                    </script>
               
                <footer id="footer">
                        <!-- 说明				 -->
                        <div class="top">
                            <div class="block left">
                                <h2>合作伙伴</h2>
                                <hr>
                                <ul>
                                    <li><a>途牛旅游网</a></li>
                                    <li><a>驴妈妈旅游网</a></li>
                                    <li><a>携程旅游</a></li>
                                    <li><a>中国青年旅行社</a></li>
                                    </ul>
                            </div>
                            <div class="block middle">
                                <h2>旅游FAQ</h2>
                                <hr>
                                <ul>
                                    <li><a>旅游合同签订方式？</a></li>
                                    <li><a>儿童价是基于什么制定的？</a></li>
                                    <li><a>旅游的线路品质怎么界定的？</a></li>
                                    <li><a>单房差是什么？</a></li>
                                    <li><a>旅游保险有那些种类？</a></li>
                                    </ul>
                            </div>
                            <div class="block right">
                                <h2>联系方式</h2>
                                <hr>
                                <ul>
                                    <li><a>微博：weibo.com/ycku</a></li>
                                    <li><a>邮件：ycku@ycku.com</a></li>
                                    <li><a>地址：江苏盐城无名路123号</a></li>
                                    </ul>
                            </div>
                            </div>
                            <!-- 底部 -->
                        <div class="botton">
                            Copyright © YCKU 瓢城旅行社 | 苏ICP备120110119号 | 旅行社经营许可证：L-YC-BK12345
                        </div>
                    </footer>
                    </body>
</html>
