package com.busanit501.samplejsp501.lunch.service;

import com.busanit501.samplejsp501.lunch.dao.LunchMemberDAO;
import com.busanit501.samplejsp501.lunch.doamin.LunchMemberVO;
import com.busanit501.samplejsp501.lunch.dto.LunchMemberDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum LunchMemberService {
    INSTANCE;
    private LunchMemberDAO lunchmemberDAO;
    private ModelMapper modelMapper;

    LunchMemberService() {
        lunchmemberDAO = new LunchMemberDAO();
        // 기본 생성자 호출해서, 할당하기. 0x100
        modelMapper = MapperUtil.INSTANCE.get();
    }
    public LunchMemberDTO getOneMember(String mid, String mpw) throws Exception {
        LunchMemberVO sample = lunchmemberDAO.getWithPasswordMember(mid, mpw);
//        log.info("TodoService , 확인1, sample : " + sample);
        LunchMemberDTO lunchmemberDTO = modelMapper.map(sample,LunchMemberDTO.class);
        return lunchmemberDTO;
    }
    public void updateUUID(String mid, String uuid) throws Exception {
        lunchmemberDAO.updateUUID(mid, uuid);
    }
    public LunchMemberDTO selectUUID(String uuid) throws Exception {
        LunchMemberVO lunchmemberVO = lunchmemberDAO.selectUUID(uuid);
        LunchMemberDTO lunchmemberDTO = modelMapper.map(lunchmemberVO,LunchMemberDTO.class);
        return lunchmemberDTO;
    }
    public void insertMember(LunchMemberDTO lunchmemberDTO) throws Exception {
        LunchMemberVO lunchmemberVO = modelMapper.map(lunchmemberDTO,LunchMemberVO.class);
        lunchmemberDAO.insertMember(lunchmemberVO);
    }

}
