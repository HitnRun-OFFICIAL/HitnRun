package com.HitnRun.utils;

import com.HitnRun.handlers.DatabaseException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareDatabase {
    private static final String CREATE_DATABASE = "CREATE DATABASE hitnrun";
    private static final String USE_DATABASE = "USE hitnrun";
    private static final String CREATE_TABLES =
            ""
                    + //
                    "CREATE TABLE Customers ("
                    + //
                    "    CustomerID INT PRIMARY KEY,"
                    + //
                    "    FirstName VARCHAR(50),"
                    + //
                    "    LastName VARCHAR(50),"
                    + //
                    "    Email VARCHAR(100),"
                    + //
                    "    Phone VARCHAR(20),"
                    + //
                    "    Username VARCHAR(50),"
                    + //
                    "    Password VARCHAR(50)"
                    + //
                    ");"
                    + //
                    "CREATE TABLE Vehicles ("
                    + //
                    "    VehicleID INT PRIMARY KEY,"
                    + //
                    "    Make VARCHAR(50),"
                    + //
                    "    Model VARCHAR(50),"
                    + //
                    "    Year INT,"
                    + //
                    "    LicensePlate VARCHAR(20),"
                    + //
                    "    Description TEXT,"
                    + //
                    "    Color VARCHAR(20),"
                    + //
                    "    Rating DECIMAL(3, 2),"
                    + //
                    "    ImagePath VARCHAR(255)"
                    + //
                    ");"
                    + //
                    "CREATE TABLE Staff ("
                    + //
                    "    StaffID INT PRIMARY KEY,"
                    + //
                    "    FirstName VARCHAR(50),"
                    + //
                    "    LastName VARCHAR(50),"
                    + //
                    "    Position VARCHAR(50),"
                    + //
                    "    Email VARCHAR(100),"
                    + //
                    "    Phone VARCHAR(20),"
                    + //
                    "    Username VARCHAR(50),"
                    + //
                    "    Password VARCHAR(50),"
                    + //
                    ");"
                    + //
                    "CREATE TABLE Rental ("
                    + //
                    "    RentalID INT PRIMARY KEY,"
                    + //
                    "    CustomerID INT,"
                    + //
                    "    VehicleID INT,"
                    + //
                    "    StaffID INT,"
                    + //
                    "    RentalDate DATETIME,"
                    + //
                    "    ReturnDate DATETIME,"
                    + //
                    "    RentalFee DECIMAL(10, 2),"
                    + //
                    "    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),"
                    + //
                    "    FOREIGN KEY (VehicleID) REFERENCES Vehicles(VehicleID),"
                    + //
                    "    FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)"
                    + //
                    ");"
                    + //
                    "CREATE TABLE Payments ("
                    + //
                    "    PaymentID INT PRIMARY KEY,"
                    + //
                    "    RentalID INT,"
                    + //
                    "    PaymentDate DATETIME,"
                    + //
                    "    Amount DECIMAL(10, 2),"
                    + //
                    "    FOREIGN KEY (RentalID) REFERENCES Rental(RentalID)"
                    + //
                    ");"
                    + //
                    "CREATE TABLE Maintenance ("
                    + //
                    "    MaintenanceID INT PRIMARY KEY,"
                    + //
                    "    VehicleID INT,"
                    + //
                    "    MaintenanceDate DATETIME,"
                    + //
                    "    Description TEXT,"
                    + //
                    "    Cost DECIMAL(10, 2),"
                    + //
                    "    FOREIGN KEY (VehicleID) REFERENCES Vehicles(VehicleID)"
                    + //
                    ");";

    private static final String INSERT_CUSTOMERS =
            ""
                    + //
                    "INSERT INTO Customers (CustomerID, FirstName, LastName, Email, Phone,"
                  + " Username, Password)"
                    + //
                    "VALUES"
                    + //
                    "    (101, 'Saman', 'Perera', 'saman@example.com', '+94 77 123"
                  + " 4567','saman_customer', 'customer_password'),"
                    + //
                    "    (102, 'Nimal', 'Fernando', 'nimal@example.com', '+94 71 234 5678',"
                  + " 'nimal_customer', 'customer_password'),"
                    + //
                    "    (103, 'Kamal', 'Silva', 'kamal@example.com', '+94 76 345 6789',"
                  + " 'kamal_customer', 'customer_password'),"
                    + //
                    "    (104, 'Priyantha', 'Gunasekara', 'priyantha@example.com', '+94 77 987"
                  + " 6543', 'priyantha_customer', 'customer_password'),"
                    + //
                    "    (105, 'Dilini', 'Rathnayake', 'dilini@example.com', '+94 71 876 5432',"
                  + " 'dilini_customer', 'customer_password'),"
                    + //
                    "    (106, 'Ranjith', 'Rajapaksa', 'ranjith@example.com', '+94 76 765 4321',"
                  + " 'ranjith_customer', 'customer_password'),"
                    + //
                    "    (107, 'Lalith', 'Fernando', 'lalith@example.com', '+94 77 654 3210',"
                  + " 'lalith_customer', 'customer_password'),"
                    + //
                    "    (108, 'Thilini', 'De Silva', 'thilini@example.com', '+94 71 543 2109',"
                  + " 'thilini_customer', 'customer_password'),"
                    + //
                    "    (109, 'Amila', 'Perera', 'amila@example.com', '+94 76 432 1098',"
                  + " 'amila_customer', 'customer_password'),"
                    + //
                    "    (110, 'Chamara', 'Fernando', 'chamara@example.com', '+94 77 321 0987',"
                  + " 'chamara_customer', 'customer_password'),"
                    + //
                    "    (111, 'Nadeeka', 'Wijesinghe', 'nadeeka@example.com', '+94 71 210 9876',"
                  + " 'nadeeka_customer', 'customer_password'),"
                    + //
                    "    (112, 'Dinusha', 'Silva', 'dinusha@example.com', '+94 76 109 8765',"
                  + " 'dinusha_customer', 'customer_password'),"
                    + //
                    "    (113, 'Kusal', 'Rathnayake', 'kusal@example.com', '+94 77 098 7654',"
                  + " 'kusal_customer', 'customer_password'),"
                    + //
                    "    (114, 'Anjali', 'Gunaratne', 'anjali@example.com', '+94 71 987 6543',"
                  + " 'anjali_customer', 'customer_password'),"
                    + //
                    "    (115, 'Chathura', 'Fernando', 'chathura@example.com', '+94 76 876 5432',"
                  + " 'chathura_customer', 'customer_password');";

    private static final String INSERT_VEHICLE =
            ""
                    + //
                    "INSERT INTO Vehicles (VehicleID, Make, Model, Year, LicensePlate, Description,"
                  + " Color, Rating, ImagePath)"
                    + //
                    "VALUES"
                    + //
                    "    (201, 'Toyota', 'Corolla', 2020, 'WP AB 1234', 'Compact sedan', 'Red',"
                  + " 4.5, 'images/toyota_corolla.jpg'),"
                    + //
                    "    (202, 'Honda', 'Civic', 2019, 'WP CD 5678', 'Mid-size sedan', 'Blue', 4.2,"
                  + " 'images/honda_civic.jpg'),"
                    + //
                    "    (203, 'Suzuki', 'Swift', 2021, 'WP EF 9012', 'Hatchback', 'Silver', 4.0,"
                  + " 'images/suzuki_swift.jpg'),"
                    + //
                    "    (204, 'Nissan', 'Altima', 2022, 'WP GH 3456', 'Full-size sedan', 'Black',"
                  + " 4.4, 'images/nissan_altima.jpg'),"
                    + //
                    "    (205, 'Ford', 'Fiesta', 2018, 'WP IJ 7890', 'Compact car', 'White', 3.8,"
                  + " 'images/ford_fiesta.jpg'),"
                    + //
                    "    (206, 'Chevrolet', 'Malibu', 2021, 'WP KL 2345', 'Mid-size sedan', 'Gray',"
                  + " 4.1, 'images/chevrolet_malibu.jpg'),"
                    + //
                    "    (207, 'Hyundai', 'Elantra', 2020, 'WP MN 6789', 'Compact sedan', 'Blue',"
                  + " 4.3, 'images/hyundai_elantra.jpg'),"
                    + //
                    "    (208, 'Kia', 'Seltos', 2022, 'WP OP 1234', 'Compact SUV', 'Black', 4.2,"
                  + " 'images/kia_seltos.jpg'),"
                    + //
                    "    (209, 'Mazda', 'CX-5', 2022, 'WP QR 5678', 'SUV', 'Silver', 4.6,"
                  + " 'images/mazda_cx5.jpg'),"
                    + //
                    "    (210, 'Volkswagen', 'Jetta', 2019, 'WP ST 9012', 'Compact sedan', 'Red',"
                  + " 4.4, 'images/volkswagen_jetta.jpg'),"
                    + //
                    "    (211, 'Subaru', 'Impreza', 2021, 'WP UV 3456', 'Hatchback', 'Blue', 4.0,"
                  + " 'images/subaru_impreza.jpg'),"
                    + //
                    "    (212, 'Audi', 'A4', 2022, 'WP WX 7890', 'Luxury sedan', 'Black', 4.7,"
                  + " 'images/audi_a4.jpg'),"
                    + //
                    "    (213, 'BMW', '3 Series', 2021, 'WP YZ 2345', 'Luxury sedan', 'White', 4.8,"
                  + " 'images/bmw_3series.jpg'),"
                    + //
                    "    (214, 'Mercedes-Benz', 'C-Class', 2020, 'WP 1AB 6789', 'Luxury sedan',"
                  + " 'Silver', 4.6, 'images/mercedes_cclass.jpg'),"
                    + //
                    "    (215, 'Lexus', 'ES', 2022, 'WP 2CD 1234', 'Luxury sedan', 'Black', 4.5,"
                  + " 'images/lexus_es.jpg');";

    private static final String INSERT_STAFF =
            ""
                    + //
                    "INSERT INTO Staff (StaffID, FirstName, LastName, Position, Email, Phone,"
                  + " Username, Password)"
                    + //
                    "VALUES"
                    + //
                    "    (301, 'Dilani', 'Fernando', 'Manager', 'dilani@example.com', '+94 77 987"
                  + " 6543', 'dilani_manager', 'manager_password'),"
                    + //
                    "    (302, 'Rajitha', 'Silva', 'Rental Agent', 'rajitha@example.com', '+94 71"
                  + " 876 5432', 'rajitha_agent', 'agent_password'),"
                    + //
                    "    (303, 'Sanjeewa', 'Perera', 'Maintenance Technician',"
                  + " 'sanjeewa@example.com', '+94 76 765 4321', 'sanjeewa_maintenance',"
                  + " 'maintenance_password'),"
                    + //
                    "    (304, 'Kavinda', 'Jayasekara', 'Rental Agent', 'kavinda@example.com', '+94"
                  + " 77 654 3210', 'kavinda_agent', 'agent_password'),"
                    + //
                    "    (305, 'Nimanthi', 'Fernando', 'Manager', 'nimanthi@example.com', '+94 71"
                  + " 543 2109', 'nimanthi_manager', 'manager_password'),"
                    + //
                    "    (306, 'Chamara', 'Ratnayake', 'Rental Agent', 'chamara@example.com', '+94"
                  + " 76 432 1098', 'chamara_agent', 'agent_password'),"
                    + //
                    "    (307, 'Rajith', 'Perera', 'Maintenance Technician', 'rajith@example.com',"
                  + " '+94 77 321 0987', 'rajith_maintenance', 'maintenance_password'),"
                    + //
                    "    (308, 'Dinusha', 'Fernando', 'Rental Agent', 'dinusha@example.com', '+94"
                  + " 71 210 9876', 'dinusha_agent', 'agent_password'),"
                    + //
                    "    (309, 'Sanduni', 'Silva', 'Manager', 'sanduni@example.com', '+94 76 109"
                  + " 8765', 'sanduni_manager', 'manager_password'),"
                    + //
                    "    (310, 'Tharindu', 'Ratnayake', 'Maintenance Technician',"
                  + " 'tharindu@example.com', '+94 77 098 7654', 'tharindu_maintenance',"
                  + " 'maintenance_password'),"
                    + //
                    "    (311, 'Shanika', 'Jayasuriya', 'Rental Agent', 'shanika@example.com', '+94"
                  + " 71 987 6543', 'shanika_agent', 'agent_password'),"
                    + //
                    "    (312, 'Kasun', 'Fernando', 'Manager', 'kasun@example.com', '+94 76 876"
                  + " 5432', 'kasun_manager', 'manager_password'),"
                    + //
                    "    (313, 'Isuru', 'Perera', 'Rental Agent', 'isuru@example.com', '+94 77 765"
                  + " 4321', 'isuru_agent', 'agent_password'),"
                    + //
                    "    (314, 'Nadeeka', 'Wijesinghe', 'Maintenance Technician',"
                  + " 'nadeeka@example.com', '+94 71 654 3210', 'nadeeka_maintenance',"
                  + " 'maintenance_password'),"
                    + //
                    "    (315, 'Chaminda', 'Gunasekara', 'Rental Agent', 'chaminda@example.com',"
                  + " '+94 76 543 2109', 'chaminda_agent', 'agent_password');";

    private static final String INSERT_RENTAL =
            ""
                    + //
                    "INSERT INTO Rental (RentalID, CustomerID, VehicleID, StaffID, RentalDate,"
                  + " ReturnDate, RentalFee)"
                    + //
                    "VALUES"
                    + //
                    "    (401, 101, 201, 302, '2023-10-01 09:00:00', '2023-10-05 11:00:00',"
                  + " 2500.00),"
                    + //
                    "    (402, 102, 203, 304, '2023-10-02 14:00:00', '2023-10-07 16:00:00',"
                  + " 3200.00),"
                    + //
                    "    (403, 103, 202, 303, '2023-10-03 10:00:00', '2023-10-06 13:00:00',"
                  + " 2800.00),"
                    + //
                    "    (404, 104, 205, 307, '2023-10-04 11:30:00', '2023-10-08 09:00:00',"
                  + " 1800.00),"
                    + //
                    "    (405, 105, 211, 309, '2023-10-05 15:45:00', '2023-10-09 12:30:00',"
                  + " 3000.00),"
                    + //
                    "    (406, 106, 206, 308, '2023-10-06 08:00:00', '2023-10-10 14:00:00',"
                  + " 2200.00),"
                    + //
                    "    (407, 107, 204, 302, '2023-10-07 12:15:00', '2023-10-11 10:45:00',"
                  + " 2700.00),"
                    + //
                    "    (408, 108, 210, 301, '2023-10-08 16:30:00', '2023-10-12 15:00:00',"
                  + " 2600.00),"
                    + //
                    "    (409, 109, 215, 312, '2023-10-09 07:45:00', '2023-10-13 11:15:00',"
                  + " 3500.00),"
                    + //
                    "    (410, 110, 213, 315, '2023-10-10 10:30:00', '2023-10-14 08:30:00',"
                  + " 2800.00),"
                    + //
                    "    (411, 111, 209, 314, '2023-10-11 14:00:00', '2023-10-15 16:00:00',"
                  + " 3200.00),"
                    + //
                    "    (412, 112, 207, 306, '2023-10-12 13:15:00', '2023-10-16 09:45:00',"
                  + " 2400.00),"
                    + //
                    "    (413, 113, 212, 303, '2023-10-13 09:30:00', '2023-10-17 12:30:00',"
                  + " 2900.00),"
                    + //
                    "    (414, 114, 208, 310, '2023-10-14 11:00:00', '2023-10-18 14:15:00',"
                  + " 2700.00),"
                    + //
                    "    (415, 115, 214, 305, '2023-10-15 08:45:00', '2023-10-19 10:30:00',"
                  + " 3100.00);";

    private static final String INSERT_PAYMENTS =
            ""
                    + //
                    "INSERT INTO Payments (PaymentID, RentalID, PaymentDate, Amount)"
                    + //
                    "VALUES"
                    + //
                    "    (501, 401, '2023-10-06 15:30:00', 2500.00),"
                    + //
                    "    (502, 402, '2023-10-08 10:15:00', 3200.00),"
                    + //
                    "    (503, 403, '2023-10-07 14:45:00', 2800.00),"
                    + //
                    "    (504, 404, '2023-10-10 11:00:00', 1800.00),"
                    + //
                    "    (505, 405, '2023-10-11 17:30:00', 3000.00),"
                    + //
                    "    (506, 406, '2023-10-12 13:15:00', 2200.00),"
                    + //
                    "    (507, 407, '2023-10-14 09:45:00', 2700.00),"
                    + //
                    "    (508, 408, '2023-10-15 16:30:00', 2600.00),"
                    + //
                    "    (509, 409, '2023-10-18 08:15:00', 3500.00),"
                    + //
                    "    (510, 410, '2023-10-19 10:00:00', 2800.00),"
                    + //
                    "    (511, 411, '2023-10-21 14:45:00', 3200.00),"
                    + //
                    "    (512, 412, '2023-10-22 11:30:00', 2400.00),"
                    + //
                    "    (513, 413, '2023-10-24 09:00:00', 2900.00),"
                    + //
                    "    (514, 414, '2023-10-25 16:00:00', 2700.00),"
                    + //
                    "    (515, 415, '2023-10-28 12:45:00', 3100.00);";

    private static final String INSERT_MAINTENANCE =
            ""
                    + //
                    "INSERT INTO Maintenance (MaintenanceID, VehicleID, MaintenanceDate,"
                  + " Description, Cost)"
                    + //
                    "VALUES"
                    + //
                    "    (601, 201, '2023-09-15 13:30:00', 'Routine maintenance', 150.00),"
                    + //
                    "    (602, 202, '2023-08-20 10:45:00', 'Oil change and filter replacement',"
                  + " 120.00),"
                    + //
                    "    (603, 203, '2023-09-10 14:15:00', 'Brake pad replacement', 200.00),"
                    + //
                    "    (604, 204, '2023-09-28 09:30:00', 'Tire replacement', 180.00),"
                    + //
                    "    (605, 205, '2023-08-15 14:00:00', 'Battery replacement', 80.00),"
                    + //
                    "    (606, 206, '2023-10-02 11:15:00', 'Air conditioning service', 100.00),"
                    + //
                    "    (607, 207, '2023-09-05 16:30:00', 'Engine tune-up', 220.00),"
                    + //
                    "    (608, 208, '2023-10-12 13:00:00', 'Transmission fluid change', 190.00),"
                    + //
                    "    (609, 209, '2023-09-18 10:45:00', 'Suspension repair', 250.00),"
                    + //
                    "    (610, 210, '2023-10-20 09:15:00', 'Brake rotor replacement', 150.00),"
                    + //
                    "    (611, 211, '2023-09-30 15:30:00', 'Wheel alignment', 90.00),"
                    + //
                    "    (612, 212, '2023-08-28 11:45:00', 'Exhaust system repair', 130.00),"
                    + //
                    "    (613, 213, '2023-10-06 14:00:00', 'Coolant flush', 120.00),"
                    + //
                    "    (614, 214, '2023-09-25 12:15:00', 'Electrical system check', 110.00),"
                    + //
                    "    (615, 215, '2023-08-10 10:30:00', 'Power steering service', 160.00);";

    public static void createDatabase() {
        try (Connection connection = MSSQLJDBConnector.getConnection();
                Statement statement = connection.createStatement()) {
            // Create the "hitnrun" database
            statement.executeUpdate(CREATE_DATABASE);
            statement.executeUpdate(USE_DATABASE);

            // Create tables within the "hitnrun" database
            statement.executeUpdate(CREATE_TABLES);

            // Insert data into tables
            statement.executeUpdate(INSERT_CUSTOMERS);
            statement.executeUpdate(INSERT_VEHICLE);
            statement.executeUpdate(INSERT_STAFF);
            statement.executeUpdate(INSERT_RENTAL);
            statement.executeUpdate(INSERT_PAYMENTS);
            statement.executeUpdate(INSERT_MAINTENANCE);
        } catch (SQLException e) {
            throw new DatabaseException("Failed to create the database or tables.", e);
        }
    }

    public static void main(String[] args) {
        try {
            createDatabase();
            System.out.println("Database and tables created successfully.");
        } catch (DatabaseException e) {
            System.err.println("Database Exception: " + e.getMessage());
        }
    }
}
