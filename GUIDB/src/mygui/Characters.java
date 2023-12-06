package mygui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Characters {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Characters characters = new Characters();
					characters.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Characters() {
		initialize();
	}
    public static void showWindow() {
		Characters characters = new Characters();
		characters.frame.setVisible(true);
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Characters:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 96));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnBack = new JButton("go back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Catagories.showWindow(); // Show the frame of Tab1
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 48));
		frame.getContentPane().add(btnBack, BorderLayout.SOUTH);
	}
}
