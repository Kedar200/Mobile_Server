import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public class LockExample {
    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = Native.load("user32", User32.class);

        boolean LockWorkStation();
    }

    public void lock() {
        User32.INSTANCE.LockWorkStation();
    }
}
