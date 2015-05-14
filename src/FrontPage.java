

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPage extends JFrame
{
JButton handyman=new JButton("Handyman");
JButton manager=new JButton("Manager");
JButton Clerk=new JButton("Clerk");
JButton driver=new JButton("Driver");
private JPanel buttons= new JPanel();
private JLabel text=new JLabel();

GUIDriver driv= new GUIDriver();
HandyMan handy = new HandyMan();
Clerk clerky=new Clerk();
GUIManager man = new GUIManager();



public FrontPage() throws ClassNotFoundException{

super("Front Page");
setSize(400,400);
JFrame window= new JFrame();
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setLayout(new BorderLayout());
setLayout(new GridLayout(2,2));
setVisible(true);



manager.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
Clerk.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
handyman.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
driver.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
Clerk.addActionListener(new ButtonListener());
handyman.addActionListener(new ButtonListener());
manager.addActionListener(new ButtonListener());
driver.addActionListener(new ButtonListener());

JPanel panel= new JPanel();
panel.add(manager);
panel.add(Clerk);
panel.add(handyman);
panel.add(driver);



add(manager);
add(Clerk);
add(handyman);
add(driver);

}
public static void main (String[] args) throws ClassNotFoundException
{
new FrontPage();

}

class ButtonListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{

  if(e.getSource().equals(handyman))
{
dispose();
handy.setVisible(true);

}
else if(e.getSource().equals(Clerk))
{

dispose();
clerky.setVisible(true);
clerky.setResizable(false);
}
else if(e.getSource().equals(manager))
{

dispose();
man.setVisible(true);

}
else if(e.getSource().equals(driver))
{

dispose();
driv.setVisible(true);

}
  

}
}}