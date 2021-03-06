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
		//因为有些新的Session的创建是由于不同用户的点击
		//所以调用sessionCreated的线程也就不同
		//所以要保持同步，否则就会出现多线程同时对数据修改导致的异常
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
