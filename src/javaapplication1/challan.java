/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import code.Finance;
import code.Staff;
import code.Student;
import code.StudentFeesChallan;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mithrandir
 */
public class challan extends javax.swing.JPanel implements Printable {

   int[] pageBreaks;  // array of page break line positions.

    /* Synthesise some sample lines of text */
    String[] textLines;
    private void initTextLines() {
        if (textLines == null) {
            int numLines=jTable1.getModel().getRowCount();
            textLines = new String[numLines];
            for (int i=0;i<numLines;i++) {
                textLines[i]= "This is line number " + i;
            }
        }
    }

    public int print(Graphics g, PageFormat pf, int pageIndex)
             throws PrinterException {

        Font font = new Font("Serif", Font.PLAIN, 15);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null) {
            initTextLines();
            int linesPerPage = (int)(pf.getImageableHeight()/lineHeight)-10;
            int numBreaks = ((textLines.length-1)/linesPerPage);
            pageBreaks = new int[numBreaks];
            for (int b=0; b<numBreaks; b++) {
                pageBreaks[b] = (b+1)*linesPerPage; 
            }
        }

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
        
         */int y = 70; 
        if(pageIndex==0){
            y=120;
            g.drawString(pay.getSelectedItem().toString()+"  FEE  REPORT", 250, 40);
            g.drawString(monthsea.getSelectedItem().toString(), 250, 60);
            g.drawString(yearsearch.getSelectedItem().toString(), 290, 60);
            g.drawString(jTable1.getColumnName(0), 50, 100);
        g.drawString(jTable1.getColumnName(1), 80, 100);
        g.drawString(jTable1.getColumnName(3), 350, 100);
        g.drawString(jTable1.getColumnName(4), 450, 100);
        g.drawString(jTable1.getColumnName(5), 550, 100);
        g.drawString("PAGE : "+String.valueOf(pageIndex), 550, 780);
        }else{
        
        g.drawString(jTable1.getColumnName(0), 50, 50);
        g.drawString(jTable1.getColumnName(1), 80, 50);
        g.drawString(jTable1.getColumnName(3), 350, 50);
        g.drawString(jTable1.getColumnName(4), 450, 50);
        g.drawString(jTable1.getColumnName(5), 550, 50);
        g.drawString("PAGE : "+String.valueOf(pageIndex), 550, 780);}
        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex-1];
        int end   = (pageIndex == pageBreaks.length)
                         ? textLines.length : pageBreaks[pageIndex];

        for (int line=start; line<end; line++ ) {
            y += lineHeight;
            String a=jTable1.getValueAt(line, 1).toString();
            g.drawString(jTable1.getValueAt(line, 0).toString(),50, y);
            g.drawString(a,80, y);
           g.drawString(jTable1.getValueAt(line, 3).toString(),350, y);
           g.drawString(finance.getMonthStr(Integer.parseInt(jTable1.getValueAt(line, 4).toString())),450, y);
           g.drawString(jTable1.getValueAt(line, 5).toString(),550, y);
       //     g.drawString(jTable1.getModel().getValueAt(line, 1).toString().substring(0, 20),200, y);
           
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 public void d(){
    PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
              childPanel=new challan();
        childPanel.setSize(this.getSize());
        this.removeAll();
        this.repaint();
        this.add(childPanel);
        this.validate();
         }
}
    /**
     * Creates new form challan
     */JPanel childPanel;
     Finance finance=new Finance();
      StudentFeesChallan stu=new StudentFeesChallan();
    public challan() {
        initComponents();
   
        stu.StudentRecordfees(jTable1);
//        String monthse=String.valueOf(monthsea.getMonth());
//           System.out.println(monthse);
//           
//          String year=String.valueOf(yearsearch.getYear());
//          System.out.println(year);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radiogroup = new javax.swing.ButtonGroup();
        jLabel33 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        name = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        addbtn2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        namesearch = new javax.swing.JTextField();
        idserch = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addbtn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        addbtn1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        addbtn3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pay = new javax.swing.JComboBox<>();
        monthsea = new javax.swing.JComboBox<>();
        yearsearch = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        addbtn4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1163, 750));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel33.setText("SELECTED STUDENT INFORMATION");

        name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("NAME");

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("STATUS");

        status.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        status.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        addbtn2.setBackground(new java.awt.Color(51, 153, 255));
        addbtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtn2MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/icons8-search-40.png"))); // NOI18N
        jLabel6.setText("SEARCH");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout addbtn2Layout = new javax.swing.GroupLayout(addbtn2);
        addbtn2.setLayout(addbtn2Layout);
        addbtn2Layout.setHorizontalGroup(
            addbtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbtn2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        addbtn2Layout.setVerticalGroup(
            addbtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbtn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("NAME");

        namesearch.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        namesearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        namesearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namesearchActionPerformed(evt);
            }
        });

        idserch.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        idserch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        idserch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idserchActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("ID");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("ID");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/icons8-back-48.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("STUDENT FEE ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        addbtn.setBackground(new java.awt.Color(51, 153, 255));
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PAY");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout addbtnLayout = new javax.swing.GroupLayout(addbtn);
        addbtn.setLayout(addbtnLayout);
        addbtnLayout.setHorizontalGroup(
            addbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbtnLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel4)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        addbtnLayout.setVerticalGroup(
            addbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(15, 15, 15))
        );

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("YEAR");

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("MONTH");

        id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        radiogroup.add(jRadioButton1);
        jRadioButton1.setText("PAID BEFORE DUE DATE");
        jRadioButton1.setAutoscrolls(true);

        radiogroup.add(jRadioButton2);
        jRadioButton2.setText("PAID AFTER DUE DATE");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        addbtn1.setBackground(new java.awt.Color(51, 153, 255));
        addbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtn1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GENERATE EXTRA FEE");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout addbtn1Layout = new javax.swing.GroupLayout(addbtn1);
        addbtn1.setLayout(addbtn1Layout);
        addbtn1Layout.setHorizontalGroup(
            addbtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbtn1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(50, 50, 50))
        );
        addbtn1Layout.setVerticalGroup(
            addbtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbtn1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        addbtn3.setBackground(new java.awt.Color(51, 153, 255));
        addbtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtn3MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GENERATE FEE CHALLAN");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout addbtn3Layout = new javax.swing.GroupLayout(addbtn3);
        addbtn3.setLayout(addbtn3Layout);
        addbtn3Layout.setHorizontalGroup(
            addbtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbtn3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(35, 35, 35))
        );
        addbtn3Layout.setVerticalGroup(
            addbtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbtn3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "UNPAID", "PAID" }));

        monthsea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "JANUARY", "FEBUEARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" }));
        monthsea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthseaActionPerformed(evt);
            }
        });

        yearsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1982", "1981", "1980" }));
        yearsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsearchActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("STATUS");

        addbtn4.setBackground(new java.awt.Color(51, 153, 255));
        addbtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtn4MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PRINT REPORT");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout addbtn4Layout = new javax.swing.GroupLayout(addbtn4);
        addbtn4.setLayout(addbtn4Layout);
        addbtn4Layout.setHorizontalGroup(
            addbtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbtn4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(82, 82, 82))
        );
        addbtn4Layout.setVerticalGroup(
            addbtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbtn4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel30)
                                    .addComponent(id)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton2))
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addbtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addbtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)))
                .addGap(0, 84, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28)
                    .addComponent(idserch, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26)
                    .addComponent(namesearch, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthsea, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(yearsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(addbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idserch)
                            .addComponent(namesearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(monthsea, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(addbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(18, 18, 18)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
//           String monthse=(String)this.monthsea.getSelectedItem();
//        String year=(String)this.yearsearch.getSelectedItem();
//         String pa=(String)pay.getSelectedItem();
//      if (pa.equals("PAID")){
//         pa="0"  ; 
//        }
//        else {
//            pa="1";
//        }
//          if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//          return;
//          }
//          
//       StudentFeesChallan st=new StudentFeesChallan();
////       int m=0;
//       Staff staff=new Staff();
////        m=staff.getMonthInt(m,monthse);
//////        if (id)
////Staff st=new Staff();
//        int m=0;
//        m=staff.getMonthInt(m,monthse);
//if (idserch.getText()==("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ") && pa!=(" ")){
//    stu.StudentFeesConditionpay(jTable1, pa);
//    return;
//}
//if (idserch.getText()!=("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ") && pa!=(" ")){
//    stu.StudentFeesConditionidpay(jTable1, idserch.getText(),pa);
//    return;
//}
//
//if (idserch.getText().equals("")&&namesearch.getText()!=("")&&monthse.equals(" ")&&year.equals(" ") && pa!=(" ")){
//    stu.StudentFeesConditionpayname(jTable1, pa,namesearch.getText());
//    return;
//}
//
//if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse!=(" ")&&year.equals(" ") && pa!=(" ")){
//    stu.StudentFeesConditionpaymonth(jTable1, pa,String.valueOf(m));
//    return;
//}
//if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse==(" ")&&year!=(" ") && pa!=(" ")){
//    stu.StudentFeesConditionpayyear(jTable1, pa,year);
//    return;
//}
//
//
//        if (idserch.getText()!=""&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ") && pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
////          return;
//if (st.searchstudentfeesid(idserch.getText())){
//st.StudentFeesConditionid(jTable1, idserch.getText());
//return;}
//else{
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
// 
//        stu.StudentRecordfees(jTable1);return;
//}
//          }
//        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse.equals(" ")&&year.equals(" ")){
//     if (st.searchstudentfeesname(namesearch.getText())){         st.StudentFeesConditionname(jTable1, namesearch.getText());//jTable1);
//              return;}
//     else {
//         
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//     }
//          }
//        if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse!=" "&&year.equals(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//           if (st.searchstudentfeesmonth(monthse)){ st.StudentFeesConditionmonth(jTable1,monthse);
//return;}else {
//               
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//           }
//          }
//        if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse==" "&&year!=" "&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//         if (st.searchstudentfeesyear(year)){   st.StudentFeesConditionyear(jTable1, year);
//return;}else {
//             
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//         }
//          }
//        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse==" "&&year.equals(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//        if (st.searchstudentfeesidname(idserch.getText(), namesearch.getText())){    st.StudentFeesConditionidName(jTable1, idserch.getText(),namesearch.getText());
//return;
//          }
//        else {
//            
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//        }}
//        
//        if (idserch.getText()!=""&&namesearch.getText()==""&&monthse!=" "&&year.equals(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//          if (st.searchstudentfeesidmonth(idserch.getText(), String.valueOf(m))){  st.StudentFeesConditionidMonth(jTable1, idserch.getText(),String.valueOf(m));
//return;}
//          else {
//              
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//          }
//          }
//        
//        if (idserch.getText()!=""&&namesearch.getText()==""&&monthse==" "&&year!=(" ") && pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//           if (st.searchstudentfeesidyear(idserch.getText(), year)){ st.StudentFeesConditionidYear(jTable1, idserch.getText(),year);
//return;}
//           else {
//               
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//           }
//          }
//        
//        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse!=" "&&year.equals(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//          if (st.searchstudentfeesnamemonth(namesearch.getText(), String.valueOf(m))){  st.StudentFeesConditionNameMonth(jTable1, namesearch.getText(),String.valueOf(m));
//return;}
//          else{
//              
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//          }
//          }
//        
//        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse==" "&&year !=(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//if (st.searchstudentfeesnameyear(namesearch.getText(), year)){
//            st.StudentFeesConditionNameYear(jTable1, namesearch.getText(),year);
//return;}
//else {
//    
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//}
//          }
//        
//        if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse!=" "&&year!=(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//if(st.searchstudentfeesmonthyear(String.valueOf(m), year)){
//            st.StudentFeesConditionMonthYear(jTable1,String.valueOf(m) , year);
////JOptionPane.showMessageDialog(null, "found");//Year(jTable1, namesearch.getText(),year);
//return;}else {
//        
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//        }
//          }
//        
//        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse!=(" ")&&year.equals(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//if (st.searchstudentfeesidnamemonth(idserch.getText(), namesearch.getText(), String.valueOf(m))){
//            st.StudentFeesConditionidNameMonth(jTable1, idserch.getText(),namesearch.getText(),String.valueOf(m));
//return;}
//else {
//    
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//}
//          }
//        
//        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse==" "&&year!=(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//if (st.searchstudentfeesidmonthyear(idserch.getText(),monthse, year)){
//            st.StudentFeesConditionIdMonthYear(jTable1, idserch.getText(),monthse,year);
//return;}
//else {
//    
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//}
//          }
//        
//        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse!=(" ")&&year!=(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//        if (st.searchstudentfeesnamemonthyear(namesearch.getText(), String.valueOf(m), year)){    st.StudentFeesConditionNameMonthYear(jTable1, namesearch.getText(),String.valueOf(m),year);
//return;}
//        else {
//            
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//        }
//          }
//        
//        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse!=" "&&year!=(" ")&& pa.equals(" ")){
////              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//        if (st.searchstudentfeesAll(idserch.getText(), namesearch.getText(), String.valueOf(m), year)){    
//       st.StudentFeesConditionAll(jTable1, idserch.getText(), namesearch.getText(), String.valueOf(m), year);
//   
//return;}else {
//            
//    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT",JOptionPane.INFORMATION_MESSAGE);
//        stu.StudentRecordfees(jTable1);
// return;
//        }
//          }                                 

    }//GEN-LAST:event_jLabel6MouseClicked

    private void addbtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtn2MouseClicked
        
//         StudentFeesChallan std=new StudentFeesChallan();
//        boolean isIntegerid=std.isInteger(idserch.getText());
           String monthse=(String)this.monthsea.getSelectedItem();
        String year=(String)this.yearsearch.getSelectedItem();
         String pa=(String)pay.getSelectedItem();
      if (pa.equals("PAID")){
         pa="0.0"  ; 
        }
      else if (pa.equals("UNPAID")){
          pa="1";
      }
        else {
            pa=" ";
        }
          
          
       StudentFeesChallan st=new StudentFeesChallan();
//       int m=0;
       Staff staff=new Staff();
//        m=staff.getMonthInt(m,monthse);
////        if (id)
//Staff st=new Staff();
        int m=0;
        m=staff.getMonthInt(m,monthse);
        if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ")&&pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
stu.StudentRecordfees(jTable1);
          return;
          }
if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ") && pa!= " " ){
  
    stu.StudentFeesConditionpay(jTable1, pa);
    return;
}
if (idserch.getText()!=("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ") && pa!= " " ){
    stu.StudentFeesConditionidpay(jTable1, idserch.getText(),pa);
    return;
}

if (idserch.getText().equals("")&&namesearch.getText()!="" && monthse.equals(" ")&&year.equals(" ") && pa!= " " ){
    stu.StudentFeesConditionpayname(jTable1, namesearch.getText(),pa);
    return;
}

if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse!=" " &&year.equals(" ") && pa!= " " ){
    stu.StudentFeesConditionpaymonth(jTable1, pa,String.valueOf(m));
    return;
}
if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year!=" " && pa!=" "){
    stu.StudentFeesConditionpayyear(jTable1, pa,year);
    return;
}
if (idserch.getText()!="" &&namesearch.getText()!="" &&monthse.equals(" ")&&year.equals(" ") && pa!=" "){
    stu.StudentFeesConditionidpayname(jTable1, idserch.getText(), namesearch.getText(), pa);
    return;
}
if (idserch.getText()!="" &&namesearch.getText().equals("") &&monthse!=" "&&year.equals(" ") && pa!=" "){
    stu.StudentFeesConditionidpaymonth(jTable1, idserch.getText(), pa, String.valueOf(m));
return;}

