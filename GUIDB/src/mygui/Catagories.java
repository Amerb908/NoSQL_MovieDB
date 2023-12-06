package mygui;

//import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class Catagories {

    private static JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        showWindow();
    }

    /**
     * Initialize the contents of the frame.
     */
    public static void showWindow() { 
        frame = new JFrame("Catagories");
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
        frame.setBounds(100, 100, 1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("CATAGORIES");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 96));
        lblNewLabel.setBounds(10, 11, 1622, 136);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnBack = new JButton("Go Back to Main Page");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // Hide the current frame (Tab1)
                MainPageGUI.showWindow(); // Show the MainPageGUI frame
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 36));
        btnBack.setBounds(0, 979, 1906, 64);
        frame.getContentPane().add(btnBack);
        
        //Movie
        JButton btnMovie = new JButton("Movie");
        btnMovie.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // Hide the current frame (Tab1)
                Movie.showWindow(); // Show the MainPageGUI frame
        	}
        });
        btnMovie.setFont(new Font("Tahoma", Font.PLAIN, 36));
        btnMovie.setBounds(20, 158, 256, 96);
        frame.getContentPane().add(btnMovie);
        
        //Actors
        JButton btnActors = new JButton("Actors");
        btnActors.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // Hide the current frame (Tab1)
                Actors.showWindow(); // Show the MainPageGUI frame
        	}
        });
        btnActors.setFont(new Font("Tahoma", Font.PLAIN, 36));
        btnActors.setBounds(735, 158, 256, 96);
        frame.getContentPane().add(btnActors);
        
        //Book
        JButton btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		Book.showWindow();
        	}
        });
        btnBook.setFont(new Font("Tahoma", Font.PLAIN, 36));
        btnBook.setBounds(1481, 158, 256, 96);
        frame.getContentPane().add(btnBook);
        
        //Award
        JButton btnAward = new JButton("Award");
        btnAward.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		Award.showWindow();
        	}
        });
        btnAward.setFont(new Font("Tahoma", Font.PLAIN, 36));
        btnAward.setBounds(20, 410, 256, 96);
        frame.getContentPane().add(btnAward);
        
        //Characters
        JButton btnCharacters = new JButton("Characters");
        btnCharacters.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		Characters.showWindow();
        	}
        });
        btnCharacters.setFont(new Font("Tahoma", Font.PLAIN, 36));
        btnCharacters.setBounds(1481, 410, 256, 96);
        frame.getContentPane().add(btnCharacters);
        
        //Movie Theater
        JButton btnMovieTheatre = new JButton("Movie Theatre");
        btnMovieTheatre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		Movie_Theatre.showWindow();
        	}
        });
        btnMovieTheatre.setFont(new Font("Tahoma", Font.PLAIN, 36));
        btnMovieTheatre.setBounds(735, 410, 268, 96);
        frame.getContentPane().add(btnMovieTheatre);
        frame.setVisible(true);
    }
}
