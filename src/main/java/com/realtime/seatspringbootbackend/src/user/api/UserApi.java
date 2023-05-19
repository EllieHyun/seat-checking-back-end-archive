package com.realtime.seatspringbootbackend.src.user.api;

import com.realtime.seatspringbootbackend.src.user.dto.request.UserSignUpReq;
import com.realtime.seatspringbootbackend.src.user.dto.request.ValidateLoginIdReq;
import com.realtime.seatspringbootbackend.src.user.dto.request.ValidateNicknameReq;
import com.realtime.seatspringbootbackend.src.user.dto.response.ValidateUserInformationRes;
import com.realtime.seatspringbootbackend.src.user.service.UserSignUpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "01. [User]")
@RequestMapping("/v1/users")
@Validated
@RequiredArgsConstructor
public class UserApi {
    private final UserSignUpService userSignUpService;

    @Operation(summary = "아이디 검증 및 중복 확인")
    @PostMapping("/validate/login-id")
    public ValidateUserInformationRes validateLoginId(
            @Valid @RequestBody ValidateLoginIdReq validateLoginIdReq) {
        return userSignUpService.isLoginIdDuplicated(validateLoginIdReq.getLoginId());
    }

    @Operation(summary = "닉네임 검증 및 중복 확인")
    @PostMapping("/validate/nickname")
    public ValidateUserInformationRes validateNickname(
            @Valid @RequestBody ValidateNicknameReq validateNicknameReq) {
        return userSignUpService.isNicknameDuplicated(validateNicknameReq.getNickname());
    }

    @Operation(summary = "일반 사용자 회원가입")
    @PostMapping("/sign-up")
    public String userSignUp(@Valid @RequestBody UserSignUpReq userSignUpReq) {
        System.out.println(userSignUpReq.getNickname());
        userSignUpService.userSignUp(userSignUpReq);

        return "회원가입이 완료됐습니다.";
    }
}
