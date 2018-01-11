package librarymanagement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

public class SearchBooks extends JPanel
{

	/**
	 * Create the panel.
	 */
	
	Vector<String> cols;
	Vector<Vector<String>> totalrecords=new Vector<Vector<String>>();
	JTable t;

	public void getHeader()
	{
		cols=new Vector<String>();
		cols.add("ID");
		cols.add("TITLE");
		cols.add("AUTHOR");
		cols.add("SUBJECT");
		cols.add("CATEGORY");
		cols.add("PUBLISHER");
		cols.add("ISBN");
		cols.add("EDITION");
		cols.add("PRICE");
		cols.add("QUANTITY");
		
		
	}
	public void getRecord(String name,String value)
	{
		
		String query="Select * from book where "+name+"=?";
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
    			String s5=rs.getString(5);
    			String s6=rs.getString(6);
    			String s7=rs.getString(7);
    			String s8=rs.getString(8);
    			String s9=rs.getString(9);
    			String s10=rs.getString(10);
    			singleRecord.add(s1);
    			singleRecord.add(s2);
    			singleRecord.add(s3);
    			singleRecord.add(s4);
    			singleRecord.add(s5);
    			singleRecord.add(s6);
    			singleRecord.add(s7);
    			singleRecord.add(s8);
    			singleRecord.add(s9);
    			singleRecord.add(s10);
    			totalrecords.add(singleRecord);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public SearchBooks() {
		setSize(518, 526);
		setBorder(new TitledBorder(null, "Search book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblSearchBooksBy = new JLabel("Search books by");
		lblSearchBooksBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		String value[]={"ID", "TITLE", "AUTHOR", "PUBLISHER", "SUBJECT", "CATEGORY", "ALL"};
		JComboBox comboBox = new JComboBox(value);
		//comboBox.setModel(new DefaultComboBoxModel());
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem()=="ID")
				{
					int flag=0;
					String idd=JOptionPane.showInputDialog(SearchBooks.this, "Enter ID", "Search", JOptionPane.PLAIN_MESSAGE);
					try
					{
					if(idd.equals(""))
					{
						flag=1;
					}
					}
					catch(Exception ex)
					{
						flag=1;
					}
					if(flag==0)
					{
					getHeader();			
					
					getRecord("id", idd);
					
					t=new JTable(totalrecords, cols);
					
					t.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
					 
					for (int column = 0; column < t.getColumnCount()-3; column++)
					{
					    TableColumn tableColumn = t.getColumnModel().getColumn(column);
					    int preferredWidth = tableColumn.getMinWidth();
					    int maxWidth = tableColumn.getMaxWidth();
					 
					    for (int row = 0; row < t.getRowCount(); row++)
					    {
					        TableCellRenderer cellRenderer = t.getCellRenderer(row, column);
					        Component c = t.prepareRenderer(cellRenderer, row, column);
					        int width = c.getPreferredSize().width + t.getIntercellSpacing().width;
					        preferredWidth = Math.max(preferredWidth, width);
					 
					        //  We've exceeded the maximum width, no need to check other rows
					 
					        if (preferredWidth >= maxWidth)
					        {
					            preferredWidth = maxWidth;
					            break;
					        }
					    }
					    if(preferredWidth<100)
					    {
					    	preferredWidth=100;
					    }
					    tableColumn.setPreferredWidth( preferredWidth );
					}
					
					JScrollPane pane=new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					
					
										JFrame j=new JFrame("Records");
					
					j.getContentPane().add(pane);
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setLocationRelativeTo(SearchBooks.this);
					j.setSize(600,600);
					JButton b=new JButton("Go back");
					b.setFont(new Font("Tahoma", Font.BOLD, 14));
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							j.dispose();
							loginpage.ad=new AdminPage();
							loginpage.ad.setVisible(true);
						}
					});
					j.getContentPane().add(b,new BorderLayout().SOUTH);
					loginpage.ad.dispose();
					j.setVisible(true);
					
					
					
					
					}
					
					
					
				}
				else if(comboBox.getSelectedItem()=="TITLE")
				{
					
					int flag=0;
					String title=JOptionPane.showInputDialog(SearchBooks.this, "Enter title(Case sensitive)", "Search", JOptionPane.PLAIN_MESSAGE);
					try
					{
					if(title.equals(""))
					{
						flag=1;
					}
					}
					catch(Exception ex)
					{
						flag=1;
					}
					if(flag==0)
					{
					getHeader();
					getRecord("title", title);
					t=new JTable(totalrecords, cols);
					t.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
					 
					for (int column = 0; column < t.getColumnCount()-3; column++)
					{
					    TableColumn tableColumn = t.getColumnModel().getColumn(column);
					    int preferredWidth = tableColumn.getMinWidth();
					    int maxWidth = tableColumn.getMaxWidth();
					 
					    for (int row = 0; row < t.getRowCount(); row++)
					    {
					        TableCellRenderer cellRenderer = t.getCellRenderer(row, column);
					        Component c = t.prepareRenderer(cellRenderer, row, column);
					        int width =50+c.getPreferredSize().width + t.getIntercellSpacing().width;
					        preferredWidth = Math.max(preferredWidth, width);
					 
					        //  We've exceeded the maximum width, no need to check other rows
					 
					        if (preferredWidth >= maxWidth)
					        {
					            preferredWidth = maxWidth;
					            break;
					        }
					    }
					 
					    tableColumn.setPreferredWidth( preferredWidth );
					}
					JScrollPane pane=new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					JFrame j=new JFrame("Records");
					j.getContentPane().add(pane);
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setLocationRelativeTo(SearchBooks.this);
					j.setSize(600,600);
					JButton b=new JButton("Go back");
					b.setFont(new Font("Tahoma", Font.BOLD, 14));
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							j.dispose();
							loginpage.ad=new AdminPage();
							loginpage.ad.setVisible(true);
						}
					});
					j.getContentPane().add(b,new BorderLayout().SOUTH);
					loginpage.ad.dispose();
					j.setVisible(true);
					}
				}
				else if(comboBox.getSelectedItem()=="AUTHOR")
				{
					int flag=0;
				
					String author=JOptionPane.showInputDialog(SearchBooks.this, "Enter author", "Search", JOptionPane.PLAIN_MESSAGE);
					try
					{
					if(author.equals(""))
					{
						flag=1;
					}
					}
					catch(Exception ex)
					{
						flag=1;
					}
					if(flag==0)
					{
					getHeader();			
					
					getRecord("author", author);
					
					t=new JTable(totalrecords, cols);
					t.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
					 
					for (int column = 0; column < t.getColumnCount()-3; column++)
					{
					    TableColumn tableColumn = t.getColumnModel().getColumn(column);
					    int preferredWidth = tableColumn.getMinWidth();
					    int maxWidth = tableColumn.getMaxWidth();
					 
					    for (int row = 0; row < t.getRowCount(); row++)
					    {
					        TableCellRenderer cellRenderer = t.getCellRenderer(row, column);
					        Component c = t.prepareRenderer(cellRenderer, row, column);
					        int width = 50+c.getPreferredSize().width + t.getIntercellSpacing().width;
					        preferredWidth = Math.max(preferredWidth, width);
					 
					        //  We've exceeded the maximum width, no need to check other rows
					 
					        if (preferredWidth >= maxWidth)
					        {
					            preferredWidth = maxWidth;
					            break;
					        }
					    }
					 
					    tableColumn.setPreferredWidth( preferredWidth );
					 
					}
					JScrollPane pane=new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					JFrame j=new JFrame("Records");
					j.getContentPane().add(pane);
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setLocationRelativeTo(SearchBooks.this);
					j.setSize(600,600);
					JButton b=new JButton("Go back");
					b.setFont(new Font("Tahoma", Font.BOLD, 14));
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							j.dispose();
							loginpage.ad=new AdminPage();
							loginpage.ad.setVisible(true);
						}
					});
					j.getContentPane().add(b,new BorderLayout().SOUTH);
					loginpage.ad.dispose();
					j.setVisible(true);
					
					}
				}
				else if(comboBox.getSelectedItem()=="PUBLISHER")
				{	int flag=0;
					String pub=JOptionPane.showInputDialog(SearchBooks.this, "Enter publisher", "Search", JOptionPane.PLAIN_MESSAGE);
					try
					{
					if(pub.equals(""))
					{
						flag=1;
					}
					}
					catch(Exception ex)
					{
						flag=1;
					}
					if(flag==0)
					{
					getHeader();			
					
					getRecord("publisher", pub);
					
					t=new JTable(totalrecords, cols);
					t.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
					 
					for (int column = 0; column < t.getColumnCount()-3; column++)
					{
					    TableColumn tableColumn = t.getColumnModel().getColumn(column);
					    int preferredWidth = tableColumn.getMinWidth();
					    int maxWidth = tableColumn.getMaxWidth();
					 
					    for (int row = 0; row < t.getRowCount(); row++)
					    {
					        TableCellRenderer cellRenderer = t.getCellRenderer(row, column);
					        Component c = t.prepareRenderer(cellRenderer, row, column);
					        int width = 50+c.getPreferredSize().width + t.getIntercellSpacing().width;
					        preferredWidth = Math.max(preferredWidth, width);
					 
					        //  We've exceeded the maximum width, no need to check other rows
					 
					        if (preferredWidth >= maxWidth)
					        {
					            preferredWidth = maxWidth;
					            break;
					        }
					    }
					 
					    tableColumn.setPreferredWidth( preferredWidth );
					}
					JScrollPane pane=new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					add(pane);
					JFrame j=new JFrame("Records");
					j.getContentPane().add(pane);
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setLocationRelativeTo(SearchBooks.this);
					j.setSize(600,600);
					JButton b=new JButton("Go back");
					b.setFont(new Font("Tahoma", Font.BOLD, 14));
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							j.dispose();
							loginpage.ad=new AdminPage();
							loginpage.ad.setVisible(true);
						}
					});
					j.getContentPane().add(b,new BorderLayout().SOUTH);
					loginpage.ad.dispose();
					j.setVisible(true);
					}
					
				}
				else if(comboBox.getSelectedItem()=="SUBJECT")
				{
					int flag=0;
					String sub=JOptionPane.showInputDialog(SearchBooks.this, "Enter subject", "Search", JOptionPane.PLAIN_MESSAGE);
					try
					{
					if(sub.equals(""))
					{
						flag=1;
					}
					}
					catch(Exception ex)
					{
						flag=1;
					}
					if(flag==0)
					{
					getHeader();			
					
					getRecord("subject", sub);
					
					t=new JTable(totalrecords, cols);
					t.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
					 
					for (int column = 0; column < t.getColumnCount()-3; column++)
					{
					    TableColumn tableColumn = t.getColumnModel().getColumn(column);
					    int preferredWidth = tableColumn.getMinWidth();
					    int maxWidth = tableColumn.getMaxWidth();
					 
					    for (int row = 0; row < t.getRowCount(); row++)
					    {
					        TableCellRenderer cellRenderer = t.getCellRenderer(row, column);
					        Component c = t.prepareRenderer(cellRenderer, row, column);
					        int width =50+ c.getPreferredSize().width + t.getIntercellSpacing().width;
					        preferredWidth = Math.max(preferredWidth, width);
					 
					        //  We've exceeded the maximum width, no need to check other rows
					 
					        if (preferredWidth >= maxWidth)
					        {
					            preferredWidth = maxWidth;
					            break;
					        }
					    }
					 
					    tableColumn.setPreferredWidth( preferredWidth );
					}
					JScrollPane pane=new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					JFrame j=new JFrame("Records");
					j.getContentPane().add(pane);
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setLocationRelativeTo(SearchBooks.this);
					j.setSize(600,600);
					JButton b=new JButton("Go back");
					b.setFont(new Font("Tahoma", Font.BOLD, 14));
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							j.dispose();
							loginpage.ad=new AdminPage();
							loginpage.ad.setVisible(true);
						}
					});
					j.getContentPane().add(b,new BorderLayout().SOUTH);
					loginpage.ad.dispose();
					j.setVisible(true);
					}
					
				}
				else if(comboBox.getSelectedItem()=="CATEGORY")
				{
					int flag=0;
					String cat=JOptionPane.showInputDialog(SearchBooks.this, "Enter category", "Search", JOptionPane.PLAIN_MESSAGE);
					try
					{
					if(cat.equals(""))
					{
						flag=1;
					}
					}
					catch(Exception ex)
					{
						flag=1;
					}
					if(flag==0)
					{
					getHeader();			
					
					getRecord("category", cat);
					
					t=new JTable(totalrecords, cols);
					t.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
					 
					for (int column = 0; column < t.getColumnCount()-3; column++)
					{
					    TableColumn tableColumn = t.getColumnModel().getColumn(column);
					    int preferredWidth = tableColumn.getMinWidth();
					    int maxWidth = tableColumn.getMaxWidth();
					 
					    for (int row = 0; row < t.getRowCount(); row++)
					    {
					        TableCellRenderer cellRenderer = t.getCellRenderer(row, column);
					        Component c = t.prepareRenderer(cellRenderer, row, column);
					        int width = 50+c.getPreferredSize().width + t.getIntercellSpacing().width;
					        preferredWidth = Math.max(preferredWidth, width);
					 
					        //  We've exceeded the maximum width, no need to check other rows
					 
					        if (preferredWidth >= maxWidth)
					        {
					            preferredWidth = maxWidth;
					            break;
					        }
					    }
					 
					    tableColumn.setPreferredWidth( preferredWidth );
					}
					JScrollPane pane=new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					JFrame j=new JFrame("Records");
					j.getContentPane().add(pane);
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setLocationRelativeTo(SearchBooks.this);
					j.setSize(600,600);
					JButton b=new JButton("Go back");
					b.setFont(new Font("Tahoma", Font.BOLD, 14));
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							j.dispose();
							loginpage.ad=new AdminPage();
							loginpage.ad.setVisible(true);
						}
					});
					j.getContentPane().add(b,new BorderLayout().SOUTH);
					loginpage.ad.dispose();
					j.setVisible(true);
					
					}
				}
				else
				{
					
					getHeader();
					String query="Select * from book";
					try
					{
						Connection con=DBInfo.getConnection();
						PreparedStatement ps=con.prepareStatement(query);
						ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
							Vector<String> singleRecord=new Vector<String>();  
			    			String s1=rs.getString(1);
			    			String s2=rs.getString(2);
			    			String s3=rs.getString(3);
			    			String s4=rs.getString(4);
			    			String s5=rs.getString(5);
			    			String s6=rs.getString(6);
			    			String s7=rs.getString(7);
			    			String s8=rs.getString(8);
			    			String s9=rs.getString(9);
			    			String s10=rs.getString(10);
			    			singleRecord.add(s1);
			    			singleRecord.add(s2);
			    			singleRecord.add(s3);
			    			singleRecord.add(s4);
			    			singleRecord.add(s5);
			    			singleRecord.add(s6);
			    			singleRecord.add(s7);
			    			singleRecord.add(s8);
			    			singleRecord.add(s9);
			    			singleRecord.add(s10);
			    			totalrecords.add(singleRecord);
						}
					}
					catch(SQLException f)
					{
						f.printStackTrace();
					}
					t=new JTable(totalrecords, cols);
					t.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
					 
					for (int column = 0; column < t.getColumnCount()-3; column++)
					{
					    TableColumn tableColumn = t.getColumnModel().getColumn(column);
					    int preferredWidth = tableColumn.getMinWidth();
					    int maxWidth = tableColumn.getMaxWidth();
					 
					    for (int row = 0; row < t.getRowCount(); row++)
					    {
					        TableCellRenderer cellRenderer = t.getCellRenderer(row, column);
					        Component c = t.prepareRenderer(cellRenderer, row, column);
					        int width = 50+c.getPreferredSize().width + t.getIntercellSpacing().width;
					        preferredWidth = Math.max(preferredWidth, width);
					 
					        //  We've exceeded the maximum width, no need to check other rows
					 
					        if (preferredWidth >= maxWidth)
					        {
					            preferredWidth = maxWidth;
					            break;
					        }
					    }
					 
					    tableColumn.setPreferredWidth( preferredWidth );
					}
					JScrollPane pane=new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					JFrame j=new JFrame("Records");
					
					
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setLocationRelativeTo(SearchBooks.this);
					j.getContentPane().add(pane);
					JButton b=new JButton("Go back");
					b.setFont(new Font("Tahoma", Font.BOLD, 14));
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							j.dispose();
							adminnew();
							
						}
					});
					j.getContentPane().add(b,new BorderLayout().SOUTH);
					
					admindis();
					j.setSize(600,600);
					
					
					
					
					j.setVisible(true);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPageTabbedpane.remove("Search book");
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblSearchBooksBy)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(459, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(75)
										.addContainerGap(430, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addComponent(lblSearchBooksBy))
					.addGap(174)
					
					.addContainerGap(231, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	public void adminnew()
	{
		loginpage.ad=new AdminPage();
		loginpage.ad.setVisible(true);
	}
	public void admindis()
	{
		loginpage.ad.dispose();
	}
}
