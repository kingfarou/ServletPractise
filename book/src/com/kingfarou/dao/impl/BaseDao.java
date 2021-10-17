package com.kingfarou.dao.impl;

import com.kingfarou.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {

    private static QueryRunner queryRunner = new QueryRunner();

    public static int update(String sql, String ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            int row = queryRunner.update(connection, sql, args);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            JdbcUtils.close(connection);
        }
    }

    public static <T> T queryForOne(Class<T> type, String sql, Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
        }
    }

    public static <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
        }
    }

    public static Object queryForSingleValue(String sql, Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
        }
    }
}
