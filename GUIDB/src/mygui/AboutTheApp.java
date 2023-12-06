package mygui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AboutTheApp {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AboutTheApp abouttheapp = new AboutTheApp();
                    abouttheapp.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AboutTheApp() {
        initialize();
    }

    public static void showWindow() {
        AboutTheApp abouttheapp = new AboutTheApp();
        abouttheapp.frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("About the App");
        frame.setBounds(100, 100, 1920, 1080); // Adjusted size for better visibility
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("About The App:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        JButton btnBack = new JButton("Go Back to Main Page");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainPageGUI.showWindow(); // Show the frame of Tab1
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        frame.getContentPane().add(btnBack, BorderLayout.SOUTH);

        String aboutApp = "Welcome to our app – your go-to hub for effortless entertainment discovery! "
        		+ "In a world flooded with content across platforms like Netflix, Amazon Prime, and Disney+, "
        		+ "we understand the need for simplicity. Our app caters to casual film watchers, providing a "
        		+ "user-friendly space that consolidates movie and TV show information from various sources. "
        		+ "No more navigating through multiple platforms – everything you need is here. Discovering new "
        		+ "media is a breeze. From the latest releases to timeless classics, our app offers synopses, "
        		+ "cast details, ratings, and more, all in one place. Say goodbye to the hassle and hello to "
        		+ "informed choices that match your preferences. Join us in simplifying your entertainment journey. "
        		+ "Your next favorite film or show is just a click away – let our app be your guide to seamless content discovery!";

        JTextArea textArea = new JTextArea(aboutApp);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));//Increase font size

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}