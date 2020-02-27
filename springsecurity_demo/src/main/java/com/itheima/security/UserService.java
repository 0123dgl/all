package com.itheima.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ly
 * @Company 深圳黑马程序员
 * @Date 2020/2/25 10:13
 * @Version V1.0
 */
@Component // 组件，相当于spring的配置文件中定义<bean id="userService" class="com.itheima.security.UserService">
public class UserService implements UserDetailsService {

    // 模拟数据库的数据，将数据库的数据存放到Map集合中，map集合的key，表示用户名；map集合的value，表示用户对象User
    static Map<String,com.itheima.health.pojo.User> map = new HashMap<>();

    static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    // UserService类被初始化，执行static静态方法，初始化数据库的数据（初始化Map集合的数据）
    static{
        System.out.println("初始化数据...");
        com.itheima.health.pojo.User user1 = new com.itheima.health.pojo.User();
        user1.setUsername("admin");
        // user1.setPassword("123"); // 明文
        user1.setPassword(bCryptPasswordEncoder.encode("123"));
        user1.setTelephone("13212341234");

        com.itheima.health.pojo.User user2 = new com.itheima.health.pojo.User();
        user2.setUsername("zhangsan");
        // user2.setPassword("123"); // 明文
        user2.setPassword(bCryptPasswordEncoder.encode("123"));
        user2.setTelephone("13212341255");

        map.put(user1.getUsername(),user1);
        map.put(user2.getUsername(),user2);

    }

    /** 执行/login.do的url的时候，就会执行loadUserByUsername的方法
     * @param username：表示用户名，接收表单用户名的数据
     * @return UserDetails：封装的用户信息对象，用来存放用户名，密码，权限
     *                       等同于<security:user name="admin" password="{noop}123" authorities="ROLE_ADMIN"></security:user>
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("进行登录校验");
        // 1：使用用户名作为查询条件，查询用户信息（从数据库查询）
        com.itheima.health.pojo.User user = map.get(username);
        // 此时说明用户名输入有误，返回null，如果UserDetails对象为null，抛出异常，回退到登录页面，表示登录名输入有误，org.springframework.security.authentication.InternalAuthenticationServiceException: UserDetailsService returned null
        if(user==null){
            return null;
        }
        // 密码（明文）
        // String password = "{noop}"+user.getPassword();
        // 密码（BCryptPasswordEncoder）
        String password = user.getPassword();
        // 2：对当前用户分配角色和权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // 添加角色
        authorities.add(new SimpleGrantedAuthority("add"));         // 添加add权限
        authorities.add(new SimpleGrantedAuthority("delete"));     // 添加delete权限
        // 3：组织封装UserDetails对象
        /**
         * User(String username, String password, Collection<? extends GrantedAuthority> authorities)
         * 其中参数2：表示从数据库查询的密码，对于SpringSecurity来说，自动使用该密码password和表单页面传递的密码进行比对
         *             如果一致，跳转到登录成功页面index.html；如果不一致，抛出异常，回退到登录页面login.html
         *
         *             org.springframework.security.authentication.BadCredentialsException: Bad credentials
         */
        return new User(username,password,authorities);
    }
}
