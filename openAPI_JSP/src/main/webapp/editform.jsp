<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.crud.dao.CommentDAO, com.crud.bean.CommentVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미세먼지 저리가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href='./resources/css/App.css' />
</head>
<body>

	<%
	CommentDAO commentDAO = new CommentDAO();
	String id = request.getParameter("id");
	CommentVO u = commentDAO.getComment(Integer.parseInt(id));
	%>
	<div class="formstyle">
	<h2 class="form_tit">댓글 수정하기</h2>
	<form action="edit.jsp" method="post">
		<input type="hidden" name="seq" value="<%=u.getSeq()%>" />
		<table>
			<tr>
				<td>닉네임:</td>
				<td><input type="text" name="writer"
					value="<%=u.getWriter()%>" /></td>
			</tr>
			<tr>
				<td>댓글:</td>
				<td><textarea cols="30" rows="3" name="content"><%=u.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-primary" type="button" value="돌아가기" onclick="history.back()" /> 
				<td align="right"><input class="btn btn-primary" type="submit" value="저장" /></td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>