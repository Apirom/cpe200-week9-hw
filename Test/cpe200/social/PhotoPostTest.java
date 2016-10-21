package cpe200.social;

import org.junit.Assert;
import org.junit.Test;

public class PhotoPostTest {

    @Test
    public void containString() throws Exception {
        PhotoPost pp = new PhotoPost("username", "git1.jpg", "GitHub is great");
        Assert.assertTrue(pp.containString("git1.jpg"));
        Assert.assertTrue(pp.containString("git1.JPG"));
        Assert.assertFalse(pp.containString("git1.png"));
        Assert.assertFalse(pp.containString("git1.bmp"));

        Assert.assertTrue(pp.containString("github is great"));
        Assert.assertTrue(pp.containString("GIThub is Great"));
        Assert.assertFalse(pp.containString("github great"));
        Assert.assertFalse(pp.containString("git hub is great"));
    }

    @Test
    public void addCommentandLike() throws Exception {
        PhotoPost pp = new PhotoPost("user2", "github1.png", "Definitely Github");
        pp.addlike();
        pp.addComment("commit heroku master!!!");
        pp.addComment("very easy way to deploy");

        Assert.assertEquals(1, pp.likes);
        Assert.assertEquals("very easy way to deploy", pp.getComments().get(1));
    }

}