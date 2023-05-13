/**
 * An abstract class that represents a person with a name, email, password, and address.
 */
public abstract class person {
    /**
     * The name of the person.
     */
    private String name;
    
    /**
     * The email address of the person.
     */
    private String email;
    
    /**
     * The password of the person.
     */
    private String password;
    
    /**
     * The address of the person.
     */
    private String address;
    
    /**
     * Sets the name of the person.
     * @param Name the name to set
     */
    public void setUsername(String Name){
        name=Name;
    }
    
    /**
     * Sets the email address of the person.
     * @param Email the email address to set
     */
    public void setEmail(String Email ){
        email=Email;
    }
    
    /**
     * Sets the password of the person.
     * @param Password the password to set
     */
    public void setPassword(String Password){
        password=Password;
    }
    
    /**
     * Sets the address of the person.
     * @param Address the address to set
     */
    public void setAddress(String Address ){
        address=Address;
    }
    
    /**
     * Gets the name of the person.
     * @return the name
     */
    public String getUsername(){
        return name;
    }
    
    /**
     * Gets the email address of the person.
     * @return the email address
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Gets the password of the person.
     * @return the password
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * Gets the address of the person.
     * @return the address
     */
    public String getAddress(){
        return address;
    }
}