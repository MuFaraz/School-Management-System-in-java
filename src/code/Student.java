package code;


import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Faraz
 */
public class Student {
    private int id;
    private int challanNo;
    private String StudentName;
   classes classes=new classes();
    private String Grade=classes.getClassNo();
    private String Csection=classes.getSection();
    private String FatherName;
    private String Celnum1;
    private String Celnum2;
    private String Celnum3;
    private int fees;
    private int REgistrationfees;
    private String AdmissionDate;

    public Student() {
    }
    public Student(JTextField idno,JTextField challan){
//        this.id=1;
//        this.challanNo=1002;
        countID(idno, challan);
    }
    public Student(String StudentName, String FatherName, String Celnum1, String Celnum2, String Celnum3,int fees,String Grade,String Csection,String AddmissionDate,int idno,int challan) {
        this.StudentName = StudentName;
        this.FatherName = FatherName;
        this.Celnum1 = Celnum1;
        this.Celnum2 = Celnum2;
        this.Celnum3 = Celnum3;
        this.id=idno;
        this.challanNo=challan;
        this.fees=fees;
        this.Grade=Grade;
        this.Csection=Csection;
        this.AdmissionDate=AddmissionDate;
    }

    public void setId(int id) {
        this.id=id;
        
    }

    public void setChallanNo(int challanNo) {
        this.challanNo = challanNo;
    }

    public int getREgistrationfees() {
        return REgistrationfees;
    }
    
