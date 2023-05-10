import java.util.Random;
import java.util.Scanner;

public class OTP {
    private int myOTP; 
    public void setOTP(){
        Scanner in = new Scanner(System.in);
        Random rand = new Random(); // Generate random number
        System.out.println("We send to you verification code on your Email");
        myOTP=rand.nextInt(100000);
    }
    public int getOTP(){
        return myOTP;
    }
}
