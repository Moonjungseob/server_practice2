package com.busanit501.samplejsp501.todo.domain;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;

}
