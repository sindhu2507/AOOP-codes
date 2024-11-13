package hackathon;

import javax.swing.*;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.net.URI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class Program {
	static String username;
	static String password;
	private static User loggedInUser;
	
    private static Connection connect() {
        // Replace with your actual database connection logic
        return DatabaseConnector.connect(); // Ensure this method connects to your database
    }
    
 // Method to show the welcome slide
    private static void showWelcomeSlide(JFrame frame) {
    	
        // Background panel for the welcome slide
        JPanel welcomePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the background color to light olive green
                g.setColor(new Color(179, 195, 150));
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0, 0, 800, 600);
        frame.add(welcomePanel);

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome to SupportNet!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setBounds(200, 200, 400, 50);
        welcomePanel.add(welcomeLabel);

        // Thank you message
        JLabel thankYouLabel = new JLabel("Thank you for joining us!");
        thankYouLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        thankYouLabel.setForeground(Color.BLACK);
        thankYouLabel.setBounds(250, 300, 300, 30);
        welcomePanel.add(thankYouLabel);
    }
    
    private static void showNextSlide(JFrame frame) {
        // Background panel for the next slide
        JPanel nextSlidePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26, 141, 142)); // Teal Blue color (#1A8D8E)
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        nextSlidePanel.setLayout(null);
        nextSlidePanel.setBounds(0, 0, 1400, 800); // Changed dimensions to match the second method
        frame.add(nextSlidePanel);

        // Second slide logo
        JLabel secondLogoLabel = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\2.jpg")
                .getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH)));
        secondLogoLabel.setBounds(520, 50, 250, 200);
        nextSlidePanel.add(secondLogoLabel);

        // Website title: "SupportNet"
        JLabel titleLabel = new JLabel("SupportNet");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(550, 270, 400, 50);
        nextSlidePanel.add(titleLabel);

        // Tagline: "Connecting Donors with Those in Need"
        JLabel taglineLabel = new JLabel("Connecting Donors with Those in Need");
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        taglineLabel.setForeground(Color.BLACK);
        taglineLabel.setBounds(490, 320, 400, 30);
        nextSlidePanel.add(taglineLabel);
        
      //start of the block
        JPanel middleBlockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200)); // Cream color
                
                int marginX = 40; // Horizontal margin to reduce width
                int marginY = 30; // Vertical margin for alignment
                
                g2.fillRoundRect(marginX, marginY, getWidth() - 2 * marginX, getHeight() - 2 * marginY, 30, 30);
            }
        };
        middleBlockPanel.setOpaque(false);
        middleBlockPanel.setBounds(270, 350, 800, 350);
        middleBlockPanel.setLayout(null);
        nextSlidePanel.add(middleBlockPanel);
        //end of the block
        
        JLabel donorMessageLabel = new JLabel("<html><div style='text-align: center;'>"
                + "Be the change you wish to see in the world.<br>"
                + "Together, through your generous donations, we can make a lasting impact.<br>"
                + "<br>If you haven't signed in yet, join us now to become part of SupportNet and strengthen our community!"
                + "</div></html>");
        donorMessageLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set the font to normal style
        donorMessageLabel.setForeground(Color.BLACK);
        donorMessageLabel.setBounds(105, 50, 600, 200);  // Adjust the width and height as needed
        middleBlockPanel.add(donorMessageLabel);
        
        //Login button - Adding to middleBlockPanel instead
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(190, 250, 150, 50);  // Adjusted coordinates relative to middleBlockPanel
        middleBlockPanel.add(loginButton);
        
        loginButton.setBorderPainted(false); // Remove default border
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);

        loginButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142)); // Same color as signUpButton
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 30, 30); // Rounded corners with 30 radius

                // Draw text in the center
                g2.setColor(Color.WHITE);
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(loginButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(loginButton.getText(), textX, textY);

                g2.dispose();
            }
        });
        
        
        // Sign Up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(455, 250, 150, 50);  // Adjusted coordinates relative to middleBlockPanel
        middleBlockPanel.add(signUpButton);

        signUpButton.setBorderPainted(false); // Remove default border
        signUpButton.setFocusPainted(false);
        signUpButton.setContentAreaFilled(false);

        signUpButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142));
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 30, 30); // 30 for rounded corners

                // Draw text in the center
                g2.setColor(Color.WHITE);
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(signUpButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(signUpButton.getText(), textX, textY);

                g2.dispose();
            }
        });

        // Action listener for the sign-up button
        signUpButton.addActionListener(e -> {
            frame.remove(nextSlidePanel);
            showSignUpForm(frame);
            frame.revalidate();
            frame.repaint();
        });

        // Action listener for the login button
        loginButton.addActionListener(e -> {
            frame.remove(nextSlidePanel);
            showLoginForm(frame);
            frame.revalidate();
            frame.repaint();
        });
    }

    //SignUp Form - Done
    private static void showSignUpForm(JFrame frame) {
        JPanel signUpPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26,141,142));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        signUpPanel.setLayout(null);
        signUpPanel.setBounds(0, 0, 1400, 800);
        frame.add(signUpPanel);
        
      //middle block starts
        JPanel middleBlockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200)); // Cream color
                
                int marginX = 40; // Horizontal margin to reduce width
                int marginY = 30; // Vertical margin for alignment
                
                g2.fillRoundRect(marginX, marginY, getWidth() - 2 * marginX, getHeight() - 2 * marginY, 30, 30);
            }
        };
        middleBlockPanel.setOpaque(false);
        middleBlockPanel.setBounds(380, 100, 600, 600);
        middleBlockPanel.setLayout(null);
        signUpPanel.add(middleBlockPanel);
        
        JLabel signUpTitleLabel = new JLabel("Enter Your Details");
        signUpTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        signUpTitleLabel.setForeground(Color.BLACK);
        signUpTitleLabel.setBounds(180, 50, 300, 30);
        middleBlockPanel.add(signUpTitleLabel);
      //middle block ends
        
      //Back Button
      //Back Button starts
        JButton backButton = new JButton(); // No text needed; we will draw the arrow manually
        backButton.setBounds(10, 10, 50, 30); // Position of the button
        backButton.setFocusPainted(false); // Remove focus paint
        backButton.setContentAreaFilled(false); // Make the content area transparent
        backButton.setBorderPainted(false); // Remove default border painting

        backButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142)); // Same color as before
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                // Draw a thicker arrow
                g2.setColor(Color.WHITE); // Arrow color
                int arrowWidth = 8; // Width of the arrow
                int arrowHeight = 16; // Height of the arrow
                int x = 30; // X position of the arrow
                int y = c.getHeight() / 2; // Y position to center the arrow vertically
                
                // Draw the arrow using a polygon
                g2.fillPolygon(new int[]{x, x, x - arrowWidth}, new int[]{y - arrowHeight / 2, y + arrowHeight / 2, y}, 3);

                // Draw the border
                g2.setColor(new Color(255, 230, 200)); // Border color
                g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 15, 15); // Rounded border

                g2.dispose();
            }
        });
        

        // Add the back button to the signUpPanel
        signUpPanel.add(backButton);
      //Back button ends

        // Username field
        JLabel userNameLabel = new JLabel("Username:");
        userNameLabel.setBounds(150, 100, 100, 30);
        middleBlockPanel.add(userNameLabel);

        JTextField userNameField = new JTextField();
        userNameField.setBounds(250, 100, 200, 30);
        userNameField.setBorder(new LineBorder(new Color(26, 141, 142), 2)); // Adjust thickness as needed
        middleBlockPanel.add(userNameField);

     // Name field
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(150, 150, 100, 30);
        middleBlockPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(250, 150, 200, 30);
        nameField.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(nameField);
        
        // Phone number field
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(150, 200, 100, 30);
        middleBlockPanel.add(phoneLabel);

        final JTextField phoneField = new JTextField();
        phoneField.setBounds(250, 200, 200, 30);
        phoneField.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(phoneField);

        // Date of Birth field using JDatePicker
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(150, 250, 100, 30);
        middleBlockPanel.add(dobLabel);

        UtilDateModel dateModel = new UtilDateModel();
        Properties dateProperties = new Properties();
        dateProperties.put("text.today", "Today");
        dateProperties.put("text.month", "Month");
        dateProperties.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, dateProperties);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(250, 250, 200, 30);
        datePanel.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(datePicker);

     // Gender field
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(150, 300, 100, 30);
        middleBlockPanel.add(genderLabel);

        String[] genders = {"Select", "Male", "Female", "Other"};
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(250, 300, 200, 30);
        genderComboBox.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(genderComboBox);

     // Email field
        JLabel gmailLabel = new JLabel("Email:");
        gmailLabel.setBounds(150, 350, 100, 30);
        middleBlockPanel.add(gmailLabel);

        JTextField gmailField = new JTextField();
        gmailField.setBounds(250, 350, 200, 30);
        gmailField.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(gmailField);

     // Address field
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(150, 400, 100, 30);
        middleBlockPanel.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(250, 400, 200, 30);
        addressField.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(addressField);

     // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 450, 100, 30);
        middleBlockPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 450, 200, 30);
        passwordField.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(passwordField);

     // Sign Up button starts
        JButton signUpSubmitButton = new JButton("Sign Up");
        signUpSubmitButton.setBounds(250, 500, 120, 40);  // Set position and size
        signUpSubmitButton.setBorderPainted(false); // Remove default border
        signUpSubmitButton.setFocusPainted(false); // Remove focus paint
        signUpSubmitButton.setContentAreaFilled(false); // Make the content area transparent

        signUpSubmitButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142)); // Same color as before
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                // Draw text in the center
                g2.setColor(Color.WHITE); // Text color
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(signUpSubmitButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(signUpSubmitButton.getText(), textX, textY);

                g2.dispose();
            }
        });
        
        // Add the button to the middleBlockPanel
        middleBlockPanel.add(signUpSubmitButton);
        //sign up button ends

        // Action listener for sign-up button
        signUpSubmitButton.addActionListener(e -> {
            String username = userNameField.getText();
            String fullName = nameField.getText();
            String phone_number = phoneField.getText();

            java.util.Date dob = (java.util.Date) datePicker.getModel().getValue();
            java.sql.Date sqlDob = dob != null ? new java.sql.Date(dob.getTime()) : null;

            String gender = (String) genderComboBox.getSelectedItem();
            String gmail = gmailField.getText();
            String address = addressField.getText();
            String password = new String(passwordField.getPassword());

            // Validation
            if (username.isEmpty() || fullName.isEmpty() || phone_number.isEmpty() || dob == null ||
                gender.equals("Select") || gmail.isEmpty() || address.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save details to PostgreSQL database
            try (Connection connection = DatabaseConnector.connect()) {
                String insertQuery = "INSERT INTO signin (username, name, phone_number, dob, gender, gmail, address, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(insertQuery);
                stmt.setString(1, username);
                stmt.setString(2, fullName);
                stmt.setString(3, phone_number);
                stmt.setDate(4, sqlDob);
                stmt.setString(5, gender);
                stmt.setString(6, gmail);
                stmt.setString(7, address);
                stmt.setString(8, password);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.remove(signUpPanel);
                Home(frame, loggedInUser);
                frame.revalidate();
                frame.repaint();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving user details: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll(); // Clear current content
            showNextSlide(frame); // Show the welcome slide
            frame.revalidate();
            frame.repaint();
        });
    }

    private static void showLoginForm(JFrame frame) {
        // Background panel for the login form
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26, 141, 142)); 
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, 1400, 800);
        frame.add(loginPanel);
        
      //middle block starts
        JPanel middleBlockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200)); // Cream color
                
                int marginX = 40; // Horizontal margin to reduce width
                int marginY = 30; // Vertical margin for alignment
                
                g2.fillRoundRect(marginX, marginY, getWidth() - 2 * marginX, getHeight() - 2 * marginY, 30, 30);
            }
        };
        middleBlockPanel.setOpaque(false);
        middleBlockPanel.setBounds(380, 130, 600, 400);
        middleBlockPanel.setLayout(null);
        loginPanel.add(middleBlockPanel);
        //middle block ends
        
        JButton backButton = new JButton(); // No text needed; we will draw the arrow manually
        backButton.setBounds(10, 10, 50, 30); // Position of the button
        backButton.setFocusPainted(false); // Remove focus paint
        backButton.setContentAreaFilled(false); // Make the content area transparent
        backButton.setBorderPainted(false); // Remove default border painting

        backButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142)); // Same color as before
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                // Draw a thicker arrow
                g2.setColor(Color.WHITE); // Arrow color
                int arrowWidth = 8; // Width of the arrow
                int arrowHeight = 16; // Height of the arrow
                int x = 30; // X position of the arrow
                int y = c.getHeight() / 2; // Y position to center the arrow vertically
                
                // Draw the arrow using a polygon
                g2.fillPolygon(new int[]{x, x, x - arrowWidth}, new int[]{y - arrowHeight / 2, y + arrowHeight / 2, y}, 3);

                // Draw the border
                g2.setColor(new Color(255, 230, 200)); // Border color
                g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 15, 15); // Rounded border

                g2.dispose();
            }
        });
        

        // Add the back button to the signUpPanel
        loginPanel.add(backButton);
      //Back button ends

        JLabel loginTitleLabel = new JLabel("Login");
        loginTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginTitleLabel.setForeground(Color.BLACK);
        loginTitleLabel.setBounds(250, 70, 300, 30);
        middleBlockPanel.add(loginTitleLabel);

        // Username field
        JLabel userNameLabel = new JLabel("Username:");
        userNameLabel.setBounds(150, 140, 100, 30);
        middleBlockPanel.add(userNameLabel);

        JTextField userNameField = new JTextField();
        userNameField.setBounds(250, 140, 200, 30);
        userNameField.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(userNameField);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 190, 100, 30);
        middleBlockPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 190, 200, 30);
        passwordField.setBorder(new LineBorder(new Color(26, 141, 142), 2));
        middleBlockPanel.add(passwordField);

        // Login button starts
        JButton loginSubmitButton = new JButton("Login");
        loginSubmitButton.setBounds(245, 270, 100, 30); // Position of the button
        loginSubmitButton.setFocusPainted(false); // Remove focus paint
        loginSubmitButton.setContentAreaFilled(false); // Make the content area transparent
        loginSubmitButton.setBorderPainted(false); // Remove default border painting

        loginSubmitButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142)); // Custom background color
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                // Draw text in the center
                g2.setColor(Color.WHITE); // Text color
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(loginSubmitButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(loginSubmitButton.getText(), textX, textY);

                // Draw the border
               

                g2.dispose();
            }
        });

        // Add the loginSubmitButton to the middleBlockPanel
        middleBlockPanel.add(loginSubmitButton);
        //login button ends

        // Action listener for the login submit button
        loginSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userNameField.getText();
                String password = new String(passwordField.getPassword());

                // Validate the user's credentials
                User loggedInUser = authenticateUser(username, password);

                if (loggedInUser != null) {
                    // If valid, proceed to the Home screen
                    frame.remove(loginPanel);
                    Home(frame, loggedInUser); // Pass the logged-in user to the Home method
                    frame.revalidate();
                    frame.repaint();
                } else {
                    // Show an error message if credentials are invalid
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll(); // Clear current content
            showNextSlide(frame); // Show the welcome slide
            frame.revalidate();
            frame.repaint();
        });
    }

    // Method to authenticate user credentials
    private static User authenticateUser(String username, String password) {
        User user = null;
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "SELECT * FROM signin WHERE username = ? AND password = ?"; // Adjust query to match your table
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password); // Ensure this matches your actual database column
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Create a User object if authentication is successful
                user = new User();
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setDob(rs.getDate("dob"));
                user.setGender(rs.getString("gender"));
                user.setGmail(rs.getString("gmail"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user; // Return null if authentication fails
    }

    private static void addUserToDatabase(String userName, String name, String phone_number, String dob, String gender, String gmail, String address, String password) {
        Connection connection = connect();
        String query = "INSERT INTO signin(username, name, phone_number, dob, gender, gmail, address, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userName);
            stmt.setString(2, name);
            stmt.setString(3, phone_number);
            
            // Parse the date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Input format
            java.util.Date parsedDate = dateFormat.parse(dob);
            stmt.setDate(4, new Date(parsedDate.getTime())); // Convert to java.sql.Date

            stmt.setString(5, gender);
            stmt.setString(6, gmail);
            stmt.setString(7, address);
            stmt.setString(8, password);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User added successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding user: " + e.getMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error parsing date: " + e.getMessage());
        }
    }
    
    private static void Home(JFrame frame, User loggedInUser) {
        // Clear existing content in the frame
        frame.getContentPane().removeAll();

        // Create a welcome panel
        JPanel welcomePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26,141,142));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0, 0, 1400, 800);
        frame.add(welcomePanel);
        
     // Start of the block
        JPanel middleBlockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200)); // Cream color
                
                int marginX = 0; // Horizontal margin
                int marginY = 20; // Vertical margin
                
                // Calculate width and height dynamically
                int width = getWidth() - 2 * marginX;
                int height = getHeight() - 2 * marginY;

                // Draw rectangle with sharp corners
                g2.fillRect(marginX, marginY, width, height);
                
            }
        };

        middleBlockPanel.setOpaque(false);
        middleBlockPanel.setBounds(0, 150, 1700, 700);
        middleBlockPanel.setLayout(null);
        welcomePanel.add(middleBlockPanel);
        // End of the block
        
        JLabel donation1Label = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\D1.jpg")
                .getImage().getScaledInstance(350, 150, Image.SCALE_SMOOTH))); // Reduced size
        donation1Label.setBounds(720, 290, 375, 230); // Positioned at the top-left corner
        middleBlockPanel.add(donation1Label);
        
        JLabel donation2Label = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\D2.jpg")
                .getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH))); // Reduced size
        donation2Label.setBounds(690, 125, 200, 150); // Positioned at the top-left corner
        middleBlockPanel.add(donation2Label);
        
        JLabel donation3Label = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\D3.jpg")
                .getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH))); // Reduced size
        donation3Label.setBounds(800, 80, 500, 200); // Positioned at the top-left corner
        middleBlockPanel.add(donation3Label);

        JLabel logonameLabel = new JLabel("SupportNet");
        logonameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        logonameLabel.setForeground(Color.BLACK);
        logonameLabel.setBounds(550, 35, 300, 80); // Adjust position to be beside the logo
        welcomePanel.add(logonameLabel);
        
        JLabel taglineLabel = new JLabel("Connecting Donors with Those in Need");
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Normal font size
        taglineLabel.setForeground(Color.BLACK);
        taglineLabel.setBounds(550, 100, 400, 30); // Positioned below "SupportNet"
        welcomePanel.add(taglineLabel);

        JLabel welcomeLabel = new JLabel("Welcome to SupportNet!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setBounds(80, 80, 300, 30);
        middleBlockPanel.add(welcomeLabel);
        
        JLabel descriptionLabel = new JLabel("<html><div style='line-height: 2.5;'>"
                + "SupportNet is dedicated to building a caring community where your contributions truly matter. Many individuals and families are suffering and lack access to basic needs. By donating items such as clothes, books, furniture, and electrical gadgets, you can make a significant difference in their lives. The materials that you may no longer use can be a lifeline for someone else.<br><br>"
                + "Our app makes it easy to specify what you're donating, ensuring that your kindness reaches the right people. What may seem like a normal item to you could be invaluable to someone who is struggling to meet their everyday needs. You'll receive updates once your donations reach those in need, allowing you to see the positive impact of your support firsthand.<br><br>"
                + "Together, we can bring comfort and care to those who need it most, one donation at a time. Join us in making a meaningful change in our community! Your generosity can help bridge the gap for those who are less fortunate, turning unused items into hope and opportunity for others. Donate today, and be a part of something bigger—because every small act of kindness can lead to significant change in someone’s life.</div></html>");

        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 15)); // Set the font size to match donorMessageLabel
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setBounds(80, 20, 600, 550); // Adjust the bounds as needed
        middleBlockPanel.add(descriptionLabel);

        //start of donate button
        JButton donateButton = new JButton("Donate");
        donateButton.setBounds(320, 480, 120, 40);  // Set position and size
        donateButton.setBorderPainted(false); // Remove default border
        donateButton.setFocusPainted(false); // Remove focus paint
        donateButton.setContentAreaFilled(false); // Make the content area transparent

        donateButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142)); // Background color (customize as needed)
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                // Draw text in the center
                g2.setColor(Color.WHITE); // Text color
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(donateButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(donateButton.getText(), textX, textY);

                g2.dispose();
            }
        });

        middleBlockPanel.add(donateButton);
        //end of donate button

        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(1100, 20, 100, 50);  // Set position and size
        profileButton.setBorderPainted(false); // Remove default border
        profileButton.setFocusPainted(false); // Remove focus paint
        profileButton.setContentAreaFilled(false); // Make the content area transparent

        profileButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(255, 230, 200)); // Same color as before
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                // Draw text in the center
                g2.setColor(Color.BLACK); // Text color
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(profileButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(profileButton.getText(), textX, textY);

                g2.dispose();
            }
        });
        
        welcomePanel.add(profileButton);
        //profile button ends
        // Logo label
        JLabel thirdLogoLabel = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\2.jpg")
                .getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
        thirdLogoLabel.setBounds(350, 30, 150, 100);
        welcomePanel.add(thirdLogoLabel);

        // Action listener for the donate button to show the donation form
        donateButton.addActionListener(e -> {
            // Remove the welcome panel and show the donation slide
            frame.remove(welcomePanel);
            showDonateSlide(frame); // Method to show the donation slide
            frame.revalidate();
            frame.repaint();
        });

        // Action listener for profile button
        profileButton.addActionListener(e -> {
            // Remove the welcome panel and show the user's profile
            frame.remove(welcomePanel);
            showUserProfile(frame, loggedInUser); // Pass the logged-in user to the profile method
            frame.revalidate();
            frame.repaint();
        });

        // Refresh the frame to show the welcome panel
        frame.revalidate();
        frame.repaint();
    }
     
    private static void showUserProfile(JFrame frame, User user) {

        JPanel profilePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26, 141, 142)); // Teal Blue color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        profilePanel.setLayout(null);
        profilePanel.setBounds(0, 0, 1400, 800);
        frame.add(profilePanel);

        JButton backButton = new JButton();
        backButton.setBounds(10, 10, 50, 30);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(26, 141, 142));
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15);
                g2.setColor(Color.WHITE);
                int arrowWidth = 8;
                int arrowHeight = 16;
                int x = 30;
                int y = c.getHeight() / 2;
                g2.fillPolygon(new int[]{x, x, x - arrowWidth}, new int[]{y - arrowHeight / 2, y + arrowHeight / 2, y}, 3);
                g2.setColor(new Color(255, 230, 200));
                g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 15, 15);
                g2.dispose();
            }
        });
        profilePanel.add(backButton);

        backButton.addActionListener(e -> {
            frame.remove(profilePanel);
            Home(frame, user);
            frame.revalidate();
            frame.repaint();
        });

        JLabel logonameLabel = new JLabel("PROFILE");
        logonameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        logonameLabel.setForeground(Color.BLACK);
        logonameLabel.setBounds(550, 35, 300, 80);
        profilePanel.add(logonameLabel);

        JPanel middleBlockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200));
                int marginX = 40;
                int marginY = 30;
                g2.fillRoundRect(marginX, marginY, getWidth() - 2 * marginX, getHeight() - 2 * marginY, 30, 30);
            }
        };
        middleBlockPanel.setOpaque(false);
        middleBlockPanel.setBounds(70, 130, 550, 550);
        middleBlockPanel.setLayout(null);
        profilePanel.add(middleBlockPanel);

        JPanel picPanel = new JPanel();
        picPanel.setLayout(new BoxLayout(picPanel, BoxLayout.Y_AXIS));
        picPanel.setBounds(200, 50, 150, 150);
        picPanel.setOpaque(false);
        middleBlockPanel.add(picPanel);

        JLabel profilePic = new JLabel();
        profilePic.setPreferredSize(new Dimension(200, 200));
        profilePic.setOpaque(false);
        profilePic.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        profilePic.setHorizontalAlignment(SwingConstants.CENTER);

        String savedPath = loadProfilePicPathFromDB(user.getUsername());
        if (savedPath != null && !savedPath.isEmpty()) {
            user.setProfilePicPath(savedPath);
            profilePic.setIcon(new ImageIcon(savedPath));
        } else {
            profilePic.setText("Profile Pic");
        }
        picPanel.add(profilePic);

     // Label to select a picture
        JLabel selectPictureLabel = new JLabel("<html><u>Select Picture</u></html>");
        selectPictureLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        selectPictureLabel.setForeground(Color.BLUE);
        selectPictureLabel.setBounds(200, 200, 300, 30); // Adjusted height for better alignment
        selectPictureLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        selectPictureLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));
                
                // Show the file chooser dialog
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    user.setProfilePicPath(selectedFile.getAbsolutePath());
                    
                    // Save the profile picture path to the database
                    saveProfilePicPathToDB(user.getUsername(), user.getProfilePicPath());
                    
                    // Update the profile picture display
                    profilePic.setIcon(new ImageIcon(user.getProfilePicPath()));
                    profilePic.setText("");
                    JOptionPane.showMessageDialog(frame, "Profile picture selected successfully.");
                }
            }
        });
        middleBlockPanel.add(selectPictureLabel);

        // Label to delete the selected picture
        JLabel deletePictureLabel = new JLabel("<html><u>Delete Picture</u></html>");
        deletePictureLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        deletePictureLabel.setForeground(Color.BLUE);
        deletePictureLabel.setBounds(200, 230, 300, 30); // Adjusted position and size
        deletePictureLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deletePictureLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, 
                    "Are you sure you want to delete the profile picture?", 
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Clear the profile picture path and update the display
                    user.setProfilePicPath(null);
                    profilePic.setIcon(null);
                    profilePic.setText("Profile Pic");
                    
                    // Delete the profile picture path from the database
                    deleteProfilePicPathFromDB(user.getUsername());
                    JOptionPane.showMessageDialog(frame, "Profile picture deleted successfully.");
                    
                    // Refresh the component to reflect changes
                    profilePic.revalidate();
                    profilePic.repaint();
                }
            }
        });
        middleBlockPanel.add(deletePictureLabel);



        JPanel middleBlock2Panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200));
                int marginX = 40;
                int marginY = 30;
                g2.fillRoundRect(marginX, marginY, getWidth() - 2 * marginX, getHeight() - 2 * marginY, 30, 30);
            }
        };
        middleBlock2Panel.setOpaque(false);
        middleBlock2Panel.setBounds(650, 130, 550, 550);
        middleBlock2Panel.setLayout(null);
        profilePanel.add(middleBlock2Panel);

     // Add title label for Donations
     // Add title label for Donations
        JLabel DonationsLabel = new JLabel("Thank You for Donating!!");
        DonationsLabel.setBounds(150, 50, 400, 30); // Increased width for full text
        DonationsLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font for header
        DonationsLabel.setForeground(new Color(0, 85, 125)); // Slightly darker color for title
        middleBlock2Panel.add(DonationsLabel);

        // Help link
        JLabel helpLabel = new JLabel("<html><u>Help</u></html>");
        helpLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        helpLabel.setForeground(Color.BLUE);
        helpLabel.setBounds(150, 90, 100, 20); // Positioning below DonationsLabel
        helpLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        helpLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "For assistance, please contact support@example.com");
            }
        });
        middleBlock2Panel.add(helpLabel);

        // Phone Number link
        JLabel phoneNumberLabel = new JLabel("<html><u>Phone Number</u></html>");
        phoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        phoneNumberLabel.setForeground(Color.BLUE);
        phoneNumberLabel.setBounds(250, 90, 150, 20); // Positioning next to the helpLabel
        phoneNumberLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        phoneNumberLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "Contact us at: +1-234-567-890");
            }
        });
        middleBlock2Panel.add(phoneNumberLabel);


        // Fetch donation_items from the database
        String donationItems = getDonationItems(user.getUsername()); // Implement getDonationItems method below

        // Create a panel for displaying donation items with a border and padding
        JPanel donationPanel = new JPanel();
        donationPanel.setLayout(null);
        donationPanel.setBounds(100, 150, 300, 220); // Increased width for better appearance
        donationPanel.setOpaque(false);
        donationPanel.setBorder(BorderFactory.createLineBorder(new Color(34, 112, 147), 2, true)); // Rounded border
        middleBlock2Panel.add(donationPanel);

        // Add title for Donation Items
        JLabel donationTitleLabel = new JLabel("Items You have donated:");
        donationTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        donationTitleLabel.setForeground(new Color(34, 112, 147));
        donationTitleLabel.setBounds(10, 10, 280, 25); // Slightly larger title font
        donationPanel.add(donationTitleLabel);

        // Display donation items or error message if none are found
        JLabel donationItemsLabel;
        if (donationItems != null && !donationItems.isEmpty()) {
            donationItemsLabel = new JLabel("<html><p style='width: 260px;'>" + donationItems + "</p></html>"); // Wrapping text for long items
            donationItemsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            donationItemsLabel.setForeground(new Color(60, 60, 60));
            donationItemsLabel.setBounds(10, 50, 280, 150); // Adjusted bounds for content
            donationPanel.add(donationItemsLabel);
        } else {
            donationItemsLabel = new JLabel("No donation items found.");
            donationItemsLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            donationItemsLabel.setForeground(Color.RED);
            donationItemsLabel.setBounds(10, 50, 280, 25); // Position the error message
            donationPanel.add(donationItemsLabel);
        }

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(null); // Use null layout for absolute positioning
        detailsPanel.setBounds(180, 280, 250, 200);
        detailsPanel.setOpaque(false);
        middleBlockPanel.add(detailsPanel);

        JLabel titleLabel = new JLabel("User Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(30, 112, 147)); // Nice color for the title
        titleLabel.setBounds(10, 0, 230, 25); // Set position and size for title label
        detailsPanel.add(titleLabel);

        if (user == null) {
            JLabel errorLabel = new JLabel("Error: User details not found.");
            errorLabel.setFont(new Font("Arial", Font.ITALIC, 16));
            errorLabel.setForeground(Color.RED);
            errorLabel.setBounds(10, 30, 230, 25); // Position the error label
            detailsPanel.add(errorLabel);
        } else {
            // Define starting position for detail labels
            int yPosition = 30;

            // Add spacing and label formatting
            String[] userDetails = {
                "<html><b>Full Name:</b> " + user.getName() + "</html>",
                "<html><b>Username:</b> " + user.getUsername() + "</html>",
                "<html><b>Phone:</b> " + user.getPhoneNumber() + "</html>",
                "<html><b>Date of Birth:</b> " + user.getDob() + "</html>",
                "<html><b>Gender:</b> " + user.getGender() + "</html>",
                "<html><b>Email:</b> " + user.getGmail() + "</html>"
            };

            for (String detail : userDetails) {
                JLabel detailLabel = new JLabel(detail);
                detailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                detailLabel.setForeground(new Color(60, 60, 60)); // Softer color for details text
                detailLabel.setBounds(10, yPosition, 230, 25); // Set position and size for each detail label
                detailsPanel.add(detailLabel);
                yPosition += 30; // Increase yPosition for the next label
            }
        }

        // Add padding to the main details panel
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));



        JButton logoutButton = new JButton("Logout");
        logoutButton.setFocusPainted(false);
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        logoutButton.setBounds(600, 650, 100, 30);
        profilePanel.add(logoutButton);

        logoutButton.addActionListener(e -> {
            frame.remove(profilePanel);
            showNextSlide(frame);
            frame.revalidate();
            frame.repaint();
        });

        frame.revalidate();
        frame.repaint();
    }
    
    
 // Method to retrieve donation_items from the signin table
    public static String getDonationItems(String username) {
        String donationItems = null;
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "SELECT donation_items FROM signin WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    donationItems = resultSet.getString("donation_items");
                    System.out.println("Donation items for user " + username + ": " + donationItems); // Print to console
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to retrieve donation items from the database.");
        }
        return donationItems;
    }
    
    public static void deleteProfilePicPathFromDB(String username) {
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "UPDATE signin SET profile_pic = NULL WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                int rowsAffected = statement.executeUpdate();

                // Confirm if the deletion was successful in the database
                if (rowsAffected > 0) {
                    System.out.println("Profile picture path deleted in the database for user: " + username);
                } else {
                    System.out.println("No profile picture path found for deletion for user: " + username);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete profile picture from the database: " + ex.getMessage());
        }
    }

    // Database interaction methods
    private static void saveProfilePicPathToDB(String username, String path) {
        String query = "UPDATE signin SET profile_pic = ? WHERE username = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, path);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String loadProfilePicPathFromDB(String username) {
        String query = "SELECT profile_pic FROM signin WHERE username = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("profile_pic");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Method to fetch user details from the database
    private static User fetchUserDetails(String loggedInUsername) {
        User user = null;
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "SELECT name, username, phone_number, dob, gender, gmail, address FROM signin WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, loggedInUsername);
            System.out.println("Executing query for user: " + loggedInUsername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setDob(rs.getDate("dob"));
                user.setGender(rs.getString("gender"));
                user.setGmail(rs.getString("gmail"));
                user.setAddress(rs.getString("address"));
                System.out.println("User details retrieved successfully: " + user.getName());
            } else {
                System.out.println("No user found with username: " + loggedInUsername);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
   
    private static void showDonateSlide(JFrame frame) {
        JPanel donatePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26, 141, 142));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        donatePanel.setLayout(null);
        donatePanel.setBounds(0, 0, 1400, 800);
        frame.add(donatePanel);

        JLabel logoLabel = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\2.jpg")
                .getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH))); // Reduced size
        logoLabel.setBounds(250, 30, 170, 100); // Positioned at the top-left corner
        donatePanel.add(logoLabel);

        JLabel logonameLabel = new JLabel("SupportNet");
        logonameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        logonameLabel.setForeground(Color.BLACK);
        logonameLabel.setBounds(430, 35, 300, 80); // Adjust position to be beside the logo
        donatePanel.add(logonameLabel);

        JLabel taglineLabel = new JLabel("Connecting Donors with Those in Need");
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Normal font size
        taglineLabel.setForeground(Color.BLACK);
        taglineLabel.setBounds(430, 100, 400, 30); // Positioned below "SupportNet"
        donatePanel.add(taglineLabel);
        
        // Profile Button
        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(1380, 20, 100, 50); // Set position and size
        profileButton.setBorderPainted(false); // Remove default border
        profileButton.setFocusPainted(false); // Remove focus paint
        profileButton.setContentAreaFilled(false); // Make the content area transparent

        profileButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200)); // Background color
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners

                // Draw text in the center
                g2.setColor(Color.BLACK); // Text color
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(profileButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(profileButton.getText(), textX, textY);
                g2.dispose();
            }
        });
        
        donatePanel.add(profileButton);
        
        // Back Button
        JButton backButton = new JButton(); // No text needed
        backButton.setBounds(10, 10, 50, 30); // Position of the button
        backButton.setFocusPainted(false); // Remove focus paint
        backButton.setContentAreaFilled(false); // Make the content area transparent
        backButton.setBorderPainted(false); // Remove default border painting

        backButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(26, 141, 142)); // Background color
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners

                // Draw arrow
                g2.setColor(Color.WHITE); // Arrow color
                int arrowWidth = 8; // Width of the arrow
                int arrowHeight = 16; // Height of the arrow
                int x = 30; // X position of the arrow
                int y = c.getHeight() / 2; // Y position to center the arrow
                
                // Draw the arrow using a polygon
                g2.fillPolygon(new int[]{x, x, x - arrowWidth}, new int[]{y - arrowHeight / 2, y + arrowHeight / 2, y}, 3);
                g2.setColor(new Color(255, 230, 200)); // Border color
                g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 15, 15); // Rounded border
                g2.dispose();
            }
        });
        
        donatePanel.add(backButton);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); // Clear the current content
                Home(frame,loggedInUser); // Call the function to go back to the welcome slide
                frame.revalidate();
                frame.repaint();
            }
        });
        
        // Middle Block
        JPanel middleBlockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200)); // Cream color
                int marginX = 40; // Horizontal margin
                int marginY = 30; // Vertical margin
                g2.fillRoundRect(marginX, marginY, getWidth() - 2 * marginX, getHeight() - 2 * marginY, 30, 30);
            }
        };
        middleBlockPanel.setOpaque(false);
        middleBlockPanel.setBounds(150, 130, 1000, 630);
        middleBlockPanel.setLayout(null);
        donatePanel.add(middleBlockPanel);
        
        JLabel signUpTitleLabel = new JLabel("Fill the Details");
        signUpTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        signUpTitleLabel.setForeground(Color.BLACK);
        signUpTitleLabel.setBounds(400, 40, 300, 30);
        middleBlockPanel.add(signUpTitleLabel);
        
        // Donation Question
        JLabel donationQuestionLabel = new JLabel("What are you donating?");
        donationQuestionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        donationQuestionLabel.setForeground(Color.BLACK);
        donationQuestionLabel.setBounds(100, 90, 300, 30); // Position above the checkboxes
        middleBlockPanel.add(donationQuestionLabel);

        Color checkboxColor = new Color(255, 230, 200);
        
        // Donation Checkboxes
        JCheckBox clothesCheckBox = new JCheckBox("Clothes");
        clothesCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
        clothesCheckBox.setBounds(100, 140, 150, 30);
        clothesCheckBox.setBackground(checkboxColor);
        clothesCheckBox.setOpaque(true);
        middleBlockPanel.add(clothesCheckBox);

        JCheckBox booksCheckBox = new JCheckBox("Books");
        booksCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
        booksCheckBox.setBounds(100, 180, 150, 30);
        booksCheckBox.setBackground(checkboxColor);
        booksCheckBox.setOpaque(true);
        middleBlockPanel.add(booksCheckBox);

        JCheckBox gadgetsCheckBox = new JCheckBox("Electrical Gadgets");
        gadgetsCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
        gadgetsCheckBox.setBounds(100, 220, 200, 30);
        gadgetsCheckBox.setBackground(checkboxColor);
        gadgetsCheckBox.setOpaque(true);
        middleBlockPanel.add(gadgetsCheckBox);

        JCheckBox furnitureCheckBox = new JCheckBox("Furniture");
        furnitureCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
        furnitureCheckBox.setBounds(100, 260, 150, 30);
        furnitureCheckBox.setBackground(checkboxColor);
        furnitureCheckBox.setOpaque(true);
        middleBlockPanel.add(furnitureCheckBox);

        JCheckBox othersCheckBox = new JCheckBox("Others");
        othersCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
        othersCheckBox.setBounds(100, 300, 150, 30);
        othersCheckBox.setBackground(checkboxColor);
        othersCheckBox.setOpaque(true);
        middleBlockPanel.add(othersCheckBox);
        
        // Address Fields
        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setBounds(650, 90, 300, 30);
        middleBlockPanel.add(addressLabel);
        
        // House No Field
        JLabel houseNoLabel = new JLabel("House No.:");
        houseNoLabel.setBounds(550, 150, 100, 30);
        middleBlockPanel.add(houseNoLabel);
        JTextField houseNoField = new JTextField();
        houseNoField.setBounds(700, 150, 200, 30);
        middleBlockPanel.add(houseNoField);
        
        // Street Field
        JLabel streetLabel = new JLabel("Street:");
        streetLabel.setBounds(550, 200, 100, 30);
        middleBlockPanel.add(streetLabel);
        JTextField streetField = new JTextField();
        streetField.setBounds(700, 200, 200, 30);
        middleBlockPanel.add(streetField);
        
        // Landmarks Field
        JLabel landmarksLabel = new JLabel("Landmarks:");
        landmarksLabel.setBounds(550, 250, 100, 30);
        middleBlockPanel.add(landmarksLabel);
        JTextField landmarksField = new JTextField();
        landmarksField.setBounds(700, 250, 200, 30);
        middleBlockPanel.add(landmarksField);
        
        // Pincode Field
        JLabel pincodeLabel = new JLabel("Pincode:");
        pincodeLabel.setBounds(550, 300, 100, 30);
        middleBlockPanel.add(pincodeLabel);
        JTextField pincodeField = new JTextField();
        pincodeField.setBounds(700, 300, 200, 30);
        middleBlockPanel.add(pincodeField);
        
        // City Field
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(550, 350, 100, 30);
        middleBlockPanel.add(cityLabel);
        JTextField cityField = new JTextField();
        cityField.setBounds(700, 350, 200, 30);
        middleBlockPanel.add(cityField);
        
        // State Field
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setBounds(550, 400, 100, 30);
        middleBlockPanel.add(stateLabel);
        JTextField stateField = new JTextField();
        stateField.setBounds(700, 400, 200, 30);
        middleBlockPanel.add(stateField);
        
        // Country Field
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(550, 450, 100, 30);
        middleBlockPanel.add(countryLabel);
        JTextField countryField = new JTextField();
        countryField.setBounds(700, 450, 200, 30);
        middleBlockPanel.add(countryField);
        
        // Donate Button
        JButton donateButton = new JButton("Donate");
        donateButton.setBounds(400, 500, 150, 40);
        donateButton.setBackground(new Color(26, 141, 142));
        donateButton.setForeground(Color.WHITE);
        donateButton.setFont(new Font("Arial", Font.BOLD, 20));
        donateButton.addActionListener(e -> {
            // Retrieve text from input fields
            String houseNo = houseNoField.getText();
            String street = streetField.getText();
            String landmarks = landmarksField.getText();
            String pincode = pincodeField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String country = countryField.getText();

            // Check if all address fields are filled
            if (houseNo.isEmpty() || street.isEmpty() || landmarks.isEmpty() || pincode.isEmpty() 
                || city.isEmpty() || state.isEmpty() || country.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all address details before proceeding.");
                return; // Exit if any field is empty
            }

            // Collect selected checkboxes
            List<String> selectedItems = new ArrayList<>();
            if (clothesCheckBox.isSelected()) selectedItems.add("Clothes");
            if (booksCheckBox.isSelected()) selectedItems.add("Books");
            if (gadgetsCheckBox.isSelected()) selectedItems.add("Electrical Gadgets");
            if (furnitureCheckBox.isSelected()) selectedItems.add("Furniture");
            if (othersCheckBox.isSelected()) selectedItems.add("Others");

            // Check if at least one item is selected
            if (selectedItems.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select at least one item to donate before proceeding.");
                return; // Exit if no checkbox is selected
            }

            // Join selected items as a comma-separated string
            String selectedItemsString = String.join(",", selectedItems);

            // Save the donation details, including the selected items
            saveDonationDetails(houseNo, street, landmarks, pincode, city, state, country, selectedItemsString);

            // Clear current content and navigate to the Thank You slide
            frame.getContentPane().removeAll();
            ThanksSlide(frame); 
            frame.revalidate();
            frame.repaint();
        });

        middleBlockPanel.add(donateButton);
        frame.setVisible(true);
    }

    private static void saveDonationDetails(String houseNo, String street, String landmarks, String pincode, String city, String state, String country, String donationItems) {
        
        // Check if any field is empty
        if (houseNo.isEmpty() || street.isEmpty() || landmarks.isEmpty() || pincode.isEmpty() 
            || city.isEmpty() || state.isEmpty() || country.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all address details before proceeding.");
            return; // Exit the method if any field is empty
        }

        String username = User.getUsername();
        String insertSQL = "UPDATE signin SET house_no = ?, street = ?, landmarks = ?, "
            + "pincode = ?, city = ?, state = ?, country = ?, donation_items = ? WHERE username = ?";

        try (Connection connection = DatabaseConnector.connect(); // Ensure you have this method to get a connection
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set the parameters in the prepared statement
            preparedStatement.setString(1, houseNo);
            preparedStatement.setString(2, street);
            preparedStatement.setString(3, landmarks);
            preparedStatement.setString(4, pincode);
            preparedStatement.setString(5, city);
            preparedStatement.setString(6, state);
            preparedStatement.setString(7, country);
            preparedStatement.setString(8, donationItems); // Set the donation items
            preparedStatement.setString(9, username); // Set username as the last parameter

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Donation details saved successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No rows updated. Please check username.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving donation details: " + e.getMessage());
        }
    }

    private static void ThanksSlide(JFrame frame) {

    	
    	JPanel thanksPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26, 141, 142)); // Teal Blue color (#1A8D8E)
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        thanksPanel.setLayout(null);
        thanksPanel.setBounds(0, 0, 1560, 800);
        frame.add(thanksPanel);
        
        JLabel logoLabel = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\2.jpg")
                .getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH))); // Reduced size
        logoLabel.setBounds(350, 30, 170, 100); // Positioned at the top-left corner
        thanksPanel.add(logoLabel);
        
        JLabel logonameLabel = new JLabel("SupportNet");
        logonameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        logonameLabel.setForeground(Color.BLACK);
        logonameLabel.setBounds(550, 35, 300, 80); // Adjust position to be beside the logo
        thanksPanel.add(logonameLabel);
        
        JLabel taglineLabel = new JLabel("Connecting Donors with Those in Need");
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Normal font size
        taglineLabel.setForeground(Color.BLACK);
        taglineLabel.setBounds(550, 100, 400, 30); // Positioned below "SupportNet"
        thanksPanel.add(taglineLabel);
        
        // profile button starts
        
        // ImageIcon profileIcon = new ImageIcon("C:\\Users\\sindh\\Downloads\\profile logo image.png", 30, 30); // Adjust size as needed
         
         JButton profileButton = new JButton("Profile");
         profileButton.setBounds(1380, 20, 100, 50);  // Set position and size
         profileButton.setBorderPainted(false); // Remove default border
         profileButton.setFocusPainted(false); // Remove focus paint
         profileButton.setContentAreaFilled(false); // Make the content area transparent

         profileButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
             @Override
             public void paint(Graphics g, JComponent c) {
                 Graphics2D g2 = (Graphics2D) g.create();
                 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                 // Set background color
                 g2.setColor(new Color(255, 230, 200)); // Same color as before
                 g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                 // Draw text in the center
                 g2.setColor(Color.BLACK); // Text color
                 FontMetrics fm = g2.getFontMetrics();
                 int textX = (c.getWidth() - fm.stringWidth(profileButton.getText())) / 2;
                 int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                 g2.drawString(profileButton.getText(), textX, textY);

                 g2.dispose();
             }
         });
         
         thanksPanel.add(profileButton);
         //profile button ends
         
         //middle block starts
        JPanel middleBlockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 230, 200)); // Cream color
                
                int marginX = 40; // Horizontal margin to reduce width
                int marginY = 30; // Vertical margin for alignment
                
                g2.fillRoundRect(marginX, marginY, getWidth() - 2 * marginX, getHeight() - 2 * marginY, 30, 30);
            }
        };
        middleBlockPanel.setOpaque(false);
        middleBlockPanel.setBounds(100, 130, 1100, 600);
        middleBlockPanel.setLayout(null);
        thanksPanel.add(middleBlockPanel);
      //middle block ends
        
        JLabel tqLabel = new JLabel("Thank you for contributing!");
        tqLabel.setFont(new Font("Arial", Font.BOLD, 36));
        tqLabel.setForeground(Color.BLACK);
        tqLabel.setBounds(300, 50, 500, 80); // Adjust position to be beside the logo
        middleBlockPanel.add(tqLabel);
        
        JLabel matterLabel = new JLabel("<html><div style='text-align:justify; line-height:2.5;'>"
                + "Your support truly makes a difference in the lives of those in need. We deeply appreciate your willingness to help.<br><br>"
                + "We’ll keep you updated with further details, including when we’ll be collecting the materials from you.<br><br>"
                + "Your kindness brings hope to others, and together, we are making a positive impact."
                + "</div></html>");
    	matterLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Normal font size
    	matterLabel.setForeground(Color.BLACK);
    	matterLabel.setBounds(200, 140, 700, 150); // Adjusted width and height to fit text
    	middleBlockPanel.add(matterLabel);

        
      //start of donate button
        JButton gotohomeButton = new JButton("Go to Home");
        gotohomeButton.setBounds(500, 470, 120, 40);  // Set position and size
        gotohomeButton.setBorderPainted(false); // Remove default border
        gotohomeButton.setFocusPainted(false); // Remove focus paint
        gotohomeButton.setContentAreaFilled(false); // Make the content area transparent

        gotohomeButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set background color
                g2.setColor(new Color(26, 141, 142)); // Background color (customize as needed)
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with 15 radius

                // Draw text in the center
                g2.setColor(Color.WHITE); // Text color
                FontMetrics fm = g2.getFontMetrics();
                int textX = (c.getWidth() - fm.stringWidth(gotohomeButton.getText())) / 2;
                int textY = (c.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
                g2.drawString(gotohomeButton.getText(), textX, textY);

                g2.dispose();
            }
        });

        middleBlockPanel.add(gotohomeButton);
        //end of donate button
        
        gotohomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); // Clear the current content
                Home(frame,loggedInUser); // Call the function to go back to the welcome slide
                frame.revalidate();
                frame.repaint();
            }
        });
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); // Clear the current content
                showUserProfile(frame,loggedInUser); // Call the function to go back to the welcome slide
                frame.revalidate();
                frame.repaint();
            }
        });

    }
    	
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("SupportNet");
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(26, 141, 142)); 

        // Loading panel with the first logo and "Loading..." text
        JPanel loadingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(26,141,142));//Teal Blue 
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        loadingPanel.setLayout(null);
        loadingPanel.setBounds(0, 0, 1400, 800);

        JLabel logoLabel = new JLabel(new ImageIcon(new ImageIcon("D:\\KLH\\SEM3\\AOOP\\Project\\1.jpg")
                .getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
        logoLabel.setBounds(450, 105, 350, 350);
        loadingPanel.add(logoLabel);

        JLabel loadingLabel = new JLabel("Loading...");
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loadingLabel.setForeground(Color.BLACK);
        loadingLabel.setBounds(580, 480, 150, 30);
        loadingPanel.add(loadingLabel);

        frame.add(loadingPanel);
        frame.setVisible(true);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                frame.remove(loadingPanel);
                showNextSlide(frame);
                frame.revalidate();
                frame.repaint();
            }
        }, 1000);
    }
    
    
}