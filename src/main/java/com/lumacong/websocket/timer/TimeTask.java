package com.lumacong.websocket.timer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lumacong.websocket.server.WebSocketServer;
import com.lumacong.websocket.vo.Echars;

@Component
@EnableScheduling
public class TimeTask {
	static Log log = LogFactory.getLog(TimeTask.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

		System.err.println("/n 定时任务完成.......");
	}
}
