import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.io.*;
import java.util.*;


public class G18m1WONG extends JFrame implements ActionListener {
	JPanel panelBelow = new JPanel(); 
	JLabel labelInfo = new JLabel("This is the system for you applying the game of OverWatch.");
	
	JLabel Photo = new JLabel(new ImageIcon("overwatch.jpg"));
	JButton butAboutMe = new JButton("About Me");
	JButton apply = new JButton("Apply");
	JButton display = new JButton("Display");

	G18m1WONG(){ 
	setTitle ( "Overwatch Appointment System" );
	setSize ( 450, 450 );
	setDefaultCloseOperation ( EXIT_ON_CLOSE );
	initGUI();
	}
	public void initGUI(){
	
		panelBelow.add(apply);
		panelBelow.add(display);
		panelBelow.add(butAboutMe);
		add(Photo, BorderLayout.CENTER);
		add(panelBelow, BorderLayout.SOUTH);
		add(labelInfo, BorderLayout.NORTH);
		butAboutMe.addActionListener(this);
		
		apply.addActionListener( new ActionListener() {	
		public void actionPerformed(ActionEvent event1) { 	
				String ID = JOptionPane.showInputDialog(null, "What is your uid?");
				String Date = JOptionPane.showInputDialog(null, 
					"What is the date you want to reserve? Please follow the format: [dd/mm/yyyy]");
				String[] optVal = { "Attack", "Healing", "Defense" };
				String Appointment_Type = (String) JOptionPane.showInputDialog(null, 
					"Choose your hero type", "hero type Input",
					JOptionPane.INFORMATION_MESSAGE,
					null, optVal, optVal[0]);
				Date today = new Date();
				SimpleDateFormat CurrentDayTime = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
				SimpleDateFormat CurrentDay = new SimpleDateFormat("yyyyMMddHHmmss");
			try{
			
				String date2 = CurrentDayTime.format(today);
				String date3 = CurrentDay.format(today);
			
				FileWriter file = new FileWriter("G18m1WONG.csv");
				BufferedWriter bwt = new BufferedWriter(file);
				PrintWriter pwr = new PrintWriter(bwt);
			
				pwr.println(ID+","+date3+ID+","+Date+","+Appointment_Type+","+date2);
				pwr.flush();
				pwr.close();
			
				JOptionPane.showMessageDialog(null,"Appointment sucessfully applied");
			}catch(Exception E){
					JOptionPane.showMessageDialog(null, "FoundException", "MESSAGE", JOptionPane.WARNING_MESSAGE);
				}				
		}}
		);
		
		display.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent event2) { 
				String uid = JOptionPane.showInputDialog(null, "What is your uid?");
				ArrayList<String> data = new ArrayList<String>();
				boolean find = false;
				String UID; String ARID; 
				String Date; String AppointmentType; 
				String DateAndTime; String record;
			try{
					Scanner scanner;
					scanner = new Scanner(new File("G18m1WONG.csv"));
					scanner.useDelimiter("[,\n]");
				while(scanner.hasNext()){
						UID = scanner.next();
						if(UID.equals(uid)){
							ARID = scanner.next();
							Date = scanner.next();
							AppointmentType = scanner.next();
							DateAndTime = scanner.next();
							record = UID+","+ARID+","+Date+","+AppointmentType+","+DateAndTime;
							data.add(record);
							find = true;
							}
					}
				if (!find)
					JOptionPane.showMessageDialog(null, "There is no your record(s)");		
					scanner.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "FoundException", "MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				String[] recordsArray = new String[data.size()];
				data.toArray(recordsArray);
				String info = "Your UID, Apointment_Record_ID, Appointment_Date, Appointment_Type, Reservation_Date\n";
				for (String output:recordsArray){
					info = info + output+"\n";
				}
				JOptionPane.showMessageDialog(null, info, "Your appointment record", JOptionPane.INFORMATION_MESSAGE);
		} 
		} );
		
	}
		public void actionPerformed(ActionEvent event3) { 
			JOptionPane.showMessageDialog(null,
				"My information:\n" +
				"Wong Man Ho\n20093274",
				"About Me: G18, 2019-2020, OOP",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("G18m1WONG.jpg"));
		}
	
public static void main(String[] args){ 
	 (new  G18m1WONG()).setVisible(true);
	 }
}