package librarymanagement;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class AdminPage extends JFrame
{
	JSplitPane pane;
	public AdminPage() 
	{
		super("Admin");
		setSize(700, 650);
		//setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		pane=new JSplitPane();
		pane.setEnabled(false);
		pane.setLeftComponent(new AdminPageToolbar());
		pane.setBackground(Color.white);
		pane.setRightComponent(new AdminPageTabbedpane());
		add(pane);
		
		
		
	}
	static AdminPage obj;


}
