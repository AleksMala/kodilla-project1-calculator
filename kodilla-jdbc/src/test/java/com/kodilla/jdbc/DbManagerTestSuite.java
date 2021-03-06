package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    private static int count = 0;

    @Before
    public void execute() {
        count++;
        System.out.println("Test " + count);
    }

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersWithMoreThanTwoPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER FROM USERS U, POSTS P " +
                "WHERE P.USER_ID = U.ID " +
                "GROUP BY P.USER_ID " +
                "HAVING COUNT(*) > 1 " +
                "ORDER BY U.LASTNAME, U.FIRSTNAME";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sqlQuery);
        //Then
        int count = 0;
        while (result.next()) {
            System.out.println(result.getString("FIRSTNAME") + " " +
                    result.getString("LASTNAME") + ", number of posts: " +
                    result.getInt("POSTS_NUMBER"));
            count++;
        }
        result.close();
        statement.close();
        Assert.assertEquals(2, count);
    }
}