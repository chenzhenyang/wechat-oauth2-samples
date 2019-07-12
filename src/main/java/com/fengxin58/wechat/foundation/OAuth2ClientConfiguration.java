package com.fengxin58.wechat.foundation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

@Configuration
//@EnableOAuth2Client
public class OAuth2ClientConfiguration {
	
	@Primary
	@Bean
	@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
	public OAuth2ClientContext createContext() {
		OAuth2ClientContext context = new DefaultOAuth2ClientContext();
		return context;
	}
	
}
