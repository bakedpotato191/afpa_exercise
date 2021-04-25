package user;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private HttpServletRequest httpRequest;

	private static final String[] loginRequiredURLs = { "/create", "/edit", "/delete", "/logout" };

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		httpRequest = (HttpServletRequest) request;

		HttpSession session = httpRequest.getSession(false);

		boolean isLoggedIn = (session != null && session.getAttribute("utilisateur") != null);

		String loginURI = httpRequest.getContextPath() + "/login";
		boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

		if (isLoggedIn && (isLoginRequest || isLoginPage)) {
			// the user is already logged in and he's trying to login again
			// then forward to the homepage
			httpRequest.getRequestDispatcher("/home").forward(request, response);

		} else if (!isLoggedIn && isLoginRequired()) {
			// the user is not logged in, and the requested page requires
			// authentication, then forward to the login page
			String loginPage = "/login.jsp";
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);
		} else {
			// for other requested pages that do not require authentication
			// or the user is already logged in, continue to the destination
			chain.doFilter(request, response);
		}
	}

	private boolean isLoginRequired() {
		String requestURL = httpRequest.getRequestURL().toString();

		for (String loginRequiredURL : loginRequiredURLs) {
			if (requestURL.contains(loginRequiredURL)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
