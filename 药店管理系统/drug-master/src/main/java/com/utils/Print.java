package com.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bean.Sell;


public class Print implements Printable{
	private static String TITLE;//����
	private static String ORDERNO;//����
	private static String STORENAME;//�ŵ�
	private static String CASHIER;//����Ա
	private static String CASH;//���ֽ�
	private static String PAYMENT;//֧����ʽ
	private static String USERNAME;//��Ա����
	private static String TEL;//�ͷ��绰
	private static String ADDRESS;//��ַ
	private static List<Sell> Goodsinfo;
	
	


	private static void chushihua(String orderNo, String storeName, String cashier, String cash, String payment, String userName, String tel, String address,List<Sell> goodsinfo){
		TITLE ="����СƱ";
		ORDERNO =orderNo;
		STORENAME =storeName;
		CASHIER =cashier;
		CASH =cash;
		PAYMENT =payment;
		USERNAME =userName;
		TEL =tel;
		ADDRESS =address;
		Goodsinfo =goodsinfo;
		
	}
	
	/**
	 * ���ڽ���Ʒ���۽��н��д�ӡ
	 */
	public  void printSheet(String orderNo, String storeName, String cashier, String cash, String payment, String userName, String tel, String address, List<Sell> Goodsinfo) {
		chushihua(orderNo,storeName, cashier, cash, payment, userName, tel, address, Goodsinfo);
		// ͨ���������顢�ĵ�
		Book book = new Book();
		// ���ó�����
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT); //LANDSCAPE��ʾ���;PORTRAIT��ʾ����;REVERSE_LANDSCAPE��ʾ��ӡ�հ�
		// ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
		Paper p = new Paper();
		int length = printSize(Goodsinfo);//��ֵ����Ϊ115������������Ҫ���Ӹ߶�
		System.out.println("Paper length is:"+length);
		p.setSize(165, length); // ֽ�Ŵ�СA4ֽ(595, 842),������58mmΪ165 
		p.setImageableArea(5, 5, 155, length); //���ô�ӡ����A4ֽ��Ĭ��X,Y�߾���72
		//x - �������ô� paper �ɳ����������Ͻǵ� x ����
		//y - �������ô� paper �ɳ����������Ͻǵ� y ����
		//width - �������ô� paper �ɳ��������ȵ�ֵ
		//height - �������ô� paper �ɳ�������߶ȵ�ֵ
		pf.setPaper(p);
		// �� PageFormat �� Printable ��ӵ����У����һ��ҳ��
		book.append(new Print(), pf);
		// ��ȡ��ӡ�������
		PrinterJob job = PrinterJob.getPrinterJob();
		// ���ô�ӡ��
		job.setPageable(book);
		try {
			// // ������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ
			// if (a) {
			job.print();
			// }
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer printSize(List<Sell> goodsArray) {
		int height = 200;//��ֵ����Ϊ140������������Ҫ���Ӹ߶�
		if (goodsArray.size() > 0) {
			height += goodsArray.size()*10;
			for(int i=0;i<goodsArray.size();i++){
				goodsArray.get(i).getDrugname();
				//String[] goods = goodsArray[i].split(",");
				if(goodsArray.get(i).getDrugname().length()>8){//���Ƴ�11����,����
					height += 10;
				}
			}
		}
		return height;
	}
	

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		try {
			/**
			 * * @param Graphicָ����ӡ��ͼ�λ��� 
			 * PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��
			 * 1��Ϊ1Ӣ���1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595��842�㣩 *
			 * @param pageIndexָ��ҳ��
			 **/
			// ת����Graphics2D
			Graphics2D g2d = (Graphics2D) graphics;
			// ���ô�ӡ��ɫΪ��ɫ
			g2d.setColor(Color.black);
			// ��ӡ�������
			switch (pageIndex) {
				case 0:
					String xuxian = "------------------------------------";
					double x = pageFormat.getImageableX();
					double y = pageFormat.getImageableY() + 10;
					//���ô�ӡ���壨�������ơ���ʽ�͵��С�����������ƿ�������������߼����ƣ�
					Font fontTitle = new Font("������", Font.BOLD, 10);
					g2d.setFont(fontTitle); // ��������
					//��ӡ����
					g2d.drawString(TITLE, (float) x + 40, (float) y);
					y += fontTitle.getSize2D()+4;
					
					Font fontContent = new Font("������", Font.PLAIN, 7);
					g2d.setFont(fontContent); //��������
					//��ӡ ������
					g2d.drawString("���ţ�" + ORDERNO, (float) x, (float) y);
					y += fontContent.getSize2D()+4;
					g2d.drawString("�ŵ꣺" + STORENAME, (float) x, (float) y);
					y += fontContent.getSize2D()+4;
					g2d.drawString("����Ա��" +CASHIER, (float) x, (float) y);
					y += fontContent.getSize2D()+4;
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					g2d.drawString("ʱ�䣺" + format.format(new Date()), (float) x, (float) y);
					y += fontContent.getSize2D()+4; 
					
					g2d.drawString(xuxian, (float) x, (float) y);
					y += fontContent.getSize2D()+2;
					
					g2d.drawString("����", (float) x, (float) y);
					g2d.drawString("��", (float) x + 70, (float) y);
					//g2d.drawString("���ֵ�", (float) x + 80, (float) y);
					g2d.drawString("�ֽ�", (float) x + 110, (float) y);
					y += fontContent.getSize2D()+2;
					g2d.drawString("��", (float) x + 70, (float) y);
					//g2d.drawString("��", (float) x + 80, (float) y);
					g2d.drawString("��", (float) x + 110, (float) y);
					y += fontContent.getSize2D()+2;
					@SuppressWarnings("unused")
					Double totalCount = 0.0,totalPrice = 0.0 ;
					
					for(int i=0;i<Goodsinfo.size();i++){
						//String[] goods = GOODSARRAY[i].split(",");
						
						totalCount += Double.valueOf(Goodsinfo.get(i).getCount());
						//totalPrice += Double.valueOf(GOODSARRAY.get(i).getCount())*Double.valueOf(GOODSARRAY.get(i).get);
						String goodsName = Goodsinfo.get(i).getDrugname().length()>8?Goodsinfo.get(i).getDrugname().substring(0, 8):Goodsinfo.get(i).getDrugname();
						g2d.drawString((i+1) + "." + goodsName, (float) x, (float) y);
						if(Goodsinfo.get(i).getDrugname().length()>8){//���Ƴ�8����,����
							y += fontContent.getSize2D()+2;
							g2d.drawString(Goodsinfo.get(i).getDrugname().substring(8), (float) x+7, (float) y);
						}
						if(Goodsinfo.get(i).getDrugname().length()>20){
							y += fontContent.getSize2D()+2;
						}
						g2d.drawString(Goodsinfo.get(i).getAmount().toString(), (float) x + 70, (float) y);
						//g2d.drawString(Goodsinfo.get(i).getJifen().toString(), (float) x + 80, (float) y);
						g2d.drawString(Goodsinfo.get(i).getPrice().toString(), (float) x + 110, (float) y);
						y += fontContent.getSize2D()+2; 
			        }
					g2d.drawString(xuxian, (float) x, (float) y);
					y += fontContent.getSize2D()+2; 
					/*g2d.drawString("������"+totalCount, (float) x , (float) y);
					y += fontContent.getSize2D()+2;*/
					/*g2d.drawString("�����ܼƣ�"+ String.format("%.2f",Double.valueOf(INTEGRAL)), (float) x ,(float) y);
					y += fontContent.getSize2D()+2;*/
					g2d.drawString("�ֽ��ܼƣ�"+ String.format("%.2f",Double.valueOf(CASH)), (float) x, (float) y);
					y += fontContent.getSize2D()+2;
					g2d.drawString("֧����ʽ��"+ PAYMENT, (float) x, (float) y);
					y += fontContent.getSize2D()+2;
					g2d.drawString("��Ա���ƣ�"+ USERNAME, (float) x, (float) y);
					y += fontContent.getSize2D()+2; 
					g2d.drawString(xuxian, (float) x, (float) y);
					y += fontContent.getSize2D()+4; 
					String address = ADDRESS.length()>16?ADDRESS.substring(0,16):ADDRESS;
					g2d.drawString("��ַ��" + address, (float) x, (float) y);
					if(ADDRESS.length()>16){
						y += fontContent.getSize2D()+2;
						g2d.drawString(ADDRESS.substring(16), (float) x+20, (float) y);
					}
					y += fontContent.getSize2D()+2; 
					g2d.drawString("лл�ݹ�,ף�����տ���!!!", (float) x+22, (float) y);
					y += fontContent.getSize2D()+2; 
					g2d.drawString("�ͷ��绰("+TEL+")", (float) x+25, (float) y);
					y += fontContent.getSize2D()+10; 
					return PAGE_EXISTS;
				default:
					return NO_SUCH_PAGE;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}

