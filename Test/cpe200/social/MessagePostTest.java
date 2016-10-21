package cpe200.social;

import org.junit.Assert;
import org.junit.Test;

public class MessagePostTest {

    @Test
    public void containString() throws Exception {
        MessagePost pp = new MessagePost("username", "How to use AngularJS?");

        Assert.assertTrue(pp.containString("how to use angularJS?"));
        Assert.assertTrue(pp.containString("How to use angularjs?"));
        Assert.assertFalse(pp.containString("How to use angularjs"));
        Assert.assertFalse(pp.containString("How to uses Angularjs?"));

    }

    @Test
    public void addComment() throws Exception {
        MessagePost pp = new MessagePost("username", "How to use AngularJS?");

        pp.addComment(null);
        Assert.assertEquals(0, pp.getComments().size());

        pp.addComment("");
        Assert.assertEquals(0, pp.getComments().size());

        pp.addComment("With love and patience.");
        pp.addComment("I want to know as well.");
        Assert.assertEquals(2, pp.getComments().size());
        Assert.assertEquals("I want to know as well.", pp.getComments().get(1));

    }

}