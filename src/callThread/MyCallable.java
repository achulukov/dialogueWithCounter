package callThread;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int i = 0;

    @Override
    public String call() throws Exception {

            while (i < 20){
                System.out.printf("� %s .���� ������!\n",Thread.currentThread().getName());
                i++;
                Thread.sleep(1000);
            }

        return "���������� ��������� " + i;
    }
}
