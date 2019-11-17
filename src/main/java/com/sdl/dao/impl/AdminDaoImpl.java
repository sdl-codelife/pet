package com.sdl.dao.impl;

import com.sdl.dao.AdminDao;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import com.sdl.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    List<SUserInfo> infoList = new ArrayList<SUserInfo>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    boolean a;
    int b;
    @Override
    public User findUser(String userName, String userPassWord) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_user where username = ? and userpassword = ?";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassWord);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                Integer userId = rs.getInt("userid");
                String userType = rs.getString("usertype");
                User user = new User(userId,userType,userName,userPassWord);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("close");
            DBUtil.close(rs,preparedStatement,connection);
        }
        return null;
    }

    @Override
    public UserInfo findUserInfo(int userId) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_userinfo where userid = ? ";
            System.out.println(sql);
            System.out.println(userId);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                Integer infoId =rs.getInt("infoid");
                String userSex = rs.getString("usersex");
                String userTel = rs.getString("usertel");
                String userQQ = rs.getString("userqq");
                String userNote = rs.getString("usernote");
                UserInfo userInfo = new UserInfo(infoId, userSex, userTel, userQQ, userNote, userId);
                return userInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,preparedStatement,connection);
        }
        return null;
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        try {
            connection = DBUtil.getConnection();
            String sql = "update t_userinfo set usersex = ?,usertel = ?,userqq = ?,usernote = ? where userid = ? ";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userInfo.getUserSex());
            preparedStatement.setString(2, userInfo.getUserTel());
            preparedStatement.setString(3, userInfo.getUserQQ());
            preparedStatement.setString(4, userInfo.getUserNote());
            preparedStatement.setInt(5, userInfo.getUserId());
            b = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,preparedStatement,connection);
        }
        return b;
    }

    @Override
    public int updateUserPassword(User user) {
        try {
            connection = DBUtil.getConnection();
            String sql = "update t_user set username = ?,userpassword = ? where userid = ? ";
            System.out.println(sql);
            System.out.println(user.getUserName());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setInt(3, user.getUserId());
            b = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,preparedStatement,connection);
        }
        return b;
    }

    @Override
    public List<SUserInfo> findAllUserInfo(String userType) {
        try {

            connection = DBUtil.getConnection();
            String sql = "select t.userid,usertype,username,usersex,usertel,userqq from t_user as s,t_userinfo as t where s.userid = t.userid and usertype= ?";
            System.out.println(sql);
            System.out.println(userType);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userType);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                int cout = 0;
                int auserId = rs.getInt("userid");
                String auserType = rs.getString("usertype");
                String ausername = rs.getString("username");
                String ausersex = rs.getString("usersex");
                String ausertel = rs.getString("usertel");
                String auserqq = rs.getString("userqq");
                SUserInfo sUserInfo = new SUserInfo(auserId,auserType,ausername,ausersex,ausertel,auserqq);
                System.out.println(sUserInfo);
                infoList.add(sUserInfo);
            }
            return infoList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,preparedStatement,connection);
        }
        return null;
    }

    @Override
    public int delUser(int userId) {
        try {
            connection = DBUtil.getConnection();
            String sql = "DELETE from t_user WHERE userid = ?";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            b = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,preparedStatement,connection);
        }
        return b;
    }

    @Override
    public int addUser(User user) {
        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT t_user (userid,usertype,username,userpassword) VALUES(?,?,?,?)";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setString(2, user.getUserType());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getUserPassword());
            b = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return b;
    }

    @Override
    public int addUserInfo(int userId, UserInfo userInfo) {
        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT t_userinfo (usersex,usertel,userqq,usernote,userid) VALUES(?,?,?,?,?)";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userInfo.getUserSex());
            preparedStatement.setString(2, userInfo.getUserTel());
            preparedStatement.setString(3, userInfo.getUserQQ());
            preparedStatement.setString(4, userInfo.getUserNote());
            preparedStatement.setInt(5, userId);
            b = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, preparedStatement, connection);
        }
        return b;
    }
}

