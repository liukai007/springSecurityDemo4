Spring-Security认证主要组成成员：

1）认证过滤器抽象类 AbstractAuthenticationProcessingFilter
UsernamePasswordAuthenticationFilter为其默认实现，拦截登录路径。

2）封装的认证实体抽象类 AbstractAuthenticationToken
UsernamePasswordAuthenticationToken为其默认实现，封装输入的用户名密码。

3）认证器接口 AuthenticationProvider
具体的方法认证规则，需实现。

4）认证器管理接口 AuthenticationManager
ProviderManager为其默认实现。

5）登录成功处理器接口 AuthenticationSuccessHandler
需实现
6）登录失败处理器接口 AuthenticationFailureHandler
需实现
7）security配置抽象类 WebSecurityConfigurerAdapter
需实现

参考链接：
https://blog.csdn.net/qq_38225558/article/details/101754743
inMemoryAuthentication ===内存配置

http://127.0.0.1:8080/login

报错：
Parameter 0 of constructor in com.lkspringsecurity.dmeo1.config.CusAuthenticationManager required a bean of type 'com.lkspringsecurity.dmeo1.config.AdminAuthenticationProvider' that could not be found.


Action:

Consider defining a bean of type 'com.lkspringsecurity.dmeo1.config.AdminAuthenticationProvider' in your configuration.

Disconnected from the target VM, address: '127.0.0.1:55540', transport: 'socket'

Process finished with exit code 1

解决：没有注入。