package com.beluga.dao.impl;

import com.beluga.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Beluga
 * @createTime 2022/8/9 -- 21:30
 */
public abstract class BaseDao {
    //使用dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * INSERT UPDATE DELETE
     * @param sql   sql语句
     * @param args  参数表
     * @return -1：执行失败； 其他为影响行数
     */
    public int update(String sql, Object ... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询单个对象
     * @param type  返回对象的类型
     * @param sql   查询语句
     * @param args  参数列表
     * @param <T>   返回的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     *
     * 获取参数列表
     * @param type 类型泛型
     * @param sql   sql语句
     * @param args  参数列表
     * @param <T>   返回的参数类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的查询
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
