import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;


public class GUI {

	private JFrame frmEyeOfThe;
	private JTable admin_view;
	private static Call call;
	private JTable stu_view;
	private JTable cl_view;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmEyeOfThe.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		call = new Call();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEyeOfThe = new JFrame();
		frmEyeOfThe.setResizable(false);
		frmEyeOfThe.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/pics/Eye Of The Tiger Logo.png")));
		frmEyeOfThe.setTitle("Eye of The Tiger");
		frmEyeOfThe.setBounds(100, 100, 436, 310);
		frmEyeOfThe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JTabbedPane admin = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Administrator", null, admin, null);
		tabbedPane.setBackgroundAt(0, new Color(240, 240, 240));
		
		
		admin_view = new JTable();
		
		JPanel view_admin = new JPanel();
		view_admin.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				/////////////////////////////////////////////////////////////////////////////////////////////
				DefaultTableModel dtm = new DefaultTableModel(0, 0);
				String header[] = {"First Name", "Last Name", "Timetable"};
				dtm.setColumnIdentifiers(header);
				admin_view.setModel(dtm);
				dtm.addRow(header);
				ArrayList<String[]> data = call.getAdminData();
				for(String[] d: data){ dtm.addRow(d); }
				///////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});

		admin.addTab("view", null, view_admin, null);
		view_admin.setLayout(new MigLayout("", "[384px]", "[193px]"));
		
		
		admin_view.setRowSelectionAllowed(false);

		view_admin.add(admin_view, "cell 0 0,grow");
		
		JPanel add_admin = new JPanel();
		admin.addTab("add", null, add_admin, null);
				
		final JFormattedTextField admin_first_name = new JFormattedTextField();
		final JFormattedTextField admin_last_name = new JFormattedTextField();
		final JFormattedTextField admin_timetable = new JFormattedTextField();
		
		JLabel lblFirstName = new JLabel("First Name:");
		JLabel label = new JLabel("Last Name:");
		JLabel label_1 = new JLabel("Timetable:");
		
