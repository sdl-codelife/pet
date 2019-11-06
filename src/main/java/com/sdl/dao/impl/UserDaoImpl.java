package com.sdl.dao.impl;

import com.sdl.dao.UserDao;
import com.sdl.entity.Description;
import com.sdl.entity.Pet;
import com.sdl.util.DBUtil;
import com.sdl.util.SelectPet;
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
    List<SelectPet> Selectlist = new ArrayList<SelectPet>();
    List<Description> descriptions = new ArrayList<Description>();
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

    @Override
    public List<SelectPet> Selectlist(int userId) {
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
                SelectPet selectlist = new SelectPet(petName, petId);
                Selectlist.add(selectlist);
            }
            return Selectlist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public Pet selectPet(int petId) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_pet where petid =?";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, petId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("userid");
                String petName = rs.getString("petname");
                String petBreed = rs.getString("petbreed");
                String petSex = rs.getString("petsex");
                String petAge = rs.getString("petage");
                String petWeight = rs.getString("petweight");
                Pet pet = new Pet(petId, petName, petBreed, petSex, petAge, petWeight, userId);
                System.out.println(pet);
                return pet;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public boolean creatDescription(Description description) {
        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT t_description (did,date,petname,description,result,petid,userid) VALUES(?,?,?,?,?,?,?)";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, description.getdId());
            preparedStatement.setString(2, description.getDate());
            preparedStatement.setString(3, description.getPetName());
            preparedStatement.setString(4, description.getDescription());
            preparedStatement.setString(5, description.getResult());
            preparedStatement.setInt(6, description.getPetId());
            preparedStatement.setInt(7, description.getUserId());
            a = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return a;
    }

    @Override
    public List<Description> getDescription(int userId) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_description where userid =?";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int dId = rs.getInt("did");
                String date = rs.getString("date");
                String petName = rs.getString("petname");
                String description = rs.getString("description");
                String result = rs.getString("result");
                int resoved = rs.getInt("resoved");
                int petId = rs.getInt("petid");
                Description descriptionl = new Description(dId, date, petName, description, result, resoved, petId, userId);
                descriptions.add(descriptionl);
            }
            return descriptions;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public Description getaDescription(int petId) {
        Description descriptionl = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_description where petid =?";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, petId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int dId = rs.getInt("did");
                String date = rs.getString("date");
                String petName = rs.getString("petname");
                String description = rs.getString("description");
                String result = rs.getString("result");
                int resoved = rs.getInt("resoved");
                int userId = rs.getInt("userid");
                descriptionl = new Description(dId, date, petName, description, result, resoved, petId, userId);
            }
            return descriptionl;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return null;
    }
}
