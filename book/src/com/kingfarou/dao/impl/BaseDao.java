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

public abstract class BaseDao {

    private static QueryRunner queryRunner = new QueryRunner();

    /**
     * 增删改操作
     * @param sql
     * @param args
     * @return -1:改动数据失败；成功则返回影响行数
     */
    public static int update(String sql, Object ...args){
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

    /**
     * 查询一个对象
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return null：查询失败；成功则返回查询结果
     */
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

    /**
     * 查询集合
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return null：查询失败；成功则返回查询结果
     */
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

    /**
     * 服务于类似select count(*)、select min(columnName)等操作
     * @param sql
     * @param args
     * @return null：查询失败；成功则返回查询结果
     */
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
