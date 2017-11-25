package unvHI;

import javax.swing.JPanel;

import unvPD.University;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UniversityEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public UniversityEditPanel(JFrame currentFrame, University univ) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University :");
		lblNewLabel.setBounds(43, 74, 86, 16);
		add(lblNewLabel);
		
		JLabel lblAbreviation = new JLabel("Abreviation :");
		lblAbreviation.setBounds(45, 102, 86, 16);
		add(lblAbreviation);
		
		textField = new JTextField(univ.getName());
		textField.setBounds(143, 68, 208, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(univ.getAbbreviation());
		textField_1.setBounds(143, 96, 69, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(univ.getNickName());
		textField_2.setBounds(143, 128, 134, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNickname = new JLabel("Nickname :");
		lblNickname.setBounds(43, 130, 88, 16);
		add(lblNickname);
		
		JLabel lblEditUniverstiy = new JLabel("Edit Universtiy");
		lblEditUniverstiy.setBounds(162, 25, 140, 16);
		add(lblEditUniverstiy);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				univ.setName(textField.getText());
				univ.setAbbreviation(textField_1.getText());
				univ.setNickName(textField_2.getText());
				
				MainUPanel mainUPanel = new MainUPanel(univ);
				currentFrame.getContentPane().removeAll();
				currentFrame.add(mainUPanel);
				currentFrame.revalidate();
			}
		});
		btnSave.setBounds(60, 216, 117, 29);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUPanel mainUPanel = new MainUPanel(univ);
				currentFrame.getContentPane().removeAll();
				currentFrame.add(mainUPanel);
				currentFrame.revalidate();
			}
		});
		btnCancel.setBounds(234, 216, 117, 29);
		add(btnCancel);

	}
}
