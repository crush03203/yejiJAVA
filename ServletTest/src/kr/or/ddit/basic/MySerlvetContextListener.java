package kr.or.ddit.basic;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySerlvetContextListener implements ServletContextListener,
	ServletContextAttributeListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[MySerlvetContextListener]"
							 + "contextDestroyed() 호출됨.");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[MySerlvetContextListener]"
				+ "contextInitialized() 호출됨.");
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("[MySerlvetContextListener]"
				+ "attributeAdded() 호출됨 => "
				+ event.getName() + "=" + event.getValue());
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("[MySerlvetContextListener]"
				+ "attributeRemoved() 호출됨 => "
				+ event.getName() + "=" + event.getValue());
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("[MySerlvetContextListener]"
				+ "attributeReplaced() 호출됨 => "
				+ event.getName() + "=" + event.getValue());
		
	}

}
