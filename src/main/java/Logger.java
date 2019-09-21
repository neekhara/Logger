import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Vishal Neekhara
 */
public class Logger implements Subject {

    private HashMap<Integer, List<OutputStream>> mapOfStream;

    private HashMap<Level, Boolean> statusMap;

    private static Logger logger;

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    private Logger() {
        mapOfStream = new HashMap<Integer, List<OutputStream>>();
        statusMap = new HashMap<Level, Boolean>();
        statusMap.put(Level.ERROR, Boolean.TRUE);
        statusMap.put(Level.INFO, Boolean.TRUE);
        statusMap.put(Level.FATAL, Boolean.TRUE);
    }

    @Override
    public void registerOutputStream(int level, OutputStream outputStream) {
        if (!mapOfStream.containsKey(level)) {
            mapOfStream.put(level, new ArrayList<OutputStream>(Arrays.asList(outputStream)));
        } else {
            mapOfStream.get(level).add(outputStream);
        }
    }

    @Override
    public void removeOutputStream(OutputStream outputStream) {
        for (Integer i : mapOfStream.keySet()) {
            // remove from list
        }
    }

    @Override
    public void notifyOutStream(int level) {
        if (mapOfStream.containsKey(level)) {
            List<OutputStream> outputStreams = mapOfStream.get(level);
            for (OutputStream stream : outputStreams) {
                stream.update(this);
            }
        }
    }

    public static Logger getInstanse() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    void writeLog(Level type, String msg) {
        if (statusMap.get(type)) {
            setMsg(msg);
            notifyOutStream(type.ordinal());
        }
    }

}
