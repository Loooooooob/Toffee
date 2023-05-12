import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OTP {
    private int myOTP; 
    public void sendOTP(String email,String Name){
        Random rand = new Random(); // Generate random number
        System.out.println("We send to you verification code on your Email");
        myOTP=rand.nextInt(100000);
        String to = email;
        String from = "tawfik040@gmail.com";
        String host = "smtp.gmail.com";


        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "uuyhhvwuvkzgydwu");

            }

        });

        try{
            MimeMessage message = new MimeMessage(session);

            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Verify your email address");
            message.setFrom(new InternetAddress(from));
            message.setText("Dear "+Name+",\nThank you for signing up for our service! Before we can get started, we need to verify your email address.\nTo verify your email address, please enter this otp: "+myOTP+" .\nOnce you have verified your email address, you will be able to access all of the features of our service.\nThank you for using our service!\nBest regards,");

            Transport.send(message);
            System.out.println("OTP sent successfully....");

        }catch (MessagingException mex) {mex.printStackTrace();}
    }
    public int getOTP(){
        return myOTP;
    }
}