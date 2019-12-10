
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage {



	private JFrame frame;

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

		JButton button = new JButton("User (All user accounts): Display ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 58, 414, 41);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("User (All user accounts): Delete");
		button_1.setBounds(10, 109, 414, 41);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("LoginRecord (All records): Display");
		button_2.setBounds(10, 160, 414, 41);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("LoginRecord (All records):  Delete");
		button_3.setBounds(10, 207, 414, 41);
		frame.getContentPane().add(button_3);
		frame.setVisible(true);
	}
}
