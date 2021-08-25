
package hospital.Dao;
import hospital.dbutil.DBConnection;
import hospital.pojo.UserDetailspojo;
import hospital.pojo.Userpojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;



public class UserDao {
    public static String validateUser(Userpojo user)throws SQLException 
       {
        Connection conn=DBConnection.getConnection();
        String qry="select username from Users1 where userid=?and password=? and userType=?";
           System.out.println(user);
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        String username=null;
        if(rs.next())
        { 
            username=rs.getString(1);
        }
        return username;
    
    }
     

    public static boolean addUser(UserDetailspojo user) throws SQLException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Connection conn=DBConnection.getConnection();
        String qry="insert into users1 values(?,?,?,?,?)";
           System.out.println(user);
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserid());
        ps.setString(4,user.getPassword());
        ps.setString(5,user.getUserType());
        ps.setString(3,user.getEmpid());
        ps.setString(2,user.getUserName());
        //ResultSet rs=ps.executeQuery();
          int rs=ps.executeUpdate();
          return rs==1;
        //String username=null;
    }
 public static HashMap<String,String> getReceptionistIdList() throws SQLException{
     Statement st=DBConnection.getConnection().createStatement();   
    ResultSet rs=st.executeQuery("select Empid,userName from users1 where userType='RECEPTIONIST'");
         HashMap<String,String> ReceptionistIdList=new HashMap<>();
         while(rs.next()){
            //String s=rs.getString(1);
            ReceptionistIdList.put(rs.getString(1),rs.getString(2));
         }
         return ReceptionistIdList;
         
     
     }
       public static boolean updatePassword(String pass,String id)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users1 set password= ? where empid=?");
        ps.setString(1,pass);
        ps.setString(2,id);
        int result=ps.executeUpdate();
        if(result==1)
            return true;
        return false;
        
    }
}
    
    

