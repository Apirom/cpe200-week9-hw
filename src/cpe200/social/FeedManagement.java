package cpe200.social;

import cpe200.util.PList;

public class FeedManagement implements ISearchable {

    private PList feeds;

    public FeedManagement() {
        feeds = new PList();
    }

    public int getSize() {
        return feeds.getSize();
    }

    public boolean addFeed(String topic) {

        return false;
    }

    public NewsFeed getFeed(int idx) {

        return null;
    }

    public boolean deleteFeed(String topic) {
        // delete feed by feed name
        return false;
    }

    public boolean addMessagePost(int feed_id, String message, String username) {
        boolean result = false;

        try {
            if (!username.equalsIgnoreCase("") && !message.equalsIgnoreCase("")) {


            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public boolean addPhotoPost(int feed_id, String filename, String caption, String username) {
        boolean result = false;


        return result;
    }

    public boolean deletePost(int feed_id, String str) {
        boolean result = false;

        return result;
    }



    public void displayAllFeeds() {

    }

    public void displayFeed(int feed_id) {

    }

    public void displayPost(int feed_id, int post_id) {

    }


    public void likePost(int feed_id, int post_id) {
        feed_id--; // change from one-indexed to zero-indexed
        post_id--;
        if (feed_id > -1 && feed_id<feeds.getSize()) {
            NewsFeed f = (NewsFeed) feeds.elementAt(feed_id);
            f.getPost(post_id).addlike();
        }
    }

    public void addComment(int feed_id, int post_id, String comment) {

    }
}
