package librarymanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Vector;

public class getvalues 
{
	public static Vector<String> getAuthor() 
	{
		Vector<String> v=new Vector<String>();
		Connection con=DBInfo.getConnection();
		String query="Select name from author order by name";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				v.add(rs.getString(1).toUpperCase());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return v;
	}
	public static Vector<String> getSubject() 
	{
		Vector<String> v=new Vector<String>();
		Connection con=DBInfo.getConnection();
		String query="Select name from subject order by name";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				v.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return v;
	}
	public static Vector<String> getCategory() 
	{
		Vector<String> v=new Vector<String>();
		Connection con=DBInfo.getConnection();
		String query="Select name from category order by name";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				v.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return v;
	}
	public static Vector<String> getPublisher() 
	{
		Vector<String> v=new Vector<String>();
		Connection con=DBInfo.getConnection();
		String query="Select name from publisher order by name";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				v.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return v;
	}

}
