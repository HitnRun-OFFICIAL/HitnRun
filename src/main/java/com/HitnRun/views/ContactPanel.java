package com.HitnRun.views;

import com.HitnRun.controllers.ContactPanelController;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

// Define a class called ContactPanel that extends JPanel
public class ContactPanel extends JPanel {
  private JLabel contactusLbl;
  private JLabel emailIcon;
  private JLabel emailLbl;
  private JLabel locationIcon;
  private JLabel staffInfoLbl;
  private JTable staffTable;
  private JLabel mobileLbl;
  private JLabel addr1Lbl;
  private JLabel addr2Lbl;
  private JScrollPane staffViewScroll;
  private JLabel callIcon;
  private ContactPanelController contactPanelController;

  // Constructor for the ContactPanel class
  ContactPanel() {
    // Initialize the components and view the staff table
    initComponents();
    viewTable();
  }

  // Initialize the GUI components
  void initComponents() {
    // Create an instance of the ContactPanelController
    contactPanelController = new ContactPanelController();
    // Create and configure various JLabels, fonts, and colors
    staffInfoLbl = new JLabel();
    emailLbl = new JLabel();
    mobileLbl = new JLabel();
    locationIcon = new JLabel();
    emailIcon = new JLabel();
    callIcon = new JLabel();
    addr2Lbl = new JLabel();
    contactusLbl = new JLabel();
    addr1Lbl = new JLabel();
    staffViewScroll = new JScrollPane();
    staffTable = new JTable();

    setBackground(new java.awt.Color(40, 43, 48));
    setMaximumSize(new java.awt.Dimension(1280, 768));
    setPreferredSize(new java.awt.Dimension(1280, 728));

    // Set fonts and colors for various labels
    staffInfoLbl.setFont(new java.awt.Font("Cascadia Code", 1, 24));
    staffInfoLbl.setForeground(new java.awt.Color(255, 255, 255));
    staffInfoLbl.setText("Staff Information");

    emailLbl.setFont(new java.awt.Font("Cascadia Code", 1, 18));
    emailLbl.setForeground(new java.awt.Color(255, 255, 255));
    emailLbl.setText("rentals@hitnrunvehicles.lk");

    mobileLbl.setFont(new java.awt.Font("Cascadia Code", 1, 18));
    mobileLbl.setForeground(new java.awt.Color(255, 255, 255));
    mobileLbl.setText("+94 77 123 4567");

    // Set an icon and color for locationIcon
    locationIcon.setHorizontalAlignment(SwingConstants.CENTER);
    locationIcon.setIcon(FontIcon.of(MaterialDesign.MDI_MAP_MARKER, 32, Color.WHITE));

    // Set an icon and color for emailIcon
    emailIcon.setIcon(FontIcon.of(MaterialDesign.MDI_EMAIL, 32, Color.WHITE));

    // Set an icon and color for callIcon
    callIcon.setIcon(FontIcon.of(MaterialDesign.MDI_PHONE, 32, Color.WHITE));

    addr2Lbl.setFont(new java.awt.Font("Cascadia Code", 1, 18));
    addr2Lbl.setForeground(new java.awt.Color(255, 255, 255));
    addr2Lbl.setText("Colombo 06, Sri Lanka");

    contactusLbl.setFont(new java.awt.Font("Cascadia Code", 1, 36));
    contactusLbl.setForeground(new java.awt.Color(255, 255, 255));
    contactusLbl.setText("Contact Us");

    addr1Lbl.setFont(new java.awt.Font("Cascadia Code", 1, 18));
    addr1Lbl.setForeground(new java.awt.Color(255, 255, 255));
    addr1Lbl.setText("123A, Galle Road,");

    // Create a table for displaying staff information
    staffTable.setModel(
        new DefaultTableModel(
            new Object[][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
            },
            new String[] {"Title 1", "Title 2", "Title 3", "Title 4"}));
    staffViewScroll.setViewportView(staffTable);

    // Set up the layout for this JPanel using GroupLayout
    GroupLayout contactPanelLayout = new GroupLayout(this);
    setLayout(contactPanelLayout);
    contactPanelLayout.setHorizontalGroup(
        contactPanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                contactPanelLayout
                    .createSequentialGroup()
                    .addGroup(
                        contactPanelLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                contactPanelLayout
                                    .createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addGroup(
                                        contactPanelLayout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(staffInfoLbl)
                                            .addComponent(
                                                staffViewScroll,
                                                GroupLayout.PREFERRED_SIZE,
                                                1173,
                                                GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                contactPanelLayout
                                    .createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addGroup(
                                        contactPanelLayout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(contactusLbl)
                                            .addGroup(
                                                contactPanelLayout
                                                    .createSequentialGroup()
                                                    .addComponent(locationIcon)
                                                    .addPreferredGap(
                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(
                                                        contactPanelLayout
                                                            .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                            .addComponent(addr2Lbl)
                                                            .addGroup(
                                                                contactPanelLayout
                                                                    .createSequentialGroup()
                                                                    .addComponent(addr1Lbl)
                                                                    .addGap(147, 147, 147)
                                                                    .addComponent(emailIcon)
                                                                    .addPreferredGap(
                                                                        LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(emailLbl)
                                                                    .addGap(98, 98, 98)
                                                                    .addComponent(callIcon)
                                                                    .addPreferredGap(
                                                                        LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(mobileLbl)))))))
                    .addContainerGap(53, Short.MAX_VALUE)));
    contactPanelLayout.setVerticalGroup(
        contactPanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                contactPanelLayout
                    .createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(
                        contactPanelLayout
                            .createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                contactPanelLayout
                                    .createSequentialGroup()
                                    .addComponent(contactusLbl)
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        contactPanelLayout
                                            .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(locationIcon)
                                            .addComponent(addr1Lbl)
                                            .addComponent(emailIcon)
                                            .addComponent(emailLbl)
                                            .addComponent(callIcon)))
                            .addComponent(mobileLbl))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(addr2Lbl)
                    .addGap(36, 36, 36)
                    .addComponent(staffInfoLbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        staffViewScroll,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)));
  }

  // Method to populate and display the staff information in the table
  private void viewTable() {
    // Retrieve staff information from the controller
    Object[][] staffs = contactPanelController.getStaffs();
    // Set the data and column names for the staff table
    staffTable.setModel(
        new DefaultTableModel(
            staffs, new String[] {"FirstName", "LastName", "Email", "Phone", "Position"}));
  }
}
