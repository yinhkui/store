package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    void printContext() {
        System.out.println(function(100));
    }

    long function(long x) {
        if (x <= 1 ) return x;
        long left = 0;
        long right =x;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            long s = mid * mid;
            if ( s > x ) {
                right = (mid - 1);
            } else if ( s < x ) {
                if ((mid + 1) * (mid + 1) > x) {
                    return mid;
                }
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
