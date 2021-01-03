package veerlethome.VeerletRest.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import veerlethome.VeerletRest.Secuirity.Jwt_util;
import veerlethome.VeerletRest.Services.CustomUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class Jwt_filter extends OncePerRequestFilter {

    @Autowired
    private Jwt_util jwt_util;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader("Authorization");
        String token = null;
        String user = null;
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            token = authHeader.substring(7);

            user = jwt_util.extractUsername(token);
        }
         if(user != null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails= customUserDetailsService.loadUserByUsername(user);
             if (jwt_util.validateToken(token, userDetails)) {

                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                 usernamePasswordAuthenticationToken
                         .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
             }

         }
     filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
