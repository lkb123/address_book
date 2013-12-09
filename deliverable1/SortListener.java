package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class SortListener implements ActionListener {
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		AddressBook a = Interface.getAddressBook();
		if(arg0.getActionCommand().equals("Sort by Name")) {
			a.sort(SortType.NAME);
		}
		else {
			a.sort(SortType.ZIP);
		}
	}

}
