package com.yoondev.backoffice.utils;

import javax.servlet.http.HttpServletRequest;

public class Paging {
    private final Integer showContentSize;
    private final Integer contentSize;
    private Integer movePage;
    private final Integer pageListSize;
    private final String requestUri;

    public Paging(int showContentSize, int contentSize, int movePage, int pageListSize, String requestUri){
        this.showContentSize = showContentSize;
        this.contentSize = contentSize;
        this.movePage = movePage;
        this.pageListSize = pageListSize;
        this.requestUri = requestUri;
    }

    public String makePagingHTML(){
        Integer totalPage;
        Integer tmpPage;
        Integer pageStart;
        Integer pageEnd;

        totalPage = (int) Math.ceil(contentSize.doubleValue()/showContentSize.doubleValue());

        if(movePage < 1){
            movePage = 1;
        }

        if(movePage > totalPage){
            movePage = totalPage;
        }

        tmpPage = movePage/pageListSize;
        pageStart = (tmpPage * pageListSize) + 1;
        pageEnd = (tmpPage + 1) * pageListSize;

        if(pageEnd > totalPage){
            pageEnd = totalPage;
        }

        if(movePage % pageListSize == 0){
            pageStart = pageStart - pageListSize;
            pageEnd = (pageStart + pageListSize) - 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");

        if(pageStart > 1){
            sb.append(String.format("<li onclick='location.href=\"%s\"'><<</li>", requestUri + "?page=1"));
            sb.append(String.format("<li onclick='location.href=\"%s\"'><</li>", requestUri + "?page=" + (pageEnd - pageListSize)));
        }

        for(int i = pageStart; i <= pageEnd; i++){
            if(movePage == i){
                sb.append(String.format("<li onclick='location.href=\"%s\"' class='current'>%s</li>", requestUri + "?page=" + i, i));
            }else{
                sb.append(String.format("<li onclick='location.href=\"%s\"'>%s</li>", requestUri + "?page=" + i, i));
            }
        }

        if(pageEnd.intValue() != totalPage.intValue()){
            sb.append(String.format("<li onclick='location.href=\"%s\"'>></li>", requestUri + "?page=" + (pageStart + pageListSize)));
            sb.append(String.format("<li onclick='location.href=\"%s\"'>>></li>", requestUri + "?page=" + totalPage));
        }

        sb.append("</ul>");

        return sb.toString();
    }
}
