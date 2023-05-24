package com.bit.vo;

public class PageVO {
    private int pageScale;
    private int currentPage;
    private int totalRow;
    private int totalPage;
    private int start;
    private int end;
    private int currentBlock;
    private int startPage;
    private int endPage;

    public PageVO() {
    }

    public PageVO(int pageScale, int currentPage, int totalRow, int totalPage, int start, int end, int currentBlock, int startPage, int endPage) {
        this.pageScale = pageScale;
        this.currentPage = currentPage;
        this.totalRow = totalRow;
        this.totalPage = totalPage;
        this.start = start;
        this.end = end;
        this.currentBlock = currentBlock;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public int getPageScale() {
        return pageScale;
    }

    public void setPageScale(int pageScale) {
        this.pageScale = pageScale;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(int currentBlock) {
        this.currentBlock = currentBlock;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
