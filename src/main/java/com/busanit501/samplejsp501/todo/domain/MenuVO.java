package com.busanit501.samplejsp501.todo.domain;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

public class MenuVO {
    private Long MenuNo;
    private String MenuTitle;
    private LocalDate MenuRegDate;
}
