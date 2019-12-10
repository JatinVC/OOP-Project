public class User{
  private int uID;
  private String pwd;
  private String uName;
  private String uRole;
  private int yearOfBirth;
  private String remarks;

  public User(int uID, String pwd, String uName, String uRole, int yearOfBirth, String remarks){
    this.uID = uID;
    this.pwd = pwd;
    this.uName = uName;
    this.uRole = uRole;
    this.yearOfBirth = yearOfBirth;
    this.remarks = remarks;
  }
  public int getUID(){
    return uID;
  }
  public void setUID(int uID){
    this.uID = uID;
  }
  public String getPwd(){
    return pwd;
  }
  public void setPwd(String pwd){
    this.pwd = pwd;
  }
  public String getUName(){
    return uName;
  }
  public void setUName(String uName){
    this.uName = uName;
  }
  public String getURole(){
    return uRole;
  }
  public void setURole(String uRole){
    this.uRole = uRole;
  }
  public int getYearOfBirth(){
    return yearOfBirth;
  }
  public void setYearOfBirth(int yearOfBirth){
    this.yearOfBirth = yearOfBirth;
  }
  public String getRemarks(){
    return this.remarks;
  }
  public void setRemarks(String remarks){
    this.remarks = remarks;
  }
}
