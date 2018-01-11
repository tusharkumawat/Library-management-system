package librarymanagement;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class studprofile extends JPanel

{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_5_1;
	public studprofile()
	{
		setSize(518,508);
		setBorder(new TitledBorder(null, "Student profile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblUsertype = new JLabel("Usertype");
		lblUsertype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMobileNo = new JLabel("Mobile no.");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField((String) null);
		textField.setEnabled(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				if(textField.equals(""))
				
				if(textField_1.equals(""))
				{
					textField_1.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(textField_2.equals(""))
				{
					textField_2.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(textField_3.equals(""))
				{
					textField_3.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
					}
				if(flag==0)
				{
					String query="Update registration set name=?,email=?,mobile=? where id=?";
					try
					{
						PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);
					
						ps.setString(1, textField_1.getText());
						ps.setString(2, textField_2.getText());
						ps.setString(3, textField_3.getText());
						ps.setString(4, textField.getText());
						ps.executeUpdate();
						JOptionPane.showMessageDialog(new studprofile(), "Profile updated!!","Success",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception exx)
					{
						exx.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setEnabled(false);
		textField_5 = new JTextField((String) null);
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		JButton btnEditProfile_1 = new JButton("EDIT PROFILE");
		btnEditProfile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(true);
			
				btnNewButton.setEnabled(true);
			}
		});
		btnEditProfile_1.setEnabled(false);
		btnEditProfile_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.RED);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(Color.RED);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(Color.RED);
		
		JLabel label_10 = new JLabel("");
		
		JLabel label_11 = new JLabel("");
		label_11.setForeground(Color.RED);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.RED);
		
		
		
		JButton btnEditProfile = new JButton("GET PROFILE");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query="Select name,email,usertype,mobile from registration where id=?";
				String name=new String();
				String email=new String();
				String usertype=new String();
				String mobile=new String();
				try
				{
					PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);
					ps.setString(1, loginpage.studentid);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						name=rs.getString(1);
						email=rs.getString(2);
						usertype=rs.getString(3);
						mobile=rs.getString(4);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
				textField.setText(loginpage.studentid);
				textField_1.setText(name);
				textField_2.setText(email);
				textField_3.setText(mobile);
				textField_5_1.setText(usertype);
				btnEditProfile_1.setEnabled(true);
			}
		});
		btnEditProfile.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentPageTabbedpane.remove("Student profile");}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		
		textField_5_1 = new JTextField();
		textField_5_1.setEnabled(false);
		textField_5_1.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(457, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMobileNo, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblUsertype, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addGap(65)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addGap(65)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(362)
										.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addGap(65)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
											.addComponent(textField_5_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
								.addGap(67)))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(btnEditProfile)
					.addGap(44)
					.addComponent(btnEditProfile_1)
					.addGap(45)
					.addComponent(btnNewButton)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUsertype, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobileNo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditProfile, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditProfile_1)
						.addComponent(btnNewButton))
					.addGap(148))
		);
		setLayout(groupLayout);
		
	}
}
