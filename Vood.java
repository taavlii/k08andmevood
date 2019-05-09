import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Vood{
  public static void main(String[] arg) throws IOException{
    PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
    Files.readAllLines(Paths.get("Pokemon.txt")).stream()
    .filter(s -> Double.parseDouble(s.split(",")[1]) >= 41)
     .sorted(Comparator.comparing(s -> s.split(",")[0]))
     .map(s -> "Pokemon " + s.split(",")[0] + " omab elusid suuruses " +
    s.split(",")[1]+" HP ja elaks suure(40 damage) laksu üle").
    collect(Collectors.toList()).forEach(pw::println);
    pw.println ("\nLaksu ei elaks üle:");

    Files.readAllLines(Paths.get("Pokemon.txt")).stream()
    .filter(s2 -> Double.parseDouble(s2.split(",")[1]) < 41)
    .sorted(Comparator.comparing(s2 -> s2.split(",")[0]))
    .map(s -> s.split(",")[0] + " eludega " +
    s.split(",")[1]+" HP").
    collect(Collectors.toList()).forEach(pw::println);

    pw.close();
  }
}
