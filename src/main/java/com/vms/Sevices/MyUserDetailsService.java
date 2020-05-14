/*
 * package com.vms.Sevices;
 * 
 * 
 * import java.util.Collection; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.vms.Model.Employee; import com.vms.Model.MyUserDetails; import
 * com.vms.Repository.EmployeeRepository;
 * 
 * 
 * @Service public class MyUserDetailsService implements UserDetailsService {
 * 
 * @Autowired EmployeeRepository users;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Optional<Employee> u =
 * users.findById(Integer.parseInt(username)); return
 * u.map(MyUserDetails::new).get(); }
 * 
 * }
 * 
 */