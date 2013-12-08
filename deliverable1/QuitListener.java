package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public final class QuitListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = "Are you sure you want to quit?";
		int choice = JOptionPane.showConfirmDialog(null, s, s, JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION)
			System.exit(0);
	}

}
