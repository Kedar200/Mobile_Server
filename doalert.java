import java.awt.*;
import java.awt.TrayIcon.MessageType;

class doalert implements Runnable {
    String msg;

    doalert(String t) {
        this.msg = t;
    }

    @Override
    public void run() {
        try {
            SystemTray tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().createImage("icon.png");

            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            tray.add(trayIcon);
            trayIcon.displayMessage("Samsung m32", msg, MessageType.INFO);
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
