/**
 * @author Vishal Neekhara
 */
public class Config {

    public static void setup(Logger logger) {
        OutputStream outputStream = new ConsoleOutputStream();
        logger.registerOutputStream(Level.INFO.ordinal(), outputStream);
    }
}
