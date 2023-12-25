    package com.example.careregistrrysprinboot.ExceptionHandler;



    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.core.authority.AuthorityUtils;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
    import org.springframework.stereotype.Component;


    import java.io.IOException;
    import java.util.List;
    import java.util.Optional;
    import java.util.Set;
    import org.springframework.security.core.Authentication;

    @Component
    public class YourCustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Authentication authentication) throws IOException, jakarta.servlet.ServletException {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            System.out.println(roles);
            if (roles.contains("ROLE_[CAREGIVER]")) {
                response.sendRedirect("/v1/Agent_YYasd");
            } else if (roles.contains("ROLE_[CUSTOMER]")) {
                response.sendRedirect("/v2/recipient");
            } else if (roles.contains("ROLE_[TEAM]")) {
                response.sendRedirect("/v3/teamdashboard");
            } else {
                response.sendRedirect("/error");
            }

        }
    }

