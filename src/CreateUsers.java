import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class CreateUsers {

	private static String[] user = new String[1024];
	private static int count = 0;
	private JFrame frame;
	private JTextField textNewUsername;
	private JTextField textNewPassword;
	/**
	 * Create the application.
	 */
	public CreateUsers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New Username:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 52, 158, 47);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewPassword.setBounds(10, 127, 158, 47);
		frame.getContentPane().add(lblNewPassword);

		textNewUsername = new JTextField();
		textNewUsername.setFont(new Font("Arial", Font.BOLD, 20));
		textNewUsername.setBounds(177, 52, 247, 47);
		frame.getContentPane().add(textNewUsername);
		textNewUsername.setColumns(10);

		textNewPassword = new JTextField();
		textNewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		textNewPassword.setColumns(10);
		textNewPassword.setBounds(177, 127, 247, 47);
		frame.getContentPane().add(textNewPassword);

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      File myObj = new File("users.txt");
				      Scanner myReader = new Scanner(myObj);
				      count = 0;
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        user[count] = data;
				        count++;
				      }
				      myReader.close();
				    } catch (FileNotFoundException e1) {
				      e1.printStackTrace();
				    }

				try {
				      FileWriter myWriter = new FileWriter("users.txt");
				      for (int i = 0; i < count; i ++) {
				    	  String temp = user[i];
				    	  myWriter.write(temp+"\n");
				      }
				      String newName = textNewUsername.getText();
				      String newPw = textNewPassword.getText();
				      myWriter.write(newName+"\n");
				      myWriter.write(newPw);
				      myWriter.close();
				    } catch (IOException e2) {
				    	JOptionPane.showMessageDialog(null, "Error!","Error!", JOptionPane.ERROR_MESSAGE);
				      e2.printStackTrace();
				    }
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(32, 184, 158, 47);
		frame.getContentPane().add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNewUsername.setText(null);
				textNewPassword.setText(null);
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 20));
		btnClear.setBounds(243, 184, 158, 47);
		frame.getContentPane().add(btnClear);
	}
}
