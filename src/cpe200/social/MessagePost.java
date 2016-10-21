package cpe200.social;

public class MessagePost extends Post {
    private String message;

    public MessagePost() {
        super();
        this.message = null;
    }

    public MessagePost(String u) {
        super(u);
        this.message = null;
    }

    public MessagePost(String u, String m) {
        super(u);
        this.message = m;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String o = this.username + " (posted: " + timestamp + ")\n";
        if (message != null)
            o += "Message: " + message + "\n";

        o += likes + " people like this.\n";

        if (comments.size()>0) {
            for (String c : comments) {
                o += "\t" + c + "\n";
            }
        } else {
            o += "\tNo comments.";
        }

        return o;
    }

}
