package com.busanit501.samplejsp501.lunch.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class LunchMemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
