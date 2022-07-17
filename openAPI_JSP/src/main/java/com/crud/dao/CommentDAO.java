package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.bean.CommentVO;
import com.crud.common.JDBCUtil;

public class CommentDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String COMMENT_INSERT = "insert into lsk_comment (writer, content) values (?,?)";
	private final String COMMENT_UPDATE = "update lsk_comment set writer=?, content=? where seq=?";
	private final String COMMENT_DELETE = "delete from lsk_comment  where seq=?";
	private final String COMMENT_GET = "select * from lsk_comment  where seq=?";
	private final String COMMENT_LIST = "select * from lsk_comment order by seq desc";

	public int insert(CommentVO vo) {
		System.out.println("insert success");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_INSERT);
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getContent());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void delete(CommentVO vo) {
		System.out.println("delete success");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int update(CommentVO vo) {
		System.out.println("update success");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_UPDATE);
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			System.out.println(vo.getWriter() + "-" +  vo.getContent() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public CommentVO getComment(int seq) {
		CommentVO cvo = new CommentVO();
		System.out.println("getBoard success");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				cvo.setSeq(rs.getInt("seq"));
				cvo.setWriter(rs.getString("writer"));
				cvo.setContent(rs.getString("content"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cvo;
	}
	
	public List<CommentVO> getCommentList(){
		List<CommentVO> list = new ArrayList<CommentVO>();
		System.out.println("getCommentList success");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				CommentVO cvo = new CommentVO();
				cvo.setSeq(rs.getInt("seq"));
				cvo.setWriter(rs.getString("writer"));
				cvo.setContent(rs.getString("content"));
				cvo.setRegdate(rs.getDate("regdate"));
				list.add(cvo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
