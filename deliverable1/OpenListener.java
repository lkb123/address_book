package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class OpenListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem save = Interface.getSave();
		if(save.isEnabled()) {
			//TODO
		}
		
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(new Interface());
		
		if(returnVal == JFileChooser.APPROVE_OPTION)
			System.out.println("Open New");
		else
			System.out.println("Balik didto");

	}

}
