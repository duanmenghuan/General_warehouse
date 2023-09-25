package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bean.Drug;


@Repository
public interface DrugMapper {
		List<Drug> QueryByNameCS(@Param("drugname")String drugname,@Param("changshang")String changshang);  //����drugname��changshang����
		void AddDrug(Drug drug); //���drug
		void DeleteDrug(@Param("drugname")String drugname,@Param("changshang")String changshang);//����drugname��changshangɾ��drug
		List<Drug> GetAllDrug();//��ѯȫ��druginfo
		List<Drug> QueryByTiao(String tiaoxingma); //�����������ѯdrug
		List<Drug> QueryByName(@Param("name")String name);  //����drugnameģ����ѯ
		void Update(@Param("olddn")String olddn,@Param("oldcs")String oldcs,@Param("dd")Drug drug);
}
