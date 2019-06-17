package com.lumacong.websocket.timer;

import com.alibaba.fastjson.JSON;
import com.lumacong.websocket.server.ResourceSocketServer;
import com.lumacong.websocket.server.WebSocketServer;
import com.lumacong.websocket.vo.Echars;
import com.lumacong.websocket.vo.Resource;
import com.sun.management.OperatingSystemMXBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@EnableScheduling
public class TimeTask {
    static Log log = LogFactory.getLog(TimeTask.class);
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    @Scheduled(cron = "0/1 * * * * ?") // 每分钟执行一次
    public void test() {
        System.err.println("*********   定时任务执行   **************");
        CopyOnWriteArraySet<WebSocketServer> webSocketSet = WebSocketServer.getWebSocketSet();
        webSocketSet.forEach(c -> {
            try {
                List<Echars> list = new ArrayList<Echars>();
                list.add(new Echars("帽子", (int) (1 + Math.random() * (10 - 1 + 1))));
                list.add(new Echars("鞋子", (int) (1 + Math.random() * (20 - 1 + 1))));
                list.add(new Echars("毛衣", (int) (1 + Math.random() * (30 - 1 + 1))));
                list.add(new Echars("羽绒服", (int) (1 + Math.random() * (40 - 1 + 1))));
                list.add(new Echars("羊毛衫", (int) (1 + Math.random() * (50 - 1 + 1))));
                c.sendMessage(JSON.toJSONString(list));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        CopyOnWriteArraySet<ResourceSocketServer> resourceSocketServer = ResourceSocketServer.getWebSocketSet();
        resourceSocketServer.forEach(c -> {
            try {
                double cpuLoad = osmxb.getSystemCpuLoad();
                int percentCpuLoad = (int) (cpuLoad * 100);

                double totalvirtualMemory = osmxb.getTotalPhysicalMemorySize();
                double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
                double value = freePhysicalMemorySize / totalvirtualMemory;
                int percentMemoryLoad = (int) ((1 - value) * 100);

                List<Resource> list = new ArrayList<Resource>();
                list.add(new Resource(sdf.format(new Date()), percentCpuLoad, percentMemoryLoad));
                c.sendMessage(JSON.toJSONString(list));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.err.println("/n 定时任务完成.......");
    }
}
