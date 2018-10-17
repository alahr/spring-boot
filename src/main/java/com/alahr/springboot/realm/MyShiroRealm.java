package com.alahr.springboot.realm;

import com.alahr.springboot.module.system.dto.SysResourceDto;
import com.alahr.springboot.module.system.dto.SysRoleDto;
import com.alahr.springboot.module.system.dto.SysUserDto;
import com.alahr.springboot.module.system.service.SysResourceService;
import com.alahr.springboot.module.system.service.SysRoleService;
import com.alahr.springboot.module.system.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Resource
    public SysUserService sysUserService;
    @Resource
    public SysRoleService sysRoleService;
    @Resource
    public SysResourceService sysResourceService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principals.getPrimaryPrincipal();
        logger.info("username is {}.", username);

        SysUserDto user = sysUserService.getByUsername(username);
        List<SysRoleDto> roleDtos = sysRoleService.findRolesBySysUserId(user.getId());
        roleDtos.stream().forEach(role -> {
            authorizationInfo.addRole(role.getRoleName());
            List<SysResourceDto> resourceDtos = sysResourceService.findResourcesBySysRoleId(role.getId());
            resourceDtos.stream().forEach(resource -> {
                authorizationInfo.addStringPermission(resource.getResourceName());
            });
        });

        return authorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户账号
        String username = token.getPrincipal().toString();

        String password = sysUserService.getPasswordByUsername(username);
        if (password != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    username,   //认证通过后，存放在session,一般存放user对象
                    password,   //用户数据库中的密码
                    getName());    //返回Realm名
            return authenticationInfo;
        }
        return null;
    }
}
