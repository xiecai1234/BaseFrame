package com.fingerbeat.cloud.bean;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 作者：XieCaibao
 * 时间： 2019/4/24
 * 邮箱：825302814@qq.com
 */
public class UserModel {
    /**
     * @Entity 　表明这个实体类会在数据库中生成一个与之相对应的表。
     * @Id 　对应数据表中的 Id 字段，有了解数据库的话，是一条数据的唯一标识。
     * @Property(nameInDb = “STUDENTNUM”) 　表名这个属性对应数据表中的 STUDENTNUM 字段。
     * @Property 　可以自定义字段名，注意外键不能使用该属性
     * @NotNull 　该属性值不能为空
     * @Transient 　该属性不会被存入数据库中
     * @Unique 　表名该属性在数据库中只能有唯一值
     */
    private String access_token;
    private String token_type;
    private int expires_in;

    @Id
    private Long id;
    @NotNull
    @Unique
    private String phone;
    private String username;
    private String InviteCode;
    private String email;
    private int member;
    private String card_id;
}
