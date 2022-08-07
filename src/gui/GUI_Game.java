package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_Game extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField direction_field;
	private JTextField strength_field;

	public String getDirection() {
		return direction_field.getText();
	}
	
	public String getStrength() {
		return strength_field.getText();
	}
	/**
	 * Create the dialog.
	 */
	public GUI_Game() {
		setTitle("GOAL!");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[436px]", "[232px][31px]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "cell 0 0,alignx left,growy");
		contentPanel.setLayout(new MigLayout("", "[300px,grow]", "[][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Choose direction: L/M/R");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel, "cell 0 0,grow");
		}
		{
			direction_field = new JTextField();
			contentPanel.add(direction_field, "cell 0 1,grow");
			direction_field.setColumns(1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Choose your strength: (1-8)");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 0 2,grow");
		}
		{
			strength_field = new JTextField();
			contentPanel.add(strength_field, "cell 0 3,growx");
			strength_field.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, "cell 0 1,growx,aligny top");
			{
				JButton okButton = new JButton("Confirm");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if((direction_field.getText().equals("L") || direction_field.getText().equals("M") || direction_field.getText().equals("R"))
								&& strength_field.getText().length()<2
								&& (strength_field.getText().matches("[1-8]+")))
							{
								setVisible(false);
							} else if(direction_field.getText().isBlank()|| strength_field.getText().isBlank()) {
								JOptionPane.showMessageDialog(null, "ERROR: Input is missing!");
							} else {
								JOptionPane.showMessageDialog(null, "ERROR: Wrong Input!");
							}
						}
				});
		
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				okButton.setVerticalAlignment(SwingConstants.BOTTOM);
				okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				okButton.setHorizontalAlignment(SwingConstants.RIGHT);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
