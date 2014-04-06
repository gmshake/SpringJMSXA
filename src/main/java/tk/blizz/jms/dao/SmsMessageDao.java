package tk.blizz.jms.dao;

import tk.blizz.jms.model.SmsMessage;

public interface SmsMessageDao {
	SmsMessage getSmsMessageById(Long id);

	void saveSmsMessage(SmsMessage smsMessage);
}
