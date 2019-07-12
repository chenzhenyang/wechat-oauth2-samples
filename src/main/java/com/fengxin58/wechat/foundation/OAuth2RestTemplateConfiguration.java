package com.fengxin58.wechat.foundation;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@Configuration
public class OAuth2RestTemplateConfiguration {
	
	@Bean
	public OAuth2RestTemplate restTemplate(OAuth2ClientContext context){
		AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
		resource.setAuthenticationScheme(AuthenticationScheme.form);
		resource.setClientAuthenticationScheme(AuthenticationScheme.form);
		resource.setClientId("wx991c7d7bfbf20138");
		resource.setClientSecret("01e7bc3aef58e201778c454e6df44405");
		resource.setUserAuthorizationUri("https://open.weixin.qq.com/connect/oauth2/authorize");
		resource.setAccessTokenUri("https://api.weixin.qq.com/sns/oauth2/access_token");
		resource.setScope(Arrays.asList("snsapi_base"));
//		context.getAccessTokenRequest().setCurrentUri(request.getRequestURL().toString());
		resource.setPreEstablishedRedirectUri("http://a3f2cdb0.ngrok.io/principal");
		resource.setUseCurrentUri(false);
		OAuth2RestTemplate template = new WeixinOAuth2RestTemplate(resource, context);
		return template;
	}
	
}
