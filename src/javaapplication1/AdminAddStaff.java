/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import code.Staff;
import static code.Student.isInteger;
//import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mithrandir
 */
public class AdminAddStaff extends javax.swing.JPanel {

    /**
     * Creates new form AdminAddStaff
     */JPanel childPanel;
     int count=0;
     DateFormat dateFormat =new SimpleDateFormat("MM/dd/YYYY");
     Date dates=new Date();
     
    public AdminAddStaff() {
        initComponents();
//        count++;
date.setText(" "+dateFormat.format(dates));
        Staff st=new Staff(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel31 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        jSeparator32 = new javax.swing.JSeparator();
        addbutn1 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        NAMETF1 = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        dob = new javax.swing.JFormattedTextField();
        contact = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jSeparator33 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        designation = new javax.swing.JTextField();
        jSeparator34 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1082, 779));

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("CONTACT");

        id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("SALARY");

        jLabel38.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("ID");

        salary.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        salary.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        addbutn1.setBackground(new java.awt.Color(51, 153, 255));
        addbutn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbutn1MouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("ADD");

        javax.swing.GroupLayout addbutn1Layout = new javax.swing.GroupLayout(addbutn1);
        addbutn1.setLayout(addbutn1Layout);
        addbutn1Layout.setHorizontalGroup(
            addbutn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbutn1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel39)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        addbutn1Layout.setVerticalGroup(
            addbutn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbutn1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel39)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jSeparator27.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("DESIGNATION");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("NAME");

        NAMETF1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        NAMETF1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("JOINING DATE");

        dob.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        dob.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        contact.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        contact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel33.setText("PERSONAL INFORMATION");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/icons8-back-48.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("ADD EMPLOYEE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        designation.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        designation.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel33)))
                .addGap(404, 404, 404))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator32, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel26)
                                    .addComponent(NAMETF1)
                                    .addComponent(jLabel31)
                                    .addComponent(jSeparator28)
                                    .addComponent(contact)
                                    .addComponent(jSeparator10)
                                    .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                                .addComponent(jLabel38)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(91, 91, 91)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28)
                    .addComponent(jLabel40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(designation, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator31, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator34, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(salary, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(addbutn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel38)
                                .addGap(1, 1, 1)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NAMETF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel40)
                                .addGap(1, 1, 1)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(addbutn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addbutn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbutn1MouseClicked
        // TODO add your handling code here:
          boolean isIntegersalary=isInteger(salary.getText());
            
         boolean isIntegercontact=isInteger(contact.getText());
       try{
       
         if (NAMETF1.getText().equals("")){
                 JOptionPane.showMessageDialog( this, "PLEASE ENTER NAME ","Error", JOptionPane.ERROR_MESSAGE);
        return;
             }
              
              if (contact.getText().equals("")){
                 JOptionPane.showMessageDialog( this, "PLEASE ENTER CONTACT","Error", JOptionPane.ERROR_MESSAGE);
          return;
             }
              
              if (date.getText().equals("")){
                  JOptionPane.showMessageDialog( this, "PLEASE ENTER DATE","Error", JOptionPane.ERROR_MESSAGE);
         return;
             }
              if (salary.getText().equals("")){
                  JOptionPane.showMessageDialog( this, "PLEASE ENTER SALARY","Error", JOptionPane.ERROR_MESSAGE);
             return;}

              if (designation.equals("")){
                   JOptionPane.showMessageDialog( this, "PLEASE ENTER DESIGNATION","Error", JOptionPane.ERROR_MESSAGE);
             return;
              }
              if (NAMETF1.getText()==""&&salary.getText().equals("")&&contact.getText()==""){
                 JOptionPane.showMessageDialog( this, "PLEASE INPUT ALL DETAILS ","Error", JOptionPane.ERROR_MESSAGE);
        return;
             }
              
              if (isIntegersalary==false){
                  
                 JOptionPane.showMessageDialog( this, "YOU ENTERED SALARY IN ALPHABET ","Error", JOptionPane.ERROR_MESSAGE);
        return;
             }
             
              if (isIntegercontact==false){
                 JOptionPane.showMessageDialog( this, "YOU ENTERED CONTACT NUMBER IN ALPHABET ","Error", JOptionPane.ERROR_MESSAGE);
        return;
             }
              if(isIntegersalary==false&&isIntegercontact==false){
                 JOptionPane.showMessageDialog( this, "YOU ENTERED CONTACT NUMBER,ID NUMBER AND SALRY IN ALPHABET ","Error", JOptionPane.ERROR_MESSAGE);
        return;
              }
              
            Staff staff=new Staff(Integer.parseInt(id.getText()), NAMETF1.getText(), designation.getText(), contact.getText(), date.getText(), Integer.parseInt(salary.getText()));
            staff.addStaff();
            NAMETF1.setText("");
            contact.setText("");
            salary.setText("");
            designation.setText("");
            Staff s=new Staff(id);
       }catch(Exception e){
           JOptionPane.showMessageDialog( this, "ERROR IN ENROLL STAFF","Error", JOptionPane.ERROR_MESSAGE);
           
       }
       
    }//GEN-LAST:event_addbutn1MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        childPanel=new Staffhome();
        childPanel.setSize(this.getSize());
        this.removeAll();
        this.repaint();
        this.add(childPanel);
        this.validate();
    }//GEN-LAST:event_jPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NAMETF1;
    private javax.swing.JPanel addbutn1;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField date;
    private javax.swing.JTextField designation;
    private javax.swing.JFormattedTextField dob;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JTextField salary;
    // End of variables declaration//GEN-END:variables
}
