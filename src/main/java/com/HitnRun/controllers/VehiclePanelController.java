package com.HitnRun.controllers;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.repositories.VehicleDAO;
import com.HitnRun.utils.HSQLDBConnector;
import com.HitnRun.views.PreviewPanel;
import com.HitnRun.views.VehicleItem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

public class VehiclePanelController {
  private Connection connection;
  private VehicleDAO vehicleDAO;
  private List<VehicleDTO> vehicles;
  private List<String> models;
  private List<String> makes;
  private VehicleItem oldItem;

  public VehiclePanelController() {
    connection = HSQLDBConnector.getConnection();
    vehicleDAO = new VehicleDAO(connection);
    vehicles = new ArrayList<VehicleDTO>();
  }

  public List<VehicleDTO> getVehicles() {
    try {
      vehicles = vehicleDAO.readAllVehicles();
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return vehicles;
  }

  public String[] getModels() {
    try {
      models = new ArrayList<>();
      models.add("Model");
      models.addAll(vehicleDAO.readVehicleModel());

      return (String[]) Arrays.copyOf(models.toArray(), models.size(), String[].class);

    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String[] getMakes() {
    try {
      makes = new ArrayList<>();
      makes.add("Make");
      makes.addAll(vehicleDAO.readVehicleMake());

      return (String[]) Arrays.copyOf(makes.toArray(), makes.size(), String[].class);

    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void viewItems(JPanel itemPanel, GridLayout gridLayout, PreviewPanel previewPanel, String model, String make) {
    List<VehicleDTO> list = getVehicles();
    for (int i = 0; i < list.size(); i += 3) {
      gridLayout.setRows(gridLayout.getRows() + 1);
      JPanel testPanel = new JPanel();
      testPanel.setBackground(new Color(62, 65, 67));
      GroupLayout gl = new GroupLayout(testPanel);
      testPanel.setLayout(gl);
      testPanel.setPreferredSize(new Dimension(900, 320));
      SequentialGroup h = gl.createSequentialGroup();
      ParallelGroup v = gl.createParallelGroup(GroupLayout.Alignment.LEADING);

      h.addGap(29, 29, 29);
      for (int j = i; j < i + 3; j++) {
        h.addGap(28, 28, 28);
        if (list.get(j) != null) {
          VehicleItem item =
              new VehicleItem(list.get(j)) {
                public void itemMousePressed(MouseEvent evt) {
                  preview(this, previewPanel);
                  this.setBackground(new Color(50, 53, 58));
                }
              };
          h.addComponent(item);
          v.addComponent(item);
        } else {
          h.addGap(225, 225, 255);
          v.addGap(300, 300, 300);
        }
        h.addGap(28, 28, 28);
      }
      h.addGap(29, 29, 29);

      gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(h));
      if (list.get(i + 1) != null) {
        gl.setVerticalGroup(gl.createSequentialGroup().addGap(15, 15, 15).addGroup(v));
      } else {
        gl.setVerticalGroup(
            gl.createSequentialGroup().addGap(15, 15, 15).addGroup(v).addGap(15, 15, 15));
      }

      itemPanel.add(testPanel);
    }
    preview(new VehicleItem(list.get(0)), previewPanel);
  }

  void preview(VehicleItem vi, PreviewPanel previewPanel) {
    if (oldItem != vi && oldItem != null) {
      oldItem.setBackground(new Color(30, 33, 38));
    }
    oldItem = vi;
    VehicleDTO v = oldItem.getVehicle();
    previewPanel.setImg(v.getImagePath());
    previewPanel.setMake(v.getMake());
    previewPanel.setModel(v.getModel());
    previewPanel.setYear(v.getYear());
    previewPanel.setColor(v.getColor());
    previewPanel.setDescription(v.getDescription());
    previewPanel.setRent(v.getRent());
    previewPanel.setRating(v.getRating());
  }
}
