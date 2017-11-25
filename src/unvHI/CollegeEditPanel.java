package unvHI;

import javax.swing.JPanel;

import unvPD.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CollegeEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JButton btnEditDept;
	JButton btnDeleteDept;

	private JList list;

	/**
	 * Create the panel.
	 */
	public CollegeEditPanel(JFrame univFrame, University univ, College college, Boolean isAdd) {
		setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				college.setName(textField.getText());
				college.setAbrev(textField_1.getText());
				if (isAdd) univ.addCollege(college);
				CollegeListPanel collegeListPanel = new CollegeListPanel(univFrame,univ);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(collegeListPanel);
				univFrame.revalidate();
			}
		});
		btnSave.setBounds(87, 265, 75, 29);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CollegeListPanel collegeListPanel = new CollegeListPanel(univFrame, univ);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(collegeListPanel);
				univFrame.revalidate();	
			}
		});
		btnCancel.setBounds(188, 265, 94, 29);
		add(btnCancel);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(16, 50, 61, 16);
		add(lblName);
		
		JLabel lblAbreviation = new JLabel("Abreviation :");
		lblAbreviation.setBounds(16, 78, 94, 16);
		add(lblAbreviation);
		
		DefaultListModel listModel = new DefaultListModel();
		for (Entry<String,Department > deptEntry : college.getDepartments().entrySet())
		listModel.addElement(deptEntry.getValue());
		

		list = new JList(listModel);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.isSelectionEmpty())
				{
					btnEditDept.setEnabled(true);
					Department d = (Department) list.getSelectedValue();
					if (!d.isUsed())
						btnDeleteDept.setEnabled(true);
				}
				else
				{
					btnEditDept.setEnabled(false);
					btnDeleteDept.setEnabled(false);
				}
			}
		});
		list.setBounds(284, 78, 126, 119);
		add(list);
		
		btnEditDept = new JButton("Edit Dept");
		btnEditDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Department department = (Department) list.getSelectedValue();
				DepartmentEditPanel deptEditPanel = new DepartmentEditPanel(univFrame, univ,college,department, false,isAdd );
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(deptEditPanel);
				univFrame.revalidate();	
			}
		});
		btnEditDept.setBounds(259, 209, 94, 29);
		btnEditDept.setEnabled(false);
		add(btnEditDept);
		
		textField = new JTextField(college.getName());
		textField.setBounds(99, 44, 311, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(college.getAbrev());
		textField_1.setBounds(99, 72, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAddDept = new JButton("Add Dept");
		btnAddDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentEditPanel deptEditPanel = new DepartmentEditPanel(univFrame, univ,college,new Department(), true,isAdd);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(deptEditPanel);
				univFrame.revalidate();	
			}
		});
		btnAddDept.setBounds(349, 209, 95, 29);
		add(btnAddDept);
		
		btnDeleteDept = new JButton("Delete Dept");
		btnDeleteDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				college.removeDepartment((Department)list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				revalidate();
			}
		});
		btnDeleteDept.setBounds(293, 238, 117, 29);
		btnDeleteDept.setEnabled(false);
		add(btnDeleteDept);

	}
}
