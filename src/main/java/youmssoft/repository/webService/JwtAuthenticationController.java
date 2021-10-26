package youmssoft.repository.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import youmssoft.repository.entities.JwtRequest;
import youmssoft.repository.entities.JwtResponse;
import youmssoft.repository.services.JwtUserDetailsService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
//@CrossOrigin(origins = "*")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;


    @GetMapping(value="/user")
    public HashMap<String, Object> getLogedUser(){
        SecurityContext securitycontex= SecurityContextHolder.getContext();
        //On recupere l'utilisateur connecté
        String username=securitycontex.getAuthentication().getName();

        //On récupère tous les rôles de l'utilisateur.
        List<String> roles=new ArrayList<>();
        for(GrantedAuthority ga:securitycontex.getAuthentication().getAuthorities()) {
            roles.add(ga.getAuthority().substring(5));
        }

        HashMap<String, Object> hm=new HashMap<>();
        hm.put("username", username);
        hm.put("roles", roles);

        return hm;
    }




    /*@GetMapping(value="/user")
    public HashMap<String, Object> getLogedUser(HttpSession session){
        SecurityContext securitycontex=(SecurityContext )session.getAttribute("SPRING_SECURITY_CONTEXT");
        //On recupere l'utilisateur connecté
        String username=securitycontex.getAuthentication().getName();

        //On récupère tous les rôles de l'utilisateur.
        List<String> roles=new ArrayList<>();
        for(GrantedAuthority ga:securitycontex.getAuthentication().getAuthorities()) {
            roles.add(ga.getAuthority().substring(5));
        }

        HashMap<String, Object> hm=new HashMap<>();
        hm.put("username", username);
        hm.put("roles", roles);

        return hm;
    }*/



    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
