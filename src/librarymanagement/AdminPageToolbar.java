package librarymanagement;

import java.awt.Color;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class AdminPageToolbar extends Panel
{
	JToolBar tool;
	JButton b1,b2,b3,b4,b5,b6,b7,b9,b10;
	public AdminPageToolbar()
	{
		tool=new JToolBar();
		tool.setBackground(Color.white);
		b1=new JButton(new ImageIcon("addnewbook1.jpg"));
		b1.setBorder(null);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Add book",AdminPageTabbedpane.obj1=new AddNewBook());
				
		
			}
		});
		
		b2=new JButton(new ImageIcon("submitbook1.png"));
		b2.setBorder(null);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Submit book",AdminPageTabbedpane.obj8=new SubmitBook());
				
		
			}
		});
		
		b3=new JButton(new ImageIcon("issuebook1.png"));
		b3.setBorder(null);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Issue book",AdminPageTabbedpane.obj6=new IssueBook());
				
		
			}
		});
		b4=new JButton(new ImageIcon("searchbook1.jpg"));
		b4.setBorder(null);
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Search book",AdminPageTabbedpane.obj3=new SearchBooks());
				
		
			}
		});
		b5=new JButton(new ImageIcon("addnewuser1.png"));
		b5.setBorder(null);
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Add user",AdminPageTabbedpane.obj4=new NewUser());
				
		
			}
		});
		b6=new JButton(new ImageIcon("deleteuser1.png"));
		b6.setBorder(null);
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Delete user",AdminPageTabbedpane.obj5=new DeleteUser());
				
		
			}
		});
		b7=new JButton(new ImageIcon("updatebook1.png"));
		b7.setBorder(null);
		b7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Update book",AdminPageTabbedpane.obj2=new UpdateBook());
				
		
			}
		});
		
		b9=new JButton(new ImageIcon("changepass1.png"));
		b9.setBorder(null);
		
		b9.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.tab1.addTab("Change password",AdminPageTabbedpane.obj7=new ChangePassword());
				
		
			}
		});
		
		b10=new JButton(new ImageIcon("logout.png"));
		b10.setBorder(null);
		b10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginpage.ad.dispose();
				loginpage login=new loginpage();
				login.setVisible(true);
		
			}
		});
		tool.add(b1);
		tool.add(b2);
		tool.add(b3);
		tool.add(b4);
		tool.add(b5);
		tool.add(b6);
		tool.add(b7);
		tool.add(b9);
		tool.add(b10);
		tool.setEnabled(false);
		
		add(tool);
		tool.setOrientation(JToolBar.VERTICAL);
	}
	
	

}
