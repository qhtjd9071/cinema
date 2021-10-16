package shop.jbsapp.www.util;

import java.util.ArrayList;
import java.util.List;

public class GetSeatNum {
	public static List<String> getSeatNumList(List<String> list, String seatNumString) {
		String temp = seatNumString.substring(1, seatNumString.length() - 1);
		String[] seatNumArr = temp.split(",");
		for(String str : seatNumArr) {
			if(!str.equals("")) {
				list.add(str);
			}
		}
		return list;
	}
	
	public static String getSeatNumList(String seatNumString) {
		List<String> list = new ArrayList<String>();
		String temp = seatNumString.substring(1, seatNumString.length() - 1);
		String[] seatNumArr = temp.split(",");
		int index = 0;
		for(String str : seatNumArr) {
			if(!str.equals("")) {
				int code = (int)((Integer.parseInt(str)-1)/8.0 + 65);
				char alphabet = (char)code;
				seatNumArr[index] =  alphabet + Integer.toString(Integer.parseInt(str)%8);
				list.add(seatNumArr[index]);
			}
			index++;
		}
		return list.toString();
	}
	
	public static void main(String[] args) {
		String test = "[1, , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , 49, 50]";
		List<String> list = new ArrayList<>();
		List<String> method1 = getSeatNumList(list, test);
		
		String method2 = getSeatNumList(test);
	}
}