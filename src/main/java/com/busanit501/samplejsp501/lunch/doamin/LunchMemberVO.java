package com.busanit501.samplejsp501.lunch.doamin;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class LunchMemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;

}
