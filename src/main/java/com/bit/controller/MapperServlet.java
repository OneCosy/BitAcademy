package com.bit.controller;

public class MapperServlet {
    public static ProcessController getMapper(String cmd) {
        ProcessController processController = null;

        if (cmd.equalsIgnoreCase("join")) {
            processController = new JoinController("board/signin.jsp", false);
        }

        if (cmd.equalsIgnoreCase("login")) {
            processController = new LoginController("", false);
        }

        if (cmd.equalsIgnoreCase("paging")) {
            processController = new PagingController("list.do?cmd=list", false);
        }

        if (cmd.equalsIgnoreCase("list")) {
            processController = new ListController("board/board.jsp", false);
        }

        return processController;
    }
}
