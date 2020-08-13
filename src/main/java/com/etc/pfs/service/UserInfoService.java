package com.etc.pfs.service;

import com.etc.pfs.entity.UserInfo;

public interface UserInfoService {

    /**
     * 新增用户
     * @param userInfo
     */
    public Integer inseratUserInfo(UserInfo userInfo);


    /**
     * 根据id修改用户信息
     * @param userInfo
     * @return
     */
    public Integer updateUserInfo(UserInfo userInfo);


    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    public Integer deleteUserInfo(String id);


    /**
     * 登录校验
     * @param userInfo
     * @return
     */
    public UserInfo loginUserInfo(UserInfo userInfo);


    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    public UserInfo getUserInfoById(String id);


    /**
     * 根据username查询单个用户
     * @param username
     * @return
     */
    public UserInfo getUserInfoByUserName(String username);
}
