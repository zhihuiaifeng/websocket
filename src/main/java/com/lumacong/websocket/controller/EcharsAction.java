package com.lumacong.websocket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lumacong.websocket.vo.Echars;

@Controller
public class EcharsAction {

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

	@RequestMapping("Echars")
	public String echarts4(Model model) {
		return "Echars";
	}
}
