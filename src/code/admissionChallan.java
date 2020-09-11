/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Muhammad Faraz
 */
public class admissionChallan {

    public admissionChallan() {
    }
    
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
        Finance fin=new Finance();
        Staff st2=new Staff();
        public String dueDateUthao(){
//            int row= jTable1.getSelectedRow();
//            String month= jTable1.getModel().getValueAt(row, 4).toString();
            Statement st=null;
            ResultSet rs11=null;
//           String year1=jTable1.getModel().getValueAt(row, 5).toString();

           String day="";
           int d=0;
            int month=0;
        int year=0;
        try {
           
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
//          JOptionPane.showMessageDialog(null, year+" "+month);
            st = con.createStatement();
            String sql = "SELECT day FROM DueDate ";  
            rs11 = st.executeQuery(sql);
            while(rs11.next()){
                  d  =rs11.getInt("day");
//                  System.out.println(month1);
                       }
            if (d<=9) {
               day="0"+String.valueOf(d);
           }
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update due","Record", JOptionPane.ERROR_MESSAGE);
           }
//        JOptionPane.showMessageDialog(null, year1+month+"10");
        return d+"/"+month+"/"+year;
       }
        public void c(JTable table){
            try{ ResultSet fadi=null;
           PreparedStatement ppp=null;
            int row= table.getSelectedRow();
            String table_click= table.getModel().getValueAt(row, 0).toString();
            String mm="";
            String yy="";
            try{
            String ssS="select * from Student where IDnum = '"+table_click+"'";
            PreparedStatement ll=null;
            ll=con.prepareStatement(ssS);
            
            ResultSet resultset=null;
            resultset = ll.executeQuery();
            
            if (resultset.next()){
              mm  =rs.getString("month");
              yy=rs.getString("year");
            }}catch(Exception e){
                System.out.println(" ");
            }
//                System.out.println("hogya");
//           String table_click="";
          
//            JOptionPane.showMessageDialog(null, table_click);
           String due=dueDateUthao();
          
//            JOptionPane.showMessageDialog(null, due);
           
//Connection con=connection.setConnection();
//            int row= jTable1.getSelectedRow();
//            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
           
            
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
            pst1=con.prepareStatement(sql1);
            //pst1=con.prepareStatement(sql1);
            rs1=pst1.executeQuery();
            double totall=0;
               double totalLat=0;
               double regFee=0;
            double st=0;
            
                    
            try{
            if (rs1.next()){
             regFee=rs1.getDouble("registrationfee");
             st=rs1.getDouble("stationaryfee");
            
        totall=regFee+st+cut1+cut2+cut3;
        totalLat=regFee+st+300+cut1+cut2+cut3;
            }}catch(Exception e){
//                System.out.println("eeeeeeeee");
            }
            String sql="Select * from Student where IDnum = '"+table_click+"'";
pst=con.prepareStatement(sql);
           rs=  pst.executeQuery();
             
            if(rs.next()){
        double fees=rs.getDouble("fees");
          totall=totall+fees;
          totalLat=totalLat+fees;
        String regNo=rs.getString("IDnum");
       String Name=rs.getString("StudentName");
       String sec=rs.getString("Section");
                  
             String   Class=rs.getString("Grade");
//             JOptionPane.showMessageDialog(null, regNo);
//             JOptionPane.showMessageDialog(null, Name);
//             JOptionPane.showMessageDialog(null, sec);
//             JOptionPane.showMessageDialog(null, Class);
                  InputB(regNo, Name, Class, sec,fees,totalLat,regFee,String.valueOf(totall),task1,task2,task3,cut1,cut2,cut3,due,st,mm,yy);
                            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR","CHALLAN",JOptionPane.ERROR_MESSAGE);
        }
        }
        public void InputB(String regNo,String Name,String Classes,String Section,double Fees,double Late,double reg,String total,String task1,String task2,String task3,double cutt1,double cutt2,double cutt3,String due,double st,String month,String year){
          
  try {
      
    String sql = "UPDATE AdmissionChallan SET RegNo=?,Name=?,date=?,Classees=?,Section=?,fee=?,lateFees=?,regFees=?,total=?,taskOne=?,taskTwo=?,taskThree=?,cut1=?,cut2=?,cut3=?,duedate=?,stFees=?,month=?,year=? WHERE ID = '1'";
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
          
            pst.setString(9, total);
            pst.setString(10, task1);
            pst.setString(11, task2);
            pst.setString(12, task3);
            if (String.valueOf(cutt1).equals("0.0")){
                
                pst.setString(13, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(13, cutt1);
  }
              if (String.valueOf(cutt2).equals("0.0")){
                
                pst.setString(14, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(14, cutt2);}
                if (String.valueOf(cutt3).equals("0")){
                
                pst.setString(15, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(15, cutt3);}
                pst.setString(16, due);
                if (String.valueOf(st).equals("0")){
                
                pst.setString(17, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(17, st);}
          pst.setString(18,month);
          pst.setString(19, year);
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update 1","Record", JOptionPane.ERROR_MESSAGE);
          }  
      }
        Student s=new Student();
        public void clickTable(){
       try{ ResultSet fadi=null;
           PreparedStatement ppp=null;
           String table_click="";
            String sqlpti= "select * from Student ";
            ppp=con.prepareStatement(sqlpti);
            fadi=ppp.executeQuery();
            while(fadi.next()){
                table_click=fadi.getString("IDnum");
            }
//            JOptionPane.showMessageDialog(null, table_click);
           String due=dueDateUthao();
          
//            JOptionPane.showMessageDialog(null, due);
           
//Connection con=connection.setConnection();
//            int row= jTable1.getSelectedRow();
//            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
           
            
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
            pst1=con.prepareStatement(sql1);
            //pst1=con.prepareStatement(sql1);
            rs1=pst1.executeQuery();
            double totall=0;
               double totalLat=0;
               double regFee=0;
            double st=0;
            
                    
            try{
            if (rs1.next()){
             regFee=rs1.getDouble("registrationfee");
             st=rs1.getDouble("stationaryfee");
            
        totall=regFee+st+cut1+cut2+cut3;
        totalLat=regFee+st+300+cut1+cut2+cut3;
            }}catch(Exception e){
//                System.out.println("eeeeeeeee");
            }
            String sql="Select * from Student where IDnum = '"+table_click+"'";
pst=con.prepareStatement(sql);
           rs=  pst.executeQuery();
             
            if(rs.next()){
        double fees=rs.getDouble("fees");
          totall=totall+fees;
          totalLat=totalLat+fees;
        String regNo=rs.getString("IDnum");
       String Name=rs.getString("StudentName");
       String sec=rs.getString("Section");
                  
             String   Class=rs.getString("Grade");
//             JOptionPane.showMessageDialog(null, regNo);
//             JOptionPane.showMessageDialog(null, Name);
//             JOptionPane.showMessageDialog(null, sec);
//             JOptionPane.showMessageDialog(null, Class);
                  InputA(regNo, Name, Class, sec,fees,totalLat,regFee,String.valueOf(totall),task1,task2,task3,cut1,cut2,cut3,due,st);
                            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR","CHALLAN",JOptionPane.ERROR_MESSAGE);
        }
    }
        public void InputA(String regNo,String Name,String Classes,String Section,double Fees,double Late,double reg,String total,String task1,String task2,String task3,double cutt1,double cutt2,double cutt3,String due,double st){
          
  try {
      
    String sql = "UPDATE AdmissionChallan SET RegNo=?,Name=?,date=?,Classees=?,Section=?,fee=?,lateFees=?,regFees=?,total=?,taskOne=?,taskTwo=?,taskThree=?,cut1=?,cut2=?,cut3=?,duedate=?,stFees=? WHERE ID = '1'";
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
          
            pst.setString(9, total);
            pst.setString(10, task1);
            pst.setString(11, task2);
            pst.setString(12, task3);
            if (String.valueOf(cutt1).equals("0.0")){
                
                pst.setString(13, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(13, cutt1);
  }
              if (String.valueOf(cutt2).equals("0.0")){
                
                pst.setString(14, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(14, cutt2);}
                if (String.valueOf(cutt3).equals("0")){
                
                pst.setString(15, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(15, cutt3);}
                pst.setString(16, due);
                if (String.valueOf(st).equals("0")){
                
                pst.setString(17, "");
//                JOptionPane.showMessageDialog(null, "ddd");
            }
            else{
            pst.setDouble(17, st);}
          
               pst.executeUpdate();
               
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update 1","Record", JOptionPane.ERROR_MESSAGE);
          }  
      }
        public void setChallan(JLabel name,JLabel name1,JLabel name2,JLabel regNo,JLabel regNo1,JLabel regNo2,JLabel classes,JLabel classes1,JLabel classes2,JLabel fees,JLabel fees1,JLabel fees2,JLabel regFees,JLabel jLabel20,JLabel jLabel19,JLabel total,JLabel total1,JLabel total2,JLabel jLabel53,JLabel jLabel52,JLabel jLabel54,JLabel jLabel36,JLabel jLabel39,JLabel jLabel32,JLabel jLabel41,JLabel jLabel43,JLabel jLabel38,JLabel jLabel46,JLabel jLabel55,JLabel jLabel48,JLabel jLabel31,JLabel jLabel35,JLabel jLabel33,JLabel jLabel40,JLabel jLabel42,JLabel jLabel37,JLabel jLabel44,JLabel jLabel45,JLabel jLabel47,JLabel jLabel51,JLabel jLabel50,JLabel jLabel49 )
//     public void setChallan(JLabel name,JLabel name1,JLabel name2,JLabel regNo,JLabel regNo1,JLabel regNo2,JLabel classes,JLabel classes1,JLabel classes2,JLabel fees,JLabel fees1,JLabel fees2,JLabel regFees,JLabel jLabel20,JLabel jLabel19,JLabel total,JLabel total1,JLabel total2,JLabel jLabel53,JLabel jLabel52,JLabel jLabel54,JLabel jLabel36,JLabel jLabel39,JLabel jLabel32,JLabel jLabel41,JLabel jLabel43,JLabel jLabel38,JLabel jLabel46,JLabel jLabel55,JLabel jLabel48,JLabel jLabel31,JLabel jLabel35,JLabel jLabel33,JLabel jLabel40,JLabel jLabel42,JLabel jLabel37,JLabel jLabel44,JLabel jLabel45,JLabel jLabel47,JLabel jLabel51,JLabel jLabel50,JLabel jLabel49 )
      {
          try {   
    String sql = "SELECT * FROM AdmissionChallan where ID = '1'";//SET RegNo=?,Name=?,date=?,Classees=?,Section=?,fee=?,lateFees=? WHERE ID = '1'";
            pst = con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if (rs.next()){
                 String fee=rs.getString("fee");
                 fees.setText(fee);
                 fees1.setText(fee);
                 fees2.setText(fee);
                 String regFeees=rs.getString("regFees");
                 String due=rs.getString("duedate");
//                 String sta=rs.getString("StatFees");
                 String late=rs.getString("lateFees");
                 String totalss=rs.getString("total");
                 String cut1=rs.getString("cut1");
                 String cut2=rs.getString("cut2");
                 String cut3=rs.getString("stFees");
                 String taskone = rs.getString("taskOne");
                  String tasktwo=rs.getString("taskTwo");
//                  String taskthree=rs.getString("taskThree");
                  jLabel49.setText(due);jLabel50.setText(due);jLabel51.setText(due);
                  jLabel31.setText(taskone);jLabel35.setText(taskone);jLabel33.setText(taskone);
              jLabel40.setText(tasktwo);jLabel42.setText(tasktwo);jLabel37.setText(tasktwo);
              if (cut3.equals("")){
              jLabel44.setText("");jLabel45.setText("");jLabel47.setText("");
              }
                  else {
               jLabel44.setText("Stationary Fees");jLabel45.setText("Stationary Fees");jLabel47.setText("Stationary Fees");}
       jLabel32.setText(String.valueOf(cut1));
            jLabel36.setText(String.valueOf(cut1));
            jLabel39.setText(String.valueOf(cut1));
            jLabel41.setText(String.valueOf(cut2));
            jLabel43.setText(String.valueOf(cut2));
            jLabel38.setText(String.valueOf(cut2));
            jLabel46.setText(String.valueOf(cut3));
            jLabel55.setText(String.valueOf(cut3));
            jLabel48.setText(String.valueOf(cut3));
                 jLabel20.setText(regFeees);
                  jLabel19.setText(regFeees);
                  regFees.setText(regFeees);
//                  jLabel22.setText(sta);
//                  jLabel23.setText(sta);
//                  jLabel24.setText(sta);
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
        public void setChallan2(JLabel name,JLabel name1,JLabel name2,JLabel regNo,JLabel regNo1,JLabel regNo2,JLabel classes,JLabel classes1,JLabel classes2,JLabel fees,JLabel fees1,JLabel fees2,JLabel regFees,JLabel jLabel20,JLabel jLabel19,JLabel total,JLabel total1,JLabel total2,JLabel jLabel53,JLabel jLabel52,JLabel jLabel54,JLabel jLabel36,JLabel jLabel39,JLabel jLabel32,JLabel jLabel41,JLabel jLabel43,JLabel jLabel38,JLabel jLabel46,JLabel jLabel55,JLabel jLabel48,JLabel jLabel31,JLabel jLabel35,JLabel jLabel33,JLabel jLabel40,JLabel jLabel42,JLabel jLabel37,JLabel jLabel44,JLabel jLabel45,JLabel jLabel47,JLabel jLabel51,JLabel jLabel50,JLabel jLabel49,JLabel month,JLabel month1,JLabel month2,JLabel Date,JLabel date1,JLabel date2 )
//     public void setChallan(JLabel name,JLabel name1,JLabel name2,JLabel regNo,JLabel regNo1,JLabel regNo2,JLabel classes,JLabel classes1,JLabel classes2,JLabel fees,JLabel fees1,JLabel fees2,JLabel regFees,JLabel jLabel20,JLabel jLabel19,JLabel total,JLabel total1,JLabel total2,JLabel jLabel53,JLabel jLabel52,JLabel jLabel54,JLabel jLabel36,JLabel jLabel39,JLabel jLabel32,JLabel jLabel41,JLabel jLabel43,JLabel jLabel38,JLabel jLabel46,JLabel jLabel55,JLabel jLabel48,JLabel jLabel31,JLabel jLabel35,JLabel jLabel33,JLabel jLabel40,JLabel jLabel42,JLabel jLabel37,JLabel jLabel44,JLabel jLabel45,JLabel jLabel47,JLabel jLabel51,JLabel jLabel50,JLabel jLabel49 )
      {
          try {   
    String sql = "SELECT * FROM AdmissionChallan where ID = '1'";//SET RegNo=?,Name=?,date=?,Classees=?,Section=?,fee=?,lateFees=? WHERE ID = '1'";
            pst = con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if (rs.next()){
                 String fee=rs.getString("fee");
                 fees.setText(fee);
                 fees1.setText(fee);
                 fees2.setText(fee);
                 Staff stf=new Staff();
        Date.setText(stf.getDate()+"/"+stf.getMonth()+"/"+stf.getYear());
                date1.setText(stf.getDate()+"/"+stf.getMonth()+"/"+stf.getYear());
                date2.setText(stf.getDate()+"/"+stf.getMonth()+"/"+stf.getYear());
                String mon=rs.getString("month");
                String ye=rs.getString("year");
//                 String m=stf.getMonthString(mon);
                month.setText(mon+" "+ye);
                month2.setText(mon+" "+ye);
                month1.setText(mon+" "+ye);
                 String regFeees=rs.getString("regFees");
                 String due=rs.getString("duedate");
//                 String sta=rs.getString("StatFees");
                 String late=rs.getString("lateFees");
                 String totalss=rs.getString("total");
                 String cut1=rs.getString("cut1");
                 String cut2=rs.getString("cut2");
                 String cut3=rs.getString("stFees");
                 String taskone = rs.getString("taskOne");
                  String tasktwo=rs.getString("taskTwo");
//                  String taskthree=rs.getString("taskThree");
                  jLabel49.setText(due);jLabel50.setText(due);jLabel51.setText(due);
                  jLabel31.setText(taskone);jLabel35.setText(taskone);jLabel33.setText(taskone);
              jLabel40.setText(tasktwo);jLabel42.setText(tasktwo);jLabel37.setText(tasktwo);
              if (cut3.equals("")){
              jLabel44.setText("");jLabel45.setText("");jLabel47.setText("");
              }
                  else {
               jLabel44.setText("Stationary Fees");jLabel45.setText("Stationary Fees");jLabel47.setText("Stationary Fees");}
       jLabel32.setText(String.valueOf(cut1));
            jLabel36.setText(String.valueOf(cut1));
            jLabel39.setText(String.valueOf(cut1));
            jLabel41.setText(String.valueOf(cut2));
            jLabel43.setText(String.valueOf(cut2));
            jLabel38.setText(String.valueOf(cut2));
            jLabel46.setText(String.valueOf(cut3));
            jLabel55.setText(String.valueOf(cut3));
            jLabel48.setText(String.valueOf(cut3));
                 jLabel20.setText(regFeees);
                  jLabel19.setText(regFeees);
                  regFees.setText(regFeees);
//                  jLabel22.setText(sta);
//                  jLabel23.setText(sta);
//                  jLabel24.setText(sta);
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
}
