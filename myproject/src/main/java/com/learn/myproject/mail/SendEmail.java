
package com.learn.myproject.mail;

import com.learn.myproject.entites.User;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.SessionFactory;


public class SendEmail {
    
     private SessionFactory factory;
    public SendEmail(SessionFactory factory) {
        this.factory = factory;
    }
    //get random code
     public String getRandom(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);        
        return String.format("%06d",number);
    }
     //send Email
     public boolean SendEmail(User user){
        boolean test = false;
        
        String toEmail = user.getUserEMAIL();
        final String fromEmail ="furniture.commail2020@gmail.com";
        final String password = "hellowfun2020@@";
        
        try{
            Properties pr =new Properties();
            pr.setProperty("mail.smtp.host","smtp.gmail.com");
            pr.setProperty("mail.smtp.port","465");
            pr.setProperty("mail.smtp.auth","true");
            pr.setProperty("mail.smtp.ssl.enable","true");
           
            
            
            Session session = Session.getInstance(pr,new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail,password); //To change body of generated methods, choose Tools | Templates.
                }              
                
            });
            
            MimeMessage mess = new MimeMessage(session);
             mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
           
            
            mess.setSubject("User Email Verificaion");
            
            mess.setText("Registration Successfully Please verify your account using this OTP:"+user.getUserCODE());
            
            
            Transport.send(mess);
            
            test=true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
                
                return test;
    }
}
