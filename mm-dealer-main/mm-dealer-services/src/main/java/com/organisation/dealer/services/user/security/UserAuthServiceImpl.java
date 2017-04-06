package com.organisation.dealer.services.user.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.repository.UserAuthenticationRepository;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;


@Service("UserAuthService")
public class UserAuthServiceImpl implements UserDetailsService {

	protected static final Logger LOG_R = Logger.getLogger(UserAuthServiceImpl.class);

	@Autowired
	@Qualifier("UserAuthenticationRepository")
	private UserAuthenticationRepository repo;
	

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userID)throws UsernameNotFoundException {
		UserDetails user = null;
		try {
			MgmtUserEntity loadUserByUserName = repo.getUserByUserID(userID);
			if (loadUserByUserName != null) {
				Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
				GrantedAuthority grant = new GrantedAuthorityImpl(loadUserByUserName.getRole().name());
				authorities.add(grant);
				user = new UserDetailsImpl(loadUserByUserName.getEmail(),loadUserByUserName.getPassword(), loadUserByUserName.getMgmtUserProfileEntity().getFirstName()+loadUserByUserName.getMgmtUserProfileEntity().getLastName(),authorities);
			} else {
				throw new UsernameNotFoundException("User name not found.");
			}
		} catch (ManagmentRepositoryException e) {
			throw new UsernameNotFoundException("Exception occurred wile reading user info."); 
		}
		return user;
	}
}
