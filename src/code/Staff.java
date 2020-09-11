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
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

import java.time.LocalDate;
import javax.print.DocFlavor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
/**
 *
 * @author Muhammad Faraz
 */
public class Staff {
    private int sNo;
    private String EmployeeName;
    private String Designation;
    private String Contact;
    private String DateOfJoining;
    private int basicSalary;
    public Staff(JTextField sNum){
//        sNo=0;
        countSNO(sNum);
    }
    public Staff(int sNo, String EmployeeName, String Designation, String Contact, String DateOfJoining, int basicSalary) {
        this.sNo = sNo;
        this.EmployeeName = EmployeeName;
        this.Designation = Designation;
        this.Contact = Contact;
        this.DateOfJoining = DateOfJoining;
        this.basicSalary = basicSalary;
    }
Finance finance =new Finance();
    public Staff(String EmployeeName, String Designation, String Contact, String DateOfJoining, int basicSalary) {
        this.EmployeeName = EmployeeName;
        this.Designation = Designation;
        this.Contact = Contact;
        this.DateOfJoining = DateOfJoining;
        this.basicSalary = basicSalary;
    }
    
    public int getsNo() {
        return sNo;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getContact() {
        return Contact;
    }

    public String getDateOfJoining() {
        return DateOfJoining;
    }

    public int getBasicSalary() {
        return basicSalary;
    }
public String getMonthString(int monthint,String monthString) {
         
         
        Calendar cal = Calendar.getInstance();
//        monthint = cal.get(Calendar.MONTH)+1;
        switch (monthint) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        return monthString;
    }
    public Staff() {
    }
    Connection2DB connection=new Connection2DB();
    Connection con=connection.setConnection();
    ResultSet rs=null;
    ResultSet ra=null;
    PreparedStatement pst=null;
     public void addStaff() {
        try {
           // link.addTeacherLinkList(teacherId, teacherName, fatherName, teacherCnic, age, Contact, joiningDate, gender, salary, address);
            String sql = "Insert into Staff(Sno,Name,Designation,Contact,DateOfJoining,BasicSalary,advance,incentive,retentiondeduction) values (?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1,getsNo());
            pst.setString(2, getEmployeeName());
            pst.setString(3, getDesignation());
            pst.setString(4, getContact());
            pst.setString(5, getDateOfJoining());
            pst.setInt(6, getBasicSalary());
            pst.setInt(7, 0);
            pst.setInt(8, 0);
            pst.setInt(9, 0);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Successfully Saved ","Staff Record",JOptionPane.INFORMATION_MESSAGE);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR","STAFF RECORD", JOptionPane.ERROR_MESSAGE);
       }
    }
    public void countSNO(JTextField snum){
         try{
                sNo=1;
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff ";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  int Sn = rs.getInt("Sno");
                  if (Sn>sNo) {
                      sNo=Sn;
                  }
                  
              }
              sNo++;
              snum.setText(String.valueOf(sNo));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
      
        }
     }
     public String getMonthString(int monthint) {
         
         String monthString;
        Calendar cal = Calendar.getInstance();
//        monthint = cal.get(Calendar.MONTH)+1;
        switch (monthint) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        return monthString;
    }

     public void deleteStaff(String sNo)
    {
        
        try{
            int P = JOptionPane.showConfirmDialog(null," ARE YOU SURE YOU WANT TO DELETE?","CONFIMATION ",JOptionPane.YES_NO_OPTION);
            if (P==0)   
            {
//                link.DeleteTeacherlink(Integer.parseInt(Id));
                String sql="Delete From Staff where Sno = ?";
                pst =con.prepareStatement(sql);
                pst.setString(1, sNo);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted","Records",JOptionPane.INFORMATION_MESSAGE);
            }
            
    }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"CAN'T  DELETE","Record", JOptionPane.ERROR_MESSAGE);
        }
    }
     public boolean searchEmployee(String Id){
        boolean found =false;    
        ResultSet rs=null;
        try {
            
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff WHERE Sno = '"+Id+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String ID = rs.getString("Sno");
                   if(Id.equals(ID) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
//                      System.out.println("Found");
                  }
                  else {
                   
               }
//                      System.out.println("Not Found");
              }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
     public boolean searchEmployeename(String name){
        boolean found =false;          
        try {
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff where Name ='"+name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String ID = rs.getString("Sno");
                  String nam=rs.getString("Name");
                   if(name.equals(nam) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
//                      System.out.println("Found");
                  }
                  else {
                   
               }
//                      System.out.println("Not Found");
              }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }public void payROLLRecord(JTable tab)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public void payrollAll(JTable table,String id,String name,String month,String year){
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE ID = '"+id+"'"+"AND Name = '"+name+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"; 
            try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }public void getSALAryStatus(JTable tab,JTextField txt){
        Statement st;
        int absent=0;
        try {
            int row= tab.getSelectedRow();
          
            String id_click= tab.getModel().getValueAt(row, 0).toString();
            String month_click= tab.getModel().getValueAt(row, 6).toString();
            String year_click= tab.getModel().getValueAt(row, 7).toString();
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where ID='" +id_click+ "'AND Month='" +month_click+ "' AND year='" +year_click+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("dues");
            } 
            if (absent!=0) {
                txt.setText("UNPAID");
            }else
                txt.setText("PAID");
//        JOptionPane.showMessageDialog(null,"already paid","Record", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
       public boolean searchpayrollAll(String id,String name,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql ="select * from TeacherSalary WHERE ID = '"+id+"'"+"AND Name = '"+name+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"; 
        rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(id.equals(Idnum)&&name.equals(stdName)&&Month.equals(month)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
       public void StudentFeesConditionidNameMonth(JTable table,String id,String name,String month){
         String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE ID = '"+id+"'"+"AND Name = '"+name+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"; 
               try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
        public boolean searchstudentfeesidnamemonth(String id,String name,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
           String sql ="select * from TeacherSalary WHERE ID = '"+id+"'"+"AND Name = '"+name+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"; 
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("month");
//                  String Year=rs.getString("year");
                   if(id.equals(Idnum)&&name.equals(stdName)&&Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
        public void StudentFeesConditionidNameYear(JTable table,String id,String name,String year){
         String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE ID = '"+id+"'"+"AND Name = '"+name+"'"+"AND year = '"+year+"'"; 
             try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
         public boolean searchstudentfeesidnameyear(String id,String name,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql ="select * from TeacherSalary WHERE ID = '"+id+"'"+"AND Name = '"+name+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(id.equals(Idnum)&&name.equals(stdName)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
         public void StudentFeesConditionIdMonthYear(JTable table,String id,String month,String year){
          String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE ID = '"+id+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"; 
         try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
          public boolean searchstudentfeesidmonthyear(String id,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql ="select * from TeacherSalary WHERE ID = '"+id+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(id.equals(Idnum)&&Month.equals(month)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
          public void StudentFeesConditionNameMonthYear(JTable table,String name,String month,String year){
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE Name = '"+name+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"; 
         try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
           public boolean searchstudentfeesnamemonthyear(String name,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
          String sql ="select * from TeacherSalary WHERE year = '"+year+"'"+"AND Name = '"+name+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"; 
           rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(name.equals(stdName)&&Month.equals(month)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void StudentFeesConditionidName(JTable table,String id,String name){
  String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE Name = '"+name+"'"+"AND ID = '"+id+"'";//+"AND year = '"+year+"'"; 
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
     public boolean searchstudentfeesidname(String id,String name){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
           String sql ="select * from TeacherSalary WHERE ID = '"+id+"'"+"AND Name = '"+name+"'";//+"AND month = '"+month+"'";//+"AND year = '"+year+"'"; 
           rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("month");
//                  String Year=rs.getString("year");
                   if(id.equals(Idnum)&&name.equals(stdName) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
     public void StudentFeesConditionidMonth(JTable table,String id,String month){
         String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE ID = '"+id+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"; 
      try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
      public boolean searchstudentfeesidmonth(String id,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
    
           String sql ="select * from TeacherSalary WHERE ID = '"+id+"'"+"AND month = '"+month+"'";
           rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
                  String Month=rs.getString("month");
//                  String Year=rs.getString("year");
                   if(id.equals(Idnum)&&Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
      public void StudentFeesConditionidYear(JTable table,String id,String year){
      String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE ID = '"+id+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
   try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public boolean searchstudentfeesidyear(String id,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
    
           String sql ="select * from TeacherSalary WHERE ID = '"+id+"'"+"AND year = '"+year+"'"; 
    rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
//                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(id.equals(Idnum)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
       public void StudentFeesConditionNameMonth(JTable table,String name,String month){
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE Name = '"+name+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"; 
 try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
        public boolean searchstudentfeesnamemonth(String name,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from TeacherSalary WHERE Name = '"+name+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"; 
   rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("month");
//                  String Year=rs.getString("year");
                   if(name.equals(stdName)&&Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
        public void StudentFeesConditionNameYear(JTable table,String name,String year){
        String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE Name = '"+name+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
  try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
         public boolean searchstudentfeesnameyear(String name,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from TeacherSalary WHERE Name = '"+name+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
 rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
//                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(name.equals(stdName)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
         public void StudentFeesConditionMonthYear(JTable table,String month,String year){
          String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE month = '"+month+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
   try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
          public boolean searchstudentfeesmonthyear(String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from TeacherSalary WHERE month = '"+month+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
   rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(Month.equals(month)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
          public void StudentFeesConditionid(JTable table,String id){
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE ID = '"+id+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
           public boolean searchstudentfeesid(String id){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from TeacherSalary WHERE ID = '"+id+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
   rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
//                  String Month=rs.getString("month");
//                  String Year=rs.getString("year");
                   if(id.equals(Idnum) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
           public void StudentFeesConditionname(JTable table,String name){
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE Name = '"+name+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
     try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
            public boolean searchstudentfeesname(String name){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from TeacherSalary WHERE Name = '"+name+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
     rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("month");
//                  String Year=rs.getString("year");
                   if(name.equals(stdName) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
            public void StudentFeesConditionmonth(JTable table,String month){
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE month = '"+month+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
             public boolean searchstudentfeesmonth(String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from TeacherSalary WHERE month = '"+month+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
   rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
                  String Month=rs.getString("month");
//                  String Year=rs.getString("year");
                   if(Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
             public void StudentFeesConditionyear(JTable table,String year){
         String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY],increament as [INCREAMENT], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],AdvanceSalary as [ADVANCE SALARY],RetensionDeducted as [RETENSION DEDUCTED],incentives as [INCENTIVES],NetSalary as [NET SALARY],TotalRetension as [TOTAL RETENTION] from TeacherSalary WHERE year = '"+year+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
     try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
              public boolean searchstudentfeesyear(String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from TeacherSalary WHERE year = '"+year+"'";//+"AND year = '"+year+"'";//+"AND year = '"+year+"'"; 
    rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
//                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
     public boolean searchEmployeenameid(String name,String id){
        boolean found =false;          
        try {
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff where Name ='"+name+"'"+"AND Sno = '"+id+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String ID = rs.getString("Sno");
                  String nam=rs.getString("Name");
                   if(name.equals(nam)&&ID.equals(id) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
//                      System.out.println("Found");
                  }
                  else {
                   
               }
//                      System.out.println("Not Found");
              }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
      public void updateStaff(String SNo){
     
    try {   
    String sql = "UPDATE Staff SET Name=?,Designation=?,Contact=?,DateOfJoining=?,BasicSalary=? WHERE Sno = '"+SNo+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,getEmployeeName());
            pst.setString(2,getDesignation());
            pst.setString(3,getContact());
            pst.setString(4,getDateOfJoining());
            pst.setInt(5,getBasicSalary());
            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          } 
  }
     public void STAFFRecord(JTable tab)
   {
       
       try{
           String sql ="select Sno as [S.NO], Name as [EMPLOYEE NAME],Designation as [DESIGNATION],Contact as [CONTACT],DateOfJoining as [DATE OF JOINING],BasicSalary as [BASIC SALARY] from Staff"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
      public void getDataStaff(JTable table,String search,String Name ){
        String sql="select Sno as [S.NO], Name as [EMPLOYEE NAME],Designation as [DESIGNATION],Contact as [CONTACT],DateOfJoining as [DATE OF JOINING],BasicSalary as [BASIC SALARY] FROM Staff WHERE Sno = '"+search+"'"+" AND Name = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}}
public void getDataStaffID1(JTable table,String search){
        String sql="select Sno as [S.NO], Name as [EMPLOYEE NAME],Designation as [DESIGNATION],Contact as [CONTACT],DateOfJoining as [DATE OF JOINING],BasicSalary as [BASIC SALARY] FROM Staff  WHERE Sno = '"+search+"'";//+"AND Name = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
}
public void getDataStaffNAME(JTable table,String Name ){
        String sql="select Sno as [S.NO], Name as [EMPLOYEE NAME],Designation as [DESIGNATION],Contact as [CONTACT],DateOfJoining as [DATE OF JOINING],BasicSalary as [BASIC SALARY] FROM Staff  WHERE Name = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}}
      public void staffClickTable(JTable jTable1,JTextField NAMETF1,JTextField designation,JTextField contact,JTextField salary ,JTextField idnotf1,JTextField date){
         try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql= "select * from Staff where Sno = '" + table_click + "'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
//                AdminStudent adminStudent=new AdminStudent();
               String Name=rs.getString("Name");
               NAMETF1.setText (Name);
            String  Designation=rs.getString("Designation");
                designation.setText(Designation);
              
               String Contact=rs.getString("Contact");
                contact.setText(Contact);
              
               String Salary=rs.getString("BasicSalary");
                salary.setText(Salary);
              String id=rs.getString("Sno");
              idnotf1.setText(id);
              String Date=rs.getString("DateOfJoining");
              date.setText(Date);
               
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
      }
      public void FeedAttandence(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int dataday=0;
        try{
            Statement st=con.createStatement();
            String sql="Select * FROM Counter ";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){  
                dataday=rs.getInt("day");
            }
        if(day!=dataday){
           staffToAttendance();
           try {   
    String sql1 = "UPDATE Counter SET day='" + day + "'";
            pst = con.prepareStatement(sql1);
         //  pst.setInt(1,0);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }        
    }
        }
    catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error","Connection Error", JOptionPane.ERROR_MESSAGE);
           }}
      public void staffToAttendance(){
          try {
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff ";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  int ID = rs.getInt("Sno");
                  String Name=rs.getString("Name");
                  String sql1 = "Insert into TeacherAttandance(ID,Name,Present,Late,Day,month,year) values (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql1);
            pst.setInt(1,ID);
            pst.setString(2, Name);
            pst.setString(3, "0");
            pst.setString(4, "0");
            pst.setInt(5, getDate());
            pst.setInt(6, getMonth());
            pst.setInt(7, getYear());
            
            pst.execute();
            
                   
              }}
          catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
      }
      public void tableIDNAME(JTable table){
        //  staffToAttendance();
          String sql="select ID as [S.NO], Name as [EMPLOYEE NAME],Present as[Present] from TeacherAttandance WHERE Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
}
      public int getYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
//        System.out.println(year);
        return year;
    }

    public int getMonth() {
        Calendar cal = Calendar.getInstance();
       int  monthint = cal.get(Calendar.MONTH)+1;
//        System.out.println(monthint);
        return monthint;
    }
     public int getDate() {
        Calendar cal = Calendar.getInstance();
       int  monthint = cal.get(Calendar.DATE);
//        System.out.println(monthint);
        return monthint;
    }
      public void F(JTable tab){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int dataday=0;        
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
    //    tab.setModel(model);
   // model.addRow(new Object[6]);
//          System.out.println(getDate());
        int id=0;
        int i=0;
        String present=null;
        String late=null;
        String half=null;
        String leave=null;
        String name;
        try{
            Statement st=con.createStatement();
            String sql="select * from TeacherAttandance WHERE Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){  
                id=rs.getInt("ID");
                name=rs.getString("Name");
                present=rs.getString("Present");
                late=rs.getString("Late");
                half=rs.getString("halfdays");
                leave=rs.getString("leaves");
                Vector row = new Vector();
                row.add(id);
                row.add(name);
              //  row.add("Enter data to column 3");
                model.addRow(row);
                if (present=="1") {
                    tab.getModel().setValueAt(true, i, 2);
                }
                else{
                    tab.getModel().setValueAt(false, i, 2);
                }
                if (late=="1") {
                    tab.getModel().setValueAt(true, i, 3);
                }
                else{
                    tab.getModel().setValueAt(false, i, 3);
                }
                 if (half=="1") {
                    tab.getModel().setValueAt(true, i, 4);
                }
                else{
                    tab.getModel().setValueAt(false, i, 4);
                }
                 if (half=="1") {
                    tab.getModel().setValueAt(true, i, 4);
                }
                else{
                    tab.getModel().setValueAt(false, i, 4);
                }
                 if (leave=="1") {
                    tab.getModel().setValueAt(true, i, 5);
                }
                else{
                    tab.getModel().setValueAt(false, i, 5);
                }
                i++;
            }
        }
    catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error","Connection Error", JOptionPane.ERROR_MESSAGE);
           }}
      public void tableChanged(JTable jTable1) {
    
          for (int i = 0; i <jTable1.getModel().getRowCount(); i++) {
              boolean a=(Boolean) jTable1.getValueAt(i,2);
              boolean b=(Boolean) jTable1.getValueAt(i,3);
              boolean c=(Boolean) jTable1.getValueAt(i,4);
              boolean d=(Boolean) jTable1.getValueAt(i,5);
        if (a)
                    {  
                        String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                      attendancePresent1(id);
                    }
else{
   String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                      attendancePresent0(id);
}
       
        if (b)
                    {  
                        String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                        attendanceLate1(id);
                    }
else{
   String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                      attendanceLate0(id);
}
        if (c)
                    {  
                        String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                      attendanceHalf1(id);
                    }
else{
   String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                      attendancehalf0(id);
}if (d)
                    {  
                        String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                        attendanceleave1(id);
                    }
else{
   String id =(String.valueOf(jTable1.getValueAt(i,0)));
//                       System.out.println(id);
                      attendanceleave0(id);
}
       
  
}}
public void tablefalse(JTable jTable1) {
          for (int i = 0; i <jTable1.getModel().getRowCount(); i++) {
                       jTable1.getModel().setValueAt(false, i, 2);
  
}}
public void attendancePresent1(String id){
          try{
            String sql = "UPDATE TeacherAttandance SET Present=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"1");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
            
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN present", JOptionPane.ERROR_MESSAGE);
        
          }
      }
public void attendanceHalf1(String id){
          try{
            String sql = "UPDATE TeacherAttandance SET halfdays=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"1");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
            
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN present", JOptionPane.ERROR_MESSAGE);
        
          }
      }
  public void attendanceleave1(String id){
          try{
            String sql = "UPDATE TeacherAttandance SET leaves=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"1");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
            
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN present", JOptionPane.ERROR_MESSAGE);
        
          }
      }
  public void attendanceleave0(String id){
          try{
            String sql = "UPDATE TeacherAttandance SET leaves=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"0");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
            
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN present", JOptionPane.ERROR_MESSAGE);
        
          }
      }
public void attendancePresent0(String id){
          try{
            String sql = "UPDATE TeacherAttandance SET Present=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"0");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
            
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN present", JOptionPane.ERROR_MESSAGE);
        
          }
      }
      public void attendancehalf0(String id){
          try{
            String sql = "UPDATE TeacherAttandance SET halfdays=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"0");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
            
              
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN present", JOptionPane.ERROR_MESSAGE);
        
          }
      }
      public void attendanceLate0(String id){
          try{
              String sql = "UPDATE TeacherAttandance SET Late=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"0");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN late", JOptionPane.ERROR_MESSAGE);
        
          }
      }
      public void attendanceLate1(String id){
          try{
              String sql = "UPDATE TeacherAttandance SET Late=? WHERE ID = '"+id+"'"+"AND Day = '"+getDate()+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,"1");
            
//            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error","ERROR IN late", JOptionPane.ERROR_MESSAGE);
        
          }
      }
      public void staffToAbsentLate(){
          try {
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff ";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  int ID = rs.getInt("Sno");
                  String Name=rs.getString("Name");
                  
            String sql1 = "Insert into AbsentLate(ID,Name,Present,Late,halfsdays,leaves,Absent,increament,Month,Year) values (?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql1);
            pst.setInt(1,ID);
            pst.setString(2, Name);
            pst.setString(3, "0");
            pst.setString(4, "0");
            pst.setString(5, "0");
            pst.setString(6, "0");
            pst.setString(7, "0");
            pst.setString(8, "0");
            pst.setInt(9, getMonth());
            pst.setInt(10, getYear());
            
            pst.execute();
            
                   
              }}
          catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
      }
      public void StaffIdGeneraterForPLAupdate(){
          try{int id=0;
              Statement st = con.createStatement();
              String sql2 = "SELECT * FROM AbsentLate ";   
            rs = st.executeQuery(sql2);
             
            while(rs.next()){
               
                  id = rs.getInt("ID");
                  updateAbsentLate(id);
                  
            }
//             System.out.println(id);
          }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error","id", JOptionPane.ERROR_MESSAGE); 
          }
      }
      public void updateAbsentLate(int id){
          try{
              Statement st = con.createStatement(); 
                int p=0,l=0,a=0,h=0,le=0;    
                  String sql = "SELECT * FROM TeacherAttandance WHERE ID = '"+id+"'"+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
                  ra = st.executeQuery(sql);
              while(ra.next()){
                  int present = ra.getInt("Present");  
                  if(present==1)
                  {
                      p++;
                  }
                  else
                  {a++;}
                  int Late=ra.getInt("Late");
                  if (Late==1) {
                      {l++;}
                      int half=ra.getInt("halfdays");
                  if (half==1) {
                      {h++;}
                      int leaves=ra.getInt("leaves");
                  if (leaves==1) {
                      le++;}
              }
                  }
//                  System.out.println("-------------");
//                  System.out.println(h);
//                  System.out.println(l);
//                  System.out.println(a);
                  String sql1 = "UPDATE  AbsentLate SET Present=?,Late=?,Absent=?,halfsdays=?,leaves=? WHERE ID = '"+id+"'"+"AND Month = '"+getMonth()+"'"+"AND Year = '"+getYear()+"'";
            pst = con.prepareStatement(sql1);
            pst.setString(1,String.valueOf(p));
            pst.setString(2,String.valueOf(l));
            pst.setString(3,String.valueOf(a) );
            pst.setString(4,String.valueOf(h) );
             pst.setString(5,String.valueOf(le) );
             pst.execute();
              }
          }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error","uuuuuuuuuuuuuuuppppppppp", JOptionPane.ERROR_MESSAGE); 
          }
      }
      
      public void a(int a){
//          System.out.println(a);
      }
      
      public void staffReport(JTable tab){
        try{
            String sql="select ID as [ID],Name as [Employee Name],Present as [PRESENT],Absent as [ABSENT],halfsdays as [HALF DAY],Late as [LATE],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE Month = '"+getMonth()+"'"+"AND Year = '"+getYear()+"'";
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
      
      public boolean searchAbsentLate(String Id,String name,String month,String year){
        boolean found =false;          
        try {
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+Id+"'"+"OR Name = '"+name+"'"+"OR Month = '"+month+"'"+"OR Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){String id12=rs.getString("ID");
                String name12=rs.getString("Name");
                String present=rs.getString("Present");
                String late=rs.getString("Late");
                String Absent=rs.getString("Absent");
                String month12=rs.getString("Month");
                String year12=rs.getString("Year");
                   if(Id.equals(id12)||name12.equals(name)||month12.equals(month)||year.equals(12) ){
                     {
                      found = true;
                      break;
                      }
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
//                      System.out.println("Found");
                  }
                  else {
//                      System.out.println("Not Found");
                   }}
        catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
     public int getMonthInt(int monthint,String month){
//         String month =(String)this.jComboBox1.getSelectedItem();
//          int monthint=0;
        switch (month) {
         case "JANUARY":  monthint = 1;
                     break;
            case "FEBUARY":   monthint = 2;
                     break;
            case "MARCH": monthint = 3;
                     break;
            case "APRIL":   monthint = 4;
                     break;
            case "MAY":  monthint = 5;
                     break;
            case "JUNE":  monthint = 6;
                     break;
            case "JULY": monthint = 7;
                     break;
            case "AUGUST":  monthint = 8;
                     break;
            case "SEPTEMBER":  monthint = 9;
                     break;
            case "OCTOBER": monthint = 10;
                     break;
            case "NOVEMBER": monthint = 11;
                     break;
            case "DECEMBER": 
                monthint = 12;
                     break;
//                     default:  JOptionPane.showMessageDialog(null,"Error","INVALID INPUT", JOptionPane.ERROR_MESSAGE);
        
//                     break;
            }
        return monthint;
    }
      public void staffReportConditionAll(JTable table,String id,String name,String month,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
      public boolean searchStaffAll(String ID,String Name,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+ID+"'"+" AND Name = '"+Name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum)&&Name.equals(stdName)&&Month.equals(month)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
       public void staffReportConditionidNameMonth(JTable table,String id,String name,String month){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
        public boolean searchStafffidnamemonth(String ID,String Name,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+ID+"'"+" AND Name = '"+Name+"'"+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum)&&Name.equals(stdName)&&Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
        public void staffReportConditionidNameYear(JTable table,String id,String name,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" AND Name = '"+name+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
         public boolean searchStaffidnameyear(String ID,String Name,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+ID+"'"+" AND Name = '"+Name+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum)&&Name.equals(stdName)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
         public void staffReportConditionIdMonthYear(JTable table,String id,String month,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
          public boolean searchStaffidmonthyear(String ID,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+ID+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum)&&Month.equals(month)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
          public void staffReportConditionNameMonthYear(JTable table,String name,String month,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
           public boolean searchStaffnamemonthyear(String Name,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where Name = '"+Name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(Name.equals(stdName)&&Month.equals(month)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void staffReportConditionidName(JTable table,String id,String name){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" AND Name = '"+name+"'";//+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
     public boolean searchStaffidname(String ID,String Name){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+ID+"'"+" AND Name = '"+Name+"'";//+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum)&&Name.equals(stdName) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
     public void staffReportConditionidMonth(JTable table,String id,String month){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
      public boolean searchStaffidonth(String ID,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+ID+"'"+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum)&&Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
      public void staffReportConditionidYear(JTable table,String id,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public boolean searchStaffidyear(String ID,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+ID+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
       public void staffReportConditionNameMonth(JTable table,String name,String month){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE  Name = '"+name+"'"+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       
        public boolean searchStaffnamemonth(String Name,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where  Name = '"+Name+"'"+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Name.equals(stdName)&&Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
        public void staffReportConditionNameYear(JTable table,String name,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE  Name = '"+name+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
         public boolean searchStaffnameyear(String Name,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where  Name = '"+Name+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(Name.equals(stdName)&&year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
         public void staffReportConditionMonthYear(JTable table,String month,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
          public boolean searchStaffmonthyear(String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where  Month = '"+month+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(Month.equals(month) && Year.equals(year)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
          public void staffReportConditionid(JTable table,String id){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
           public boolean searchStaffid(String ID){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate WHERE ID ='"+ID+"'";//+" AND Name = '"+Name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(ID.equals(Idnum) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
           public void staffReportConditionname(JTable table,String name){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE Name = '"+name+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
            public boolean searchStaffname(String Name){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where  Name = '"+Name+"'";//+;//" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Name.equals(stdName) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
            public void staffReportConditionmonth(JTable table,String month){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE Month = '"+month+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
             public boolean searchStaffmonth(String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("Name");
                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Month.equals(month) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
             public void staffReportConditionyear(JTable table,String year){
          String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE Year = '"+year+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
              public boolean searchStaffyear(String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
                  String Year=rs.getString("Year");
                   if(year.equals(Year) ){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
//      public void staffReportCondition(JTable table,String id ,String name,String month,String year){
//        
// 
//          try{
//            
////             DefaultTableModel model = (DefaultTableModel) table.getModel();
//   
//            Statement st=con.createStatement();
//            String sql="select ID as [ID],Name as [EMPLOYEE NAME],Present as [PRESENT],Late as [LATE],Absent as [ABSENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"+" OR WHERE Name = '"+name+"'"+" OR WHERE Month = '"+month+"'"+" OR WHERE Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
//            
//         pst=con.prepareStatement(sql);
//          rs= pst.executeQuery();
//         table.setModel(DbUtils.resultSetToTableModel(rs));
////            ResultSet rs=st.executeQuery(sql);
////            while(rs.next()){  
////                int id12=rs.getInt("ID");
////                String name12=rs.getString("Name");
////                String present=rs.getString("Present");
////                String late=rs.getString("Late");
////                String Absent=rs.getString("Absent");
////                int month12=rs.getInt("Month");
////                String year12=rs.getString("Year");
////                Vector row = new Vector();
////                Fees fee=new Fees();
////               String mon= fee.getMonthString(month12);
//////               if (searchAbsentLate(id, name, month, year)){
////                   row.clear();
//////                   row.removeAllElements();
////                   model.addRow(row);
//////                   model.addRow(clear);
////                   row.add(id12);
////                row.add(name12);
////                row.add(present);
////                row.add(late);
////                row.add(Absent);
////                row.add(mon);
////                row.add(year12);
////                model.addRow(row);
////               
////               
//////                 table.setModel(DbUtils.resultSetToTableModel(rs));
//////                model.
//////                model.addRow(row);
////            }
//            
////                 table.setModel(DbUtils.resultSetToTableModel(rs));
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//      }
//      }
      public void ReportClickTable(JTable jTable1,JTextField id,JTextField name,JTextField present,JTextField absent ,JTextField late){
         try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql= "select * from AbsentLate where ID = '" + table_click + "'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
//                AdminStudent adminStudent=new AdminStudent();
String Id=rs.getString("ID");
id.setText(Id);
               String Name=rs.getString("Name");
               name.setText (Name);
            String Present=rs.getString("Present");
                present.setText(Present);
              
               String Absent=rs.getString("Absent");
                absent.setText(Absent);
              
               String Late=rs.getString("Late");
                late.setText(Late);
               
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
      }
      public void updateReport(String ID,String name,String present,String Absent,String Late){
          try {   
    String sql = "UPDATE AbsentLate SET Name=?,Present=?,Absent=?,Late=? WHERE ID = '"+ID+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,teacherId);
            pst.setString(1,name);
            pst.setString(2,present);
            pst.setString(3,Absent);
            pst.setString(4,Late);
            JOptionPane.showMessageDialog(null,"UPDATED","ATTENDANCES Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          } 
      
      
  }
       public void staffTostaffFinance(){
          try {
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff ";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  int ID = rs.getInt("Sno");
                  String Name=rs.getString("Name");
                  basicSalary=rs.getInt("BasicSalary");
                  String sql1 = "Insert into stafinance(ID,name,basicsalary,salary,dues,month,year) values (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql1);
            pst.setInt(1,ID);
            pst.setString(2, Name);
            pst.setInt(3, basicSalary);  
            double total=calculateabsentSalary(basicSalary, getAbsents(ID))+calculatelateSalary(basicSalary, getLates(ID));
            pst.setDouble(4, total);
            pst.setDouble(5, total);
            pst.setInt(6, getMonth());
            pst.setInt(7, getYear());
            pst.execute();      
              }}
          catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
      }
      public int getAbsents(int id){
        Statement st;
        int absent=0;
        int month=getMonth()-1;
          if (month==0) {
              month=12;
          }
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID='" +id+ "'AND Month='" +month+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                 absent=rs.getInt("Absent");
//                 System.out.println(absent);
            }          
        
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
      public double calculateabsentSalary(double sal,double abs){
          int month=getMonth()-1;
          int year=getYear();
          if (month==0) {
              month=12;
              year=year-1;
          }
          LocalDate date = LocalDate.of(year, month, 1);
          int days = date.lengthOfMonth();
//          System.out.println(days);
          double a=sal;
          a=a/days;
          sal=a*abs; 
          return sal;
      }
      public int calculatelateSalary(int sal,int late){
         int month=getMonth()-1;
          if (month==0) {
              month=12;
          }
          LocalDate date = LocalDate.of(getYear(), month, 1);
          int days = date.lengthOfMonth();
//          System.out.println(days);
          int a=sal;
          days=days/2;
          a=a/days;
          a=a*late;
          sal=sal-a;
          return sal;
      }
      public int getLates(int id){
        Statement st;
        int absent=0;
        int month=getMonth()-1;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID='" +id+ "'AND Month='" +month+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("Late");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
      public void updateSalaryDues(int ID){
          try {   
    String sql = "UPDATE satfinance SET dues=0 WHERE ID = '"+ID+"'";
            
            JOptionPane.showMessageDialog(null,"UPDATED","finance dues update",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          }   
  }
      public void STAFFincreamentrecord(JTable tab)
   {
       
       try{
           String sql ="select ID as [ID],Name as [NAME],increament as[INCREAMENT],Month as [MONTH],Year as [YEAR] from AbsentLate"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
       public void STAFFincentiverecord(JTable tab)
   {
       
       try{
           String sql ="select Sno as [ID],Name as [NAME],incentive as[INCREAMENT] from Staff"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
      
      public boolean staffsearchid(String id){
          boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID ='"+id+"'";//+"'AND StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
                   if(id.equals(Idnum)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
      }
      public void STAFFincreamentrecordSearch(JTable tab,String id)
   {
       
       try{
           String sql ="select ID as [ID],Name as [NAME],increament as[INCREAMENT],Month as [MONTH],Year as [YEAR] from AbsentLate WHERE ID = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
      public void clickStaffTableToText(JTable jTable1,JTextField TeacherID,JTextField name,JTextField incre){
          try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String table_click1= jTable1.getModel().getValueAt(row, 2).toString();
            String table_click2= jTable1.getModel().getValueAt(row, 3).toString();
            
            String sql= "select * from AbsentLate where ID = '" + table_click + "'"+"AND increament = '"+table_click1+"'"+"AND Month = '"+table_click2+"'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
//                AdminStudent adminStudent=new AdminStudent();
               String Name=rs.getString("Name");
               name.setText (Name);
           
               String  idnum=rs.getString("ID");
                TeacherID.setText(idnum);
               String  inc=rs.getString("increament");
                incre.setText(inc);
               
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
      }
     
      public void updateincreament(String num,String id){
          try {
    String sql = "UPDATE AbsentLate SET increament='" +num+ "' where ID='" +id+ "' AND Month='" +getMonth()+ "' AND Year='" +getYear()+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"ERROR IN UPDATE increament","Record", JOptionPane.ERROR_MESSAGE);
          }      
        }
      public void updateadvance(String num,String id){
          try {
    String sql = "UPDATE Staff SET advance='" +num+ "' where Sno='" +id+ "'";//AND Month='" +getMonth()+ "' AND Year='" +getYear()+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"ERROR IN UPDATE increament","Record", JOptionPane.ERROR_MESSAGE);
          }      
        }
      public void updateincentive(String num,String id){
          try {
    String sql = "UPDATE Staff SET incentive='" +num+ "' where Sno='" +id+ "'";//AND Month='" +getMonth()+ "' AND Year='" +getYear()+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"ERROR IN UPDATE increament","Record", JOptionPane.ERROR_MESSAGE);
          }      
        }
public void STAFFADVANCErecord(JTable tab)
   {
       
       try{
           String sql ="select Sno as [ID],Name as [NAME],advance as[ADVANCE] from Staff"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }

public void STAFFADVANCErecordSearch(JTable tab,String id )
   {
       
       try{
           String sql ="select Sno as [ID],Name as [NAME],advance as[ADVANCE] from Staff WHERE Sno = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }public void updateretension(String num,String id){
          try {
    String sql = "UPDATE Staff SET retentiondeduction='" +num+ "' where Sno='" +id+ "'";//AND Month='" +getMonth()+ "' AND Year='" +getYear()+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"ERROR IN UPDATE increament","Record", JOptionPane.ERROR_MESSAGE);
          }      
        }
public void STAFFretensionrecord(JTable tab)
   {
       
       try{
           String sql ="select Sno as [ID],Name as [NAME],retentiondeduction as[RETENSION DEDUCTED] from Staff"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }

public void STAFFRetensionrecordSearch(JTable tab,String id )
   {
       
       try{
           String sql ="select Sno as [ID],Name as [NAME],retentiondeduction as[RETENSION DEDUCTED] from Staff WHERE Sno = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
public void STAFFINCENTIVErecord(JTable tab)
   {
       
       try{
           String sql ="select Sno as [ID],Name as [NAME],incentive as[INCENTIVES] from Staff"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public void STAFFINCENTIVErecordSEARCH(JTable tab,String id)
   {
       
       try{
           String sql ="select Sno as [ID],Name as [NAME],incentive as[INCENTIVES] from Staff WHERE Sno = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   
 public void clickAdvanceTableToText(JTable jTable1,JTextField TeacherID,JTextField name,JTextField advance){
          try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String table_click1= jTable1.getModel().getValueAt(row, 2).toString();
//            String table_click2= jTable1.getModel().getValueAt(row, 3).toString();
            
            String sql= "select * from Staff where Sno = '" + table_click + "'";//+"AND advance = '"+table_click1+"'";//+"AND Month = '"+table_click2+"'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
//                AdminStudent adminStudent=new AdminStudent();
               String Name=rs.getString("Name");
               name.setText (Name);
           
               String  Sn=rs.getString("Sno");
                TeacherID.setText(Sn);
               String  inc=rs.getString("advance");
                advance.setText(inc);
               
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
 }
 public void clickincentiveTableToText(JTable jTable1,JTextField TeacherID,JTextField name,JTextField incentive){
          try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String namet= jTable1.getModel().getValueAt(row, 1).toString();
            String amt= jTable1.getModel().getValueAt(row, 2).toString();
//            String table_click2= jTable1.getModel().getValueAt(row, 3).toString();
            
            
               name.setText (namet);
           
               
                TeacherID.setText(table_click);
              
                incentive.setText(amt);
               
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
 }
 public void clickretensionTableToText(JTable jTable1,JTextField TeacherID,JTextField name,JTextField retension){
          try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String namet= jTable1.getModel().getValueAt(row, 1).toString();
            String amt= jTable1.getModel().getValueAt(row, 2).toString();
//            String table_click2= jTable1.getModel().getValueAt(row, 3).toString();
            
            
//                AdminStudent adminStudent=new AdminStudent();
             
               name.setText (namet);
           
              
                TeacherID.setText(table_click);
               
                retension.setText(amt);
               
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
 }
 public int getLASTmontINCREAMENT(int id){
        Statement st;
        int absent=0;
        int month=getMonth()-1;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID='" +id+ "'AND Month='" +month+ "'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent=ra.getInt("increament");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public void staffTosalary(){
          try {
              int year=getYear();
              int month=getMonth()-1;
          if (month==0) {
              month=12;
              year=getYear()-1;
          }
//            link.searchTeacherLink()
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff ";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  int ID = rs.getInt("Sno");
                  String Name=rs.getString("Name");    
            String sql1 = "Insert into TeacherSalary(ID,Name,increament,Salary,SalaryAfterIncreament,Attendence,GrossSalary,AdvanceSalary,RetensionDeducted,incentives,NetSalary,dues,TotalRetension,month,year) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql1);
            pst.setInt(1,ID);
            pst.setString(2, Name);
            pst.setString(3, String.valueOf(getLASTmontINCREAMENT(ID)));
            pst.setString(4, String.valueOf(getBasicsalary(ID)));
            double gross=getBasicsalary(ID)+getLASTmontINCREAMENT(ID);
            pst.setString(5, String.valueOf(gross));
            pst.setString(6, String.valueOf(getpresents(ID)));
            pst.setString(7, String.valueOf(calculateabsentSalary(gross,getpresents(ID))));
            pst.setString(8, String.valueOf(getadvancesalary(ID)));
            pst.setString(9,String.valueOf(getretentiondeduction(ID)));
            pst.setString(10,String.valueOf(getincentive(ID)));
            double netSalary=(calculateabsentSalary(gross,getpresents(ID))+getincentive(ID))-(getadvancesalary(ID)+getretentiondeduction(ID));
            pst.setDouble(11, netSalary);
            pst.setDouble(12, netSalary);
            pst.setInt(13, getTotalRetention(ID));
            pst.setInt(14, month);
            pst.setInt(15, year);           
            pst.execute();   
              }}
          catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
      }
  public void updatesalary(){
          try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Staff ";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  int ID = rs.getInt("Sno");
                   updatebasicsalary(String.valueOf(ID),String.valueOf( getBasicsalaryLatest(String.valueOf(ID))));
                     
              
              }}
          catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
      }
  public int getBasicsalary(int id){
        Statement st;
         int absent=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM Staff where Sno='" +id+"'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent=ra.getInt("BasicSalary");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public int checkdata(){
        Statement st;
         int absent=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary ";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent++;
                 if (absent>0) {
                    break;
                }
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public int getBasicsalaryLatest(String id){
        Statement st;
         int absent=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where ID='" +id+"'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent=ra.getInt("SalaryAfterIncreament");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public int getpresents(int id){
        Statement st;
        int absent=0;
        int month=getMonth()-1;
        int year=getYear();
          if (month==0) {
              month=12;
              year=getYear()-1;
          }
          LocalDate date = LocalDate.of(getYear(), month, 1);
          int days = date.lengthOfMonth();
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID='" +id+ "'AND Month='" +month+ "' AND Year='" +year+ "'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                
                 absent=ra.getInt("Absent");
              //   System.out.println(absent);
            }          
           
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return days-absent;
    }
  public int getadvancesalary(int id){
        Statement st;
         int absent=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM Staff where Sno='" +id+"'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent=ra.getInt("advance");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public int getincentive(int id){
        Statement st;
         int absent=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM Staff where Sno='" +id+"'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent=ra.getInt("incentive");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public int getretentiondeduction(int id){
        Statement st;
         int absent=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM Staff where Sno='" +id+"'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent=ra.getInt("retentiondeduction");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public int getTotalRetention(int id){
        Statement st;
         int absent=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where ID='" +id+"'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 absent=ra.getInt("TotalRetension");
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent+getretentiondeduction(id);
    }
  public int getbasictotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("Salary");
            } 
            txt.setText(String.valueOf(absent));
//            System.out.println(absent);
//            JOptionPane.showMessageDialog(null,"  update","Record", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
           return absent;
    }
  public void getincreamenttotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("increament");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
  public void getincreamentedSalarytotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("SalaryAfterIncreament");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
  public void getGrossSalarytotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("GrossSalary");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
  public void getAdvanceSalarytotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("AdvanceSalary");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
  public void getRetensionDeductedtotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("RetensionDeducted");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
  public void getincentivestotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("incentives");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
  public void getNetSalarytotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("NetSalary");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
  public void getTotalRetensiontotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("TotalRetension");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
   public void salaryPay(JTable tab){
    Statement st;
    int absent=0;
     int row= tab.getSelectedRow();
    String id_click= tab.getModel().getValueAt(row, 0).toString();
            String month_click= tab.getModel().getValueAt(row, 6).toString();
            String year_click= tab.getModel().getValueAt(row, 7).toString();
            String in_click= tab.getModel().getValueAt(row, 5).toString();
    try {
        st = con.createStatement();
            
            String sql= "SELECT * FROM TeacherSalary where ID='" +id_click+ "'AND month='" +month_click+ "' AND year='" +year_click+ "'";
            ResultSet r = st.executeQuery(sql);
           while(r.next()){
                 absent=r.getInt("dues");
                 System.out.println(absent);
            }          
            
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e,"staff", JOptionPane.ERROR_MESSAGE);
      }
    if (absent!=0) {
//                JOptionPane.showMessageDialog(null, "eeeee");
              finance.updateExpenditureFinance(absent);
           // updateSalaryDues(id_click,month_click,year_click);
              
          }else
       JOptionPane.showMessageDialog(null,"salary already paid","Record", JOptionPane.ERROR_MESSAGE);
       
    
  }
   public void updatebasicsalary(String ID ,String dues){
          try {   
    String sql = "UPDATE Staff SET BasicSalary='"+dues+"' WHERE Sno ='"+ID+"'";
           pst = con.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
             
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          }   
  }
   public void advanceto0(){
          try {   
    String sql = "UPDATE Staff SET advance='"+0+"'";
           pst = con.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
             
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          }   
   }
          public void retentiondeductionto0(){
          try {   
    String sql = "UPDATE Staff SET retentiondeduction='"+0+"'";
           pst = con.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
             
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          }   }
          public void incentiveto0(){
          try {   
    String sql = "UPDATE Staff SET incentive='"+0+"'";
           pst = con.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
             
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          }   
  }
   public void updateSalaryDues(String ID ,String month,String year){
          try {   
              System.out.println(ID);
              System.out.println(month);
              System.out.println(year);
              PreparedStatement ps=null;
              Connection conn=connection.setConnection();
    String sql = "UPDATE TeacherSalary SET dues =? WHERE ID ='"+ID+"' AND month = '" +month+ "' AND year = '" +year+ "'";
            ps= conn.prepareStatement(sql);
            ps.setString(1, "0");
            ps.executeUpdate();
              
            ps.close();
             JOptionPane.showMessageDialog(null,"UPDATED","finance dues update",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          }   
  }
  public int getTotalDUES(int ID){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where ID='" +ID+ "' ";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("dues");
            } 
           
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return absent;
    }
  public void setadvanceTo0(){
     
    try {   
    String sql = "UPDATE Staff SET advance=0,incentive=0,retentiondeduction=0";
            pst = con.prepareStatement(sql);
//          pst.setInt(1,teacherId);
           
            JOptionPane.showMessageDialog(null,"UPDATED","Staff Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          } 
  }
   public void totalamount(int month,int year,JLabel basic,JLabel IN,JLabel INted,JLabel gross,JLabel adv,JLabel rd,JLabel inc,JLabel nt,JLabel rt){
       try {
          ;
//       System.out.println(month);
//           System.out.println(year);
       getbasictotal(month, year, basic);
           getincreamenttotal(month, year, IN);
           getincreamentedSalarytotal(month, year, INted);
           getGrossSalarytotal(month, year, gross);
           getAdvanceSalarytotal(month, year, adv);
           getRetensionDeductedtotal(month, year, rd);
           getincentivestotal(month, year, inc);
           getNetSalarytotal(month, year, nt);
           getTotalRetensiontotal(month, year, rt);
//        JOptionPane.showMessageDialog(null,"challing","Record", JOptionPane.ERROR_MESSAGE);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
       }
      
  }
   public int previousMonth(){
        int month=getMonth()-1;
          if (month==0) {
              month=12;
              
          }
          return month;
   }
   public int previousyear(){
        int month=getMonth()-1;
        int year=getYear();
          if (month==0) {
              year=getYear()-1;
          }
          return year;
   }
   public void Feed(){
        Calendar cal = Calendar.getInstance();
        int month = 0;
        int counter=0;
        try{
            Statement st=con.createStatement();
            String sql="Select * FROM Counter ";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                counter=rs.getInt("monthCounter");
                 month=rs.getInt("month");
            }
//            System.out.println(counter);
        if(month!=getMonth() && counter==0){
            if (checkdata()!=0) {
                 updatesalary();
            }
           staffTosalary();
           staffToAbsentLate();
           finance.addFinance();
           advanceto0();
           incentiveto0();
           retentiondeductionto0();
           try {   
    String sql1 = "UPDATE Counter SET month=?";
            pst = con.prepareStatement(sql1);
           pst.setInt(1,getMonth());
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }      
    }
           
        if(month==getMonth()){
            
             try {   
    String sql1 = "UPDATE Counter SET monthCounter=0";
            pst = con.prepareStatement(sql1);
         //  pst.setInt(1,0);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         } 
       }
        }
    catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error","Connection Error", JOptionPane.ERROR_MESSAGE);
           }}

    
    public void Recordst(JTable tab)
   {
         try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary as[NetSalary],month as [MONTH],year as [YEAR]  from TeacherSalary"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }public void Recordstsearch(JTable tab,String ID)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean searchRECORD(String id){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'";//+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
   public void Recordstmonth(JTable tab,String ID)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE month = '"+ID+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean monthRECORD(String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  month = '"+month+"'";//+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String mo = rs.getString("month");
//                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(mo.equals(month)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
   public void Recordstyear(JTable tab,String ID)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE year = '"+ID+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean yearRECORD(String id){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  year = '"+id+"'";//+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("year");
//                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
   public void Recordstpay(JTable tab,String ID)
   {
       
       
       try{
           String sql="";
           if (ID!="0.0"){
               ID="1";
                sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE dues >= '"+ID+"'"; 
           
           }
           else {
               ID="0.0";
                sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE dues = '"+ID+"'"; 
           
           }
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean payRECORD(String id){
        boolean found =false;          
        try {
            String sql="";
           if (id!="0.0"){
               id="1";
                sql = "SELECT * FROM TeacherSalary where  dues = '"+id+"'";//+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            
           }
           else {
               id="0.0";
                sql = "SELECT * FROM TeacherSalary where  dues = '"+id+"'";//+" AND  Month = '"+month+"'";//+" AND  Year = '"+year+"'";   
              
           }
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("dues");
//                  String stdName=rs.getString("Name");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
   public void Recordstidpay(JTable tab,String ID,String pay)
   {
       
       
       try{
           String sql="";
           if (pay!="0.0"){
               pay="1";
            sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND dues >= '"+pay+"'"; 
           
           }
           else {
               pay="0.0";
            sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND dues = '"+pay+"'"; 
           
           }
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDidpay(String id,String pay){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'"+" AND  dues = '"+pay+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("dues");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)&& stdName.equals(pay)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstidmonth(JTable tab,String ID,String month)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND month = '"+month+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDidmonth(String id,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'"+" AND  month = '"+month+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("month");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)&& stdName.equals(month)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstidyear(JTable tab,String ID,String year)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND year = '"+year+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDidyear(String id,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'"+" AND  year = '"+year+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("year");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)&& stdName.equals(year)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstpayyear(JTable tab,String pay,String year)
   {
       
       
       try{String sql="";
           if (pay!="0.0"){
               pay="1";
            sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE dues >= '"+pay+"'"+"AND year = '"+year+"'"; 
           
           }
           else {
               pay="0.0";
            sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE dues = '"+pay+"'"+"AND year = '"+year+"'"; 
           
           }
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDpayyear(String pay,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  dues = '"+pay+"'"+" AND  year = '"+year+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("dues");
                  String stdName=rs.getString("year");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(pay)&& stdName.equals(year)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstpaymonth(JTable tab,String pay,String month)
   {
       
       
       try{
           String sql="";
           if (pay!="0.0"){
               pay="1";
           sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE month = '"+month+"'"+"AND dues >= '"+pay+"'"; 
           
           }
           else {
               pay="0.0";
           sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE month = '"+month+"'"+"AND dues = '"+pay+"'"; 
           
           }

//           sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE month = '"+month+"'"+"AND dues = '"+pay+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDpaymonth(String pay,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  month = '"+month+"'"+" AND  dues = '"+pay+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("dues");
                  String stdName=rs.getString("month");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(pay)&& stdName.equals(month)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstmonthyear(JTable tab,String month,String year)
   {
       
       
       try{
           
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE month = '"+month+"'"+"AND year = '"+year+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDmonthyear(String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  month = '"+month+"'"+" AND  year = '"+year+"'";//+" AND  Year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("month");
                  String stdName=rs.getString("year");
//                  String Month=rs.getString("Month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(month)&& stdName.equals(year)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstidpaymonth(JTable tab,String ID,String pay,String month)
   {
       
       
       try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
           sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND dues >= '"+pay+"'"+"AND month = '"+month+"'"; 
           
           }
           else {
               pay="0.0";
           sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND dues = '"+pay+"'"+"AND month = '"+month+"'"; 
                      
           }

           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDidpaymonth(String id,String pay,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'"+" AND  dues = '"+pay+"'"+" AND  month = '"+month+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("dues");
                  String Month=rs.getString("month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)&& stdName.equals(pay)&&Month.equals(month)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstidpayyear(JTable tab,String ID,String pay,String year)
   {
       
       
       try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
            sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND dues >= '"+pay+"'"+"AND year = '"+year+"'"; 
           
           }
           else {
               pay="0.0";
            sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND dues = '"+pay+"'"+"AND year = '"+year+"'"; 
                      
           }
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDidpayyear(String id,String pay,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'"+" AND  dues = '"+pay+"'"+" AND  year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("dues");
                  String Month=rs.getString("year");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)&& stdName.equals(pay)&&Month.equals(year)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstidmonthyear(JTable tab,String ID,String month,String year)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND year = '"+year+"'"+"AND month = '"+month+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDidmonthyear(String id,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'"+" AND  year = '"+year+"'"+" AND  month = '"+month+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("year");
                  String Month=rs.getString("month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(id)&& stdName.equals(year)&&Month.equals(month)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
    public void Recordstpaymonthyear(JTable tab,String pay,String month,String year)
   {
       
       
       try{
           String sql="";
           if (pay!="0.0"){
               pay="1";
           sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE year = '"+year+"'"+"AND dues >= '"+pay+"'"+"AND month = '"+month+"'"; 
           
           }
           else {
               pay="0.0";
           sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE year = '"+year+"'"+"AND dues = '"+pay+"'"+"AND month = '"+month+"'"; 
                      
           }
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDpaymonthyear(String pay,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  year = '"+year+"'"+" AND  dues = '"+pay+"'"+" AND  month = '"+month+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("year");
                  String stdName=rs.getString("dues");
                  String Month=rs.getString("month");
//                  String Year=rs.getString("Year");
                   if(Idnum.equals(year)&& stdName.equals(pay)&&Month.equals(month)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    } public void Recordstidpaymonthyear(JTable tab,String ID,String pay,String month,String year)
   {
       
       
       try{
           String sql ="select ID as [ID],Name as [NAME],Salary as[BASIC SALARY], SalaryAfterIncreament as [INCREAMENTED SALARY],GrossSalary as[GROSS SALARY],NetSalary,month as [MONTH],year as [YEAR]  from TeacherSalary WHERE ID = '"+ID+"'"+"AND dues = '"+pay+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));    
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","STAFF Record", JOptionPane.ERROR_MESSAGE);
           }
   }
   public boolean RECORDidpaymonthyear(String id,String pay,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TeacherSalary where  ID = '"+id+"'"+" AND  dues = '"+pay+"'"+" AND  month = '"+month+"'"+"AND year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("dues");
                  String Month=rs.getString("month");
                  String Year=rs.getString("year");
                   if(Idnum.equals(id)&& stdName.equals(pay)&&Month.equals(month)&&Year.equals(year)){
                     
                      found = true;
                      
                    }
                  else
                   {
                       found = false;
                   }
              }
               if (found==true)
                  {
                      }
                  else {
                   
               }
                       }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
   public void updatenetsalary(String ID ,String month,String year,String dues){
          try {   
    String sql = "UPDATE TeacherSalary SET NetSalary='"+dues+"' WHERE ID ='"+ID+"'AND Month='" +month+ "' AND year='" +year+ "'";
           pst = con.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
             
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
          }   
  }
}


