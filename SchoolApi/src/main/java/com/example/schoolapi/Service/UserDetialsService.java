package com.example.schoolapi.Service;

import com.example.schoolapi.Api.ApiException;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetialsService implements org.springframework.security.core.userdetails.UserDetailsService {

private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=authRepository.findByUserNameOrEmail(username);
        if (user==null){
            throw new ApiException("Wrong username or password");
        }
        return user;
    }


}
