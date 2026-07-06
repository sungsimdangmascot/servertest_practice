<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- memberInsertForm.jsp 작업 항목 -->
<!-- 1. 회원 추가 서블릿으로 이동할 수 있는 form태그 속성 작성 -->
<!-- 2. 회원 추가에 필요한 input 태그의 속성 작성 -->
<!-- 3. 취소버튼을 누르면 회원목록으로 돌아갈 수 있도록 링크 연결 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
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
	background-color: #007bff;
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

	<h2>회원 등록</h2>

	<!-- 항목1) 회원 추가 서블릿으로 이동할 수 있는 form태그 속성 작성 -->
	<form>
	<!-- 항목2) 회원 추가에 필요한 input 태그의 속성 작성 -->
		<p>
			<label for="memberName">이름 : </label>
			<%-- name="memberName" : 서블릿에서 request.getParameter("memberName") --%>
			<input type='text' id="memberName" name="memberName"
				placeholder="이름을 입력하세요" required>
		</p>

		<p>
			<label for="memberAge">나이 : </label> <input type="number"
				id="memberAge" name="memberAge" placeholder="나이를 입력해주세요" min="1"
				required>
		</p>

		<%-- submit버튼 --%>
		<p>
			<input type="submit" value="등록" class="btn btn-submit">
			
			<!-- 항목3) 취소버튼을 누르면 회원목록으로 돌아갈 수 있도록 링크 연결 -->
			<!-- 취소 버튼 : 회원 목록으로 다시 돌아간다 -->
			<button type="button" class="btn btn-cancel"
			onclick="location.href='${pageContext.request.contextPath}/memberList'">취소</button>
		</p>

	</form>
</body>
</html>


