if (idserch.getText()!="" &&namesearch.getText().equals("") &&monthse.equals(" ")&&year!=" " && pa!=" "){
    stu.StudentFeesConditionidpayyear(jTable1, idserch.getText(), pa,year);
return;}

if (idserch.getText().equals("") &&namesearch.getText()!="" &&monthse!=" "&&year.equals(" ") && pa!=" "){
    stu.StudentFeesConditionpaynamemonth(jTable1, namesearch.getText(), pa,String.valueOf(m));
return;}

if (idserch.getText().equals("") &&namesearch.getText()!="" &&monthse.equals(" ")&&year!=" " && pa!=" "){
    stu.StudentFeesConditionpaynameyear(jTable1, namesearch.getText(), pa,year);
return;}
if (idserch.getText().equals("") &&namesearch.getText().equals("") &&monthse!=" "&&year!=" " && pa!=" "){
    stu.StudentFeesConditionpaymonthyear(jTable1, pa,String.valueOf(m),year);
    return;
}

if (idserch.getText()!="" &&namesearch.getText()!="" &&monthse!=" "&&year.equals(" ") && pa!=" "){
    stu.StudentFeesConditionidpaynamemonth(jTable1, idserch.getText(),namesearch.getText(),pa,String.valueOf(m));
    return;
}

