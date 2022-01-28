<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!-- 공유하기 -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="../resources/js/shareProject.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>teamEResult</title>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/teamE.css">
    
</head>
<body>

<!-- 결과 화면 -->
<div class="result">
	<div class="box">
	<h1 class="text-c">ESFJ <br> 타고난 분위기메이커인 친구</h1>
    <img src="../resources/img/teamE/bar.jpg" class="bar"/>
    <img src="../resources/img/teamE/ESFJ.jpeg" class="main-animal"/>
	</div>
    
    <div class="outer">
    <div class="resultContent">
    <p class="text-d">사람 만나는거 좋아하는 친구</p>
    <p class="text-d">어색한거 못 참는 친구</p>
    <p class="text-d">어디가서 사회생활 못한다는 말 안 듣는 친구</p>
    <p class="text-d">아직 안 일어난 일을 걱정하는 친구</p><br>
    </div>
    </div>
    
	
	<p class="goodRelation">잘 맞는 유형 <br> ISFP <br> <img src="<%=request.getContextPath()%>/resources/img/teamE/ISFP.jpg" class="animals"/> </p>
  
    <p class="badRelation">안 맞는 유형 <br> INFJ <br> <img src="<%=request.getContextPath()%>/resources/img/teamE/INFJ.jpg" class="animals"/> </p> 
    	
    
    <br>
    <button class="btn-result" onclick="location.href='start'">다시하기</button><br>
    <form method="post" action="<%=request.getContextPath()%>/teamE/saved">
				<input name="mbti"id = "mbti" value="ESFJ" style="display: none">
    <button class="btn-result">저장하기</button><br>
    
    <a id="kakao-link-btn" href="javascript:sendLink()"> 
    <img src="<%=request.getContextPath()%>/resources/img/teamE/카톡 마크.jpeg" class="kakao"/>
    카카오톡 공유</a>
    
    <img src="<%=request.getContextPath()%>/resources/img/teamE/comments.jpeg" class="comments"/><br>
    <input type="text" name="comment" size="40" value="댓글을 입력하세요." class="texts">
    <button type="button" class="btn-comments">입력</button>
    
    


</div>

</body>
</html>