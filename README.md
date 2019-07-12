扩展 Spring Security OAuth2 客户端用于方便的调用微信的API

模拟 Spring Security OAuth2 Client 的配置方式，一个 session 生成一个 OAuth2ClientContext 对象，scope 范围不合适，仅供测试；

单个公众号的话 OAuth2ClientContext 对象可以设置为单例；
如果要对接多个公众号的话，可以自定义一个 scope，为一个公众号生成一个  OAuth2ClientContext 对象。
自定义scope可以模拟 AbstractRequestAttributesScope，从  RequestContextHolder.currentRequestAttributes() 中取出请求中的 wechat 实例的标识，生成一套实例存储起来，最主要的是生成请求 wechat api 接口的 OAuth2RestTemplate 客户端。
