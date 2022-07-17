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
int i = commentDAO.update(u);
response.sendRedirect("comment.jsp");
%>