package com.realtime.seatspringbootbackend.src.user.dao;

import com.realtime.seatspringbootbackend.src.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserAdaptor {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
