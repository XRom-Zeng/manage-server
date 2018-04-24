package com.xrom.server.config.shiro;

import com.xrom.server.entity.Role;
import com.xrom.server.entity.User;
import com.xrom.server.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * shiro realm configuration
 * @author: XRom
 * @date: 2018-04-19 00:26:03
 */
public class ShiroRealm  extends AuthorizingRealm{

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();

        user.getRoles().forEach(a -> roles.add(a.getRole()));
        for (Role role : user.getRoles()) {
            role.getPermissions().forEach(p -> permissions.add(p.getPermission()));
        }
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userMapper.selectByPhone(username);
        if (Objects.isNull(user)) {
            throw new UnknownAccountException("User don't exist");
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getPhone());   //盐值
        return new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, this.getName());
    }
}
