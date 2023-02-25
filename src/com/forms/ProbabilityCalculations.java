/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BackupFolder.java
 *
 * Created on Jan 19, 2010, 11:58:41 AM
 */
package com.forms;

import com.dao.ConnectionManager;
import com.helper.Constants;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.helper.StringHelper;
import image.operations.ImageHelper;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Administrator
 */
public class ProbabilityCalculations extends javax.swing.JInternalFrame {

    DefaultTableModel tm;
    private int WARNING_MESSAGE;
    List list;
    // public static ArrayList arr = null,  arr1 = null;
    MainForm jd;

    /** Creates new form BackupFolder */
    public ProbabilityCalculations() throws Exception {
        System.out.println("BackupFolder");
        initComponents();
        refreshData();
       

    }
    public static List activeUserList = null;

    public void refreshData() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        String query = "select u.UserId,u.FName,u.LName,D.noofdownloads  from (select count(*) as noofdownloads ,userid from datadb.trackdownloads group by userid) D,datadb.userinfo u where D.userid=u.userid";
        tm = (DefaultTableModel) jTableDisplay1.getModel();
        List list = ConnectionManager.getMapList(query);
        for (int i = 0; i < list.size(); i++) {
            HashMap param = (HashMap) list.get(i);
            String fname = StringHelper.nullObjectToStringEmpty(param.get("FName"));
            String lname = StringHelper.nullObjectToStringEmpty(param.get("LName"));
            String UserId = StringHelper.nullObjectToStringEmpty(param.get("UserId"));
            int noofdownloads = StringHelper.nullObjectToIntegerEmpty(param.get("noofdownloads"));
            pieDataset.setValue(fname + " " + lname, new Integer(noofdownloads));
            tm.addRow(new Object[]{(i + 1) + "", fname + " " + lname, noofdownloads});
        }
        jTableDisplay1.setModel(tm);
        JFreeChart chart = ChartFactory.createPieChart("Probability Calculation On No Of Downloads", pieDataset, true, true, Locale.ENGLISH);
        
        BufferedImage bi = chart.createBufferedImage(400, 400);
        jLabel1.setIcon(new ImageIcon(ImageHelper.toImage(bi)));

//        query="select tw.fileid,ui.userid,ui.FName,ui.LName,ui.rollId,bi.description,bi.originalpath from datadb.trackdownloads tw,datadb.userinfo ui,datadb.backupinfo bi where ui.Userid=tw.userid and tw.ipaddress !=ui.IPAddress and bi.ID=tw.fileid and  ui.rollId="+Constants.AGENT_ROLL_ID;
        query="select tw.fileid,ui.userid,ui.FName,ui.LName,ui.rollId,bi.description,bi.originalpath from datadb.trackdownloads tw,datadb.userinfo ui,datadb.backupinfo bi where ui.Userid=tw.userid and tw.ipaddress !=ui.IPAddress and bi.ID=tw.fileid ";
       DefaultTableModel tm1 = (DefaultTableModel) jTableDisplay2.getModel();
        
            list = ConnectionManager.getMapList(query);
        for (int i = 0; i < list.size(); i++) {
            HashMap param = (HashMap) list.get(i);
            String fname = StringHelper.nullObjectToStringEmpty(param.get("FName"));
            String lname = StringHelper.nullObjectToStringEmpty(param.get("LName"));

            String originalpath = StringHelper.nullObjectToStringEmpty(param.get("originalpath"));
            String description = StringHelper.nullObjectToStringEmpty(param.get("description"));
            tm1.addRow(new Object[]{(i + 1) + "", fname + " " + lname, originalpath,description});
        }
        jTableDisplay1.setModel(tm);

    }

    private boolean checkForRepeatedPath() {

        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jDialog5 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableDisplay1 = new JTable() {

            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);

                if (realColumnIndex == 1) {
                    tip = getValueAt(rowIndex, colIndex).toString();
                }
                return tip;
            }
        }
        ;
        jLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableDisplay2 = new JTable() {

            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);

                if (realColumnIndex == 1) {
                    tip = getValueAt(rowIndex, colIndex).toString();
                }
                return tip;
            }
        }
        ;
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jDialog2Layout = new org.jdesktop.layout.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jDialog3Layout = new org.jdesktop.layout.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jDialog4Layout = new org.jdesktop.layout.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jDialog5Layout = new org.jdesktop.layout.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

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
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ProbabilityCalculations.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setToolTipText(resourceMap.getString("title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(887, 580));
        setName("Peer2peer Trust Framework"); // NOI18N
        setPreferredSize(new java.awt.Dimension(887, 580));
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Guilty Agent Calculations"));
        jPanel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(887, 600));

        jTableDisplay1.setBackground(new java.awt.Color(255, 255, 204));
        jTableDisplay1.setFont(new java.awt.Font("Verdana", 0, 10));
        jTableDisplay1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No", "Agent Name", "No Of Downloads"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDisplay1.setDragEnabled(true);
        jScrollPane5.setViewportView(jTableDisplay1);

        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableDisplay2.setBackground(new java.awt.Color(255, 255, 204));
        jTableDisplay2.setFont(new java.awt.Font("Verdana", 0, 10));
        jTableDisplay2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No", "Agent Name", "File Name", "File Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDisplay2.setDragEnabled(true);
        jScrollPane6.setViewportView(jTableDisplay2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Guilty Agent Downloads From Other Machine");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 278, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane6)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                            .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 376, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 444, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .add(24, 24, 24)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 887, 550);

        jLabel2.setText("Guilty Agent File Download Details");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 163, 14);

        getAccessibleContext().setAccessibleName(resourceMap.getString("title")); // NOI18N
        getAccessibleContext().setAccessibleDescription(resourceMap.getString("title")); // NOI18N
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static int index = 0;

    // File srcPath = new File("E:/vidio songs/NEW SONGS");
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new ProbabilityCalculations().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ProbabilityCalculations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableDisplay1;
    private javax.swing.JTable jTableDisplay2;
    // End of variables declaration//GEN-END:variables
}
