package com.sdl.dao.impl;

import com.sdl.dao.DoctorDao;
import com.sdl.entity.Description;
import com.sdl.util.DBUtil;
import com.sdl.util.SelectPet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Description> descriptions = new ArrayList<Description>();
    List<SelectPet> selectPets = new ArrayList<SelectPet>();

    @Override
    public List<Description> getDescription(int resoved) {
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_description where resoved = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, resoved);
            rs = ps.executeQuery();
            if (rs.next()) {
                int dId = rs.getInt("did");
                String date = rs.getString("date");
                String petName = rs.getString("petname");
                String description = rs.getString("description");
                String result = rs.getString("result");
                int petId = rs.getInt("petid");
                int userId = rs.getInt("userid");
                Description d = new Description(dId, date, petName, description, result, resoved, petId, userId);
                descriptions.add(d);
            }
            return descriptions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateDescript(Description description) {
        try {
            conn = DBUtil.getConnection();
            String sql = "update t_description set result = ?,resoved = ? where did = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, description.getResult());
            ps.setInt(2, 1);
            ps.setInt(3, description.getdId());
            int a = ps.executeUpdate();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
