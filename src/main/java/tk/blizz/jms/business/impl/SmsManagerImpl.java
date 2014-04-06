package tk.blizz.jms.business.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import tk.blizz.jms.business.SmsManager;
import tk.blizz.jms.dao.SmsMessageDao;
import tk.blizz.jms.handler.SmsMessageHandler;
import tk.blizz.jms.model.SmsMessage;

public class SmsManagerImpl implements SmsManager {
	@Resource
	private SmsMessageDao smsMessageDao;

	@Resource
	private SmsMessageHandler smsMessageHandler;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void sendSmsMessageAndSave(String content) {
		smsMessageHandler.sendSmsMessage(content);

		SmsMessage smsMessage = new SmsMessage();
		smsMessage.setContent(content);

		smsMessageDao.saveSmsMessage(smsMessage);
	}

}
