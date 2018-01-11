package librarymanagement;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JTabbedPane;

public class AdminPageTabbedpane extends Panel 
{
	static AddNewBook obj1;
	static UpdateBook obj2;
	static SearchBooks obj3;
	static NewUser obj4;
	static DeleteUser obj5;
	static IssueBook obj6;
	static JTabbedPane tab1;
	static ChangePassword obj7;
	static SubmitBook obj8;
	public AdminPageTabbedpane() 
	{
		setBackground(Color.lightGray);
		tab1=new JTabbedPane();
		add(tab1);
		
	}
	public static void refresh()
	{
		int i=tab1.indexOfTab("Add book");
		
		tab1.remove(i);
		tab1.addTab("Add book", obj1=new AddNewBook());
	}
	public static void remove(String r)
	{
		int i=tab1.indexOfTab(r);
		tab1.remove(i);
	}
	
}
