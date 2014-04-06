package tk.blizz.jms.handler.impl;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import tk.blizz.jms.handler.SmsMessageHandler;

public class SmsMessageHandlerJmsImpl implements SmsMessageHandler {
	// TODO for test only, PLZ inject with spring
	@Resource(mappedName="queue/A")
	private Destination destination;

	@Resource()
	private ConnectionFactory connectionFactory;

	@Override
	public void sendSmsMessage(String content) {
		Connection connection = null;
	    Session session = null;
	    MessageProducer producer = null;
	    try {
	      connection = connectionFactory.createConnection();
	      session = connection.createSession(true, Session.SESSION_TRANSACTED);
	      producer = session.createProducer(destination);
	      TextMessage message = session.createTextMessage();
	      message.setJMSType("foo");
	      message.setText(content);
	      producer.send(message);
	    } catch (JMSException e) {
			throw new SmsMessageHandlerException(e);
		} finally {
	      if (producer != null) try { producer.close(); } catch (Exception ignore) { }
	      if (session != null) try { session.close(); } catch (Exception ignore) { }
	      if (connection != null) try { connection.close(); } catch (Exception ignore) { }
	    }

	}

	public static class SmsMessageHandlerException extends RuntimeException {
		private static final long serialVersionUID = 8490348772042655849L;

		public SmsMessageHandlerException() {
			super();
		}

		public SmsMessageHandlerException(String message) {
			super(message);
		}

		public SmsMessageHandlerException(String message, Throwable cause) {
			super(message, cause);
		}

		public SmsMessageHandlerException(Throwable cause) {
			super(cause);
		}
	}
}
