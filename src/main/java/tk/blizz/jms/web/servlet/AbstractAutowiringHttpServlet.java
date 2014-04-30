package tk.blizz.jms.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public abstract class AbstractAutowiringHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 2357023462372476011L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}
}
