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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Muhammad Faraz
 */
public class classes {
   private String classNo;
   private String section;

    public classes() {
    }
   
    
    public classes(String classNo, String section) {
        this.classNo = classNo;
        this.section = section;
    } 

    public String getClassNo() {
        return classNo;
    }

    public String getSection() {
        return section;
    }
    Connection2DB connection=new Connection2DB();
        Connection con = connection.setConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;
     public void addClass() {
        
        try {
//            link.addStudentfromLinkList(studentName, rollNumber, IDnumber, dateOfb, fatherName, fatherNIC, phoneNo, address, addmissionDate, CName, fees,Csection);
            String sql = "Insert into Classes(ClassName,Section) values (?,?)";
            pst = con.prepareStatement(sql);
           
            pst.setString(1,getClassNo());
            pst.setString(2, getSection());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Successfully Saved ","Classes Record",JOptionPane.INFORMATION_MESSAGE);
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
         }
    }
     public void deleteClasses(String ClasseName,String Section)
    {
        
        try{
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)   
            {    
//                link.DeleteStudent(Integer.parseInt(IDNum));
                String sql="Delete From Classes where ClassName = ? AND Section =?";
                pst =con.prepareStatement(sql);
                pst.setString(1, ClasseName);
                
                pst.setString(2, Section);
                pst.execute();
            }
            JOptionPane.showMessageDialog(null, "Succesfully Deleted","Records",JOptionPane.INFORMATION_MESSAGE);
    }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
        }
    }
     public boolean searchClasses(String Classes){
        boolean found =false;          
        try {
//            link.searchStudent(Integer.parseInt(rollNum));
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Classes where ClassName ='"+Classes+"'";   
            rs = st.executeQuery(sql);
              while(rs.next()){
                  String classname = rs.getString("ClassName");
                   if(Classes.equals(classname) ){
                     {
                      found = true;
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
              }}catch(Exception sqlEx){
                     JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }     
        return found;
    }
     public void updateClass(String Classes,String Section){
     
    try {   
    String sql = "UPDATE Classes SET ClassName=?,Section=? WHERE ClassName = '"+Classes+"'"+"AND Section = '"+Section+"'";
            pst = con.prepareStatement(sql);
            pst.setString(1,classNo);
            pst.setString(2,section);
            JOptionPane.showMessageDialog(null,"Successfully updated","Classes Record",JOptionPane.INFORMATION_MESSAGE);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
            JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
          } 
  }
      public void ClassesRecord(JTable tab)
   {
       
       try{
           String sql ="select ClassName as [Class Name], Section as [Section] from Classes"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
           }
   }
      public void getDataClasses(JTable table,String search){
        String sql="select ClassName as [Class Name], Section as [Section] from Classes where ClassName = "+search+"";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
}
      public void Fillcombo(JComboBox classtf1,JComboBox sectf1){
        try{
            String sql="select * from Classes ";
        pst = con.prepareStatement(sql);
           rs=pst.executeQuery();
           String n="";
           String s="";
           
           int j=0;
           while(rs.next()){
               
               
               String ClassName=rs.getString("ClassName");
               String Section=rs.getString("Section");
               for (int i=0;i<=j;i++){
               if (n!=ClassName){
               classtf1.addItem(ClassName);
               }
               if (s!=Section){
               sectf1.addItem(Section);
               }
               }
               n= classtf1.getSelectedItem().toString();
               s=sectf1.getSelectedItem().toString();
//               n=cl;
//               s=sec;
//               System.out.println(value);
//               System.out.println(sectf1.);
j++;
               
           }
//            System.out.println(cl);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
      public void clickMouseClass(JTextField claasName,JTextField Section,JTable jTable1 ){
             try{
            Connection con=connection.setConnection();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String table_click1= jTable1.getModel().getValueAt(row, 1).toString();
             String sql= "select * from Classes where ClassName = '" + table_click + "'"+" AND Section = '"+table_click1+"'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next())
            {
                String ClassName = rs.getString("ClassName");
                claasName.setText(ClassName);
                String sec = rs.getString("Section");
                Section.setText(sec);
            }
        
    }                                    
    catch(Exception e){
        JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
    }
      }
}
