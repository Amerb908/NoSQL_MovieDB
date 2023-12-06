package mygui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class Movie {

    private JFrame frame;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Movie window = new Movie();
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
    public Movie() {
        initialize();
    }

    public static void showWindow() {
        Movie window = new Movie();
        window.frame.setVisible(true);
        window.loadData(); // Load movie data when the window is shown
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Movies:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set a larger font size
        scrollPane.setViewportView(textArea);

        JButton btnBack = new JButton("Go Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Categories.showWindow();
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(btnBack, BorderLayout.SOUTH);
    }

    private void loadData() {
        MovieCommon movieCommon = new MovieCommon();
        MongoCollection<Document> collection = movieCommon.getCollection();

        try {
            // Fetching all entries from the collection
            for (Document doc : collection.find()) {
                textArea.append("Movie ID: " + doc.getInteger("mID") + "\n");
                textArea.append("Title: " + doc.getString("MovieTitle") + "\n");
                // A fix to fetching "Rating" issue based on its type
                if (doc.containsKey("Rating")) {
                    Object ratingObject = doc.get("Rating");
                    if (ratingObject instanceof Integer) {
                        textArea.append("Rating: " + (Integer) ratingObject + "\n");
                    } else if (ratingObject instanceof Double) {
                        textArea.append("Rating: " + (Double) ratingObject + "\n");
                    }
                }
                textArea.append("Language: " + doc.getString("Language") + "\n");
                textArea.append("Genre: " + doc.getString("Genre") + "\n");
                textArea.append("Length: " + doc.getString("Length") + "\n");
                textArea.append("Release Year: " + doc.getInteger("ReleaseYear") + "\n");
                textArea.append("\n---------------------------\n");
            }
        } finally {
            movieCommon.closeConnection();
            textArea.setCaretPosition(0);
        }
    }
}