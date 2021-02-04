package top.safer.springbootdemo.param;

import lombok.Data;

/**
 * user 的查询条件参数类继承分页基础类
 * @author sakura
 */
@Data
public class UserParam extends PageParam {
    private String userName;
    private String userSex;
}
