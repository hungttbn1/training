package io.fruitbase.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class AccessFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

//	private TokenService accessTokenService;
//
//	public AccessFilter(TokenService accessTokenService) {
//		super();
//		this.accessTokenService = accessTokenService;
//	}
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res,
//			FilterChain chain) throws IOException, ServletException {
//
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) res;
//
//		String accessToken = request.getParameter(ApiConst.AUTH_ACCESS_TOKEN);
//
//		if (!accessTokenService.isValidAccessToken(accessToken)) {
//
//			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			ServletOutputStream sos = response.getOutputStream();
//			sos.print(new Gson().toJson(ErrorInfo.ACCESS_TOKEN_INVALID));
//			sos.close();
//			return;
//
//		}
//
//		chain.doFilter(request, response);
//
//	}

}
