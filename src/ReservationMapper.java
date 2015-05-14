

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class ReservationMapper
{
   private CustomerMapper customerMapper;
   private CarMapper carMapper;
   
   public ReservationMapper() throws ClassNotFoundException
   {
      this.customerMapper = new CustomerMapper();
      this.carMapper = new CarMapper();
   }
   
   public Reservation create(Date pickUpTime, Date returnTime, String locationPickUp, String locationReturn, int kmWantToDrive, int carId, int customerId) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement(
                     "INSERT INTO Reservation(pickUpTime, returnTime, locationPickUp, locationReturn, kmWantToDrive, carId, customerId) VALUES (?,?,?,?,?,?,?)");
         statement.setDate(1, pickUpTime);
         statement.setDate(2, returnTime);
         statement.setString(3, locationPickUp);
         statement.setString(4, locationReturn);
         statement.setInt(5, kmWantToDrive);
         statement.setInt(6, carId);
         statement.setInt(7, customerId);
         
         statement.executeUpdate();
       //  ResultSet rs = statement.executeQuery();
    //    if (rs.next()) {
            Reservation reservation = new Reservation();

            return reservation;
//         }
//         else
//         {
//            throw new SQLException("Insertion didn't generate keys!!");
//         }
      }
      finally
      {
         connection.close();
      }
   }

   public Reservation read(int id) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("Select * FROM Reservation WHERE id = ?");
         statement.setInt(1, id);
         ResultSet rs = statement.executeQuery();
         if (rs.next()) 
         {
            Date pickUpTime = rs.getDate("pickUpTime");
            Date returnTime = rs.getDate("returnTime");
            String locationPickUp = rs.getString("locationPickUp");
            String locationReturn = rs.getString("locationReturn");
            int kmWantToDrive = rs.getInt("kmWantToDrive");
            int carId = rs.getInt("carId");
            int customerId = rs.getInt("customerId");

            Reservation reservation = new Reservation();
            return reservation;
         }
         else
         {
            return null;
         }
      }
      finally
      {
         connection.close();
      }
   }
   
   public void seeAvailableCars() throws SQLException
   {
      
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("SELECT car.model,car.brand,car.licencePlate,car.price,car.id FROM car WHERE(( availability = 1))");
    
         ResultSet rs = statement.executeQuery();
         ArrayList<Car> availableCarsList = new ArrayList<Car>();
         System.out.println("List of Available Cars");
         System.out.println("----------------------");
         while (rs.next()) 
         {
            System.out.println("Car Id: " + rs.getInt("id"));
            System.out.println("Model: " + rs.getString("model"));
            System.out.println("Brand: " + rs.getString("brand"));
            System.out.println("Licence Plate: " + rs.getString("licencePlate"));
            System.out.println("Price / Day: " + rs.getInt("price"));
            System.out.println();
            
            
         }
      }
      finally
      {
         connection.close();
      }
      
   }
   
   public ArrayList<String[]> seeDriveToLocations() throws SQLException
   {
      ArrayList<String[]> data = new ArrayList<>();
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("SELECT reservation.locationPickUp,reservation.carId,car.model,car.brand,car.licencePlate FROM reservation LEFT JOIN v_rent.car ON reservation.carId = car.id WHERE(( returnTime = CURDATE()))");
    
         ResultSet rs = statement.executeQuery();
         System.out.println("Drive To Locations for Today");
         System.out.println("----------------------------");
         while (rs.next()) 
         {
            String[] row = {" Car Id : " + rs.getInt("carId") + " Drive To : " + rs.getString("locationPickUp") + " Model : " + rs.getString("model") + " Brand: " + rs.getString("brand") + " Licence Plate: " + rs.getString("licencePlate")};
            System.out.println("Car Id: " + rs.getInt("carId"));
            System.out.println("Drive To: " + rs.getString("locationPickUp"));
            System.out.println("Model : " + rs.getString("model"));
            System.out.println("Brand: " + rs.getString("brand"));
            System.out.println("Licence Plate: " + rs.getString("licencePlate"));
            System.out.println();
                      
            data.add(row);
         }
         
      }
      finally
      {
         connection.close();
      }
      return data;
   }
   
   public ArrayList<String[]> seePickUpLocations() throws SQLException
   {
      ArrayList<String[]> data = new ArrayList<>();
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("SELECT reservation.locationReturn,reservation.carId,car.model,car.brand,car.licencePlate FROM reservation LEFT JOIN v_rent.car ON reservation.carId = car.id WHERE(( returnTime = CURDATE()))");
    
         ResultSet rs = statement.executeQuery();
         System.out.println("Pick Up Locations for Today");
         System.out.println("----------------------------");
         while (rs.next()) 
         {
            String[] row = {" Pick Up Locations for Today : " + " Car Id : " + rs.getString("carId") + " Model : " + rs.getString("model") + " Brand : " + rs.getString("brand") + " Licence Plate : " + rs.getString("licencePlate")};
            System.out.println("Car Id: " + rs.getString("carId"));
            System.out.println("Location Pick Up: " + rs.getString("locationReturn"));
            System.out.println("Model : " + rs.getString("model"));
            System.out.println("Brand: " + rs.getString("brand"));
            System.out.println("Licence Plate: " + rs.getString("licencePlate"));
            System.out.println();
            data.add(row);
         }
      }
      finally
      {
         connection.close();
      }
      return data;
   }
   
   public ArrayList<String[]> todayReservedCars() throws SQLException
   {
      ArrayList<String[]> data = new ArrayList<>();
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("SELECT car.model,car.brand,car.availability,car.licencePlate,car.price FROM car LEFT JOIN v_rent.reservation ON car.id = reservation.carId WHERE(( pickUpTime = CURDATE()))");
    
         ResultSet rs = statement.executeQuery();
         System.out.println("Reserved Cars for Today");
         System.out.println("-----------------------");
         while (rs.next()) 
         {
            String[] row = {"Car Model : "+rs.getString("model") + " \nBrand : " + rs.getString("brand") + " Licence Plate :" + rs.getString("licencePlate") + " Price / Day :" + rs.getString("price")};
            System.out.println("Car Model :" + rs.getString("model"));
            System.out.println("Brand :" + rs.getString("brand"));
            if(rs.getInt("availability") == 1)
            {
               System.out.println("*** CAR IS AVAILABLE");
            } else 
            {
               System.out.println("NOT ! AVAILABLE");
            }
            
            System.out.println("Licence Plate :" + rs.getString("licencePlate"));
            System.out.println("Price / Day :" + rs.getString("price"));
            System.out.println();
            data.add(row);
         }
      }
      finally
      {
         connection.close();
      }
      return data;
   }
   
   public ArrayList<String[]> seeAllReservations() throws SQLException
   {
      ArrayList<String[]> data = new ArrayList<>();
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("SELECT `reservation`.`id`,`reservation`.`pickUpTime`,`reservation`.`returnTime`,`reservation`.`locationPickUp`,`reservation`.`locationReturn`,`reservation`.`kmWantToDrive`,`customer`.`name`,`car`.`model`,`car`.`brand`,`car`.`licencePlate` FROM reservation LEFT JOIN `v_rent`.`car` ON `reservation`.`carId` = `car`.`id` LEFT JOIN `v_rent`.`customer` ON `reservation`.`customerId` = `customer`.`id`  WHERE(( carId = car.id) AND ( customerId = customer.id))");
    
         ResultSet rs = statement.executeQuery();
         System.out.println("Table of All Reservations");
         System.out.println("-------------------------");
         while (rs.next()) 
         {
            String[] row = {" Reservation ID :" + rs.getString("id") + " Car Model :" + rs.getString("model") +" KM for Driving :" + rs.getString("kmWantToDrive") + " Licence Plate :" + rs.getString("licencePlate") + " Customer Name :" + rs.getString("name")};
            System.out.println("Reservation ID :" + rs.getString("id"));
            System.out.println("Pick Up Location :" + rs.getString("locationPickUp"));
            System.out.println("Pick Up Time :" + rs.getString("pickUpTime"));
            System.out.println("Return Location :" + rs.getString("locationReturn"));
            System.out.println("Return Time " + rs.getString("returnTime"));
            System.out.println("KM for Driving :" + rs.getString("kmWantToDrive"));
            System.out.println("Car Model :" + rs.getString("model"));
            System.out.println("Licence Plate :" + rs.getString("licencePlate"));
            System.out.println("Customer Name :" + rs.getString("name"));
            System.out.println();
            data.add(row);
         }
      }
      finally
      {
         connection.close();
      }
      return data;
   }
   
   public void delete(int id) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("DELETE FROM Reservation WHERE id = ?");
         statement.setInt(1, id);
         statement.executeUpdate();
      }
      finally
      {
         connection.close();
      }
   }
   
   public ArrayList<String[]> seeReturnedCars() throws SQLException
   {
      ArrayList<String[]> data = new ArrayList<>();
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("SELECT `car`.`model`,`car`.`brand`,`car`.`licencePlate` FROM car LEFT JOIN `v_rent`.`reservation` ON `car`.`id` = `reservation`.`carId`  WHERE(( returnTime = CURDATE()))");
    
         ResultSet rs = statement.executeQuery();
         System.out.println("Returned Cars for Today");
         System.out.println("-----------------------");
         while (rs.next()) 
         {
            String[] row = {"Car Model : "+rs.getString("model") + " \nBrand : " + rs.getString("brand") + " Licence Plate :" + rs.getString("licencePlate")};
            System.out.println("Car Model :" + rs.getString("model"));
            System.out.println("Brand :" + rs.getString("brand"));
            System.out.println("Licence Plate :" + rs.getString("licencePlate"));
           
            System.out.println();
            data.add(row);
         }
      }
      finally
      {
         connection.close();
      }
      return data;
   } 
   
   
   
}