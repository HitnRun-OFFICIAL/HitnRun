package com.HitnRun.views;

import com.HitnRun.controllers.VehiclePanelController;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/** @author 5H4D0W */
public class VehiclePanel extends JPanel {
  private JPanel itemPanel;
  private PreviewPanel jPanel1;
  private JPanel jPanel2;
  private JScrollPane jScrollPane1;
  private JComboBox<String> makeCombo;
  private JComboBox<String> modelCombo;
  private GridLayout gridLayout;
  private VehiclePanelController vehiclePanelController;

  public VehiclePanel() {
    initComponents();
    vehiclePanelController.viewItems(itemPanel, gridLayout, jPanel1, "Model", "Make");
  }

  private void initComponents() {

    jPanel1 = new PreviewPanel();
    jPanel2 = new JPanel();
    modelCombo = new JComboBox<>();
    makeCombo = new JComboBox<>();
    jScrollPane1 = new JScrollPane();
    itemPanel = new JPanel();
    gridLayout = new GridLayout(0, 3);
    vehiclePanelController = new VehiclePanelController();

    setBackground(new java.awt.Color(40, 43, 48));
    setMaximumSize(new java.awt.Dimension(1280, 728));
    setMinimumSize(new java.awt.Dimension(1280, 728));
    setPreferredSize(new java.awt.Dimension(1280, 728));

    modelCombo.setModel(new DefaultComboBoxModel<>(vehiclePanelController.getModels()));
    modelCombo.addItemListener(
      new ItemListener() {
        public void itemStateChanged(ItemEvent evt) {
          if (evt.getStateChange() == ItemEvent.SELECTED) {
            itemPanel.removeAll();
            vehiclePanelController.viewItems(itemPanel, gridLayout, jPanel1, modelCombo.getSelectedItem().toString(), makeCombo.getSelectedItem().toString());
          }
        }
      }
    );

    makeCombo.setModel(new DefaultComboBoxModel<>(vehiclePanelController.getMakes()));
    makeCombo.addItemListener(
      new ItemListener() {
        public void itemStateChanged(ItemEvent evt) {
          if (evt.getStateChange() == ItemEvent.SELECTED) {
            itemPanel.removeAll();
            vehiclePanelController.viewItems(itemPanel, gridLayout, jPanel1, modelCombo.getSelectedItem().toString(), makeCombo.getSelectedItem().toString());
          }
        }
      }
    );

    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        makeCombo, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        modelCombo, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                modelCombo,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                makeCombo,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)));

    jScrollPane1.setBackground(new java.awt.Color(50, 53, 58));
    jScrollPane1.setBorder(null);
    jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
    jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);

    itemPanel.setBackground(new java.awt.Color(50, 53, 58));

    itemPanel.setLayout(gridLayout);

    jScrollPane1.setViewportView(itemPanel);

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(
                        jPanel1,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jScrollPane1, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addComponent(
                        jPanel2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(
                                jPanel1,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                    .addGap(22, 22, 22)));
  }
}
