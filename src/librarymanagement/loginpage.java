package librarymanagement;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class loginpage extends JFrame
{
	static AdminPage ad;
	static StudentPage st;
	static String adminid=new String();
	static String studentid=new String();
	private JTextField textField;
	private JPasswordField passwordField;
	public loginpage() 
	{
		setSize(550, 400);
		setLocationRelativeTo(this);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Enter student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Select usertype");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Admin"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String s1=new String();
				String s2=new String();
				String id=textField.getText();
				char password[]=passwordField.getPassword();
			
				String query="Select password,usertype from registration where id=?";
				try
				{
					PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);
					ps.setString(1, id);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						s1=rs.getString(1);
						s2=rs.getString(2);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(id.equals("") )
				{
					lblNewLabel.setText("*");
					textField.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				if(new String(password).equals(""))
				{
					lblNewLabel_1.setText("*");
					passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				if(s1.equals("") )
				{
					JOptionPane.showMessageDialog(new loginpage(), "Wrong ID entered", "Error!!", JOptionPane.ERROR_MESSAGE);
				}
				else if(!(s1.equals(new String(password))))
						{
					JOptionPane.showMessageDialog(new loginpage(), "Wrong password entered", "Error!!", JOptionPane.ERROR_MESSAGE);
					
						}
				else if(s1.equals(new String(password)))
				{
					
					if(comboBox.getSelectedItem()=="Student"  && s2.equalsIgnoreCase("STUDENT"))
					{
						dispose();
						st=new StudentPage();
						st.setVisible(true);
						studentid=id;
					}
					else if(comboBox.getSelectedItem()=="Admin"  && s2.equalsIgnoreCase("ADMIN"))
					{
						dispose();
						ad=new AdminPage();
						ad.setVisible(true);
						adminid=id;
					}
					else
					{
						JOptionPane.showMessageDialog(new loginpage(), "Wrong input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblEnterPassword)
								.addComponent(lblNewLabel_1))
							.addGap(69)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(146)
							.addComponent(btnLogin)
							.addGap(82)
							.addComponent(btnReset)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_2)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogin)
						.addComponent(btnReset))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}
	public static void main(String args[])
	{
		loginpage l=new loginpage();
		l.setVisible(true);
	}
}
