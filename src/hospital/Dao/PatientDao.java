/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Dao;

import hospital.dbutil.DBConnection;
import hospital.pojo.Emppojo;
import hospital.pojo.Patientpojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Shweta
 */

public class PatientDao{
   
    
    public static boolean addPatient(Patientpojo pp)throws SQLException{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
     ps.setString(1,pp.getP_id());
        ps.setString(2,pp.getF_name());
        ps.setString(3,pp.getS_name());
        ps.setInt(4,pp.getAge());
        ps.setString(5,pp.getOpd());
        ps.setString(6,pp.getGender());
        ps.setString(7,pp.getM_status());
        ps.setDate(8, (java.sql.Date) pp.getD());
        ps.setString(9,pp.getAddress());
        ps.setString(10,pp.getCity());
        ps.setString(11,pp.getMno());
        ps.setString(12,pp.getDoctor_id());
        int r=ps.executeUpdate();
        return r==1;
   } 
    
     public static String getNewId()throws SQLException{
        Statement st=DBConnection.getConnection().createStatement();//not dynamic so statament is used here
       // String qry="select  count(*) from employeess";
        //ResultSet rs=st.executeQuery("select  count(*) from employeess");
        ResultSet rs=st.executeQuery("select max(P_id) from patient");
       // int id=101;
        int id =1;   //atleast one row is there thats why we can remove if statment from here.
        //if(rs.next()){
           // id =id+rs.getInt(1);
       if(rs.next()){   
       String empid=rs.getString(1);
         System.out.println(empid.substring(1));
        int eno =Integer.parseInt(empid.substring(1));
        id=id+eno;
        String sr="P"+ id;
        return sr;
       }
     else
        return "P101";
     }
    public static ArrayList<Patientpojo> getAllPatients() throws Exception {
       Date d=new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String str=sdf.format(d);
        Statement st= DBConnection.getConnection().createStatement();
      ResultSet rs=st.executeQuery("select * from patient");
      ArrayList<Patientpojo> a =new ArrayList<>();
      while(rs.next()){
    Patientpojo e=new Patientpojo(rs.getString(5),rs.getString(12),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(1),rs.getString(6),rs.getString(7),rs.getString(9),rs.getString(10),rs.getString(11),new java.sql.Date(d.getTime()));
       a.add(e);
    }
      return a;
}
     public static boolean deletePatient(String id)throws SQLException{
      PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from Patient where P_id=?");
      ps.setString(1, id);
      int result=ps.executeUpdate();
      return result==1;
}     

        public static HashMap<String,Patientpojo> loadP_Details()throws SQLException{
            Date d=new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String str=sdf.format(d);
            Statement st=DBConnection.getConnection().createStatement();
      String qry="Select * from patient";
      ResultSet rs=st.executeQuery(qry);
      HashMap <String,Patientpojo> pList=new HashMap<>();
      while(rs.next()){
          Patientpojo p=new Patientpojo();
          p.setP_id(rs.getString(1));
           pList.put(p.getP_id(),p);
         }
      return pList;
} 
        
        public static ArrayList<String> getPatientIdList() throws SQLException{
         Statement st=DBConnection.getConnection().createStatement();
         ResultSet rs=st.executeQuery("select P_Id from patient");
         ArrayList<String> patientIdList=new ArrayList<>();
         while(rs.next()){
            //String s=rs.getString(1);
           patientIdList.add(rs.getString(1));
         }
         return patientIdList;
         
     }

   public static boolean UpdatePatient(Patientpojo pp)throws SQLException {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("Update patient set f_name=?,s_name=?,age=?,opd=?,gender=?,m_status=?,p_date=?,address=?,city=?,Phone_no=?,doctor_id=? where p_id=?");
                   //Update patient set f_name=?,s_name=?,age=?,opd=?,gender=?,m_status=?,p_date=?,address=?,city=?,phone_no=?,doctorId=? where p_id=?"
          ps.setString(12,pp.getP_id());
        ps.setString(1,pp.getF_name());
        ps.setString(2,pp.getS_name());
        ps.setInt(3,pp.getAge());
        ps.setString(4,pp.getOpd());
        ps.setString(5,pp.getGender());
        ps.setString(6,pp.getM_status());
        ps.setDate(7, (java.sql.Date) pp.getD());
        ps.setString(8,pp.getAddress());
        ps.setString(9,pp.getCity());
        ps.setString(10,pp.getMno());
        ps.setString(11,pp.getDoctor_id());
        int r=ps.executeUpdate();
        return r==1;
   }
       
   
    
