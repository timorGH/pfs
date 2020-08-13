package com.etc.pfs.service.impl;

import com.etc.pfs.dao.SubJectDao;
import com.etc.pfs.entity.SubJect;
import com.etc.pfs.service.SubJectService;

import java.util.List;

public class SubJectServiceImpl implements SubJectService {
    private SubJectDao subJectDao = new SubJectDao();

    @Override
    public Integer insertSubJect(SubJect subJect) {
        return subJectDao.insertSubJect(subJect);
    }

    @Override
    public Integer updateSubJect(SubJect subJect) {
        return subJectDao.updateSubJect(subJect);
    }

    @Override
    public Integer deleteSubJect(String id) {
        return subJectDao.deleteSubject(id);
    }

    @Override
    public List<SubJect> selectAllSubject() {
        return subJectDao.selectAllSubject();
    }
}
