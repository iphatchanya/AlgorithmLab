import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Schedule {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] array = input.split(" ");
        int work = Integer.parseInt(array[0]);
        int ask = Integer.parseInt(array[1]);

        HashMap<String, String> map = new HashMap<>();
        String n ,m, keyn, keym;
        String [] nn, mm;

        for (int i = 0; i < work; i++) {
            n = bufferedReader.readLine();
            nn = n.split(" ");
            keyn = nn[0] + "/" + nn[1] + "/" + nn[2];
            if (map.get(keyn) != null) {
                map.put(keyn, (map.get(keyn) + "\n" + nn[3]));
            }
            else {
                map.put(keyn, nn[3]);
            }
        }

        for (int i = 0; i < ask; i++) {
            m = bufferedReader.readLine();
            mm = m.split(" ");
            keym = mm[0] + "/" + mm[1] + "/" + mm[2];
            if (map.get(keym) != null) {
                System.out.print(keym + "\n" + map.get(keym) + "\n");
            }
            else {
                System.out.print(keym + "\n" + "no job on this day\n");
            }
        }
    }
}