package com.java1234.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.Dbutil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManagerInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private Dbutil dbutil=new Dbutil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JComboBox s_bookTypeJCB;
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;
	private JTextArea bookDescTxt;
	private JRadioButton manRdb;
	private JRadioButton womenRdb;
	private JComboBox m_bookTypeJcb;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerInterFrm frame = new BookManagerInterFrm();
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
	public BookManagerInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书管理");
		setBounds(100, 100, 735, 657);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
			
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D20\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BookManagerUpdataActionPerformed(evt);
			}
		});
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BookDelateActionPerformed(evt);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)))
					.addContainerGap(64, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(btnNewButton_1)
					.addGap(44)
					.addComponent(btnNewButton_2)
					.addContainerGap(434, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("编号");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("图书名称");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("作者性别");
		
		manRdb = new JRadioButton("男");
		buttonGroup.add(manRdb);
		
		womenRdb = new JRadioButton("女");
		buttonGroup.add(womenRdb);
		
		JLabel lblNewLabel_3 = new JLabel("价格");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("图书作者");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		m_bookTypeJcb = new JComboBox();
		
		JLabel lblNewLabel_5 = new JLabel("图书类别");
		
		JLabel lblNewLabel_6 = new JLabel("图书描述");
		
		 bookDescTxt = new JTextArea();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addGap(18)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(42)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(57)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(manRdb)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(womenRdb))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(m_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(manRdb)
							.addComponent(womenRdb))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(m_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("图书名称");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel label = new JLabel("图书作者");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书类别");
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		
		s_bookTypeJCB = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(s_bookTypeJCB, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(label))
								.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel)
									.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(s_bookTypeJCB, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
				
				
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		));
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(54);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(64);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(118);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(126);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());
	}
	
	
	
	
	
	
	
	/**
	 *图书删除事件处理
	 * @param evt
	 */
	
	protected void BookDelateActionPerformed(ActionEvent evt) {
		Connection conn=null;
		try {
			conn = dbutil.getConnection();
			String id=this.idTxt.getText();
			int n = bookDao.delete(conn, id);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "删除成功");
				fillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "删除失败");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败");
		}
		
	}

	/**
	 * 修改表单
	 * @param evt
	 */
	protected void BookManagerUpdataActionPerformed(ActionEvent evt) {
		int idTxt = Integer.parseInt(this.idTxt.getText());;
		
		String bookNameTxt=this.bookNameTxt.getText();
	
		String sex="";
		BookType booType=(BookType)this.m_bookTypeJcb.getSelectedItem();
		
		System.out.println("1bookTypeName:"+booType.getBookTypeName());
		Integer bookTypeId =null;
		Connection conn=null;
		
		if(this.manRdb.isSelected()) {
			sex="男";
		}else if(this.womenRdb.isSelected()) {
			sex="女";
		}
		Float price=Float.parseFloat(this.priceTxt.getText());
		
		String author=this.authorTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		
		if (idTxt==0) {
			JOptionPane.showConfirmDialog(null, "请选择要修改的记录");
			return;
		}
	
		
		try {
			
			conn = dbutil.getConnection();
			//获取类别
			ResultSet rs=bookTypeDao.list(conn, new BookType());
			while(rs.next()) {
				String bookTypeName=rs.getString("bookTypeName");
				System.out.println("2bookTypeName:"+bookTypeName);
				System.out.println("bookTypeName.equals(bookNameTxt)"+bookTypeName.equals(booType.getBookTypeName()));
				if(bookTypeName.equals(booType.getBookTypeName())) {
					System.out.println("真");
					bookTypeId=rs.getInt("id");
					System.out.println("bookTypeId:"+rs.getInt("id"));
					break;
				}
			}
			Book book=new Book(idTxt, bookNameTxt, author, sex, price, bookTypeId, bookDesc);
			int n=bookDao.update(conn, book);
			System.out.println("n"+n);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				fillTable(new Book());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}
		
	}

	/**
	 * 表单行点击事件
	 * @param e
	 */
	private  void bookTableMousePressed(MouseEvent e) {
		
		int row=bookTable.getSelectedRow();
		//System.out.println("鼠标点击了第"+row+"行");
		  
		  String sex=""; 
		  idTxt.setText((String)bookTable.getValueAt(row, 0));
		  this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		  this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		  sex=(String)bookTable.getValueAt(row, 3);
		  if (sex.equals("男")) {
			  this.manRdb.setSelected(true); 
		  } else if(sex.equals("女")) {
			  this.womenRdb.setSelected(true); 
		  }
		  this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
		  bookDescTxt.setText((String)bookTable.getValueAt(row, 5));
		  String bookTypeName=(String)bookTable.getValueAt(row, 6);
		  
		  int n = this.m_bookTypeJcb.getItemCount();
		  for (int i = 0; i < n; i++) {
			 BookType item = (BookType) m_bookTypeJcb.getItemAt(i);
			 if(item.getBookTypeName().equals(bookTypeName)) {
				 this.m_bookTypeJcb.setSelectedIndex(i);
			 }
			 
		}
	}

	/**
	 * 图书查询事件处理
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		BookType bookType=(BookType) this.s_bookTypeJCB.getSelectedItem();
		int bookId=bookType.getId();
		System.out.println(bookName+" "+author+" "+bookId);
		Book book=new Book(bookName,author,bookId);
		this.fillTable(book);
		
	}

	/**
	 * 初始化下拉框
	 * @param type
	 */
	private void fillBookType(String type) {
		Connection conn=null;
		BookType bookType=null;
		
		try {
			conn=dbutil.getConnection();
			ResultSet rs=bookTypeDao.list(conn, new BookType());
			if("search".equals(type)) {
			bookType=new BookType();
			bookType.setBookTypeName("请选择...");
			bookType.setId(-1);
			this.s_bookTypeJCB.addItem(bookType);
			}
			while(rs.next()) {
				bookType=new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)) {
					this.s_bookTypeJCB.addItem(bookType);
				}else if ("modify".equals(type)) {
					this.m_bookTypeJcb.addItem(bookType);
				}
			}
		} catch (Exception e) {
		
		}finally {
			try {
				dbutil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 初始化表格数据
	 * @param book
	 * @return 
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			ResultSet rs=bookDao.list(conn, book);
			while (rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败");
		}finally {
			try {
				dbutil.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
	}
}
