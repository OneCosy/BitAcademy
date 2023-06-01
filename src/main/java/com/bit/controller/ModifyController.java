package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyController implements ProcessController {
    private String path;
    private boolean redirect;

    public ModifyController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
