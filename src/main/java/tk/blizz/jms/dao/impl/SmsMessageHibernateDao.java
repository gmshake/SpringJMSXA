package tk.blizz.jms.dao.impl;

import tk.blizz.jms.dao.SmsMessageDao;
import tk.blizz.jms.model.SmsMessage;

public class SmsMessageHibernateDao extends AbstractHibernateDao implements SmsMessageDao {

	@Override
	public SmsMessage getSmsMessageById(Long id) {
		return getEntityManager().find(SmsMessage.class, id);
	}

	@Override
	public void saveSmsMessage(SmsMessage smsMessage) {
		getEntityManager().persist(smsMessage);
	}

}
