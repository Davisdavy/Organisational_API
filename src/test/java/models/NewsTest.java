package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void NewsInstantiatesCorrectly() throws Exception{
        News news = setupNews();
        assertTrue(news instanceof News);
    }

    @Test
    public void getNewsNameReturnsCorrectName() throws Exception {
        News testNews = setupNews();
        assertEquals("Rescues", testNews.getNews_name());
    }
    @Test
    public void setNewsId() throws Exception{
        News news = setupNews();
        news.setNews_id(1);
        assertNotEquals(3,news.getNews_id());
    }
    @Test
    public void NewsInstantiatesCorrectlyWithCorrect_Values() throws Exception{
        News news = setupNews();
        assertEquals("Rescues",news.getNews_name());
        assertEquals("Fire Department Rescues six",news.getNews_content());
        assertEquals(1,news.getDpt_id());
    }

    public News setupNews() {
        return new News(1, "Rescues", "Fire Department Rescues six");
    }
}