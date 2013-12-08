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
 * @date
 * 
 */
public class EditListener implements ActionListener {
	private JPanel formPanel, buttonPanel;
	private JButton ok, cancel;
	private JDialog d;
	private JTextField addr, city, zip, phone;
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame f = Interface.getMainFrame();
		d = new JDialog(f, "Edit Person");
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
	
	/**
	 * sets the buttons for the dialog box
	 */
	public void setButtons() {
		ActionListener a = new EditButtonListener();
		ok = new JButton("OK");
		ok.setMnemonic(KeyEvent.VK_O);
		ok.addActionListener(a);
		cancel = new JButton("Cancel");
		cancel.setMnemonic(KeyEvent.VK_A);
		cancel.addActionListener(a);
		
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
	}
	
	/**
	 * sets the forms for the dialog box
	 */
	public void setForms() {
		final int SIZE = 56;
		JLabel l;
		
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
	
	private class EditButtonListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == ok) {
				
			}
			else {
				d.dispose();
			}
			
		}
	}
} //end of class
