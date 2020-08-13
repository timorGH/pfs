package com.etc.pfs.service.impl;

import com.etc.pfs.dao.UserInfoDao;
import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao = new UserInfoDao();

    @Override
    public Integer inseratUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public Integer deleteUserInfo(String id) {
        return userInfoDao.deleteUserInfo(id);
    }

    @Override
    public UserInfo loginUserInfo(UserInfo userInfo) {
        return userInfoDao.loginUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return userInfoDao.getUserInfoById(id);
    }

    @Override
    public UserInfo getUserInfoByUserName(String username) {
        return userInfoDao.getUserInfoByUserName(username);
    }
}
