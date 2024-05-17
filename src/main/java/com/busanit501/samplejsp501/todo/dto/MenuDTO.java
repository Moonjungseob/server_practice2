package com.busanit501.samplejsp501.todo.dto;

import java.time.LocalDate;

public class MenuDTO {
    private Long MenuNo;
    private String MenuTitle;
    private LocalDate MenuRegDate;

    public Long getMenuNo() {
        return MenuNo;
    }

    public void setMenuNo(Long menuNo) {
        MenuNo = menuNo;
    }

    public String getMenuTitle() {
        return MenuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        MenuTitle = menuTitle;
    }

    public LocalDate getMenuRegDate() {
        return MenuRegDate;
    }

    public void setMenuRegDate(LocalDate menuRegDate) {
        MenuRegDate = menuRegDate;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "MenuNo=" + MenuNo +
                ", MenuTitle='" + MenuTitle + '\'' +
                ", MenuRegDate=" + MenuRegDate +
                '}';
    }
}