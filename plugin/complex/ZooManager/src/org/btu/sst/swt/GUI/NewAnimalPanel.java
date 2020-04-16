package org.btu.sst.swt.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.btu.sst.swt.Managing.Animal;
import org.btu.sst.swt.Managing.Spec;

public class NewAnimalPanel extends JDialog implements ActionListener {

	private static final long serialVersionUID = -5006971030527821505L;
	private static final String CMD_OK = "Ok";
	private static final String CMD_CANCEL = "Cancel";

	private JComboBox<Spec> cbSpecies;
	private JTextField tfName;

	private boolean accepted = false;

	public NewAnimalPanel(final JFrame owner) {
		super(owner, true);
		buildComponents();
	}

	private void buildComponents() {
		setLayout(new BorderLayout(5, 2));

		final JPanel labelPanel = new JPanel(new GridLayout(2, 1));
		labelPanel.add(new JLabel("Name"));
		labelPanel.add(new JLabel("Species"));
		add(labelPanel, BorderLayout.WEST);

		final JPanel entryPanel = new JPanel(new GridLayout(2, 1));
		entryPanel.add(tfName = new JTextField(20));
		entryPanel.add(cbSpecies = new JComboBox<>(Spec.values()));
		add(entryPanel, BorderLayout.CENTER);

		add(buildButtonPanel(), BorderLayout.SOUTH);
	}

	private Component buildButtonPanel() {

		final JButton btnOk = new JButton(CMD_OK);
		btnOk.addActionListener(this);
		final JButton btnCancel = new JButton(CMD_CANCEL);
		btnCancel.addActionListener(this);

		final JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(btnOk);
		buttonPanel.add(btnCancel);
		getRootPane().setDefaultButton(btnOk);
		return buttonPanel;
	}

	private Animal readAnimal() {
		return accepted ? new Animal(tfName.getText(), (Spec) cbSpecies.getSelectedItem()) : null;
	}

	public static Animal requestNewAnimal(final JFrame owner) {
		final NewAnimalPanel chooser = new NewAnimalPanel(owner);
		chooser.pack();
		chooser.setVisible(true);
		return chooser.readAnimal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		accepted = e.getActionCommand().equals(CMD_OK);
		dispose();
	}

}
