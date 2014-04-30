package tk.blizz.jms.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tk.blizz.jms.business.SmsManager;
import tk.blizz.jms.model.SmsMessage;

@WebServlet(name="SmsMessageServlet", urlPatterns={"/SmsMessage.do"})
public class SmsMessageServlet extends AbstractAutowiringHttpServlet {
	private static final long serialVersionUID = 1203265115958288862L;

	private static final Log log = LogFactory.getLog(SmsMessageServlet.class);

	@Autowired
	//@Inject
	private SmsManager smsManager;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String smsId = request.getParameter("smsId");

		Long id = Long.parseLong(smsId, 10);
		SmsMessage smsMessage = smsManager.getSmsMessageById(id);
		log.info(smsMessage);
		response.getWriter().print(smsMessage.toString());

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
