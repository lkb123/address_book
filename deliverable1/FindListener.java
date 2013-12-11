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
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class FindListener implements ActionListener {
	protected static int startIndex;
	protected static String toFind;
	private static JButton ok, cancel;
	private JTextField input;
	private JDialog d;
	private static JPanel formPanel, buttonPanel;
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		startIndex = Interface.getSelectedIndex() + 1;
		JFrame f = Interface.getMainFrame();
		d = new JDialog(f);
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d.setPreferredSize(new Dimension(300, 120));
		d.setResizable(false);
		
		formPanel = new JPanel();
		buttonPanel = new JPanel();
		formPanel.setPreferredSize(new Dimension(290, 40));
		buttonPanel.setPreferredSize(new Dimension(290, 40));
		
		setForms();
		setButtons();
		
		d.getContentPane().add(formPanel, BorderLayout.NORTH);
		d.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		d.pack();
		d.setVisible(true);
	}

	/**
	 * 
	 */
	private void setButtons() {
		ActionListener a = new FindIteratorListener();
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
	 * 
	 */
	private void setForms() {
		input = new JTextField(20);
		JLabel l = new JLabel("Find: ");
		l.setLabelFor(input);
		formPanel.add(l);
		formPanel.add(input);
	}
	
	private class FindIteratorListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == ok) {
				AddressBook a = Interface.getAddressBook();
				JList<Entry> list = Interface.getList();
				toFind = input.getText();
				d.dispose();
				
				while(startIndex < a.getSize()) {
					if(a.getEntryAt(startIndex).getPerson().toString().contains(toFind)) {
						list.setSelectedIndex(startIndex);
						JMenuItem next = Interface.getFindNext();
						next.setEnabled(true);
						break;
					}
					startIndex++;
				}
			}
			else {
				d.dispose();
			}
			
		}
		
	}

}
