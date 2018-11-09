package exp3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class inPut {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inPut window = new inPut();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inPut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 334, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(5, 3));
		
		JLabel label = new JLabel("");
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("                  \u8BF7\u8F93\u5165\u5C45\u6C11\u70B9\u4E2A\u6570");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 17));
		panel.add(label_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("           ");
		panel_1.add(label_2, BorderLayout.WEST);
		
		JLabel label_3 = new JLabel("         ");
		panel_1.add(label_3, BorderLayout.EAST);
		
		textField = new JTextField();
		panel_1.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("                    ");
		panel_2.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel label_4 = new JLabel("                 ");
		panel_2.add(label_4, BorderLayout.EAST);
		
		JButton button = new JButton("\u786E\u5B9A");
		panel_2.add(button, BorderLayout.CENTER);
	}

}
