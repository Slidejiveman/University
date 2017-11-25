package unvHI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import unvPD.FacultyMember;
import unvPD.University;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultyListPanel extends JPanel {
	int facultyListIndex;
	/**
	 * Create the panel.
	 */
	public FacultyListPanel(JFrame univFrame, University univ) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyEditPanel facultyEditPanel = new FacultyEditPanel(univFrame,univ, univ.getFacultyForIndex(facultyListIndex), false);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(facultyEditPanel);
				univFrame.revalidate();
			}
		});
		btnNewButton.setBounds(53, 230, 117, 29);
		add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyEditPanel facultyEditPanel = new FacultyEditPanel(univFrame,univ, new FacultyMember(), true);
				univFrame.getContentPane().removeAll();
				univFrame.getContentPane().add(facultyEditPanel);
				univFrame.revalidate();
			}
		});
		btnAdd.setBounds(173, 230, 117, 29);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(293, 230, 117, 29);
		add(btnDelete);
		
		JList list = new JList(univ.getFacultyList());
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				facultyListIndex = ((JList) e.getSource()).getSelectedIndex();
			}
		});
		list.setBounds(123, 39, 220, 166);
		add(list);

	}
}
