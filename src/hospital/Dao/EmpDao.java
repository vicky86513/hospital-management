/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Dao;

import hospital.dbutil.DBConnection;
import hospital.pojo.Emppojo;
import java.sql.Connection;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.net.aso.e;

/**
 *
 * @author Shweta
 */
public class EmpDao {
    public static String getNewId()throws SQLException{
        Statement st=DBConnection.getConnection().createStatement();//not dynamic so statament is used here
        ResultSet rs=st.executeQuery("select max(empid) from employeess");
        int id =1;  
        if(rs.next()){   
        String empid=rs.getString(1);
        int eno=Integer.parseInt(empid.substring(1));
        id=id+eno;
        }
        System.out.println("E"+ id);
        return  "E"+id;
    }
    public static boolean addEmployee(Emppojo e) throws SQLException{
      PreparedStatement ps= DBConnection.getConnection().prepareStatement("insert into employeess values(?,?,?,?)");
       //query is dynamic thatwhy use prepared statement here.
      ps.setString(1,e.getEmpid());
      ps.setString(2,e.getEmpname());
      ps.setString(3,e.getJob());
      ps.setDouble(4,e.getSal());
      int x=ps.executeUpdate();
      return x==1;
    }  
    public static ArrayList<Emppojo>getAllEmp()throws SQLException{
      Statement st= DBConnection.getConnection().createStatement();
      ResultSet rs=st.executeQuery("select * from employeess");
      ArrayList<Emppojo> emplist=new ArrayList<>();
      while(rs.next()){
      Emppojo e=new Emppojo();
       e.setEmpid(rs.getString(1));
       e.setEmpname(rs.getString(2));
       e.setJob(rs.getString(3));
       e.setSal(rs.getDouble(4));
       emplist.add(e);
    }
    return emplist;
}
 public static boolean deleteEmp(String id) throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from users1 where empid=?");
        ps.setString(1,id);
        int result=ps.executeUpdate();
        ps=DBConnection.getConnection().prepareStatement("delete from employeess where empid=?");
        ps.setString(1,id);
         result=ps.executeUpdate();
        if(result==1)
            return true;
        return false;
    }
 public static ArrayList<String> getEmpIdList() throws SQLException{
         Statement st=DBConnection.getConnection().createStatement();
         ResultSet rs=st.executeQuery("select Empid from employeess");
         ArrayList<String> empIdList=new ArrayList<>();
         while(rs.next()){
            String s=rs.getString(1);
            empIdList.add(s);
         }
         return empIdList;
         
     }
 public static boolean updateEmployee(Emppojo e)throws SQLException{
       PreparedStatement ps= DBConnection.getConnection().prepareStatement("update Employeess set empname=?,role=?,sal=? where empid=?");
       ps.setString(4, e.getEmpid());
       ps.setString(1, e.getEmpname());
       ps.setString(2, e.getJob());
       ps.setDouble(3,e.getSal());
       int result =ps.executeUpdate();
       if (result!=0)
           return true;
       else
           return false;
        
    }
 public static Emppojo findEmpById(String eno)throws SQLException{
        Emppojo e=null;
        PreparedStatement ps= DBConnection.getConnection().prepareStatement("select * from Employeess where empid=?");
        ps.setString(1,eno);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            e=new Emppojo();
            e.setEmpid(rs.getString(1));
            e.setEmpname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSal(rs.getDouble(4));
            
         }
        return e;
    }
   
    public static HashMap<String,String> getNonRegisteredReceptionist()throws SQLException{
          String qry="select empid, Empname from employeess where role='RECEPTIONIST' and empid not in (select empid from users1 where userType='RECEPTIONIST')";
          Statement st=DBConnection.getConnection().createStatement();
          ResultSet rs=st.executeQuery(qry);
          HashMap<String,String> hm=new HashMap();
          while (rs.next()){
              String id=rs.getString(1);
              String name=rs.getString(2);
              hm.put(id, name);
          }
          return hm;
          
      }
     public static HashMap<String,String> getNonRegisteredDoctors()throws SQLException{
          String qry="select empid, Empname from employeess where role='DOCTOR'and empid not in (select empId from users1 where userType='DOCTOR')";
          Statement st=DBConnection.getConnection().createStatement();
          ResultSet rs=st.executeQuery(qry);
          HashMap<String,String> hm=new HashMap();
          while (rs.next()){
              String id=rs.getString(1);
              String name=rs.getString(2);
              hm.put(id, name);
          }
          return hm;
          
      }
      public static String getEmpId(String Ename)throws SQLException{
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("select EmpId from employeess where Empname=?");
        ps.setString(1,Ename);
        ResultSet rs=ps.executeQuery();
        String id=null;
        if(rs.next())
          id=rs.getString(1);
        return id;
        
    }}

 

