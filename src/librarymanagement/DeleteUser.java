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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class DeleteUser extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	
	public DeleteUser() {
		setSize(526, 433);
		setBorder(new TitledBorder(null, "Add new user", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel = new JLabel("Enter id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Enter name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnterPassword = new JLabel("Enter email");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblConfirmPassword = new JLabel("Enter password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnterMobileNo = new JLabel("Enter mobile no.");
		lblEnterMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnterUsertype = new JLabel("Enter usertype");
		lblEnterUsertype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
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
		passwordField.setEnabled(false);
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Student"}));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				
				if(textField.getText().equals(""))
				{
					label.setText("*");
					textField.setBorder(BorderFactory.createLineBorder(Color.red));
					flag=1;
				}	
				if(flag==0)
				{
					String t=textField.getText();
					
					if(t.equals(""))
					{

						textField.setBorder(BorderFactory.createLineBorder(Color.red));
						label.setText("*");

					}
					else
					{
					
					String query="Delete from registration where id=?";
					try
					{
					PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);
					ps.setString(1, t);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(DeleteUser.this, "User deleted", "Done!", JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_5.setText(null);
					comboBox.setSelectedIndex(0);
					passwordField.setText(null);
					}
					catch(SQLException g)
					{
						g.printStackTrace();
					}
					
					}
				}


				}
			
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_2.setText(null);
				passwordField.setText(null);
				textField_5.setText(null);
				textField_1.setText(null);
				comboBox.setSelectedIndex(0);
				JTextField t=new JTextField();
				Border b=t.getBorder();
				textField.setBorder(b);
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
				AdminPageTabbedpane.remove("Delete user");
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.RED);
		
		JButton button_2 = new JButton("SEARCH");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t=textField.getText();
				
				if(t.equals(""))
				{

					textField.setBorder(BorderFactory.createLineBorder(Color.red));
					label.setText("*");

				}
				else
				{
				
				String query="Select * from registration where id=?";
				try
				{
				PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);
				ps.setString(1, t);
				ResultSet res=ps.executeQuery();
				while(res.next())
				{
					
					textField_1.setText(res.getString(2));
					comboBox.setSelectedItem(res.getString(5));
					textField_2.setText(res.getString(3));
					passwordField.setText(res.getString(4));
					textField_5.setText(res.getString(6));
					btnDelete.setEnabled(true);
				
					
				}
				
				}
				
				catch(SQLException g)
				{
					g.printStackTrace();
				}
				
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblEnterUsertype, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblEnterPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblConfirmPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblEnterMobileNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
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
							.addGap(27)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addGap(18)
							.addComponent(label_5))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEnterMobileNo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsertype, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	
		

	}

	

}