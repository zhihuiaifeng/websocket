package com.lumacong.websocket.controller;

import com.lumacong.websocket.server.WebSocketServer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    static Log log = LogFactory.getLog(WebSocketServer.class);

    @RequestMapping("/Echars")
    public String index() {
        return "Echars";
    }

    @RequestMapping("/websocketEcharts")
    public String websocketEcharts() {
        return "websocketEcharts";
    }

    @RequestMapping("websocketResourceEcharts")
    public String websocketResourceEcharts(Model model) {
        return "websocketResourceEcharts";
    }

    @RequestMapping("websocketMysqlEcharts")
    public String websocketMysqlEcharts(Model model) {
        return "websocketMysqlEcharts";
    }

}
