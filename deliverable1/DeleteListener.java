package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class DeleteListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = "Are you sure you want to delete this entry?";
		int choice = JOptionPane.showConfirmDialog(null, s, s, JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			AddressBook a = Interface.getAddressBook();
			int selected = Interface.getSelectedIndex();
			a.deletePerson(selected);
			Interface.deleteToList(selected);
		}
	}

}
