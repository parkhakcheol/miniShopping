<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	/minsert/m_insert_form.jsp
	<form action="<%=request.getContextPath()%>/Mini/MemberInsertAction.do"
		method="post">
		<table border="1">
			<!-- <tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="20"></td>
			<tr> -->
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			<tr>
			<tr>
				<td>시</td>
				<td><input type="text" name="city" size="20"></td>
			<tr>
			<tr>
				<td>동</td>
				<td><input type="text" name="street" size="20"></td>
			<tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="zipcode" size="20"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원가입버튼"></td>
			</tr>
		</table>
	</form>
</body>
</html>