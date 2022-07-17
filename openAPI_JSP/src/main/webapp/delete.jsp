<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.crud.dao.CommentDAO,com.crud.bean.CommentVO"%>
<%
String sid = request.getParameter("id");
if (sid != ""){  
	int id = Integer.parseInt(sid);
	CommentVO u = new CommentVO();
	u.setSeq(id);
	CommentDAO commentDAO = new CommentDAO();
	commentDAO.delete(u);
}
response.sendRedirect("comment.jsp");
%>