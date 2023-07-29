package Proyecto.Proyecto.service;


import org.springframework.security.core.userdetails.*;

public interface IUserDetailService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}