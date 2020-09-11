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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Muhammad Faraz
 */
public class StudentFeesChallan {
//    public String regNos;
//    public String date;
//    public String Names;
//    public String Classeeeees;
//    public String Section;
//    public String fee;
    public int lateFees=300;
// public JTable jTable1;
    public StudentFeesChallan() {
//        clickTable(jTable1, fee, regNos, Names, date, fee);
    }
//    public StudentFeesChallan(String Names){
//        this.Names=Names;
//    }
  Connection2DB connection=new Connection2DB();
        Connection con = connection.setConnection();
        ResultSet rs = null;
        ResultSet rs1=null;
        PreparedStatement pst = null;
        Finance finance=new Finance();
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        
        ResultSet rs2=null;
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        Staff st2=new Staff();
        ////////////////////////////////////////---------------------------------------------------------------------------/////////////
//        public void StudentRecordFees(JTable table){
//        try{
//             DefaultTableModel model = (DefaultTableModel) table.getModel();
//   
//            Statement st=con.createStatement();
//            String sql="select * from AbsentLate WHERE month = '"+st2.getMonth()+"'"+"AND year = '"+st2.getYear()+"'";
//            ResultSet rs=st.executeQuery(sql);
//            while(rs.next()){  
//                int id=rs.getInt("ID");
//                String name=rs.getString("Name");
//                String present=rs.getString("Present");
//                String late=rs.getString("Late");
//                String Absent=rs.getString("Absent");
//                int month=rs.getInt("Month");
//                String year=rs.getString("Year");
//                Vector row = new Vector();
////                Fees fee=new Fees();
//               String mon= getMonthString(month);
//                row.add(id);
//                row.add(name);
//                row.add(present);
//                row.add(late);
//                row.add(Absent);
//                row.add(mon);
//                row.add(year);
//                model.addRow(row);
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//      }
//      }
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public void StudentRecordfees(JTable tab)
   {
       
       try{
           String sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
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
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update due","Record", JOptionPane.ERROR_MESSAGE);
           }
//        JOptionPane.showMessageDialog(null, year1+month+"10");
        return d+"/"+month+"/"+year1;
       }
//-----------------------------------------------------------------------------------------------------------------------------------------
//    public void clickTable(JTable jTable1,String fees,String fees1,String fees2,String regNo,String regNo1,String regNo2,String Name,String Name1,String Name2,String Month,String Month2,String Month3,String Class,String Class1,String Class2,String date,String date1,String date2 ){
     Student s=new Student();
        public void clickTable(JTable jTable1){
       try{ 
           String due=dueDateUthao(jTable1);
//            JOptionPane.showMessageDialog(null, due);
           
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            
               
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String month= jTable1.getModel().getValueAt(row, 4).toString();
          
            String year= jTable1.getModel().getValueAt(row, 5).toString();
          
            String sql= "select * from Student where IDnum = '" + table_click + "'";
            
            String sql1= "select * from studentFinance where ID = '" + table_click + "'";
            String sql33="select * from tasktable where ID = '"+table_click+"'";
            pst2=con.prepareStatement(sql33);
            rs2=pst2.executeQuery();
            String task1="";
            String task2="";
            String task3="";
            if (rs2.next()){
                task1=rs2.getString("taskOne");
                task2=rs2.getString("taskTwo");
                task3=rs2.getString("taskThree");
            }
            double cut1=s.currentins01(Integer.parseInt(table_click));
            double cut2=s.currentins02(Integer.parseInt(table_click));
            double cut3=s.currentins03(Integer.parseInt(table_click));
            pst=con.prepareStatement(sql);
            pst1=con.prepareStatement(sql1);
            //pst1=con.prepareStatement(sql1);
            rs1=pst1.executeQuery();
            rs=  pst.executeQuery();
            double totall=0;
               double totalLat=0;
               double regFee=0;
            double st=0;
            
            try{
            if (rs1.next()){
//                month=rs.getInt("month");
//                year=rs.getInt("year");
             regFee=rs1.getDouble("registrationfee");
             st=rs1.getDouble("stationaryfee");
            
        totall=regFee+st+cut1+cut2+cut3;
        totalLat=regFee+st+300+cut1+cut2+cut3;
            }}catch(Exception e){
//                System.out.println("eeeeeeeee");
            }
//JOptionPane.showMessageDialog(null, year);
            if(rs.next()){
        double fees=rs.getDouble("fees");
          totall=totall+fees;
          totalLat=totalLat+fees;
        String regNo=rs.getString("IDnum");
       String Name=rs.getString("StudentName");
       String sec=rs.getString("Section");
                  
             String   Class=rs.getString("Grade");
                  InputA(regNo, Name, Class, sec,fees,totalLat,regFee,st,String.valueOf(totall),task1,task2,task3,cut1,cut2,cut3,due,month,year);
                            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR","CHALLAN",JOptionPane.ERROR_MESSAGE);
        }
    }
      public void InputA(String regNo,String Name,String Classes,String Section,double Fees,double Late,double reg,double sta,String total,String task1,String task2,String task3,double cutt1,double cutt2,double cutt3,String due,String month,String year){
          
  try {
      
    String sql = "UPDATE challan SET RegNo=?,Name=?,date=?,Classees=?,Section=?,fee=?,lateFees=?,regFees=?,StatFees=?,total=?,taskOne=?,taskTwo=?,taskThree=?,cut1=?,cut2=?,cut3=?,duedate=?,month=?,year=? WHERE ID = '1'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,regNo);
            pst.setString(2,Name);
            pst.setString(3,"");
            pst.setString(4,Classes);
            pst.setString(5,Section);
           if (String.valueOf(Fees).equals("0")){
                
                pst.setString(6, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            
    pst.setDouble(6,Fees);}
            pst.setDouble(7, Late);
            if (String.valueOf(reg).equals("0")){
                
                pst.setString(8, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            
            pst.setDouble(8, reg);
  }
          if (String.valueOf(sta).equals("0")){
                
                pst.setString(9, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            
            pst.setDouble(9, sta);
  }
            pst.setString(10, total);
            pst.setString(11, task1);
            pst.setString(12, task2);
            pst.setString(13, task3);
            if (String.valueOf(cutt1).equals("0.0")){
                
                pst.setString(14, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(14, cutt1);
  }
              if (String.valueOf(cutt2).equals("0.0")){
                
                pst.setString(15, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(15, cutt2);}
                if (String.valueOf(cutt3).equals("0.0")){
                
                pst.setString(16, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(16, cutt3);}
                pst.setString(17, due);
                pst.setString(18,month);
                pst.setString(19, year);
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update 1","Record", JOptionPane.ERROR_MESSAGE);
          }  
      }
      
      public void setChallan(JLabel month,JLabel month2,JLabel month3,JLabel name,JLabel name1,JLabel name2,JLabel regNo,JLabel regNo1,JLabel regNo2,JLabel classes,JLabel classes1,JLabel classes2,JTextField fees,JLabel fees1,JLabel fees2,JTextField regFees,JLabel jLabel20,JLabel jLabel19,JLabel jLabel23,JTextField jLabel22,JLabel jLabel24,JLabel total,JLabel total1,JLabel total2,JLabel jLabel53,JLabel jLabel52,JLabel jLabel54,JTextField jLabel36,JLabel jLabel39,JLabel jLabel32,JLabel jLabel41,JLabel jLabel43,JTextField jLabel38,JLabel jLabel31,JLabel jLabel35,JLabel jLabel33,JLabel jLabel40,JLabel jLabel42,JLabel jLabel37,JLabel jLabel51,JLabel jLabel50,JLabel jLabel49 )
      {
           Staff stf=new Staff();
             
          try {   
    String sql = "SELECT * FROM challan where ID = '1'";//SET RegNo=?,Name=?,date=?,Classees=?,Section=?,fee=?,lateFees=? WHERE ID = '1'";
            pst = con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if (rs.next()){
                 String fee=rs.getString("fee");
                 fees.setText(fee);
                 fees1.setText(fee);
                 fees2.setText(fee);
                 String regFeees=rs.getString("regFees");
                 String due=rs.getString("duedate");
                 String sta=rs.getString("StatFees");
                 String late=rs.getString("lateFees");
                 String totalss=rs.getString("total");
                 String cut1=rs.getString("cut1");
                 String cut2=rs.getString("cut2");
                 String cut3=rs.getString("cut3");
                 String taskone = rs.getString("taskOne");
                  String tasktwo=rs.getString("taskTwo");
                  String taskthree=rs.getString("taskThree");
                  int mo=rs.getInt("month");
                  String ye=rs.getString("year");
                  String m=stf.getMonthString(mo);
                  month.setText(m+" "+ye);
                  month2.setText(m+" "+ye);
                  month3.setText(m+" "+ye);
                  jLabel49.setText(due);jLabel50.setText(due);jLabel51.setText(due);
                  jLabel31.setText(taskone);jLabel35.setText(taskone);jLabel33.setText(taskone);
              jLabel40.setText(tasktwo);jLabel42.setText(tasktwo);jLabel37.setText(tasktwo);
//               jLabel44.setText(taskthree);jLabel45.setText(taskthree);jLabel47.setText(taskthree);
       jLabel32.setText(String.valueOf(cut1));
            jLabel36.setText(String.valueOf(cut1));
            jLabel39.setText(String.valueOf(cut1));
            jLabel41.setText(String.valueOf(cut2));
            jLabel43.setText(String.valueOf(cut2));
            jLabel38.setText(String.valueOf(cut2));
//            jLabel46.setText(String.valueOf(cut3));
//            jLabel55.setText(String.valueOf(cut3));
//            jLabel48.setText(String.valueOf(cut3));
                 jLabel20.setText(regFeees);
                  jLabel19.setText(regFeees);
                  regFees.setText(regFeees);
                  jLabel22.setText(sta);
                  jLabel23.setText(sta);
                  jLabel24.setText(sta);
                  jLabel53.setText(late);
                  jLabel52.setText(late);
                  jLabel54.setText(late);
                  total.setText(totalss);
                  total1.setText(totalss);
                  total2.setText(totalss);
//                  jLabel19.setText(regFeees);
                    
                 
//         fees1=fees;
//         fees2=fees;
//         fees
//            fee=fees;
            
//                fees.setText(fee);
//                fees1.setText(fee);
//                fees2.setText(fee);
                
        String ID=rs.getString("RegNo");
                regNo.setText(ID);
                regNo1.setText(ID);
                regNo2.setText(ID);
//               regNos=regNo;
       String         Names=rs.getString("Name");
//                Names=Name;
//                System.out.println(Names);
               name.setText (Names);
               name1.setText(Names);
               
               name2.setText(Names);
            
//            String  Gname=rs.getString("FatherName");
//                gnametf1.setText(Gname);
//              String  CellNumone=rs.getString("CellNumone");
//                contact1.setText(CellNumone);
//               String Contact=rs.getString("CellNumtwo");
//                contact2.setText(Contact);
//               String contac3=rs.getString("CellNumthree");
//                contact3.setText(contac3);
                 String sec=rs.getString("Section");
                  
             String   Class=rs.getString("Classees");
//               Classeeeees=Class;
//               Section=sec;
                classes.setText(Class+"  "+sec);
                classes1.setText(Class+"  "+sec);
                classes2.setText(Class+"  "+sec);
              
//                sec.setText(Section1);
//              String  Fees=rs.getString("fees");
//              Staff stf=new Staff();
//                date.setText(stf.getDate()+"/"+stf.getMonth()+"/"+stf.getYear());
//                date1.setText(stf.getDate()+"/"+stf.getMonth()+"/"+stf.getYear());
//                date2.setText(stf.getDate()+"/"+stf.getMonth()+"/"+stf.getYear());
//                int mon=stf.getMonth();
//                Fees fe=new Fees();
//                
//                String m=fe.getMonthString(mon);
//                Month.setText(m);
//                Month1.setText(m);
//                Month2.setText(m);
            } 
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
//              pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          }  
      }
      public void StudentFeesConditionAll(JTable table,String id,String name,String month,String year){
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'"+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public boolean searchstudentfeesAll(String id,String name,String month,String year){
        boolean found =false;          
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'"+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'"+" AND  month = '"+month+"'";//+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'"+" AND  month = '"+month+"'";//+" AND  year = '"+year+"'";
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'"+" AND  year = '"+year+"'";
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'"+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'"+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE StudentName = '"+name+"'"+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE StudentName = '"+name+"'"+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'";//+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'"+" AND StudentName = '"+name+"'";//+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'"+" AND  month = '"+month+"'";//+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'"+" AND  month = '"+month+"'";//+" AND  year = '"+year+"'";
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'"+" AND  year = '"+year+"'";
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  StudentName = '"+name+"'"+" AND  month = '"+month+"'";//+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE StudentName = '"+name+"'"+" AND  month = '"+month+"'";//+" AND  year = '"+year+"'";
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  StudentName = '"+name+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE StudentName = '"+name+"'"+" AND  year = '"+year+"'";
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE month = '"+month+"'"+" AND  year = '"+year+"'";
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
          public void StudentFeesConditionpay(JTable table,String pay){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"; 
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");
      }
      }
     public void StudentFeesConditionidpay(JTable table,String id,String pay){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
     public void StudentFeesConditionpaymonth(JTable table,String pay,String month){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND month = '"+month+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND month = '"+month+"'"; 
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
      public void StudentFeesConditionpayyear(JTable table,String pay,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND year = '"+year+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND year = '"+year+"'"; 
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
      public void StudentFeesConditionidpayyear(JTable table,String id,String pay,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND year = '"+year+"'"+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public void StudentFeesConditionidpaymonth(JTable table,String id,String pay,String month){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND moth = '"+month+"'"+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND month = '"+month+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public void StudentFeesConditionpaymonthyear(JTable table,String pay,String month,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public void StudentFeesConditionidpaymonthyear(JTable table,String id,String pay,String month,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND month = '"+month+"'"+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public void StudentFeesConditionpayname(JTable table,String name,String pay){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND StudentName = '"+name+"'";///+"AND year = '"+year+"'"+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND StudentName = '"+name+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
       public void StudentFeesConditionidpayname(JTable table,String id,String name,String pay){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND ID = '"+id+"'";//+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND ID = '"+id+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
        public void StudentFeesConditionpaynamemonth(JTable table,String name,String pay,String month){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND month = '"+month+"'";//+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
          public void StudentFeesConditionidpaynamemonth(JTable table,String id,String name,String pay,String month){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND month = '"+month+"'"+"AND ID = '"+id+"'";//+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND month = '"+month+"'"+"AND ID = '"+id+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
          public void StudentFeesConditionidpaynameyear(JTable table,String id,String name,String pay,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'"+"AND ID = '"+id+"'";//+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'"+"AND ID = '"+id+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
             public void StudentFeesConditionpaynamemonthyear(JTable table,String name,String pay,String month,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'"+"AND month = '"+month+"'";//+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
             public void StudentFeesConditionidpaynamemonthyear(JTable table,String id,String name,String pay,String month,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND ID = '"+id+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'"+"AND month = '"+month+"'";//+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND ID = '"+id+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'"+"AND month = '"+month+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
         public void StudentFeesConditionpaynameyear(JTable table,String name,String pay,String year){
    try{
            String sql="";
           if (pay!="0.0"){
               pay="1";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance  WHERE dues >= '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'";//+"AND ID = '"+id+"'"; 
           
           }
           else {
               pay="0.0";
                sql ="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE dues = '"+pay+"'"+"AND StudentName = '"+name+"'"+"AND year = '"+year+"'";//+"AND year = '"+year+"'"+"AND ID = '"+id+"'";
           
           }
//           sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],month as [MONTH],year as [YEAR]  from studentFinance WHERE  month = '"+month+"'"+" AND  year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
    
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
      }
      }
          public void StudentFeesConditionid(JTable table,String id){
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE ID = '"+id+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE ID = '"+id+"'";//+" AND StudentName = '"+name+"'"+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE StudentName = '"+name+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE StudentName = '"+name+"'";//+" AND  month = '"+month+"'"+" AND  year = '"+year+"'";
            rs = st.executeQuery(sql);
              while(rs.next()){
//                  String Idnum = rs.getString("ID");
                  String stdName=rs.getString("StudentName");
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE month = '"+month+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE month = '"+month+"'";//+" AND  year = '"+year+"'";
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
          String sql="select ID as [ID], StudentName as [STUDENT'S NAME],fees as [FEES],dues as [DUES],month as [MONTH],year as [YEAR]  from studentFinance WHERE year = '"+year+"'";//+" AND Name = '"+name+"'"+" AND  Month = '"+month+"'"+" AND  Year = '"+year+"'";//+"AND month = '"+getMonth()+"'"+"AND year = '"+getYear()+"'";
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
            String sql = "SELECT * from studentFinance WHERE year = '"+year+"'";
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
          public void clik(JTable jTable1,JTextField id,JTextField name,JTextField status){
                 try {
                      int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            
    String sql= "select * from studentFinance where ID = '" + table_click + "'";
            
           pst=con.prepareStatement(sql);
          rs=pst.executeQuery();
                  if (rs.next()){
                
                 String ID=rs.getString("ID");
                 id.setText(ID);
                 String Names=rs.getString("StudentName");
                 name.setText (Names);
                      if (finance.payStatus(Integer.parseInt(ID))) {
                          status.setText("PAID");
                      }else
                          status.setText("UNPAID");
            } 
//            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
          }
             }     
}
