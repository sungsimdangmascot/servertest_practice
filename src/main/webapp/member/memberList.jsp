<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="member.MemberDAO, member.MemberDTO, java.util.List"%>

<!-- memberList.jsp 작업 항목 -->
<!-- 1. MemberListController에서 담아온 회원목록을 불러오는 스크립틀릿 작성 -->
<!-- 2. 전체 회원 수를 출력할 수 있는 부분 작성 -->
<!-- 3. 회원 등록 페이지로 이동하는 링크 부분 속성 작성 -->
<!-- 4. 회원 목록 출력하는 부분 for문 항목 채우기 -->
<!-- 5. 수정링크 클릭시 해당 회원의 수정 폼으로 이동할 수 있도록 연결 -->
<!-- 6. 삭제링크 클릭시 해당 회원을 삭제할 수 있도록 작성 -->


<%-- 
	항목1) MemberListController에서 담아온 회원목록을 불러오는 스크립틀릿 작성
	getAttribute로 Controller가 담아준 데이터를 꺼낸다
--%>
<%
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 30px;
}

table {
	border-collapse: collapse;
	width: 60%;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px 16px;
	text-align: center;
}

th {
	background-color: #4a90d9;
	color: white;
}

a {
	color: #2c7be5;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
.btn-insert{
	display : inline-block;
	margin-bottom: 10px;
	padding: 8px 16px;
	background-color: #28a745; 
	color : white;
	border-radius : 4px;
}
</style>
</head>
<body>
	<h2>회원 목록</h2>

	<%--
		항목 2) 전체 회원 수를 출력할 수 있는 부분 작성 
		표현식으로 전체 회원 수 출력 
	--%>
	<p>
		전체 회원 수 : <strong><%= %></strong>명
	</p>
	
	<%-- 항목 3) 회원 등록 페이지로 이동하는 링크 부분 속성 작성 --%>
	<a class="btn-insert">+ 회원 등록</a>

	<table>
		<thead>
			<!-- 제목 행 작성 -->
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>나이</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>

		<tbody>
			<!-- 항목 4) 회원 목록 출력 : for문으로 회원 목록 한행씩 출력 -->
			<%
			for () {
			%>
			<tr>
				<!-- 회원 번호 -->
				<td></td>
				<!-- 회원 이름 -->
				<td></td>
				<!-- 회원 나이 -->
				<td></td>
				<%-- 항목 5) 수정 링크 : 클릭하면 memberId를 url에 수정 서블릿으로 이동--%>
				<td><a>수정</a>
				</td>
				<%-- 항목 6) 삭제 링크 : 클릭하면 memberId를 사용해 삭제 서블릿 실행 --%>
				<td><a> 삭제 </a></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>

</body>
</html>












