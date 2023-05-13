import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The SignUp class provides methods to get input from the user to create a new account,
 * validate the input, and save the account information to a file.
 */
public class SignUp {
    private String username;
    private String email;
    private String password;
    private String address;
    private user customer = new user();
    private OTP code = new OTP();
    private PersonDB DB = new PersonDB();

    /**
     * Gets input from the user to create a new account,
     * validates the input, and saves the account information to a file.
     */
    public void InputData() {
        Scanner in = new Scanner(System.in);
        setUserName();
        setPassword();
        setEmail();
        setAddress();
        VerifyEmail();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setAddress(address);
        DB.saveUser(customer);
        System.out.println("Resignation successfully");
        System.out.println();
    }

    /**
     * Gets input from the user for the username and validates it.
     * The username must consist of 4-20 characters from the set of letters (upper and lowercase),
     * digits, and the underscore character.
     * The method also checks if the username is already taken.
     */
    public void setUserName() {
        Scanner in = new Scanner(System.in);
        while (true) {
            Boolean validUserName = false;
            System.out.print("Enter Your username: ");
            username = in.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{4,20}$");
            Matcher valid = pattern.matcher(username);
            if (valid.matches()) {
                validUserName = true;
            } else {
                System.out.println("The username is invalid.");
                System.out.println("Please try another one");
            }
            if (validUserName) {
                if (DB.checkDoulicateUserName(username)) {
                    System.out.println("This user name is already choosen\nPlease try another one\n");
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Gets input from the user for the email address and validates it.
     * The email address must be in the correct format with the '@' symbol and a valid domain name.
     */
    public void setEmail() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Your Email: ");
            email = in.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            Matcher valid = pattern.matcher(email);
            if (valid.matches()) {
                break;
            } else {
                System.out.println("The email address is invalid.\nPlease try another one");
            }
        }
    }

    /**
     * Gets input from the user for the password and validates it.
     * The password must be at least 8 characters long and contain at least one uppercase letter,
     * one lowercase letter, and one digit.
     */
    public void setPassword() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Your Password: ");
            password = in.nextLine();
            Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
            Matcher valid = pattern.matcher(password); // check if password matches the excepration
            if (valid.matches()) {
                break;
            } else {
                System.out.println("The password is invalid.\nPlease try another one");
            }
        }
    }

    /**
     * Gets input from the user for the address.
     */
    public void setAddress() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Address: ");
        address = in.nextLine();
    }

    /**
     * Sends an OTP code to the user's email address and asks the user to enter the code
     * to verify the email address.
     */
    public void VerifyEmail() {
        Scanner in = new Scanner(System.in);
        while (true) {
            code.sendOTP(email, username);
            int InCode;
            System.out.print("Enter Verification Code: ");
            InCode = in.nextInt();
            in.nextLine();
            if (InCode == code.getOTP()) {
                System.out.println("Correct code");
                System.out.println();
                break;
            } else {
                System.out.println("Not Correct code !");
                System.out.println("Please Try Again");
                System.out.println();
            }
        }
    }

    /**
     * Returns the username entered by the user.
     *
     * @return the username entered by the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the email address entered by the user.
     *
     * @return the email address entered by the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the password entered by the user.
     *
     * @return the password entered by the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the address entered by the user.
     *
     * @return the address entered by the user
     */
    public String getAddress() {
        return address;
    }
}