package com.sdl.dao.impl;

import com.sdl.dao.UserDao;
import com.sdl.entity.Pet;
import com.sdl.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    boolean a;

    @Override
    public boolean addPet(Pet pet) {
        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT t_pet (petname,petbreed,petsex,petage,petweight,userid) VALUES(?,?,?,?,?,?)";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pet.getPetName());
            preparedStatement.setString(2, pet.getPetBreed());
            preparedStatement.setString(3, pet.getPetSex());
            preparedStatement.setString(4, pet.getPetAge());
            preparedStatement.setString(5, pet.getPetWeight());
            preparedStatement.setInt(6, pet.getUserId());
            a = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return a;
    }
}
