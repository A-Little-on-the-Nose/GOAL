package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_LastWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDoYouWant;
	private boolean con=true;

	
	public boolean getContinue() {
		return con;
	}

	/**
	 * Create the dialog.
	 */
	public GUI_LastWindow() {
		setTitle("GOAL!");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		setModal(true);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new MigLayout("", "[436px]", "[232px][31px]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "flowx,cell 0 0,growx,aligny top");
		contentPanel.setLayout(new MigLayout("", "[400px]", "[][][][300px]"));
		{
			txtDoYouWant = new JTextField();
			txtDoYouWant.setEditable(false);
			txtDoYouWant.setFont(new Font("Tahoma", Font.PLAIN, 17));
			contentPanel.add(txtDoYouWant, "cell 0 3,grow");
			txtDoYouWant.setBackground(new Color(240, 240, 240));
			txtDoYouWant.setHorizontalAlignment(SwingConstants.CENTER);
			txtDoYouWant.setText("Do you want to try again?");
			txtDoYouWant.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 0 1,growx,aligny top");
			{
				JButton yesButton = new JButton("Yes");
				yesButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						con=true;
						setVisible(false);
					}
				});
				yesButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				yesButton.setActionCommand("OK");
				buttonPane.add(yesButton);
				getRootPane().setDefaultButton(yesButton);
			}
			{
				JButton cancelButton = new JButton("No");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						con=false;
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
