package shop.jbsapp.www.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

import shop.jbsapp.www.mapper.BooksMapper;
import shop.jbsapp.www.mapper.PaysMapper;

@Component
public class DeleteBook implements ApplicationListener<SessionDestroyedEvent> {

	private static final Logger log = LoggerFactory.getLogger(DeleteBook.class);

	@Autowired
	private PaysMapper paysMapper;

	@Autowired
	private BooksMapper booksMapper;

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			String username = authentication.getName();
			
			BookCancel.cancel(paysMapper, booksMapper, username);
			
			log.info("user[{}]'s session was destroyed", username);
		}

	}
}
