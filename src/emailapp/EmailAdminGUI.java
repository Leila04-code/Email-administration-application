package emailapp;

import javax.swing.*;
import java.awt.*;

public class EmailAdminGUI extends JFrame {

    private EmailManager manager = new EmailManager();

    // Input fields
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> departmentBox;
    private JTextArea outputArea;

    public EmailAdminGUI() {
        setTitle("Email Administration System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ---- TOP PANEL: Input Form ----
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("New Employee"));

        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("Department:"));
        departmentBox = new JComboBox<>(new String[]{"Sales", "Development", "Accounting", "None"});
        formPanel.add(departmentBox);

        // ---- BUTTONS ----
        JButton createBtn = new JButton("Create Account");
        JButton showAllBtn = new JButton("Show All Accounts");

        createBtn.setBackground(new Color(70, 130, 180));
        createBtn.setForeground(Color.WHITE);
        showAllBtn.setBackground(new Color(60, 179, 113));
        showAllBtn.setForeground(Color.WHITE);

        formPanel.add(createBtn);
        formPanel.add(showAllBtn);

        // ---- OUTPUT AREA ----
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ---- ACTIONS ----
        createBtn.addActionListener(e -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String department = departmentBox.getSelectedItem().toString();

            if (firstName.isEmpty() || lastName.isEmpty()) {
                outputArea.setText("Please enter first name and last name.");
                return;
            }

            String dept = department.equals("None") ? "" : department;
            String result = manager.addEmployee(firstName, lastName, dept);
            outputArea.setText(result);

            // Clear fields
            firstNameField.setText("");
            lastNameField.setText("");
        });

        showAllBtn.addActionListener(e -> {
            outputArea.setText(manager.getAllAccounts());
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmailAdminGUI::new);
    }
}
