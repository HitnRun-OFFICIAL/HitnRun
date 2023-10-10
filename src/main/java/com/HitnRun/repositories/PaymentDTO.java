import java.util.Date;

public class PaymentsDTO {

    private int PaymentID;
    private RentalDTO rental; // Represents the Rental foreign key
    private Date PaymentDate;
    private double Amount;

    public PaymentsDTO() {
        // Default constructor
    }

    public PaymentsDTO(int paymentID, RentalDTO rental, Date paymentDate, double amount) {
        this.PaymentID = paymentID;
        this.rental = rental;
        this.PaymentDate = paymentDate;
        this.Amount = amount;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int paymentID) {
        PaymentID = paymentID;
    }

    public RentalDTO getRental() {
        return rental;
    }

    public void setRental(RentalDTO rental) {
        this.rental = rental;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
