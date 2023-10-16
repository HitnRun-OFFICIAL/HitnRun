package com.HitnRun.views;

import com.HitnRun.controllers.VehiclePanelController;
import com.HitnRun.models.VehicleDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/** @author 5H4D0W */
public class VehiclePanel extends JPanel {

  private JLabel description;
  private JLabel descriptionLbl;
  private JLabel jLabel1;
  private JPanel jPanel1;
  private JPanel itemView;
  private JPanel jPanel3;
  private JScrollPane jScrollPane1;
  private JLabel make;
  private JComboBox<String> makeCombo;
  private JLabel makeLbl;
  private JLabel model;
  private JComboBox<String> modelCombo;
  private JLabel modelLbl;
  private JLabel rating;
  private JLabel ratingLbl;
  private JLabel rent;
  private JTextField searchBar;
  private JPanel searchTop;
  private JLabel vehiclePreImg;
  private GridLayout gridLayout;
  private VehiclePanelController vehiclePanelController;
  private VehicleItem oldItem;

  public VehiclePanel() {
    initComponents();
    viewItems();
  }

  private void initComponents() {

    searchTop = new JPanel();
    makeCombo = new JComboBox<>();
    modelCombo = new JComboBox<>();
    searchBar = new JTextField();
    jScrollPane1 = new JScrollPane();
    itemView = new JPanel();
    jPanel3 = new JPanel();
    vehiclePreImg = new JLabel();
    descriptionLbl = new JLabel();
    makeLbl = new JLabel();
    modelLbl = new JLabel();
    ratingLbl = new JLabel();
    make = new JLabel();
    model = new JLabel();
    rating = new JLabel();
    description = new JLabel();
    rent = new JLabel();
    jPanel1 = new JPanel();
    jLabel1 = new JLabel();
    gridLayout = new GridLayout(0, 3, 10, 0);
    vehiclePanelController = new VehiclePanelController();

    setBackground(new Color(62, 65, 67));
    setMaximumSize(new Dimension(1280, 728));
    setMinimumSize(new Dimension(1280, 728));
    setPreferredSize(new Dimension(1280, 728));

    searchTop.setBackground(new Color(18, 18, 20));
    searchTop.setPreferredSize(new Dimension(1280, 40));

    makeCombo.setModel(
        new DefaultComboBoxModel<>(new String[] {"Item 1", "Item 2", "Item 3", "Item 4"}));

    modelCombo.setModel(
        new DefaultComboBoxModel<>(new String[] {"Item 1", "Item 2", "Item 3", "Item 4"}));

    searchBar.setText("jTextField1");

    GroupLayout searchTopLayout = new GroupLayout(searchTop);
    searchTop.setLayout(searchTopLayout);
    searchTopLayout.setHorizontalGroup(
        searchTopLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                searchTopLayout
                    .createSequentialGroup()
                    .addContainerGap(990, Short.MAX_VALUE)
                    .addComponent(
                        makeCombo,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        modelCombo,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        searchBar,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)));
    searchTopLayout.setVerticalGroup(
        searchTopLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                searchTopLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        searchTopLayout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                makeCombo,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                modelCombo,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                searchBar,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(0, Short.MAX_VALUE)));

    jScrollPane1.setBorder(null);
    jScrollPane1.setBackground(new Color(62, 65, 67));
    jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
    jScrollPane1.setMaximumSize(new Dimension(875, 680));
    jScrollPane1.setMinimumSize(new Dimension(875, 680));
    jScrollPane1.setPreferredSize(new Dimension(875, 680));

    itemView.setBackground(new Color(62, 65, 67));
    itemView.setMinimumSize(new Dimension(875, 680));
    itemView.setLayout(gridLayout);
    jScrollPane1.setViewportView(itemView);

    jPanel3.setBackground(new Color(18, 18, 20));
    jPanel3.setPreferredSize(new Dimension(400, 688));

    vehiclePreImg.setVerticalAlignment(SwingConstants.CENTER);
    vehiclePreImg.setHorizontalAlignment(SwingConstants.CENTER);
    vehiclePreImg.setPreferredSize(new Dimension(400, 400));
    vehiclePreImg.setIcon(
        new ImageIcon(
            new ImageIcon(getClass().getResource("/img/cars.png"))
                .getImage()
                .getScaledInstance(400, 400, Image.SCALE_SMOOTH)));

    descriptionLbl.setText("Description :");
    descriptionLbl.setForeground(Color.WHITE);

    makeLbl.setText("Make :");
    makeLbl.setForeground(Color.WHITE);

    modelLbl.setText("Model :");
    modelLbl.setForeground(Color.WHITE);

    ratingLbl.setText("Rating :");
    ratingLbl.setForeground(Color.WHITE);

    jLabel1.setText("Rent");
    jLabel1.setBackground(Color.WHITE);

    make.setForeground(Color.WHITE);
    model.setForeground(Color.WHITE);
    rating.setForeground(Color.WHITE);
    rent.setForeground(Color.WHITE);
    description.setForeground(Color.WHITE);

    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
            .addGroup(
                jPanel1Layout
                    .createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(
                        jPanel1Layout
                            .createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(0, 0, Short.MAX_VALUE))));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(
                jPanel1Layout
                    .createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(
                        jPanel1Layout
                            .createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(0, 0, Short.MAX_VALUE))));

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
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                vehiclePreImg,
                                                GroupLayout.Alignment.TRAILING,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                description,
                                                GroupLayout.Alignment.TRAILING,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addGroup(
                                                jPanel3Layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        jPanel3Layout
                                                            .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                            .addGroup(
                                                                jPanel3Layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(makeLbl)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(make))
                                                            .addComponent(descriptionLbl))
                                                    .addGap(0, 276, Short.MAX_VALUE)))
                                    .addContainerGap())
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                jPanel3Layout
                                                    .createSequentialGroup()
                                                    .addComponent(ratingLbl)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rating))
                                            .addGroup(
                                                jPanel3Layout
                                                    .createSequentialGroup()
                                                    .addComponent(modelLbl)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(model)))
                                    .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                jPanel1,
                                                GroupLayout.Alignment.TRAILING,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                rent,
                                                GroupLayout.Alignment.TRAILING,
                                                GroupLayout.PREFERRED_SIZE,
                                                71,
                                                GroupLayout.PREFERRED_SIZE))
                                    .addGap(50, 50, 50)))));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addComponent(
                        vehiclePreImg,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(descriptionLbl)
                    .addGap(18, 18, 18)
                    .addComponent(
                        description, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        rent,
                                        GroupLayout.PREFERRED_SIZE,
                                        28,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        jPanel1,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25))
                            .addGroup(
                                jPanel3Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(makeLbl)
                                            .addComponent(make))
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(modelLbl)
                                            .addComponent(model))
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        jPanel3Layout
                                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(ratingLbl)
                                            .addComponent(rating))
                                    .addGap(61, 61, 61)))));

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(searchTop, GroupLayout.PREFERRED_SIZE, 1280, GroupLayout.PREFERRED_SIZE)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        jPanel3,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(
                        jScrollPane1,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        searchTop,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(
                                jScrollPane1,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                jPanel3,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))));
  }

  private void viewItems() {
    List<VehicleDTO> list = vehiclePanelController.getVehicleDTOs();
    for (int i = 0; i < list.size(); i += 3) {
      gridLayout.setRows(gridLayout.getRows() + 1);
      JPanel testPanel = new JPanel();
      testPanel.setBackground(new Color(62, 65, 67));
      testPanel.setPreferredSize(new Dimension(875, 340));
      for (int j = i; j < i + 3; j++) {
        testPanel.add(new VehicleItem(list.get(j), this));
      }

      itemView.add(testPanel);
    }
  }

  void preview(VehicleItem vi) {
    if (oldItem != vi && oldItem != null) {
      oldItem.setBackground(Color.BLACK);
    }
    oldItem = vi;
    VehicleDTO v = oldItem.getVehicle();
    make.setText(v.getMake());
    model.setText(v.getModel());
    rating.setText(String.valueOf(v.getRating()));
    description.setText(v.getDescription());
    rent.setText(String.valueOf(v.getRent()));
  }
}
