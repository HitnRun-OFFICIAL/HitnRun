package com.HitnRun.views;

import com.HitnRun.models.VehicleDTO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class VehicleItem extends javax.swing.JPanel {
  private javax.swing.JLabel img;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel make;
  private javax.swing.JLabel model;
  private javax.swing.JLabel rent;
  private javax.swing.JLabel status;
  private javax.swing.JLabel year;
  private VehicleDTO vehicle;

  public VehicleItem(VehicleDTO vehicle) {
    this.vehicle = vehicle;
    initComponents();
  }

  private void initComponents() {

    status =
        new javax.swing.JLabel() {
          protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
          }
        };
    jPanel1 = new javax.swing.JPanel();
    img = new javax.swing.JLabel();
    make = new javax.swing.JLabel();
    model = new javax.swing.JLabel();
    year = new javax.swing.JLabel();
    rent = new javax.swing.JLabel();

    setBackground(new java.awt.Color(30, 33, 38));
    setMaximumSize(new java.awt.Dimension(225, 300));
    setMinimumSize(new java.awt.Dimension(225, 300));
    addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            itemMousePressed(evt);
          }
        });

    jPanel1.setOpaque(false);

    img.setBackground(new java.awt.Color(40, 43, 48));
    img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    img.setIcon(
        new ImageIcon(
            new ImageIcon(getClass().getResource(vehicle.getImagePath()))
                .getImage()
                .getScaledInstance(219, 201, Image.SCALE_SMOOTH)));
    img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

    make.setText(vehicle.getMake());

    model.setText(vehicle.getModel());

    year.setText(String.valueOf(vehicle.getYear()));

    rent.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    rent.setText(String.valueOf(vehicle.getRent()));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
            .addGroup(
                jPanel1Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        jPanel1Layout
                            .createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(
                                jPanel1Layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(
                                        make,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        model,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        jPanel1Layout
                                            .createSequentialGroup()
                                            .addComponent(
                                                year,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                67,
                                                Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(
                                                rent,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                82,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32))
                    .addComponent(
                        img, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(
                jPanel1Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        jPanel1Layout
                            .createSequentialGroup()
                            .addComponent(
                                img,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                201,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(make)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(model)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel1Layout
                                    .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(
                                        year,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        rent,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        19,
                                        Short.MAX_VALUE))
                            .addContainerGap(12, Short.MAX_VALUE))));

    status.setOpaque(true);
    status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    status.setBackground(new Color(0, 0, 0));
    status.setText("Unavailable");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)));
  }

  public void itemMousePressed(MouseEvent evt) {}

  public void markUnavailable(boolean visible) {
    status.setVisible(visible);
  }

  public VehicleDTO getVehicle() {
    return vehicle;
  }
}
