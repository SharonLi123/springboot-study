package top.safer.springbootdemo.param;

import lombok.Data;

/**
 * 分页的基础类
 * @author sakura
 */
@Data
public class PageParam {

    private int beginLine;
    private Integer pageSize=3;
    private Integer currentPage=0;

    //自动计算起始行
    public int getBeginLine() {
        return pageSize*currentPage;
    }
}
