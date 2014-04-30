package tk.blizz.jms.business;

import tk.blizz.jms.model.SmsMessage;

public interface SmsManager {
	SmsMessage getSmsMessageById(Long id);

	void sendSmsMessageAndSave(String content);
}
