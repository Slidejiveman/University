package unvHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import unvPD.Department;
import unvPD.FacultyMember;
import unvPD.University;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultyEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public FacultyEditPanel(JFrame univFrame,University univ, FacultyMember facultyMember, Boolean isAdd) {
		setLayout(null);
		
		JButton btnAdd = new JButton("Save");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facultyMember.setName(textField.getText());
				facultyMember.setOffice(textField_1.getText());
				facultyMember.setEmail(textField_2.getText());
				
				if (isAdd) {
					facultyMember.setDepartment((Department)comboBox.getSelectedItem());
					univ.addFaculty(facultyMember);
					facultyMember.getDepartment().addFaculty(facultyMember);
				}
				else
				{
					if (facultyMember.getDepartment()!=(Department)comboBox.getSelectedItem())
					{
						facultyMember.getDepartment().removeFaculty(facultyMember);
						facultyMember.setDepartment((Department)comboBox.getSelectedItem());
						facultyMember.getDepartment().addFaculty(facultyMember);
					}
				}
				FacultyListPanel facultyListPanel = new FacultyListPanel(univFrame,univ);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(facultyListPanel);
				univFrame.revalidate();
			}
		});
		btnAdd.setBounds(78, 226, 117, 29);
		add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyListPanel facultyListPanel = new FacultyListPanel(univFrame,univ);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(facultyListPanel);
				univFrame.revalidate();
			}
		});
		btnCancel.setBounds(240, 226, 117, 29);
		add(btnCancel);
		
		textField = new JTextField(facultyMember.getName());
		textField.setBounds(154, 47, 203, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(39, 53, 61, 16);
		add(lblName);
		
		JLabel lblOfice = new JLabel("Office :");
		lblOfice.setBounds(39, 96, 61, 16);
		add(lblOfice);
		
		textField_1 = new JTextField(facultyMember.getOffice());
		textField_1.setBounds(154, 90, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(facultyMember.getEmail());
		textField_2.setBounds(154, 127, 203, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(39, 133, 61, 16);
		add(lblEmail);
		
		DefaultComboBoxModel deptList = new DefaultComboBoxModel(univ.getDepartments().toArray());
		comboBox = new JComboBox(deptList);
		System.out.println("Fac Dept:"+facultyMember.getName());
		if(!isAdd) comboBox.setSelectedItem(facultyMember.getDepartment());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(154, 167, 134, 27);
		add(comboBox);
		
		JLabel lblDepartment = new JLabel("Department : ");
		lblDepartment.setBounds(39, 171, 103, 16);
		add(lblDepartment);

	}
}
