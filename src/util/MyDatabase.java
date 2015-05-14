package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyDatabase
{
private String driver = "com.mysql.jdbc.Driver";
private String url = "jdbc:mysql://localhost/";
private String user = "root";
private String pw = "";
private Connection connection;

public MyDatabase(String driver, String url, String user, String pw)
throws ClassNotFoundException
{
this.driver = driver;
this.url = url;
this.user = user;
this.pw = pw;
connection = null;
Class.forName(driver);
}


public MyDatabase(String databaseName, String user, String pw)
throws ClassNotFoundException
{
this.url = url + databaseName;
this.user = user;
this.pw = pw;
connection = null;
Class.forName(driver);
}

public MyDatabase(String databaseName) throws ClassNotFoundException
{
Class.forName(driver);
this.url = url + databaseName;
connection = null;
}

private void openDatabase() throws SQLException
{
connection = DriverManager.getConnection(url, user, pw);
}

private void closeDatabase() throws SQLException
{
connection.close();
}

public ArrayList<Object[]> query(String sql, Object... args)
throws SQLException
{
openDatabase();
PreparedStatement statement = null;
ResultSet resultSet = null;
try
{
statement = connection.prepareStatement(sql);
for (int i = 0; i < args.length; i++)
{
statement.setObject(i + 1, args[i]);
}
resultSet = statement.executeQuery();
ArrayList<Object[]> list = new ArrayList<Object[]>();
while (resultSet.next())
{
Object[] elements = new Object[resultSet.getMetaData()
.getColumnCount()];
for (int i = 0; i < elements.length; i++)
{
elements[i] = resultSet.getObject(i + 1);
}
list.add(elements);
}
return list;
} finally
{
if (resultSet != null)
resultSet.close();
if (statement != null)
statement.close();
closeDatabase();
}
}

public int update(String sql, Object... args) throws SQLException
{
openDatabase();
int rowCount = 0;
PreparedStatement statement = null;
try
{
statement = connection.prepareStatement(sql);
for (int i = 0; i < args.length; i++)
{
statement.setObject(i + 1, args[i]);
}
rowCount = statement.executeUpdate();
return rowCount;
} finally
{
if (statement != null)
statement.close();
closeDatabase();
}
}
}
