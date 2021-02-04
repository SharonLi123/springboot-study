package top.safer.springbootdemo.result;

import lombok.Data;
import top.safer.springbootdemo.param.PageParam;

import java.util.List;

/**
 * 分页封装数据
 *
 * @param <E>
 */
@Data
public class Page<E> {
    //当前页数
    private int currentPage = 1;
    //总页数
    private long totalPage;
    //总记录数
    private long totalNumber;
    //数据集
    private List<E> list;

    /**
     * @param beginLine   当前页数
     * @param totalNumber 总记录数
     * @param pageSize    页大小
     * @param list        页数据
     */
    public Page(int beginLine, long totalNumber, int pageSize, List<E> list) {
        super();
        this.currentPage = beginLine / pageSize + 1;
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageSize == 0 ? totalNumber
                / pageSize : totalNumber / pageSize + 1;
    }

    public Page(PageParam pageParam, long totalNumber, List<E> list){
        super();
        this.currentPage = pageParam.getCurrentPage();
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageParam.getPageSize() == 0 ? totalNumber
                / pageParam.getPageSize() : totalNumber / pageParam.getPageSize() + 1;
    }
}
