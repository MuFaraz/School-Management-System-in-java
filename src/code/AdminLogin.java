/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Muhammad Faraz
 */
public class AdminLogin {
    private String userName;
    private String Password;
    public AdminLogin next;

    public AdminLogin() {
    }

    public AdminLogin(String userName, String Password) {
        this.userName = userName;
        this.Password = Password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }
     public void display(){
        System.out.println(userName+" "+Password+" ");
        
    }
      public void printComponenet(final Component component){
  PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setJobName(" Print Component ");

  pj.setPrintable (new Printable() {    
    public int print(Graphics pg, PageFormat pf, int pageNum){
      if (pageNum > 0){
      return Printable.NO_SUCH_PAGE;
      }
      Graphics2D g2 = (Graphics2D) pg;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      String name="ID   ";
//        System.out.println("");
      
      component.print(pg);
      return Printable.PAGE_EXISTS;
    }
  });
  if (pj.printDialog() == false)
  return;

  try {
        pj.print();
  } catch (PrinterException ex) {
        // handle exception
  }
     }
      Connection2DB connection=new Connection2DB();
        Connection con = connection.setConnection();
       // ResultSet rs = null;
        PreparedStatement pst = null;
        public void piechart(JPanel pie){
        DefaultPieDataset pieDataset=new DefaultPieDataset();
        Staff stf=new Staff();
         Statement st;
         ResultSet rs;
        try {
            st = con.createStatement();
            String sql="Select * from Finance where month = '"+stf.getMonth()+"'"+"AND year = '"+stf.getYear()+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                int income=rs.getInt("income");
                int expenditure=rs.getInt("expenditure");
                 pieDataset.setValue("INCOME", new Integer(income));
                 pieDataset.setValue("EXPENDITURE", new Integer(expenditure));
                
                       }
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error in update","Record", JOptionPane.ERROR_MESSAGE);
         
        }

        JFreeChart chart=ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
        PiePlot p=(PiePlot)chart.getPlot();
//        p.setForegroundAlpha(TOP_ALIGNMENT);
//        ChartFrame frame=new ChartFrame("Pie Chart", chart);
//        frame.setVisible(true);
//        CategoryPlot barchrt=p.g;
        ChartPanel barPanel=new ChartPanel(chart);
 
//        ChartPanel 
//        frame.setSize(450,500);
        pie.removeAll();
    pie.add(barPanel,BorderLayout.CENTER);
    pie.validate();
    }
        public void setpass(String a){    
          try{
                 String sql1 = "UPDATE Login SET Password='"+a+"' where UserName='admin'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
           JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE); 
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
        public void password(JTextField snum){
         try{
             String a=null;
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Login where UserName='admin' ";   
            ResultSet rs = st.executeQuery(sql);
              while(rs.next()){
                  a=rs.getString("Password");
                  
              }
              snum.setText(a);
//              chalan.setText(String.valueOf(challanNo));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
      
        }
     }
         public String getmacpc(){
        InetAddress ip;
        String maci=null;
	try {
			
		ip = InetAddress.getLocalHost();
		//System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		//System.out.print("Current MAC address : ");
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
			maci=sb.toString();
//                        System.out.println(maci);
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
        return maci;
    }
      public String macword(){
           String a=null;
         try{
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Login where UserName = 'admin' ";   
            ResultSet rs = st.executeQuery(sql);
              while(rs.next()){
                  a=rs.getString("mac");
                  
              }
              
//              chalan.setText(String.valueOf(challanNo));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Record", JOptionPane.ERROR_MESSAGE);
      
        }
         return a;
     }   
      public boolean allow(){
          if (macword().equals(getmacpc().toString())) {
//              JOptionPane.showMessageDialog(null, getmacpc().toString());
              return true;
          } else {
              return false;
          }
      }
      public void setmac(){    
          try{
                 String sql1 = "UPDATE Login SET mac='"+getmacpc()+"' where UserName='admin'";
            pst = con.prepareStatement(sql1);
             pst.executeUpdate();
            pst.close();
           JOptionPane.showMessageDialog(null,"UPDATE","SUCCESFULLY", JOptionPane.INFORMATION_MESSAGE); 
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"update","Connection Error", JOptionPane.ERROR_MESSAGE);
           }
      }
}
