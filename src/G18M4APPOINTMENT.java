public class G18M4APPOINTMENT{
  private int arID;
  private int uID;
  private String reservedTime;
  private String appointmentType;
  private String timeRecorded;
  private String remarks;
  public G18M4APPOINTMENT(int arID, int uID, String reservedTime, String appointmentType,String timeRecorded, String remarks){
    this.arID = arID;
    this.uID = uID;
    this.reservedTime = reservedTime;
    this.appointmentType = appointmentType;
    this.timeRecorded = timeRecorded;
    this.remarks = remarks;
  }
  public int getarID(){
    return arID;
  }
  public void setARID(int arID){
    this.arID = arID;
  }
  public int getUID(){
    return uID;
  }
  public void setUID(int uID){
    this.uID = uID;
  }
  public String getReservedTime(){
    return reservedTime;
  }
  public void setReservedTime(String reservedTime){
    this.reservedTime = reservedTime;
  }
  public String getAppointmentType(){
    return appointmentType;
  }
  public void setAppointmentType(String appointmentType){
    this.appointmentType = appointmentType;
  }
  public String getTimeRecorded(){
    return timeRecorded;
  }
  public void setTimeRecorded(String timeRecorded){
    this.timeRecorded = timeRecorded;
  }
  public String getRemarks(){
    return remarks;
  }
  public void setRemarks(String remarks){
    this.remarks = remarks;
  }
}
