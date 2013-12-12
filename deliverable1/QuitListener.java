package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
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
		JMenuItem save = Interface.getSave();
		if(save.isEnabled()) {
			String s = "There are unsaved files. Want to save before exit?";
			int choice = JOptionPane.showConfirmDialog(null, s, s, JOptionPane.YES_NO_CANCEL_OPTION);
			JFrame f = Interface.getMainFrame();
			if(choice == JOptionPane.YES_OPTION) {
				if(f.getTitle().equals("Untitled")) {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showSaveDialog(f);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File selected = fc.getSelectedFile();
						String file = selected.getAbsolutePath();
						try {
							new Writer(file + ".json");
						} catch (FileNotFoundException e1) {
							;
						}
					}
				}
				else {
					String file = f.getTitle();
					try {
						new Writer(file);
					} catch (FileNotFoundException e1) {
						;
					}
				}
				System.exit(0);
			}
			else if(choice == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
			else {
				; //do nothing
			}
		}
		else {
			System.exit(0);
		}
	}

}
