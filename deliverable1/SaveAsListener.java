package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class SaveAsListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame f = Interface.getMainFrame();
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(f);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File selected = fc.getSelectedFile();
			String file = selected.getAbsolutePath();
			try {
				new Writer(file + ".json");
				f.setTitle(file);
			} catch (FileNotFoundException e1) {
				;
			}
		}
		Interface.getSave().setEnabled(false);
	}
}