if (idserch.getText()!="" &&namesearch.getText()!="" &&monthse.equals(" ") && year!=" " && pa!=" "){
    stu.StudentFeesConditionidpaynameyear(jTable1, idserch.getText(),namesearch.getText(),pa,year);
    return;
}
if (idserch.getText()!="" &&namesearch.getText().equals("") &&monthse!=" " && year!=" " && pa!=" "){
    stu.StudentFeesConditionidpaymonthyear(jTable1, idserch.getText(),pa,String.valueOf(m),year);
    return;
}if (idserch.getText().equals("") &&namesearch.getText()!= "" &&monthse!=" " && year!=" " && pa!=" "){
    stu.StudentFeesConditionpaynamemonthyear(jTable1, namesearch.getText(),pa,String.valueOf(m),year);
    return;
}
if (idserch.getText()!="" &&namesearch.getText()!= "" &&monthse!=" " && year!=" " && pa!=" "){
    stu.StudentFeesConditionidpaynamemonthyear(jTable1,idserch.getText() ,namesearch.getText(),pa,String.valueOf(m),year);
    return;
}


        if (idserch.getText()!=""&&namesearch.getText().equals("")&&monthse.equals(" ")&&year.equals(" ") && pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
//          return;
if (st.searchstudentfeesid(idserch.getText())){
st.StudentFeesConditionid(jTable1, idserch.getText());
return;}
else{
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT ID",JOptionPane.INFORMATION_MESSAGE);
 
        stu.StudentRecordfees(jTable1);return;
}
          }
        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse.equals(" ")&&year.equals(" ")){
     if (st.searchstudentfeesname(namesearch.getText())){         st.StudentFeesConditionname(jTable1, namesearch.getText());//jTable1);
              return;}
     else {
         
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT NAME",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
     }
          }
        if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse!=" "&&year.equals(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
           if (st.searchstudentfeesmonth(String.valueOf(m))){ 
               st.StudentFeesConditionmonth(jTable1,String.valueOf(m));
return;}else {
               
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT MONTH",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
           }
          }
        if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse.equals(" ")&&year!=" "&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
         if (st.searchstudentfeesyear(year)){   st.StudentFeesConditionyear(jTable1, year);
return;}else {
             
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT YEAR",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
         }
          }
        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse.equals(" ")&&year.equals(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
        if (st.searchstudentfeesidname(idserch.getText(), namesearch.getText())){    st.StudentFeesConditionidName(jTable1, idserch.getText(),namesearch.getText());
return;
          }
        else {
            
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT ID AND NAME",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
        }}
        
        if (idserch.getText()!=""&&namesearch.getText().equals(" ")&&monthse!=" "&&year.equals(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
          if (st.searchstudentfeesidmonth(idserch.getText(), String.valueOf(m))){  st.StudentFeesConditionidMonth(jTable1, idserch.getText(),String.valueOf(m));
return;}
          else {
              
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT ID MONTH",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
          }
          }
        
        if (idserch.getText()!=""&&namesearch.getText().equals(" ")&&monthse.equals(" ")&&year!=(" ") && pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
           if (st.searchstudentfeesidyear(idserch.getText(), year)){ st.StudentFeesConditionidYear(jTable1, idserch.getText(),year);
return;}
           else {
               
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT ID AND YEAR",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
           }
          }
        
        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse!=" "&&year.equals(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
          if (st.searchstudentfeesnamemonth(namesearch.getText(), String.valueOf(m))){  st.StudentFeesConditionNameMonth(jTable1, namesearch.getText(),String.valueOf(m));
return;}
          else{
              
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT AND MONTH",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
          }
          }
        
        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse.equals(" ")&&year !=(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
if (st.searchstudentfeesnameyear(namesearch.getText(), year)){
            st.StudentFeesConditionNameYear(jTable1, namesearch.getText(),year);
return;}
else {
    
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT NAME AND YEAR",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
}
          }
        
        if (idserch.getText().equals("")&&namesearch.getText().equals("")&&monthse!=" "&&year!=(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
if(st.searchstudentfeesmonthyear(String.valueOf(m), year)){
            st.StudentFeesConditionMonthYear(jTable1,String.valueOf(m) , year);
//JOptionPane.showMessageDialog(null, "found");//Year(jTable1, namesearch.getText(),year);
return;}else {
        
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT MONTH AND YEAR",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
        }
          }
        
        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse!=(" ")&&year.equals(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
if (st.searchstudentfeesidnamemonth(idserch.getText(), namesearch.getText(), String.valueOf(m))){
            st.StudentFeesConditionidNameMonth(jTable1, idserch.getText(),namesearch.getText(),String.valueOf(m));
return;}
else {
    
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT ID,NAME AND MONTH",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
}
          }
        
        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse.equals(" ")&&year!=(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
if (st.searchstudentfeesidmonthyear(idserch.getText(),String.valueOf(m), year)){
            st.StudentFeesConditionIdMonthYear(jTable1, idserch.getText(),String.valueOf(m),year);
return;}
else {
    
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT ID ,MONTH AND YEAR",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
}
          }
        
        if (idserch.getText().equals("")&&namesearch.getText()!=""&&monthse!=(" ")&&year!=(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
        if (st.searchstudentfeesnamemonthyear(namesearch.getText(), String.valueOf(m), year)){    st.StudentFeesConditionNameMonthYear(jTable1, namesearch.getText(),String.valueOf(m),year);
return;}
        else {
            
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT NAME,MONTH AND YEAR",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
        }
          }
        
        if (idserch.getText()!=""&&namesearch.getText()!=""&&monthse!=" "&&year!=(" ")&& pa.equals(" ")){
//              JOptionPane.showMessageDialog( this, "PLEASE ENTER All ","Error", JOptionPane.ERROR_MESSAGE);
        if (st.searchstudentfeesAll(idserch.getText(), namesearch.getText(), String.valueOf(m), year)){    
       st.StudentFeesConditionAll(jTable1, idserch.getText(), namesearch.getText(), String.valueOf(m), year);
   
return;}else {
            
    JOptionPane.showMessageDialog(null, "NOT FOUND","STUDENT ALL",JOptionPane.INFORMATION_MESSAGE);
        stu.StudentRecordfees(jTable1);
 return;
        }
          }             
    }//GEN-LAST:event_addbtn2MouseClicked

    private void namesearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namesearchActionPerformed
        // TODO add your handling code here:
        //        Student std=new Student();
        ////        boolean isIntegerid=std.isInteger(namesearch.getText());
        //          String monthse=(String)this.monthsea.getSelectedItem();
        //          String year=(String)this.yearsearch.getSelectedItem();
        //        if (namesearch.getText().equals("")){
            //           JOptionPane.showMessageDialog( this, "PLEASE ENTER NAME FOR SEARCH","Error", JOptionPane.ERROR_MESSAGE);
            //          return;
            //       }
        //
        //       Staff st=new Staff();
        //       st.staffReportCondition(jTable1, idserch.getText(), namesearch.getText(), monthse, year);
        //       st.sta
    }//GEN-LAST:event_namesearchActionPerformed

    private void idserchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idserchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idserchActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
       childPanel=new adminHomePanel();
        childPanel.setSize(this.getSize());
        this.removeAll();
        this.repaint();
        this.add(childPanel);
        this.validate();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked
     
        try {
      finance.payFees(Integer.parseInt(id.getText()), jRadioButton1, jRadioButton2, jTable1);
      stu.StudentRecordfees(jTable1);
            
        } catch (Exception e) {
            
        }

    }//GEN-LAST:event_addbtnMouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        StudentFeesChallan stu=new StudentFeesChallan();
        stu.clickTable(jTable1);
        stu.clik(jTable1, id, name,status);
        finance.duedatecaomparision(jRadioButton1, jRadioButton2,jTable1);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void addbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtn1MouseClicked
        // TODO add your handling code here:
         childPanel=new extrafeepanel();
        childPanel.setSize(this.getSize());
        this.removeAll();
        this.repaint();
        this.add(childPanel);
        this.validate();
    }//GEN-LAST:event_addbtn1MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void addbtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtn3MouseClicked
        // TODO add your handling code here:
        childPanel=new feeCHALLAN();
        childPanel.setSize(this.getSize());
        this.removeAll();
        this.repaint();
        this.add(childPanel);
        this.validate();
    }//GEN-LAST:event_addbtn3MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void monthseaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthseaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthseaActionPerformed

    private void yearsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearsearchActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void addbtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtn4MouseClicked
        // TODO add your handling code here:
        try {
            d();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_addbtn4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addbtn;
    private javax.swing.JPanel addbtn1;
    private javax.swing.JPanel addbtn2;
    private javax.swing.JPanel addbtn3;
    private javax.swing.JPanel addbtn4;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idserch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> monthsea;
    private javax.swing.JTextField name;
    private javax.swing.JTextField namesearch;
    private javax.swing.JComboBox<String> pay;
    private javax.swing.ButtonGroup radiogroup;
    private javax.swing.JTextField status;
    private javax.swing.JComboBox<String> yearsearch;
    // End of variables declaration//GEN-END:variables
}
