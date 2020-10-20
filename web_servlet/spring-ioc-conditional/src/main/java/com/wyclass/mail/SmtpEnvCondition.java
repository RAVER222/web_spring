package com.wyclass.mail;

public class SmtpEnvCondition implements MailService{
    public void sendMail(String address, String subject, String body) {
        System.out.println("Send mail to " + address + " using SMTP:");
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
