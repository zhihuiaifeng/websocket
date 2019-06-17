package com.lumacong.websocket.controller;

import com.alibaba.fastjson.JSON;
import com.lumacong.websocket.vo.Cpu;
import com.lumacong.websocket.vo.Echars;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EcharsAction {

    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("EcharsShow")
    @ResponseBody
    public String findById(Model model) {
        List<Echars> list = new ArrayList<Echars>();
        list.add(new Echars("帽子", 50));
        list.add(new Echars("鞋子", 126));
        list.add(new Echars("毛衣", 75));
        list.add(new Echars("羽绒服", 201));
        list.add(new Echars("羊毛衫", 172));
        return JSON.toJSONString(list);
    }

    @RequestMapping("CpuShow")
    @ResponseBody
    public String cpuShow(Model model) {
        double cpuLoad = osmxb.getSystemCpuLoad();
        int percentCpuLoad = (int) (cpuLoad * 100);
        List<Cpu> list = new ArrayList<Cpu>();
        list.add(new Cpu(sdf.format(new Date()), percentCpuLoad));
        return JSON.toJSONString(list);
    }

    @RequestMapping("Echars")
    public String echarts4(Model model) {
        return "Echars";
    }

}
