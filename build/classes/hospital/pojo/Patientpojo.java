/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pojo;

import java.sql.Date;

/**
 *
 * @author Shweta
 */
public class Patientpojo {

    @Override
    public String toString() {
        return "Patientpojo{" + "Opd=" + Opd + ", doctor_id=" + doctor_id + ", f_name=" + f_name + ", s_name=" + s_name + ", P_id=" + P_id + ", gender=" + gender + ", m_status=" + m_status + ", address=" + address + ", City=" + City + ", mno=" + mno + ", age=" + age + ", d=" + d + '}';
    }

    public Patientpojo(String Opd, String doctor_id, String f_name, String s_name, String P_id, String gender, String m_status, String address, String City, String mno, int age, Date d) {
        this.Opd = Opd;
        this.doctor_id = doctor_id;
        this.f_name = f_name;
        this.s_name = s_name;
        this.P_id = P_id;
        this.gender = gender;
        this.m_status = m_status;
        this.address = address;
        this.City = City;
        this.mno = mno;
        this.age = age;
        this.d = d;
    }

    public Patientpojo() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public Patientpojo() {
        
         this.Opd = Opd;
        this.doctor_id = doctor_id;
        this.f_name = f_name;
        this.s_name = s_name;
        this.P_id = P_id;
        this.gender = gender;
        this.m_status = m_status;
        this.address = address;
        this.City = City;
        this.mno = mno;
        this.age = age;
        this.d = d;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public void setOpd(String Opd) {
        this.Opd = Opd;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setP_id(String P_id) {
        this.P_id = P_id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public String getOpd() {
        return Opd;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public String getP_id() {
        return P_id;
    }

    public String getGender() {
        return gender;
    }

    public String getM_status() {
        return m_status;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return City;
    }

    public String getMno() {
        return mno;
    }

    public int getAge() {
        return age;
    }

    public Date getD() {
        return d;
    }

    public Patientpojo(String opd, String doctor_id, String f_name, String s_name, int age, String p_id, String gender, String m_status, String address, String city, String mno, Date date) {
        this.Opd = opd;
        this.doctor_id = doctor_id;
        this.f_name = f_name;
        this.s_name = s_name;
        this.P_id = p_id;
        this.gender = gender;
        this.m_status = m_status;
        this.address = address;
        this.City = city;
        this.mno = mno;
        this.age = age;
        this.d = date;
    }
   private String Opd,doctor_id,f_name,s_name,P_id,gender,m_status,address,City,mno;
   private int age;
   private Date d;

   
}