package librarymanagement;

import java.awt.Color;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class StudentPageToolbar extends Panel
{
	JToolBar tool;
	JButton b1,b2,b3,b4,b5;
	public StudentPageToolbar()
	{
		tool=new JToolBar();
		tool.setBackground(Color.white);
		
		b1=new JButton(new ImageIcon("issuedbook.png"));
		b1.setBorder(null);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentPageTabbedpane.tab1.addTab("Issued book",StudentPageTabbedpane.obj1=new IssuedBook());
				
		
			}
		});
		b2=new JButton(new ImageIcon("searchbook1.jpg"));
		b2.setBorder(null);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentPageTabbedpane.tab1.addTab("Search book",StudentPageTabbedpane.obj2=new SearchBooks2());
				
		
			}
		});
		b3=new JButton(new ImageIcon("profile.png"));
		b3.setBorder(null);
b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentPageTabbedpane.tab1.addTab("Student profile",StudentPageTabbedpane.obj4=new studprofile());
				
		
			}
		});

		b4=new JButton(new ImageIcon("changepass1.png"));
		b4.setBorder(null);
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentPageTabbedpane.tab1.addTab("Change password",StudentPageTabbedpane.obj3=new ChangePassword2());
				
		
			}
		});
		b5=new JButton(new ImageIcon("logout.png"));
		b5.setBorder(null);
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginpage.st.dispose();
				loginpage login=new loginpage();
				login.setVisible(true);
		
			}
		});
		tool.add(b3);
		tool.add(b1);
		tool.add(b2);
		tool.add(b4);
		tool.add(b5);
		
		tool.setEnabled(false);
		
		add(tool);
		tool.setOrientation(JToolBar.VERTICAL);
	}
	
	

}
