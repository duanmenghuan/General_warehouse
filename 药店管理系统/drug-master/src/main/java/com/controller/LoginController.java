package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Manager;
import com.service.ManagerService;
import com.service.SellService;
import com.service.StoreService;

@Controller
public class LoginController {
	@Autowired
	StoreService SS;
		
	@Autowired
	ManagerService  checkuser;
	
	@Autowired
	SellService SellS;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String logincheck(@RequestParam(value="username",required=true)String username,
			@RequestParam(value="password")String password,HttpSession hs,Map<String,Object> map){
			if(username.equals("")&&password.equals("")){
					map.put("logininfouser", "�û��������벻��Ϊ��");
					return "../../index";
			}else{
				List<Manager> ck = checkuser.QueryUserService(username);
				int N=0;
				int P=0;
				for (Manager it : ck) {
				if (username.equals(it.getUser())) {
					N = 111111;
					if (password.equals(it.getPassword())) {
						P = 111111;
						Manager login = new Manager();
						login.setUser(username);
						login.setPassword(password);
						hs.setAttribute("login", login);
						if (it.getRole() == 0){
							return "redirect:/sell_user";
						}else{
							return "redirect:/main";
						}
					} else {
						N++;
					}
				}
				}
				if(N<111111){
					map.put("logininfouser", "���û���δע�ᣬ��¼ʧ��");
					return "../../index";
                }
				if(P<111111){
        		    map.put("logininfopass", "�û����벻��ȷ����¼ʧ��");
					return "../../index";
                }
				return "../../index";
			}
		
	}
	
	@RequestMapping("/date")  //date Ч����ʾ
	public String to_date(Map<String,Object> map){
			map.put("datetips", SS.CheckStoreService());
			return "date/date";
	}
	@RequestMapping("/sellover")  //sellover 
	public String to_sellover(Map<String,Object> map){
			map.put("sellover", SellS.GetASService());
			return "sellover/sellover";
	}
	@RequestMapping("/delsellover")  //delsellover
	public String to_delsellover(String drugname,String changshang,String pihao){
			SellS.DelSelloverService(drugname,changshang,pihao);
			return "redirect:/sellover";
	}
	@RequestMapping("/storetip")  //storetip ���Ԥ��
	public String to_storetip(@RequestParam(value="c",required=false,defaultValue="1")String c,Map<String,Object> map){
		int a = 0;
		try {
			a = Integer.parseInt(c);
		} catch (Exception e) {
			a = 1;
		}
			map.put("yj", SS.YJService(a));
			return "storetip/storetip";
	}
	@RequestMapping(value="/tips")  //tips���ۼ�¼
	public String to_tips(@RequestParam(value="pn",defaultValue="1")Integer pn,
						  @RequestParam(value="selltime",defaultValue="nowtime")String selltime, Map<String,Object> map){
			map.put("alltips", SellS.GetRecordsService(pn,selltime));
			map.put("moneyinfo", SellS.GetMoneyInfo(selltime));
			map.put("today", SellS.GetTimeInfo(selltime));
			return "tips/tips";
	}
//	@RequestMapping(value="/gettips")  //tips���ۼ�¼
//	public String to_gettips(String selltime,Map<String,Object> map){
//			map.put("alltips", SellS.GetRecordsService(1,selltime));
//			return "tips/tips";
//	}
	@RequestMapping(value="/deltips",method=RequestMethod.POST)  //deltips���ۼ�¼
	public String to_deltips(String drugname,String changshang,String pihao,String selltime){
			SellS.DelRecordsService(drugname, changshang, pihao, selltime);
			return "redirect:/tips";
	}
}
