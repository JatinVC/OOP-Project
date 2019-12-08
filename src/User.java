public class User{
  private int uID;
  private String pwd;
  private String uName;
  private String uRole;
  private int yearOfBirth;
  private String remarks;

  User(int uID, String pwd, String uName, String uRole, int yearOfBirth, String remarks){
    this.uID = uID;
    this.pwd = pwd;
    this.uName = uName;
    this.uRole = uRole;
    this.yearOfBirth = yearOfBirth;
    this.remarks = remarks;
  }
  // getters and setters for this class
  public int getUID(){
    return uID;
  }
  public void int setUid(int uID){
    this.uID = uID;
  }
  public String getPwd(){
    return pwd;
  }
  public void String setPwd(String pwd){
    this.pwd = pwd;
  }
  public String getUName(){
    return uName;
  }
  public void String setUName(String uName){
    this.uName = uName;
  }
  public String getURole(){
    return uRole;
  }
  public void String setURole(String uRole){
    this.uRole = uRole;
  }
  public int getYearOfBirth(){
    return yearOfBirth;
  }
  public void int setYearOfBirth(int yearOfBirth){
    this.yearOfBirth = yearOfBirth;
  }
  public String getRemarks(){
    return remarks;
  }
  public void String setRemarks(String remarks){
    this.remarks = remarks;
  }

  //methods allowed on user
  public static List<User> getUsers(String filePath){
    return readUserFromFile(filePath);
  }
  private static List<User> readUserFromFile(String filePath){
    List<User> users = new ArrayList<>();
    Path pathToFile = Paths.get(filePath);

    try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
      //skip first line of csv file
      br.readLine();
      String line = null;
      while((line = br.readLine()) != null ){
        String[] userAttributes = line.split(",");
        User user = createUser(userAttributes);
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
    return users;
  }

  private static User createUser(String[] metadata){
    int uID = metadata[0];
    String pwd = metadata[1];
    String uName = metadata[2];
    String uRole = metadata[3];
    int yearOfBirth = metadata[4];
    String remarks = metadata[5];

    return new User(uID, pwd, uName, uRole, yearOfBirth, remarks);
  }
}
