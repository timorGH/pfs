package com.etc.pfs.dao;

import com.etc.pfs.entity.Accounts;
import com.etc.pfs.entity.Remark;
import com.etc.pfs.util.JDBCUtils;
import com.etc.pfs.util.LoadXMLUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private Map<String,String> sqlMap = LoadXMLUtil.loadMapper(Accounts.class);

    /**
     * 新增消费记录
     * @param accounts
     * @return
     */
    public Integer insertAccounts(Accounts accounts){
        return template.update(sqlMap.get("insert"),accounts.getId(),accounts.getIcategory(),accounts.getClassif(),accounts.getRemark(),accounts.getAddtime(),accounts.getUsername(),accounts.getMoney());
    }

    /**
     * 修改消费记录
     * @param accounts
     * @return
     */
    public Integer updateAccounts(Accounts accounts){
        return template.update(sqlMap.get("update"),accounts.getIcategory(),accounts.getClassif(),accounts.getRemark(),accounts.getAddtime(),accounts.getUsername(),accounts.getMoney(),accounts.getId());
    }

    /**
     * 根据id删除消费记录
     * @param id
     * @return
     */
    public Integer deleteAccounts(String id){
        return template.update(sqlMap.get("delete"),id);
    }


    /**
     * 根据id查询单个消费记录
     * @param id
     * @return
     */
    public Accounts selectAccountsById(String id){
        try{
            return template.queryForObject(sqlMap.get("selectAccountsById"),new BeanPropertyRowMapper<Accounts>(Accounts.class),id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 登录用户的收入支出
     * @param icategory
     * @param username
     * @return
     */
    public List<Accounts> selectAllIcategory(String icategory, String username,Integer start, Integer rows){
        return template.query(sqlMap.get("selectAllIcategory"),new BeanPropertyRowMapper<Accounts>(Accounts.class),icategory,username,start,rows);
    }

    /**
     * 登录用户的近期总收入支出
     * @param username
     * @param time
     * @param nowTime
     * @return
     */
    public Float selectSumByIcategory(String icategory, String username, String time, String nowTime){
        return template.queryForObject(sqlMap.get("selectSumByIcategory"),Float.class,icategory,username,time,nowTime);
    }

    /**
     * 获取登录用户近期每个类的个数
     * @param classif
     * @param username
     * @param time
     * @param nowTime
     * @return
     */
    public Integer selectCountByClassif(String classif, String username, String time,String nowTime){
        return template.queryForObject(sqlMap.get("selectCountByClassif"),Integer.class,classif,username,time,nowTime);
    }

    /**
     * 获取登录用户近期收入支出的个数
     * @param icategory
     * @param username
     * @param time
     * @param nowTime
     * @return
     */
    public Integer selectCountByIcateGory(String icategory, String username, String time, String nowTime){
        return template.queryForObject(sqlMap.get("selectCountByIcateGory"),Integer.class,icategory,username,time,nowTime);
    }

    /**
     * 获取登录用户收入支出总个数
     * @param icategory
     * @param username
     * @return
     */
    public Integer selectCountAccountsByIcateGory(String icategory, String username){
        return template.queryForObject(sqlMap.get("selectCountAccountsByIcateGory"),Integer.class,icategory,username);
    }

    /**
     * 获取条件登录用户收入支出总个数
     * @param icategory
     * @param username
     * @return
     */
    public Integer selectCountAccountsByIcateGory(String icategory, String username,Map<String, String[]> condition){
        String sql = "select count(id) from accounts where icategory = ? and username = ?";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> strings = condition.keySet();
        List<Object> params = new ArrayList<>();
        params.add(icategory);
        params.add(username);
        for (String key : strings) {
            if(!key.equals("pageNum") && !key.equals("rows") && !key.equals("id")){
                String value = condition.get(key)[0];
                if(!"".equals(value)){
                    sb.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");
                }
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    /**
     * 获取特定分类的总记录数
     * @param classif
     * @return
     */
    public Integer selectCountRemarkByClassif(String classif,String username){
        return template.queryForObject(sqlMap.get("selectCountRemarkByClassif"),Integer.class,classif,username);
    }


    /**
     * 查询登录用户的收入或支出记录
     * @param icategory
     * @param username
     * @return
     */
    public List<Accounts> selectAllAccounts(String icategory,String username){
        return template.query(sqlMap.get("selectAllAccounts"),new BeanPropertyRowMapper<Accounts>(Accounts.class),icategory,username);
    }

    /**
     * 分页查询收入或支出的记录
     * @param icategory
     * @param username
     * @param start
     * @param rows
     * @return
     */
    public List<Accounts> selectAllByIcateGory(String icategory, String username, Integer start, Integer rows){
        return template.query(sqlMap.get("selectAllIcategory") ,new BeanPropertyRowMapper<Accounts>(Accounts.class),icategory,username,start,rows);
    }

    /**
     * 分页条件查询收入或支出的记录
     * @param icategory
     * @param username
     * @param start
     * @param rows
     * @return
     */
    public List<Accounts> selectAllByIcateGory(String icategory, String username, Integer start, Integer rows,Map<String, String[]> condition){
        try{
            String sql = "select * from accounts where icategory = ? and username = ?";
            StringBuilder sb = new StringBuilder(sql);
            Set<String> strings = condition.keySet();
            List<Object> params = new ArrayList<>();
            params.add(icategory);
            params.add(username);
            for (String key : strings) {
                if(!key.equals("pageNum") && !key.equals("rows")){
                    String value = condition.get(key)[0];
                    if(!"".equals(value)){
                        sb.append(" and "+key+" like ?");
                        params.add("%"+value+"%");
                    }
                }
            }

            params.add(start);
            params.add(rows);
            sb.append(" limit ?,?");
            System.out.println(sb.toString());
            System.out.println(params);
            return template.query(sb.toString(),new BeanPropertyRowMapper<>(Accounts.class),params.toArray());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取特定分类的比例
     * @param classif
     * @param start
     * @param rows
     * @return
     */
    public List<Remark> selectClassif(String classif,String username,Integer start, Integer rows){
        try{
            return template.query(sqlMap.get("selectClassif"),new BeanPropertyRowMapper<Remark>(Remark.class),classif,classif,username,start,rows);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
