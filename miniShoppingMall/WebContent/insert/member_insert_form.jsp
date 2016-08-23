<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	/insert/member_insert_form.jsp
	<form action="${pageContext.request.contextPath}/Mini/MemberInsertAction.do" method="post">
		<table border="1">
			<!-- <tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="20"></td>
			<tr> -->
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>시</td>
				<td><input type="text" name="city" size="20"></td>
			</tr>
			<tr>
				<td>동</td>
				<td><input type="text" name="street" size="20"></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="zipcode" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원가입버튼"></td>
			</tr>
		</table>
	</form>
</body>
</html>