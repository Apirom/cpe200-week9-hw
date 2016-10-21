package cpe200.social;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FeedManagementApp {

    public static void main(String args []) {

        FeedManagement fm = new FeedManagement();
        int choice;

        while (true) {
            try {
                choice = chooseFromMenu();
            } catch (InputMismatchException e) {
                System.out.println("\tWrong input, try again");
                choice = 100;
            }

            switch (choice) {
                case 1:
                    displayAllFeeds(fm); // display all NewsFeeds
                    break;
                case 2:
                    displayFeed(fm);    // display a NewsFeed and its posts
                    break;
                case 3:
                    displayPost(fm);    // display a single post in a NewsFeed
                    break;
                case 4:
                    createFeed(fm);    // create a NewsFeed
                    break;
                case 5:
                    deleteFeed(fm);    // delete a NewsFeed
                    break;
                case 6:
                    addPost(fm); // add a MessagePost to a NewsFeed
                    break;
                case 7:
                    deletePost(fm);   // add a PhotoPost to a NewsFeed
                    break;
                case 8:
                    addComment(fm);     // delete a Post from a NewsFeed
                    break;
                case 9:
                    likePost(fm);
                    break;
                default:
                    break;
            }

            if (choice == 10)
                break;
        }
    }

    private static int chooseFromMenu() throws InputMismatchException {

        Scanner sc = new Scanner(System.in);

        String m = "\n+++++++++++++++++++++++++++++++++ News Feed Management +++++++++++++++++++++++++++++++++ \n"
                + "\t1) Display feeds\t 2) Display a feed\t 3) Display a post\n"
                + "\t4) Create feed\t\t 5) Delete feed\n"
                + "\t6) Add a post\t\t 7) Delete a post\n"
                + "\t8) Add comment\t\t 9) Like a post\n"
                + "\t10) Exit\n"
                + "\tYour choice: ";

        System.out.print(m);

        return sc.nextInt();
    }

    private static void displayAllFeeds(FeedManagement fm) {
        System.out.println("\n++++++++++++++++++++ Display all feeds ++++++++++++++++++++");
        if (fm.getSize()>0) {
            fm.displayAllFeeds();
        } else {
            System.out.println("\tNo feed available!");
        }
    }

    private static void displayFeed(FeedManagement fm) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++ Display a feed ++++++++++++++++++++");
        if (fm.getSize()>0) {
            System.out.print("\tFeed id: ");
            int feed_id = s.nextInt();
            fm.displayFeed(feed_id);
        } else {
            System.out.println("\tNo feed available!");
        }
    }

    private static void displayPost(FeedManagement fm) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++ Display a post ++++++++++++++++++++");
        if (fm.getSize()>0) {
            System.out.print("\tFeed id: ");
            int feed_id = s.nextInt();
            System.out.print("\tPost id: ");
            int post_id = s.nextInt();
            fm.displayPost(feed_id, post_id);
        } else {
            System.out.println("\tNo feed available!");
        }
    }

    private static void createFeed(FeedManagement fm) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++ Adding Feed ++++++++++++++++++++");
        System.out.print("\tAdd feed topic: ");
        String topic = s.nextLine();

        if (fm.addFeed(topic))
            System.out.println("\tFeed with the topic '" + topic + "' has been created.\n");
        else
            System.out.println("\tCannot create the feed.\n");

    }

    private static void deleteFeed(FeedManagement fm) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++ Deleting Feed ++++++++++++++++++++");
        if (fm.getSize()>0) {
            System.out.print("\tDelete feed topic: ");
            String topic = s.nextLine();

            if (fm.deleteFeed(topic))
                System.out.println("\tFeed with the topic '" + topic + "' has been removed.\n");
            else
                System.out.println("\tCannot delete the feed.\n");
        } else {
            System.out.println("\tNo feed available!");
        }

    }

    private static void addPost(FeedManagement fm) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++ Adding post ++++++++++++++++++++");
        System.out.print("\tAdd a post to the feed: ");
        String topic = s.nextLine();

        // search feed by feed name (topic) to add a post
        int topic_id = fm.searchItem(topic);

        System.out.print("\tMessage(1) or Photo(2) post: ");
        int post_type;
        try {
            post_type = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\tWrong input, adding Message post by default");
            post_type = 1;
        }

        if (post_type != 2) {
            addMessagePost(fm, topic_id);
        } else {
            addPhotoPost(fm, topic_id);
        }
    }
    private static void addMessagePost(FeedManagement fm, int topic_id) {
        Scanner s = new Scanner(System.in);

        if (topic_id > -1) {
            System.out.print("\tMessage: ");
            String message = s.nextLine();
            System.out.print("\tUsername: ");
            String username = s.next();

            if (fm.addMessagePost(topic_id, message, username)) {
                System.out.println("\tMessage post added.\n");
            } else {
                System.out.println("\tCannot add post.\n");
            }
        } else {
            System.out.println("\tCannot find the topic.\n");
        }

    }

    private static void addPhotoPost(FeedManagement fm, int topic_id) {
        Scanner s = new Scanner(System.in);

        if (topic_id > -1) {
            System.out.print("\tPhoto filename (.jpg or .png): ");
            String filename = s.next(); s.nextLine();
            System.out.print("\tPhoto caption: ");
            String caption = s.nextLine();
            System.out.print("\tUsername: ");
            String username = s.next();

            if (fm.addPhotoPost(topic_id, filename, caption, username)) {
                System.out.println("\tPhoto post added.\n");
            } else {
                System.out.println("\tCannot add post.\n");
            }
        } else {
            System.out.println("\tCannot find the topic.\n");
        }

    }

    private static void deletePost(FeedManagement fm) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++ Deleting a post ++++++++++++++++++++");
        System.out.print("\tDelete a post from the feed: ");
        String topic = s.nextLine();

        // search feed by feed name (topic) to delete a post
        int topic_id = fm.searchItem(topic);

        if (topic_id > -1) {
            System.out.print("\tPost's message or caption or filename: ");
            String str = s.nextLine();

            if (fm.deletePost(topic_id, str))
                System.out.println("\tPost containing '" + str + "' has been removed.\n");
            else
                System.out.println("\tCannot delete '" + str + "' post.\n");

        } else {
            System.out.println("\tCannot find the post '" + s + "'.\n");
        }

    }

    private static void addComment(FeedManagement fm) {
        Scanner s = new Scanner(System.in);

        System.out.println("\n++++++++++++++++++++ Adding comment ++++++++++++++++++++");
        System.out.print("\tFeed id: "); int feed_id = s.nextInt();
        System.out.print("\tPost id: "); int post_id = s.nextInt(); s.nextLine();
        System.out.print("\tComment: "); String comment = s.nextLine();
        fm.addComment(feed_id, post_id, comment);
    }

    private static void likePost(FeedManagement fm) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n++++++++++++++++++++ Like a post ++++++++++++++++++++");
        System.out.print("\tFeed id: "); int feed_id = s.nextInt();
        System.out.print("\tPost id: "); int post_id = s.nextInt();
        fm.likePost(feed_id, post_id);
    }

}
