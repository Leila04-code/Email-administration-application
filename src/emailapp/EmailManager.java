package emailapp;

import java.util.ArrayList;

public class EmailManager {

    private ArrayList<Email> emailList = new ArrayList<>();

    // Add a new employee - checks for duplicates
    public String addEmployee(String firstName, String lastName, String department) {
        Email newEmail = new Email(firstName, lastName, department);

        // Check for duplicate email
        for (Email e : emailList) {
            if (e.getEmail().equalsIgnoreCase(newEmail.getEmail())) {
                return "ERROR: Email " + newEmail.getEmail() + " already exists!";
            }
        }

        emailList.add(newEmail);
        return "SUCCESS: Account created!\n" + newEmail.showInfo();
    }

    // Display all accounts
    public String getAllAccounts() {
        if (emailList.isEmpty()) {
            return "No accounts found.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== ALL EMPLOYEE ACCOUNTS (").append(emailList.size()).append(") ===\n\n");
        for (int i = 0; i < emailList.size(); i++) {
            sb.append("--- Employee ").append(i + 1).append(" ---\n");
            sb.append(emailList.get(i).showInfo()).append("\n\n");
        }
        return sb.toString();
    }

    // Get total number of accounts
    public int getTotalAccounts() {
        return emailList.size();
    }
}