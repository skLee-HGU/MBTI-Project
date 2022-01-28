<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- 공유하기 -->
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript" src="../resources/js/shareProject.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>teamDResult-INFP</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/teamD.css">
</head> 

<body style="background-attachment : fixed ;">
	<div id="wrapper_version1">
		<h1>나랑 꼭 닮은<br>짱구 속 등장인물은?</h1>
		
		<div id="result">
		<table style="width:100%">
			<tr>
				<td><img src="../resources/img/teamD/짱아.png" style="width:230px; height:230px;">
				<td><h2>무한긍정<br>짱아 (INFP)</h2>
				<p>+ 상성 좋은 케미:<br>정의구현자 유리<br>
				- 상성 안 좋은 케미:<br>천방지출 흥부자 짱구</p>
				</td>
		</table>
		</div>
		
		<div id="result_more">
			<p>당신은 짱아처럼 순둥순둥한 순둥이!<br>
				사람 만나는걸 좋아하면서도 싫어하는 당신, 집에 들어가면 연락이 두절되는 조용한 관종이에요.<br>
				개인 시간과 공간은 내가 살아가는 이유로 그 누구도 침범해서는 안돼요.<br>
				모든 일에 의욕이 부족해요. 시작하면 제대로 하긴 하지만 일단 최대한 미뤄요.<br>
				어디로 튈지 모르는 탱탱볼 같은 매력이 있어요. 제일 힘든 것은 미래 설계하기! 당장 내일 점심에 무슨 일이 일어날지도 모르는 세상인데요.<br>
				인간관계에서 눈치가 빨르고 섬세한 부분까지 잘 캐치해요. 그래서 남들은 날 편하다고 느껴요.<br>
				싫어하는 것은 어색한 사이로 소리를 지르며 싸우는 것은 최악이에요. 문제나 갈등은 어떻게든지 피하고 싶어요.<br><br>
				한국인 중의 5.9%가 나랑 같은 유형이에요.</p>
		</div>
		
		<div id="end">
		<table style="width: 100%" id="endbar">
			<tr>
				<td onclick="location.href='start'">
				<div id="img1"><img id="back" style="float:none;width:40px;height:42px;" src="../resources/img/teamD/back.png" >다시하기</div></td>
				<td>
				<div id="img2"> <a id="kakao-link-btn" href="javascript:sendLink()"> <img id="share" style="float:none;width:40px;height:40px;" src="../resources/img/teamD/share.png">결과 공유하기</a></div></td>
				<td><div onclick="location.href='../index'" style="margin-left:0px">Home</div></td>
			</tr>
		</table>
		</div>
	</div>
</body>
</html>