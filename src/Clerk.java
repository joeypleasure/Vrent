import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Clerk extends JFrame
{

   private JTextField DaysBooked;
   private JLabel label;

   private JTextField brand;
   private JLabel label2;

   private JTextField model;
   private JLabel label3;

   private JButton Price;

   private JLabel FindCustomer;
   private JTextField CustomerName;
   private JTextField CustomerPhoneNo;
   private JButton Search;
   private Car car;
   private CarMapper carMapper;
   private CustomerMapper customerMapper;

   public Clerk() throws ClassNotFoundException
   {
      super("Clerk menu");
      setLayout(new GridLayout(11, 3));
      setSize(400, 400);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      label = new JLabel("Reserve duration(in days)");
      DaysBooked = new JTextField("0", 2);
      label2 = new JLabel("Brand");
      brand = new JTextField("0", 2);

      label3 = new JLabel("model");
      model = new JTextField("0", 2);
      Price = new JButton("Price");
      Price.setPreferredSize(new Dimension(40, 40));
      FindCustomer = new JLabel("Find Customer");
      CustomerName = new JTextField("Name:");
      CustomerPhoneNo = new JTextField("Phone number:");
      Search = new JButton("Search:");
      carMapper = new CarMapper();
      customerMapper = new CustomerMapper();

      Price.addActionListener(new ButtonListener());
      Search.addActionListener(new ButtonListener());
      add(label);
      add(DaysBooked);
      add(label2);
      add(brand);
      add(label3);
      add(model);
      add(Price);
      add(FindCustomer);
      add(CustomerName);
      add(CustomerPhoneNo);
      add(Search);
   }

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource().equals(Price))
         {
            int price = 0;

            String[] input = new String[2];
            if (e.getSource().equals(Price))
            {
               input[0] = brand.getText();
               input[1] = model.getText();
               

               try
               {
                  price = carMapper.carSelect(input[0].toString(),
                        input[1].toString());

                  int DaysBook = Integer.parseInt(DaysBooked.getText());
                  
                  JOptionPane.showMessageDialog(null, brand.getText() + "\n"
                        + model.getText() + "\n" + "Price for a day: " + price
                        + "\nThe Total Price: " + price * DaysBook);

               }
               catch (ClassNotFoundException | SQLException e1)
               {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }

            }
         }
         if (e.getSource().equals(Search))
         {
            int customerId = 0;

            String[] input = new String[2];
            if (e.getSource().equals(Search))
            {
               input[0] = CustomerName.getText();
               input[1] = CustomerPhoneNo.getText();
               int id = Integer.parseInt(input[1].toString());

               try
               {

                  customerId = customerMapper.CustomerSelect(input[0].toString(),id);

               

               }

               catch (ClassNotFoundException | SQLException e2)
               {
                  // TODO Auto-generated catch block
                  e2.printStackTrace();
               }
               Reservation reserve;
               try
               {
                  reserve = customerMapper.carReservation(customerId);
                  JOptionPane.showMessageDialog(null,"Reservation for  customer:"+ CustomerName.getText() + "\n" +
                 "Phone number:" + CustomerPhoneNo.getText() + "\n"+ customerMapper.carReservation(customerId) );
                      
               } 
               catch (ClassNotFoundException e1)
               {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }
               catch (SQLException e1)
               {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }
            }
         }

      }
   }
}

