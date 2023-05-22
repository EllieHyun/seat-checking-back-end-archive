package com.realtime.seatspringbootbackend.src.store.dto.request;

import com.realtime.seatspringbootbackend.src.store.domain.DayEnum;
import com.realtime.seatspringbootbackend.src.store.domain.KindEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@NoArgsConstructor
@Getter
public class StoreUpdateRequestDto {
    @NotBlank(message = "가게 이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "가게 설명을 입력해주세요.")
    private String introduction;

    @NotBlank(message = "가게 위치를 입력해주세요.")
    private String location;

    @Positive(message = "층수는 1 이상의 수로 입력해주세요.")
    private int totalFloor;

    @NotNull(message = "가게 종류를 선택해주세요.")
    private KindEnum kind;

    private List<DayEnum> dayOff;
    private String monBusinessHours;
    private String tueBusinessHours;
    private String wedBusinessHours;
    private String thuBusinessHours;
    private String friBusinessHours;
    private String satBusinessHours;
    private String sunBusinessHours;
    private String breakTime;
    private String useTimeLimit;
}
