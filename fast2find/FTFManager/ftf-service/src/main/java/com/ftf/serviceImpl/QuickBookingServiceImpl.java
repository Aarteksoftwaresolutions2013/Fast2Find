package com.ftf.serviceImpl;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.ftf.model.Branch;
import com.ftf.model.QuickBooking;
import com.ftf.repository.QuickBookingRepository;
import com.ftf.service.QuickBookingService;
import com.ftf.util.IConstant;

@Service
public class QuickBookingServiceImpl implements QuickBookingService {
  @Autowired
  private QuickBookingRepository quickBookingRepository;

  @Autowired
  private JavaMailSender mailSender;
  
/**
 * addBooking method use to save booking information into database.
 * send method use to send booking information to customer.
 * @param quickBooking
 * @param messagePreparator
 */
  public boolean addBooking(QuickBooking quickBooking, final String emailId) {
    boolean status = false;
    final int noOfPeople = quickBooking.getNumberOfPerson();
    final String time = quickBooking.getTableBookingTime();
    final String orderPlace = quickBooking.getOrderPlace();
    quickBooking.setIsDeleted(IConstant.IS_DELETED);
    Branch branch = new Branch();
    branch.setBranchId(quickBooking.getbId());
    quickBooking.setBranch(branch);
    MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
      public void prepare(MimeMessage mimeMessage) throws Exception {
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
        mimeMessage.setFrom(new InternetAddress("earl@fast2find.com"));
        mimeMessage.setSubject("Your QuickBooking Reciept");
        mimeMessage.setText("Dear Customer thank you for placing order. Your order is:"
            + orderPlace + "," + noOfPeople + "People at" + time);
      }
    };
    mailSender.send(messagePreparator);
    status = quickBookingRepository.addBooking(quickBooking);
    if (status) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * send() use to send quick booking information to user.
   * addBooking() method use for save quick booking information into database.
   * @param quickBooking
   */
  public boolean addBooking(QuickBooking quickBooking) {
    boolean status = false;
    final int noOfPeople = quickBooking.getNumberOfPerson();
    final String time = quickBooking.getTableBookingTime();
    final String orderPlace = quickBooking.getOrderPlace();
    final String emailId = quickBooking.getEmailId();
    quickBooking.setIsDeleted(IConstant.IS_DELETED);
    Branch branch = new Branch();
    branch.setBranchId(quickBooking.getbId());
    quickBooking.setBranch(branch);
    MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
      public void prepare(MimeMessage mimeMessage) throws Exception {
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
        mimeMessage.setFrom(new InternetAddress("earl@fast2find.com"));
        mimeMessage.setSubject("Your QuickBooking Reciept");
        mimeMessage.setText("Dear Customer thank you for placing order. Your order is:"
            + orderPlace + "," + noOfPeople + "People at" + time);
      }
    };
    mailSender.send(messagePreparator);
    status = quickBookingRepository.addBooking(quickBooking);
    if (status) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @param mailSender
   *          the mailSender to set
   */
  public void setMailSender(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  /**
   * addeventBooking method use to save event booking information into database.
   * send method use to send quick booking information to customer
   * @param quickBooking
   *  @param messagePreparator
   */
  public boolean addeventBooking(QuickBooking quickBooking, final String emailId) {
    boolean status = false;
    final int noOfPeople = quickBooking.getNumberOfPerson();
    final String orderPlace = quickBooking.getOrderPlace();
    quickBooking.setIsDeleted(IConstant.IS_DELETED);
    Branch branch = new Branch();
    branch.setBranchId(quickBooking.getbId());
    quickBooking.setBranch(branch);
    MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
      public void prepare(MimeMessage mimeMessage) throws Exception {
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
        mimeMessage.setFrom(new InternetAddress("earl@fast2find.com"));
        mimeMessage.setSubject("Your QuickBooking Reciept");
        mimeMessage.setText("Dear Customer thank you for placing order. Your order is:"
            + orderPlace + "," + noOfPeople + "People");
      }
    };
    mailSender.send(messagePreparator);
    status = quickBookingRepository.addeventBooking(quickBooking);
    if (status) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * saveComment() method use to save user comment.
   * @param quickBooking
   */
  public boolean saveComment(QuickBooking quickBooking) {
    boolean status = false;
    quickBooking.setIsDeleted(IConstant.IS_DELETED);
    Branch branch = new Branch();
    branch.setBranchId(quickBooking.getbId());
    quickBooking.setBranch(branch);
    status = quickBookingRepository.saveComment(quickBooking);
    if (status) {
      return true;
    } else {
      return false;
    }
  }
}
