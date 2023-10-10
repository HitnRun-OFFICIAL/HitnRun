import java.util.Date;

public class MaintenanceDTO {

    private int MaintenanceID;
    private VehicleDTO vehicle; // Represents the Vehicle foreign key
    private Date MaintenanceDate;
    private String Description;
    private double Cost;

    public MaintenanceDTO() {
        // Default constructor
    }

    public MaintenanceDTO(int maintenanceID, VehicleDTO vehicle, Date maintenanceDate, String description, double cost) {
        this.MaintenanceID = maintenanceID;
        this.vehicle = vehicle;
        this.MaintenanceDate = maintenanceDate;
        this.Description = description;
        this.Cost = cost;
    }

    public int getMaintenanceID() {
        return MaintenanceID;
    }

    public void setMaintenanceID(int maintenanceID) {
        MaintenanceID = maintenanceID;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public Date getMaintenanceDate() {
        return MaintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        MaintenanceDate = maintenanceDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }
}
