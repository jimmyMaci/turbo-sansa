package message.system.application.models.utlis;

import java.util.Locale;

import message.system.application.models.InfoMessageModel;
import message.system.application.models.utlis.EmailComposer;
import net.sourceforge.jaulp.locale.Locales;

import org.testng.annotations.Test;



public class EmailComposerTest {

	@Test(enabled=false)
	public void testCreateEmailMessageForForgottenPassword() {
		InfoMessageModel model = EmailComposer
				.createEmailMessageForForgottenPassword("xy@z.com", "z.com",
						"abc", "Albert Einstein", "a.e@gmail.com", "yyy",
						"http://www.xy.com/bla=fasel", Locales.GREEK);
		System.out.println(model.getMessageContentModel().getSubject());

	}

	@Test(enabled=true)
	public void testCreateEmailMessageForRecommendProfile() {
		InfoMessageModel model = EmailComposer.createEmailMessageForRecommendProfile(
				"xy@z.com", "z.com",
				"abc", "Albert Einstein", "a.e@gmail.com", "yyy",
				"http://www.xy.com/bla=3", "Bla", "http://senderProfileLink", "http://signupLink", Locale.GERMAN);
		System.out.println(model.getMessageContentModel().getSubject());
		System.out.println(model.getMessageContentModel().getContent());
	}
}