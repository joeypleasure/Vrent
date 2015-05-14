

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import util.MyDatabase;



public class CustomerMapper
{
   public CustomerMapper() throws ClassNotFoundException
   {
      Class.forName("com.mysql.jdbc.Driver");
   }

   public Customer create(String name, int phoneNo, int licence) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("INSERT INTO Customer(name, phoneNo, licence) VALUES (?, ?, ?)");
         statement.setString(1, name);
         statement.setInt(2, phoneNo);
         statement.setInt(3, licence);
         statement.executeUpdate();
         Customer customer = new Customer();
         return customer;
      }
      finally
      {
         connection.close();
      }
   }

   public Customer readAfterId(int id) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection
               .prepareStatement("Select * FROM Customer WHERE id = ?");
         statement.setInt(1, id);
         ResultSet rs = statement.executeQuery();
         if (rs.next()) 
         {
            String name = rs.getString("name");
            int phoneNo = rs.getInt("phoneNo");
            int licence = rs.getInt("licence");

            Customer customer = new Customer();
            return customer;
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


   public Customer readByPhoneNo(int phone) throws SQLException
   {
      Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/v_rent", "root", "");
      try
      {
         PreparedStatement statement = connection.prepareStatement("Select * FROM Customer WHERE phoneNo = ?");
         statement.setInt(1, phone);
         ResultSet rs = statement.executeQuery();
         if(rs.next()) 
         {

            if(rs.next())
            {
               String name = rs.getString("name");
               phone = rs.getInt("phoneNo");
               int licence = rs.getInt("licence");
              
               Customer customer = new Customer();
               return customer;
            }
            else
            {
               return null;
            }
         }
      }
      finally
      {
         connection.close();
      }
      return null;
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
   public int CustomerSelect(String name,int phoneNo) throws SQLException,
   ClassNotFoundException
{


String sql = ("SELECT id FROM Customer where name = ? and phoneNo = ?");

MyDatabase db = new MyDatabase("v_rent","root","");

ArrayList<Object[]> datalist = db.query(sql, name, phoneNo);

int id = 0;
for (int i = 0; i < datalist.size(); i++)
{
   Object[] row = datalist.get(i);
          
   id = Integer.parseInt(row[0].toString());//(row[0].toString());

} 
System.out.println(id);
return id;
}
   public Reservation carReservation(int customerId) throws SQLException,
   ClassNotFoundException
{


String sql = ("SELECT * FROM reservation where customerId=?");

MyDatabase db = new MyDatabase("v_rent","root","");

ArrayList<Object[]> datalist = db.query(sql, customerId);


if (datalist.size() > 0) {
   Object[] row = datalist.get(0);
   Date pickUpTime = (Date) row [1];
   Date returnTime = (Date) row [2];
   String locationPickUp = (String) row [3];
   String locationReturn = (String) row [4];
   int kmWantToDrive = (Integer) row [5];
   int customer = (Integer) row [6];

Reservation reserve = new Reservation();
return reserve;
}else return null;
}
 

}