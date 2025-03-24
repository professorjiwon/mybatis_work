<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.login-area a {
		text-decoration: none;
		color: black;
		font-size: 14px;
	}
	.loginInfo {
		font-size: 18px;
	}
	.nav-area {
		background-color: black;
		color: white;
		height: 50px;
	}
	.menu {
		display: table-cell;
		width: 250px;
		height: 50px;
		vertical-align: middle;
	}
	.outer {
		text-align: center;
	}
	.outer table tr {
		text-align: left;
		height: 30px;
	}
</style>
</head>
<body>
	<h1 align="center">Welcome to MyBatis World</h1>
	
	<div class="login-area" align="right">
		<c:choose>
			<c:when test="${ empty loginUser }">
				<form action="login.me" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input name="userId" required></td>
							<td rowspan="2">
								<input type="submit" value="로그인" style="height:46px">
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="userPwd" required></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="enrollForm.me">회원가입</a>
								<a href="">아이디/비번찾기</a>
							</td>
						</tr>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<!-- 로그인 후 -->
				<table>
					<tr>
						<td colspan="2"><b class="loginInfo">${ loginUser.userName }님 환영합니다</b></td>
					</tr>
					<tr>
						<td><a href="">마이페이지</a></td>
						<td><a href="logout.me">로그아웃</a></td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	
	<br>
	
	<div class="nav-area" align="center">
		<div class="menu">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu" onclick="location.href='list.bo?nowPage=1'">게시판</div>
		<div class="menu">ETC</div>
	</div>
</body>
</html>