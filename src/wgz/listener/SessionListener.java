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
	}

	public void sessionCreated(HttpSessionEvent event) {
		synchronized (this) {
			logger.debug("Session计数 +1");
			sessionCount++;
		}
		logger.debug("现在有：" + sessionCount + "个Session");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		synchronized (this) {
			logger.debug("Session计数 -1");
			sessionCount--;
		}
		logger.debug("现在有：" + sessionCount + "个Session");
	}

}
