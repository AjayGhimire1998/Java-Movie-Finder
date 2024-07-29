import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import org.apache.tomcat.jni.File;

public class MovieIO {
  public static ArrayList<Movie> getMovies() {
    ArrayList<Movie> movies = new ArrayList<>();
    BufferedReader reader = getReader("");
  }

  private static BufferedReader getReader(String name) {
    BufferedReader in = null;

    try {
      File file = new File(name);
      in = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      System.out.println("File doesn't exist!");
    }
  }



}
