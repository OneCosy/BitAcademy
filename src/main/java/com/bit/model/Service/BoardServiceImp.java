package com.bit.model.Service;

import com.bit.model.Dao.BoardDao;
import com.bit.model.Dao.BoardDaoImp;
import com.bit.vo.BoardVO;
import com.bit.vo.MemberVO;

import java.util.HashMap;
import java.util.List;

public class BoardServiceImp implements BoardService {
    static BoardService boardService = new BoardServiceImp();

    public static BoardService getBoardService() {
        return boardService;
    }

    @Override
    public void insertMember(MemberVO vo) {
        BoardDaoImp.getBoardDao().insertMember(vo);
    }

    @Override
    public String getIdCheck(String id) {
        return BoardDaoImp.getBoardDao().getIdCheck(id);
    }

    @Override
    public List<BoardVO> selectAll() {
        return BoardDaoImp.getBoardDao().selectAll();
    }

    @Override
    public int selectTotal(HashMap<String, Object> map) {
        return BoardDaoImp.getBoardDao().selectTotal(map);
    }

    @Override
    public List<BoardVO> selectPage(HashMap<String, Object> map) {
        return BoardDaoImp.getBoardDao().selectPage(map);
    }

    @Override
    public void insertBoard(BoardVO vo) {
        BoardDaoImp.getBoardDao().insertBoard(vo);
    }

    @Override
    public void updateHit(int no) {
        BoardDaoImp.getBoardDao().updateHit(no);
    }

    @Override
    public Object selectInfo(int no) {
        return BoardDaoImp.getBoardDao().selectInfo(no);
    }

    @Override
    public void deleteBoard(int no) {
        BoardDaoImp.getBoardDao().deleteBoard(no);
    }
}
