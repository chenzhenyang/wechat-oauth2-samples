package com.fengxin58.wechat.foundation;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private OAuth2RestTemplate restTemplate;	
	
	@RequestMapping(value = "/principal")
	public Principal principal(Principal principal) {
		return principal;
	}
	
	@ResponseBody
	@RequestMapping("/weixin/authorize")
	public Object getUserInfo(HttpServletRequest request) {
		String url = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN&openid=$openid$";
		ResponseEntity<Object> result = restTemplate.getForEntity(url, Object.class);
		return result.getBody();
	}
}
