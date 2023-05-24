package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;
import com.bit.vo.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinController implements ProcessController {
    private String path;
    private boolean redirect;

    public JoinController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("pass");
        String name = request.getParameter("name");

        MemberVO vo = new MemberVO(id, password, name);
        System.out.println(vo);

        BoardServiceImp.getBoardService().insertMember(vo);

        path = "/board/signin.jsp";

        return new ForwardController(path, redirect);
    }
}
