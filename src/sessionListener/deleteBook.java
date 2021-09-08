package sessionListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import jbs.controller.bookCancel;

@WebListener
public class deleteBook implements HttpSessionListener {
	@Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
         bookCancel bc=new bookCancel();
         bc.cancel(se.getSession());
    }
	
}
