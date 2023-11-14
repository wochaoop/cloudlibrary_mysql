package com.itheima.cloudlibrary.dao.impl;

import com.itheima.cloudlibrary.dao.UserDao;
import com.itheima.cloudlibrary.domain.User;
import com.itheima.cloudlibrary.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


public class UserDaoImpl  implements UserDao {
    // 用户模块DAO的用户登录的方法:
    public User login(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //请补充SQL命令，实现登录时的用户名和密码核验
        String sql = "SELECT * FROM user WHERE email=? AND password=? AND status = ?";
        return qr.query(sql, new BeanHandler<User>(User.class),user.getEmail(), user.getPassword(), 0);
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM user WHERE username=? status = 0";
        return queryRunner.query(sql, new BeanHandler<User>(User.class), username);
    }

}
