package com.HitnRun.views;

import com.HitnRun.controllers.VehiclePanelController;
import com.HitnRun.models.VehicleDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @author 5H4D0W */
public class VehiclePanel extends javax.swing.JPanel {
  private javax.swing.JLabel color;
  private javax.swing.JLabel colorLbl;
  private javax.swing.JLabel description;
  private javax.swing.JLabel descriptionLbl;
  private JLabel rating;
  private JLabel ratingLbl;
  private JLabel rent;
  private JLabel rentLbl;
  private javax.swing.JLabel img;
  private javax.swing.JPanel itemPanel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel make;
  private javax.swing.JComboBox<String> makeCombo;
  private javax.swing.JLabel makeLbl;
  private javax.swing.JLabel model;
  private javax.swing.JComboBox<String> modelCombo;
  private javax.swing.JLabel modelLbl;
  private javax.swing.JLabel rentBtn;
  private javax.swing.JTextField searchBar;
  private javax.swing.JLabel year;
  private javax.swing.JLabel yearLbl;
  private GridLayout gridLayout;
  private VehiclePanelController vehiclePanelController;
  private VehicleItem oldItem;

  public VehiclePanel() {
    initComponents();
    viewItems();
  }

  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    img = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    makeLbl = new javax.swing.JLabel();
    make = new javax.swing.JLabel();
    modelLbl = new javax.swing.JLabel();
    model = new javax.swing.JLabel();
    yearLbl = new javax.swing.JLabel();
    year = new javax.swing.JLabel();
    colorLbl = new javax.swing.JLabel();
    color = new javax.swing.JLabel();
    descriptionLbl = new javax.swing.JLabel();
    description = new javax.swing.JLabel();
    rentLbl = new JLabel();
    rent = new JLabel();
    ratingLbl = new JLabel();
    rating = new JLabel();
    rentBtn = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    searchBar = new javax.swing.JTextField();
    modelCombo = new javax.swing.JComboBox<>();
    makeCombo = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    itemPanel = new javax.swing.JPanel();
    vehiclePanelController = new VehiclePanelController();
    gridLayout = new GridLayout(0, 3);

    setBackground(new java.awt.Color(40, 43, 48));
    setMaximumSize(new java.awt.Dimension(1280, 728));
    setMinimumSize(new java.awt.Dimension(1280, 728));
    setPreferredSize(new java.awt.Dimension(1280, 728));

    jPanel1.setBackground(new java.awt.Color(50, 53, 58));

    img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    jPanel3.setBackground(new java.awt.Color(50, 53, 58));

    makeLbl.setForeground(new java.awt.Color(115, 138, 219));
    makeLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    makeLbl.setText("Make");

    make.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    make.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

    modelLbl.setForeground(new java.awt.Color(115, 138, 219));
    modelLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    modelLbl.setText("Model");

    model.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    model.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

    yearLbl.setForeground(new java.awt.Color(115, 138, 219));
    yearLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    yearLbl.setText("Year");

    year.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    year.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

    colorLbl.setForeground(new java.awt.Color(115, 138, 219));
    colorLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    colorLbl.setText("Color");

    color.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    color.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

    rentLbl.setForeground(new java.awt.Color(115, 138, 219));
    rentLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    rentLbl.setText("Rent");

    rent.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    rent.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

    ratingLbl.setForeground(new java.awt.Color(115, 138, 219));
    ratingLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    ratingLbl.setText("Rating");

    rating.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    rating.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

    descriptionLbl.setForeground(new java.awt.Color(115, 138, 219));
    descriptionLbl.setFont(new java.awt.Font("Cascadia Code", 1, 14));
    descriptionLbl.setText("Description");

    description.setFont(new java.awt.Font("Cascadia Code", 0, 15));
    description.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

    rentBtn.setBackground(new java.awt.Color(102, 102, 255));
    rentBtn.setForeground(new java.awt.Color(255, 255, 255));
    rentBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    rentBtn.setText("RENT");
    rentBtn.setOpaque(true);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(
                                                rentLbl,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                125,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                ratingLbl,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                rent,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                rating,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)))
                            .addComponent(
                                descriptionLbl,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                model,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                makeLbl,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                make,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                modelLbl,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(
                                                colorLbl,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                125,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                yearLbl,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                year,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                color,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)))
                            .addComponent(
                                description,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addContainerGap())
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(
                        rentBtn,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        65,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(makeLbl)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(make)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(modelLbl)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(model)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearLbl)
                            .addComponent(year))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colorLbl)
                            .addComponent(color))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(descriptionLbl)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(description)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rentLbl)
                            .addComponent(rent))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ratingLbl)
                            .addComponent(rating))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addComponent(
                        rentBtn,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        37,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
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
                                    .addContainerGap()
                                    .addComponent(
                                        img,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        313,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(
                                        jPanel3,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        img,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        240,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jPanel3,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    searchBar.setText("Search for vehicle...");

    modelCombo.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {"Model", "Item 2", "Item 3", "Item 4"}));

    makeCombo.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {"Make", "Item 2", "Item 3", "Item 4"}));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        makeCombo,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        144,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        modelCombo,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        144,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        searchBar,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        201,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                searchBar,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                modelCombo,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                makeCombo,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)));

    jScrollPane1.setBackground(new java.awt.Color(50, 53, 58));
    jScrollPane1.setBorder(null);
    jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
    jScrollPane1.setHorizontalScrollBarPolicy(
        javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(
        javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);

    itemPanel.setBackground(new java.awt.Color(50, 53, 58));

    itemPanel.setLayout(gridLayout);

    jScrollPane1.setViewportView(itemPanel);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel2,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        900,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addComponent(
                        jPanel2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        42,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                jPanel1,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                    .addGap(22, 22, 22)));
  }

  private void viewItems() {
    List<VehicleDTO> list = vehiclePanelController.getVehicles();
    for (int i = 0; i < list.size(); i += 3) {
      gridLayout.setRows(gridLayout.getRows() + 1);
      JPanel testPanel = new JPanel();
      testPanel.setBackground(new Color(62, 65, 67));
      testPanel.setPreferredSize(new Dimension(900, 375));
      for (int j = i; j < i + 3; j++) {
        testPanel.add(
            new VehicleItem(list.get(j)) {
              public void itemMousePressed(MouseEvent evt) {
                preview(this);
                this.setBackground(new Color(50, 53, 58));
              }
            });
      }

      itemPanel.add(testPanel);
    }
    preview(new VehicleItem(list.get(0)));
  }

  void preview(VehicleItem vi) {
    if (oldItem != vi && oldItem != null) {
      oldItem.setBackground(new Color(30, 33, 38));
    }
    oldItem = vi;
    VehicleDTO v = oldItem.getVehicle();
    img.setIcon(
        new ImageIcon(
            new ImageIcon(getClass().getResource(v.getImagePath()))
                .getImage()
                .getScaledInstance(313, 240, Image.SCALE_SMOOTH)));
    make.setText(v.getMake());
    model.setText(v.getModel());
    year.setText(String.valueOf(v.getYear()));
    color.setText(v.getColor());
    description.setText(v.getDescription());
    rent.setText(String.valueOf(v.getRent()));
    rating.setText(String.valueOf(v.getRating()));
  }
}
