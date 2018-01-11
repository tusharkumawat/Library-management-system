package librarymanagement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IssueBook extends JPanel {
	private JTextField textField= new JTextField();;
	Border b=textField.getBorder();
	Vector<String> cols;
	Vector<Vector<String>> totalrecords;

	
	
	public void getHeader()
	{
		cols=new Vector<String>();
		cols.add("Student ID");
		cols.add("Name");
		cols.add("Book ID");
		cols.add("Book name");
	}
	public void getRecord(String studentid,String value)
	{
		totalrecords=new Vector<Vector<String>>();
		String query="Select * from issue where "+studentid+"=?";
		try
		{
			Connection con=DBInfo.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, value);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Vector<String> singleRecord=new Vector<String>();  
    			String s1=rs.getString(1);
    			String s2=rs.getString(2);
    			String s3=rs.getString(3);
    			String s4=rs.getString(4);
    			
    			singleRecord.add(s1);
    			singleRecord.add(s2);
    			singleRecord.add(s3);
    			singleRecord.add(s4);
    			totalrecords.add(singleRecord);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	

	

	/**
	 * Create the panel.
	 */
	public IssueBook() {
		
		setSize(518, 406);
		setBorder(new TitledBorder(null, "Issue book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JLabel l=new JLabel("Enter Student ID");
		l.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JTextField text=new JTextField();
	
		
		
		JLabel lblNewLabel = new JLabel("Enter Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.red);
	
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
	
		
		

		textField.setEnabled(false);
		textField.setColumns(10);
		
		
		JButton btnIssue = new JButton("ISSUE");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				String studentid=text.getText();
				if(studentid.equals(""))
				{
					lblNewLabel_1.setText("*");
					text.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				String bookid=textField.getText();
				if(bookid.equals(""))
				{
					lblNewLabel_2.setText("*");
					textField.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(flag==0)
				{
				String query1="Select title from book where id="+bookid+"";
				String query2="Select name from registration where id="+studentid+"";
				String query="Insert into issue values(?,?,?,?)";
				String title=new String();
				String name=new String();
				try
				{
					
					PreparedStatement ps=DBInfo.getConnection().prepareStatement(query1);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						title=rs.getString(1);
					}
					ps=DBInfo.getConnection().prepareStatement(query2);
					rs=ps.executeQuery();
					while(rs.next())
					{
						name=rs.getString(1);
					}
					if(title.equals("") || name.equals(""))
					{
						JOptionPane.showMessageDialog(new IssueBook(), "Wrong input!!", "Error", JOptionPane.ERROR_MESSAGE);
						text.setText(null);
						textField.setText(null);
						textField.setEnabled(false);
						
					}
					else
					{
					ps=DBInfo.getConnection().prepareStatement(query);
					ps.setString(1, studentid);
					ps.setString(2, name);
					ps.setString(3, bookid);
					ps.setString(4, title);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(new IssueBook(), "Book issued", "Success", JOptionPane.INFORMATION_MESSAGE);
					text.setText(null);
					textField.setText(null);
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(new IssueBook(), "Incomplete data", "Error!!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIssue.setEnabled(false);
		btnIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		text.addFocusListener(new FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
			String studid=text.getText();
			if(studid.equals(""))
			{
				lblNewLabel_1.setText("*");
				text.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			else
			{
			getHeader();
			getRecord("studentid", studid);
			JFrame frm=new JFrame("Student information");
			JTable t=new JTable(totalrecords, cols);
			JScrollPane pane=new JScrollPane(t);
			frm.getContentPane().add(pane);
			
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setLocationRelativeTo(IssueBook.this);
			frm.setSize(600,600);
			frm.setVisible(true);
			btnIssue.setEnabled(true);
			textField.setEnabled(true);
		}
			
			}
		});
		
		JButton btnNewButton = new JButton("Get Informaton");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							
				
				
				String studid=text.getText();
				if(studid.equals(""))
				{
					lblNewLabel_1.setText("*");
					text.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}
				else
				{
				getHeader();
				getRecord("studentid", studid);
				JFrame frm=new JFrame("Student information");
				JTable t=new JTable(totalrecords, cols);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				
				frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frm.setLocationRelativeTo(IssueBook.this);
				frm.setSize(600,600);
				frm.setVisible(true);
				btnIssue.setEnabled(true);
				textField.setEnabled(true);
			}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text.setText("");
				text.setBorder(b);
				textField.setText("");
				textField.setBorder(b);
				lblNewLabel_1.setText("");
				lblNewLabel_2.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPageTabbedpane.remove("Issue book");
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(l)
						.addComponent(lblNewLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(281)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(text, 176, 176, 176))))
					.addGap(46))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(btnNewButton)
					.addGap(56)
					.addComponent(btnIssue)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addGap(60))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(457, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(l)
								.addComponent(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnReset)
									.addComponent(btnIssue))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblNewLabel_1)
							.addGap(38)
							.addComponent(lblNewLabel_2)))
					.addContainerGap(195, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
