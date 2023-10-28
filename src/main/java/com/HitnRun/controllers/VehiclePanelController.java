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
    int itemsPerRow = 3;

    for (int i = 0; i < list.size(); i += itemsPerRow) {
      JPanel rowPanel = createRowPanel();

      for (int j = i; j < i + itemsPerRow; j++) {
        if (j < list.size()) {
          VehicleDTO vehicle = list.get(j);
          VehicleItem item = createVehicleItem(vehicle, previewPanel);
          rowPanel.add(item);
        } else {
          rowPanel.add(createGapPanel());
        }
      }

      itemPanel.add(rowPanel);
    }

    if (!list.isEmpty()) {
      preview(new VehicleItem(list.get(0)), previewPanel);
    }
  }

  //New JPanel to represent a row
  private JPanel createRowPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(new Color(62, 65, 67));
    panel.setPreferredSize(new Dimension(900, 320));
    return panel;
  }

  private VehicleItem createVehicleItem(VehicleDTO vehicle, PreviewPanel previewPanel) {
    VehicleItem item =
        new VehicleItem(vehicle) {
          //@override
          //Call the preview pannel with current item as an arg
          public void itemMousePressed(MouseEvent evt) {
            preview(this, previewPanel);
            this.setBackground(new Color(50, 53, 58));
          }
        };
    return item;
  }

  // Create a new JPanel that serves as a gap
  private JPanel createGapPanel() {
    JPanel gapPanel = new JPanel();
    gapPanel.setPreferredSize(new Dimension(225, 300));
    return gapPanel;
  }

  // Check if there is an oldItem selected and if it's not the same as the current selection.
  void preview(VehicleItem vi, PreviewPanel previewPanel) {
    if (oldItem != vi && oldItem != null) {
      oldItem.setBackground(new Color(30, 33, 38));  // Set the background color of the old item
    }
    oldItem = vi; //update the old item
    VehicleDTO v = oldItem.getVehicle();
    //Preview updata goes BRRR
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
