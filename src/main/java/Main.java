/**
 * @author Vishal Neekhara
 */
public class Main {
    public static void main(String gg[]) {
        Logger logger = Logger.getInstanse();

        Config.setup(logger);
        logger.writeLog(Level.INFO,"this is info log");
    }
}
