package com.entity.view;

import com.entity.DiscusskefangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 客房信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-03 13:33:01
 */
@TableName("discusskefangxinxi")
public class DiscusskefangxinxiView  extends DiscusskefangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusskefangxinxiView(){
	}
 
 	public DiscusskefangxinxiView(DiscusskefangxinxiEntity discusskefangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusskefangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
