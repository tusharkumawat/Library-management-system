package librarymanagement;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class NewUser extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public String userid()
	{
		String id="";
		for(int i=0;i<=6;i++)
		{
			id+=(int)((Math.random()*9)+1);
		}
		return id;
	}
	public NewUser() {
		JTextField t=new JTextField();
		Border b=t.getBorder();
		setSize(526, 526);
		setBorder(new TitledBorder(null, "Add new user", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel = new JLabel("Enter id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Enter name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnterPassword = new JLabel("Enter email");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblConfirmPassword = new JLabel("Enter password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblConfirmPassword_1 = new JLabel("Confirm password");
		lblConfirmPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnterMobileNo = new JLabel("Enter mobile no.");
		lblEnterMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnterUsertype = new JLabel("Enter usertype");
		lblEnterUsertype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField(userid());
		textField.setEnabled(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JLabel label=new JLabel("");
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.RED);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.RED);
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADMIN", "STUDENT"}));
		
		JButton button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int flag=0;
				
				if(textField_1.getText().equals(""))
				{
					label_1.setText("*");
					textField_1.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(textField_2.getText().equals(""))
				{
					label_2.setText("*");
					textField_2.setBorder(BorderFactory.createLineBorder(Color.red));
				
					flag=1;
					}
				
				if(String.valueOf(passwordField.getPassword()).equals(""))
				{
					label_3.setText("*");
					passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
					}
				if(String.valueOf(passwordField_1.getPassword()).equals(""))
				{
				label_4.setText("*");
					passwordField_1.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				if(textField_5.getText().equals(""))
				{
					label_5.setText("*");
					textField_5.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}
				
				if(flag==0)
				{
				insertion();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(userid());
				textField_2.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);
				textField_5.setText(null);
				textField_1.setText(null);
				comboBox.setSelectedIndex(0);
				textField_1.setBorder(b);
				textField_2.setBorder(b);
				textField_5.setBorder(b);
				JPasswordField p=new JPasswordField();
				Border bb=p.getBorder();
				passwordField.setBorder(bb);
				passwordField_1.setBorder(bb);
				label.setText("");
				label_1.setText("");
				label_2.setText("");
				label_3.setText("");
				label_4.setText("");
				label_5.setText("");
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button_1 = new JButton("X");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPageTabbedpane.remove("Add user");
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.RED);
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblEnterUsertype, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEnterPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblConfirmPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblConfirmPassword_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEnterMobileNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(passwordField))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5)
								.addComponent(label_4)
								.addComponent(label_3)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1))
								.addComponent(label_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(88, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(467, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(button_1)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterMobileNo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsertype, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	
		

	}
	public void insertion()
	{
		DBInfo.getConnection();
		String query="Insert into registration values(?,?,?,?,?,?)";
		
		int flag=0;
		String pass=String.valueOf(passwordField.getPassword());
		
		String repass=String.valueOf(passwordField_1.getPassword());
		
		if(pass.equals(repass))
		{
		try
		{
		PreparedStatement ps=DBInfo.con.prepareStatement(query);
		ps.setString(1, textField.getText());
		ps.setString(2, textField_1.getText().toUpperCase());
		ps.setString(3, textField_2.getText());
		ps.setString(5, (String)(comboBox.getSelectedItem()));
		ps.setString(4, pass);
		
		ps.setString(6, textField_5.getText());
		
		flag=ps.executeUpdate();
		}
		catch(SQLException f)
		{
			f.printStackTrace();
		}
		if(flag==0)
    	{
    		JOptionPane.showMessageDialog(AdminPage.obj, "User not Added", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	if(flag==1)
    	{
    		JOptionPane.showMessageDialog(AdminPage.obj, "User Added", "Added", JOptionPane.INFORMATION_MESSAGE);
    		textField.setText(userid());
    		textField_1.setText(null);
    		textField_2.setText(null);
    	
    		passwordField.setText(null);
    		passwordField_1.setText(null);
    		textField_5.setText(null);
    		
    	}
	
	}
	else
	{
		JOptionPane.showMessageDialog(AdminPage.obj, "User not Added", "Error", JOptionPane.ERROR_MESSAGE);
	 	
	}
}
}