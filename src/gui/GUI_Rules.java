package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_Rules extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean con=true;

	/**
	 * Create the dialog.
	 */
	public GUI_Rules() {
		setTitle("GOAL!");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JTextArea txtrWelcomeToGoal = new JTextArea();
			txtrWelcomeToGoal.setLineWrap(true);
			txtrWelcomeToGoal.setWrapStyleWord(true);
			txtrWelcomeToGoal.setEditable(false);
			txtrWelcomeToGoal.setText("Welcome to GOAL!\r\n\r\nThe game goes as follows:\r\n1) The Defender gets random stats assigend and is placed on the field\r\n2) The Player will put in his stats\r\n3) Beware: The strength influences the speed!\r\n\r\nHave fun!!");
			contentPanel.add(txtrWelcomeToGoal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
