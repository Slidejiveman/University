package unvHI;

import javax.swing.JPanel;

import unvPD.University;
import javax.swing.JLabel;

public class MainUPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainUPanel(University univ) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(univ.getName());
		lblNewLabel.setBounds(93, 71, 251, 16);
		add(lblNewLabel);

	}

}
