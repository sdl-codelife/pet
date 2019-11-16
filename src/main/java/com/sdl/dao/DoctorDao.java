package com.sdl.dao;

import com.sdl.entity.Description;
import com.sdl.util.SelectPet;

import java.util.List;

public interface DoctorDao {
    /**
     * 获取所有未/已诊断的挂号单
     *
     * @param resoved
     * @return
     */
    public List<Description> getDescription(int resoved);

    /**
     * 更新挂号单
     *
     * @param description
     * @return
     */
    public int updateDescript(Description description);
}
