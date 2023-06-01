package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements ProcessController {
    private String path;
    private boolean redirect;

    public DeleteController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        int no = Integer.parseInt(request.getParameter("no"));
        System.out.println("no = " + no);

        BoardServiceImp.getBoardService().deleteBoard(no);

        return new ForwardController(path, redirect);
    }
}
