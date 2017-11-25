package unvHI;

import javax.swing.JPanel;

import unvPD.College;
import unvPD.Department;
import unvPD.University;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DepartmentEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public DepartmentEditPanel(JFrame univFrame, University univ, College college, Department dept, Boolean isNew, Boolean isNewCollege) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept.setName(textField.getText());
				dept.setCode(textField_1.getText());
				if (isNew) college.addDepartment(dept);
				CollegeEditPanel collegeEditPanel = new CollegeEditPanel(univFrame,univ,college,isNewCollege);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(collegeEditPanel);
				univFrame.revalidate();
			}
		});
		btnNewButton.setBounds(47, 230, 117, 29);
		add(btnNewButton);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(47, 56, 61, 16);
		add(lblName);
		
		JLabel lblCode = new JLabel("Code :");
		lblCode.setBounds(47, 95, 61, 16);
		add(lblCode);
		
		textField = new JTextField(dept.getName());
		textField.setBounds(112, 50, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(dept.getCode());
		textField_1.setBounds(112, 89, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CollegeEditPanel collegeEditPanel = new CollegeEditPanel(univFrame,univ,college,isNewCollege);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(collegeEditPanel);
				univFrame.revalidate();
			}
		});
		btnCancel.setBounds(160, 230, 117, 29);
		add(btnCancel);
		
		

	}
}
