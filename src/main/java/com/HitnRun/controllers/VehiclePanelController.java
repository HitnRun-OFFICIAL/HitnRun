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
  // Variables to manage database connection and vehicle data
  private Connection connection;
  private VehicleDAO vehicleDAO;
  private List<VehicleDTO> vehicles;
  private List<String> models;
  private List<String> makes;
  private VehicleItem oldItem;

  // Constructor to initialize the database connection and create the controller
  public VehiclePanelController() {
    connection = HSQLDBConnector.getConnection(); // Get connection
    vehicleDAO = new VehicleDAO(connection); // Intialize class instance
    vehicles = new ArrayList<VehicleDTO>(); // Initialize an empty list for vehicle data
  }

  public List<VehicleDTO> getVehicles(String Model, String Make) {
    try {
      vehicles = vehicleDAO.readAllVehicles(Model, Make); // Read all vehicles from the database
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return vehicles; // Return the list of vehicles
  }

  // Method to retrieve an array of vehicle models
  public String[] getModels() {
    try {
      models = new ArrayList<>();
      models.add("Model"); //Add placeholder value
      models.addAll(vehicleDAO.readVehicleModel()); // Retrieve Vehicle models from database

      return (String[]) Arrays.copyOf(models.toArray(), models.size(), String[].class);

    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return null;
  }

  // Method to retrieve an array of vehicle makes
  public String[] getMakes() {
    try {
      makes = new ArrayList<>();
      makes.add("Make"); // Placeholder value
      makes.addAll(vehicleDAO.readVehicleMake());// Retrieve vehicle makes from the database

      return (String[]) Arrays.copyOf(makes.toArray(), makes.size(), String[].class);

    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return null;
  }

  // Method to display vehicle items in a panel
  public void viewItems(
      JPanel itemPanel,
      GridLayout gridLayout,
      PreviewPanel previewPanel,
      String model,
      String make) {
    List<VehicleDTO> list = getVehicles(model, make);
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
        if (j < list.size()) {
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
      if (i + 1 < list.size()) {
        gl.setVerticalGroup(gl.createSequentialGroup().addGap(15, 15, 15).addGroup(v));
      } else {
        gl.setVerticalGroup(
            gl.createSequentialGroup().addGap(15, 15, 15).addGroup(v).addGap(15, 15, 15));
      }

      itemPanel.add(testPanel);
    }
    if (!list.isEmpty()) {
      preview(new VehicleItem(list.get(0)), previewPanel);
    }
  }

  void preview(VehicleItem vi, PreviewPanel previewPanel) {
    // Check if there is an oldItem selected and if it's not the same as the current selection.
    if (oldItem != vi && oldItem != null) {
      oldItem.setBackground(new Color(30, 33, 38));  // Set the background color of the old item
    }
    oldItem = vi; //update the old item
    VehicleDTO v = oldItem.getVehicle();
    //Preview updates
    previewPanel.setId(v.getVehicleID());
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
