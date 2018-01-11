package librarymanagement;




import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;


import javax.swing.JComboBox;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class AddNewBook extends JPanel
{
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	JComboBox<String> comboBox; 
	JComboBox<String> comboBox_1; 
	JComboBox<String> comboBox_2; 
	JComboBox<String> comboBox_3;
	
	public String bookid()
	{
		String id="";
		for(int i=0;i<=6;i++)
		{
			id+=(int)((Math.random()*9)+1);
		}
		return id;
	}
	public AddNewBook() 
	{
		setSize(526, 526);
		setBorder(new TitledBorder(null, "Add new book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField(bookid());
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.RED);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.RED);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.RED);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(Color.RED);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setForeground(Color.RED);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText(null);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setText(null);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setText(null);
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setText(null);
		DBInfo.getConnection();
		comboBox = new JComboBox<String>(getvalues.getAuthor());
		
		comboBox.insertItemAt("Select",0);
		comboBox.setSelectedIndex(0);
		
		
	
		
		comboBox_1 = new JComboBox<String>(getvalues.getSubject());
		comboBox_1.insertItemAt("Select",0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2 = new JComboBox<String>(getvalues.getCategory());
		comboBox_2.insertItemAt("Select",0);
		comboBox_2.setSelectedIndex(0);
		comboBox_3 = new JComboBox<String>(getvalues.getPublisher());
		comboBox_3.insertItemAt("Select",0);
		comboBox_3.setSelectedIndex(0);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				
				if(textField_2.getText().equals(""))
				{
					lblNewLabel_1.setText("*");
					textField_2.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(textField_3.getText().equals(""))
				{
					lblNewLabel_6.setText("*");
					textField_3.setBorder(BorderFactory.createLineBorder(Color.red));
				
					flag=1;
					}
				if(comboBox.getSelectedIndex()==0)
				{
					lblNewLabel_2.setText("*");
					comboBox.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(comboBox_1.getSelectedIndex()==0)
				{
					lblNewLabel_3.setText("*");
					comboBox_1.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(comboBox_2.getSelectedIndex()==0)
				{
					lblNewLabel_4.setText("*");
					comboBox_2.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(comboBox_3.getSelectedIndex()==0)
				{
					lblNewLabel_5.setText("*");
					comboBox_3.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(textField_4.getText().equals(""))
				{
					lblNewLabel_7.setText("*");
					textField_4.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
					}
				if(textField_5.getText().equals(""))
				{
					lblNewLabel_8.setText("*");
					textField_5.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(textField_6.getText().equals(""))
				{
					lblNewLabel_9.setText("*");
					textField_6.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				
				if(flag==0)
				{
				insertion();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText(bookid());
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DBInfo.getConnection();
				
				DBInfo.insert("author");
				
				AdminPageTabbedpane.refresh();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBInfo.getConnection();
				
				DBInfo.insert("subject");
				
				AdminPageTabbedpane.refresh();
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBInfo.getConnection();
				
				DBInfo.insert("category");
				
				AdminPageTabbedpane.refresh();
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBInfo.getConnection();
				
				DBInfo.insert("publisher");
				
				AdminPageTabbedpane.refresh();
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setBackground(Color.red);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.remove("Add book");
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPublisher, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdition, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addGap(65))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_2, 0, 242, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_2)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_6)
							.addComponent(textField_5)
							.addComponent(textField_4)
							.addComponent(textField_3)
							.addComponent(comboBox_3, 0, 242, Short.MAX_VALUE)
							.addComponent(textField_1)
							.addComponent(btnReset, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)))
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_9))
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(493, Short.MAX_VALUE)
					.addComponent(btnNewButton_1))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblId)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1)))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(42))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(20)
											.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
													.addComponent(button, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblNewLabel_3)))
											.addGap(17)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_4))))
									.addGap(5)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(16)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblPublisher, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(19)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_5))))))
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_6)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(16)
									.addComponent(lblEdition, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_7))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_8))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnReset)
								.addComponent(btnSave))
							.addGap(24))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(278))))
		);
		setLayout(groupLayout);
		
/*		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		
		JMenuItem mntmNewAuthor = new JMenuItem("Author");
		mntmNewAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String a=mntmNewAuthor.getActionCommand();
				DBInfo.getConnection();
				
				DBInfo.insert(a);
				dispose();
				AddNewBook obj=new AddNewBook();
				obj.setVisible(true);
				
			}
		});
		mnAdd.add(mntmNewAuthor);
		
		JMenuItem mntmNewSubject = new JMenuItem("Subject");
		
		mntmNewSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String a=mntmNewSubject.getActionCommand();
				DBInfo.getConnection();
				
				DBInfo.insert(a);
				dispose();
				AddNewBook obj=new AddNewBook();
				obj.setVisible(true);
			}
		});
		mnAdd.add(mntmNewSubject);
		
		JMenuItem mntmNewCategory = new JMenuItem("Category");
		mntmNewCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String a=mntmNewCategory.getActionCommand();
				DBInfo.getConnection();
				
				DBInfo.insert(a);
				dispose();
				AddNewBook obj=new AddNewBook();
				obj.setVisible(true);
			}
		});
		mnAdd.add(mntmNewCategory);
		
		JMenuItem mntmNewPublisher = new JMenuItem("Publisher");
		mntmNewPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String a=mntmNewPublisher.getActionCommand();
				DBInfo.getConnection();
				
				DBInfo.insert(a);
				dispose();
				AddNewBook obj=new AddNewBook();
				obj.setVisible(true);
			}
		});
		mnAdd.add(mntmNewPublisher);
	*/	
	}
	public void insertion()
	{
		DBInfo.getConnection();
		String query="Insert into book values(?,?,?,?,?,?,?,?,?,?)";
		
		int flag=0;
		try
		{
		PreparedStatement ps=DBInfo.con.prepareStatement(query);
		ps.setString(1, textField_1.getText());
		ps.setString(2, textField_2.getText().toUpperCase());
		ps.setString(3, (String)(comboBox.getSelectedItem()));
		ps.setString(4, (String)(comboBox_1.getSelectedItem()));
		ps.setString(5, (String)(comboBox_2.getSelectedItem()));
		ps.setString(6, (String)(comboBox_3.getSelectedItem()));
		ps.setString(7, textField_3.getText());
		ps.setString(8, textField_4.getText());
		ps.setString(9, textField_5.getText());
		ps.setString(10, textField_6.getText());
		flag=ps.executeUpdate();
		}
		catch(SQLException f)
		{
			f.printStackTrace();
		}
		if(flag==0)
    	{
    		JOptionPane.showMessageDialog(AdminPage.obj, "Book not Added", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	if(flag==1)
    	{
    		JOptionPane.showMessageDialog(AdminPage.obj, "Book  Added", "Added", JOptionPane.INFORMATION_MESSAGE);
    		
    		textField_1.setText(bookid());
    		textField_2.setText(null);
    		comboBox.setSelectedIndex(0);
    		comboBox_1.setSelectedIndex(0);
    		comboBox_2.setSelectedIndex(0);
    		comboBox_3.setSelectedIndex(0);
    		textField_3.setText(null);
    		textField_4.setText(null);
    		textField_5.setText(null);
    		textField_6.setText(null);
    		
    	}
	}
}
