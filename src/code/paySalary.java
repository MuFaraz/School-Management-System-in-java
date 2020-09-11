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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Faraz
 */
public class paySalary {
    Connection2DB connection=new Connection2DB();
        Connection con = connection.setConnection();
        ResultSet rs = null;
        ResultSet rs1=null;
        PreparedStatement pst = null;
        Finance finance=new Finance();
        PreparedStatement pst1 = null;
//private int lessdedduction=0;
    public paySalary() {
    }

//    public paySalary(int lessdedduction) {
//        this.lessdedduction = lessdedduction;
//    }
    
    public void InputA(String name,String designation,String attendance,String gross,String prev,String salaryEnch,String totalSalary,String lessSalary,String net,String retension,String absent,String lates,String halfdays,String advance,String totalreduction,String totalredudeposit,String leaves,String sno,String month,String year ){
          
//            String sql = "Insert into a(RegNo,Name,date,Classees,Section,fee,lateFees) values (?,?,?,?,?,?,?)";
          try {   
    String sql = "UPDATE paySalary SET name=?,designation=?,attendance=?,gross=?,prev=?,salaryEnch=?,totalsalary=?,lessSalary=?,net=?,retension=?,absent=?,lates=?,halfDays=?,advance=?,totalreduction=?,totalretiondeposit=?,leaves=?,Sno=?,month=?,year=? WHERE ID = '1'";
            pst = con.prepareStatement(sql);
//            pst.setInt(1,getId());
//            pst.setInt(2,getChallanNo());
            pst.setString(1,name);
            pst.setString(2,designation);
            pst.setString(3,attendance);
            pst.setString(4,gross);
            pst.setString(5,prev);
            pst.setString(6,salaryEnch);
            pst.setString(7, totalSalary);
            pst.setString(8, lessSalary);
            pst.setString(9, net);
            pst.setString(10, retension);
            pst.setString(11, absent);
            pst.setString(12, lates);
            pst.setString(13, halfdays);
            pst.setString(14, advance);
            pst.setString(15, totalreduction);
            pst.setString(16, totalredudeposit);
            pst.setString(17, leaves);
            pst.setString(18, sno);
            pst.setString(19, month);
            pst.setString(20, year);
               pst.executeUpdate();
              
          
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
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
   public int getnets(int id){
        Statement st;
         int net=0;
        try {
            st = con.createStatement();
            String sql = "SELECT NetSalary FROM TeacherSalary WHERE ID = '" +id+"'";  
            ResultSet ra = st.executeQuery(sql);
            while(ra.next()){
                 net=ra.getInt("NetSalary");
                 
            }          
        
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return net;
    }
   Staff staf=new Staff();
       public int gethalfdays(int id){
        Statement st;
        int half=0;
       
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID='" +id+ "'AND Month='" +staf.previousMonth()+ "'"+"AND Year = '"+staf.previousyear()+"'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                 half=rs.getInt("halfsdays");
//                 System.out.println(absent);
            }          
        
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return half;
    }
          public int getleavesdays(int id){
        Statement st;
        int leaves=0;
       
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM AbsentLate where ID='" +id+ "'AND Month='" +staf.previousMonth()+ "'"+"AND Year = '"+staf.previousyear()+"'";  
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                 leaves=rs.getInt("leaves");
//                 System.out.println(absent);
            }          
        
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
        }
            return leaves;
    }
    public void clicktable(JTable jTable1){ 
       
           ResultSet rs1=null;
           ResultSet rs=null;
           PreparedStatement pst;
           PreparedStatement pst1;
       try{ 
           Staff st=new Staff();
//Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String idclick= jTable1.getModel().getValueAt(row, 0).toString();
            String nameclick=jTable1.getModel().getValueAt(row, 1).toString();
            String month=jTable1.getModel().getValueAt(row, 6).toString();
            String year=jTable1.getModel().getValueAt(row, 7).toString();
//            int m=Integer.parseInt(month);
//            String mo="";
//           mo= st.getMonthString(m, mo);
           
//            String desi=jTable1.getModel().getValueAt(row, 2).toString();
           
           int attendance=st.getpresents(Integer.parseInt(idclick));
          String desi="";
           String sqll="SELECT Designation from Staff WHERE Sno = '"+idclick+"'";
           pst1=con.prepareStatement(sqll);
            rs1=  pst1.executeQuery();
            if (rs1.next()){
                 desi=rs1.getString("Designation");
                 
            }
           
           
            String sql= "select * from TeacherSalary where ID = '" + idclick + "'"+"AND month = '"+st.previousMonth()+"'"+"AND year = '"+st.previousyear()+"'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            int salaryEncash=0;
            int grossSalar=0;
            int prev=getTotalDUES(Integer.parseInt(idclick));
            int retdeducted=0;
            
            int absent=st.getAbsents(Integer.parseInt(idclick));
            int lates=st.getLates(Integer.parseInt(idclick));
          int half=gethalfdays(Integer.parseInt(idclick));
          int advance=st.getadvancesalary(Integer.parseInt(idclick));
          int totaldeduction=retdeducted+advance;
          int retendeposit=0;
          int leave=getleavesdays(Integer.parseInt(idclick));
            int net=0;
            int lessSalary=0;
            if (rs.next()){
                 grossSalar=rs.getInt("GrossSalary");
//                 net=rs.getInt("NetSalary");
                 retdeducted=rs.getInt("RetensionDeducted");
                 
            }
            prev=prev-grossSalar;
            int totalsalary=grossSalar+prev+salaryEncash;
            lessSalary=totaldeduction;
            net=totalsalary-lessSalary;
            InputA(nameclick, desi, String.valueOf(attendance), String.valueOf(grossSalar), String.valueOf(prev), String.valueOf(salaryEncash), String.valueOf(totalsalary), String.valueOf(lessSalary), String.valueOf(net), String.valueOf(retdeducted), String.valueOf(absent), String.valueOf(lates), String.valueOf(half), String.valueOf(advance), String.valueOf(totaldeduction), String.valueOf(retendeposit), String.valueOf(leave),idclick,month,year);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
     public void setpayroll(JLabel name,JLabel designation,JLabel attendance,JLabel gross,JLabel previus,JTextField enchashment,JLabel total,JLabel lesssa,JLabel netsalary,JLabel retension,JLabel absent,JLabel lates,JLabel half,JLabel advance,JLabel totalredu,JTextField lateRete,JLabel leaves,JLabel month,JLabel year)//,JLabel date,JLabel date1,JLabel date2,JLabel Month,JLabel Month1,JLabel Month2 )
      {
         Staff st=new Staff();
          try {   
    String sql = "SELECT * FROM paySalary where ID = '1'";//SET RegNo=?,Name=?,date=?,Classees=?,Section=?,fee=?,lateFees=? WHERE ID = '1'";
            pst = con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if (rs.next()){
                 String nam=rs.getString("name");
                 name.setText(nam);
                 String desi=rs.getString("designation");
                 String att=rs.getString("attendance");
                 String gro=rs.getString("gross");
                 String pre=rs.getString("prev");
                 int mon=rs.getInt("month");
                 String yea=rs.getString("year");
                 String m="";
                  m = st.getMonthString(mon, m);
//                  System.out.println("s"+m);
                 month.setText(m);
                year.setText(yea);
                 designation.setText(desi);
                  attendance.setText(att);
                  gross.setText(gro);
                  previus.setText(pre);
        String sal=rs.getString("salaryEnch");
                enchashment.setText(sal);
//               regNos=regNo;
       String         totalsal=rs.getString("totalsalary");
//                Names=Name;
//                System.out.println(Names);
               total.setText (totalsal);
               String les=rs.getString("lessSalary");
                  
             String   ne=rs.getString("net");
//               Classeeeees=Class;
//               Section=sec;
                lesssa.setText(les);
                netsalary.setText(ne);
               String ret=rs.getString("retension");
                  
             String   abs=rs.getString("absent");
//               Classeeeees=Class;
//               Section=sec;
                retension.setText(ret);
                absent.setText(abs);
               String lat=rs.getString("lates");
                  
             String   halfda=rs.getString("halfDays");
               String advan=rs.getString("advance");
                  advance.setText(advan);
             String   totalre=rs.getString("totalreduction");
               String depo=rs.getString("totalretiondeposit");
                  
             String   lea=rs.getString("leaves");
//               Classeeeees=Class;
//               Section=sec;
               lates.setText(lat);
                half.setText(halfda);
                totalredu.setText(totalre);
                lateRete.setText(depo);
                leaves.setText(lea);
              
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
