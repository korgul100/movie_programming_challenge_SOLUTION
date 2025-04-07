import java.util.*;

public class MovieCollection
{
    private ArrayList<Movie> movies;

    public MovieCollection()
    {
        movies = new ArrayList<Movie>();
    }

    // adds a new movie to the movie collection
    public void addMovie(String title, int year, double rating)
    {
        Movie newMovie = new Movie(title, year, rating);
        movies.add(newMovie);
        System.out.println("Movie added successfully!");
    }

    // removes a movie from the movie collection
    // return true if movie was successfully removed
    // return false if movie cannot be found
    public boolean removeMovie(String title)
    {
        int index = -1;
        for (int i = 0; i < movies.size(); i++)
        {
            if (title.equals(movies.get(i).getTitle()))
            {
                index = i;
            }
        }
        if (index != -1)
        {
            movies.remove(index);
            return true;
        }
        else
        {
            return false;
        }
    }

    // search for a movie
    // returns Movie object if exists
    // return null if movie is not in collection
    public Movie searchMovie(String title)
    {
        for (int i = 0; i < movies.size(); i++)
        {
            if (title.equals(movies.get(i)))
            {
                return movies.get(i);
            }
        }
        return null;
    }

    // displays all movies in the collection in order sorted by rating
    public void displayMovies()
    {
        sortMoviesByRating();
        System.out.println(movies.size());
        for (int i = 0; i < movies.size(); i++)
        {
            System.out.println(movies.get(i).getTitle() + ", " + movies.get(i).getYear() + ", " + movies.get(i).getRating());
        }
    }

    // sorts movies by rating - use Bubblesort
    private void sortMoviesByRating()
    {
        for (int i = 0; i < this.movies.size() - 2; i++)
        {
            for (int j = this.movies.size() - 1; j > i; j--)
            {
                if (movies.get(j).getRating() < movies.get(j - 1).getRating())
                {
                    Movie temp = movies.get(j);
                    movies.set(j, movies.get(j - 1));
                    movies.set(j - 1, temp);
                }
            }
        }
    }
}