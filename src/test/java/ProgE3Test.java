import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProgE3Test {

    @Test
    public void testWriteResult()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        ProgE3.main(new String[]{"snowdepth.csv"}); // 実行時引数をテストする場合

        // assertion
        String expected = "中央区, 5842\n" +
                "北区(太平), 8872\n" +
                "北区(あいの里), 7957\n" +
                "東区, 7380\n" +
                "白石区, 6542\n" +
                "厚別区, 7303\n" +
                "豊平区, 7540\n" +
                "清田区, 6888\n" +
                "南区(南31条西8丁目), 6148\n" +
                "南区(定山渓), 8307\n" +
                "西区(西野), 7203\n" +
                "西区(平和), 9496\n" +
                "手稲区, 7151\n";

        try(BufferedReader br = new BufferedReader(new FileReader("summary.csv"))){
            String lines = "";
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                lines = lines + line + "\n";
                line = br.readLine();
            }
            assertEquals(expected, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testCatchException()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // assertion
        assertDoesNotThrow(() -> ProgE3.main(new String[]{"src/main/java/abcdefg.txt"}));
    }
}
