package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController implements ProcessController {
    private String path;
    private boolean redirect;

    public LoginController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String id = request.getParameter("id");
            String password = request.getParameter("pass");
            String correctPass = BoardServiceImp.getBoardService().getIdCheck(id);

            PrintWriter out = response.getWriter();

            if (correctPass!=null && correctPass.equals(password)) {
                request.getSession().setAttribute("id", id);

                // signin.jsp의 data에 값 전달
                out.print("T");
            } else {
                // signin.jsp의 data에 값 전달
                out.print("F");
            }
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ForwardController(null, redirect);
    }
}
