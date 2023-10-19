package com.HitnRun.views;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class AboutPanel extends JPanel {
  private JLabel aboutUsLbl;
  private JLabel abt1Lbl;
  private JLabel abt2Lbl;
  private JLabel abt3Lbl;
  private JLabel abt4Lbl;

  AboutPanel() {
    aboutUsLbl = new JLabel();
    abt2Lbl = new JLabel();
    abt1Lbl = new JLabel();
    abt3Lbl = new JLabel();
    abt4Lbl = new JLabel();

    setBackground(new java.awt.Color(40, 43, 48));
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setMaximumSize(new java.awt.Dimension(1280, 728));
    setMinimumSize(new java.awt.Dimension(1280, 728));

    aboutUsLbl.setFont(new java.awt.Font("Cascadia Code", 1, 36)); // NOI18N
    aboutUsLbl.setForeground(new java.awt.Color(255, 255, 255));
    aboutUsLbl.setText("About Us");

    abt2Lbl.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
    abt2Lbl.setForeground(new java.awt.Color(255, 255, 255));
    abt2Lbl.setText(
        "experiences. Our mission is to redefine how people explore the world, offering a diverse fleet, easy");

    abt1Lbl.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
    abt1Lbl.setForeground(new java.awt.Color(255, 255, 255));
    abt1Lbl.setText(
        "Hit n Run is your go-to vehicle rental company, founded in 2020 to provide unique and memorable travel");

    abt3Lbl.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
    abt3Lbl.setForeground(new java.awt.Color(255, 255, 255));
    abt3Lbl.setText(
        "booking, exceptional service, safety, customized experiences, and competitive pricing. We're committed");

    abt4Lbl.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
    abt4Lbl.setForeground(new java.awt.Color(255, 255, 255));
    abt4Lbl.setText(
        "to making your journey an unforgettable adventure, and we're ready to help you hit the road in style.");

    GroupLayout aboutPanelLayout = new GroupLayout(this);
    setLayout(aboutPanelLayout);
    aboutPanelLayout.setHorizontalGroup(
        aboutPanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                aboutPanelLayout
                    .createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(
                        aboutPanelLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(abt4Lbl)
                            .addComponent(abt3Lbl)
                            .addComponent(abt2Lbl)
                            .addComponent(abt1Lbl)
                            .addComponent(aboutUsLbl))
                    .addGap(0, 0, Short.MAX_VALUE)));
    aboutPanelLayout.setVerticalGroup(
        aboutPanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                aboutPanelLayout
                    .createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(aboutUsLbl)
                    .addGap(44, 44, 44)
                    .addComponent(abt1Lbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(abt2Lbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(abt3Lbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(abt4Lbl)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
  }
}
