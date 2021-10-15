package shop.jbsapp.www.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import shop.jbsapp.www.mapper.BooksMapper;
import shop.jbsapp.www.mapper.PaysMapper;

@Component
public class DeleteBook implements HttpSessionListener{

	private static final Logger log = LoggerFactory.getLogger(DeleteBook.class);
	
	@Autowired
	private PaysMapper paysMapper;
	
	@Autowired
	private BooksMapper booksMapper;
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		UserDetails userDetails = (UserDetails)principal;
		String username = userDetails.getUsername();

		BookCancel.cancel(paysMapper, booksMapper, username);
		
		log.info("user[{}]'s session was destroyed");
	}
}
