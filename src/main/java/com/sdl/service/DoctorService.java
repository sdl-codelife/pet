package com.sdl.service;

import com.sdl.entity.Description;

import java.util.List;

public interface DoctorService {
    public List<Description> getDescription(int resoved);

    public int updateDescript(Description description);
}
