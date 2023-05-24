package com.bit.model.Dao;

import com.bit.conf.SqlSessionManager;
import com.bit.vo.BoardVO;
import com.bit.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

public class BoardDaoImp implements BoardDao {
    private static BoardDao boardDao = new BoardDaoImp();
    private SqlSessionFactory sessionFactory = SqlSessionManager.getSqlSessionFactory();

    public static BoardDao getBoardDao() {
        return boardDao;
    }
    @Override
    public void insertMember(MemberVO vo) {
        SqlSession sqlSession = sessionFactory.openSession();

        try {
            sqlSession.insert("com.bit.vo.insertMember", vo);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public String getIdCheck(String id) {
        SqlSession sqlSession = sessionFactory.openSession();
        String correctPass = null;

        try {
            correctPass = sqlSession.selectOne("com.bit.vo.getIdCheck", id);
            System.out.println(correctPass);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return correctPass;
    }

    @Override
    public List<BoardVO> selectAll() {

        SqlSession sqlSession = sessionFactory.openSession();
        List<BoardVO> list = null;

        try {
            list = sqlSession.selectList("com.bit.vo.selectBoard");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public int selectTotal(HashMap<String, Object> map) {
        SqlSession sqlSession = sessionFactory.openSession();

        int total = 0;

        try {
            total = sqlSession.selectOne("com.bit.vo.selectTotal", map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return total;
    }

    @Override
    public List<BoardVO> selectPage(HashMap<String, Object> map) {
        SqlSession sqlSession = sessionFactory.openSession();

        List<BoardVO> pageList = null;

        try {
            pageList = sqlSession.selectList("com.bit.vo.selectPage", map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return pageList;
    }
}
