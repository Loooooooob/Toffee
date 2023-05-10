public abstract class person {
    private String name; 
    private String email; 
    private String password; 
    private String address; 
    public void setUsername(String Name){
        name=Name;
    }
    public void setEmail(String Email ){
        email=Email;
    }
    public void setPassword(String Password){
        password=Password;
    }
    public void setAddress(String Address ){
        address=Address;
    }
    public String getUsername(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getAddress(){
        return address;
    }
}
