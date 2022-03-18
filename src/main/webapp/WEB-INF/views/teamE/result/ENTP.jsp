<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!-- 공유하기 -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/share/teamE.js"></script>

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
	<h1 class="text-c">ENTP <br> 논쟁적인 친구</h1>
    <img src="../resources/img/teamE/bar.jpg" class="bar"/>
    <img src="../resources/img/teamE/ENTP.jpeg" class="main-animal"/>
	</div>
    
    <div class="outer">
    <div class="resultContent">
    <p class="text-d">관대하고 느긋한 친구</p>
    <p class="text-d">일단 저지르고 나중에 생각하는 편</p>
    <p class="text-d">직설적이고 솔직한 친구</p>
    <p class="text-d">환불 요구, 컴플레인 잘 거는 친구</p><br>
    </div>
    </div>
    
	
	<p class="goodRelation">잘 맞는 유형 <br> INFJ <br> <img src="<%=request.getContextPath()%>/resources/img/teamE/INFJ.jpeg" class="animals"/> </p>
  
    <p class="badRelation">안 맞는 유형 <br> ESFJ <br> <img src="<%=request.getContextPath()%>/resources/img/teamE/ESFJ.jpeg" class="animals"/> </p> 
    	
    
    <br>
    <div class="restarticon">
			<a id="home-btn" href="<%=request.getContextPath()%>/index"> <input
				type="button" value="홈가기" class="btn-result"></a>
			
			<input type="button" value="다시하기"
				class="btn-result"
				onclick="location.href='<%=request.getContextPath()%>/teamE/start'">
			
			<form method="post"
				action="<%=request.getContextPath()%>/teamE/saved"
				style="display: inline-block;">
				<input name="mbti" id="mbti" value="ENTP" style="display: none">
				<button class="btn-result">
					<input type="button" value="저장하기" style="border: none; background: none; padding-left: 166px; padding-right: 166px;">
				</button>
			</form>
	</div>
		<div class="share-wrap" style="margin-bottom: 40px;">
			<a id="kakao-link-btn" href="javascript:sendLink()"> <img
				src="<%=request.getContextPath()%>/resources/img/teamB/kakaotalk_icon.png"
				alt="kakaoicon"></a> <a id="copy-link-btn"
				href="javascript:copyLink()"> <img
				src="<%=request.getContextPath()%>/resources/img/teamB/link_icon.png"
				alt="linkicon"></a>
		</div>
</div>

</body>
</html>