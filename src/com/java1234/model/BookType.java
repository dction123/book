package com.java1234.model;
/**
 * 图书类别实体
 * @author Administrator
 *
 */
public class BookType {
	private int id;
	private String bookTypeName;//图书类别名称
	private String bookTypeDesc;//备注
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}
	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	@Override
	public String toString() {
		return bookTypeName;
	}
	
}
