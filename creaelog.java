
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class creaelog {
    public void createlog(String s) {
        String val = "";
        try {
            File Obj = new File("log.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                val = val + data + "\n";
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        val = val + date.toString() + " " + String.valueOf(time.getHour()) + ":" + String.valueOf(time.getMinute())
                + ":" + String.valueOf(time.getSecond()) + " " + s + "\n";
        try {
            FileWriter Writer = new FileWriter("log.txt");
            Writer.append(val);
            Writer.close();
        } catch (IOException exception) {
        }

    }

}