    public Student(String StudentName, String FatherName,String cellnum1, String Celnum2, String Celnum3, int fees, String AdmissionDate ,int id,String classes,String section) {
        this.StudentName = StudentName;
        this.FatherName = FatherName;
        this.Celnum2 = Celnum2;
        this.Celnum3 = Celnum3;
        this.fees = fees;
        this.AdmissionDate = AdmissionDate;
        this.id=id;
        this.Grade=classes;
        this.Csection=section;
    }
    public void StudentRecordfees(JTable tab)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
    public void StudentRecordfeesid(JTable tab,String id)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance where ID = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
    public boolean searchStudentfeesid(String IDnum){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where ID ='"+IDnum+"'";//AND StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
//                  String stdName=rs.getString("StudentName");
                   if(IDnum.equals(Idnum)){
                     
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
    public void StudentRecordfeesmonth(JTable tab,String id)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance where month = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
    public boolean searchStudentfeesmonth(String IDnum){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where month ='"+IDnum+"'";//AND StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("month");
//                  String stdName=rs.getString("StudentName");
                   if(IDnum.equals(Idnum)){
                     
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
    public void StudentRecordfeesyear(JTable tab,String id)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance where year = '"+id+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
    public boolean searchStudentfeesyear(String IDnum){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where year ='"+IDnum+"'";//AND StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("year");
//                  String stdName=rs.getString("StudentName");
                   if(IDnum.equals(Idnum)){
                     
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
    public void StudentRecordfeesidmonth(JTable tab,String id,String month)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance where ID = '"+id+"'"+"AND month = '"+month+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
     public void getDataStudent(JTable table,String search,String Name){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where IDnum = '"+search+"'" +"AND StudentName = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}
}
            public void getDataStudentID(JTable table,String search){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where IDnum = '"+search+"'" ;//+"AND StudentName = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}
       
}
            public void getDataStudentname(JTable table,String Name){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where StudentName = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}
}

    public String getAdmissionDate() {
        return AdmissionDate;
    }
    public void getDataStudentclass(JTable table,String search){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where Grade = '"+search+"'" ;//+"AND StudentName = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}}
    public boolean searchStudentclass(String IDnum){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where Grade ='"+IDnum+"'" ; //+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("Grade");
//                  String stdName=rs.getString("StudentName");
                   if(IDnum.equals(Idnum) ){
                     
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
    public void getDataStudentSec(JTable table,String search){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where Section = '"+search+"'" ;//+"AND StudentName = '"+Name+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}}
    public boolean searchStudentsec(String IDnum){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where Section ='"+IDnum+"'" ; //+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("Section");
//                  String stdName=rs.getString("StudentName");
                   if(IDnum.equals(Idnum) ){
                     
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
    public void getDataStudentidclass(JTable table,String search,String classe){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where IDnum = '"+search+"'"+"AND Grade = '"+classe+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}}
    public boolean searchStudentidclass(String IDnum,String classe){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum ='"+IDnum+"'"+"'AND Grade = '"+classe+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  
                  String Idnum = rs.getString("IDnum");
                  String stdName=rs.getString("Grade");
                   if(IDnum.equals(Idnum)&&stdName.equals(classe) ){
                     
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
    public void getDataStudentidsec(JTable table,String search,String sec){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where IDnum = '"+search+"'"+"AND Section = '"+sec+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}}
    public boolean searchStudentidsection(String IDnum,String sec){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum ='"+IDnum+"'"+"'AND Section = '"+sec+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  
                  String Idnum = rs.getString("IDnum");
                  String stdName=rs.getString("Section");
                   if(IDnum.equals(Idnum)&&stdName.equals(sec) ){
                     
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
    public void getDataStudentclasssec(JTable table,String classe,String sec){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where Grade = '"+classe+"'"+"AND Section = '"+sec+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}}
    public boolean searchStudentclasssection(String classe,String Sec){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where Grade ='"+classe+"'"+"'AND Section = '"+Sec+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  
                  String Idnum = rs.getString("Grade");
                  String stdName=rs.getString("Section");
                   if(classe.equals(Idnum)&&stdName.equals(Sec) ){
                     
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
    public void getDataStudentidclasssection(JTable table,String search,String classe,String sec){
        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where IDnum = '"+search+"'"+"AND Grade = '"+classe+"'"+"AND Section = '"+sec+"'";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
          
}}
    public boolean searchStudentidclasssec(String IDnum,String classe,String sec){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum ='"+IDnum+"'"+"'AND Grade = '"+classe+"'"+"AND Section = '"+sec+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  
                  String Idnum = rs.getString("IDnum");
                  String stdName=rs.getString("Grade");
                  String sec1=rs.getString("Section");
                   if(IDnum.equals(Idnum)&&stdName.equals(classe)&&sec1.equals(sec) ){
                     
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
    public boolean searchStudentfeesidmonth(String IDnum,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where ID ='"+IDnum+"'"+"AND month = '"+month+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("month");
                   if(IDnum.equals(Idnum)&&stdName.equals(month)){
                     
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
    }public void StudentRecordfeesidyear(JTable tab,String id,String month)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance where ID = '"+id+"'"+"AND year = '"+month+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
    public boolean searchStudentfeesidyear(String IDnum,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where ID ='"+IDnum+"'"+"AND year = '"+month+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("year");
                   if(IDnum.equals(Idnum)&&stdName.equals(month)){
                     
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
    public void StudentRecordfeesmonthyear(JTable tab,String id,String month)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance where month = '"+id+"'"+"AND year = '"+month+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
    public boolean searchStudentfeesmonthyear(String IDnum,String month){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where month ='"+IDnum+"'"+"AND year = '"+month+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("month");
                  String stdName=rs.getString("year");
                   if(IDnum.equals(Idnum)&&stdName.equals(month)){
                     
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
    }public void StudentRecordfeesidmonthyear(JTable tab,String id,String month,String year)
   {
       
       try{
           String sql ="select ID as [ID],fees as [FEES],registrationfee as [REGISTRATION FEE],stationaryfee as[STATIONARY FEE],discount as [DISCOUNT],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance where ID = '"+id+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
       }
   }
    public boolean searchStudentfeesidmonthyear(String IDnum,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM studentFinance where ID ='"+IDnum+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  
                  String stdName1=rs.getString("month");
                  String stdName=rs.getString("year");
                   if(IDnum.equals(Idnum)&&stdName.equals(year)
                           && stdName1.equals(month)){
                     
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
    public int getId() {
        return id;
    }

    public int getChallanNo() {
        return challanNo;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getGrade() {
        return Grade;
    }

    public String getCsection() {
        return Csection;
    }

    public String getFatherName() {
        return FatherName;
    }

    public String getCelnum1() {
        return Celnum1;
    }

    public String getCelnum2() {
        return Celnum2;
    }

    public String getCelnum3() {
        return Celnum3;
    }

    public int getFees() {
        return fees;
    }
    public static boolean isInteger(String s) {
      boolean isValidInteger = false;
      try
      {
          Long.parseLong(s);
//         Integer.parseInt(s);
 
         // s is a valid integer
 
         isValidInteger = true;
      }
      catch (NumberFormatException ex)
      {
         // s is not an integer
      }
 
      return isValidInteger;
   }
    
   Connection2DB connection=new Connection2DB();
        Connection con = connection.setConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;
        public void countID(JTextField idnot,JTextField chalan){
            try{
                id=1;
                challanNo=1002;
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student ";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  int Idnum = rs.getInt("IDnum");
                  int chalana = rs.getInt("ChallanNo");
                  if (Idnum>id) {
                      id=Idnum;
                  }
                  if (chalana>challanNo) {
                      challanNo=chalana;
                  }
              }
              id++;
              challanNo++;
              idnot.setText(String.valueOf(id));
              chalan.setText(String.valueOf(challanNo));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
      
        }
        }
    public void addStudent(String statFees) {
        
        try {
            String sql = "Insert into Student(IDnum,ChallanNo,StudentName,FatherName,CellNumone,CellNumtwo,CellNumthree,Grade,fees,RegistrationFee,Section,AdmissionDate,stationaryFee) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
           
            pst.setInt(1,getId());
            pst.setInt(2, getChallanNo());
            pst.setString(3, getStudentName());
            pst.setString(4, getFatherName());
            pst.setString(5, getCelnum1());
            pst.setString(6, getCelnum2());
            pst.setString(7,getCelnum3());
            pst.setString(8,getGrade());
            pst.setInt(9,getFees());
            pst.setInt(10,getREgistrationfees());
            pst.setString(11, getCsection());
            pst.setString(12, AdmissionDate);
            pst.setString(13,statFees);
            pst.execute();
//            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully Saved ","Student Record",JOptionPane.INFORMATION_MESSAGE);
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }
    }
     public void addStudenttoTask(String anual) {
        
        try {
            String sql = "Insert into tasktable(ID,name,taskOne,taskTwo,taskThree,numOfinstallmentsTask1,installmentTask1,numOfinstallmentsTask2,numOfinstallmentsTask3,installmentTask2,installmentTask3) values (?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
           
            pst.setInt(1,getId());
            pst.setString(2, getStudentName());
            pst.setString(3, "ANNUAL CHARGES");
            pst.setString(4, "");
            pst.setString(5, "");
            pst.setString(6, "1");
            pst.setString(7,anual);
            pst.setString(8,"1");
            pst.setString(9,"1");
            pst.setString(10,"0");
            pst.setString(11, "0");
            pst.execute();
//            pst.close();
            
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }
    }
        public void deleteStudent(String ID)
    {
        try{
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)   
            {  
                String sql="Delete From Student where IDnum = ?";
                pst =con.prepareStatement(sql);
                pst.setString(1, ID);
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
        public boolean searchStudentidNAME(String IDnum,String Name){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum ='"+IDnum+"'AND StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("IDnum");
                  String stdName=rs.getString("StudentName");
                   if(IDnum.equals(Idnum)&&Name.equals(stdName) ){
                     
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
    }public boolean searchStudentname(String Name){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where StudentName ='"+Name+"'" ; //+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("IDnum");
                  String stdName=rs.getString("StudentName");
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
    public boolean searchStudentid(String IDnum){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum ='"+IDnum+"'" ; //+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("IDnum");
                  String stdName=rs.getString("StudentName");
                   if(IDnum.equals(Idnum) ){
                     
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
         public void updateStudent(String ID){
    try {   
    String sql = "UPDATE Student SET StudentName=?,FatherName=?,CellNumone=?,CellNumtwo=?,CellNumthree=?,Grade=?,fees=?,Section=?, AdmissionDate=? WHERE IDnum = '"+ID+"'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,getStudentName());
            pst.setString(2,getFatherName());
            pst.setString(3,getCelnum1());
            pst.setString(4,getCelnum2());
            pst.setString(5,getCelnum3());
            pst.setString(6,getGrade());
            pst.setInt(7, getFees());
            pst.setString(8, getCsection());
            pst.setString(9, getAdmissionDate());
               pst.executeUpdate();
               JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
  }
         
         public void StudentRecord(JTable tab)
   {
       
       try{
           String sql ="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date]  from Student"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
//           JTableHeader Theader=tab.getTableHeader();
//           Theader.setFont(new Font("SEGUI UI",Font.BOLD,15));
//           tab.setFont(new Font("Tahoma",Font.PLAIN,12));
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
   }
//         public void getDataStudent(JTable table,String search,String Name){
//        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where IDnum = '"+search+"'" +"AND StudentName = '"+Name+"'";
//          try{
//         pst=con.prepareStatement(sql);
//          rs= pst.executeQuery();
//         table.setModel(DbUtils.resultSetToTableModel(rs));
//         }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error");
//          
//}
//}
//            public void getDataStudentID(JTable table,String search){
//        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where IDnum = '"+search+"'" ;//+"AND StudentName = '"+Name+"'";
//          try{
//         pst=con.prepareStatement(sql);
//          rs= pst.executeQuery();
//         table.setModel(DbUtils.resultSetToTableModel(rs));
//         }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error");
//          
//}
//}   public void getDataStudentname(JTable table,String Name){
//        String sql="select IDnum as [ID],ChallanNo as [Challan Number], StudentName as [Student's Name],Grade as [Grade],Section as [Section],FatherName as [Father's Name],CellNumone as [Contact],fees as [Stat],AdmissionDate as [Admission Date] from Student where StudentName = '"+Name+"'";
//          try{
//         pst=con.prepareStatement(sql);
//          rs= pst.executeQuery();
//         table.setModel(DbUtils.resultSetToTableModel(rs));
//         }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error");
//          
//}
//}

    
         public void studentClickTable(JTable jTable1,JTextField NAmeStudent,JTextField gnametf1,JTextField contact1,JTextField contact2,JTextField contact3,JTextField classtf1,JTextField sectf1,JTextField feetf1,JTextField addmidatetf1,JTextField idnotf1 ){
         try{ 
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql= "select * from Student where IDnum = '" + table_click + "'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
//                AdminStudent adminStudent=new AdminStudent();
               String StudentName=rs.getString("StudentName");
               NAmeStudent.setText (StudentName);
            String  Gname=rs.getString("FatherName");
                gnametf1.setText(Gname);
              String  CellNumone=rs.getString("CellNumone");
                contact1.setText(CellNumone);
               String Contact=rs.getString("CellNumtwo");
                contact2.setText(Contact);
               String contac3=rs.getString("CellNumthree");
                contact3.setText(contac3);
               String Class=rs.getString("Grade");
                classtf1.setText(Class);
              String  Section=rs.getString("Section");
                sectf1.setText(Section);
              String  Fees=rs.getString("fees");
                feetf1.setText(Fees);
               String AdmisDate=rs.getString("AdmissionDate");
                addmidatetf1.setText(AdmisDate);
               String  idnum=rs.getString("IDnum");
                idnotf1.setText(idnum);
               
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
        }
      }
         public void insert(String ID1,String Name1){
             try {
            String sql = "Insert into taskTable(ID,name) values (?,?)";
            pst = con.prepareStatement(sql);
           
            pst.setString(1,ID1);
            pst.setString(2, Name1);
            pst.execute();
//            pst.close();
           
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }
         }
         public void updateinstallmentTask1(String instalmentTask1){
             try {   
    String sql = "UPDATE tasktable SET installmentTask1 = ? ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,instalmentTask1);
            
               pst.executeUpdate();
               
            pst.close();
        }
             JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
         public void updateinstallmentTask2(String instalmentTask2){
             try {   
    String sql = "UPDATE tasktable SET installmentTask2=? ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,instalmentTask2);
            
               pst.executeUpdate();
               
            pst.close();
        }
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
         public void updateinstallmentTask3(String instalmentTask3){
             try {   
    String sql = "UPDATE tasktable SET installmentTask3=? ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,instalmentTask3);
            
               pst.executeUpdate();
               
            pst.close();
        }
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
         public void updateNoofinstallmentTask1(String noOFInstallmentTask1,String ID1){
             try {   
    String sql = "UPDATE tasktable SET numOfinstallmentsTask1=? WHERE ID = '"+ID1+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,noOFInstallmentTask1);
            
               pst.executeUpdate();
               
            pst.close();
        
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
         public void updateNoofinstallmentTask2(String noOFInstallmentTask2,String ID1){
             try {   
    String sql = "UPDATE tasktable SET numOfinstallmentsTask2=? WHERE ID = '"+ID1+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,noOFInstallmentTask2);
            
               pst.executeUpdate();
               
            pst.close();
        
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
         public void updateNoofinstallmentTask3(String noOFInstallmentTask3,String ID1){
             try {   
    String sql = "UPDATE tasktable SET numOfinstallmentsTask3=? WHERE ID = '"+ID1+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,noOFInstallmentTask3);
            
               pst.executeUpdate();
               
            pst.close();
        
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
         
         
         
    public void StudentTotaskTable(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student ";//where IDnum ='"+IDnum+"'OR StudentName = '"+Name+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("IDnum");
                  String stdName=rs.getString("StudentName");
//                  insert(Idnum, stdName);
                   
                       }
        }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
    }
      public void extrapay01(int id){
        Statement st;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 double numOfInstallments =rs.getInt("numOfinstallmentsTask1");
                 double installment=rs.getInt("installmentTask1");    
                 double cut =installment/numOfInstallments;
                 cut=installment-cut;
                 numOfInstallments=numOfInstallments-1;
                 updateextrapayInstallment01(cut, id);
                 updateextrapayNOfInstallment01(numOfInstallments, id);
                       }
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error ","EXTRAPAY", JOptionPane.ERROR_MESSAGE);
          
        }
            
    }
       public void updateextrapayInstallment01(double cut,int id){
             try {   
    String sql = "UPDATE tasktable SET installmentTask1='" +cut+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
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
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       
       ////////////////////////////////////////////
       public void extrapay02(int id){
        Statement st;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 double numOfInstallments =rs.getInt("numOfinstallmentsTask2");
                 double installment=rs.getInt("installmentTask2");    
                 double cut =installment/numOfInstallments;
                 cut=installment-cut;
                 numOfInstallments=numOfInstallments-1;
                 updateextrapayInstallment02(cut, id);
                 updateextrapayNOfInstallment02(numOfInstallments, id);
                       }
        
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       ////////////////////////////////////////////////////////////////////
       public void extrapay03(int id){
        Statement st;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 int numOfInstallments =rs.getInt("numOfinstallmentsTask3");
                 int installment=rs.getInt("installmentTask3");    
                 int cut =installment/numOfInstallments;
                 cut=installment-cut;
                 numOfInstallments=numOfInstallments-1;
                 updateextrapayInstallment03(cut, id);
                 updateextrapayNOfInstallment03(numOfInstallments, id);
                       }
        
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
         
        }
            
    }
       public void updateextrapayInstallment03(int cut,int id){
             try {   
    String sql = "UPDATE tasktable SET installmentTask3='" +cut+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       public void updateextrapayNOfInstallment03(int inst,int id){
             try {   
    String sql = "UPDATE tasktable SET numOfinstallmentsTask3='" +inst+ "' where ID='" +id+ "'";
            pst = con.prepareStatement(sql);
               pst.executeUpdate();  
            pst.close();
            JOptionPane.showMessageDialog(null,"Successfully updated","Student Record",JOptionPane.INFORMATION_MESSAGE);
          
             }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          } 
         }
       public void studentTotask(String id, String name,String noinstal101,String noinstal102,String noinstall03){
           try {
            String sql = "Insert into tasktable(ID,name,numOfinstallmentsTask1,numOfinstallmentsTask2,numOfinstallmentsTask3) values (?,?,?,?,?)";
            pst = con.prepareStatement(sql);
           
            pst.setString(1,id);
            pst.setString(2, name);
            pst.setString(3, noinstal101);
            pst.setString(4, noinstal102);
            pst.setString(5, noinstall03);
            pst.execute();
//            pst.close();
           
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }
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
//                     JOptionPane.showConfirmDialog(null, "s");
                 cut =installment/numOfInstallments;  
                 }
                 
                       }
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return cut;
    }
       public int currentins02(int id){
        Statement st;
        int cut=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 int numOfInstallments2 =rs.getInt("numOfinstallmentsTask2");
                 int installment2=rs.getInt("installmentTask2");    
                 if (numOfInstallments2!=0) {
                 cut =installment2/numOfInstallments2;
                    
                 }
                 
                       }
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return cut;
    }
       public int currentins03(int id){
        Statement st;
        int cut=0;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tasktable where ID='" +id+ "'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                 int numOfInstallments3 =rs.getInt("numOfinstallmentsTask3");
                 int installment3=rs.getInt("installmentTask3");    
                 if (numOfInstallments3!=0) {
                 cut =installment3/numOfInstallments3;
                    
                 }
                 
                       }
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return cut;
    }
       Finance fin=new Finance();
       public int getmonthFinance(){
           int mont=0;
        try{
           
            Statement st=con.createStatement();
            String sql="Select * FROM studentFinance ";//where ID= '"+ID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                 mont=rs.getInt("month");
                 
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"getmonthFinance","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
       return mont;
       }
        public int getyearFinance(){
           int mont=0;
        try{
           
            Statement st=con.createStatement();
            String sql="Select * FROM studentFinance ";//where ID= '"+ID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                 mont=rs.getInt("year");
                 
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"getyearFinance","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
       return mont;
       }
        public void inputFinance(String name,String ID,String fees,String regFees,String StFees){
           int month=0;
        int year=0;
          if (fin.getday()>=25) {
         month=fin.getMonth()+1;
         year=fin.getYear();
        if (month==13) {
            month=1;
            year=year+1;
        }      
          }else{
         month=fin.getMonth();
         year=fin.getYear();
        
        }
         try{  
             String sql = "Insert into studentFinance(ID,StudentName,fees,registrationfee,stationaryfee,dues,month,year) values (?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
           
            pst.setString(1,ID);
            pst.setString(2,name);
            pst.setString(3, fees);
            pst.setString(4,regFees);
            pst.setString(5, StFees);
            pst.setDouble(6, fin.generateDues(ID));
            pst.setInt(7,month);
            pst.setInt(8,year);
            
            pst.execute();}
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
       
       }
       public void clickTable(JTable jTable1,JTextField id,JTextField name,JTextField reg,JTextField nary,JTextField anual,JTextField fee,JTextField dis,JTextField dues){
           try {
            int row= jTable1.getSelectedRow();
            String id_click= jTable1.getModel().getValueAt(row, 0).toString();
            String reg_click= jTable1.getModel().getValueAt(row, 2).toString();
            String nary_click= jTable1.getModel().getValueAt(row, 3).toString();
            String dis_click= jTable1.getModel().getValueAt(row, 4).toString();
            String dues_click= jTable1.getModel().getValueAt(row, 5).toString();
            String fees_click= jTable1.getModel().getValueAt(row, 1).toString();
            String studentName=getStudentName(id_click);
            String annualfee=String.valueOf(currentins01(Integer.parseInt(id_click)));
            id.setText(id_click);
            name.setText(studentName);
            reg.setText(reg_click);
            nary.setText(nary_click);
            dis.setText(dis_click);
            fee.setText(fees_click);
            dues.setText(dues_click);
            anual.setText(annualfee);
           } catch (Exception e) {
           }
            
       
       }
       public String getStudentName(String id){
           String stdName=null;
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student where IDnum ='"+id+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  
                   stdName=rs.getString("StudentName");
//                  insert(Idnum, stdName);
                   
                       }
        }catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error in Searching","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return stdName;
    }
}