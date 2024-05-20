package com.busanit501.connectTest;

import com.busanit501.samplejsp501.todo.dao.MenuDAO;
import com.busanit501.samplejsp501.todo.domain.MenuVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class MenuTest {
    private MenuDAO menuDAO;

    //각 단위 테스트가 실행되기전에 먼저 실행되는 어노테이션
    //todoDAO 할당 함.
    @BeforeEach
    public void ready(){
        menuDAO = new MenuDAO();
    }
    @Test
    public void getSelectAll() throws Exception {
        List<MenuVO> samples = menuDAO.selectAll();
        System.out.println("samples : " + samples);
        //향상된 for 목록에서 요소를 하나씩 뽑아서 출력함.
        //smaples 목록에서 하나 요소를 꺼내서 vo에 담고 그리고 개별 요소 출력하기
        samples.forEach(vo->System.out.println("각각 출력해보기 : "+vo));
    }
    @Test
    public void selectOne() throws Exception {
        MenuVO menuVO = menuDAO.selectOne(3L);
        System.out.println("menuVO : " + menuVO);


    }

    @Test
    public void insert() throws Exception{
        MenuVO menuVO1 = MenuVO.builder()
                .MenuTitle("칼국수")
//                .dueDate(LocalDate.now())
                .MenuRegDate(LocalDate.of(2024,5,20))
                .build();
        menuDAO.insert(menuVO1);
    }
    @Test
    public void delete() throws Exception{
        //기능 확인 해보기
        menuDAO.delete(7L);

    }
    @Test
    public void update() throws Exception {
        MenuVO menuVO1 = MenuVO.builder()
                .MenuNo(3L)
                .MenuTitle("비빔면")
                .MenuRegDate(LocalDate.now())
                .build();

        menuDAO.update(menuVO1);
    }
}
