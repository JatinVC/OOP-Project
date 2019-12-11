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
import java.util.Scanner;
import java.io.File;
public class G18M4MAIN implements ActionListener{
  int arID = 0;
  JFrame frame = new JFrame("Rainbow Six Training");
  JPanel panel = new JPanel();
  JLabel information = new JLabel("Here you can make appointments for Rainbow Six Siege Training");
  JButton aboutMe = new JButton("About Me");
  JButton bookAppointment = new JButton("Book an Appointment");
  JButton viewAppointment = new JButton("View Booked Appointments");

  G18M4MAIN(){
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    panel.add(bookAppointment);
    panel.add(viewAppointment);
    panel.add(aboutMe);
    frame.add(panel, BorderLayout.SOUTH);
    frame.add(information);
    aboutMe.addActionListener(this);
    bookAppointment.addActionListener(this);
    viewAppointment.addActionListener(this);
    frame.setSize(500,500);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("About Me")){
      aboutMe();
    }else if(ae.getActionCommand().equals("Book an Appointment")){
      bookAppointment(Login.user.getUID());
    }else if(ae.getActionCommand().equals("View Booked Appointments")){
      viewAppointment(Login.user.getUID());
    }
  }

  public void aboutMe(){
    ImageIcon pic = new ImageIcon("Jatin.jpeg");
    JOptionPane.showMessageDialog(null, "My name is Jatin Chandwaney (20090263)\n I play Rainbow six like a beast\nG18, 2019-2020, OOP", "Hello", JOptionPane.INFORMATION_MESSAGE, pic);
  }
  public void bookAppointment(int uID){
    String reservedDate, reservedTime, appointmentType, remarks;
    LocalDateTime timeRecorded = LocalDateTime.now();
    reservedDate = JOptionPane.showInputDialog(null, "When do you want to have the appointment? Type in [DD/MM/YYYY]");
    reservedTime = JOptionPane.showInputDialog(null, "What time do you want to book?");
    String[] types = {"Attack", "Defense", "General Guidance"};
    //check if time is valid
    appointmentType = (String) JOptionPane.showInputDialog(null, "Choose Appointment Topic", "Topic", JOptionPane.INFORMATION_MESSAGE, null, types, types[1]);
    remarks = JOptionPane.showInputDialog(null, "Any remarks?");
    String reservedDateTime = reservedDate + reservedTime;
    G18M4APPOINTMENT appointment = new G18M4APPOINTMENT(arID, uID, reservedDateTime, appointmentType, timeRecorded.toString(), remarks);
    updateRecord(appointment);
  }

  public static void updateRecord(G18M4APPOINTMENT appointment){
    int arID = appointment.getarID();
    int uID = appointment.getUID();
    String reservedDateTime = appointment.getReservedTime();
    String appointmentType = appointment.getAppointmentType();
    String timeRecorded = appointment.getTimeRecorded();
    String remarks = appointment.getRemarks();

    try{
      FileWriter fw = new FileWriter("G18M4CHANDWANEY.csv", true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      pw.println(Integer.toString(arID)+","+Integer.toString(uID)+","+reservedDateTime+","+appointmentType+","+timeRecorded+","+remarks);
      pw.flush();
      pw.close();
    }catch(Exception e){
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  public void viewAppointment(int uID){
    JFrame appointments = new JFrame("Appointments");
    JTable table;
    String[] columnNames = {"AR_ID","U_ID","RESERVED_TIME","APPOINTMENT_TYPE","TIME_RECORDED","REMARKS"};
    List<String[]> data = new ArrayList<String[]>();
    try {
      Scanner scan = new Scanner(new File("G18M4CHANDWANEY.csv"));
      scan.nextLine();
      String[] line;
      while(scan.hasNext()){
        line = scan.nextLine().split(",");
        if(line[1].equals(Integer.toString(uID))){
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
