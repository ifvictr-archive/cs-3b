/*
 * Lab 2: P3.6 by Victor Truong
 *
 * This program models social relationships via befriending and unfriending. It prints out a dynamic
 * list of the person’s friends as they befriend and unfriend other people.
 */

/**
 * Tests the Person class.
 */
public class PersonTester {
    public static void main(String[] args) {
        Person victor = new Person("Victor");
        Person dave = new Person("Dave");

        // Print default values
        System.out.println("Victor’s friends: " + victor.getFriendNames());
        System.out.println("Dave’s friends: " + dave.getFriendNames());
        System.out.println();

        // Test befriend for Victor
        victor.befriend(dave);
        System.out.println("* Victor befriended Dave!");
        System.out.println("Victor’s friends: " + victor.getFriendNames());
        System.out.println("Dave’s friends: " + dave.getFriendNames());
        System.out.println();

        // Test befriend for Dave
        dave.befriend(victor);
        System.out.println("* Dave befriended Victor!");
        System.out.println("Victor’s friends: " + victor.getFriendNames());
        System.out.println("Dave’s friends: " + dave.getFriendNames());
        System.out.println();

        // Test unfriend for Victor
        victor.unfriend(dave);
        System.out.println("* Victor unfriended Dave! :(");
        System.out.println("Victor’s friends: " + victor.getFriendNames());
        System.out.println("Dave’s friends: " + dave.getFriendNames());
        System.out.println();

        // Test unfriend for Dave
        dave.unfriend(victor);
        System.out.println("* Dave unfriended Victor! :(");
        System.out.println("Victor’s friends: " + victor.getFriendNames());
        System.out.println("Dave’s friends: " + dave.getFriendNames());
    }
}
