<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.crud.dao.CommentDAO"%>

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="u" class="com.crud.bean.CommentVO" />
<jsp:setProperty property="*" name="u" />

<%
CommentDAO commentDAO = new CommentDAO();
	int i = commentDAO.insert(u);
	String msg = "댓글 추가 성공 !";
	if(i == 0) msg = "[에러] 댓글 추가 실패!";
%>

<script>
	alert('<%=msg%>');
	location.href='comment.jsp';
</script>