package com.adaming.projetJsf.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adaming.projetJsf.entity.Client;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClientService iClientService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		Client c = iClientService.getClientByUsername(username);
 		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new GrantedAuthorityImpl(c.getRole()));
		UserDetails resultat = new User(c.getUsername(), c.getMdpClient(), true, true, true, true, roles);
		return resultat;
	}

}
