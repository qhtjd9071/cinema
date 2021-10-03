package shop.jbsapp.www.util;

import java.util.List;

import shop.jbsapp.www.mapper.BooksMapper;
import shop.jbsapp.www.mapper.PaysMapper;
import shop.jbsapp.www.vo.BooksVo;
import shop.jbsapp.www.vo.PaysVo;

public class BookCancel {
	public static void cancel(PaysMapper payMapper, BooksMapper bookMapper, String id){
		List<PaysVo> list=payMapper.findAll();
		
		for(int i=0;i<list.size();i++) {
			PaysVo paysVo=list.get(i);
			int bookId=paysVo.getBookId();
			if(paysVo.getMethod() == null) {
				BooksVo bookVo = bookMapper.findById(bookId);
				if(bookVo.getUserId() == id) {
					bookMapper.deleteById(bookId);
				}
			}
		}
	}
}