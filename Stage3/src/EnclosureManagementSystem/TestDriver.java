package EnclosureManagementSystem;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class TestDriver extends JFrame {
	
	private EnclosureDatabase database;
	private List<EnclosureFrame> enclosures = new ArrayList<>();

	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JLabel label_1;
	private JPanel mainPanel;
	private JButton openBtn;
	private JButton quit;
	
	public TestDriver() {
		database = new EnclosureDatabase();
		
		mainPanel = new JPanel();
		label_1 = new JLabel();
		checkBox_1 = new JCheckBox();
		checkBox_2 = new JCheckBox();
		checkBox_3 = new JCheckBox();
		openBtn = new JButton();
		quit = new JButton();
		
		database.loadEnclosureData();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(database.getZooName() + " Enclosure Management System");
		setMinimumSize(new Dimension(850, 150));
		setPreferredSize(new Dimension(850, 150));
		setResizable(false);
		getContentPane().setLayout(null);

		mainPanel.setPreferredSize(new Dimension(850, 150));
		mainPanel.setLayout(null);

		Font font = new Font("Arial", 1, 14);
		label_1.setFont(font);
		label_1.setText("Select enclosures: ");
		mainPanel.add(label_1);
		label_1.setBounds(12, 12, 150, 18);

		checkBox_1.setFont(font);
		checkBox_1.setText("African Safari Enclosure");
		mainPanel.add(checkBox_1);
		checkBox_1.setBounds(160, 12, 200, 50);

		checkBox_2.setFont(font);
		checkBox_2.setText("Standard Australian Enclosure");
		checkBox_2.setToolTipText("");
		mainPanel.add(checkBox_2);
		checkBox_2.setBounds(370, 12, 240, 50);

		checkBox_3.setFont(font);
		checkBox_3.setText("Nocturnal Enclosure");
		mainPanel.add(checkBox_3);
		checkBox_3.setBounds(621, 12, 236, 50);

		openBtn.setFont(font);
		openBtn.setText("Open Selected enclosures");
		mainPanel.add(openBtn);
		openBtn.setBounds(500, 70, 240, 30);
		openBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!checkBox_1.isSelected() && !checkBox_2.isSelected() && !checkBox_3.isSelected()) {
					String message = "Enclosure is not selected. \nPlease select and then try again.";
					JOptionPane.showMessageDialog(mainPanel, message, "Error", JOptionPane.ERROR_MESSAGE);
				} 
				else {
					if (checkBox_1.isSelected()) {
						EnclosureFrame dialog = new EnclosureFrame(checkBox_1.getText(), database);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
						enclosures.add(dialog);
					}
					if (checkBox_2.isSelected()) {
						EnclosureFrame dialog = new EnclosureFrame(checkBox_2.getText(), database);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
						enclosures.add(dialog);
					}
					if (checkBox_3.isSelected()) {
						EnclosureFrame dialog = new EnclosureFrame(checkBox_3.getText(), database);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
						enclosures.add(dialog);
					}
				}
			}
		});
		
		quit.setFont(font);
		quit.setText("Close");
		mainPanel.add(quit);
		quit.setBounds(750, 70, 74, 29);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for (EnclosureFrame enclosureFrame : enclosures) {
					enclosureFrame.dispose();
				}
				dispose();
			}
		});
		
		getContentPane().add(mainPanel);
		mainPanel.setBounds(0, 0, 850, 150);
		setLocationRelativeTo(null);
		pack();
	}
	
	public static void main(String[] args) {
		TestDriver td = new TestDriver();
		td.setVisible(true);
	}
}