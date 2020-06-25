/**
 * Greeter builds personalized messages and returns them.
 */
public class Greeter {
    private String name;

    /**
     * Constructs a Greeter with a certain name.
     *
     * @param name the name all strings built should use
     */
    public Greeter(String name) {
        this.name = name;
    }

    /**
     * Builds a greeting message.
     *
     * @return greeting message with the name
     */
    public String sayHello() {
        return "Hello, " + this.name;
    }

    /**
     * Builds a goodbye message.
     *
     * @return goodbye message with the name
     */
    public String sayGoodbye() {
        return "Goodbye, " + this.name;
    }

    /**
     * Builds a refusal message.
     *
     * @return refusal message with the name
     */
    public String refuseHelp() {
        return "I am sorry, " + this.name + ". I am afraid I can’t do that.";
    }
}
