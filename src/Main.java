import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\user\\Desktop\\Pliki użytkownika darekdede1995 - Chomikuj.pl.htm"));
        {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("<tbody><tr><td><div class=\"T_c\"><div id=\"Ti_0\" class=\"T_col\"></div></div></td><td><a href=\"https://chomikuj.pl/darekdede1995\" rel=\"0\" title=\"darekdede1995\" id=\"Ta_0\">")) {
                    while (line.indexOf("title") != line.lastIndexOf("title")) {
                        int pomocniczy;
                        line = line.substring(line.indexOf("title="));
                        line = line.substring(line.indexOf('"') + 1);
                        pomocniczy = line.indexOf('"');

                        if (!(line.substring(0, pomocniczy).contains("darekdede1995")) && !(line.substring(0, pomocniczy).contains("Zawiera nowe pliki")))
                            sb.append(line.substring(0, pomocniczy)).append("\n");
                    }
                }

            }
            Writer w = new FileWriter("C:\\Users\\user\\Desktop\\opis.txt");
            w.write(sb.toString());
            w.close();

            System.out.println(sb);

        }


    }
}
