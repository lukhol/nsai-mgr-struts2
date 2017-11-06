package com.politechnika.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.politechnika.dao.UserDAO;
import com.politechnika.models.User;
import com.politechnika.models.UserRole;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		System.out.println("UserDetailsService");
		User user = userService.findByLogin(arg0);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}
	
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
			true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles){
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
		return result;
	}
}
