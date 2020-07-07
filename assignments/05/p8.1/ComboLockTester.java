/*
 * Assignment 5: P8.1 by Victor Truong
 *
 * This program models a combo lock and tests its functionality, which includes: being turned left,
 * then right, being opened, and being reset. Then it outputs the results of testing the turnLeft,
 * turnRight, and open methods.
 */

/**
 * Tests our ComboLock class.
 */
public class ComboLockTester {
    public static void main(String[] args) {
        ComboLockTester tester = new ComboLockTester();

        tester.testTurnLeft();
        tester.testTurnRight();
        tester.testFailedOpen();
        tester.testSuccessfulOpen();
    }

    public void testTurnLeft() {
        System.out.println("testTurnLeft:");

        ComboLock lock = new ComboLock();

        lock.turnLeft(39);
        System.out.println("  Expected 39, got " + lock.getDialPosition());

        lock.turnLeft(1);
        System.out.println("  Expected 0, got " + lock.getDialPosition());
    }

    public void testTurnRight() {
        System.out.println("testTurnRight:");

        ComboLock lock = new ComboLock();

        lock.turnRight(1);
        System.out.println("  Expected 39, got " + lock.getDialPosition());

        lock.turnRight(39);
        System.out.println("  Expected 0, got " + lock.getDialPosition());
    }

    public void testFailedOpen() {
        System.out.println("testFailedOpen:");

        ComboLock lock = new ComboLock(39, 9, 3);
        System.out.println("  Expected false, got " + lock.open());
    }

    public void testSuccessfulOpen() {
        System.out.println("testSuccessfulOpen:");

        ComboLock lock = new ComboLock(39, 9, 3);
        System.out.println("  Expected 0, got " + lock.getDialPosition());

        lock.turnRight(1);
        System.out.println("  Expected 39, got " + lock.getDialPosition());

        lock.turnLeft(10);
        System.out.println("  Expected 9, got " + lock.getDialPosition());

        lock.turnRight(6);
        System.out.println("  Expected 3, got " + lock.getDialPosition());

        System.out.println("  Expected true, got " + lock.open());
    }
}
