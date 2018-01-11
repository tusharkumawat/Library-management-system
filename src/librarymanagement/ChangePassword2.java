package librarymanagement;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPasswordField;

public class ChangePassword2 extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

		public ChangePassword2() {
		setSize(518,388);
		setBorder(new TitledBorder(null, "Change password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel l1 = new JLabel("Enter existing password");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel l2 = new JLabel("Enter new password");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel l3 = new JLabel("Confirm new password");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char existpass[]=passwordField_1.getPassword();
				char newpass[]=passwordField.getPassword();
				char confpass[]=passwordField_2.getPassword();
				if(new String(newpass).equals(new String(confpass)))
				{
					String query="Select password from registration where id=?";   //static user ID to be created
				int flag=0;
				try
				{
					PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);
					ps.setString(1, loginpage.studentid);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						String pass=rs.getString(1);
						if(pass.equals(new String(existpass)))
								{
							
									flag=1;
								}
					}
					if(flag==1)
					{
						String confpaass=new String(confpass);
						
						query="Update registration set password=? where id=?";
						ps=DBInfo.getConnection().prepareStatement(query);
						ps.setString(2, loginpage.studentid);
						ps.setString(1,confpaass );
						ps.executeUpdate();
						JOptionPane.showMessageDialog(new ChangePassword2(), "Password changed", "Success!!", JOptionPane.INFORMATION_MESSAGE);
						passwordField.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
					}
					else
					{
						
						JOptionPane.showMessageDialog(new ChangePassword2(), "Wrong password", "Error!!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(new ChangePassword2(), "Password not confirmed", "Error!!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				passwordField_1.setText("");
				passwordField_2.setText("");
			
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		
		JLabel label1 = new JLabel("");
		label1.setForeground(Color.RED);
		
		JLabel label2 = new JLabel("");
		label2.setForeground(Color.RED);
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		passwordField_2 = new JPasswordField();
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentPageTabbedpane.remove("Change password");
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(82, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(l1)
									.addComponent(l2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
									.addComponent(l3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(16)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(54)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(193)
											.addComponent(label2))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(193)
											.addComponent(label1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(passwordField_2, Alignment.LEADING)
												.addComponent(passwordField)
												.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
											.addGap(36)
											.addComponent(label))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(79)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(button)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(l1)
						.addComponent(label)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(l2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(l3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	

	}
}
