package com.amazonaws.tvm.anonymous;

import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.amazonaws.tvm.Configuration;
import com.amazonaws.tvm.TokenVendingMachineLogger;

/**
 * Servlet implementation class InitServlet
 */
public final class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger log = TokenVendingMachineLogger.getLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		if (isNull(Configuration.AWS_ACCESS_KEY_ID)) {
			throw new ServletException("AWS_ACCESS_KEY_ID is null");
		}
		if (isNull(Configuration.AWS_SECRET_KEY)) {
			throw new ServletException("AWS_SECRET_KEY is null");
		}
	}

	private boolean isNull(String str) {
		if (str == null) {
			return true;
		}

		if (str.length() <= 0) {
			return true;
		}

		return false;
	}
}
