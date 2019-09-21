/**
 * @author Vishal Neekhara
 */
public class ConsoleOutputStream implements OutputStream {

    @Override
    public void update(Subject subject) {
        System.out.println(subject.getMsg());
    }
}
