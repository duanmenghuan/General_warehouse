package com.yxq.carpark.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxq.carpark.dto.CouponData;
import com.yxq.carpark.entity.Coupon;
import com.yxq.carpark.entity.Depotcard;
import com.yxq.carpark.entity.Income;
import com.yxq.carpark.entity.User;
import com.yxq.carpark.service.CouponService;
import com.yxq.carpark.service.DepotcardService;
import com.yxq.carpark.service.IncomeService;
import com.yxq.carpark.service.UserService;
import com.yxq.carpark.utils.Msg;


@Controller
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	@Autowired
	private UserService userService;
	@Autowired
	private DepotcardService depotcardService;
	
	@ResponseBody
	@RequestMapping("/index/coupon/findCouponById")
	public Msg findCouponById(@RequestParam("id") Integer id)
	{
		Coupon coupon=couponService.findCouponById(id.intValue());
		if(coupon==null)
		{
			return Msg.fail().add("va_msg", "��ѯ������ˢ��ҳ�棡");
		}
		return Msg.success().add("coupon", coupon);
	}
	@ResponseBody
	@RequestMapping("/index/coupon/deleteCoupon")
	public Msg deleteCoupon(@RequestParam("id") Integer id)
	{
		Coupon coupon=couponService.findCouponById(id.intValue());
		if(coupon==null)
		{
			return Msg.fail().add("va_msg", "ɾ��������ˢ��ҳ�棡");
		}else{
			couponService.deleteCoupon(id);
			return Msg.success().add("va_msg", "ɾ���ɹ���");
		}
	}
	
	//�����Ż�ȯ
	@ResponseBody
	@RequestMapping("/index/coupon/setCoupon")
	public Msg setCoupon(CouponData couponData)
	{
		int money=couponData.getMoney();
		int count=couponData.getCount();
		if(userService.findAllUserCount(3)<count)
		{
			return Msg.fail().add("va_msg", "�����û����������������룡");
		}
		List<User> list=userService.finAllUserByRole(3); 
		Set<User> userSet=new HashSet<User>();
		for(User user:list)
		{
			userSet.add(user);
		}
		Iterator<User> it = userSet.iterator();  
		int c=0;
		try {
			while (it.hasNext()) {  
				if(c>=count)
				{
					break;
				}
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				User user = it.next();
				Depotcard depotcard=depotcardService.findByCardid(user.getCardid());
				Coupon coupon=new Coupon();
				coupon.setCouponNum(uuid);
				coupon.setCardnum(depotcard.getCardnum());
				coupon.setMoney(money);
				coupon.setTime(new Date());
				couponService.addCoupon(coupon);
				c++;
			}  
		} catch (Exception e) {
			return Msg.fail().add("va_msg", "ϵͳ����");
		}
		return Msg.success();
	}
}
