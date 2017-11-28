package com.zyjr.zyjroa.common.constant.state;

/**
 * 管理员的状态
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午9:54:13
 */
public enum ManagerStatus {

    OK(1, "启用"), FREEZED(2, "冻结"), DELETED(3, "被删除");
	//ONTRY(1, "试用期员工"), PRACTICE(2, "实习期员工"), OFFICIAL(3, "正式员工"),LEAVE(4, "离职");

    int code;
    String message;

    ManagerStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return "";
        } else {
            for (ManagerStatus ms : ManagerStatus.values()) {
                if (ms.getCode() == value) {
                    return ms.getMessage();
                }
            }
            return "";
        }
    }
}
