package jbs.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import jbs.dao.payDao;
import semi.vo.payVo;

public class kakaoPay extends HttpServlet{
	public String kakaoPayReady(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 	String jsonString=request.getParameter("toss");
			 	JSONObject json=new JSONObject(jsonString);
			 	String partner_order_id=json.getString("bookNum");
			 	String partner_user_id=json.getString("id");
			 	String item_name=json.getString("title");
			 	int quantity=json.getInt("count");
			 	int total_amount=json.getInt("total");
			 	
			 	URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
	            HttpURLConnection con=(HttpURLConnection) url.openConnection();//�������
	            con.setRequestMethod("POST");
	            con.setRequestProperty("Authorization","KakaoAK 2668af820c7a5e9072a3f9629c1cc7da");//KaKaoAK + Admin key
	            con.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
	            con.setDoInput(true);//�޾ƿð� ����
	            con.setDoOutput(true);//������ ����
	            
	            //IP�ּ�,��Ʈ��ȣ,url ������
	            String base_url="http://"+"www.lottocinema.shop"+request.getContextPath();
	            String approval_url=base_url+"/kakao?partner_order_id="+partner_order_id;
	            String cancel_url=base_url+"/payList";
	            String fail_url=base_url+"/bookCancel";
	            
	            //header�� �ٿ��� post������� ����
	            String headerParam = "cid=TC0ONETIME"+
	            			   "&partner_order_id="+partner_order_id+//���Ź�ȣ
	            			   "&partner_user_id="+partner_user_id+//id
	            			   "&item_name="+item_name+//��ȭ����
	            			   "&quantity="+quantity+//����
	            			   "&total_amount="+total_amount+//�ѱݾ�
	            			   "&tax_free_amount="+total_amount+
	            			   "&approval_url="+approval_url+
	            			   "&cancel_url="+cancel_url+
	            			   "&fail_url="+fail_url;
	            
	            byte[] encoded=headerParam.getBytes("utf-8");
	            con.getOutputStream().write(encoded);
	            con.getOutputStream().close();
	            //�����޽��� ó��
	            if(con.getResponseCode()!=200) {
					BufferedReader br=new BufferedReader(new InputStreamReader(con.getErrorStream(),"utf-8"));
					String serverResp=br.readLine();
					System.out.println(serverResp);
				
				}
	            BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
	            
	            String serverResp=br.readLine();
	    		JSONObject obj=new JSONObject(serverResp);
	    		String tid=obj.getString("tid");
	    		String next_redirect_pc_url=obj.getString("next_redirect_pc_url");

	    		payVo vo=new payVo();
	    		vo.setPayNum(tid);
	    		System.out.println("tid:"+tid);
	    		vo.setIntNum(Integer.parseInt(partner_order_id));
	    		System.out.println("poid:"+partner_order_id);
	    		payDao dao=payDao.getInstance();
	    		dao.insert(vo);
	    		
	    		System.out.println("puid:"+partner_user_id);
	    		System.out.println("end of kakaopayready");
	    		return next_redirect_pc_url;
		 	} catch (MalformedURLException me) {
	            System.out.println("�߸��� URL�Դϴ�.");
	            return null;
	        } catch (IOException e) {
				e.printStackTrace();
				return null;
			}
	}
	public void kakaoPayApprove(String partner_order_id,String pg_token,HttpServletRequest request) throws ServletException, IOException {
		try {
			URL url = new URL("https://kapi.kakao.com/v1/payment/approve");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization","KakaoAK 2668af820c7a5e9072a3f9629c1cc7da");//KaKaoAK + Admin key
			con.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			con.setDoInput(true);
			con.setDoOutput(true);
			
			int intOrder=Integer.parseInt(partner_order_id);
			System.out.println("poid:"+partner_order_id);
			payDao dao=payDao.getInstance();
			payVo vo=dao.find(intOrder);
			String tid=vo.getPayNum();
			//partner_order_id�� bookNum �˻��� userNum���� users ���̺�� �����ؼ� id ��������
			HttpSession session=request.getSession();
			String partner_user_id=(String)session.getAttribute("id");
			System.out.println("puid:"+partner_user_id);
			
			String headerParam = "cid=TC0ONETIME"+
					"&tid="+tid+
					"&partner_order_id="+partner_order_id+
					"&partner_user_id="+partner_user_id+
					"&pg_token="+pg_token;
			
			System.out.println(headerParam);
			byte[] encoded=headerParam.getBytes("utf-8");
            con.getOutputStream().write(encoded);
			con.getOutputStream().close();
			
			if(con.getResponseCode()!=200) {
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getErrorStream(),"utf-8"));
				String serverResp=br.readLine();
				System.out.println(serverResp);
			
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			
			String serverResp=br.readLine();
			JSONObject obj=new JSONObject(serverResp);
			System.out.println(serverResp);
			
			String payment_method_type=obj.getString("payment_method_type");
			JSONObject amount=obj.getJSONObject("amount");
			int total=amount.getInt("total");
			payVo vo2=new payVo();
			vo2.setPayNum(tid);
			System.out.println(tid);
			vo2.setMethod(payment_method_type);
			vo2.setTot(total);
			dao.save(vo2);
			
		} catch (MalformedURLException me) {
			System.out.println("�߸��� URL�Դϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void kakaoPayCancel(String partner_order_id) throws ServletException, IOException {
		try {
			URL url = new URL("https://kapi.kakao.com/v1/payment/cancel");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization","KakaoAK 2668af820c7a5e9072a3f9629c1cc7da");//KaKaoAK + Admin key
			con.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			con.setDoInput(true);
			con.setDoOutput(true);
			
			int intOrder=Integer.parseInt(partner_order_id);
			payDao dao=payDao.getInstance();
			payVo vo=dao.find(intOrder);
			String tid=vo.getPayNum();
			int cancel_amount=vo.getTot();
			
			String headerParam = "cid=TC0ONETIME"+
					"&tid="+tid+
					"&cancel_amount="+cancel_amount+
					"&cancel_tax_free_amount="+cancel_amount;
			
			System.out.println(headerParam);
			byte[] encoded=headerParam.getBytes("utf-8");
			con.getOutputStream().write(encoded);
			con.getOutputStream().close();

			if(con.getResponseCode()!=200) {
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getErrorStream(),"utf-8"));
				String serverResp=br.readLine();
				System.out.println(serverResp);
			
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			String serverResp=br.readLine();
			JSONObject obj=new JSONObject(serverResp);
			System.out.println(serverResp);
			
		} catch (MalformedURLException me) {
			System.out.println("�߸��� URL�Դϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
  