		JButton admin_add = new JButton("Add");
		admin_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!admin_first_name.getText().isEmpty() && !admin_last_name.getText().isEmpty() && !admin_timetable.getText().isEmpty()){
					/////////////////////////////////////////////////////////////////////////////////////////////////////////
					call.createAdmin(admin_first_name.getText(), admin_last_name.getText(), admin_timetable.getText());
					admin_first_name.setText("");
					admin_last_name.setText("");
					admin_timetable.setText("");
					//////////////////////////////////////////////////////////////////////////////////////////////////////////
				}
			}
		});
		GroupLayout gl_add_admin = new GroupLayout(add_admin);
		gl_add_admin.setHorizontalGroup(
			gl_add_admin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_add_admin.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addGroup(gl_add_admin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_add_admin.createSequentialGroup()
							.addGroup(gl_add_admin.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFirstName)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_add_admin.createParallelGroup(Alignment.LEADING, false)
								.addComponent(admin_timetable, Alignment.TRAILING)
								.addComponent(admin_last_name, Alignment.TRAILING)
								.addComponent(admin_first_name, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
							.addGap(102))
						.addGroup(Alignment.TRAILING, gl_add_admin.createSequentialGroup()
							.addComponent(admin_add)
							.addGap(169))))
		);
		gl_add_admin.setVerticalGroup(
			gl_add_admin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_add_admin.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_add_admin.createParallelGroup(Alignment.BASELINE)
						.addComponent(admin_first_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_add_admin.createParallelGroup(Alignment.BASELINE)
						.addComponent(admin_last_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_add_admin.createParallelGroup(Alignment.BASELINE)
						.addComponent(admin_timetable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addComponent(admin_add)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		add_admin.setLayout(gl_add_admin);
		
		JTabbedPane student = new JTabbedPane(JTabbedPane.TOP);
		student.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addTab("Students", null, student, null);
		stu_view = new JTable();
		JPanel view_students = new JPanel();
		view_students.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				/////////////////////////////////////////////////////////////////////////////
				DefaultTableModel dtm = new DefaultTableModel(0, 0);
				String header[] = {"First Name", "Last Name", "Timetable" };
				dtm.setColumnIdentifiers(header);
				stu_view.setModel(dtm);
				dtm.addRow(header);
				ArrayList<String[]> data = call.getStudentData();
				for(String[] d: data){ dtm.addRow(d); }
				////////////////////////////////////////////////////////////////////////////
			}
		});
		student.addTab("view", null, view_students, null);
		view_students.setLayout(new MigLayout("", "[384px]", "[193px]"));
		
		

		stu_view.setRowSelectionAllowed(false);
		view_students.add(stu_view, "cell 0 0,grow");
		
		JPanel add_students = new JPanel();
		student.addTab("add", null, add_students, null);
		
		JLabel lblTimetable = new JLabel("Timetable :");
		
		JLabel label_3 = new JLabel("Last Name:");
		
		final JFormattedTextField stu_timetable = new JFormattedTextField();
		final JFormattedTextField stu_last_name = new JFormattedTextField();
		final JFormattedTextField stu_first_name = new JFormattedTextField();
		
		JLabel label_4 = new JLabel("First Name:");
		
		JButton add_student = new JButton("Add");
		add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!stu_first_name.getText().isEmpty() && !stu_last_name.getText().isEmpty() && !stu_timetable.getText().isEmpty()  ){
					//Do DB stuff//////////////////////////////////////////////
					call.createStudent(stu_first_name.getText(), stu_last_name.getText(), stu_timetable.getText());
					stu_first_name.setText("");
					stu_last_name.setText("");
					stu_timetable.setText("");
				}
			}
		});
		frmEyeOfThe.getContentPane().setLayout(new MigLayout("", "[420px]", "[247px]"));
		GroupLayout gl_add_students = new GroupLayout(add_students);
		gl_add_students.setHorizontalGroup(
			gl_add_students.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_add_students.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_add_students.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_add_students.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(stu_first_name, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_add_students.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(stu_last_name, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_add_students.createSequentialGroup()
							.addComponent(lblTimetable, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(stu_timetable, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(108, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_add_students.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addComponent(add_student, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(158))
		);
		gl_add_students.setVerticalGroup(
			gl_add_students.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_add_students.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_add_students.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_add_students.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(stu_first_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_add_students.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_add_students.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(stu_last_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_add_students.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_add_students.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTimetable))
						.addComponent(stu_timetable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(add_student)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		add_students.setLayout(gl_add_students);
		

		//class_info.setLayout(gl_class_info);
		panel.setLayout(new MigLayout("", "[434px]", "[261px]"));
		panel.add(tabbedPane, "cell 0 0,alignx left,aligny top");
		
		JTabbedPane class_info = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Class Information", null, class_info, null);
		cl_view = new JTable();
		JPanel class_view = new JPanel();
		class_view.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				/////////////////////////////////////////////////////////////////////////////
				DefaultTableModel dtm = new DefaultTableModel(0, 0);
				String header[] = {"Class Name", "Class Start", "Class End", "Class Location"};
				dtm.setColumnIdentifiers(header);
				cl_view.setModel(dtm);
				dtm.addRow(header);
				ArrayList<String[]> data = call.getClassData();
				for(String[] d: data){ dtm.addRow(d); }
				////////////////////////////////////////////////////////////////////////////
			}
		});
		class_info.addTab("View", null, class_view, null);
		class_view.setLayout(new MigLayout("", "[384px]", "[193px]"));
		
		
		cl_view.setRowSelectionAllowed(false);
		class_view.add(cl_view, "cell 0 0,grow");
		
		JPanel class_add = new JPanel();
		class_info.addTab("Add", null, class_add, null);
		
		JPanel panel_3 = new JPanel();
		class_add.add(panel_3);
		
		
		final JFormattedTextField class_name_field = new JFormattedTextField();
		final JFormattedTextField class_start_field = new JFormattedTextField();
		final JFormattedTextField class_location_field = new JFormattedTextField();
		final JFormattedTextField class_end_field = new JFormattedTextField();
		
		JLabel classStartLabel = new JLabel("Start:");
		JLabel classLocationLabel = new JLabel("Location :");		
		JLabel classEndLabel = new JLabel("End:");
		JLabel classNamelabel = new JLabel("Class Name:");
		
		JButton classAdd = new JButton("Add");
		
		
		
		classAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( !class_name_field.getText().isEmpty() && !class_start_field.getText().isEmpty() && !class_end_field.getText().isEmpty() && !class_location_field.getText().isEmpty() ){
					call.createClass(class_name_field.getText(), class_start_field.getText(), class_end_field.getText(), class_location_field.getText());
				    /////////////////////////////////////////////////////////////////////
					class_name_field.setText("");
					class_start_field.setText("");
					class_end_field.setText("");
					class_location_field.setText("");
					////////////////////////////////////////////////////////////////////
				}
			}
		});
		

		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addGap(86)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(classLocationLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(class_location_field))
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
									.addComponent(classNamelabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addComponent(classStartLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_3.createSequentialGroup()
										.addComponent(class_start_field, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(classEndLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(class_end_field, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addComponent(class_name_field, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 125, GroupLayout.PREFERRED_SIZE)
							.addComponent(classAdd, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(70)))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(classNamelabel)
						.addComponent(class_name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(class_start_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(classStartLabel))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(classEndLabel)
								.addComponent(class_end_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(class_location_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(classLocationLabel))
					.addGap(13)
					.addComponent(classAdd)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		frmEyeOfThe.getContentPane().add(panel, "cell 0 0,grow");
	}
}
