<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/basic.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <title>show</title>
</head>
<body>
    <nav id="nav">
        <section class="cen">
        <h1 class="logo"></h1>
               <ul class="link">
                <li ><a href="index.jsp">图文投票</a></li>	
                <li ><a href="videoVote.jsp">视频投票</a></li>
                <li class="active"><a href="musicVote.jsp">音乐投票</a></li>
                <li><a href="AddOption.jsp">发起投票</a></li>
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
                   
            
                   
                    <figure>
                        <img src="img/loginback.jpg"> 
                        <embed height="25" width="340" src="music/music1.mp3" autostart=false/>
                        <!-- 描述照片 -->
                        <figcaption>
                       	<strong style="padding-left: 50px;">&lt;西沙海底墓&gt; </strong>
                        </figcaption>
                        <div>
                                <div class="sta" ><a href=show1.jsp><i  class="fa fa-heart-o" id="before" onclick="ch()" aria-hidden="true"></i></a></div>

                                <div class="price"><strong>0人</strong></div>
                                  <script>
                        function ch(){
                            var before=document.getElementById('before');
                            before.style.color = "red";
                        }
                    </script>
                            </div>
                    </figure>
                     <figure>
                        <img src="img/loginback.jpg"> 
                        <embed height="25" width="340" src="music/music1.mp3" autostart=false/>
                        <!-- 描述照片 -->
                        <figcaption>
                       	<strong style="padding-left: 50px;">&lt;秦岭神树&gt; </strong>
                        </figcaption>
                        <div>
                                <div class="sta" ><a href=show.html><i  class="fa fa-heart-o" id="before" onclick="ch()" aria-hidden="true"></i></a></div>

                                <div class="price"><strong>0人</strong></div>
                                  <script>
                        function ch(){
                            var before=document.getElementById('before');
                            before.style.color = "red";
                        }
                    </script>
                            </div>
                    </figure>
                     <figure>
                        <img src="img/loginback.jpg"> 
                        <embed height="25" width="340" src="music/music1.mp3" autostart=false/>
                        <!-- 描述照片 -->
                        <figcaption>
                       	<strong style="padding-left: 50px;">&lt;秦岭神树&gt; </strong>
                        </figcaption>
                        <div>
                                <div class="sta" ><a href=show.html><i  class="fa fa-heart-o" id="before" onclick="ch()" aria-hidden="true"></i></a></div>

                                <div class="price"><strong>0人</strong></div>
                                  <script>
                        function ch(){
                            var before=document.getElementById('before');
                            before.style.color = "red";
                        }
                    </script>
                            </div>
                    </figure>
                 
                  
                   </form>
     </div>
               
                <footer id="footer">
                        <!-- 说明-->
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