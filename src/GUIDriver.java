import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class GUIDriver extends JFrame
{
   public GUIDriver() throws ClassNotFoundException
   {
      // Creating the JFrame Main Window and setting it
      super("Driver's Window View");
      JFrame window = new JFrame();
      setSize(800, 400);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLayout(new BorderLayout());

      // Creating the JPane for the  Buttons
      JPanel buttons = new JPanel();
      


      // Here are the Buttons on the left site
      JButton driveToLocation = new JButton("Drive To Locations");
      JButton pickUpLocation = new JButton("Pick Up Locations");
      JButton reservedCars = new JButton("Today's reserved Cars");
      buttons.setLayout(new GridLayout(3,1,5,5));
      buttons.add(driveToLocation);
      buttons.add(pickUpLocation);
      buttons.add(reservedCars);
      add(buttons, BorderLayout.WEST);
      

      // Create a Center Panel - Here I need The Tables Views for every Button to appear
      final JPanel center =  new JPanel();
      center.setLayout(new FlowLayout());
      JLabel background=new JLabel(new ImageIcon("C:\\Users\\Pia Kjær\\Desktop\\LAST-SEP\\im.jpg"));
      center.add(background);
      final ReservationMapper mapper = new ReservationMapper();
      
      // This is for Today's reserved Cars List
      
      
      final JLabel list= new JLabel();
      final JLabel list2 = new JLabel(); 
      final JLabel list3 = new JLabel();
//      center.add(list);
//      center.add(list2);
//      center.add(list3);
      
      center.setBackground(Color.WHITE);
      center.setBorder(BorderFactory.createLoweredBevelBorder());
      add(center, BorderLayout.CENTER);
      center.setAutoscrolls(rootPaneCheckingEnabled);
      
      // Action Listeners for every button
      pickUpLocation.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {  
            ArrayList<String[]> temp;
            try
            {
               temp = mapper.seePickUpLocations();
               String str="<html>";
               
               for(int i = 0; i < temp.size(); i++)
               {
                  for(int j = 0; j < temp.get(i).length; j++)
                  {
                     str+=temp.get(i)[j] + " ";
                  }
                  str+="<br />";
                  
               }
               str += "</html>";
              
               center.add(list);
               list.setText(str);
               
               JOptionPane message = new JOptionPane();
               JOptionPane.showMessageDialog(null,list);
               
            }
            catch (SQLException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            
         }
         
      });
      
      
      driveToLocation.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e2)
         {  
            ArrayList<String[]> temp;
            try
            {
               temp = mapper.seeDriveToLocations();
               String str="<html>";
               
               for(int i = 0; i < temp.size(); i++)
               {
                  for(int j = 0; j < temp.get(i).length; j++)
                  {
                     str+=temp.get(i)[j] + " ";
                  }
                  str+="<br />";
                  
               }
               str += "</html>";
              
               center.add(list2);
               list2.setText(str);
               
               JOptionPane message = new JOptionPane();
               message.showMessageDialog(null, list2);
               
              
            }
            catch (SQLException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            
         }
         
      });
      
      reservedCars.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e3)
         {  
            ArrayList<String[]> temp;
            try
            {
               temp = mapper.seeAllReservations();
               String str="<html>";
               
               for(int i = 0; i < temp.size(); i++)
               {
                  for(int j = 0; j < temp.get(i).length; j++)
                  {
                     str+=temp.get(i)[j] + " ";
                  }
                  str+="<br />";
                  
               }
               str += "</html>";
              
               center.add(list3);
               list3.setText(str);
               
               JOptionPane message = new JOptionPane();
               message.showMessageDialog(null, list3);
               
            }
            catch (SQLException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            
         }
         
      });
   }

   
   public static void main(String[] args) throws ClassNotFoundException
   {
      JFrame window = null;
      try
      {
         window = new GUIDriver();
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      window.setVisible(true);
      window.setResizable(false);
      window.setLocationRelativeTo(null);
   }

}
