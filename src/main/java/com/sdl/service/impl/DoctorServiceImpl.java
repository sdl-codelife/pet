package com.sdl.service.impl;

import com.sdl.dao.DoctorDao;
import com.sdl.dao.impl.DoctorDaoImpl;
import com.sdl.entity.Description;
import com.sdl.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    DoctorDao doctorDao = new DoctorDaoImpl();

    @Override
    public List<Description> getDescription(int resoved) {
        return doctorDao.getDescription(resoved);
    }

    @Override
    public int updateDescript(Description description) {
        return doctorDao.updateDescript(description);
    }
}
