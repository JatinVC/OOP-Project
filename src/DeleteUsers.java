import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import java.io.File;
import java.io.FileNotFoundException;
public class DeleteUsers {

	public JFrame frame;
	private static String[] user = new String[1024];
	private static int count = 0;
	/**
	 * Create the application.
	 */
	public DeleteUsers() {
		initialize();

}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String apple = "";
		try {
		      File myBBB = new File("G18User.csv");
		      Scanner myReader = new Scanner(myBBB);
		      count = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        user[count] = data;
		        count++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e4) {
		      e4.printStackTrace();
		    }

	for(int i =0;i <count;i++){
		apple = apple + user[i] + "\n";
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 13, 291, 174);
		frame.getContentPane().add(scrollPane);

		JTextPane orange = new JTextPane();
		scrollPane.setViewportView(orange);
		orange.setText(apple);
	}
}
