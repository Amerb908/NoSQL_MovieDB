package mygui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainPageGUI {

    private JFrame frame;
    private JButton btnCatagories;
    private JLabel lblNewLabel;
    private JButton btnSearch;
    private JButton btnAboutMe;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void showWindow() {
        MainPageGUI window = new MainPageGUI();
        window.frame.setVisible(true);
    }

    public MainPageGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Main Page");
        frame.setBounds(100, 100, 1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        lblNewLabel = new JLabel("Welcome to MovieDB");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Span 3 columns
        frame.getContentPane().add(lblNewLabel, gbc);

        btnCatagories = new JButton("Categories");
        btnCatagories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Categories.showWindow();
            }
        });
        btnCatagories.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        frame.getContentPane().add(btnCatagories, gbc);

        btnSearch = new JButton("Search Movies");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Search.showWindow();
            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.getContentPane().add(btnSearch, gbc);

        btnAboutMe = new JButton("About The App");
        btnAboutMe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AboutTheApp.showWindow();
            }
        });
        btnAboutMe.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.WEST;
        frame.getContentPane().add(btnAboutMe, gbc);
        
    }
}