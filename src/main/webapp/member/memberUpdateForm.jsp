<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDTO" %>

<!-- memberUpdateForm.jsp 작업 항목 -->
<!-- 1. MemberUpdateController에서 받아온 수정할 회원에 대한 정보 꺼내기 -->
<!-- 2. 회원 수정시 수정할 회원 정보를 서블릿에 보낼 수 있는 form태그의 속성 작성 -->
<!-- 3. input 태그의 속성과 수정 하기 전 회원의 정보를 출력할 수 있는 속성 작성 -->
<!-- 4. 취소 버튼을 누르면 회원 목록 페이지로 돌아갈 수 있도록 button 태그 속성 작성 -->

<!-- 항목 1) MemberUpdateController에서 받아온 수정할 회원에 대한 정보 꺼내기 -->
<%

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 30px;
}

label {
	display: inline-block;
	width: 80px;
}

input[type="text"], input[type="number"] {
	padding: 6px;
	margin: 6px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.btn {
	padding: 8px 20px;
	margin-top: 10px;
	cursor: pointer;
}

.btn-submit {
	background-color: #fd7e14;
	color: white;
	border: none;
	border-radius: 4px;
}

.btn-cancel {
	background-color: #6c757d;
	color: white;
	border: none;
	border-radius: 4px;
}

</style>
</head>
<body>
	<h2>회원 수정</h2>
	
	<!-- 항목 2)회원 수정시 수정할 회원 정보를 서블릿에 보낼 수 있는 form태그의 속성 작성 -->
	<form action="memberUpdate" method="post">
	
		<!-- 항목 3) 3. input 태그의 속성과 수정 하기 전 회원의 정보를 출력할 수 있는 속성 작성 -->
		
		<%--
			hidden 필드 : 화면에는 보이지 않지만 서버로 전송되는 데이터
			수정할 회원 ID를 post 요청에 함께 담아 보내야 "누구를 수정할지"알 수 있다
		 --%>
		<input type="hidden" value="<%= %>">
		
		<p>
			<label>ID :</label>
			<%-- ID는 변경하지 않으므로 readonly로 수정 불가 처리--%>
			<input type="number" readonly
			style="background-color: #f0f0f0;">
		</p>
		
		<p>
			<label for="memberName">이름 :</label>
			
			<input type="text" id="memberName" required>
		</p>
		
		<p>
			<label for="memberAge">나이 :</label>
			<input type="number" id="memberAge" required>
		</p>
		
		
		<p>
			<input type="submit" value="수정완료" class="btn btn-submit">
			<%-- 항목 4) 취소 버튼 : 회원목록으로 돌아가기 --%>
			<button type="button" class="btn btn-cancel">취소</button>
		</p>
		
		
		
	</form>
	
	
</body>
</html>







