package com.sdl.dao;

import com.sdl.entity.Pet;

public interface UserDao {
    /**
     * 添加宠物
     *
     * @return
     */
    public boolean addPet(Pet pet);
}
