package com.entity.model;

import com.entity.KefangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 客房信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-03 13:33:00
 */
public class KefangxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 客房类型
	 */
	
	private String kefangleixing;
		
	/**
	 * 客房图片
	 */
	
	private String kefangtupian;
		
	/**
	 * 客房设施
	 */
	
	private String kefangsheshi;
		
	/**
	 * 客房价格
	 */
	
	private Integer kefangjiage;
		
	/**
	 * 客房状态
	 */
	
	private String kefangzhuangtai;
		
	/**
	 * 客房介绍
	 */
	
	private String kefangjieshao;
		
	/**
	 * 酒店名称
	 */
	
	private String jiudianmingcheng;
		
	/**
	 * 酒店类型
	 */
	
	private String jiudianleixing;
		
	/**
	 * 酒店地址
	 */
	
	private String jiudiandizhi;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：客房类型
	 */
	 
	public void setKefangleixing(String kefangleixing) {
		this.kefangleixing = kefangleixing;
	}
	
	/**
	 * 获取：客房类型
	 */
	public String getKefangleixing() {
		return kefangleixing;
	}
				
	
	/**
	 * 设置：客房图片
	 */
	 
	public void setKefangtupian(String kefangtupian) {
		this.kefangtupian = kefangtupian;
	}
	
	/**
	 * 获取：客房图片
	 */
	public String getKefangtupian() {
		return kefangtupian;
	}
				
	
	/**
	 * 设置：客房设施
	 */
	 
	public void setKefangsheshi(String kefangsheshi) {
		this.kefangsheshi = kefangsheshi;
	}
	
	/**
	 * 获取：客房设施
	 */
	public String getKefangsheshi() {
		return kefangsheshi;
	}
				
	
	/**
	 * 设置：客房价格
	 */
	 
	public void setKefangjiage(Integer kefangjiage) {
		this.kefangjiage = kefangjiage;
	}
	
	/**
	 * 获取：客房价格
	 */
	public Integer getKefangjiage() {
		return kefangjiage;
	}
				
	
	/**
	 * 设置：客房状态
	 */
	 
	public void setKefangzhuangtai(String kefangzhuangtai) {
		this.kefangzhuangtai = kefangzhuangtai;
	}
	
	/**
	 * 获取：客房状态
	 */
	public String getKefangzhuangtai() {
		return kefangzhuangtai;
	}
				
	
	/**
	 * 设置：客房介绍
	 */
	 
	public void setKefangjieshao(String kefangjieshao) {
		this.kefangjieshao = kefangjieshao;
	}
	
	/**
	 * 获取：客房介绍
	 */
	public String getKefangjieshao() {
		return kefangjieshao;
	}
				
	
	/**
	 * 设置：酒店名称
	 */
	 
	public void setJiudianmingcheng(String jiudianmingcheng) {
		this.jiudianmingcheng = jiudianmingcheng;
	}
	
	/**
	 * 获取：酒店名称
	 */
	public String getJiudianmingcheng() {
		return jiudianmingcheng;
	}
				
	
	/**
	 * 设置：酒店类型
	 */
	 
	public void setJiudianleixing(String jiudianleixing) {
		this.jiudianleixing = jiudianleixing;
	}
	
	/**
	 * 获取：酒店类型
	 */
	public String getJiudianleixing() {
		return jiudianleixing;
	}
				
	
	/**
	 * 设置：酒店地址
	 */
	 
	public void setJiudiandizhi(String jiudiandizhi) {
		this.jiudiandizhi = jiudiandizhi;
	}
	
	/**
	 * 获取：酒店地址
	 */
	public String getJiudiandizhi() {
		return jiudiandizhi;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
