package com.shiro.realm;

import com.shiro.dao.UserDao;
import com.shiro.entity.User;
import com.shiro.services.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import javax.annotation.Resource;

/**
 * 自定义Realm
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserDao userDao;
    /**
     * 为当前登录的用户授予角色和权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userDao.selRolesByUserName(userName));
        authorizationInfo.setStringPermissions(userDao.selPermissionsByUserName(userName));
        return authorizationInfo;
    }

    /**
     * 验证当前用户
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String)token.getPrincipal();
        //根据用户名查询数据库 用户名，密码
        User user = userDao.selUserByUserName(userName);
        if(user!=null){
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xx");
            return authcInfo;
        }else {
            return null;
        }
    }
}
