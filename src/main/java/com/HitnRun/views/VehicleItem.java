package com.HitnRun.views;

import com.HitnRun.models.VehicleDTO;
import java.awt.Color;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class VehicleItem extends JPanel {
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private Color bg;
  private VehicleDTO vehicle;
  private VehiclePanel vehiclePanel;

  public VehicleItem(VehicleDTO vehicle, VehiclePanel vehiclePanel) {
    this.vehicle = vehicle;
    this.vehiclePanel = vehiclePanel;
    initComponents();
  }

  private void initComponents() {

    jLabel1 = new JLabel();
    jLabel2 = new JLabel();
    jLabel3 = new JLabel();
    jLabel4 = new JLabel();
    jLabel5 = new JLabel();
    bg = new Color(0, 0, 0);

    setMaximumSize(new java.awt.Dimension(246, 325));
    setMinimumSize(new java.awt.Dimension(246, 325));
    setBackground(bg);
    setForeground(new Color(255, 255, 255));
    setPreferredSize(new java.awt.Dimension(275, 325));
    addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            formMousePressed(evt);
          }
        });

    jLabel1.setText(vehicle.getMake());
    jLabel1.setForeground(new Color(255, 255, 255));

    jLabel2.setText(vehicle.getModel());
    jLabel2.setForeground(new Color(255, 255, 255));

    jLabel3.setText(String.valueOf(vehicle.getRating()));
    jLabel3.setForeground(new Color(255, 255, 255));

    jLabel4.setText(String.valueOf(vehicle.getRent()));
    jLabel4.setForeground(new Color(255, 255, 255));

    jLabel5.setIcon(
        new ImageIcon(
            new ImageIcon(getClass().getResource(vehicle.getImagePath()))
                .getImage()
                .getScaledInstance(240, 200, Image.SCALE_SMOOTH)));
    jLabel5.setVerticalAlignment(SwingConstants.CENTER);
    jLabel5.setHorizontalAlignment(SwingConstants.CENTER);

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        jLabel5,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addContainerGap())
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        126,
                                        Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addGap(21, 21, 21))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(0, 0, Short.MAX_VALUE)))));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        jLabel5,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addGap(12, 12, 12)));
  }

  public Color getBg() {
    return bg;
  }

  public void setBg(Color bg) {
    this.bg = bg;
    setBackground(bg);
  }

  public VehicleDTO getVehicle() {
    return vehicle;
  }

  public void setVehicle(VehicleDTO vehicle) {
    this.vehicle = vehicle;
  }

  private void formMousePressed(java.awt.event.MouseEvent evt) {
    this.setBackground(Color.WHITE);
    vehiclePanel.preview(this);
  }
}
