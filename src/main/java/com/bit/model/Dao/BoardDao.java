package com.bit.model.Dao;


import com.bit.vo.BoardVO;
import com.bit.vo.MemberVO;

import java.util.HashMap;
import java.util.List;

public interface BoardDao {
    public void insertMember(MemberVO vo);
    public String getIdCheck(String id);

    public List<BoardVO> selectAll();

    public int selectTotal(HashMap<String, Object> map);

    public List<BoardVO> selectPage(HashMap<String, Object> map);

    public void insertBoard(BoardVO vo);

    public void updateHit(int no);

    public Object selectInfo(int no);
    public void deleteBoard(int no);
}
