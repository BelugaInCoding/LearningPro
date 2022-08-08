package com.beluga.test;

import com.beluga.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Beluga
 * @createTime 2022/8/7 -- 23:26
 */
public class JdbcUtilsTest {

    @Test
    public void  test(){
        for(int i =0 ; i<30; i++){
            // 拿了之后释放 下次循环还拿这个
            Connection conn = JdbcUtils.getConnection();
            System.out.println(i+"--- testGet:"+conn);
            JdbcUtils.close(conn);
        }
    }

}
