package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.StringUtil;

/**
 * 图书Dao类
 * @author Administrator
 *
 */
public class BookDao {
	public int addBook(Connection conn,Book book)throws Exception {
		String sql="insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,book.getBookName() );
		pstmt.setString(2,book.getAuthor() );
		pstmt.setString(3,book.getSex() );
		pstmt.setFloat(4,book.getPrice());
		pstmt.setInt(5,book.getBookTypeId());
		pstmt.setString(6,book.getBookDesc());
		return pstmt.executeUpdate();
		
	}
	/**
	 * 查询图书
	 * @param conn
	 * @param book
	 * @return
	 */
	public ResultSet list(Connection conn,Book book) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_book b, t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like'%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sb.append("and b.bookTypeId="+book.getBookTypeId());
		}
		System.out.println("sql:"+sb.toString());
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 删除记录
	 * @param conn
	 * @param book
	 * @return
	 */
	public int delete(Connection conn,String id)throws Exception {
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 更新图书信息
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,Book book) throws Exception{
		String sql="update t_book set bookName=?,sex=?,price=?,author=?,bookTypeId=?,bookDesc=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,book.getBookName());
		pstmt.setString(2, book.getSex());
		pstmt.setFloat(3, book.getPrice());
		pstmt.setString(4, book.getAuthor());
		
		
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
}
}