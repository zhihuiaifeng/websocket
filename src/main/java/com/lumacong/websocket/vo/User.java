/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   Administrator
 * Date:     2019/6/18 10:32
 * Description: User
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lumacong.websocket.vo;

/**
 * 〈一句话功能简述〉<br>
 * 〈User〉
 *
 * @author Administrator
 * @create 2019/6/18
 * @since 1.0.0
 */
public class User {
    private Long id;
    private String username;
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
