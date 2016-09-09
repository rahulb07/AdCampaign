package com.ad.campaign.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/spring/spring-mvc.xml")
public class AbstractContextControllerTests {
	
		@Autowired
		protected WebApplicationContext wac;

}
