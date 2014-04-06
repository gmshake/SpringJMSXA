package tk.blizz.jms.business.impl;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tk.blizz.jms.business.SmsManager;

public class AMessageListener implements MessageListener {
	private static final Log log = LogFactory.getLog(AMessageListener.class);

	@Resource
	private SmsManager smsManager;

	@Resource
	private AtomicInteger counter;

	@Override
	public void onMessage(Message message) {
		if (log.isDebugEnabled())
			log.debug("redirect message: " + message + "\n to another queue");

		if (message instanceof TextMessage) {
			try {
				this.smsManager.sendSmsMessageAndSave(((TextMessage)message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("xxx");
		}

		if (this.counter != null)
			this.counter.incrementAndGet();
	}
}
