package System.PackageDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import System.PackageHuman.person;

/**
 * The PersonDB class provides methods to manage a list of Customer objects
 * stored in a text file. It allows for saving a new customer to the file,
 * checking if a customer with a given username and password exists in the file,
 * and checking if a given username already exists in the file.
 */
public class PersonDB {

    /**
     * The name of the file storing the login information for customers.
     */
    private String DataSource = "loginCustomers.txt";

    /**
     * Saves a new customer to the file.
     *
     * @param customer the customer to be saved
     */
    public void saveUser(person customer) {
        try {
            FileWriter loginCustomers = new FileWriter(DataSource, true);
            loginCustomers.write(customer.getUsername() + " " + customer.getPassword() + " "
                    + customer.getEmail() + " " + customer.getAddress() + "\n");
            loginCustomers.close();
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }

    /**
     * Checks if a customer with the given username and password exists in the file.
     *
     * @param username the username of the customer to check
     * @param password the password of the customer to check
     * @return true if a customer with the given username and password exists in the file, false otherwise
     */
    public boolean checkUser(String username, String password) {
        boolean Find = false;
        try {
            File loginCustomers = new File("loginCustomers.txt");
            Scanner myline = new Scanner(loginCustomers);
            while (myline.hasNextLine()) {
                String data = myline.nextLine();
                if (data.indexOf((username + " " + password), 0) != -1) {
                    Find = true;
                    break;
                }
            }
            myline.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong.");
        }
        return Find;
    }

    /**
     * Checks if a given username already exists in the file.
     *
     * @param username the username to check
     * @return true if the username already exists in the file, false otherwise
     */
    public boolean checkDoulicateUserName(String username) {
        boolean Find = false;
        try {
            File loginCustomers = new File("loginCustomers.txt");
            Scanner myline = new Scanner(loginCustomers);
            while (myline.hasNextLine()) {
                String data = myline.nextLine();
                if (data.indexOf(username, 0) != -1) {
                    Find = true;
                    break;
                }
            }
            myline.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong.");
        }
        return Find;
    }
}
