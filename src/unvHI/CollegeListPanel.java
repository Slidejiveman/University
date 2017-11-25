package unvHI;

import javax.swing.JPanel;


import unvPD.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class CollegeListPanel extends JPanel {

	private JList list;
	JButton btnEdit;
	JButton btnDelete;
	DefaultListModel listModel;
	/**
	 * Create the panel.
	 */
	public CollegeListPanel(JFrame univFrame,University univ) {
		setLayout(null);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CollegeEditPanel collegeEditPanel = 
						new CollegeEditPanel(univFrame,univ, (College)list.getSelectedValue(), false);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(collegeEditPanel);
				univFrame.revalidate();	
			}
		});
		btnEdit.setBounds(37, 226, 117, 29);
		btnEdit.setEnabled(false);
		add(btnEdit);
		
		JButton btnAdd = new JButton("Add");;
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CollegeEditPanel collegeEditPanel = 
						new CollegeEditPanel(univFrame,univ,new College(), true);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(collegeEditPanel);
				univFrame.revalidate();	
			}
		});
		btnAdd.setBounds(166, 226, 117, 29);
		add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				univ.removeCollege((College)list.getSelectedValue());
				listModel.removeElement((College)list.getSelectedValue());
			}
		});
		btnDelete.setBounds(284, 226, 117, 29);
		btnDelete.setEnabled(false);
		add(btnDelete);
		
		listModel = new DefaultListModel();
		for (Entry<String, College> collegeEntry : univ.getColleges().entrySet())
		listModel.addElement(collegeEntry.getValue());
		
		list = new JList(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			if (list.isSelectionEmpty())
			{
				 btnDelete.setEnabled(false);
				 btnEdit.setEnabled(false);
			}
			else
			{
				College c = (College)list.getSelectedValue();
			 	if (!c.isUsed() )
			 		btnDelete.setEnabled(true);
			 	else 
			 		btnDelete.setEnabled(false);
			 		
			 	btnEdit.setEnabled(true);
			}
				 
			}
		});
		list.setBounds(112, 34, 206, 180);
		add(list);

	}
}
