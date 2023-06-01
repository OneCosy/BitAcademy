package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitController implements ProcessController {
    private String path;
    private boolean redirect;


    public HitController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        int no = Integer.parseInt(request.getParameter("no"));

        path = "info.do?cmd=info&no="+no;

        BoardServiceImp.getBoardService().updateHit(no);

        return new ForwardController(path, redirect);
    }
}
