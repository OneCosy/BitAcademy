package com.bit.vo;

public class BoardVO {
    private int no;
    private String brd_category;
    private String brd_writer;
    private String brd_pass;
    private String brd_subject;
    private String brd_content;
    private String brd_file;
    private int brd_readcount;
    private String brd_date;

    public BoardVO() {
    }

    public BoardVO(int no, String brd_category, String brd_writer, String brd_pass, String brd_subject, String brd_content, String brd_file, int brd_readcount, String brd_date) {
        this.no = no;
        this.brd_category = brd_category;
        this.brd_writer = brd_writer;
        this.brd_pass = brd_pass;
        this.brd_subject = brd_subject;
        this.brd_content = brd_content;
        this.brd_file = brd_file;
        this.brd_readcount = brd_readcount;
        this.brd_date = brd_date;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getBrd_category() {
        return brd_category;
    }

    public void setBrd_category(String brd_category) {
        this.brd_category = brd_category;
    }

    public String getBrd_writer() {
        return brd_writer;
    }

    public void setBrd_writer(String brd_writer) {
        this.brd_writer = brd_writer;
    }

    public String getBrd_pass() {
        return brd_pass;
    }

    public void setBrd_pass(String brd_pass) {
        this.brd_pass = brd_pass;
    }

    public String getBrd_subject() {
        return brd_subject;
    }

    public void setBrd_subject(String brd_subject) {
        this.brd_subject = brd_subject;
    }

    public String getBrd_content() {
        return brd_content;
    }

    public void setBrd_content(String brd_content) {
        this.brd_content = brd_content;
    }

    public String getBrd_file() {
        return brd_file;
    }

    public void setBrd_file(String brd_file) {
        this.brd_file = brd_file;
    }

    public int getBrd_readcount() {
        return brd_readcount;
    }

    public void setBrd_readcount(int brd_readcount) {
        this.brd_readcount = brd_readcount;
    }

    public String getBrd_date() {
        return brd_date;
    }

    public void setBrd_date(String brd_date) {
        this.brd_date = brd_date;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "no=" + no +
                ", brd_category='" + brd_category + '\'' +
                ", brd_writer='" + brd_writer + '\'' +
                ", brd_pass='" + brd_pass + '\'' +
                ", brd_subject='" + brd_subject + '\'' +
                ", brd_content='" + brd_content + '\'' +
                ", brd_file='" + brd_file + '\'' +
                ", brd_readcount=" + brd_readcount +
                ", brd_date='" + brd_date + '\'' +
                '}';
    }
}
