package com.etc.pfs.dao;

import com.etc.pfs.entity.SubJect;
import com.etc.pfs.util.JDBCUtils;
import com.etc.pfs.util.LoadXMLUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class SubJectDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private Map<String,String> sqlMap = LoadXMLUtil.loadMapper(SubJect.class);

    /**
     * 新增科目
     * @param subJect
     */
    public Integer insertSubJect(SubJect subJect){
        return template.update(sqlMap.get("insert"),subJect.getId(),subJect.getS_name());
    }

    /**
     * 更新科目
     * @param subJect
     * @return
     */
    public Integer updateSubJect(SubJect subJect){
        return template.update(sqlMap.get("update"),subJect.getS_name(),subJect.getId());
    }

    /**
     * 根据id删除科目
     * @param id
     * @return
     */
    public Integer deleteSubject(String id){
        return template.update(sqlMap.get("delete"),id);
    }


    /**
     * 查询所有科目
     * @return
     */
    public List<SubJect> selectAllSubject(){
        return template.query(sqlMap.get("selectAllSubject"),new BeanPropertyRowMapper<SubJect>(SubJect.class));
    }
}
