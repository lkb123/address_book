package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class FindListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(Interface.getSelectedIndex());

	}

}
