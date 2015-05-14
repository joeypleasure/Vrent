import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIManager extends JFrame {

	private JButton showcar;
	private JButton addcar;
	private JButton showcustomer;
	private JButton addcustomer;
	private JButton showreservation;
	private JButton addreservation;
	private JButton back;
	private JPanel center;
	private JLabel label1;
	private JLabel label2;
	private JTextField text;
	private CarMapper mode;
	private CarMapper carMapper;
	private CustomerMapper customerMapper;
	private ReservationMapper reservationMapper;
	JButton okay;
	JButton okay1;
	JTextField brand;
	JTextField year;
	JTextField loadSize;
	JTextField kmDrived;
	JTextField litersHold;
	JTextField fuelType;
	JTextField vehicleType;
	JTextField availability;
	JTextField licencePlate;
	JTextField price;
	JTextField name;
	JTextField license;
	JTextField phone;

	public GUIManager() {
		super("Manager");
		setSize(800, 600);

		JPanel west = new JPanel();
		center = new JPanel();

		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);

		showcar = new JButton("Show all Cars");
		showcar.addActionListener(new ShowCars());
		addcar = new JButton("Add new Car");
		addcar.addActionListener(new ShowCars());
		showcustomer = new JButton("Show all Customers");
		showcustomer.addActionListener(new ShowCars());
		addcustomer = new JButton("Add new Customer");
		addcustomer.addActionListener(new ShowCars());
		showreservation = new JButton("Show all Reservations");
		showreservation.addActionListener(new ShowCars());
		addreservation = new JButton("Add new Reservation");
		addreservation.addActionListener(new ShowCars());
		back = new JButton("Back to Frontpage");

		west.setLayout(new GridLayout(7, 1, 10, 10));
		west.add(showcar);
		west.add(addcar);
		west.add(showcustomer);
		west.add(addcustomer);
		west.add(showreservation);
		west.add(addreservation);
		west.add(back);

		center.setLayout(new FlowLayout());

		label2 = new JLabel();
		center.add(label2);

		text = new JTextField(10);
		center.add(text);
		text.addActionListener(new ShowCars());

		label1 = new JLabel();
		center.add(label1);

		// pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class ShowCars implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource().equals(showcar)) {
				label2.setText("search for a car:");

				ArrayList<Car> cars = new ArrayList<Car>();
				for (int i = 0; i < cars.size(); i++) {
					if (cars.get(i).getAvailability())
						System.out.println(cars.get(i).getModel());
					System.out.println(cars.get(i).getPrice());
				}

				String car;
				car = text.getText();

				okay = new JButton("OK");
				okay.addActionListener(new ShowCars());
				center.add(okay);
			}
			if (event.getSource().equals(okay)) {
				ArrayList<String[]> temp;
				try {
					String model = text.getText();
					mode = new CarMapper();

					temp = mode.readAvailableCars(model);
					String str = "<html>";

					for (int i = 0; i < temp.size(); i++) {
						for (int j = 0; j < temp.get(i).length; j++) {
							str += temp.get(i)[j] + " ";
						}
						str += "<br />";

					}
					str += "</html>";

					JOptionPane message = new JOptionPane();
					JOptionPane.showMessageDialog(null, str);
					// JOptionPane.showMessageDialog(null,
					// mode.readAvailableCars(model));

				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				

			}

			if (event.getSource().equals(addcar)) {

				brand = new JTextField("brand", 10);
				brand.addActionListener(new ShowCars());
				center.add(brand);

				year = new JTextField("year", 10);
				year.addActionListener(new ShowCars());
				center.add(year);

				loadSize = new JTextField("loadSize", 10);
				loadSize.addActionListener(new ShowCars());
				center.add(loadSize);

				kmDrived = new JTextField("kmdrived", 10);
				kmDrived.addActionListener(new ShowCars());
				center.add(kmDrived);

				litersHold = new JTextField("litershold", 10);
				litersHold.addActionListener(new ShowCars());
				center.add(litersHold);

				fuelType = new JTextField("fuelType", 10);
				fuelType.addActionListener(new ShowCars());
				center.add(fuelType);

				vehicleType = new JTextField("vehicleType", 10);
				vehicleType.addActionListener(new ShowCars());
				center.add(vehicleType);

				availability = new JTextField("available", 10);
				availability.addActionListener(new ShowCars());
				center.add(availability);

				licencePlate = new JTextField("licensePlate", 10);
				licencePlate.addActionListener(new ShowCars());
				center.add(licencePlate);

				price = new JTextField("price", 10);
				price.addActionListener(new ShowCars());
				center.add(price);

				label2.setText("car information:  model:  ");

				okay1 = new JButton("OK");
				okay1.addActionListener(new ShowCars());
				center.add(okay1);
			}
			if (event.getSource().equals(okay1)) {

				try {
					String model;
					model = text.getText();
					mode = new CarMapper();

					mode.create(model, brand.getText(),
							Integer.parseInt(year.getText()),
							Integer.parseInt(loadSize.getText()),
							Integer.parseInt(kmDrived.getText()),
							Integer.parseInt(litersHold.getText()),
							fuelType.getText(), vehicleType.getText(),
							Boolean.parseBoolean(availability.getText()),
							licencePlate.getText(),
							Integer.parseInt(price.getText()));

					JOptionPane.showMessageDialog(null,
							"Your car has been created!");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// JOptionPane.showMessageDialog(null, "BOOM");

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// JOptionPane.showMessageDialog(null, "damn");
				}

			}

			else if (event.getSource().equals(showcustomer)) {
				label2.setText("search for a customer:");

				
			}

			else if (event.getSource().equals(addcustomer)) {
				label2.setText("add new Customer");
				/*
				 * name = new JTextField("name", 10); name.addActionListener(new
				 * ShowCars()); center.add(name);
				 * 
				 * license = new JTextField("license", 10);
				 * license.addActionListener(new ShowCars());
				 * center.add(license);
				 * 
				 * JTextField phone = new JTextField("phoneNo", 10);
				 * phone.addActionListener(new ShowCars()); center.add(phone);
				 * 
				 * okay = new JButton("OK"); okay.addActionListener(new
				 * ShowCars()); center.add(okay); } if
				 * (event.getSource().equals(okay)) {
				 * 
				 * Customer cust = new Customer(); try {
				 * 
				 * CustomerMapper cus = new CustomerMapper();
				 * 
				 * cust = cus.create(name.getText(),
				 * Integer.parseInt(license.getText()),
				 * Integer.parseInt(phone.getText()));
				 * 
				 * } catch (SQLException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); // JOptionPane.showMessageDialog(null,
				 * "BOOM");
				 * 
				 * } catch (ClassNotFoundException e) { // TODO Auto-generated
				 * catch block e.printStackTrace(); //
				 * JOptionPane.showMessageDialog(null, "damn"); }
				 */
			}

			else if (event.getSource().equals(showreservation)) {

				label2.setText("search for a Reservation by id:");

			}

			else if (event.getSource().equals(addreservation)) {
				label2.setText("Add new Reservation");

			}
		}
	}

}
