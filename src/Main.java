import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        URL url = new URL("https://chomikuj.pl/" + args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        //BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\user\\Desktop\\Pliki użytkownika darekdede1995 - Chomikuj.pl.htm"));
        {
            boolean lista=false;
            String line;
            while ((line = br.readLine()) != null)
            {

                if (lista)
                {
                    if(line.contains("foldersList"))
                    {
                        lista=true;
                    }
                    continue;
                }
                if(line.contains("<a href=\"/" + args[0]) && !line.contains("folderOptionsTitle"))
                {
                    line=line.substring(0, line.lastIndexOf('"'));
                    line=line.substring(line.lastIndexOf('"')+1);
                    sb.append(line);
                    sb.append("\n");
                }
                if (lista)
                {
                    if(line.contains("</table>"))
                    {
                        lista=false;
                    }
                    continue;
                }
            }
        }

            Writer w = new FileWriter("C:\\Users\\user\\Desktop\\opis.txt");
            w.write(sb.toString());
            w.close();
            System.out.println(sb);
    }
}

