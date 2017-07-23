package com.ogogc.app.utils;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtils {
	static String msgText = "This is a message body.\nHere's the second line.";
	String  to, subject = null, from = null, 
			cc = null, bcc = null, url = null;
		static String mailhost = "smtp.163.com";
		static String mailer = "smtpsend";
		String file = null;
		String protocol = null, host = null;
		static String user = "xp0375@163.com";
		static String password = "xpadmin0";
		String record = null;	// name of folder in which to record mail
		boolean debug = false;
		boolean verbose = false;
		boolean auth = false;
		static String prot = "smtp";
	public static void sendMail(String content,String username,String userid){
		sendEmail(content,username,userid);
	}
	public static void sendEmail(String content,String username,String userid){
		try {
			Properties prop = new Properties();
	          prop.setProperty("mail.host", "smtp.163.com");
	          prop.setProperty("mail.transport.protocol", "smtp");
	          prop.setProperty("mail.smtp.auth", "true");
	          //使用JavaMail发送邮件的5个步骤
	          //1、创建session
	          Session session = Session.getInstance(prop);
	          //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	          session.setDebug(true);
	          //2、通过session得到transport对象
	          Transport ts = session.getTransport();
	          //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
	          ts.connect("smtp.163.com", "xp0375", "xpadmin0");
	          //4、创建邮件
	          Message message = createSimpleMail(session,content,username,userid);
	          //5、发送邮件
	          ts.sendMessage(message, message.getAllRecipients());
	          ts.close();
		} catch (Exception e) {
			// TODO: handle excetion
		}
		 
	}
	 public static MimeMessage createSimpleMail(Session session,String content,String username,String userid)
	              throws Exception {
	          //创建邮件对象
	          MimeMessage message = new MimeMessage(session);
	          //指明邮件的发件人
	         message.setFrom(new InternetAddress("xp0375@163.com"));
	          //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	          message.setRecipient(Message.RecipientType.TO, new InternetAddress("xp0375@163.com"));
	          //邮件的标题
	          message.setSubject("用户反馈！");
	          //邮件的文本内容
	          message.setContent("用户反馈！<br>内容："+content+"<br>"+"用户名："+username+"<br>"+"用户ID："+userid, "text/html;charset=UTF-8");
	          //返回创建好的邮件对象
	          return message;
	      }
}
