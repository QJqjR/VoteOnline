<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/basic.css">
    <link rel="stylesheet" href="css/style.css">
    <title>VideoVote</title>
</head>
<body>
    <nav id="nav">
        <section class="cen">
        <h1 class="logo"></h1>
               <ul class="link">
                <li ><a href="index.jsp">图文投票</a></li>	
                <li class="active"><a href="#">视频投票</a></li>
                <li><a href="musicVote.jsp">音乐投票</a></li>
                <li><a href="AddOption.jsp">发起投票</a></li>
                <li><a href="myVote.jsp">我的投票</a></li>
                <li><a href="login.jsp">登录</a></li>
                <li><a href="register.jsp">注册</a></li>
            </ul>
        </section>
    </nav>
   <div class="container">
       
    </div>
    <form action="findVideo" method="post">
    <div id="search">
        <div class="center">
        <input type="text" class="search" placeholder="请输入旅游景点或城市" name="videoFind"/>
        <button class="button">搜索</button>
          
            <div class="slider">
                <div class="slider_item">
               
                    <span class="slider__caption">20年等待，只为你的到来；20年专业投票，只为你量身定做  </span>
                </div>
            </div>
   
        </div>
    </div>
    </form>
    <div id="tour">
         <!-- 标题 -->
             <section class="center">
                        <h2>Just Pick You,Only For You</h2><br>
                        <p>图文投票、视频投票、音乐投票、礼物投票、累计举办投票活动超过20万次</p><br>
                    </section>
                    
                    <c:if test="${empty requestScope.currentPage }">
					<c:redirect url="video"></c:redirect>
					</c:if>
                    
                    <!-- 1 -->
                    <form action="video" method="post">
                    <c:forEach var="vid" items="${requestScope.videoList}"
							varStatus="i" step="1">
                    <figure>
                        <video id="myVideo" width="340" height="180" poster=${vid.sImage} controls=""> 
                            <source src=${vid.sVideo} type="video/MP4" ></source>
                        </video>
                        <!-- 描述照片 -->
                        <figcaption>
                         <c:if test="${ sessionScope.name!=null}">
                    	 <!-- <a href="videoVote?sessionScope.name"><strong>&lt;${vid.sType}&gt; </strong></a>  -->
                    	 <c:if test="${vid.sId!=12 }">
                    	  <a href="videoVote?sessionScope.name"><strong>&lt;${vid.sType}&gt; </strong></a>
                    	  </c:if>${mus.sId }
                    	  <c:if test="${vid.sId==12 }">
                    	   <a href="showv.jsp"><strong>&lt;${vid.sType}&gt; </strong></a>
                    	  </c:if>
                    	</c:if>
                    	<c:if test="${ sessionScope.name==null}">
                    	  <a href="login"><strong>&lt;${vid.sType}&gt; </strong>
                    	</c:if>
                        </figcaption>
                        <div>
                                <div class="sta">访问人数</div>
                                <div class="price"><strong>${vid.sBrowseTotal}人</strong></div>
                            </div>
                            <div>
                                <div class="sta">参与人数</div>
                                <div class="price"><strong>${vid.sParticipate}人</strong></div>
                            </div>
                            <div>
                                <div class="sta">累计投票数</div>
                                <div class="price"><strong>${vid.sVotetotal}票</strong></div>
                            </div>                       
                        <div class="type">
                            ${vid.sTitle}
                            </div>
                    </figure>
                    </c:forEach>
                 	<div>
                 	  <c:if test="${requestScope.currentPage==1 }">
									<a href="index?currentPage=${currentPage-1}">
										<button class="pageBottom">首页</button></a>
								</c:if>
                 	  <c:if test="${requestScope.currentPage==1 }">
									<a href="index?currentPage=${currentPage-1}">
										<button class="pageBottom">下一页</button></a>
								</c:if> <c:if test="${requestScope.currentPage!=totalPage }">
									<a href="index?currentPage=${currentPage+1}">
										<button class="pageBottom">上一页</button></a>
								</c:if>
                  
					</div>
                   </form>
     </div>
                
                
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