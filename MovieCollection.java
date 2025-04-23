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
        // if inserting at beginning of ArrayList
        if (movies.size() == 0 || (newMovie.getRating() >= movies.get(0).getRating()))
        {
            movies.add(0, newMovie);
        }
        else if (newMovie.getRating() < movies.get(movies.size() - 1).getRating())
        {
            movies.add(newMovie);
        }
        else
        {
            for (int i = 0; i < movies.size() - 1; i++)
            {
                if (newMovie.getRating() <= movies.get(i).getRating() && newMovie.getRating() > movies.get(i+1).getRating())
                {
                    movies.add(i, newMovie);
                    break;
                }
                System.out.println(i);
            }
        }
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
        int index = 0;
        while (index < movies.size())
        {
            System.out.println(movies.get(index).toString());
            index++;
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