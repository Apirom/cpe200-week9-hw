package cpe200.social;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FeedManagementTest {

    private FeedManagement fm = new FeedManagement();

    @Before
    public void setup() throws Exception {
        fm.addFeed("OOP");
        fm.addFeed("Web Dev");
        fm.addFeed("OOP");

        fm.addMessagePost(0,"Java?","user1");
        fm.addPhotoPost(0,"csharp.png","What about C#", "user2");
        fm.addMessagePost(0,"C++","user2");
        fm.addMessagePost(0,"Python","user1");

        // addComment() expect one-index value
        fm.addComment(0+1, 1+1, "yes, C#");
        fm.addComment(0+1, 3+1, "python has hugh libraries");
        fm.addComment(0+1, 3+1, "i agree");

        // likePost() expect one-index value
        fm.likePost(0+1, 2+1); fm.likePost(0+1, 1+1); fm.likePost(0+1, 1+1);

        fm.addMessagePost(1,"Flask Framework","user3");
        fm.addMessagePost(1,"ruby on rails","user3");
        fm.addPhotoPost(1,"angular0.png","AngularJS for sure", "user4");

        // addComment() expect one-index value
        fm.addComment(1+1, 1+1, "any idea on ruby");
        fm.addComment(1+1, 2+1, "angular if you want good performance");
        fm.addComment(1+1, 2+1, "i agree");

        // likePost() expect one-index value
        fm.likePost(1+1, 2+1);
        fm.likePost(1+1, 2+1);
        fm.likePost(1+1, 0+1);
    }

    @Test
    public void deleteFeed() throws Exception {
        Assert.assertEquals(2, fm.getSize());
        fm.deleteItem("OOP");
        Assert.assertEquals(1, fm.getSize());
        Assert.assertEquals("Web Dev",fm.getFeed(0).getFeedName());

    }

    @Test
    public void addMessagePost() throws Exception {
        Assert.assertEquals("Python", ((MessagePost) fm.getFeed(0).getPost(3)).getMessage());
        Assert.assertEquals("ruby on rails", ((MessagePost) fm.getFeed(1).getPost(1)).getMessage());
    }

    @Test
    public void addPhotoPost() throws Exception {
        Assert.assertEquals("What about C#", ((PhotoPost) fm.getFeed(0).getPost(1)).getCaption());
        Assert.assertEquals("angular0.png", ((PhotoPost) fm.getFeed(1).getPost(2)).getFilename());
    }

    @Test
    public void deletePost() throws Exception {
        Assert.assertFalse(fm.deletePost(0,"Python!!!"));
        Assert.assertTrue(fm.deletePost(0,"python"));
        Assert.assertFalse(fm.deletePost(1,"angular.png"));
        Assert.assertTrue(fm.deletePost(1,"angular0.png"));

        Assert.assertEquals(3, fm.getFeed(0).getPosts().size());
        Assert.assertEquals(2, fm.getFeed(1).getPosts().size());

    }

    @Test
    public void searchItem() throws Exception {
        Assert.assertEquals(-1, fm.searchItem("oops"));
        Assert.assertEquals(0, fm.searchItem("oop"));
        Assert.assertEquals(-1, fm.searchItem("web"));
        Assert.assertEquals(1, fm.searchItem("web dev"));

    }

    @Test
    public void addComment() throws Exception {
        Assert.assertEquals("i agree", fm.getFeed(0).getPost(3).getComments().get(1));
        Assert.assertEquals("i agree", fm.getFeed(1).getPost(2).getComments().get(1));
    }

    @Test
    public void deleteItem() throws Exception {
        Assert.assertFalse(fm.deleteItem("oops"));
        Assert.assertTrue(fm.deleteItem("web dev"));
        Assert.assertFalse(fm.deleteItem("web dev"));
        Assert.assertTrue(fm.deleteItem("oop"));
    }



}