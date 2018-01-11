package librarymanagement;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JTabbedPane;

public class StudentPageTabbedpane extends Panel 
{
	static IssuedBook obj1;
	static SearchBooks2 obj2;
	static ChangePassword2 obj3;
	static studprofile obj4;
	static JTabbedPane tab1;
	public StudentPageTabbedpane() 
	{
		setBackground(Color.lightGray);
		tab1=new JTabbedPane();
		add(tab1);
		
	}
	
	public static void remove(String r)
	{
		int i=tab1.indexOfTab(r);
		tab1.remove(i);
	}
	
}
