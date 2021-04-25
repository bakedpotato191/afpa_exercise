package smtp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public void send(String email, String token) {

		String to = email;
		String from = "";

		final String username = "";
		final String password = "";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("[BookShop] Réinitialisation du mot de passe");

			String lien = "http://localhost:8080/website/password_reset?token=" + token;

			String msg = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN'";
			msg += " 'https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
			msg += "<head>";
			msg += "<title>Test Email Sample</title>";
			msg += "<meta http–equiv='Content-Type' content='text/html; charset=UTF-8' />";
			msg += "<meta http–equiv='X-UA-Compatible' content='IE=edge' />";
			msg += "<meta name='viewport' content='width=device-width, initial-scale=1.0 ' />";
			msg += "</head>";
			msg += "<body>";
			msg += "<div style=\\\'text-align: center;\\\'>";
			msg += "<h1>Réinitialisation de mot de passe</h1>";
			msg += "<div style=\\\"display: inline-block; text-align: left;\\\">";
			msg += "<p>Vous recevez ce mail suite à votre demande de réinitialisation de votre mot de passe sur thebookshop.com</p>";
			msg += "<p>Pour cela il vous suffit de cliquer sur le lien ci-dessous, ou de copier coller l'url dans votre navigateur. Ce lien sera actif 1 heure.</p>";
			msg += "<p><b>Génerer mon nouveau mot de passe: </b><a href='" + lien
					+ "'>lien</a></p>";
			msg += "<p>Si vous n'êtes pas a l'origine de cette demande et souhaitez conserver votre mot de passe actuel, ignorez simplement cet email</p>";
			msg += "<br><p>TheBookShop</p>";
			msg += "</div></div></body><br></html>";

			message.setContent(msg, "text/html; charset=utf-8");

			Transport.send(message);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
