package com.realtime.seatspringbootbackend.src.store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DayEnum {
    MON("MON"),
    TUE("TUE"),
    WED("WED"),
    THU("THU"),
    FRI("FRI"),
    SAT("SAT"),
    SUN("SUN");

    private final String value;
}
