
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class HandyMan extends JFrame
{
   public HandyMan() throws ClassNotFoundException
   {
      
      
      
      // Creating the JFrame Main Window and setting it
      super("Handyman's Window View");
//      JFrame window = new JFrame();
      setSize(800, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JButton returnedCars = new JButton("See returned cars");
      JButton todaysReserved = new JButton("Reserved cars for today");
      setLayout(new BorderLayout());
      // Creating the JPane for the  Buttons
      JPanel buttons = new JPanel();
     
      
     

      buttons.setLayout(new GridLayout(2,1,10,10));
      buttons.add(returnedCars);
      buttons.add(todaysReserved);
      add(buttons, BorderLayout.WEST);
     
      final JPanel center =  new JPanel();
      center.setLayout(new FlowLayout());
      JLabel background=new JLabel(new ImageIcon("C:\\Users\\asus1\\Downloads\\techart-gt-sport.jpg"));
      center.add(background);
      final ReservationMapper mapper = new ReservationMapper();
      
      // This is for Today's reserved Cars List
      
      
      final JLabel list= new JLabel();
      final JLabel list2 = new JLabel(); 
      final JLabel list3 = new JLabel();
      
      returnedCars.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {  
            ArrayList<String[]> temp;
            try
            {
               temp = mapper.seeReturnedCars();
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
      
      todaysReserved.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e2)
         {  
            ArrayList<String[]> temp;
            try
            {
               temp = mapper.todayReservedCars();
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
      
      
   }
  
}