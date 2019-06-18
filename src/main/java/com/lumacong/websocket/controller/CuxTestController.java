/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CuxTestController
 * Author:   Administrator
 * Date:     2019/6/17 17:15
 * Description: CuxTestController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lumacong.websocket.controller;

import com.lumacong.websocket.service.CuxTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈CuxTestController〉
 *
 * @author Administrator
 * @create 2019/6/17
 * @since 1.0.0
 */

@RestController
public class CuxTestController {
    @Autowired
    private CuxTestService cuxTestService;

    @RequestMapping("/cuxTest")
    public List login() {
        return cuxTestService.getList();
    }

}