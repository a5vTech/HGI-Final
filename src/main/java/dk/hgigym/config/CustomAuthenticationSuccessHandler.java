package dk.hgigym.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@Configuration

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_INSTRUCTOR")) {
            httpServletResponse.sendRedirect("/board");
        } else if (roles.contains("ROLE_ROLE2")) {
            httpServletResponse.sendRedirect("redirectlink");
        } else if (roles.contains("ROLE_ROLE3")) {
            httpServletResponse.sendRedirect("redirectlink");

        }else {
                httpServletResponse.sendRedirect("/logifn");
            }
        }

}
