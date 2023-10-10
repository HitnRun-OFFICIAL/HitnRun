public class VehicleDTO {

    private int VehicleID;
    private String Make;
    private String Model;
    private int Year;
    private String LicensePlate;
    private String Description;
    private String Color;
    private double Rating;
    private String ImagePath;

    public VehicleDTO() {
        // Default constructor
    }

    public VehicleDTO(int vehicleID, String make, String model, int year, String licensePlate, String description, String color, double rating, String imagePath) {
        this.VehicleID = vehicleID;
        this.Make = make;
        this.Model = model;
        this.Year = year;
        this.LicensePlate = licensePlate;
        this.Description = description;
        this.Color = color;
        this.Rating = rating;
        this.ImagePath = imagePath;
    }

    public int getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(int vehicleID) {
        VehicleID = vehicleID;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
