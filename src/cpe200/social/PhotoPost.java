package cpe200.social;

public class PhotoPost extends Post {
    private String filename;
    private String caption;

    public PhotoPost() {
        super();
        this.filename = null;
        this.caption = null;
    }

    public PhotoPost(String u) {
        super(u);
        this.filename = null;
        this.caption = null;
    }

    public PhotoPost(String u, String f, String c) {
        super(u);
        setFilename(f);
        setCaption(c);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = isValidateFile(filename)?filename:null;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = isValidateComment(caption)?caption:null;
    }

    private boolean isValidateFile(String f) {
        if (f == null)
            return false;

        if (f.toLowerCase().endsWith(".jpg") || f.toLowerCase().endsWith(".png"))
            return true;

        return false;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String o = this.username + " (posted: " + timestamp + ")\n";
        if (filename != null)
            o += "[ " + filename + " ]\n";

        if (caption != null)
            o += "Caption: " + caption + "\n";

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
