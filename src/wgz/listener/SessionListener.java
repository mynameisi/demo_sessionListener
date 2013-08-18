package wgz.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class SessionListener
 * 
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	private static final Logger logger = LoggerFactory.getLogger(HttpSessionListener.class);

	private int sessionCount = 0;

	public SessionListener() {
		// TODO Auto-generated constructor stub
	}

	public void sessionCreated(HttpSessionEvent event) {
		synchronized (this) {
			sessionCount++;
		}
		logger.debug("有一个Session被创建，现在有：" + sessionCount + "个Session");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		synchronized (this) {
			sessionCount--;
		}
		logger.debug("有一个Session被销毁，还剩下：" + sessionCount + "个Session");
	}

}
