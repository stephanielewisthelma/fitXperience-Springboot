package com.example.fitXperience.Security.User;


import com.example.fitXperience.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

//        map each role name
        user.getRoles().forEach(roles ->
                authorities.add(new SimpleGrantedAuthority(roles.getName())));

//      map each permission name (e.g MANAGE_USERS)
        user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(perm -> new SimpleGrantedAuthority(perm.getName()))
                .forEach(authorities::add);

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    @Override
//    public boolean isAccountNonLocked() {
//        return user.getStatus() != UserStatus.LOCKED;
//    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
//
//    @Override
//    public boolean isEnabled() {
//        return user.getStatus() == UserStatus.ACTIVE;
//    }
}
