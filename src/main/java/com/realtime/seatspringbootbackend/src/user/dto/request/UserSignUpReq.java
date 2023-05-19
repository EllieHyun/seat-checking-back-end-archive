package com.realtime.seatspringbootbackend.src.user.dto.request;

import com.realtime.seatspringbootbackend.src.user.domain.UserSex;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserSignUpReq {
    private String loginId;
    private String loginPw;
    private String nickname;
    private int age;
    private UserSex sex;
    private Boolean consentToMarketing;
    private Boolean consentToTermsOfUser;
}
