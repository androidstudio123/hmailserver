package com.example.email.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class shiroConfig {
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
      DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
      securityManager.setRealm(shiroRelam());
      return securityManager;
    }
    @Bean
    public ShiroRelam shiroRelam(){
        return new ShiroRelam();
    }

    /**
     * 配置权限拦截器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置登录界面
        shiroFilterFactoryBean.setLoginUrl("/main");
        //沒有权限返回界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        //设置登录成功界面
        shiroFilterFactoryBean.setSuccessUrl("/login");
        /**
         * 配置shiro拦截器链
         * anon  不需要认证
         * authc 需要认证
         * user  验证通过或RememberMe登录的都可以
         */
        Map<String, String> map = new HashMap<String, String>();
        map.put("/mima", "anon");
        map.put("/login","anon");
        map.put("/login2", "anon");
        map.put("/logout" , "anon");
        map.put("/", "anon");
        map.put("/static/**", "anon");
        map.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
