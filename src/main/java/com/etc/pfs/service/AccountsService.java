package com.etc.pfs.service;

import com.etc.pfs.entity.Accounts;
import com.etc.pfs.entity.PageInfo;
import com.etc.pfs.entity.Remark;

import java.util.List;
import java.util.Map;

public interface AccountsService {
    /**
     * 新增消费记录
     * @param accounts
     * @return
     */
    public Integer insertAccounts(com.etc.pfs.entity.Accounts accounts);

    /**
     * 修改消费记录
     * @param accounts
     * @return
     */
    public Integer updateAccounts(com.etc.pfs.entity.Accounts accounts);

    /**
     * 根据id删除消费记录
     * @param id
     * @return
     */
    public Integer deleteAccounts(String id);

    /**
     * 根据id查询单个消费记录
     * @param id
     * @return
     */
    public Accounts selectAccountsById(String id);

    /**
     * 登录用户的收入支出记录
     * @param icategory
     * @param username
     * @return
     */
    public List<Accounts> selectAllIcategory(String icategory, String username);

    /**
     * 分页查询登录用户的收入支出
     * @param icategory
     * @param username
     * @return
     */
    public PageInfo<Accounts> selectAllIcategory(String icategory, String username,String start,String rows);

    /**
     * 分页条件查询登录用户的收入支出
     * @param icategory
     * @param username
     * @return
     */
    public PageInfo<Accounts> selectAllIcategory(String icategory, String username,String start,String rows,Map<String, String[]> condition);

    /**
     * 登录用户的近期总收入支出
     * @param username
     * @param time
     * @param nowTime
     * @return
     */
    public Float selectSumByIcategory(String icategory, String username, String time, String nowTime);

    /**
     * 获取登录用户近期每个类的个数
     * @param classif
     * @param username
     * @param time
     * @param nowTime
     * @return
     */
    public Integer selectCountByClassif(String classif, String username, String time,String nowTime);

    /**
     * 获取登录用户近期收入支出的个数
     * @param icategory
     * @param username
     * @param time
     * @param nowTime
     * @return
     */
    public Integer selectCountByIcateGory(String icategory, String username, String time, String nowTime);

    /**
     * 获取登录用户收入支出的个数
     * @param icategory
     * @param username
     * @return
     */
    public Integer selectCountAccountsByIcategory(String icategory,String username);



    /**
     * 获取特定分类的总记录数
     * @param classif
     * @return
     */
    public Integer selectCountRemarkByClassif(String classif,String username);

    /**
     * 获取特定分类的比例
     * @param classif
     * @param start
     * @param rows
     * @return
     */
    public List<Remark> selectClassif(String classif,String username,Integer start, Integer rows);

    /**
     * 分页关键字查询
     * @param start
     * @param rows
     * @return
     */
    PageInfo<Remark> findAccountsByPage(String start, String rows, String classif,String username);
}
