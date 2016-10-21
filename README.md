# Week 9 - Homework: News Feed Management

This homework will help you learn how to solve problem with multiple Java classes.

The objectives of this week are following:
* Programming abstraction of "Feed Management System" with simple console UI.
* Learn to use 'abstract' class and abstract method
* Learn to use 'interface'
* Learn to use 'InputMismatchException' to handle wrong input type.
* Create Java archive (.jar) for Java console application.
* Run the Java application in command line interface (without the IDE).

Note: This project requires the 'cpe200-utils.jar' created from 'cpe200-utils' project
* https://github.com/cpe200-159-sec11/cpe200-util

##Post Abstract Class
* Modify the class to 'abstract' class.
* Add 'public abstract boolean containString(String)' method.
* Note: What would happen if we try to create objects of this class. 
    * Post p = new Post();

##MessagePost Class
* Implements the 'matchString(String)' abstract method.
* 'matchString()' returns TRUE if the string is the same as 'message' property.

##PhotoPost Class
* Implements the 'matchString(String)' abstract method.
* 'matchString()' returns TRUE if the string is the same as 'caption' property.

##ISearchable Interface
* Provide two public interfaces (method signatures):
    * public int searchItem(String) : search for an item, given a string.
    * public boolean deleteItem(String) : delete an item, given a string.
* A class implementing this interface has to implement methods above.

##NewsFeed Class
* Modify the 'getPost(int index)' method from one-index to zero-index, i.e.:
    * getPost(0) returns the 1st Post element.
    * getPost(1) returns the 2nd Post element.
* Implements the 'IListManageable' interface.
* Searchable and deletable Post object by given ... 
    * 'message' attribute (for Message post) or 
    * 'caption' or 'filename' attributes (for Photo post).

##FeedManagement Class
* Use 'PList' to represent a list of NewsFeed objects.
    * DO NOT make a copy of 'PList' source files into this module
    * see README.md of 'cpe200-util' module on how to create a Java library.
* Implements the 'IListManageable' interface.
    * Searchable and deletable NewsFeed object by given 'feedname' attribute.
* Provide methods for feed management:
    1. Display all feeds
    2. Display a feed (given feed id)
    3. Display a post (given feed and post id)
    4. Create new feed
    5. Delete a feed (given feed name)
    6. Add new (message and photo) post
    7. Delete a post (given a feed name, and message or photo caption or photo filename )
    8. Add comment to post (given feed and post id)
    9. Add like to post (given feed and post id)

##TestFeedManagement Class
* A Java program providing a simple "console UI" for user to manage feeds

##To complete the homework you need to meet following requirements:
* Pass all unit tests 
* Able to create Java archive (.jar) of the application
* Able to run your Java console application in command line interface (without IDE)
* Able to create Java document for the 'FeedManagement' class
