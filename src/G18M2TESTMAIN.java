import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


public class G18M2TESTMAIN implements ActionListener{

	int arID = 0;
  JFrame frame;
	JPanel panel = new JPanel();
	JLabel information = new JLabel("Here you can make appointments for League of Legends");
	JButton aboutMe = new JButton("About Me");
	JButton Apply = new JButton("Apply");
	JButton Display = new JButton("Display");
	private int newarID, newdatetime;
	String newtimerecorded, newtype;
	G18M2TESTMAIN(int arID2, int uID, String DateTime, String Type, String string, String reuid){
		 frame = new JFrame("The system of League of Legends");
		 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 panel.add(Apply);
		 panel.add(Display);
		 panel.add(aboutMe);
		 frame.add(panel, BorderLayout.SOUTH);
		 frame.add(information);
		 aboutMe.addActionListener(this);
		 Apply.addActionListener(this);
		 Display.addActionListener(this);
		 frame.setSize(500,500);
		 frame.setVisible(true);
		}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("About Me")){
		      aboutMe();
		    }else if(ae.getActionCommand().equals("Apply")){
		      Apply();
		    }else if(ae.getActionCommand().equals("Display")){
		      Display();
		    }
	}

	private void aboutMe() {
		 ImageIcon pic = new ImageIcon("leo.png");
		 JOptionPane.showMessageDialog(null, "My info:\n Mok Chun Chung 20088483,\n 2019-2020, OOP", null, JOptionPane.INFORMATION_MESSAGE, pic);

	}

	 public void Apply(){
		    String Date, Time, reuid, Type;
		    LocalDateTime timeRecorded = LocalDateTime.now();
		    Date = JOptionPane.showInputDialog(null, "When do you want to make an appointment? [DD/MM/YYYY]");
		    Time = JOptionPane.showInputDialog(null, "What time do you want for the appointment?");
		    reuid = JOptionPane.showInputDialog(null, "Your user ID:?");
		    Type = (String) JOptionPane.showInputDialog(null, "Choose Topic (eg Top Land, Jungle):" );
		    String DateTime = Date + Time;
		    G18M2TESTMAIN appointment = new G18M2TESTMAIN(arID, arID, DateTime, Type, timeRecorded.toString(), reuid);
		    updateRecord(appointment);
		  }

	private void updateRecord(G18M2TESTMAIN appointment) {
		int arID = appointment.newarID;
	    int DateTime = appointment.newdatetime;
	    String Type = appointment.newtype;
	    String timeRecorded = appointment.newtimerecorded;

	    try{
	        FileWriter fw = new FileWriter("G18M2TESTMAINrecord.csv", true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        PrintWriter pw = new PrintWriter(bw);

	        String reuid = null;
			pw.println(Integer.toString(arID)+","+DateTime+","+Type+","+reuid+","+timeRecorded+",");
	        pw.flush();
	        pw.close();
	      }catch(Exception e){
	        JOptionPane.showMessageDialog(null, e.getMessage());
	      }
	    }

	    public void Display(){
	      JFrame appointments = new JFrame("Appointments");
	      JTable table;
	      String[] columnNames = {"AR_ID","U_ID","RESERVED_TIME","APPOINTMENT_TYPE","TIME_RECORDED","REMARKS"};
	      List<String[]> data = new ArrayList<String[]>();
	      try {
	        Scanner scan = new Scanner(new File("G18M2TESTMAINrecord.csv"));
	        scan.nextLine();
	        String[] line;
	        while(scan.hasNext()){
	          line = scan.nextLine().split(",");
	          int reuid = 0;
			if(line[1].equals(Integer.toString(reuid))){
	            data.add(line);
	          }
	        }
	        String[][] rowData = data.toArray(new String[0][]);
	        table = new JTable(rowData, columnNames);
	        table.setBounds(30,40,200,300);
	        JScrollPane sp = new JScrollPane(table);
	        appointments.add(sp);
	        appointments.setSize(500,200);
	        appointments.setVisible(true);
	        scan.close();
	      } catch(Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage());
	      }
	}
}
