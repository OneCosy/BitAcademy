package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;
import com.bit.vo.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class PagingController implements ProcessController {
    private String path;
    private boolean redirect;

    public PagingController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        int currentPage = 1;

        if (request.getParameter("p") != null) {
            currentPage = Integer.parseInt(request.getParameter("p"));  // 현재 페이지;
        }

//        System.out.println("currentPage = " + currentPage);


        // 단위 페이지 번호, 10 페이지씩 나오도록
        int pageScale = 10;

        int pageNum = (currentPage-1) * 10;
        String curCategory = request.getParameter("category") == null ? "SELECT" : request.getParameter("category");
        String curInputText = request.getParameter("inputText") == null ? "" : request.getParameter("inputText");

//        System.out.println(curCategory);
//        System.out.println(curInputText);

        HashMap<String, Object> pagingMap = new HashMap<>();
        pagingMap.put("pageNum", pageNum);
        pagingMap.put("curCategory", curCategory);
        pagingMap.put("curInputText", curInputText);
//        pagingMap.put("pageScale", pageScale);

//        System.out.println("pageNum = " + pageNum);
//        System.out.println("curCategory = " + curCategory);
//        System.out.println("curInputText = " + curInputText);
//        System.out.println("pageScale = " + pageScale);

        List<BoardVO> table = BoardServiceImp.getBoardService().selectPage(pagingMap);

        // 총 튜플 개수
        int totalRow = BoardServiceImp.getBoardService().selectTotal(pagingMap);
//        System.out.println("totalRow = " + totalRow);

        int totalPage = totalRow%pageScale==0 ? (totalRow/pageScale) : (totalRow/pageScale) + 1;
        totalPage = totalPage==0 ? 1 : totalPage;
//        System.out.println("totalPage = " + totalPage);

        // 현재 페이지에 따른 시작 페이지 번호
        int start = 1+(currentPage-1)*pageScale;
        int end = pageScale + (currentPage-1) * pageScale;
        int currentBlock = currentPage%pageScale==0 ? (currentPage/pageScale) : (currentPage/pageScale)+1;
        int startPage = 1+(currentBlock-1)*pageScale;
        int endPage = pageScale+(currentBlock-1)*pageScale;

        if (endPage > totalPage) {
            endPage = totalPage;
        }

//        System.out.println("start = " + start);
//        System.out.println("end = " + end);
//        System.out.println("currentBlock = " + currentBlock);
//        System.out.println("startPage = " + startPage);
//        System.out.println("endPage = " + endPage);

        request.getSession().setAttribute("list", table);
        request.getSession().setAttribute("totalPage", totalPage);
        request.getSession().setAttribute("currentPage", currentPage);
        request.getSession().setAttribute("pageScale", pageScale);
        request.getSession().setAttribute("curCategory", curCategory);
        request.getSession().setAttribute("curInput", curInputText);
        request.getSession().setAttribute("start", start);
        request.getSession().setAttribute("end", end);
        request.getSession().setAttribute("currentBlock", currentBlock);
        request.getSession().setAttribute("startPage", startPage);
        request.getSession().setAttribute("endPage", endPage);

        return new ForwardController(path, redirect);
    }
}
