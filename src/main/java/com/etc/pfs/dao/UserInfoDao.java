package com.etc.pfs.dao;

import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.util.JDBCUtils;
import com.etc.pfs.util.LoadXMLUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class UserInfoDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private Map<String,String> sqlMap = LoadXMLUtil.loadMapper(UserInfo.class);


    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    public Integer insertUserInfo(UserInfo userInfo){
        return template.update(sqlMap.get("insert"),userInfo.getId(),userInfo.getUsername(),userInfo.getPassword(),userInfo.getEmail(),userInfo.getTelphone(),userInfo.getFileurl());
    }

    /**
     * 根据id修改用户信息
     * @param userInfo
     * @return
     */
    public Integer updateUserInfo(UserInfo userInfo){
        return template.update(sqlMap.get("update"),userInfo.getUsername(),userInfo.getPassword(),userInfo.getEmail(),userInfo.getTelphone(),userInfo.getFileurl(),userInfo.getId());
    }

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    public Integer deleteUserInfo(String id){
        return template.update(sqlMap.get("delete"),id);
    }

    /**
     * 登录校验
     * @param userInfo
     * @return
     */
    public UserInfo loginUserInfo(UserInfo userInfo){
        try{
            return template.queryForObject(sqlMap.get("selectLogin"),new BeanPropertyRowMapper<UserInfo>(UserInfo.class),userInfo.getUsername(),userInfo.getPassword());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    public UserInfo getUserInfoById(String id){
        try{
            return template.queryForObject(sqlMap.get("selectById"),new BeanPropertyRowMapper<UserInfo>(UserInfo.class),id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据username查询单个用户
     * @param username
     * @return
     */
    public UserInfo getUserInfoByUserName(String username){
        try{
            return template.queryForObject(sqlMap.get("selectByUserName"),new BeanPropertyRowMapper<UserInfo>(UserInfo.class),username);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
