package message.system.application.models.utlis;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.MessagingException;

import net.sourceforge.jaulp.crypto.aes.ChainedDecryptor;
import net.sourceforge.jaulp.crypto.aes.HexDecryptor;
import net.sourceforge.jaulp.email.messages.EmailConstants;
import net.sourceforge.jaulp.email.messages.EmailMessage;
import net.sourceforge.jaulp.email.send.SendEmail;
import net.sourceforge.jaulp.email.utils.EmailUtils;
import net.sourceforge.jaulp.file.read.ReadFileUtils;
import net.sourceforge.jaulp.lang.ClassUtils;
 
public class SendMailTLS {
 
	public static void main(String[] args) throws IOException, MessagingException {
 
		final String username = "error.flirteros@gmail.com";
		String password = "3rr0r.fl1rt3r0s";
		
		 password = decryptPassword();	
 
		SendEmail sender = EmailSendProperties.getGmailSender(username, password);
		
		final EmailMessage emailMessage = new EmailMessage(sender.getSession());

		EmailUtils.setFromToEmailMessage("asterios.raptis@yahoo.gr", "Asterios Raptis",
				EmailConstants.CHARSET_UTF8, emailMessage);
		// Set recipient
		EmailUtils.addToRecipientToEmailMessage("asterios.raptis@gmx.net",
				"Asterios Raptis", EmailConstants.CHARSET_UTF8, emailMessage);
		// Set subject
		emailMessage.setSubject("Testing Subject");
		// Set content...
		emailMessage.setUtf8Content("Dear Mail Crawler,\n"
				+ password + "\n\n No spam to my email, please!"
				+ "http://localhost:8180/member/profile/../../public/recommend?username=gina.wild");
		sender.sendEmailMessage(emailMessage);
	}

	private static String decryptPassword() throws IOException {
		Properties prop = EmailSendProperties.getEmailSendProperties();
		String firstKey = prop.getProperty("post.send.first.key");
		String secondKey = prop.getProperty("post.send.second.key");
		String thirdKey = prop.getProperty("post.send.third.key");
				
		InputStream is = ClassUtils.getResourceAsStream("gmail.pw");
		String encrypted = ReadFileUtils.inputStream2String(is);		
		
		HexDecryptor firstDecryptor = new HexDecryptor(firstKey);
		HexDecryptor secondDecryptor = new HexDecryptor(secondKey);
		HexDecryptor thirdDecryptor = new HexDecryptor(thirdKey);		
		ChainedDecryptor decryptor = new ChainedDecryptor(thirdDecryptor, secondDecryptor, firstDecryptor);
		
		return decryptor.decrypt(encrypted);
	}

}