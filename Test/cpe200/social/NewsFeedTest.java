package cpe200.social;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewsFeedTest {

    private NewsFeed f = new NewsFeed("Web Dev");

    @Before
    public void setup() throws Exception {
        f.addPost(new MessagePost("user1", "Is it ok to use Laravel for PHP web app?"));
        f.addPost(new PhotoPost("user2", "github1.png", "Definitely Github"));

        f.getPost(0).addComment("Definitely!!!");
        f.getPost(0).addComment("Phalcon is faster");
        f.getPost(0).addComment("What about Angularjs and Nodejs");
        f.getPost(0).addlike(); f.getPost(0).addlike(); f.getPost(0).addlike();

        f.getPost(1).addlike();
        f.getPost(1).addComment("commit heroku master!!!");
        f.getPost(1).addComment("very easy way to deploy");

    }

    @Test
    public void addPost() throws Exception {
        Assert.assertEquals("user1",f.getPost(0).username);
        Assert.assertEquals(2,f.getPost(1).getComments().size());
        Assert.assertEquals(3,f.getPost(0).likes);
    }

    @Test
    public void searchItem() throws Exception {
        Assert.assertEquals(0, f.searchItem("is it ok to use laravel for php web app?"));
        Assert.assertEquals(1, f.searchItem("github1.png"));
    }

    @Test
    public void deleteItem() throws Exception {
        Assert.assertFalse(f.deleteItem("github1.jpg"));
        Assert.assertTrue(f.deleteItem("is it ok to use laravel for php web app?"));
        Assert.assertTrue(f.deleteItem("definitely github"));
    }

}