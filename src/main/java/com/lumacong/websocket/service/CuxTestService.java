/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestService
 * Author:   Administrator
 * Date:     2019/6/17 17:12
 * Description: TestService
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lumacong.websocket.service;

import com.lumacong.websocket.vo.CuxTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈TestService〉
 *
 * @author Administrator
 * @create 2019/6/17
 * @since 1.0.0
 */
@Service
public class CuxTestService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List getList() {

        String sql = "select TD1,TD2,TD3,TD4,TD5 from cux_test_cong";
        return (List) jdbcTemplate.query(sql, new RowMapper() {

            public CuxTest mapRow(ResultSet rs, int rowNum) throws SQLException {
                CuxTest cuxTest = new CuxTest();
                cuxTest.setTD1("TD1");
                cuxTest.setTD2("TD2");
                cuxTest.setTD3("TD3");
                cuxTest.setTD4("TD4");
                cuxTest.setTD5("TD5");

                return cuxTest;
            }

        });
    }
}