 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import com.jgoodies.common.base.Strings;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mithrandir
 */
public class Finance {
    private int income;
    private int expenditure;
    private int monthint;
    private String monthString;
    private int year;
    private int totalIncome;
    private double dues=0;
     String Stdname;
     int idnum;
     int fees;  
    
//    private String studentName;
//    private int fees;
    public Finance() {
    }
    
public Finance(String stdName,int dues,int idnum,int fees){
    this.Stdname=stdName;
    this.dues=dues;
    this.fees=fees;
    this.idnum=idnum;
}
    public Finance(int income, int expenditure, int month, String monthString, int year) {
        this.income = income;
        this.expenditure = expenditure;
        this.monthint = month;
        this.monthString = monthString;
        this.year = year;
       
    }
public String getMonthStr(int mo) {
        
        switch (mo) {
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
    public String getMonthString(int mo) {
        Calendar cal = Calendar.getInstance();
        mo = cal.get(Calendar.MONTH)+1;
        switch (mo) {
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

    public int getMonthint(int monthint,String month) {
        switch (month) {
            case "January":  monthint = 1;
                     break;
            case "February":   monthint = 2;
                     break;
            case "March": monthint = 3;
                     break;
            case "April":   monthint = 4;
                     break;
            case "May":  monthint = 5;
                     break;
            case "June":  monthint = 6;
                     break;
            case "July": monthint = 7;
                     break;
            case "August":  monthint = 8;
                     break;
            case "September":  monthint = 9;
                     break;
            case "October": monthint = 10;
                     break;
            case "November": monthint = 11;
                     break;
            case "December": monthint = 12;
                     break;
            default:
//                monthString = "Invalid month";
//                     break;
        }
        return monthint;
    }
 public int getYear() {
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
//        System.out.println(year);
        return year;
    }
     public int getday() {
       Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println(year);
        return year;
    }

    public int getMonth() {
        Calendar cal = Calendar.getInstance();
        monthint = cal.get(Calendar.MONTH)+1;
      //  System.out.println(monthint);
        return monthint;
    }
    Connection2DB connection=new Connection2DB();
        Connection con = connection.setConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;
        public void changeduedate(String day){
            try{
                String sql1 = "UPDATE DueDate SET day = ? where id= '1' ";
            pst = con.prepareStatement(sql1);
          pst.setString(1,day);
            pst.executeUpdate();
            pst.close();
             JOptionPane.showMessageDialog(null,"SUCCESSFULLY UPDATE","DUE DATE", JOptionPane.INFORMATION_MESSAGE);
        
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
        
            }
        }
    public void FeedFees(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int counter=0;
        try{
            Statement st=con.createStatement();
            String sql="Select * FROM Counter ";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                counter=rs.getInt("monthCounter");
            }
//            System.out.println(counter);
        if(predatefees() && counter==0){          
           dataToStudentFinaceAdd();
           adddueDate();
           updatefeesdate();
           try {   
    String sql1 = "UPDATE Counter SET monthCounter=1";
            pst = con.prepareStatement(sql1);
         // pst.setInt(1,0);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }      
    }
        if(predatefees()==false){
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
     
    public void dataToStudentFinaceAdd(){
        try{
            Statement st=con.createStatement();
            String sql="Select * FROM Student ";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                  Stdname=rs.getString("StudentName");
                  idnum=rs.getInt("IDnum");
                  fees=rs.getInt("fees");
                  dues=rs.getInt("Dues");
 addStudentFinance(Stdname, idnum, fees);
                setRegistrationtofee(idnum);
                setstationarytofee(idnum);                
            }
            JOptionPane.showMessageDialog(null,"Next month fees added ","Student Record",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"DATA TO STUDENT","ERROR", JOptionPane.ERROR_MESSAGE);
           }
    }
    public void addStudentFinance(String stdName,int idnum,int fees) {
        int month=0;
        int year=0;
          if (getday()>=25) {
         month=getMonth()+1;
         year=getYear();
        if (month==13) {
            month=1;
            year=year+1;
        }      
          }else{
         month=getMonth();
         year=getYear();
        
        }
        try{
   String sql1 = "Insert into studentFinance(StudentName,ID,fees,registrationfee,stationaryfee,discount,dues,month,year) values (?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql1);   
            pst.setString(1,stdName);
            pst.setInt(2, idnum);
            pst.setInt(3, fees);
            pst.setInt(4, 0);
            pst.setInt(5, 0);
            pst.setInt(6, 0);
            pst.setString(7, String.valueOf(generateDues(String.valueOf(idnum))));
            pst.setInt(8, month);
            pst.setInt(9, year);
         //   updateDuesStudent(String.valueOf(idnum),generateDues(String.valueOf(idnum)));
            pst.execute();
            updateDuesStudent(String.valueOf(idnum), (int) generateDues(String.valueOf(idnum)));
                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"addStudenttofinance","Connection Error", JOptionPane.ERROR_MESSAGE);
          
        } 
        
    }
    public double getDues(int ID){
         try{
           
            Statement st=con.createStatement();
            String sql="Select * FROM Student where IDnum= '"+ID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                
                 dues=rs.getInt("Dues");
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"getDues","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
       return dues;
    }
    

    public int getFees(String ID) {
      int feesfromStud=0;
        try{
           
            Statement st=con.createStatement();
            String sql="Select * FROM Student where IDnum= '"+ID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                 feesfromStud=rs.getInt("fees");
                 
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Getfees","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
       return feesfromStud;
    }
    public double generateDues(String ID){
                 double inst1=getextra01(Integer.parseInt(ID));
                 double inst2=getextra02(Integer.parseInt(ID));
                 double inst3=getextra03(Integer.parseInt(ID));
                 dues=getFees(ID)+inst1+inst2+inst3+getstationaryfee(Integer.parseInt(ID))+getregfee(Integer.parseInt(ID));
        return dues;
    }
      public void updateDuesStudent(String id,int d){    
          try{
        Statement st=con.createStatement();
      //      String sql="Select * FROM studentFinance where ID = '"+id+"'";
        //    ResultSet rs=st.executeQuery(sql);
          ///  while(rs.next()){
          //      dues=rs.getInt("dues");
                 String sql1 = "UPDATE Student SET Dues='"+d+"' WHERE IDnum = '"+id+"'";
            pst = con.prepareStatement(sql1);
         //   pst.setInt(1,dues);
             pst.executeUpdate();
            pst.close();
            
        //    }
         //  dues=dues+getFees(ID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void updateDuesStudentFinance(String id,double d){    
          try{
        Statement st=con.createStatement();
      //      String sql="Select * FROM studentFinance where ID = '"+id+"'";
        //    ResultSet rs=st.executeQuery(sql);
          ///  while(rs.next()){
          //      dues=rs.getInt("dues");
                 String sql1 = "UPDATE studentFinance SET dues='"+d+"' WHERE ID = '"+id+"'";
            pst = con.prepareStatement(sql1);
         //   pst.setInt(1,dues);
             pst.executeUpdate();
            pst.close();
            
        //    }
         //  dues=dues+getFees(ID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
       public void updateDuesStudentFinancefees(String id,double d,String month,String year){    
          try{
        Statement st=con.createStatement();
      //      String sql="Select * FROM studentFinance where ID = '"+id+"'";
        //    ResultSet rs=st.executeQuery(sql);
          ///  while(rs.next()){
          //      dues=rs.getInt("dues");
                 String sql1 = "UPDATE studentFinance SET dues='"+d+"' WHERE ID = '"+id+"' AND month= '"+month+"' AND year= '"+year+"'";
            pst = con.prepareStatement(sql1);
         //   pst.setInt(1,dues);
             pst.executeUpdate();
            pst.close();
              System.out.println("done");
        //    }
         //  dues=dues+getFees(ID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void payFees(int ID,JRadioButton paid,JRadioButton unpaid,JTable table){
          try {
           int row= table.getSelectedRow();
            String dues= table.getModel().getValueAt(row, 3).toString();
            String id= table.getModel().getValueAt(row, 0).toString();
            String month= table.getModel().getValueAt(row, 4).toString();
            String year= table.getModel().getValueAt(row, 5).toString();
               if (unpaid.isSelected() && duesUthao(table)==true ) {
              updateincomeFinance(300.0);
              }
              updateincomeFinance(Double.parseDouble(dues));
              updateDuesStudent(String.valueOf(ID), 0);
              updateDuesStudentFinancefees(id,0,month,year);
              extrapay01(ID);
              extrapay02(ID);
              extrapay03(ID);    
      }
           catch (Exception e) {
               JOptionPane.showMessageDialog(null,"select some value","overpay", JOptionPane.ERROR_MESSAGE);
          }
      }
      public void updateincomeFinance(double num){   
          double in=0.0;
          try{
        Statement st=con.createStatement();
            String sql="Select * FROM Finance where month = '"+getMonth()+"' AND Year='"+getYear()+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                in=rs.getDouble("income");
                in=num+in;
            }     String sql1 = "UPDATE Finance SET income='"+in+"' where month = '"+getMonth()+"' AND year='"+getYear()+"'";
            pst = con.prepareStatement(sql1);
         //   pst.setInt(1,dues);
             pst.executeUpdate();
            pst.close();
            
            
         //  dues=dues+getFees(ID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void addFinance() {
        try{
   String sql1 = "Insert into Finance(income,expenditure,dueday,fees,feesdues,salary,salarydues,month,year) values (?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql1);   
            pst.setInt(1, 0);
            pst.setInt(2, 0);
            pst.setInt(3, 10);
            pst.setInt(4, getfeestotal());
            pst.setString(5, String.valueOf(getduestotal()));
            pst.setInt(6, getsalarytotal());
            pst.setInt(7,getsalaryDuestotal());
            pst.setInt(8, getMonth());
            pst.setInt(9, getYear());
            pst.execute();  
            JOptionPane.showMessageDialog(null,"Successfully Saved ","Student Record",JOptionPane.INFORMATION_MESSAGE);       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"finance","Connection Error", JOptionPane.ERROR_MESSAGE);    
        } 
    }
      public void updateExpenditureFinance(int num){   
          int in=0;
          try{
        Statement st=con.createStatement();
            String sql="Select * FROM Finance where month = '"+getMonth()+"' AND Year='"+getYear()+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                in=rs.getInt("expenditure");
                num=num+in;
                 String sql1 = "UPDATE Finance SET expenditure='"+num+"' where month = '"+getMonth()+"' AND year='"+getYear()+"'";
   pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();        
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void setStationaryFee(int a){    
          try{
                 String sql1 = "UPDATE Student SET stationaryFee='"+a+"'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
           JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE); 
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
         public void setregistrationFee(int id,int a){    
          try{
                 String sql1 = "UPDATE Student SET RegistrationFee='"+a+"' WHERE IDnum = '"+id+"'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void updateRegistrationfee(int id){    
          try{
                 String sql1 = "UPDATE Student SET RegistrationFee=0 WHERE IDnum = '"+id+"'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"updateRegistrationfee","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
    public void updatestationaryfee(int id){    
          try{
                 String sql1 = "UPDATE Student SET stationaryFee=0 WHERE IDnum = '"+id+"'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void updateRegistrationfeeInfinace(int id,int a){    
          try{
                 String sql1 = "UPDATE studentFinance SET RegistrationFee='"+a+"' WHERE ID = '"+id+"' AND month = '"+getMonth()+"' AND year='"+getYear()+"'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"updateRegistrationfeeInfinace","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void setRegistrationtofee(int ID){
         try{
           
            Statement st=con.createStatement();
            String sql="Select * FROM Student where IDnum= '"+ID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                int regfee=rs.getInt("RegistrationFee");
                updateRegistrationfeeInfinace(ID,regfee);
                updateRegistrationfee(ID);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"setRegistrationtofee","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
    }
      public void updatestationaryfeeInfinace(int id,int a){    
          try{
            String sql1 = "UPDATE studentFinance SET stationaryFee='"+a+"' WHERE ID = '"+id+"' AND month = '"+getMonth()+"' AND year='"+getYear()+"'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"updatestationaryfeeInfinace","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void setstationarytofee(int ID){
         try{
           
            Statement st=con.createStatement();
            String sql="Select * FROM Student where IDnum= '"+ID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                int stationary=rs.getInt("stationaryFee");
                updatestationaryfeeInfinace(ID,stationary);
                updatestationaryfee(ID);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"setstationarytofee","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
    }
      public double getextra01(int id){
        Statement st;
        double installment=0;
        double num=0;
        try {
            
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 installment=ra.getDouble("installmentTask1"); 
                 num=ra.getDouble("numOfinstallmentsTask1");
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
         return installment/num;
    }
      public double getextra02(int id){
        Statement st;
        double installment=0;
        double num=0;
        try {
            
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 installment=ra.getDouble("installmentTask2"); 
                 num=ra.getDouble("numOfinstallmentsTask2");
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
         return installment/num;
    }
      public double getextra03(int id){
        Statement st;
        double installment=0;
        double num=0;
        try {
            
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 installment=ra.getDouble("installmentTask3"); 
                 num=ra.getDouble("numOfinstallmentsTask3");
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
         return installment/num;
    }
      public int getstationaryfee(int id){
        Statement st;
        int installment=0;
        try {
            
            st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum='"+id+"'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 installment=ra.getInt("stationaryFee"); 
//                  System.out.println(installment);
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
         return installment;
    }
       public int getregfee(int id){
        Statement st;
        int installment=0;
        try {
            
            st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum='" +id+ "'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 installment=ra.getInt("RegistrationFee"); 
                  
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
         return installment;
    }
       public void extrapay01(int id){
        Statement st;
        double cut=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 double numOfInstallments =rs.getInt("numOfinstallmentsTask1");
                 double installment=rs.getInt("installmentTask1");    
                 if (numOfInstallments!=0) {
                 cut =installment/numOfInstallments;
                // updateincomeFinance(cut);
                 cut=installment-cut;
                numOfInstallments=numOfInstallments-1;
                 }
                 updateextrapayInstallment01(cut, id);
                 updateextrapayNOfInstallment01(numOfInstallments, id);
                 
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
       public void updateextrapayInstallment01(double cut,int id){
             try {   
    String sql = "UPDATE tasktable SET installmentTask1='" +cut+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
//            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       public void updateextrapayNOfInstallment01(double inst,int id){
             try {   
    String sql = "UPDATE tasktable SET numOfinstallmentsTask1='" +inst+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
//            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       ////////////////////////////////////////////////////////////////////////////////////////////////////
       public void tasktableSearch(JTable tab,int id){
           try{
           String sql ="select ID as [ID],name as [STUDENT'S NAME], numOfinstallmentsTask1 as [NUMBER OF INSTALLMENT TASK#01],numOfinstallmentsTask2 as [NUMBER OF INSTALLMENT TASK#02],numOfinstallmentsTask3 as [NUMBER OF INSTALLMENT TASK#03],installmentTask1 as [INSTALLMENT TASK # 01]  from tasktable WHERE ID = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
       }
       //////////////////////////////////////////////////////////////////////////////////////////////
       
         public void tasktableClickTable(JTable jTable1,JTextField extrafeeName1,JTextField extrafeeName2,JTextField extrafeeName3,JTextField NAmeStudent,JTextField extrafee01,JTextField extrafee02,JTextField extrafee03,JTextField noinstall01,JTextField noinstall02,JTextField noinstall03,JTextField id ){
         try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql= "select * from tasktable where ID = '" + table_click + "'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
//                AdminStudent adminStudent=new AdminStudent();
               String name=rs.getString("name");
               NAmeStudent.setText (name);
               String feename=rs.getString("taskOne");
               String feename2=rs.getString("taskTwo");
               String feename3=rs.getString("taskThree");
               extrafeeName1.setText(feename);
               extrafeeName2.setText(feename2);
               extrafeeName3.setText(feename3);
            String  instal1=rs.getString("installmentTask1");
                extrafee01.setText(instal1);
              String  install02=rs.getString("installmentTask2");
                extrafee02.setText(install02);
               String install03=rs.getString("installmentTask3");
                extrafee03.setText(install03);
               String noinstall1=rs.getString("numOfinstallmentsTask1");
                noinstall01.setText(noinstall1);
               String noinstall2=rs.getString("numOfinstallmentsTask2");
                noinstall02.setText(noinstall2);
              String  noinstall3=rs.getString("numOfinstallmentsTask3");
                noinstall03.setText(noinstall3);
               String id1=rs.getString("ID");
               id.setText(id1);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
      }
       ////////////////////////////////////////////////
       public void taskTable(JTable tab){
            try{
           String sql ="select ID as [ID],name as [STUDENT'S NAME], numOfinstallmentsTask1 as [NUMBER OF INSTALLMENT TASK#01],numOfinstallmentsTask2 as [NUMBER OF INSTALLMENT TASK#02],numOfinstallmentsTask3 as [NUMBER OF INSTALLMENT TASK#03],installmentTask1 as [INSTALLMENT TASK # 01]  from tasktable"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
       }
       
       ////////////////////////////////////////////
       public void extrapay02(int id){
        Statement st;
        double cut=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 double numOfInstallments =rs.getInt("numOfinstallmentsTask2");
                 double installment=rs.getInt("installmentTask2");    
                 if (numOfInstallments!=0) {
                 cut =installment/numOfInstallments;
          //       updateincomeFinance(cut);
                 cut=installment-cut;
                numOfInstallments=numOfInstallments-1;
                 }
                 updateextrapayInstallment02(cut, id);
                 updateextrapayNOfInstallment02(numOfInstallments, id);
                 
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
       public void updateextrapayInstallment02(double cut,int id){
             try {   
    String sql = "UPDATE tasktable SET installmentTask2='" +cut+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       public void updateextrapayNOfInstallment02(double inst,int id){
             try {   
    String sql = "UPDATE tasktable SET numOfinstallmentsTask2='" +inst+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
//            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       ////////////////////////////////////////////////////////////////////
       public void extrapay03(int id){
        Statement st;
        double cut=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 double numOfInstallments =rs.getInt("numOfinstallmentsTask3");
                 double installment=rs.getInt("installmentTask3");    
                 if (numOfInstallments!=0) {
                 cut =installment/numOfInstallments;
             //    updateincomeFinance(cut);
                 cut=installment-cut;
                numOfInstallments=numOfInstallments-1;
                 }
                 updateextrapayInstallment03(cut, id);
                 updateextrapayNOfInstallment03(numOfInstallments, id);
                 
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
       public void updateextrapayInstallment03(double cut,int id){
             try {   
    String sql = "UPDATE tasktable SET installmentTask3='" +cut+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
//            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       public void updateextrapayNOfInstallment03(double inst,int id){
             try {   
    String sql = "UPDATE tasktable SET numOfinstallmentsTask3='" +inst+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
//            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
        public boolean payStatus(int id){
        Statement st;
       double status=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 status =rs.getDouble("dues");
                 
                       }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in status","Record", JOptionPane.ERROR_MESSAGE);
        }
        if (status==0) {
                return true;
            }
            else
                return false;
        }
       public String dueDateUthaomonth(){
           Statement st;
           String month1="";
        try {
            st = con.createStatement();
            String sql = "SELECT month FROM DueDate  ";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                  month1  =rs.getString("month");
//                  System.out.println(month1);
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
           }
        return month1;
       }
        public String dueDateUthao(JTable jTable1){
            int row= jTable1.getSelectedRow();
            String month= jTable1.getModel().getValueAt(row, 4).toString();
           Statement st;
           String year1=jTable1.getModel().getValueAt(row, 5).toString();
           String day="";
           int d=0;
        try {
            st = con.createStatement();
            String sql = "SELECT day FROM DueDate ";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                  d  =rs.getInt("day");
//                  System.out.println(month1);
                       }
            if (d<=9) {
               day="0"+String.valueOf(d);
           }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update due","Record", JOptionPane.ERROR_MESSAGE);
           }
//        JOptionPane.showMessageDialog(null, year1+month+"10");
        return year1+month+d;
       }
        public boolean duesUthao(JTable table){
           Statement st;
           int row= table.getSelectedRow();
            double dd=Double.parseDouble( table.getModel().getValueAt(row, 3).toString());
            if (dd==0) {
                return false;
            } else {
                return true;
            }
       }
        public void duedatecaomparision(JRadioButton a,JRadioButton b,JTable table){
            String day=String.valueOf(getday());
           if (getday()<=9) {
               day="0"+String.valueOf(getday());
           }
            String date=Integer.toString(getYear())+Integer.toString(getMonth())+day;
//            System.out.println("date"+date);
            int currdate=Integer.parseInt(date);
//            System.out.println("333333");
            date=dueDateUthao(table);
//            JOptionPane.showMessageDialog(null, "errr");
//            System.out.println(date);
            int duedate=Integer.parseInt(date);
            
//            JOptionPane.showMessageDialog(null, "errr");
            if (duedate>=currdate) {
                a.setSelected(true);
            } else {
                b.setSelected(true);
            }
            
//            JOptionPane.showMessageDialog(null, "errr");
        }
        int inst1;
        int inst2;
        int inst3;
        public boolean read01(){
            
            boolean flag=false;
         Statement st=null;
            try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable ";// where IDnum='" +id+ "'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 inst1=ra.getInt("installmentTask1");
                  if (inst1!=0){
//                      return true;
                        flag=true;
                  }
                  
                      
                       }
            
            
            
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
            if (flag==true){
             return true;   
            }
            else {
                return false;
            }
        }
        public boolean read02(){
            
            boolean flag=false;
         Statement st=null;
            try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable ";// where IDnum='" +id+ "'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 inst2=ra.getInt("installmentTask2");
                  if (inst1>0){
                      System.out.println(inst2);  
                        flag=true;
                  }           
                       }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
            if (flag==true){
             return true;   
            }
            else {
                return false;
            }
        } public boolean read03(){
            
            boolean flag=false;
         Statement st=null;
            try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable ";// where IDnum='" +id+ "'";  
          ResultSet  ra = st.executeQuery(sql);
            while(ra.next()){        
                 inst3=ra.getInt("installmentTask3");
                  if (inst3!=0){
//                      return true;
                        flag=true;
                  }
                  
                      
                       }
            
            
            
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"naiboi","Connection Error", JOptionPane.ERROR_MESSAGE);
        }
            if (flag==true){
             return true;   
            }
            else {
                return false;
            }
        }
        public void updateTask01(String task01,String inst){
            if(read01()==false){
            try {   
    String sql = "UPDATE tasktable SET taskOne='" +task01+ "',installmentTask1 = '"+inst+"'";//+ "where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } }
            else {
                 JOptionPane.showMessageDialog(null,"FEES REMAINING","FEES",JOptionPane.INFORMATION_MESSAGE);
          
            }
        }
        public void updateTask02(String task02,String inst){
            if (read02()==false){
            try {   
    String sql = "UPDATE tasktable SET taskTwo='" +task02+ "',installmentTask2 = '"+inst+"'";//+ "where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } }
        }
        public void updateTask03(String task03,String inst){
            if (read03()==false){
            try {   
    String sql = "UPDATE tasktable SET taskThree='" +task03+ "',installmentTask3 = '"+inst+"'";//+ "where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } }
        }
        public void getINCOMEtotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM fINANCE where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("income");
            } 
           // txt.setText(String.valueOf(absent));
//            System.out.println(absent);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }}
        public void getependituretotal(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM fINANCE where Month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("expenditure");
            } 
           // txt.setText(String.valueOf(absent));
//            System.out.println(absent);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }   
    }
        public double getduestotal(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT dues FROM studentFinance";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("dues");
            } 
           // txt.setText(String.valueOf(absent));
//            System.out.println(absent);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"gettotaldues","Record", JOptionPane.ERROR_MESSAGE);
        }
        return absent;
    }
        public int getfeestotal(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT fees FROM Student";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("fees");
            } 
           // txt.setText(String.valueOf(absent));
//            System.out.println(absent);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
        return absent;
    }
        public int getsalarytotal(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT BasicSalary FROM Staff";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("BasicSalary");
            } 
           // txt.setText(String.valueOf(absent));
//            System.out.println(absent);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
        return absent;
    }
        public int getsalaryDuestotal(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT dues FROM TeacherSalary";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("dues");
            } 
           // txt.setText(String.valueOf(absent));
//            System.out.println(absent);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
        return absent;
    }
        public void financeRecord(JTable tab ){
   
       
       try{
           String sql ="select income as [INCOME],expenditure as [EXPENDITURE], dueday as [DUE DATE],month as [MONTH],year as [YEAR],expectedincome as [EXPENDITURE INCOME],expectedexpenditure as [EXPECTED EXPENDITURE],fees as [FEES],dues as [DUES] from FINANCE"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
   
        }
        public void financeRecordmonth(JTable tab,String month ){
   
       
       try{
           String sql ="select income as [INCOME],expenditure as [EXPENDITURE], dueday as [DUE DATE],month as [MONTH],year as [YEAR],expectedincome as [EXPENDITURE INCOME],expectedexpenditure as [EXPECTED EXPENDITURE],fees as [FEES],dues as [DUES] from FINANCE WHERE month = '"+month+"'"; 
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
   
        }
        public boolean searchfinancemonth(String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Finance where month ='"+month+"'" ; //+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String mon = rs.getString("month");
//                  String stdName=rs.getString("StudentName");
                   if(mon.equals(month) ){
                     
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
           public void financeRecordyear(JTable tab,String year ){
   
       
       try{
           String sql ="select income as [INCOME],expenditure as [EXPENDITURE], dueday as [DUE DATE],month as [MONTH],year as [YEAR],expectedincome as [EXPENDITURE INCOME],expectedexpenditure as [EXPECTED EXPENDITURE],fees as [FEES],dues as [DUES] from FINANCE WHERE year = '"+year+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
   
        }
        public boolean searchfinanceyear(String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Finance where year ='"+year+"'" ; //+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String ye = rs.getString("year");
//                  String stdName=rs.getString("StudentName");
                   if(ye.equals(year) ){
                     
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
           public void financeRecordmonthyear(JTable tab,String month,String year ){
   
       
       try{
           String sql ="select income as [INCOME],expenditure as [EXPENDITURE], dueday as [DUE DATE],month as [MONTH],year as [YEAR],expectedincome as [EXPENDITURE INCOME],expectedexpenditure as [EXPECTED EXPENDITURE],fees as [FEES],dues as [DUES] from FINANCE WHERE month = '"+month+"'"+"AND year = '"+year+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
   
        }
        public boolean searchfinancemonthyear(String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Finance where month ='"+month+"'"+"AND year = '"+ year+"'"; //+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String mon = rs.getString("month");
                  String yo=rs.getString("year");
                   if(yo.equals(year) ){
                     
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
        public void getincomefinance(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT income FROM Finance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("income");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
        public void getexpenfinance(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT expenditure FROM Finance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("expenditure");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
        public void getfeesfinance(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT fees FROM Finance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("fees");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
        public void getfeesDuesfinance(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT * FROM Finance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("feesdues");
            } 
            txt.setText(String.valueOf(absent));
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
        public void getsalaryfinance(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT salary FROM Finance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("salary");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
        public void getsalaryduesfinance(int month,int year,JLabel txt){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT salarydues FROM Finance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("salarydues");
            } 
            txt.setText(String.valueOf(absent));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            
    }
        public void totalamount(int month,int year,JLabel income,JLabel ex,JLabel fees,JLabel feesdues,JLabel adv,JLabel rd){
       try {
          ;
//           System.err.println(month);
//           System.err.println(year);
           getincomefinance(month, year, income);
           getexpenfinance(month, year, ex);
           getfeesfinance(month, year, fees);
           getfeesDuesfinance(month, year, feesdues);
           getsalaryfinance(month, year, adv);
           getsalaryduesfinance(month, year, rd);
//        JOptionPane.showMessageDialog(null,"challing","Record", JOptionPane.ERROR_MESSAGE);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"ERROR IN UPDATE","Record", JOptionPane.ERROR_MESSAGE);
       }
      
  }
        public int getlastmonth(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT month FROM studentFinance";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("month");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
       return absent;
    }
        public int getlastyear(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT year FROM studentFinance";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("year");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
       return absent;
        }
        public int getdueslastyear(int month,int year){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT dues FROM studentFinance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("dues");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
       return absent;
        }
        public int getfeeslastyear(int month,int year){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT fees FROM studentFinance where month='" +month+ "' AND year='" +year+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("fees");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
       return absent;
        }
        public boolean checkfeedue(){
            if (getfeeslastyear(getlastmonth(),getlastyear())==getdueslastyear(getlastmonth(),getlastyear())) {
                return true;
            } else {
                return false;
            }
        }
        public boolean checkdate(){
            if (getlastmonth()<=getMonth())
                 {
                return true;
            } else {
                return false;
            }
        }
        public void enterdatatofinance(){
            if (checkdate()) {
                dataToStudentFinaceAdd();
            }
            else
                JOptionPane.showMessageDialog(null, "CANNOT ENTER","Records",JOptionPane.INFORMATION_MESSAGE);
        }
         public void deletefees()
    {
        try{
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)   
            {  
                String sql="Delete From studentFinance where month='" +getlastmonth()+ "' AND year='" +getlastyear()+ "'";
                pst =con.prepareStatement(sql);
                pst.execute();
                pst.close();
                 JOptionPane.showMessageDialog(null, "Succesfully Deleted","Records",JOptionPane.INFORMATION_MESSAGE);
   
            }
            }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"ERROR IN DELETE","Record", JOptionPane.ERROR_MESSAGE);
        }
    }  
         public void deletedatatofinance(){
            if (checkfeedue()) {
                dataToStudentFinaceAdd();
            }
            else
                JOptionPane.showMessageDialog(null, "CANNOT DELETE","Records",JOptionPane.INFORMATION_MESSAGE);
         }
         public int getlastyearfORsALARY(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT year FROM Teachersalary";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("year");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
       return absent;
        }
         public int getlastMonthfORsALARY(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT month FROM Teachersalary";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("month");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
       return absent;
        }
         public boolean checksalarydate(){
             
             if (previousMonth()==getlastMonthfORsALARY()) {
                return true;
             } else {
                 return false;
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
   public int getduesSalarylast(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT dues FROM TeacherSalary where month='" +getlastMonthfORsALARY()+ "' AND year='" +getlastyearfORsALARY()+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("dues");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);   
        }
        return absent;
   }
    public int getSalarylast(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT salary FROM TeacherSalary where month='" +getlastMonthfORsALARY()+ "' AND year='" +getlastyearfORsALARY()+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent+=rs.getInt("salary");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);   
        }
        return absent;
   }
    public boolean checksalarydue(){
             
             if (getSalarylast()==getduesSalarylast()) {
                return true;
             } else {
                 return false;
             }
         }
    public void addsal(){
        if (checksalarydate()==false) {
            Staff s=new Staff();
            s.staffTosalary();
        }
        else
            JOptionPane.showMessageDialog(null,"salary already added","Record", JOptionPane.ERROR_MESSAGE);
    }
    public void adddueDate() {
        try{
   String sql1 = "Insert into DueDate(day,month,year) values (?,?,?)";
            pst = con.prepareStatement(sql1);   
            pst.setInt(1, 10);
            pst.setInt(2, getdueMonth());
            pst.setInt(3, getdueYear());

            pst.execute();  
          //  JOptionPane.showMessageDialog(null,"Successfully Saved ","Student Record",JOptionPane.INFORMATION_MESSAGE);       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"addStudentduedate","Connection Error", JOptionPane.ERROR_MESSAGE);    
        } 
    }
     public int getdueMonth(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT month FROM studentFinance";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("month");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);   
        }
        return absent;
   }
     public int getdueYear(){
        Statement st;
        int absent=0;
        try {           
            st = con.createStatement();
            String sql = "SELECT year FROM studentFinance";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 absent=rs.getInt("year");
            } 
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);   
        }
        return absent;
   }
      public int currentins01(int id){
        Statement st;
        int cut=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 int numOfInstallments =rs.getInt("numOfinstallmentsTask1");
                 int installment=rs.getInt("installmentTask1");    
                 if (numOfInstallments!=0) {
                 cut =installment/numOfInstallments;
                 
                 }
                       }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return cut;
    }
      public void updateExpenditureINFinance(int num){   
          int in=0;
          try{
        Statement st=con.createStatement();
            String sql="Select * FROM Finance where month = '"+getMonth()+"' AND Year='"+getYear()+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                in=rs.getInt("expenditure");
                num=in-num;
                 String sql1 = "UPDATE Finance SET expenditure='"+num+"' where month = '"+getMonth()+"' AND year='"+getYear()+"'";
       pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();        
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void updateNETSALARYINFinance(int num,int month ,int year){   
          int in=0;
          try{
      
                 String sql1 = "UPDATE TeacherSalary SET NetSalary='"+num+"' where month = '"+month+"' AND year='"+year+"'";
       pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();        
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public String getmonthforpay(){   
          String in=null;
          try{
        Statement st=con.createStatement();
            String sql="Select month FROM paySalary";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                in=rs.getString("month");
                
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
          return in;
      }
      public boolean checkdataBase(){
          int a=0;
           Statement st;
           boolean use=false;
           String day="";
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM studentFinance ";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 
               a++; 
                if (a>0) {
                    use=true;
                    break;
                }
                       }
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
           }
        return use;
       }
      public void updatefeesdate(){   
          int month=0;
        int year=0;
          if (getday()>=25) {
         month=getMonth()+1;
         year=getYear();
        if (month==13) {
            month=1;
            year=year+1;
        }      
          }else{
         month=getMonth();
         year=getYear();
        }
          try{
      
                 String sql1 = "UPDATE feesdate SET month='"+month+"',year='"+year+"'";
       pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();        
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
      public void addfeesDuedateFirst() {
          int month=0;
        int year=0;
          if (getday()>=25) {
         month=getMonth()+1;
         year=getYear();
        if (month==13) {
            month=1;
            year=year+1;
        }      
          }else{
         month=getMonth();
         year=getYear();
        }
        try{
   String sql1 = "Insert into feesdate(month,year) values (?,?)";
            pst = con.prepareStatement(sql1);   
            pst.setInt(1,month);
            pst.setInt(2,year);
            pst.execute();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"addStudentduedatefirst","Connection Error", JOptionPane.ERROR_MESSAGE);
          
        } 
        
        
    }
      
      public void insertFirstDuedate(){
          if (checkdataBase()) {
              FeedFees();
              return;
          } else {
              addfeesDuedateFirst();
              dataToStudentFinaceAdd();
          }
      }
      public String getmonthforfees(){   
          String in=null;
          try{
        Statement st=con.createStatement();
            String sql="Select month FROM feesdate";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                in=rs.getString("month");
                
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
          return in;
      }
      public String getyearforfees(){   
          String in=null;
          try{
        Statement st=con.createStatement();
            String sql="Select year FROM feesdate";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                in=rs.getString("year");
                
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
          return in;
      }
       public boolean predatefees(){
           String pre=getyearforfees()+getmonthforfees()+"25";
           String day=String.valueOf(getday());
           if (getday()<=9) {
               day="0"+String.valueOf(getday());
           }
           String date=Integer.toString(getYear())+Integer.toString(getMonth())+day;
//           System.out.println(date);
           if (Integer.parseInt(pre)>Integer.parseInt(date)) {
               return false;
           } else {
               return true;
           }
       }
       public void disss(JTextField set,int a,int b){
           if (a<b) {
               JOptionPane.showMessageDialog(null, "over discount");
           }else{
               set.setText(String.valueOf(a-b));
           }
       }
       public void updatedues(int num,String id,String month,String year){   
          int in=0;
          try{
                 Statement st=con.createStatement();          
                 String sql1 ="UPDATE studentFinance SET dues='"+num+"' where  ID= '"+id+"' AND  month = '"+month+"' AND year='"+year+"'";
                 pst = con.prepareStatement(sql1);        
                 pst.executeUpdate();
                 pst.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
       public void checkdues (JTable jTable1,JTextField dues,JTextField diss){
           try {
            int row= jTable1.getSelectedRow();
            String id_click= jTable1.getModel().getValueAt(row, 0).toString();
            String dues_click= jTable1.getModel().getValueAt(row, 5).toString();
            String month_click= jTable1.getModel().getValueAt(row, 6).toString();
            String year_click= jTable1.getModel().getValueAt(row, 7).toString();
               if (Integer.parseInt(dues_click)!=0) {
                   updatedues(Integer.valueOf(dues.getText()), id_click, month_click, year_click);
                   updatedisss(Integer.valueOf(diss.getText()), id_click, month_click, year_click);
               }else
                    JOptionPane.showMessageDialog(null,"already paid","over pay", JOptionPane.ERROR_MESSAGE);
           } catch (Exception e) {
               
           }
       }
       public void updatedisss(int num,String id,String month,String year){   
          int in=0;
          try{
                 Statement st=con.createStatement();          
                 String sql1 ="UPDATE studentFinance SET discount='"+num+"' where  ID= '"+id+"' AND  month = '"+month+"' AND year='"+year+"'";
                 pst = con.prepareStatement(sql1);        
                 pst.executeUpdate();
                 pst.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
       public void reUpdaterues (String id_click){
           try {
               double a=getlastDues(id_click);
               System.out.println(a);
               if (a!=0) {
                   updateDuesStudentFinance(id_click,generateDues(id_click));  
                   System.out.println("done");
               }
               JOptionPane.showMessageDialog(null,"update","done", JOptionPane.INFORMATION_MESSAGE);
           } catch (Exception e) {
               
           }
       }
        public double getlastDues(String ID){
         try{
           
            Statement st=con.createStatement();
            String sql="Select * FROM studentFinance where ID= '"+ID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                
                 dues=rs.getDouble("Dues");
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"getDues","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
       return dues;
    }
}