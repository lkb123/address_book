package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class FindIteratorListener extends FindListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int currentIndex = Interface.getSelectedIndex();
		AddressBook a = Interface.getAddressBook();
		JList<Entry> l = Interface.getList();
		System.out.println(FindListener.toFind + currentIndex);
		currentIndex++;
		while(currentIndex < a.getSize()) {
			if(a.getEntryAt(currentIndex).getPerson().toString().contains(FindListener.toFind)) {
				l.setSelectedIndex(currentIndex);
				break;
			}
			currentIndex++;
		}
	}

}
