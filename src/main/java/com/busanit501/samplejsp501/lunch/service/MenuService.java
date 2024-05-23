package com.busanit501.samplejsp501.lunch.service;

import com.busanit501.samplejsp501.lunch.dao.MenuDAO;
import com.busanit501.samplejsp501.lunch.doamin.MenuVO;
import com.busanit501.samplejsp501.lunch.dto.MenuDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MenuService {
    INSTANCE;

    //준비물), 1) TodoDAO ,인스턴슨 필요
    // 2) DTO <-> VO 간에 변환기 필요, MapperUtil
    private MenuDAO menuDAO;
    private ModelMapper modelMapper;

    //TodoService, 생성자 만들기.
    MenuService() {
        menuDAO = new MenuDAO();
        // 기본 생성자 호출해서, 할당하기. 0x100
        modelMapper = MapperUtil.INSTANCE.get();
    }

   public void register2(MenuDTO menuDTO) throws Exception {
        // DTO -> VO 변환 이 필요함. , 도구 이용법.
        MenuVO menuVO = modelMapper.map(menuDTO, MenuVO.class);

        log.info("menuVO : "+ menuVO);

        // 실제 디비에도 넣기.
       menuDAO.insert(menuVO);
    }
    // 전체 조회
    public List<MenuDTO> listAll() throws Exception {

        List<MenuVO> sampleList = menuDAO.selectAll();
        log.info("MenuService , 확인1, sampleList : " + sampleList);
        List<MenuDTO> sampleDtoList = sampleList.stream()
                .map(vo -> modelMapper.map(vo,MenuDTO.class))
                .collect(Collectors.toList());
        return sampleDtoList;

    }

    // 하나 조회
    public MenuDTO getSelectOne(Long menuNo) throws Exception {
        MenuVO sample = menuDAO.selectOne(menuNo);
        MenuDTO menuDTO = modelMapper.map(sample, MenuDTO.class);
        return menuDTO;
    }

    // 수정
    public void updateTodo(MenuDTO menuDTO) throws Exception {
        MenuVO menuVO = modelMapper.map(menuDTO, MenuVO.class);
        menuDAO.update(menuVO);
    }

    // 삭제
    public void deleteTodo(Long menuNo) throws Exception {
        menuDAO.delete(menuNo);
    }




}