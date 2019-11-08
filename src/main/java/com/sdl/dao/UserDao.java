package com.sdl.dao;

import com.sdl.entity.Description;
import com.sdl.entity.Pet;
import com.sdl.util.SelectPet;

import java.util.List;

public interface UserDao {
    /**
     * 添加宠物
     *
     * @return
     */
    public int addPet(Pet pet);

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
    public int delPet(int petId);

    /**
     * 更新宠物信息
     *
     * @param pet
     * @return
     */
    public int updatePet(Pet pet);

    /**
     * 挂号功能宠物下拉选择实现
     *
     * @param userId
     * @return
     */
    public List<SelectPet> Selectlist(int userId);

    /**
     * 根据petId查找宠物
     *
     * @param petId
     * @return
     */
    public Pet selectPet(int petId);

    /**
     * 创建挂号单
     *
     * @param description
     * @return
     */
    public int creatDescription(Description description);

    /**
     * 根据主人id获取所有挂号单
     *
     * @param userId
     * @return
     */
    public List<Description> getDescription(int userId);

    /**
     * 根据宠物id获取挂号单
     *
     * @param petId
     * @return
     */
    public Description getaDescription(int petId);

    /**
     * 根据挂号单id删除挂号单
     *
     * @param dId
     * @return
     */
    public int deldescriptForm(int dId);
}
