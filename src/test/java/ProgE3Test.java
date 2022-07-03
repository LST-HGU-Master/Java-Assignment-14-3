import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @version (20220703)
 *  (注意)このテストコードを実行すると、ProgE３.mainメソッドの実行で作られた「summary.txt」は内容が書き変わったり削除されることがある
 */
public class ProgE3Test {

    @Test
    public void testWriteResult1()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);
        String fname = "summary.txt";
        File falready = new File(fname);
        if(falready.exists()) falready.delete();

        // action
        ProgE3.main(new String[]{"snowdepth.csv"}); // 実行時引数をテストする場合
        // undo the binding in System
        System.setOut(originalOut);
        
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

        try(BufferedReader br = new BufferedReader(new FileReader(fname))){
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
            fail(fname +" がありません!");
        }
    }

    @Test
    public void testWriteResult2()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);
        // preparing a csvfile, remove already existing outputfile
        String fnameIn = "test.csv", fnameOut = "summary.txt";
        String [] dt = {"2022,3,7,82,135,125,121,107,121,127,112,97,119,109,156,105",
                        "2022,3,8,81,132,122,117,103,117,124,108,95,116,107,154,104",
                        "2022,3,9,79,128,121,115,102,115,122,106,95,115,106,153,102" };
        try (FileWriter fw = new FileWriter(fnameIn) ) {
            for(int i=0; i<dt.length; i++) {
                fw.write(dt[i] +"\n");
            }
        } catch ( Exception e) {
            fail("Exception has occured during preparing test data!");
        }
        File falready = new File(fnameOut);
        if(falready.exists()) falready.delete();

        // action
        ProgE3.main(new String[]{fnameIn}); // expecting args[0] is applied & summary.txt produced
        // undo the binding in System
        System.setOut(originalOut);
        File fin = new File(fnameIn); fin.delete();
        // assertion
        String expected = "中央区, 242\n" +
                "北区(太平), 395\n" +
                "北区(あいの里), 368\n" +
                "東区, 353\n" +
                "白石区, 312\n" +
                "厚別区, 353\n" +
                "豊平区, 373\n" +
                "清田区, 326\n" +
                "南区(南31条西8丁目), 287\n" +
                "南区(定山渓), 350\n" +
                "西区(西野), 322\n" +
                "西区(平和), 463\n" +
                "手稲区, 311\n";

        try(BufferedReader br = new BufferedReader(new FileReader("summary.txt"));){
            String lines = "";
            String line = br.readLine();
            // int i = 0;
            while (line != null) {
                lines = lines + line + "\n";
                line = br.readLine();
            }
            assertEquals(expected, lines);
        } catch (IOException e) {
            e.printStackTrace();
            fail(fnameOut +"がありません!");
        }
    }

    @Test
    public void testCatchException()
    {
        // PrintStream originalOut = System.out;
        // ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // System.setOut(new PrintStream(bos));

        // StandardInputStream in = new StandardInputStream();
        // System.setIn(in);

        // assertion
        assertDoesNotThrow(() -> ProgE3.main(new String[]{"src/main/java/abcdefg.txt"}),"例外処理をthrowしてはいけません!");
    }
}
