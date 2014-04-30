package tk.blizz.jms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="SMS_MESSAGE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class SmsMessage implements Serializable {
	private static final long serialVersionUID = -5766568652595121691L;

	private Long id;
	private String content;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SMS_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="SMS_CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("%s@%d:[id=%d, content=%s]", this.getClass().getName(), this.hashCode(), this.id, this.content);
	}
}
