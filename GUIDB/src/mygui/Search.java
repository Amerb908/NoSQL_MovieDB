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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;

public class Search {

    private JFrame frame;
    private JTextField queryField;
    private JTextArea resultArea; // Declare resultArea here

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Search window = new Search();
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
    public Search() {
        initialize();
    }

    public static void showWindow() {
        Search search = new Search();
        search.frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	
        frame = new JFrame("Search");
        frame.setBounds(100, 100, 1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Search for Movies");
        lblNewLabel.setBounds(0, 0, 1906, 44);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);

        queryField = new JTextField();
        queryField.setFont(new Font("Tahoma", Font.PLAIN, 24));
        queryField.setBounds(455, 82, 974, 73); // Adjusted bounds
        queryField.setEditable(true); // Make the text field editable
        panel.add(queryField);
        queryField.setColumns(10);

        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 36));
        searchButton.setBounds(666, 207, 566, 145);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
        panel.add(searchButton);

        JButton btnBack = new JButton("Go Back to Main Page");
        btnBack.setBounds(0, 1014, 1906, 29);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainPageGUI.showWindow();
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
        panel.add(btnBack);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 26));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(10, 376, 1896, 637);
        panel.add(scrollPane);
        
        JLabel lblNewLabel_1 = new JLabel("Movie Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblNewLabel_1.setBounds(228, 86, 238, 65);
        panel.add(lblNewLabel_1);
        
        
    }

    private void performSearch() {
        resultArea.setText(""); // Clear previous results
        String query = queryField.getText();

        if (query.isEmpty()) {
            resultArea.append("Empty input, please add a movie.\n");
            return;
        }

        // Specify the collections the user can access
        String[] collections = {"Movie"};  // Include "Book" in the search

        // Perform search for each collection
        for (String collection : collections) {
            search(collection, query);
        }
    }

    private void search(String collectionName, String query) {
        resultArea.append("Search results for " + collectionName + ":\n");

        try {
            MongoCollection<Document> collection = getCollection(collectionName);

            // Special handling for the "Movie" collection
            if ("Movie".equals(collectionName)) {
                BasicDBObject regexQuery = new BasicDBObject();
                regexQuery.put("MovieTitle", new BasicDBObject("$regex", query).append("$options", "i"));

                FindIterable<Document> results = collection.find(regexQuery);

                // Display the results
                boolean movieFound = false;
                for (Document doc : results) {
                    displayMovie(doc);
                    movieFound = true;
                }

                if (!movieFound) {
                    resultArea.append("Movie not found, please try again.\n");
                }
            } else {
                // Generic handling for other collections
                FindIterable<Document> results = collection.find(Document.parse(query));

                // Display the results
                for (Document doc : results) {
                    resultArea.append(doc.toJson() + "\n");
                    resultArea.append("\n------------------------------\n");
                }

                if (!results.iterator().hasNext()) {
                    resultArea.append("No results found for the specified query in " + collectionName + "\n");
                }
            }
        } catch (Exception e) {
            resultArea.append("Error processing the query for " + collectionName + "\n");
            resultArea.append("\n---------------------------\n");
        }
    }
    // Helper method to display movie details
    private void displayMovie(Document doc) {
    	resultArea.setCaretPosition(0);
        resultArea.append("Movie ID: " + doc.getInteger("mID") + "\n");
        resultArea.append("Title: " + doc.getString("MovieTitle") + "\n");

        if (doc.containsKey("Rating")) {
            Object ratingObject = doc.get("Rating");
            if (ratingObject instanceof Integer) {
                resultArea.append("Rating: " + (Integer) ratingObject + "\n");
            } else if (ratingObject instanceof Double) {
                resultArea.append("Rating: " + (Double) ratingObject + "\n");
            }
        }

        resultArea.append("Language: " + doc.getString("Language") + "\n");
        resultArea.append("Genre: " + doc.getString("Genre") + "\n");
        resultArea.append("Length: " + doc.getString("Length") + "\n");
        resultArea.append("Release Year: " + doc.getInteger("ReleaseYear") + "\n");
        resultArea.append("\n---------------------------\n");
    }
    private MongoCollection<Document> getCollection(String collectionName) {
        // Assuming you have implementations for these classes
        MovieCommon movieCommon = new MovieCommon();
        ActorCommon actorCommon = new ActorCommon();
        AwardCommon awardCommon = new AwardCommon();
        BookCommon bookCommon = new BookCommon();
        CharacterCommon characterCommon = new CharacterCommon();
        ReviewCommon reviewCommon = new ReviewCommon();

        switch (collectionName) {
            case "Movie":
                return movieCommon.getCollection();
            case "Actor":
                return actorCommon.getCollection();
            case "Award":
                return awardCommon.getCollection();
            case "Book":
                return bookCommon.getCollection();
            case "Character":
                return characterCommon.getCollection();
            case "Review":
                return reviewCommon.getCollection();
            default:
                throw new IllegalArgumentException("Invalid collection name: " + collectionName);
        }
    }
}
