package com.busanit501.samplejsp501.lunch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MenuDTO {
    private Long menuNo;
    private String menuTitle;
    private LocalDate menuRegDate;

}