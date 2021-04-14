package com.kuliah.main.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kuliah.main.entity.Mahasiswa;

public class CustomUserDetail implements UserDetails {
	 
    private Mahasiswa user;
     
    public CustomUserDetail(Mahasiswa user) {
        this.user = user;
    }
 
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	final List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
     //   if (enabled) {
          /*  if (this.getUser().isAdmin()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }*/
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    //    }
            return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getNim();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    public String getFullName() {
        return user.getNamaMahasiswa();
    }
 
}
