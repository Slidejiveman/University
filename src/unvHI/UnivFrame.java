package unvHI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import unvPD.University;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UnivFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void altmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UnivFrame frame = new UnivFrame(new University());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void run(University univ) {
		try {
			UnivFrame frame = new UnivFrame(univ);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public UnivFrame(University univ) {
		UnivFrame currentFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUniversity = new JMenu("University");
		menuBar.add(mnUniversity);
		
		JMenuItem mntmUnversity = new JMenuItem("Unversity");
		mntmUnversity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new UniversityEditPanel(currentFrame,univ));
				getContentPane().revalidate();
			}
		});
		mnUniversity.add(mntmUnversity);
		
		JMenuItem mntmColleges = new JMenuItem("Colleges");
		mntmColleges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CollegeListPanel(currentFrame,univ));
				getContentPane().revalidate();
			}
		});
		mnUniversity.add(mntmColleges);
		
		JMenuItem mntmFaculty = new JMenuItem("Faculty");
		mntmFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new FacultyListPanel(currentFrame,univ));
				getContentPane().revalidate();
			}
		});
		mnUniversity.add(mntmFaculty);
		
		JMenuItem mntmCourses = new JMenuItem("Courses");
		mntmCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnUniversity.add(mntmCourses);
		
		JMenu mnSemesters = new JMenu("Semesters");
		menuBar.add(mnSemesters);
		
		JMenuItem mntmSemesters = new JMenuItem("Semesters");
		mnSemesters.add(mntmSemesters);
		
		JMenuItem mntmGenerateSections = new JMenuItem("Generate Sections");
		mnSemesters.add(mntmGenerateSections);
		
		JMenu mnStudents = new JMenu("Students");
		menuBar.add(mnStudents);
		
		JMenuItem mntmStudents = new JMenuItem("Students");
		mnStudents.add(mntmStudents);
		
		JMenuItem mntmEnroll = new JMenuItem("Enroll");
		mnStudents.add(mntmEnroll);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		contentPane = new MainUPanel(univ);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
