package cn.oyzc.dto;

/**
 * @ClassName ResultData
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午11:20
 * @Version 1.0
 */
public class ResultData<T> {

    private int code;

    private T data;

    private String msg;

    private int count;

    public static <T> ResultData<T> data(StatEnum statEnum, T data, int count) {
        return new ResultData<>(statEnum, data, count);
    }

    public static <T> ResultData<T> data(String msg) {
        return new ResultData<>(StatEnum.ERROR_RESULT.getCode(), msg);
    }

    public ResultData(StatEnum statEnum, T data, int count) {
        this.code = statEnum.getCode();
        this.data = data;
        this.msg = statEnum.getMsg();
        this.count = count;
    }

    private ResultData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
