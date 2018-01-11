package librarymanagement;

import java.awt.Panel;

import javax.swing.border.TitledBorder;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IssuedBook extends JPanel
{
	
	Vector<String> cols;
	Vector<Vector<String>> totalrecords;

	private JTable t;
	
	public void getHeader()
	{
		cols=new Vector<String>();
		cols.add("Student ID");
		cols.add("Name");
		cols.add("Book ID");
		cols.add("Book name");
	
		
		
	}
	public void getRecord(String value)
	{
		totalrecords=new Vector<Vector<String>>();
		String query="Select * from issue where studentid=?";
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
	
	public IssuedBook()
	{
		setSize(518, 428);
		setBorder(new TitledBorder(null, "Issued books", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getHeader();
		getRecord(loginpage.studentid);
		t=new JTable(totalrecords, cols);
		JScrollPane pane=new JScrollPane(t);
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentPageTabbedpane.remove("Issued book");
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(457, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(button)
					.addGap(10)
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}