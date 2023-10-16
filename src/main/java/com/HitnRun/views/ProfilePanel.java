package com.HitnRun.views;

import com.HitnRun.controllers.ProfilePanelController;
import com.HitnRun.models.CustomerDTO;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

public class ProfilePanel extends JPanel {
  private JLabel myBookingsLbl;
  private JLabel profileIcon;
  private JLabel profileName;
  private JPanel jPanel11;
  private JLabel profileRentalDate;
  private JLabel profileRentalDateLbl;
  private JLabel profileReturnDate;
  private JLabel profileReturnDateLbl;
  private JLabel profileVehicleImg;
  private JLabel profileVehicleName;
  private ProfilePanelController profilePanelController;

  ProfilePanel() {
    initComponents();
    viewCustomer();
  }

  void initComponents() {
    jPanel11 = new JPanel();
    myBookingsLbl = new JLabel();
    profileIcon = new JLabel();
    profileName = new JLabel();
    profileVehicleImg = new JLabel();
    profileVehicleName = new JLabel();
    profileRentalDateLbl = new JLabel();
    profileReturnDateLbl = new JLabel();
    profileRentalDate = new JLabel();
    profileReturnDate = new JLabel();
    profilePanelController = new ProfilePanelController();

    setBackground(new java.awt.Color(40, 43, 48));
    setMaximumSize(new java.awt.Dimension(1280, 728));
    setMinimumSize(new java.awt.Dimension(1280, 728));

    myBookingsLbl.setFont(new java.awt.Font("Cascadia Code", 1, 36));
    myBookingsLbl.setForeground(new java.awt.Color(255, 255, 255));
    myBookingsLbl.setText("My Bookings");

    profileIcon.setIcon(FontIcon.of(MaterialDesign.MDI_ACCOUNT_BOX, 64, Color.WHITE));

    profileName.setFont(new java.awt.Font("Cascadia Code", 1, 18));
    profileName.setForeground(new java.awt.Color(255, 255, 255));
    profileName.setText("[Profile Name]");

    jPanel11.setBackground(new java.awt.Color(0, 0, 0));

    profileVehicleImg.setBackground(new java.awt.Color(255, 255, 255));
    profileVehicleImg.setForeground(new java.awt.Color(255, 255, 255));
    profileVehicleImg.setHorizontalAlignment(SwingConstants.CENTER);
    profileVehicleImg.setText("[Vehicle Image]");

    profileVehicleName.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    profileVehicleName.setForeground(new java.awt.Color(255, 255, 255));
    profileVehicleName.setText("[Vehicle Name]");

    profileRentalDateLbl.setFont(new java.awt.Font("Cascadia Code", 1, 18));
    profileRentalDateLbl.setForeground(new java.awt.Color(255, 255, 255));
    profileRentalDateLbl.setText("Rental Date:");
    profileRentalDateLbl.setToolTipText("");

    profileReturnDateLbl.setFont(new java.awt.Font("Cascadia Code", 1, 18));
    profileReturnDateLbl.setForeground(new java.awt.Color(255, 255, 255));
    profileReturnDateLbl.setText("Return Date:");

    profileRentalDate.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    profileRentalDate.setForeground(new java.awt.Color(255, 255, 255));
    profileRentalDate.setText("[Rental Date]");
    profileRentalDate.setToolTipText("");

    profileReturnDate.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    profileReturnDate.setForeground(new java.awt.Color(255, 255, 255));
    profileReturnDate.setText("[Return Date]");
    profileReturnDate.setToolTipText("");

    GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel11Layout
                    .createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(
                        profileVehicleImg,
                        GroupLayout.PREFERRED_SIZE,
                        295,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel11Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(profileVehicleName)
                            .addComponent(profileRentalDateLbl)
                            .addComponent(profileRentalDate))
                    .addGap(34, 34, 34)
                    .addGroup(
                        jPanel11Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(profileReturnDateLbl)
                            .addComponent(profileReturnDate))
                    .addContainerGap(558, Short.MAX_VALUE)));
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel11Layout
                    .createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(
                        profileVehicleImg,
                        GroupLayout.PREFERRED_SIZE,
                        320,
                        GroupLayout.PREFERRED_SIZE))
            .addGroup(
                jPanel11Layout
                    .createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(profileVehicleName)
                    .addGap(32, 32, 32)
                    .addComponent(profileRentalDateLbl)
                    .addGap(6, 6, 6)
                    .addComponent(profileRentalDate))
            .addGroup(
                jPanel11Layout
                    .createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(profileReturnDateLbl)
                    .addGap(6, 6, 6)
                    .addComponent(profileReturnDate)));

    GroupLayout profilePanelLayout = new GroupLayout(this);
    setLayout(profilePanelLayout);
    profilePanelLayout.setHorizontalGroup(
        profilePanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                profilePanelLayout
                    .createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(
                        profilePanelLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(myBookingsLbl)
                            .addGroup(
                                profilePanelLayout
                                    .createSequentialGroup()
                                    .addComponent(profileIcon)
                                    .addGap(33, 33, 33)
                                    .addComponent(profileName)))
                    .addContainerGap(981, Short.MAX_VALUE))
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                profilePanelLayout
                    .createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        jPanel11,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    profilePanelLayout.setVerticalGroup(
        profilePanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                profilePanelLayout
                    .createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(myBookingsLbl)
                    .addGroup(
                        profilePanelLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                profilePanelLayout
                                    .createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(profileIcon))
                            .addGroup(
                                profilePanelLayout
                                    .createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addComponent(profileName)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                    .addComponent(
                        jPanel11,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(62, 62, 62)));
  }

  private void viewCustomer() {
    CustomerDTO p = profilePanelController.getCustomer();
    profileName.setText(p.getFirstName() + " " + p.getLastName());
  }
}
