/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author Muhammad Faraz
 */import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import javaapplication1.LOGIN;
import javax.swing.JOptionPane;
public class linnklist {
    private Student headStud;
    private Staff headTeacher;
    private AdminLogin headadmin;
//    student stud=new student();
    public linnklist() {
        headStud=null;
        headTeacher=null;
        headadmin=null;
    }
    public boolean isemptyTeacher(){
        return (headTeacher==null);
    }
    Connection2DB connection=new Connection2DB();
    Connection con=connection.setConnection();
    /////////////////////////////////STUDENTS SECTION////////////////////////////
    public void dataToLinkStudent(){
        try{
            Statement st=con.createStatement();
            String sql="Select * FROM Student ";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String Stdname=rs.getString("StudentName");
                int Rolnum=rs.getInt("RollNum");
                String DateOfBirth=rs.getString("DateOfBirth");
                String fname=rs.getString("GuardianName");
                String fatherCnic=rs.getString("GuardinCnic");
                int Contact=rs.getInt("CellNum");
                String Address=rs.getString("Address");
                String AddmissionDate=rs.getString("AdmissionDate");
                int idnum=rs.getInt("IDnum");
                int fees=rs.getInt("fees");
                String ClassName=rs.getString("ClassName");
                String Section=rs.getString("Section");
                classes classes=new classes();

//               student newstud=new student(Stdname, Rolnum, idnum, DateOfBirth, fname, fatherCnic, Contact, Address, AddmissionDate, ClassName, fees,Section);
                       if (headStud==null){
//                   headStud=newstud;
               }
               else {
//                   student temp=headStud;
//                   while(temp.next!=null)
                   {
//                       temp=temp.next;
                   }
//                   temp.next=newstud;
               }
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
    }
//    public void displayStudent(){
//         student thelink=headStud;
//            while(thelink!=null){
//                thelink.display();
//                thelink=thelink.next;
//                System.out.println();
//            }
//    }
    public void addStudentfromLinkList(String StdName,int RollNum,int IDnum,String DateOfBirth,String fname,String FCnic,int Contact,String Address,String AdmissionDate,String classes,int fees,String Section){
//    student  newstud=new student(StdName, RollNum, IDnum, DateOfBirth, fname, FCnic, Contact, Address, AdmissionDate, classes, fees,Section);
    if (headStud==null){
//        headStud=newstud;
    }
    else {
//        student temp=headStud;
//        while(temp.next!=null)
        {
//            temp=temp.next;
        }
//        temp.next=newstud;
    }
    }
     public boolean isEmptyStudent(){
            return (headStud==null);
        }
//    public student searchStudent(int rollNum){
//           student student=headStud;
//            if (isEmptyStudent()){
//                while(student.getRollNumber()!=rollNum){
//                    if (student.next==null){
//                        return null;
//                    }else {
//                        student=student.next;
//                    }
//                }
//            }
//            else {
//                System.out.println("Empty");
//            }
//            return student;
//        }
//     public student DeleteStudent(int rollNum){
//            student currentstudent=headStud;
//            student previusstudent=headStud;
//            while(currentstudent.getRollNumber()!=rollNum){
//                if (currentstudent.next==null){
//                    return null;
//                }
//                else {
//                    previusstudent =currentstudent;
//                    currentstudent=currentstudent.next;
//                }
//            }
//            if (currentstudent==headStud){
//                headStud=headStud.next;
//            }
//            else {
//                previusstudent.next=currentstudent.next;
//            }
//            return currentstudent;
//        }
//------------------X--------------------------------X-----------------------------X------------------------------------X
     /////////////////////TEACHER SECTION////////////
//     public void dataToLinkTeacher(){
//        try{
//            Statement st=con.createStatement();
//            String sql="Select * FROM Teacher ";
//            ResultSet rs=st.executeQuery(sql);
//            while(rs.next()){
//                String TeachName=rs.getString("teacherName");
//                int teacheID=rs.getInt("teacherID");
//                String joiningDate=rs.getString("joiningDate");
//                String fname=rs.getString("fatherName");
//                String teachCnic=rs.getString("teacherCnic");
//                int Contact=rs.getInt("Contact");
//                String Address=rs.getString("Address");
//                int age=rs.getInt("Age");
//                String gender=rs.getString("Gender");
//                int Salary=rs.getInt("Salary");
////                classes classes;student newstud=new student(Stdname, Rolnum, idnum, DateOfBirth, fname, fatherCnic, Contact, Address, AddmissionDate, classes, fees);
//               Staff newteacher =new Staff(teacheID, TeachName, fname, teachCnic, age, Contact, joiningDate, gender, Salary, Address);
//                if (headTeacher==null){
//                   headTeacher=newteacher;
//               }
//               else {
//                   Staff temp=headTeacher;
//                   while(temp.next!=null){
//                       temp=temp.next;
//                   }
//                   temp.next=newteacher;
//               }
//            }
//        }catch(Exception e){
//             JOptionPane.showMessageDialog(null,"Error","Connection Error", JOptionPane.ERROR_MESSAGE);
//           }
//    }
//      public void addTeacherLinkList(int teacheID,String TeachName, String fname,String teachCnic,int age,int Contact,String joiningDate,String gender,int Salary,String Address){
//       Staff newTeacher=new Staff(teacheID, TeachName, fname, teachCnic, age, Contact, joiningDate, gender, Salary, Address);
//     if (headTeacher==null){
//        headTeacher=newTeacher;
//    }
//    else {
//        Staff temp=headTeacher;
//        while(temp.next!=null){
//            temp=temp.next;
//        }
//        temp.next=newTeacher;
//    }
//    }
//      public Staff searchTeacherLink(int teacherID){
//           Staff teacher=headTeacher;
//            if (isemptyTeacher()){
//                while(teacher.getTeacherId()!=teacherID){
//                    if (teacher.next==null){
//                        return null;
//                    }else {
//                        teacher=teacher.next;
//                    }
//                }
//            }
//            else {
//                System.out.println("Empty");
//            }
//            return teacher;
//        }
//     public Staff DeleteTeacherlink(int teacherId){
//            Staff currentTeacher=headTeacher;
//            Staff previusTeacher=headTeacher;
//            while(currentTeacher.getTeacherId()!=teacherId){
//                if (currentTeacher.next==null){
//                    return null;
//                }
//                else {
//                    previusTeacher =currentTeacher;
//                    currentTeacher=currentTeacher.next;
//                }
//            }
//            if (currentTeacher==headTeacher){
//                headTeacher=headTeacher.next;
//            }
//            else {
//                previusTeacher.next=currentTeacher.next;
//            }
//            return currentTeacher;
//        }
     /////////////////ADMIN LOGIN/////////////////////////////////////////
      public boolean isemptylogin(){
        return (headadmin==null);
    }
      public void dataToLinkLogin(){
        try{
            Statement st=con.createStatement();
            String sql="Select * FROM Login ";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String UserName=rs.getString("UserName");
                String Password=rs.getString("Password");
//              Staff newteacher =new Staff(teacheID, TeachName, fname, teachCnic, age, Contact, joiningDate, gender, Salary, Address);
                AdminLogin newlogin=new AdminLogin(UserName, Password);
                if (headadmin==null){
                   headadmin=newlogin;
               }
               else {
                   AdminLogin temp=headadmin;
                   while(temp.next!=null){
                       temp=temp.next;
                   }
                   temp.next=newlogin;
               }
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
    }
      public boolean matchPassword(String username,String Password){
        boolean found=false;
        AdminLogin temp=headadmin;
        try{
            while(temp!=null){
                if (username.equals(temp.getUserName())&&Password.equals(temp.getPassword())){
//                   return true;
       found=true;
       break;
                }
                else{
                    temp=temp.next;
                }
            }
        
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
          }
        if (found==false){
            return false;
        }   
        else {
            return true;
        }
//        return found;
      }
       public void display(){
            AdminLogin thelink=headadmin;
            while(thelink!=null){
                thelink.display();
//                System.out.println("Next link : "+thelink.next);
                thelink=thelink.next;
//                System.out.println();
            }
            
        }
}
