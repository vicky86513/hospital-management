/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Dao;

import hospital.dbutil.DBConnection;
import hospital.pojo.Emppojo;
//import hospital.pojo.Receptionistpojo;
import hospital.pojo.UserDetailspojo;
import hospital.pojo.Userpojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Shweta
 */

    public class ReceptionistDao {
    public static boolean addreceptionist(UserDetailspojo p) throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users1 values(?,?,?,?,?)");
        ps.setString(1,p.getUserid());
        ps.setString(2,p.getUserName());
        ps.setString(3,p.getEmpid());
        ps.setString(4,p.getPassword());
        ps.setString(5,p.getUserType());
        int x=ps.executeUpdate();
        return x>0;
    }
       public static ArrayList<UserDetailspojo> getAllReceptionist()throws SQLException{
      Statement st=DBConnection.getConnection().createStatement();
    ResultSet rs=st.executeQuery("select * from users1 where userType='RECEPTIONIST'");
    ArrayList<UserDetailspojo> receptionistList=new ArrayList<>();
    while(rs.next()){
        UserDetailspojo e=new UserDetailspojo();
        e.setEmpid(rs.getString(3));
        e.setUserName(rs.getString(2));
        e.setUserType(rs.getString(5));
        e.setUserid(rs.getString(1));
       receptionistList.add(e);
        
    }
    return receptionistList;
    }

   
/*
public static boolean updatePassword(String userid,String pwd)throws SQLException{
PreparedStatement ps = DBConnection.getConnection().prepareStatement("update users1 set password=? where userid=?");
ps.setString(1,pwd);
ps.setString(2,userid);
//return(ps.executeUpdate()!=0);
int result =ps.executeUpdate();
if(result==1)
    return true;
return false;
} 

   

    public static HashMap <String,String> getReceptionistList() throws SQLException{
    Statement st= DBConnection.getConnection().createStatement();
      ResultSet rs=st.executeQuery("select userid from users1 where usertype='RECEPTIONIST'");
      HashMap<String,String> receptionistList=new HashMap<>();
      while(rs.next()){
       UserDetailspojo e=new UserDetailspojo();
       receptionistList.put(rs.getString(1),rs.getString(2));
      }    
      return receptionistList;
    }
      /*public static HashMap<String,Receptionistpojo>loadReceptionistDetails()throws SQLException{
      Statement st=DBConnection.getConnection().createStatement();
      String qry="Select * from users1";
      ResultSet rs=st.executeQuery(qry);
      HashMap <String,Receptionistpojo> receptionistList=new HashMap<>();
      while(rs.next()){
          Receptionistpojo rec=new Receptionistpojo();
          rec.setReceptionistid(rs.getString(1));
          receptionistList.put(rec.getReceptionistid(),rec);
           }
      return receptionistList;
     }
        public static Receptionistpojo searchEmp(String str) throws SQLException {
        Receptionistpojo e =null;
   PreparedStatement ps= DBConnection.getConnection().prepareStatement("select * from employeess where empid=?");
     ps.setString(1,str);
     ResultSet rs=ps.executeQuery();
    //  ArrayList<Emppojo>emplist=new ArrayList();
      while(rs.next()){
       e=new Receptionistpojo();
       e.setReceptionistid(rs.getString(1));
      // e.setReceptionistName(rs.getString(2));
       //e.setJob(rs.getString(3));
      // e.setSal(rs.getDouble(4));
     //  emplist.add(e);
    }
     return e;
        }
   */   
      
      
     
    
       ////////////////////////////////////
        public static boolean deleteReceptionist(String id) throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from users1 where empId=?");
        ps.setString(1,id);
        int result=ps.executeUpdate();
          ps=DBConnection.getConnection().prepareStatement("delete from employeess where empid=?");
        ps.setString(1,id);
         result=ps.executeUpdate();
       
        if(result==1)
            return true;
        return false;
    }
       

    public static String getSal(String empId) throws SQLException {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("select sal from employeess where empid=?");
        ps.setString(1,empId);
        ResultSet rs=ps.executeQuery();
        String sal="";
        if(rs.next())
           sal= rs.getString(1);
        return sal;
    }
   
    public static String getName(String id)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select userName from users1 where empid=?");
        ps.setString(1,id);
        ResultSet rs=ps.executeQuery();
        String n="";
        if(rs.next())
           n= rs.getString(1);
        return n;
    }
    }


         
     

