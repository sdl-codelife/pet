package com.sdl.dao;

import com.sdl.entity.Pet;

import java.util.List;

public interface UserDao {
    /**
     * 添加宠物
     *
     * @return
     */
    public boolean addPet(Pet pet);

    /**
     * 查看某人的所有宠物
     *
     * @param userId
     * @return
     */
    public List<Pet> petList(int userId);

    /**
     * 根据petid删除宠物
     *
     * @param petId
     * @return
     */
    public boolean delPet(int petId);

    /**
     * 更新宠物信息
     *
     * @param pet
     * @return
     */
    public boolean updatePet(Pet pet);
}
