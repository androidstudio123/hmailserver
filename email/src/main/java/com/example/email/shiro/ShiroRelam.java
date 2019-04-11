package com.example.email.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collections;

public class ShiroRelam extends AuthorizingRealm{
    /**
     * 用户验证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //获取用户信息
        String name= (String) principalCollection.getPrimaryPrincipal();
        //到数据库查询获取到用户的权限和角色（可用list循环获取）
        String role="";
        //将角色和权限添加到info中
       info.addRole(role);
        return info;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        //获取用户输入的账号
        String name= (String) authenticationToken.getPrincipal();
        //然后通过获取的用户账号去数据库查询user对象，
        String password="123";
        if(password==null){
            return  null;
        }
        //查询到user对象后，将该条数据的属性封装到authenticationInfo中，便于后续验证。
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo();
         return authenticationInfo;
    }
}
