/**
 * Created with IntelliJ IDEA.
 * User: hauke
 * Date: 18.05.12
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    private static Test ourInstance = new Test();

    public static Test getInstance() {
        return ourInstance;
    }

    private Test() {
    }
}
