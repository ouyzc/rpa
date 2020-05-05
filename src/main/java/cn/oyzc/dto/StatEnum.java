package cn.oyzc.dto;

/**
 * @ClassName StatEnum
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午11:17
 * @Version 1.0
 */
public enum StatEnum {
    SUCCESS_RESULT(200, "操作成功"),
    SUCCESS_NULL(400, "未查询到数据"),
    ERROR_RESULT(-200, "操作失败");

    private int code;

    private String msg;

    StatEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
