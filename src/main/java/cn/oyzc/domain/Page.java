package cn.oyzc.domain;

/**
 * @ClassName Page
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/3 上午9:21
 * @Version 1.0
 */
public class Page {

    // 总数
    private int count;

    // 总页数
    private int countPage;

    // 当前页
    private int currentPage;

    // 限制查询条数
    private int limit;

    // 偏移量
    private int offset;

    public int getCount() {
        return count;
    }

    public Page() {
    }

    public Page(int currentPage, int limit) {
        this.currentPage = currentPage;
        this.limit = limit;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
