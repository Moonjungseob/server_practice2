package com.busanit501.samplejsp501.lunch.doamin;

import lombok.*;

import java.time.LocalDate;
@Getter
@Builder
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

public class MenuVO {
    private Long menuNo;
    private String menuTitle;
    private LocalDate menuRegDate;
}
