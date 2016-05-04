package com.ftf.serviceImpl;

import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.ftf.repository.ForgotRepository;
import com.ftf.service.ForgotService;
import com.ftf.util.Encryption;

@Service
public class ForgotServiceImpl implements ForgotService {
	@Autowired
	private ForgotRepository forgotRepository;

	@Autowired
	private JavaMailSender mailSender;
	@SuppressWarnings("rawtypes")
	
	 /**
   * getPassword method use to get password from database.
   * @param email
   */
	public List getPassword(String email) {
		List password = null;
		password = forgotRepository.getPassword(email);
		return password;
	}
	
	 /**
   * sendMail method use to send mail to user who requested for password.
   * @param emailId
   * @param pass
   */
	public void sendMail(final String pass, final String emailId) {
		final String password = Encryption.decrypt(pass);
		System.out.println("password is--" + password);
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(emailId));
				String message = "Dear Customer,<br>";
        message += "&nbsp;&nbsp;&nbsp;We have received a request to email your password .Please find your log-in credentials below:<br>";
        message +=" <br>";
        message += "Email ID /Username : "+emailId+"<br>";
        message +="Password : "+password+"<br>";
        message +=" <br>";
        message +="If you have not raised this request , please contact us at 1-701-214-4566 or email at fast2find@outlook.com.<br>";
        message +=" <br>";
        message +="Regards,<br>";
        message +="Fast2Find Customer Support";
        mimeMessage.setFrom(new InternetAddress("earl@fast2find.com"));
				mimeMessage.setSubject("Welcome to Fast2Find");
				mimeMessage.setContent(message,"text/html");
			}
		};
		mailSender.send(messagePreparator);

	}

	/**
	 * @param mailSender
	 *            the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	 /**
   * sendConfirmation method use to send mail to user if user registration successful.
   * @param emailId
   * @param pass
   */
	public void sendConfirmation(final String pass, final String emailId) {
    final String password = Encryption.decrypt(pass);
    System.out.println("password is--" + password);
    MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
      public void prepare(MimeMessage mimeMessage) throws Exception {
        mimeMessage.setRecipient(Message.RecipientType.TO,
            new InternetAddress(emailId));
        String message = "Dear Customer,<br>";
        message += "&nbsp;&nbsp;&nbsp;You have registered with fast2find successfully, Please find your log-in credentials below::<br>";
        message += "Email ID /Username : "+emailId+"<br>";
        message +="Password : "+password+"<br>";
        mimeMessage.setFrom(new InternetAddress("earl@fast2find.com"));
        mimeMessage.setSubject("Welcome to Fast2Find");
        mimeMessage.setContent(message,"text/html");
      }
    };
    mailSender.send(messagePreparator);
  }

}
