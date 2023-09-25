package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









import com.bean.Datetips;
import com.bean.Store;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.StoreMapper;
import com.utils.Boolean_tiaoxingma;
import com.utils.StringPro;


@Service
public class StoreService {

	@Autowired
	StoreMapper store;
	
	public PageInfo<Store> QueryStoreService(Integer pn, String qs) {
		if(qs==""||qs==null){
			PageHelper.startPage(pn, 8);
			List<Store> re = store.GetAllStore();
			PageInfo<Store> page_1 = new PageInfo<Store>(re,5);
			return page_1;
		}else{
			if(Boolean_tiaoxingma.CheckParam(qs)){
				PageHelper.startPage(pn, 8);
				List<Store> re2 = store.QueryBySTiao(qs);
				PageInfo<Store> page_2 = new PageInfo<Store>(re2,5);
				return page_2;
			}else{
				PageHelper.startPage(pn, 8);
				List<Store> re3 = store.QueryBySName(qs);
				PageInfo<Store> page_3 = new PageInfo<Store>(re3,5);
				return page_3;
			}
		}
	}

	public void DeleteService(String drugname, String changshang, String pihao) {
		store.DeleteStore(drugname, changshang, pihao);	
	}

	public void UpdateStoreService(Store reqstore) {
		store.UpdateStoreSomeInfo(reqstore);
		
	}
	/**
	 * ��ӿ��,���ݿ�����Ƿ���ͬ����ҩƷ����true��false,��ͬ���ŷ���true
	 * @param s
	 * @return
	 */
	public boolean AddStoreService(Store s){
		List<Store> check = store.QueryByNCP(s.getDrugname(), s.getChangshang(), s.getPihao());
		if(check.isEmpty()){
			store.AddStore(s);
			return false;
		}else{
			String newcount = StringPro.add(check.get(0).getCount(), s.getCount());
			store.UpdateStoreCount(newcount, s.getDrugname(), s.getChangshang(), s.getPihao());
			return true;
		}
	}
	/**
	 * Ч����ʾ
	 * @return
	 *���û�м�¼����ֵֻ��һ����¼������flag="notip"
	 */
	public synchronized List<Datetips> CheckStoreService() {
		List<Store> allstore = store.GetAllStore();
		ArrayList<Datetips> re = new ArrayList<Datetips>();
		if(allstore.isEmpty()){
			re.add(new Datetips(null,null,null,null,null,null,null,null,null,null,null,null,"notip"));
			return re;
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String nowdate=sdf.format(new Date());//��ȡϵͳ��ǰʱ��
			for (Store s : allstore) {
			try{
				int flag = StringPro.daysBetween(nowdate,s.getDate());
				if(flag<=180){
					String tip = "";
					String f = "";
                	if(flag<=0){
                		tip="�ѹ���";
                		f = "r";
                	}else{
                		tip="����"+flag+"�����";
                		f = "y";
                	}
                	Datetips nn = new Datetips(s.getDrugname(), s.getChangshang(), s.getBeginprice(), s.getPrice(), s.getDate(), s.getPihao(), s.getBeizhu(), s.getLocation(), s.getCount(), s.getUnit(), s.getGuige(), tip, f);
                	re.add(nn);
				}
			}catch(Exception e) {
				continue;
			}
		}
			if(re.isEmpty()){
				re.add(new Datetips(null,null,null,null,null,null,null,null,null,null,null,null,"notip"));
			}
			return re;
		}
	}
	public List<Store> YJService(int c){
		return store.StoreYJ(c);
	}
}
