package com.HitnRun.views;

import com.HitnRun.controllers.ProfilePanelController;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.models.VehicleDTO;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;

public class HistoryItem extends javax.swing.JPanel {

  private javax.swing.JLabel color;
  private javax.swing.JLabel description;
  private javax.swing.JLabel fee;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel make;
  private javax.swing.JLabel model;
  private javax.swing.JLabel rentedOn;
  private javax.swing.JLabel vehicleImg;
  private javax.swing.JLabel year;
  private RentalDTO rental;
  private ProfilePanelController profilePanelController;

  public HistoryItem(RentalDTO rental) {
    this.rental = rental;
    initComponents();
    viewItem();
  }

  private void initComponents() {

    vehicleImg = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    make = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    model = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    year = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    color = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    description = new javax.swing.JLabel();
    fee = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    rentedOn = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    profilePanelController = new ProfilePanelController();

    setBackground(new java.awt.Color(35, 35, 35));
    setMaximumSize(new java.awt.Dimension(900, 265));
    setMinimumSize(new java.awt.Dimension(900, 265));
    setPreferredSize(new java.awt.Dimension(900, 265));

    vehicleImg.setMaximumSize(new java.awt.Dimension(265, 265));
    vehicleImg.setMinimumSize(new java.awt.Dimension(265, 265));
    vehicleImg.setPreferredSize(new java.awt.Dimension(265, 265));

    jLabel3.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(115, 132, 219));
    jLabel3.setText("Make");

    make.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    make.setForeground(new java.awt.Color(255, 255, 255));

    jLabel4.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(115, 132, 219));
    jLabel4.setText("Model");

    model.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    model.setForeground(new java.awt.Color(255, 255, 255));

    jLabel5.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(115, 132, 219));
    jLabel5.setText("Year");

    year.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    year.setForeground(new java.awt.Color(255, 255, 255));

    jLabel6.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(115, 132, 219));
    jLabel6.setText("Color");

    color.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    color.setForeground(new java.awt.Color(255, 255, 255));

    jLabel11.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(115, 132, 219));
    jLabel11.setText("Description");

    description.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    description.setForeground(new java.awt.Color(255, 255, 255));

    fee.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    fee.setForeground(new java.awt.Color(255, 255, 255));

    jLabel13.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(115, 132, 219));
    jLabel13.setText("Fee");

    rentedOn.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    rentedOn.setForeground(new java.awt.Color(255, 255, 255));

    jLabel14.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(115, 132, 219));
    jLabel14.setText("Rented on");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        vehicleImg,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                    .addGap(27, 27, 27)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(model)
                                            .addComponent(make))
                                    .addGap(56, 56, 56)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                    .addGap(27, 27, 27)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(year)
                                            .addComponent(color))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        30,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13))
                                    .addGap(36, 36, 36)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fee)
                                            .addComponent(rentedOn))
                                    .addGap(30, 30, 30))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(description))
                                    .addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                vehicleImg,
                javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(
                                        layout
                                            .createSequentialGroup()
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel5)
                                                    .addComponent(year))
                                            .addGap(18, 18, 18)
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(color)))
                                    .addGroup(
                                        layout
                                            .createSequentialGroup()
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(make))
                                            .addGap(18, 18, 18)
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(model))))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(fee))
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(rentedOn))))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel11)
                    .addGap(18, 18, 18)
                    .addComponent(description)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
  }

  public void viewItem() {
    List<RentalDTO> rentals = profilePanelController.getRentals();
    for (RentalDTO rental : rentals) {
      VehicleDTO vehicle = profilePanelController.getVehicle(rental.getVehicleID());
      vehicleImg.setIcon(
          new ImageIcon(
              new ImageIcon(getClass().getResource(vehicle.getImagePath()))
                  .getImage()
                  .getScaledInstance(265, 265, Image.SCALE_SMOOTH)));
      make.setText(vehicle.getMake());
      model.setText(vehicle.getModel());
      year.setText(String.valueOf(vehicle.getYear()));
      color.setText(vehicle.getColor());
      description.setText(vehicle.getDescription());
      fee.setText(String.valueOf(rental.getRentalFee()));
      rentedOn.setText(rental.getRentalDate().toString());
    }
  }
}
