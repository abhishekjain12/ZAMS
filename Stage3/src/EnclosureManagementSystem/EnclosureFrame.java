package EnclosureManagementSystem;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

//Enclosure detailed frame
public class EnclosureFrame extends JFrame {

	private String selectedEnclosure;
	private EnclosureDatabase database;
	private Map<String, Animal> selectedAnimals = new HashMap<String, Animal>();

	private JTextArea animalData;
	private JPanel animalPanel;
	private ButtonGroup btngrp;
	private JButton clearBtn;
	private JButton dispInfBtn;
	private JLabel infoLabel;
	private JPanel animalDataPanel;
	private JScrollPane animalsDataScrollPanel;
	private JPanel mainPanel;
	private JButton quitBtn;
	private JScrollPane animalScrollPanel;
	
	public EnclosureFrame(String selectedEnclosure, EnclosureDatabase database) {
		this.selectedEnclosure = selectedEnclosure;
		this.database = database;
		
		Enclosure enclosure = database.getEnclosure(selectedEnclosure);
		
		btngrp = new ButtonGroup();
		mainPanel = new JPanel();
		dispInfBtn = new JButton();
		clearBtn = new JButton();
		quitBtn = new JButton();
		animalPanel = new JPanel();
		animalDataPanel = new JPanel();
		infoLabel = new JLabel();
		animalsDataScrollPanel = new JScrollPane();
		animalScrollPanel = new JScrollPane();
		animalData = new JTextArea();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Details of " + selectedEnclosure + " | " + database.getZooName());
		setMinimumSize(new Dimension(800, 520));
		setPreferredSize(new Dimension(800, 520));
		setResizable(false);
		getContentPane().setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				dispose();
			}
		});
		
		mainPanel.setMinimumSize(new Dimension(800, 520));
		mainPanel.setPreferredSize(new Dimension(800, 520));
		mainPanel.setLayout(null);

		Font font = new Font("Arial", 1, 12);
		String msg = "";

		infoLabel.setFont(new Font("Arial", 1, 14));
		infoLabel.setText("Entry Price is $" + enclosure.getPrice() + " and Opening Hours is " + enclosure.getOpeningHours() + ".");
		mainPanel.add(infoLabel);
		infoLabel.setBounds(150, 10, 500, 18);
		
		msg = "Animals in " + selectedEnclosure;
		animalPanel.setBorder(BorderFactory.createTitledBorder(null, msg, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, font));
		animalPanel.setLayout(null);

		animalDataPanel.setLayout(null);
		animalScrollPanel.setViewportView(animalDataPanel);

		animalPanel.add(animalScrollPanel);
		animalScrollPanel.setBounds(20, 20, 410, 200);
		
		mainPanel.add(animalPanel);
		animalPanel.setBounds(10, 40, 450, 230);

		dispInfBtn.setFont(font);
		dispInfBtn.setText("Display Information");
		dispInfBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (selectedAnimals.isEmpty()) {
					String message = "No anmial is selected. \nPlease select and then try again.";
					JOptionPane.showMessageDialog(mainPanel, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					StringBuilder sb = new StringBuilder();
					for (Entry<String, Animal> entry : selectedAnimals.entrySet()) {
						Animal animal = entry.getValue();
						sb.append("\t" + animal + "\n\n");
					}
					animalData.setText(sb.toString());
				}
			}
		});
		mainPanel.add(dispInfBtn);
		dispInfBtn.setBounds(550, 50, 200, 50);

		clearBtn.setFont(font);
		clearBtn.setText("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				animalData.setText("");
				btngrp.clearSelection();
			}
		});
		mainPanel.add(clearBtn);
		clearBtn.setBounds(550, 120, 200, 50);

		quitBtn.setFont(font);
		quitBtn.setText("Quit");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		mainPanel.add(quitBtn);
		quitBtn.setBounds(550, 190, 200, 50);

		animalData.setColumns(20);
		animalData.setRows(5);
		animalsDataScrollPanel.setBorder(BorderFactory.createTitledBorder("Animal Information from " + selectedEnclosure));
		animalsDataScrollPanel.setViewportView(animalData);

		mainPanel.add(animalsDataScrollPanel);
		animalsDataScrollPanel.setBounds(10, 290, 770, 180);
		
		getContentPane().add(mainPanel);
		mainPanel.setBounds(0, 0, 800, 520);
		pack();		
		
		addAnimal();
	}

	private void addAnimal() {
		Enclosure enclosure = database.getEnclosure(selectedEnclosure);
		Map<String, Animal> animals = enclosure.getAnimals();
		System.out.println(animals.size());
		
		if (null != animals && !animals.isEmpty()) {
			animalDataPanel.setLayout(new GridLayout(animals.size(), 1));
			for (Map.Entry<String, Animal> entry : animals.entrySet()) {
				if (null != entry) {

					JCheckBox checkBox = new JCheckBox();
					checkBox.setPreferredSize(new Dimension(250, 30));
					checkBox.addItemListener(new ItemListener() {
						@Override
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								selectedAnimals.put(entry.getKey(), entry.getValue());
							} else {
								selectedAnimals.remove(checkBox.getName());
							}
						}
					});
					final Animal value = entry.getValue();

					String label = value.type + " " + value.name;
					checkBox.setText(label);
					checkBox.setName(value.id);
					checkBox.setFont(new java.awt.Font("Tahoma", 1, 12));
					animalDataPanel.add(checkBox);
				}
			}
		}
	}
}