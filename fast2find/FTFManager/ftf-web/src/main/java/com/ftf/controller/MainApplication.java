package com.ftf.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class EmailAlertWeekly extends TimerTask {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/admin_fast2find_db";
  static final String USER = "root";
  static final String PASS = "root";

  public void run() {
    Connection conn = null;
    Statement stmt = null;
    Statement stmt1 = null;
    String weekly = "weekly";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      stmt1 = conn.createStatement();
      String sql = "select * from emailalert where EMAIL_ALERT_TIME='" + weekly + "'";
      ResultSet rs = stmt.executeQuery(sql);
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      while (rs.next()) {
        String email = rs.getString("EMAIL_ID");
        String updatedDate = rs.getString("UPDATED_ON");
        System.out.print("EMAIL: " + email + '\n');
        System.out.print("emailTime:" + updatedDate + '\n');
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(updatedDate));
        cal.add(Calendar.DATE, 7);
        String convertedDate = dateFormat.format(cal.getTime());
        System.out.println("Date increase by one.." + convertedDate);
        Date date = new Date();
        String todayDate = dateFormat.format(date);
        System.out.println("today Date--" + todayDate);
        if (convertedDate.equals(todayDate)) {
          System.out.println("inside if block");
          String sql2 = "select * from branch b LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID where b.BRANCH_TYPE='"
              + rs.getString("CATAGORY") + "' and l.CITY_NAME='" + rs.getString("CITY") + "' ";
          ResultSet rs2 = stmt1.executeQuery(sql2);
          while (rs2.next()) {
            final String username = "earl@fast2find.com";
            final String password = "Efinch~2013";
            Properties props = new Properties();
            props.put("host", "dedrelay.secureserver.net");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "25");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "true");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });
            try {
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("earl@fast2find.com"));
              message.setRecipients(Message.RecipientType.TO,
                  InternetAddress.parse(rs.getString("EMAIL_ID")));
              message.setSubject("Fast2Find Event Information");
              message.setText("Event Information:Place" + rs2.getString("BRANCH_NAME")
                  + "Event Name:" + rs2.getString("ADDITIONAL_INFO") + "Start Date&Time:-"
                  + rs2.getString("EVENT_START_DATEANDTIME") + "End Date&Time:-"
                  + rs2.getString("EVENT_END_DATEANDTIME"));
              Transport.send(message);
              System.out.println("Done");
            } catch (MessagingException e) {
              throw new RuntimeException(e);
            }
          }

        }
      }
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (stmt != null && stmt1 != null)
          stmt.close();
        stmt1.close();
      } catch (SQLException se2) {
      }
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }
  }
}

class EmailAlertMonthly extends TimerTask {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/admin_fast2find_db";
  static final String USER = "root";
  static final String PASS = "root";

  public void run() {
    Connection conn = null;
    Statement stmt = null;
    Statement stmt1 = null;
    String monthly = "monthly";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      stmt1 = conn.createStatement();
      String sql = "select * from emailalert where EMAIL_ALERT_TIME='" + monthly + "'";
      ResultSet rs = stmt.executeQuery(sql);
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      while (rs.next()) {
        String email = rs.getString("EMAIL_ID");
        String updatedDate = rs.getString("UPDATED_ON");
        System.out.print("EMAIL: " + email + '\n');
        System.out.print("emailTime:" + updatedDate + '\n');
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(updatedDate));
        cal.add(Calendar.DATE, 30);
        String convertedDate = dateFormat.format(cal.getTime());
        System.out.println("Date increase by one.." + convertedDate);
        Date date = new Date();
        String todayDate = dateFormat.format(date);
        System.out.println("today Date--" + todayDate);
        if (convertedDate.equals(todayDate)) {
          System.out.println("inside if block");
          String sql2 = "select * from branch b LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID where b.BRANCH_TYPE='"
              + rs.getString("CATAGORY") + "' and l.CITY_NAME='" + rs.getString("CITY") + "' ";
          ResultSet rs2 = stmt1.executeQuery(sql2);
          while (rs2.next()) {
            final String username = "earl@fast2find.com";
            final String password = "Efinch~2013";
            Properties props = new Properties();
            props.put("host", "dedrelay.secureserver.net");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "25");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "true");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });
            try {
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("earl@fast2find.com"));
              message.setRecipients(Message.RecipientType.TO,
                  InternetAddress.parse(rs.getString("EMAIL_ID")));
              message.setSubject("Fast2Find Event Information");
              message.setText("Event Information:Place" + rs2.getString("BRANCH_NAME")
                  + "Event Name:" + rs2.getString("ADDITIONAL_INFO") + "Start Date&Time:-"
                  + rs2.getString("EVENT_START_DATEANDTIME") + "End Date&Time:-"
                  + rs2.getString("EVENT_END_DATEANDTIME"));
              Transport.send(message);
              System.out.println("Done");
            } catch (MessagingException e) {
              throw new RuntimeException(e);
            }
          }
        }
      }
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (stmt != null && stmt1 != null)
          stmt.close();
        stmt1.close();
      } catch (SQLException se2) {
      }
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }
  }
}

public class MainApplication {
  public static void main(String[] args) {
    Timer timer = new Timer();
    Calendar date = Calendar.getInstance();
    timer.schedule(new EmailAlertWeekly(), date.getTime(), 1000 * 60 * 60 * 24 * 7);
    Timer timer2 = new Timer();
    Calendar date2 = Calendar.getInstance();
    timer2.schedule(new EmailAlertMonthly(), date2.getTime(), 1000 * 60 * 60 * 24 * 30);
  }
}