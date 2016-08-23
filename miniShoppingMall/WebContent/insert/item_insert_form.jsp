<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	/insert/item_insert_form.jsp
	<form action="${pageContext.request.contextPath}/Mini/ItemInsertAction.do" method="post">
		<table border="1">
			<tr>
				<td>카테고리 선택</td>
				<td>
					<select>
						<c:forEach var="category" items="${categoryList }">
							<option value="${category.name }">${category.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>아이템 이름 : </td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>아이템 수량 : </td>
				<td><input type="text" name="stockquantity" size="20"></td>
			</tr>
			<tr>
				<td>아이템 가격 : </td>
				<td><input type="text" name="price" size="20"></td>
			</tr>
			<!-- <tr>
				<td>우편번호</td>
				<td><input type="text" name="zipcode" size="20"></td>
			</tr> -->
			<tr>
				<td colspan="4"><input type="submit" value="아이템 등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>