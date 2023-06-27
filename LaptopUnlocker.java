import java.io.IOException;

public class LaptopUnlocker {
    public static void unlockWindowsWithPIN(String pin) {
        try {
            String[] command = { "cmd.exe", "/c", "tscon.exe", "1", "/password:<your_pin>" };
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pin = "<your_pin>"; // Replace with your actual PIN
        unlockWindowsWithPIN(pin);
    }
}
