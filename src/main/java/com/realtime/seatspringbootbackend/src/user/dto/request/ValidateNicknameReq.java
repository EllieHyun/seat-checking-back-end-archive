package com.realtime.seatspringbootbackend.src.user.dto.request;

import com.realtime.seatspringbootbackend.common.annotation.Nickname;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ValidateNicknameReq {
    @Nickname(message = "")
    private String nickname;
}
