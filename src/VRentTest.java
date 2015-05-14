
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class VRentTest
{

   public static void main(String[] args) throws SQLException,
   ClassNotFoundException
   {
      // 1. Load the driver
      Class.forName("com.mysql.jdbc.Driver");

      // 2. Create the connection
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/v_rent", "root", "");
      // 3. Call the database
      try
      {
         // Updating
         // 3a) Prepare statement
         //PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Reservation (pickUpTime, returnTime, locationPickUp, locationReturn, kmWantToDrive, carId, customerId) VALUES ('2013-11-29', '2013-12-01', 'Horsens', 'Skanderborg', 40, 1, 1)");
         // 3b) Execute statement
         //insertStatement.executeUpdate();

         //         // Selecting
         //         // 3a) Prepare statement
          //              PreparedStatement selectStatement = connection.prepareStatement("SELECT model, brand, year, loadSize, kmDrived, litersHold, fuelType, vehicleType, availability, licencePlate, price FROM Car WHERE 1 ");
         //         // 3b) Execute statement
         //        ResultSet rs = selectStatement.executeQuery();
                  
         //         // 3c) Work with result
//                 while (rs.next())
//                  {
//                    System.out.println(rs.getString("model"));
//                    System.out.println(rs.getString("brand"));
//                    System.out.println(rs.getDate("year"));
//                    System.out.println(rs.getInt("loadSize"));
//                    System.out.println(rs.getInt("kmDrived"));
//                    System.out.println(rs.getInt("litersHold"));
//                    System.out.println(rs.getString("fuelType"));
//                    System.out.println(rs.getString("vehicleType"));
//                    System.out.println(rs.getString("availability"));
//                    System.out.println(rs.getInt("price"));
//                }
         //
         //         // Update using setInt() and setString()
         //         // 3a) Prepare statement
         //         PreparedStatement prep = connection
         //               .prepareStatement("INSERT INTO Captain (captainNumber, captainName) VALUES (?, ?)");
         //         prep.setInt(1, 2);
         //         prep.setString(2, "Nemo");
         //         // 3b) Execute statement
         //         prep.executeUpdate();
         //
         //         // Selecting using setInt()
         //         Scanner keyboard = new Scanner(System.in);
         //         System.out.print("Enter number of captain: ");
         //         int captainNumber = keyboard.nextInt();
         //         // 3a) Prepare statement
         //         prep = connection
         //               .prepareStatement("SELECT captainNumber, captainName FROM Captain WHERE captainNumber = ?");
         //         prep.setInt(1, captainNumber);
         //         // 3b) Execute statement
         //         rs = prep.executeQuery();
         //         // 3c) Work with result
         //         if (rs.next())
         //         {
         //            System.out.println(rs.getString("captainName"));
         //         }
      }
      finally
      {
         // 4. Close the connection
         connection.close();
      }
   }
}