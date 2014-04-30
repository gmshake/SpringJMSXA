package tk.blizz.jms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SMS_MESSAGE_HISTORY")
public class SmsMessageHistory extends SmsMessage {
	private static final long serialVersionUID = 5519841686634129760L;

}
