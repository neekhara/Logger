/**
 * @author Vishal Neekhara
 */
interface Subject {

    void setMsg(String msg);

    String getMsg();

    void registerOutputStream(int level, OutputStream outputStrem);

    void removeOutputStream(OutputStream outputStream);

    void notifyOutStream(int level);
}
