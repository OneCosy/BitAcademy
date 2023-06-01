package com.bit.controller;

import com.bit.model.Service.BoardServiceImp;
import com.bit.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class WriteController implements ProcessController {
    private String path;
    private boolean redirect;

    public WriteController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        int size = 10*1024*1024;
        String uploadPath = "C:\\boardMyBatis\\src\\main\\webapp\\upload\\";

        try {
            MultipartRequest multi = new MultipartRequest(
                    request, // 원래 요청객체
                    uploadPath, // upload 경로
                    size,   // MaxSize
                    "UTF-8", // 한글 인코딩
                    new DefaultFileRenamePolicy()   // 똑같은 파일 업로드시 자동으로 변환
            );

            Enumeration e = multi.getFileNames();
            String file = null;

            if (e.hasMoreElements()) {
                file = (String) e.nextElement();
            } else {
                System.out.println("file 요소 업음");
            }

            BoardVO vo = new BoardVO(multi.getParameter("category"),
                    multi.getParameter("writer"),
                    multi.getParameter("pass"),
                    multi.getParameter("title"),
                    multi.getParameter("contents"),
                    multi.getOriginalFileName(file));

            System.out.println(vo);

            BoardServiceImp.getBoardService().insertBoard(vo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ForwardController(path, redirect);
    }
}
