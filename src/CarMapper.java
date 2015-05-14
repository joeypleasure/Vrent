

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.MyDatabase;



public class CarMapper
{
   public CarMapper() throws ClassNotFoundException
   {
      Class.forName("com.mysql.jdbc.Driver");
   }

   public Car create(String model, String brand, int year, int loadSize, int kmDrived, int litersHold, String fuelType, String vehicleType, boolean availability, String licencePlate, int price) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("INSERT INTO Car(model, brand, year, loadSize, kmDrived, litersHold, fuelType, vehicleType, availability, licencePlate, price) VALUES (?, ?, ?, ?,?, ?, ?, ?,?,?,?)");
         statement.setString(1, model);
         statement.setString(2, brand);
         statement.setInt(3, year);
         statement.setInt(4, loadSize);
         statement.setInt(5, kmDrived);
         statement.setInt(6, litersHold);
         statement.setString(7, fuelType);
         statement.setString(8, vehicleType);
         statement.setBoolean(9, availability);
         statement.setString(10, licencePlate);
         statement.setInt(11, price);
         statement.executeUpdate();
         Car car = new Car();
         return car;
      }
      finally
      {
         connection.close();
      }
   }

   public Car readAfterId(int id) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("Select * FROM Car WHERE id = ?");
         statement.setInt(1, id);
         ResultSet rs = statement.executeQuery();
         if (rs.next()) 
         {
            String model = rs.getString("model");
            String brand = rs.getString("brand");
            int year = rs.getInt("year");
            int loadSize = rs.getInt("loadSize");
            int kmDrived = rs.getInt("kmDrived");
            int litersHold = rs.getInt("litersHold");
            String fuelType = rs.getString("fuelType");
            String vehicleType = rs.getString("vehicleType");
            String licencePlate = rs.getString("licencePlate");
            boolean availability = rs.getBoolean("availability");
            int price = rs.getInt("price");

            Car car = new Car();
            return car;
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


   public ArrayList<String[]> readAvailableCars(String model) throws SQLException, Exception
   {
	   ArrayList<String[]> data = new ArrayList<>();
	      Connection connection = DriverManager.getConnection(
	            "jdbc:mysql://localhost/v_rent", "root", "");
	      try
	      {
	         PreparedStatement statement = connection
	               .prepareStatement("SELECT * FROM Car WHERE availability=1 AND model = ?");
	         statement.setString(1, model);
	         ResultSet rs = statement.executeQuery();
	         System.out.println("These are the available cars!");
	         System.out.println("----------------------------");
	         while (rs.next()) 
	         {
	            String[] row = {" Car Id : " + rs.getInt("id")  + " Model : " + rs.getString("model") + " Brand: " + rs.getString("brand") + " Licence Plate: " + rs.getString("licencePlate")};
	            System.out.println("Car Id: " + rs.getInt("id"));
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

   public void delete(int id) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("DELETE FROM Car WHERE id = ?");
         statement.setInt(1, id);
         statement.executeUpdate();
      }
      finally
      {
         connection.close();
      }
   }
   
   public int carSelect(String brand, String model) throws SQLException,
   ClassNotFoundException
{


String sql = ("SELECT price FROM Car where model = ? and brand = ?");

MyDatabase db = new MyDatabase("v_rent","root","");

ArrayList<Object[]> datalist = db.query(sql, model, brand);

int price = 0;
for (int i = 0; i < datalist.size(); i++)
{
   Object[] row = datalist.get(i);

   price = Integer.parseInt(row[0].toString());

}

System.out.println(price);
return price;
}

}
