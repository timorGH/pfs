package com.etc.pfs.service;

import com.etc.pfs.entity.SubJect;

import java.util.List;

public interface SubJectService {

    /**
     * 新增科目
     * @param subJect
     * @return
     */
    Integer insertSubJect(SubJect subJect);

    /**
     * 修改科目
     * @param subJect
     * @return
     */
    Integer updateSubJect(SubJect subJect);

    /**
     * 根据id删除科目
     * @param id
     * @return
     */
    Integer deleteSubJect(String id);

    /**
     * 查询所有科目
     * @return
     */
    List<SubJect> selectAllSubject();
}
