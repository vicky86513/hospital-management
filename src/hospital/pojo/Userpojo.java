
package hospital.pojo;


public class Userpojo {

    @Override
    public String toString() {
        return "Userpojo{" + "userId=" + userId + ", password=" + password + ", userType=" + userType + '}';
    }

  

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
     private String userId;
    private String password;
    private String userType;
   // private String empid;
    //private String UserName;
    
    
}
