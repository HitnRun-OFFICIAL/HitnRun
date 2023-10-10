import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.Double;
 
public class VehicleDao {
    private Connection connection ;
    
    public VehicleDao(Connection connection){
        this.connection = connection ;
    }

    
   
    public void createVehicle(VehicleDao vehicle) throws SQLException{
        String sql = "INSERT INTO Vehicles (VehicleID, Make, Model, Year, LicensePlate, Description, Color, Rating, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicle.getVechileID());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setString(5, vehicle.getLicensePlate());
            preparedStatement.setString(6, vehicle.getDescription());
            preparedStatement.setString(7, vehicle.getColor);
            preparedStatement.setDouble(8, vehicle.getRating);
            preparedStatement.setString(9, vehicle.getImagePath);
            preparedStatement.executeUpdate();

    }

    
    // Read a Vehicle by ID
    public VehicleDTO readVehicle(int vehicleID) throws SQLException {
        String sql = "SELECT * FROM Vehicles WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicleID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToVehicle(resultSet);
                }
            }
        }
        return null; // Vehicle not found
    }
    
    //Add other reads If necessary
    
    
    
 
    // Read all Vehicles
    public List<VehicleDTO> readAllVehicles() throws SQLException {
        List<VehicleDTO> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicles";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                vehicles.add(mapResultSetToVehicle(resultSet));
            }
        }
        return vehicle;
    }
 
    // Update a Vehicle
    public void updateVehicle(VehicleDTO vehicle) throws SQLException {
        String sql = "UPDATE Vehicles SET Make = ? , Model = ? , Year = ? , LicensePlate = ? , Description = ?, Color = ?,Rating = ?,ImagePath = ? WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicle.getVechileID());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setString(5, vehicle.getLicensePlate());
            preparedStatement.setString(6, vehicle.getDescription());
            preparedStatement.setString(7, vehicle.getColor);
            preparedStatement.setDouble(8, vehicle.getRating);
            preparedStatement.setString(9, vehicle.getImagePath);
            preparedStatement.executeUpdate();
        }
    }
 
    // Delete a Vehicle by ID
    public void deleteVehicle(int vehicleID) throws SQLException {
        String sql = "DELETE FROM Vehicles WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicleID);
            preparedStatement.executeUpdate();
        }
    }
 
    // Helper method to map ResultSet to VehicleDTO
    private VehicleDTO mapResultSetToVehicle(ResultSet resultSet) throws SQLException {
        VehicleDTO vehicle = new VehicleDTO();
        
        
        
        vehicle.setVehicleID(resultSet.getInt("VehicleID"));
        vehicle.setMake(resultSet.getString("Make"));
        vehicle.setModel(resultSet.getString("Model"));
        vehicle.setYear(resultSet.getInt("Year"));
        vehicle.setLicensePlate(resultSet.getString("LisensePlate");
        vehicle.setMake(resultSet.getString("Make"));
        vehicle.setDouble(resultSet.getDouble("Rating"));
        vehicle.setImagePath(resultSet.getString("ImagePath"));
        return vehicle;
    }
    

}
