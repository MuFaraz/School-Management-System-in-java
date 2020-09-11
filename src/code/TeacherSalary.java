/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Faraz
 */
public class TeacherSalary {
    private String name;
    private String id;
    private int Salary;
    private int increment;
    private int attendance;
    private int advanceSalary;
    private int retensionDeduction;
    private int incentives;
    private int lasMonthRetension;

    public TeacherSalary() {
    }
    Connection2DB connection=new Connection2DB();
        Connection con = connection.setConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;
         Finance finance=new Finance();
           int mont=finance.getMonth();
           
           String m=finance.getMonthString(mont);
    public void addTeacherSalary(){
           try {
            String sql = "Insert into TeacherSalary(ID,Name,Salary,increament,SalaryAfterIncreament,Attendence,GrossSalary,AdvanceSalary,RetensionDeducted,incentives,NetSalary,LastMonthRetension,TotalRetension,month) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
          
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setInt(3,Salary);
            pst.setInt(4,0);
            pst.setInt(5,Salary);
            pst.setInt(6,0);
            pst.setInt(7,0);
            pst.setInt(8,0);
            pst.setInt(9,0);
            pst.setInt(10,0);
            pst.setInt(11,0);
            pst.setInt(12,0);
            pst.setInt(13,0);
            pst.setInt(14,getMonth());
           
            pst.execute();
//            pst.close();
            
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }
    }
    public void updateSalaryAfterIncome(int salary,int id){
        try {   
    String sql = "UPDATE TeacherSalary SET SalaryAfterIncreament = '"+salary+"'"+"WHERE month = '"+getMonth()+"'"+"AND ID = '"+id+"'" ;//,FatherName=?,CellNumone=?,CellNumtwo=?,CellNumthree=?,Grade=?,fees=?,Section=?, AdmissionDate=? WHERE IDnum = '"+ID+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
    }
    public void SalaryAfterIncreament(int id){//,int id,int name){
        Statement st;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//where ID='" +id+ "'"+"AND Name = '"+name+"'"+"AND month = '"+m+"'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
               int salary =rs.getInt("Salary");
                int  increament=rs.getInt("increament");    
                int total=salary+increament;
                updateSalaryAfterIncome(total,id);
                updateGrossSalary(id, salary);
                updateAbsent(id);
//                int  grossss=rs.getInt("GrossSalary");    
//                int  advance=rs.getInt("AdvanceSalary");    
//                int  incentives=rs.getInt("incentives");    
//                int  retension=rs.getInt("RetensionDeducted");    
//                int totalnet=net(grossss, advance, incentives, retension);
//                updatenetSalary(id, totalnet);
//                updateLastRetent(id);
//                int lastre=rs.getInt("LastMonthRetension");
//                int totalretent=TotalRetenten(retension, lastre);
//                updateTotalRetension(id, totalretent);
S(id);
                totalR(id);
                       }
        
        } catch (Exception ex) {
//            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void S(int id){//,int id,int name){
        Statement st;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//where ID='" +id+ "'"+"AND Name = '"+name+"'"+"AND month = '"+m+"'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                int  grossss=rs.getInt("GrossSalary");    
                int  advance=rs.getInt("AdvanceSalary");    
                int  retension=rs.getInt("RetensionDeducted");    
                    
                int totalnet=net(grossss, advance, incentives, retension);
                updatenetSalary(id, totalnet);
                updateLastRetent(id);
               
                       }
        
        } catch (Exception ex) {
//            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void totalR(int id){//,int id,int name){
        Statement st;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//where ID='" +id+ "'"+"AND Name = '"+name+"'"+"AND month = '"+m+"'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                int  retension=rs.getInt("RetensionDeducted");
     int lastre=rs.getInt("LastMonthRetension");
//                int totalretent=retension+lastre;
int totalretent=TotalRetenten(retension, lastre);
                updateTotalRetension(id, totalretent);
//                System.out.println(totalretent);
                       }
        
        } catch (Exception ex) {
//            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
JOptionPane.showMessageDialog(null, ex);
        }
    }
    public int net(int gros,int advance,int ince,int ret){
        int aa=(gros+advance+ince)-(advance+ret);
        return aa;
    }
    public int getMonth() {
        Calendar cal = Calendar.getInstance();
       int  monthint = cal.get(Calendar.MONTH)+1;
//        System.out.println(monthint);
        return monthint;
    }
    public void updateAbsent(int id){
        try {   
    String sql = "UPDATE TeacherSalary SET Attendence = '"+getAbsents(id)+"'"+"WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//,FatherName=?,CellNumone=?,CellNumtwo=?,CellNumthree=?,Grade=?,fees=?,Section=?, AdmissionDate=? WHERE IDnum = '"+ID+"'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update gross","Record", JOptionPane.ERROR_MESSAGE);
          } 
    }
    public int getAbsents(int id){
        Statement st;
        int absent=0;
        int month=getMonth()-1;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate WHERE ID = '" +id+ "'AND Month='" +month+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("Absent");
            }          
        
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
     public int calculatelateSalary(int sal,int late){
         int month=getMonth()-1;
          if (month==0) {
              month=12;
          }
          LocalDate date = LocalDate.of(getYear(), month, 1);
          int days = date.lengthOfMonth();
          System.out.println(days);
          int a=sal;
          days=days/2;
          a=a/days;
          a=a*late;
          sal=sal-a;
          return sal;
      }
      public int calculateabsentSalary(int sal,int abs){
          int month=getMonth()-1;
          if (month==0) {
              month=12;
          }
          LocalDate date = LocalDate.of(getYear(), month, 1);
          int days = date.lengthOfMonth();
          System.out.println(days);
          int a=sal;
          a=a/days;
          a=a*abs;
//          System.out.println(a);
          sal=sal-a;
//          System.out.println(sal);
          return sal;
      }
      public int getYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
