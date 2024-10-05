package com.mrgym.mrgym.Jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



import org.springframework.util.StringUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//este clase abstractca s eusa para crear filtros personalizados
// se extiende esta clase para que el filtro se ejcute olo 1 vez para el http
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final JwtService jwtService;
    private final UserDetailsService userdetailsService;

    //@Nonull se asegura que los parametros no sean nulos , y cumple con el contrato del metodo herado
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain)
            throws ServletException, IOException {
            
            //este metodo realiza todos los filtros relacionados al token que esta en el request
            //filterchange es la cadena de filtros

            final String token = getTokenFromRequest(request);

            //segunda parte para regresar el token configurar filtro
            final String username;

            if(token == null){
                filterChain.doFilter(request, response);
                return ;
            }

            username = jwtService.getUsernameFromToken(token);

            
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = userdetailsService.loadUserByUsername(username);
                
                if(jwtService.isTokenValid(token,userDetails)){
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            filterChain.doFilter(request, response);
    }

    //este metododevuelve el token
    //en el encabezado del requeste obtenemos el token
    private String getTokenFromRequest(HttpServletRequest request) {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        
        //verificar si existe el texto ene l encabezado y que comienze con Bearer
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer"))
        {
            return authHeader.substring(7);
        }
        return null;

    }

}
