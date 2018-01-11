package librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;




public class DBInfo 
{
	static Connection con=null;
	static
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	}
	public static Connection getConnection()
	{
		
		try
		{
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libdbms", "root", "tushar");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void insert(String a)
	{
		String str=JOptionPane.showInputDialog("Enter new "+a);
				if(str!=null)
				{
				String query="Insert into "+a.toLowerCase()+"(name) values(?)";
				try
				{
				java.sql.PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, str.toUpperCase());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(new AddNewBook(),a+" inserted!!");
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				}
	}
/*	public static Vector<String> getName(String nametype) 
	{
		Vector<String> v=new Vector<>();
		String query="Select name from "+nametype+" order by name";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				v.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return v;
	}
*/		
	
	
}
