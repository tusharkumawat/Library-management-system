package librarymanagement;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class StudentPage extends JFrame
{
	JSplitPane pane;
	public StudentPage() 
	{
		super("Student");
		setSize(700, 650);
		//setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		pane=new JSplitPane();
		pane.setEnabled(false);
		pane.setLeftComponent(new StudentPageToolbar());
		pane.setBackground(Color.white);
		pane.setRightComponent(new StudentPageTabbedpane());
		add(pane);
		
		
		
	}
	static StudentPage obj;

	

}