  public static boolean checkMno(String mno,String id)throws SQLException {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select phone_no from patient where P_Id=?");
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        String phoneNo=null;
        if(rs.next()){
            phoneNo=rs.getString(1);
        }
        if(phoneNo.equals(mno))
            return false;
        return true;
        
    }
   
  /* public static HashMap<String,String> getAppointments(String docId) throws SQLException {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select p_id ,f_name from patient where doctor_id=?");
        ps.setString(1,docId);
        ResultSet rs=ps.executeQuery();
        HashMap<String,String> hs=new HashMap<>();
        while(rs.next()){
            hs.put(rs.getString(1),rs.getString(2));
        }
        return hs;
    }  */public static ArrayList<Patientpojo> getAppointment(String uid) throws SQLException{
         PreparedStatement st=DBConnection.getConnection().prepareStatement("select doctorid from doctors where userid=?");
         st.setString(1, uid);
         String s=null;
         ResultSet rs=st.executeQuery();
         if(rs.next())
             s=rs.getString(1);
        // System.out.println("YES1");
        PreparedStatement st1=DBConnection.getConnection().prepareStatement("select * from patient where doctor_id=?");
        st1.setString(1,s);
        ResultSet rs1=st1.executeQuery();
        // System.out.println("Yes2");
        ArrayList<Patientpojo> a=new ArrayList<>();
        while(rs1.next()){
            Patientpojo e=new Patientpojo();
            e.setP_id(rs1.getString(1));
            e.setF_name(rs1.getString(2));
            e.setS_name(rs1.getString(3));
            e.setAge(rs1.getInt(4));
            e.setOpd(rs1.getString(5));
           e.setGender(rs1.getString(6));
            e.setM_status(rs1.getString(7));
            e.setD(rs1.getDate(8));
            e.setAddress(rs1.getString(9));
            e.setCity(rs1.getString(10));
            e.setMno(rs1.getString(11));
            e.setDoctor_id(rs1.getString(12));
            a.add(e);
        }
        return a;
    }   
 public static Patientpojo getPatientDetails(String pid) throws SQLException{
        Date d=new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String str=sdf.format(d);
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from Patient where P_id=?");
        ps.setString(1,pid);
        ResultSet rs=ps.executeQuery();
        Patientpojo e=null;
        if(rs.next()){
         e=new Patientpojo(rs.getString(5),rs.getString(12),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(1),rs.getString(6),rs.getString(7),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDate(8));
    }
    return e;
        
    }
public static Patientpojo searchPatient(String pid) throws SQLException{
        Patientpojo e=null;
        
        PreparedStatement pst=DBConnection.getConnection().prepareStatement("select * from patient where p_id=?");
        pst.setString(1, pid);
        ResultSet rs=pst.executeQuery();
        if(rs.next()){
            //java.util.Date d=new java.util.Date(.getTime());
            e=new Patientpojo();
            e.setP_id(pid);
            e.setF_name(rs.getString(2));
            e.setS_name(rs.getString(3));
            e.setAge(rs.getInt(4));
            e.setOpd(rs.getString(5));
            e.setGender(rs.getString(6));
            e.setM_status(rs.getString(7));
            e.setD(rs.getDate(8));
            e.setAddress(rs.getString(9));
            e.setCity(rs.getString(10));
            e.setMno(rs.getString(11));
            e.setDoctor_id(rs.getString(12));
                   // e=new PatientPojo(rs.getString(5),rs.getString(12),rs.getString(2),rs.getString(3),rs.getString(1),rs.getString(6),rs.getString(7),rs.getString(9),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getDate(8));
                    System.out.println("p1:"+e);

        }
        return e;
    }
     public static ArrayList<String> getPatientList() throws SQLException{
       ArrayList<String> list=new ArrayList<>();
         Statement st=DBConnection.getConnection().createStatement();
         ResultSet rs=st.executeQuery("select p_id from patient");
         while(rs.next()){
             String s=rs.getString(1);
             
             list.add(s);
         }
         return list;
     }
 
}

  

      