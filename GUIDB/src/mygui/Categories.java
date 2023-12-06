package mygui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class Categories {

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
        frame = new JFrame("Categories");
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
        frame.setBounds(100, 100, 1920, 1080); // Set a reasonable size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use a GridLayout with 2 rows and 3 columns for the buttons
        frame.getContentPane().setLayout(new GridLayout(2, 3, 10, 10));

        JLabel lblNewLabel = new JLabel("CATEGORIES");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        frame.getContentPane().add(lblNewLabel);

        // Movie
        JButton btnMovie = new JButton("Movie");
        btnMovie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Movie.showWindow();
            }
        });
        btnMovie.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnMovie);

        // Actors
        JButton btnActors = new JButton("Actors");
        btnActors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Actors.showWindow();
            }
        });
        btnActors.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnActors);

        // Book
        JButton btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Book.showWindow();
            }
        });
        btnBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnBook);

        // Award
        JButton btnAward = new JButton("Award");
        btnAward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Award.showWindow();
            }
        });
        btnAward.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnAward);

        // Characters
        JButton btnCharacters = new JButton("Characters");
        btnCharacters.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Character.showWindow();
            }
        });
        btnCharacters.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnCharacters);

        // Reviews
        JButton btnMovieTheatre = new JButton("Reviews");
        btnMovieTheatre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Review.showWindow();
            }
        });
        btnMovieTheatre.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnMovieTheatre);

        JButton btnBack = new JButton("Go Back to Main Page");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainPageGUI.showWindow();
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnBack);

        frame.setVisible(true);
    }
}