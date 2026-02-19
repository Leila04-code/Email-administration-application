package emailapp;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "leilacompany.com";

    public Email(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = randomPassword(defaultPasswordLength);

        String deptAbbr;
        if (department.equalsIgnoreCase("Sales"))            { deptAbbr = "sales"; }
        else if (department.equalsIgnoreCase("Development")) { deptAbbr = "dev"; }
        else if (department.equalsIgnoreCase("Accounting"))  { deptAbbr = "acct"; }
        else                                                  { deptAbbr = ""; }

        if (deptAbbr.isEmpty()) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        } else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + deptAbbr + "." + companySuffix;
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity) { this.mailBoxCapacity = capacity; }
    public void setAlternateEmail(String altEmail) { this.alternateEmail = altEmail; }
    public void changePassword(String password) { this.password = password; }

    public String getEmail()          { return email; }
    public String getPassword()       { return password; }
    public int getMailBoxCapacity()   { return mailBoxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getFirstName()      { return firstName; }
    public String getLastName()       { return lastName; }

    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
               "\nEmail: " + email +
               "\nMailbox Capacity: " + mailBoxCapacity + " MB" +
               "\nPassword: " + password;
    }
}

