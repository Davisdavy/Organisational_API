package dao;

import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private static Connection conn;
    private static Sql2oNewsDao newsDao;
    private static Sql2oDepartmentsDao departmentsDao;

    public News setupNews(){
        return new News(1,"Power Outage","Power outage in various states");
    }

    @Before
    public void setUp() throws Exception {
        String connectingString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectingString,"","");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    //Add news
    @Test
    public void addNews() throws Exception{
        News testNews = setupNews();
        newsDao.add(testNews);
        int newId = testNews.getNews_id();
        assertEquals(newId,testNews.getNews_id());
    }







}