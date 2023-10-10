import java.util.Date;

public class RentalDTO {

    private int RentalID;
    private CustomerDTO customer; // Represents the Customer foreign key
    private VehicleDTO vehicle; // Represents the Vehicle foreign key
    private StaffDTO staff; // Represents the Staff foreign key
    private Date RentalDate;
    private Date ReturnDate;
    private double RentalFee;

    public RentalDTO() {
        // Default constructor
    }

    public RentalDTO(int rentalID, CustomerDTO customer, VehicleDTO vehicle, StaffDTO staff, Date rentalDate, Date returnDate, double rentalFee) {
        this.RentalID = rentalID;
        this.customer = customer;
        this.vehicle = vehicle;
        this.staff = staff;
        this.RentalDate = rentalDate;
        this.ReturnDate = returnDate;
        this.RentalFee = rentalFee;
    }

    public int getRentalID() {
        return RentalID;
    }

    public void setRentalID(int rentalID) {
        RentalID = rentalID;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public StaffDTO getStaff() {
        return staff;
    }

    public void setStaff(StaffDTO staff) {
        this.staff = staff;
    }

    public Date getRentalDate() {
        return RentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        RentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }

    public double getRentalFee() {
        return RentalFee;
    }

    public void setRentalFee(double rentalFee) {
        RentalFee = rentalFee;
    }
}
