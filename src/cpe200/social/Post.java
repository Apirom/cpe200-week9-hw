package cpe200.social;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Post {
    protected String username;
    protected LocalDateTime timestamp;
    protected int likes;
    protected ArrayList<String> comments;

    public Post() {
        this("anonymous");
    }

    public Post(String u) {
        this.username = isValidateUsername(u)?u:"anonymous";
        this.timestamp = LocalDateTime.now();
        this.likes = 0;
        this.comments = new ArrayList<String>();
    }

    public boolean addComment(String c) {
        if (isValidateComment(c)) {
            this.comments.add(c);
            return true;
        }
        return false;
    }

    public void addlike() {
        likes++;
    }

    public boolean removeComment(String c) {
        if (this.comments.contains(c)) {
            this.comments.remove(c);
            return true;
        }
        return false;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    private boolean isValidateUsername(String u) {
        if (u == null)
            return false;
        else
            return true;
    }

    protected boolean isValidateComment(String c) {
        return (c==null || c.equalsIgnoreCase(""))?false:true;
    }

    public void display() {
        System.out.print(toString());
    }

    @Override
    public String toString() {
        String o = this.username + " (posted: " + timestamp + ")\n";
        o += likes + " people like this.\n";

        if (comments.size()>0) {
            for (String c : comments) {
                o += "\t- " + c + "\n";
            }
        } else {
            o += "\tNo comments.\n";
        }

        return o;
    }

    /*
        A method to check if the post object contains the specified string.
        This method will be implemented in subclasses. Each subclass can
        implements this method differently
     */
    public abstract boolean containString(String s);

}
