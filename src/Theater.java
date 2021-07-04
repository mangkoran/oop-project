import java.util.ArrayList;
import movie.*;

public class Theater {
    private String name;
    private ArrayList<Movie> movies;

    public Theater(String name, ArrayList<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Movie getMovie(int i) {
        return movies.get(i);
    }

    public void setMovie(int i, Movie m) {
        this.movies.set(i, m);
    }
}
