package com.sdl.dao.impl;

import com.sdl.dao.UserDao;
import com.sdl.entity.Pet;
import com.sdl.entity.SUserInfo;
import com.sdl.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    boolean a;
    List<Pet> petlist = new ArrayList<Pet>();
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

    @Override
    public List<Pet> petList(int userId) {
        try {

            connection = DBUtil.getConnection();
            String sql = "select * from t_pet where userId =?";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int petId = rs.getInt("petid");
                String petName = rs.getString("petname");
                String petBreed = rs.getString("petbreed");
                String petSex = rs.getString("petsex");
                String petAge = rs.getString("petage");
                String petWeight = rs.getString("petweight");
                Pet pet = new Pet(petId, petName, petBreed, petSex, petAge, petWeight, userId);
                System.out.println(pet);
                petlist.add(pet);
            }
            return petlist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public boolean delPet(int petId) {
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from t_pet where petid =?";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, petId);
            a = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return a;
    }

    @Override
    public boolean updatePet(Pet pet) {
        try {
            connection = DBUtil.getConnection();
            String sql = "update t_pet set petname = ?,petbreed = ?,petsex = ?,petage = ?,petweight =?  where petid = ? ";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pet.getPetName());
            preparedStatement.setString(2, pet.getPetBreed());
            preparedStatement.setString(3, pet.getPetSex());
            preparedStatement.setString(4, pet.getPetAge());
            preparedStatement.setString(5, pet.getPetWeight());
            preparedStatement.setInt(6, pet.getPetId());
            a = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return a;
    }
}
