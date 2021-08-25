/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Dao;

import hospital.dbutil.DBConnection;
import hospital.pojo.Doctorspojo;
import hospital.pojo.Patientpojo;
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
public class DoctorsDao {
   
    public static boolean addDoctor(Doctorspojo user) throws SQLException {
         { 
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into doctors values(?,?,?,?,'y')");
       ps.setString(1, user.getUserid());
         ps.setString(4, user.getSpecilist());
         ps.setString(3, user.getQulification());
         ps.setString(2, user.getDoctorid());
         
          //ps.setString(3, user.getEmpid());
          //   ps.setString(4, user.getPassword());
          //  ps.setString(5, user.getUserType().toUpperCase());
             System.out.println("doctor"+user);
        int x=ps.executeUpdate();
        if(x>0){
            return true;
        }else{
            return false;
        }
    }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public static String getName(String id) throws SQLException{
    PreparedStatement ps=DBConnection.getConnection().prepareStatement("select UserName from users1 where userid=?");
    ps.setString(1,id);
    ResultSet rs=ps.executeQuery();
    String n="";
    if(rs.next())
        n=rs.getString(1);
     return n;
}
      public static ArrayList <String> getDoctorList() throws SQLException{
          ArrayList<String> list=new ArrayList<>();
        Statement st= DBConnection.getConnection().createStatement();
      ResultSet rs=st.executeQuery("select doctorid from doctors");
     // HashMap<String,String> DoctorList=new HashMap<>();
      while(rs.next()){
     // UserDetailspojo e=new UserDetailspojo();
       String s=rs.getString(1);
       list.add(s);
      }    
      return list;
    }
      public static HashMap<String,Doctorspojo>loadDoctorDetails()throws SQLException{
      Statement st=DBConnection.getConnection().createStatement();
      String qry="Select * from users1";
      ResultSet rs=st.executeQuery(qry);
      HashMap <String,Doctorspojo> DoctorList=new HashMap<>();
      while(rs.next()){
          Doctorspojo rec=new Doctorspojo();
          rec.setDoctorid(rs.getString(1));
          DoctorList.put(rec.getDoctorid(),rec);
           }
      return DoctorList;
     }
        public  static String getNewDoctorId()throws SQLException{
    Statement st=DBConnection.getConnection().createStatement();
    ResultSet rs=st.executeQuery("select max(doctorid) from doctors");
    int id=1;
    if(rs.next()){
        if(rs.getString(1)!=null){
        String docid=rs.getString(1);
        int n=Integer.parseInt(docid.substring(4));
        id=id+n;
        }
        else
        id=101;
    }
    
        System.out.println("DOC_"+id);
    return "DOC_"+id;
        }

    
      public static ArrayList<String> getDoctorIdList() throws SQLException{
         Statement st=DBConnection.getConnection().createStatement();
         ResultSet rs=st.executeQuery("select doctorid from doctors where Active='y'");
         ArrayList<String> DoctorIdList=new ArrayList<>();
         while(rs.next()){
            //String s=rs.getString(1);
           DoctorIdList.add(rs.getString(1));
         }
         return DoctorIdList;
         
     }

    public static ArrayList<Doctorspojo> getAllDoctor() throws SQLException {
        
      Statement st= DBConnection.getConnection().createStatement();
      ResultSet rs=st.executeQuery("select * from doctors where active='y'");
      ArrayList<Doctorspojo> a =new ArrayList<>();
      while(rs.next()){
      Doctorspojo e=new Doctorspojo();
       e.setDoctorid(rs.getString(1));
       e.setUserid(rs.getString(2));
       e.setQulification(rs.getString(3));
       e.setSpecilist(rs.getString(4));
       a.add(e);
    }
      return a;
}
    public static boolean deleteDoctor(String id) throws SQLException{
       
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update doctors set active='N' where doctorid=?");
        ps.setString(1,id);
        int result=ps.executeUpdate();
    
        if(result==1)
            return true;
        return false;
    }
   
      
    public static String getUserId(String docId) throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select userid from doctors where doctorid=?");
        ps.setString(1,docId);
        ResultSet rs=ps.executeQuery();
        String userId=null;
        if(rs.next()){
            userId=rs.getString(1);
        }
        return userId;
    }

    public static String getDoctorId(String userId) throws SQLException {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select doctorId from doctors where userId=?");
        ps.setString(1,userId);
        ResultSet rs=ps.executeQuery();
        String dId=null;
        if(rs.next()){
            dId=rs.getString(1);
        }
        return dId;
    }
    
}
