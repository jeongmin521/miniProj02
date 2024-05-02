package org.kosa.mini.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO implements UserDetails {
	
	private String member_id;
	private String member_pwd;
	private String member_pwd2;
	private String member_name;
	private String member_address;
	private String member_phone_number;
	private String member_gender;
	private String member_roles;
	private String member_account_expired; 
	private String member_account_locked;
	private int    member_login_count;
	private LocalDateTime member_last_login_time;
	
	public boolean isEqualsPwd(String pwd) {
		return this.member_pwd.equals(pwd);		
	}
	
	public void hashPassword(PasswordEncoder passwordEncoder) {
		this.member_pwd = passwordEncoder.encode(this.member_pwd);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collections = new ArrayList<GrantedAuthority>();
		
		if (member_roles != null) {
			Arrays.stream(member_roles.split(",")).forEach(role -> collections.add(new SimpleGrantedAuthority("ROLE_" + role.trim())));
		}
		
		return collections;
	}

	@Override
	public String getPassword() {
		return member_pwd;
	}

	@Override
	public String getUsername() {
		return member_id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return "N".equalsIgnoreCase(member_account_expired);
	}

	@Override
	public boolean isAccountNonLocked() {
		return "N".equalsIgnoreCase(member_account_locked);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}