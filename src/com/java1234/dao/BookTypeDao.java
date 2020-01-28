package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.BookType;
import com.java1234.util.StringUtil;

/**
 * 图书类别Dao类
 * @author Administrator
 *
 */
public class BookTypeDao {
	/**
	 * 图书类别添加
	 * @param conn
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn,BookType booktype) throws Exception{
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());
		pstmt.setString(2, booktype.getBookTypeDesc());
		return pstmt.executeUpdate();
		
	}
	/**
	 * 查询图书类别集合
	 * @param conn
	 * @param bookTypeDao
	 * @return
	 */
	public ResultSet list(Connection conn,BookType bookType) throws Exception {
		
		StringBuffer sb=new StringBuffer("select * from t_bookType");
		if (StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replace("and", "where"));
		
		return pstmt.executeQuery();
		
	}
	/**
	 * 删除图书类别
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn,String id) throws Exception{
		String sql="delete from t_bookType where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/**
	 * 更新图书类别
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,BookType bookType) throws Exception{
		String sql="update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
}
