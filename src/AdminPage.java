
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.io.FileWriter;
import java.io.IOException;
public class AdminPage {

	private static String[] user = new String[1024];
	private static int count = 0;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPage() {
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

		JButton btnNewButton = new JButton("Create new User account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateUsers create = new CreateUsers();
			}
		});
		btnNewButton.setBounds(10, 10, 414, 41);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton1 = new JButton("User (All user accounts): Display ");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUsers display = new DeleteUsers();
				display.frame.setVisible(true);
			}
		}
				);
		btnNewButton1.setBounds(10, 58, 414, 41);
		frame.getContentPane().add(btnNewButton1);

		JButton btnNewButton2 = new JButton("User (All user accounts): Delete");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter myWriter = new FileWriter("G18User.csv");
					JOptionPane.showMessageDialog(null, " File Cleared","System message", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error!","Opps!!!", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		}
		);
		btnNewButton2.setBounds(10, 109, 414, 41);
		frame.getContentPane().add(btnNewButton2);

		JButton btnNewButton3 = new JButton("LoginRecord (All records): Display");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteLoginRecord displayLR = new DeleteLoginRecord();
				displayLR.frame.setVisible(true);
			}
		});
		btnNewButton3.setBounds(10, 160, 414, 41);
		frame.getContentPane().add(btnNewButton3);

		JButton btnNewButton4 = new JButton("LoginRecord (All records):  Delete");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter myWriter = new FileWriter("G18LoginRecord.csv");
					JOptionPane.showMessageDialog(null, " LoginRecord Cleared","System message", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "Error!","Opps!!!", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
		btnNewButton4.setBounds(10, 207, 414, 41);
		frame.getContentPane().add(btnNewButton4);
	}
}
