package com.busanit501.samplejsp501.todo.domain;


import lombok.*;

import java.time.LocalDate;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
//기존 인스턴스 방법 A a new A();
//a.setTitle("제목")
//a.setTno(100L)
//a.setDueDate(new LocalDate().now());
//@Builder 기본 사용법
//TodoVo todo = TodoVO.builder()
// .멤버의 이름으로 설정한다.
// .build();
