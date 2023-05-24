package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;
import com.bit.vo.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class ListController implements ProcessController {
    private String path;
    private boolean redirect;

    public ListController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        List<BoardVO> table = (List<BoardVO>) request.getSession().getAttribute("list");

        if (table != null) {
            for (BoardVO board : table) {
                // 각각의 board 객체에 접근하여 원하는 정보를 확인할 수 있습니다.
                // 예를 들어, board.getId(), board.getTitle() 등의 메서드를 사용하여 정보에 접근할 수 있습니다.
                System.out.println("ID: " + board.getNo());
                System.out.println("Title: " + board.getBrd_category());
                System.out.println("Writer: " + board.getBrd_writer());
                System.out.println("Pass: " + board.getBrd_pass());
                System.out.println("Subject: " + board.getBrd_subject());
                System.out.println("Content: " + board.getBrd_content());
                System.out.println("File: " + board.getBrd_file());
                System.out.println("ReadCount: " + board.getBrd_readcount());
                System.out.println("Date: " + board.getBrd_date());
                // 원하는 정보를 활용하여 추가적인 작업을 수행할 수 있습니다.
            }
        } else {
            System.out.println("table이 비어 있습니다.");
        }

        request.setAttribute("list", table);

        return new ForwardController(path, redirect);
    }
}
