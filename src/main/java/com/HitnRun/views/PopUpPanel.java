package com.HitnRun.views;

public class PopUpPanel extends javax.swing.JPanel {

  private String message;

  public PopUpPanel(String message) {
    this.message = message;
    initComponents();
  }

  private void initComponents() {

    popUpMsg = new javax.swing.JLabel();
    popUpClose = new javax.swing.JLabel();

    setMaximumSize(new java.awt.Dimension(400, 200));
    setMinimumSize(new java.awt.Dimension(400, 200));
    setPreferredSize(new java.awt.Dimension(400, 200));
    setBackground(new java.awt.Color(40, 43, 48));

    popUpMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    popUpMsg.setText(message);

    popUpClose.setBackground(new java.awt.Color(102, 102, 255));
    popUpClose.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
    popUpClose.setForeground(new java.awt.Color(255, 255, 255));
    popUpClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    popUpClose.setText("OK");
    popUpClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    popUpClose.setOpaque(true);
    popUpClose.addMouseMotionListener(
        new java.awt.event.MouseMotionAdapter() {
          public void mouseMoved(java.awt.event.MouseEvent evt) {
            popUpCloseMouseMoved(evt);
          }
        });
    popUpClose.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseExited(java.awt.event.MouseEvent evt) {
            popUpCloseMouseExited(evt);
          }

          public void mousePressed(java.awt.event.MouseEvent evt) {
            popUpCloseMousePressed(evt);
          }
        });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
    setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(
                                        popUpMsg,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        300,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(160, 160, 160)
                                    .addComponent(
                                        popUpClose,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        80,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(50, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(popUpMsg)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                    .addComponent(
                        popUpClose,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        31,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)));
  }

  private void popUpCloseMouseMoved(java.awt.event.MouseEvent evt) {}

  private void popUpCloseMouseExited(java.awt.event.MouseEvent evt) {}

  public void popUpCloseMousePressed(java.awt.event.MouseEvent evt) {
    this.setVisible(false);
    repaint();
  }

  private javax.swing.JLabel popUpClose;
  private javax.swing.JLabel popUpMsg;
}
