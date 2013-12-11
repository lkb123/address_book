package deliverable1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Louie Kert Basay
 * @date 12-07-13
 * 
 */
public class AddListener implements ActionListener {
	private JPanel formPanel, buttonPanel;
	private JButton ok, cancel;
	private JDialog d;
	private JTextField fname, lname, addr, city, zip, phone;
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame f = Interface.getMainFrame();
		d = new JDialog(f, "Add new Person");
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d.setPreferredSize(new Dimension(730, 250));
		
		formPanel = new JPanel();
		buttonPanel = new JPanel();
		formPanel.setPreferredSize(new Dimension(290, 160));
		buttonPanel.setPreferredSize(new Dimension(290, 50));
		setForms();
		setButtons();
		d.getContentPane().add(formPanel, BorderLayout.NORTH);
		d.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		d.pack();
		d.setVisible(true);
	}
	
	private void setForms() {
		final int SIZE = 56;
		//first name
		fname = new JTextField(SIZE);
		JLabel l = new JLabel("First Name: ");
		l.setLabelFor(fname);
		formPanel.add(l);
		formPanel.add(fname);
		
		//last name
		lname = new JTextField(SIZE);
		l = new JLabel("Last Name: ");
		l.setLabelFor(lname);
		formPanel.add(l);
		formPanel.add(lname);
		
		//address
		addr = new JTextField(SIZE + 1);
		l = new JLabel("Address: ");
		l.setLabelFor(addr);
		formPanel.add(l);
		formPanel.add(addr);
		
		//city
		city = new JTextField(SIZE + 4);
		l = new JLabel("City: ");
		l.setLabelFor(city);
		formPanel.add(l);
		formPanel.add(city);
		
		//zip
		zip = new JTextField(SIZE + 4);
		l = new JLabel("Zip: ");
		l.setLabelFor(zip);
		formPanel.add(l);
		formPanel.add(zip);
		
		//phone
		phone = new JTextField(SIZE);
		l = new JLabel("Phone: ");
		l.setLabelFor(phone);
		formPanel.add(l);
		formPanel.add(phone);
	}

	/**
	 * Adds the buttons for the dialog box
	 */
	private void setButtons() {
		ActionListener a = new AddButtonListener();
		ok = new JButton("OK");
		ok.setMnemonic(KeyEvent.VK_O);
		ok.addActionListener(a);
		cancel = new JButton("Cancel");
		cancel.setMnemonic(KeyEvent.VK_A);
		cancel.addActionListener(a);
		
		
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
	}
	
	private class AddButtonListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == ok) {
				try {
					AddressBook a = Interface.getAddressBook();
					String nFname = fname.getText();
					String nLname = lname.getText();
					String nAddr = addr.getText();
					String nCity = city.getText();
					String nZip = zip.getText();
					String nPhone = phone.getText();
					
					Address addr = new Address(nAddr, nCity, nZip);
					Phone ph = new Phone(nPhone);
					Person pe = new Person(nFname, nLname, addr, ph);
					Entry e = new Entry(pe);
					a.addPerson(e);
					d.dispose();
					Interface.getSave().setEnabled(true);
					
				}
				catch (NullPointerException e) {
					System.err.println("Missing Field");
					System.exit(-1);
				}
			}
			else if(arg0.getSource() == cancel) {
				d.dispose();
			}
		}
		
	}

}
