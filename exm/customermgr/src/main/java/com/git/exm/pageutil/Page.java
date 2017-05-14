package com.git.exm.pageutil;

import java.util.Collections;
import java.util.List;

public class Page<E> {

    private int pageShow = 2;
    private int totalPage;
    private int totalcCount;
    private int start;
    private int nowPage;
    private List<E> result = Collections.emptyList();

    public int getStart(){
        start = (getNowPage()-1)*getPageShow();
        if(start <0){
            start = 0;
        }
        return start;
    }

    public int getPageShow() {
        return pageShow;
    }

    public void setPageShow(int pageShow) {
        this.pageShow = pageShow;
    }

    public int getTotalPage() {
        return (int)Math.ceil(totalcCount*1.0/pageShow);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalcCount() {
        return totalcCount;
    }

    public void setTotalcCount(int totalcCount) {
        this.totalcCount = totalcCount;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNowPage() {
        if(nowPage<=0){
            nowPage = 1;
        }
        if(nowPage>getTotalPage()){
            nowPage = getTotalPage();
        }
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }
}