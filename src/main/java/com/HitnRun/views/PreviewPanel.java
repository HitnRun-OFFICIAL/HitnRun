package com.HitnRun.views;

import com.HitnRun.controllers.RentalController;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.utils.Authenticator;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;

public class PreviewPanel extends JPanel {
  private JFrame parent;
  private JLabel color;
  private JLabel colorLbl;
  private JLabel description;
  private JLabel descriptionLbl;
  private JLabel rating;
  private JLabel ratingLbl;
  private JLabel rent;
  private JLabel rentLbl;
  private JLabel img;
  private JLabel make;
  private JLabel makeLbl;
  private JLabel model;
  private JLabel modelLbl;
  private JLabel year;
  private JLabel yearLbl;
  private Button rentBtn;
  private JPanel jPanel3;
  private int id;
  private double rentFee;
  private RentalController rentalController;

  // constructor
  PreviewPanel(JFrame parent) {
    this.parent = parent;
    initComponents();
  }

  // Initialize login components
  private void initComponents() {
    id = 0;
    rentFee = 0;
    // Create JLabels and other UI components.
    img = new JLabel();
    makeLbl = new JLabel();
    make = new JLabel();
    modelLbl = new JLabel();
    model = new JLabel();
    yearLbl = new JLabel();
    year = new JLabel();
    colorLbl = new JLabel();
    color = new JLabel();
    descriptionLbl = new JLabel();
    description = new JLabel();
    rentLbl = new JLabel();
    rent = new JLabel();
    ratingLbl = new JLabel();
    rating = new JLabel();
    // Create a new RentalController instance for handling rental operations.
    rentalController = new RentalController();
    // Create a custom button ("RENT") with mouse press event handling.
    rentBtn =
        new Button("RENT") {
          public void btnMousePressed(MouseEvent evt) {
            // Display a date selection panel.
            JPanel panel = new JPanel();

            SpinnerModel startDateModel =
                new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
            SpinnerModel endDateModel =
                new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
            JSpinner startDateSpinner = new JSpinner(startDateModel);
            JSpinner endDateSpinner = new JSpinner(endDateModel);

            panel.add(startDateSpinner);
            panel.add(endDateSpinner);

            // Show a confirmation dialog to select date range.
            int result =
                JOptionPane.showConfirmDialog(
                    parent, panel, "Select Date Range", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
              java.sql.Date startDate =
                  new java.sql.Date(((Date) startDateSpinner.getValue()).getTime());
              java.sql.Date endDate =
                  new java.sql.Date(((Date) endDateSpinner.getValue()).getTime());

              // Perform the rental operation by calling the rentalController.
              rentalController.rent(
                  new RentalDTO(
                      Authenticator.getProfile().getCustomerID(), id, startDate, endDate, rentFee));
            }
          }
        };

    // Create a JPanel for additional layout and styling.
    jPanel3 = new JPanel();

    jPanel3.setBackground(new java.awt.Color(50, 53, 58));
    // Configure the layout and styling of various components.
    // (Code for layout, colors, fonts, and component positioning)

    img.setHorizontalAlignment(SwingConstants.CENTER);

    makeLbl.setForeground(new java.awt.Color(115, 138, 219));
    makeLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    makeLbl.setText("Make");

    make.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    make.setHorizontalAlignment(SwingConstants.TRAILING);

    modelLbl.setForeground(new java.awt.Color(115, 138, 219));
    modelLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    modelLbl.setText("Model");

    model.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    model.setHorizontalAlignment(SwingConstants.TRAILING);

    yearLbl.setForeground(new java.awt.Color(115, 138, 219));
    yearLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    yearLbl.setText("Year");

    year.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    year.setHorizontalAlignment(SwingConstants.TRAILING);

    colorLbl.setForeground(new java.awt.Color(115, 138, 219));
    colorLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    colorLbl.setText("Color");

    color.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    color.setHorizontalAlignment(SwingConstants.TRAILING);

    rentLbl.setForeground(new java.awt.Color(115, 138, 219));
    rentLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    rentLbl.setText("Rent");

    rent.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    rent.setHorizontalAlignment(SwingConstants.TRAILING);

    ratingLbl.setForeground(new java.awt.Color(115, 138, 219));
    ratingLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    ratingLbl.setText("Rating");

    rating.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    rating.setHorizontalAlignment(SwingConstants.TRAILING);

    descriptionLbl.setForeground(new java.awt.Color(115, 138, 219));
    descriptionLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    descriptionLbl.setText("Description");

    description.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    description.setHorizontalAlignment(SwingConstants.TRAILING);

    GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(
                                                GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(
                                                rentLbl,
                                                GroupLayout.Alignment.LEADING,
                                                GroupLayout.DEFAULT_SIZE,
                                                125,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                ratingLbl,
                                                GroupLayout.Alignment.LEADING,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                rent,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                rating,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)))
                            .addComponent(
                                descriptionLbl,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                model,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                makeLbl,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                make,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                modelLbl,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(
                                                GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(
                                                colorLbl,
                                                GroupLayout.Alignment.LEADING,
                                                GroupLayout.DEFAULT_SIZE,
                                                125,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                yearLbl,
                                                GroupLayout.Alignment.LEADING,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                year,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                color,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)))
                            .addComponent(
                                description,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addContainerGap())
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(
                        rentBtn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(makeLbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(make)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(modelLbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(model)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(yearLbl)
                            .addComponent(year))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(colorLbl)
                            .addComponent(color))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(descriptionLbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(description)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(rentLbl)
                            .addComponent(rent))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(ratingLbl)
                            .addComponent(rating))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addComponent(
                        rentBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)));
    this.setBackground(new java.awt.Color(50, 53, 58));

    GroupLayout jPanel1Layout = new GroupLayout(this);
    this.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(
                                        img,
                                        GroupLayout.PREFERRED_SIZE,
                                        313,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(
                                        jPanel3,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(img, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jPanel3,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setColor(String color) {
    this.color.setText(color);
  }

  public void setDescription(String description) {
    this.description.setText(description);
  }

  public void setRating(double rating) {
    this.rating.setText(String.valueOf(rating));
  }

  public void setRent(double rent) {
    rentFee = rent;
    this.rent.setText(String.valueOf(rent));
  }

  public void setImg(String img) {
    this.img.setIcon(
        new ImageIcon(
            new ImageIcon(getClass().getResource(img))
                .getImage()
                .getScaledInstance(313, 240, Image.SCALE_SMOOTH)));
  }

  public void setMake(String make) {
    this.make.setText(make);
  }

  public void setModel(String model) {
    this.model.setText(model);
  }

  public void setYear(int string) {
    this.year.setText(String.valueOf(string));
  }
}
