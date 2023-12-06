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

public class Character {

    private JFrame frame;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Character window = new Character();
                    window.frame.setVisible(true);
                    window.loadData(); // Load character data when the window is shown
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Character() {
        initialize();
    }

    public static void showWindow() {
        Character window = new Character();
        window.frame.setVisible(true);
        window.loadData(); // Load character data when the window is shown
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Characters");
        frame.setBounds(100, 100, 1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Characters:");
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
        CharacterCommon characterCommon = new CharacterCommon();
        MongoCollection<Document> collection = characterCommon.getCollection();

        try {
            // Fetch all documents from the collection
            for (Document doc : collection.find()) {
                textArea.append("Character ID: " + doc.getInteger("cID") + "\n");
                textArea.append("Movie Title: " + doc.getString("MovieTitle") + "\n");
                textArea.append("Character Name: " + doc.getString("CharacterName") + "\n");
                textArea.append("Role: " + doc.getString("Role") + "\n");
                textArea.append("Description: " + doc.getString("Description") + "\n");
                textArea.append("\n---------------------------\n");
            }
        } finally {
            characterCommon.closeConnection();
            textArea.setCaretPosition(0);
        }
    }
}