//        System.out.println(year);
        return year;
    }
      public void updateGrossSalary(int id,int basic){
          System.out.println("------------------------------------------------");
//          System.out.println(getAbsents(id));
//          int bas=
          try {   
    String sql = "UPDATE TeacherSalary SET GrossSalary = '"+calculateabsentSalary(basic, getAbsents(id))+"'"+"WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//,FatherName=?,CellNumone=?,CellNumtwo=?,CellNumthree=?,Grade=?,fees=?,Section=?, AdmissionDate=? WHERE IDnum = '"+ID+"'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update gross","Record", JOptionPane.ERROR_MESSAGE);
          } 
      }
      public void updatenetSalary(int id,int sal){
          try {   
    String sql = "UPDATE TeacherSalary SET NetSalary = '"+sal+"'"+"WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//,FatherName=?,CellNumone=?,CellNumtwo=?,CellNumthree=?,Grade=?,fees=?,Section=?, AdmissionDate=? WHERE IDnum = '"+ID+"'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update gross","Record", JOptionPane.ERROR_MESSAGE);
          } 
      }
      public void updateLastRetent(int id){
          try {   
    String sql = "UPDATE TeacherSalary SET LastMonthRetension = '"+lastRetantion(id)+"'"+"WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//,FatherName=?,CellNumone=?,CellNumtwo=?,CellNumthree=?,Grade=?,fees=?,Section=?, AdmissionDate=? WHERE IDnum = '"+ID+"'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update gross","Record", JOptionPane.ERROR_MESSAGE);
          } 
      }
      public int lastRetantion(int id){
          Statement st;
        int retension=0;
        int a=getMonth()-1;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary WHERE ID = '" +id+ "'AND month='" +a+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 retension=rs.getInt("LastMonthRetension");
            }          
        
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
        return retension;
      }
      public int TotalRetenten(int retuensionde,int lastRet){
          int a=retuensionde+lastRet;
          return a;
      }
      public void updateTotalRetension(int id,int sal){
          try {   
    String sql = "UPDATE TeacherSalary SET TotalRetension = '"+sal+"'"+"WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'";//,FatherName=?,CellNumone=?,CellNumtwo=?,CellNumthree=?,Grade=?,fees=?,Section=?, AdmissionDate=? WHERE IDnum = '"+ID+"'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update gross","Record", JOptionPane.ERROR_MESSAGE);
          } 
      }
      
}
