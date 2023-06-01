package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoController implements ProcessController {
    private String path;
    private boolean redirect;

    public InfoController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        int no = Integer.parseInt(request.getParameter("no"));

        request.setAttribute("info", BoardServiceImp.getBoardService().selectInfo(no));

        return new ForwardController(path, redirect);
    }
}
