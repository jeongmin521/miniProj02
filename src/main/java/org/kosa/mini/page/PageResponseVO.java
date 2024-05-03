package org.kosa.mini.page;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageResponseVO<E> {
	
    private int pageNo;//페이지번호
    private int size;  //페이지의 건수  
    private int total; //전체건수 

    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> list;

    public static <E> PageResponseVO<E> withAll(List<E> list, int total, int pageNo, int size){

    	PageResponseVO pageResponseVO = new PageResponseVO<E>();

    	pageResponseVO.pageNo = pageNo;
    	pageResponseVO.size = size;

    	pageResponseVO.total = total;
    	pageResponseVO.list = list;

    	pageResponseVO.end = (int)(Math.ceil(pageResponseVO.pageNo / 10.0 )) * 10;

    	pageResponseVO.start = pageResponseVO.end - 9;

    	int last = (int)(Math.ceil((total/(double)size)));

    	pageResponseVO.end = pageResponseVO.end > last ? last: pageResponseVO.end;

    	pageResponseVO.prev = pageResponseVO.start > 1;

    	pageResponseVO.next = total > pageResponseVO.end * pageResponseVO.size;

    	return pageResponseVO;
    	}
    }