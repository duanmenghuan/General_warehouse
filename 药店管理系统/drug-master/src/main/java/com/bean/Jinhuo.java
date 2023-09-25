package com.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Jinhuo {
	
	@Pattern(regexp = "^.{1,22}$",message = "��ʽ����򳬹���������")
	@NotBlank(message="dn����Ϊ��")
	private String drugname;
	
	@Pattern(regexp = "^.{1,22}$",message = "��ʽ����򳬹���������")
	@NotBlank(message="cs����Ϊ��")
	private String changshang;
	
	@Pattern(regexp = "^[1-9]\\d*\\.\\d*|^0\\.\\d*[1-9]\\d*$|^\\d+$",message = "���ָ�ʽ����")
	@NotBlank(message="bp����Ϊ��")
	private String beginprice;
	
	@Pattern(regexp = "^[1-9]\\d*\\.\\d*|^0\\.\\d*[1-9]\\d*$|^\\d+$",message = "���ָ�ʽ����")
	@NotBlank(message="pri����Ϊ��")
	private String price;
	
	@Pattern(regexp = "^[1-9]\\d*|0$",message = "���ָ�ʽ����")
	@NotBlank(message="kc����Ϊ��")
	private String amount;
	
	@Pattern(regexp = "^[1-9]\\d*\\.\\d*|^0\\.\\d*[1-9]\\d*$|^\\d+$",message = "���ָ�ʽ����")
	@NotBlank(message="sum����Ϊ��")
	private String sum;
	private String begindate;
	private String date;
	
	@Pattern(regexp = "^.{1,30}$",message = "��ʽ����򳬹���������")
	@NotBlank(message="ph����Ϊ��")
	private String pihao;
	private String beizhu;
	private String location;
	private String unit;
	private String guige;
	private String tiaoxingma;
	private String jinhuo_time;
	private String gonghuoshang;
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public String getChangshang() {
		return changshang;
	}
	public void setChangshang(String changshang) {
		this.changshang = changshang;
	}
	public String getBeginprice() {
		return beginprice;
	}
	public void setBeginprice(String beginprice) {
		this.beginprice = beginprice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPihao() {
		return pihao;
	}
	public void setPihao(String pihao) {
		this.pihao = pihao;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public String getTiaoxingma() {
		return tiaoxingma;
	}
	public void setTiaoxingma(String tiaoxingma) {
		this.tiaoxingma = tiaoxingma;
	}
	public String getJinhuo_time() {
		return jinhuo_time;
	}
	public void setJinhuo_time(String jinhuo_time) {
		this.jinhuo_time = jinhuo_time;
	}
	public String getGonghuoshang() {
		return gonghuoshang;
	}
	public void setGonghuoshang(String gonghuoshang) {
		this.gonghuoshang = gonghuoshang;
	}
	public Jinhuo(){}
	public Jinhuo(String drugname, String changshang, String beginprice,
			String price, String amount, String sum, String begindate,
			String date, String pihao, String beizhu, String location,
			String unit, String guige, String tiaoxingma, String jinhuo_time,
			String gonghuoshang) {
		super();
		this.drugname = drugname;
		this.changshang = changshang;
		this.beginprice = beginprice;
		this.price = price;
		this.amount = amount;
		this.sum = sum;
		this.begindate = begindate;
		this.date = date;
		this.pihao = pihao;
		this.beizhu = beizhu;
		this.location = location;
		this.unit = unit;
		this.guige = guige;
		this.tiaoxingma = tiaoxingma;
		this.jinhuo_time = jinhuo_time;
		this.gonghuoshang = gonghuoshang;
	}
	@Override
	public String toString() {
		return "Jinhuo [drugname=" + drugname + ", changshang=" + changshang
				+ ", beginprice=" + beginprice + ", price=" + price
				+ ", amount=" + amount + ", sum=" + sum + ", begindate="
				+ begindate + ", date=" + date + ", pihao=" + pihao
				+ ", beizhu=" + beizhu + ", location=" + location + ", unit="
				+ unit + ", guige=" + guige + ", tiaoxingma=" + tiaoxingma
				+ ", jinhuo_time=" + jinhuo_time + ", gonghuoshang="
				+ gonghuoshang + "]";
	}
	
	
}
