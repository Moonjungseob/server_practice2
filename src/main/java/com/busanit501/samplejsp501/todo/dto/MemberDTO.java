package com.busanit501.samplejsp501.todo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
