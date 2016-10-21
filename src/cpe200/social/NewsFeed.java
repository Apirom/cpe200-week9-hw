package cpe200.social;

import java.util.ArrayList;


public class NewsFeed implements ISearchable {
    private String feedname;
    private ArrayList<Post> posts;

    public NewsFeed(String name) {
        feedname = name;
        posts = new ArrayList<Post>();
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void deletePost(Post post) {
        posts.remove(post);
    }

    public String getFeedName() {
        return this.feedname;
    }

    public Post getPost(int i) {
        if (i >= 0 && i < posts.size())
            return posts.get(i);
        return null;
    }

    public void displayFeed() {

        for (int post_id = 0; post_id < posts.size(); post_id++) {
            displayPost(post_id);
        }

    }

    public void displayPost(int post_id) {
        if (post_id > -1 && post_id < posts.size()) {
            Post p = posts.get(post_id);

            System.out.println("<---------- Post(" + (post_id+1) + ") ---------->");

            if (p instanceof MessagePost) {
                MessagePost mp = (MessagePost) p;
                mp.display();
            }

            if (p instanceof PhotoPost) {
                PhotoPost pp = (PhotoPost) p;
                pp.display();
            }
        }
    }

    @Override
    public int searchItem(String s) {
        // search post by "post message' or "photo's caption"
        for (int i = 0; i < posts.size(); i++) {
            Post p = posts.get(i);

            if (p instanceof MessagePost) {
                MessagePost mp = (MessagePost) p;
                if (mp.containString(s))
                    return i;
            }

            if (p instanceof PhotoPost) {
                PhotoPost pp = (PhotoPost) p;
                if (pp.containString(s))
                    return i;
            }

        }
        return -1;
    }

    @Override
    public boolean deleteItem(String s) {
        // delete post by "post message" or "photo's caption"
        int post_id = searchItem(s);

        if (post_id > -1) {
            posts.remove(post_id);
            return true;
        }

        return false;
    }
}
