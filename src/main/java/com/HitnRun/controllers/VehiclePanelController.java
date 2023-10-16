package com.HitnRun.controllers;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.repositories.VehicleDAO;
import com.HitnRun.utils.MSSQLJDBConnector;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class VehiclePanelController {
  private Connection connection;
  private VehicleDAO vehicleDAO;
  private List<VehicleDTO> vehicles;

  public VehiclePanelController() {
    connection = MSSQLJDBConnector.getConnection("hitnrun");
    vehicleDAO = new VehicleDAO(connection);
    vehicles = new ArrayList<VehicleDTO>();
  }

  public List<VehicleDTO> getVehicleDTOs() {
    try {
      for (VehicleDTO v : vehicleDAO.readAllVehicles()) {
        v.setImagePath("/img/cars.png");
        vehicles.add(v);
      }
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return vehicles;
  }
}