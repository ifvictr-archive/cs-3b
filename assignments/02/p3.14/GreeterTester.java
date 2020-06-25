/*
 * Assignment 2: P3.14 by Victor Truong
 *
 * This program instantiates an instance of VotingMachine and tests all the voting methods.
 */

/**
 * Tests our Greeter class.
 */
public class GreeterTester {
    public static void main(String[] args) {
        // Test out all the methods with "World"
        Greeter greeter1 = new Greeter("World");
        System.out.println(greeter1.sayHello());
        System.out.println(greeter1.refuseHelp());
        System.out.println(greeter1.sayGoodbye());

        // Test out all the methods with "Dave"
        Greeter greeter2 = new Greeter("Dave");
        System.out.println(greeter2.sayHello());
        System.out.println(greeter2.refuseHelp());
        System.out.println(greeter2.sayGoodbye());
    }
}
