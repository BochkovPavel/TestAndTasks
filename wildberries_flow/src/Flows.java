import java.io.File;
import java.io.FileWriter;

public class Flows extends Thread {

    Flows(String name){
        setName(name);
    }
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            WriteToFile(Thread.currentThread().getName() + " " + (i+1) + "\n");
        }
    }
    public void WriteToFile(String stringMessage)
    {
        try
        {
            FileWriter filelog = new FileWriter(new File("C:\\Java\\Test.txt"),true);
            filelog.write(stringMessage);
            filelog.flush();
        }
        catch(Exception error)
        {
            //ошибка
        }
    }
}
