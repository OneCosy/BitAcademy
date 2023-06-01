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

        if (cmd.equalsIgnoreCase("hit")) {
            processController = new HitController("board/info.jsp", false);
        }

        if (cmd.equalsIgnoreCase("write")) {
            processController = new WriteController("board/board.jsp", false);
        }

        if (cmd.equalsIgnoreCase("info")) {
            processController = new InfoController("board/info.jsp", false);
        }

        if (cmd.equalsIgnoreCase("modify")) {
            processController = new ModifyController("board/info.jsp", false);
        }

        if (cmd.equalsIgnoreCase("delete")) {
            processController = new DeleteController("board.do?cmd=paging", false);
        }

        return processController;
    }
}
