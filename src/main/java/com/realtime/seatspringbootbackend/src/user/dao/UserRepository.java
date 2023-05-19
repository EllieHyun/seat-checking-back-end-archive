package com.realtime.seatspringbootbackend.src.user.dao;

import static com.realtime.seatspringbootbackend.common.entity.BaseEntity.State;

import com.realtime.seatspringbootbackend.src.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Boolean existsByNicknameAndState(String nickname, State state);

    Boolean existsByLoginIdAndState(String loginId, State state);
}
