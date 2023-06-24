import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

import org.json.JSONObject;

class functions {
    public static String gettype(JSONObject obj) {
        return obj.get("type").toString();
    }

    public static String getfuntion(Object obj) {
        System.out.println(obj);
        JSONObject object = new JSONObject(obj.toString());
        return object.get("function").toString();
    }

    public static int getValue(Object obj) {
        JSONObject object = new JSONObject(obj.toString());
        int a = (int) object.get("value");
        return a;
    }

    public static void Action(JSONObject obj, BufferedWriter out) {

        Object object = obj.get("data");
        String text = getfuntion(object);
        if (text.equals("Brightness")) {

            new Thread(new BrightnessManager(getValue(object))).start();

        } else if (text.equals("lock")) {
            LockExample user32 = new LockExample();
            user32.lock();
            try {
                out.write("Locked\n");
                out.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else if (text.equals("Shutdown")) {

            Thread t = new Thread(new doalert("Shutdown"));
            t.start();

        } else if (text.equals("Mousemove")) {

        }

    }
}
