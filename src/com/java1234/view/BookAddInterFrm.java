package com.java1234.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.Dbutil;
import com.java1234.util.StringUtil;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField priceTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton manJRB;
	private JRadioButton womenJRB;
	private JTextArea bookDescTxt;
	private Dbutil dbutil=new Dbutil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JComboBox bookTypeJCB;		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书添加");
		setBounds(100, 100, 564, 450);
		
		JLabel lblNewLabel = new JLabel("图书名称");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label = new JLabel("作者");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("性别");
		
		manJRB = new JRadioButton("男");
		buttonGroup.add(manJRB);
		
		 womenJRB = new JRadioButton("女");
		buttonGroup.add(womenJRB);
		
		JLabel lblNewLabel_2 = new JLabel("价格");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("备注");
		
		 bookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restValue(e);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("图书类别");
		
		 bookTypeJCB = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(manJRB)
							.addGap(18)
							.addComponent(womenJRB))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(96)
									.addComponent(btnNewButton_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
										.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookTypeJCB, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addGap(338))))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeJCB, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(8))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(womenJRB)
							.addComponent(manJRB)))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(57))
		);
		getContentPane().setLayout(groupLayout);
		fillSelect();
	}
	/**
	 * 重置表单
	 * @param e
	 */
	private void restValue(ActionEvent e) {
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.bookDescTxt.setText("");
		this.priceTxt.setText("");
		this.manJRB.setSelected(true);
		
	}

	/**
	 * 图书添加事件处理
	 * @param e
	 */
	private void addBookActionPerformed(ActionEvent e) {
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookDesc)) {
			JOptionPane.showMessageDialog(null, "图书备注不能为空");
			return;
		}
		String sex="";
		if(this.manJRB.isSelected()) {
			sex="男";
			
		}if(this.womenJRB.isSelected()) {
			sex="女";
		}
		BookType bookType=(BookType) bookTypeJCB.getSelectedItem();
		int bookTypeId=bookType.getId();
		Book book=new Book(bookName, author, sex, Float.parseFloat(price),bookTypeId, bookDesc);
		
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			int addNum=bookDao.addBook(conn, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功");
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败");

		}finally {
			try {
				dbutil.closeConnection(conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 填充下拉单
	 */
	private void fillSelect() {
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			ResultSet rs=null;
			rs=bookTypeDao.list(conn, new BookType());
			while(rs.next()) {
				BookType bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJCB.addItem(bookType);
				
			}
		} catch (Exception e) {
		
		}finally {
			
		}
		
	}
}
