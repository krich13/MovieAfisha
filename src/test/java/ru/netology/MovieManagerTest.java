package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private MovieItem firstMovie = new MovieItem(1, 1, "Fleabag", "sitcom");
    private MovieItem secondMovie = new MovieItem(2, 2, "Gentelmen", "action movie");
    private MovieItem thirdMovie = new MovieItem(3, 3, "Notebook", "melodrama");
    private MovieItem forthMovie = new MovieItem(4, 4, "The Hate U Give", "action movie");
    private MovieItem fifthMovie = new MovieItem(5, 5, "Parasite", "drama");
    private MovieItem sixthMovie = new MovieItem(6, 6, "Titanic", "drama");
    private MovieItem seventhMovie = new MovieItem(7, 7, "Casablanca", "drama");
    private MovieItem eighthMovie = new MovieItem(8, 8, "The Farewell", "action movie");
    private MovieItem ninthMovie = new MovieItem(9, 9, "Rebel Without a Cause", "drama");
    private MovieItem tenthMovie = new MovieItem(10, 10, "Promising Young Woman", "horror");
    private MovieItem eleventhMovie = new MovieItem(11, 11, "Rocky", "sitcom");
    private MovieItem twelvethMovie = new MovieItem(12, 12, "Jaws", "horror");
    private MovieItem thirtheenthMovie = new MovieItem(13, 13, "Schindler's List", "drama");

    @BeforeEach
    public void setUp() {
        manager.addMovie(firstMovie);
        manager.addMovie(secondMovie);
        manager.addMovie(thirdMovie);
        manager.addMovie(forthMovie);
        manager.addMovie(fifthMovie);
        manager.addMovie(sixthMovie);
        manager.addMovie(seventhMovie);
        manager.addMovie(eighthMovie);
        manager.addMovie(ninthMovie);
        manager.addMovie(tenthMovie);
        manager.addMovie(eleventhMovie);
        manager.addMovie(twelvethMovie);
        manager.addMovie(thirtheenthMovie);
    }

    @Test
    public void addNewMovie() { // добавление фильма в массив
        MovieItem fourteenthMovie = new MovieItem(14, 14, "The Godfather ", "action movie");
        manager.addMovie(fourteenthMovie);
        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{fourteenthMovie, thirtheenthMovie, twelvethMovie, eleventhMovie, tenthMovie, ninthMovie, eighthMovie, seventhMovie, sixthMovie, fifthMovie};
        assertArrayEquals(actual, expected);
    }

    @Test
    void showLastAddedMoviesViaDefaultConsructor() { // если фильмов больше 10, то выведутся последние 10 в обратном порядке при использовании дефолтного конструктора
        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{thirtheenthMovie, twelvethMovie, eleventhMovie, tenthMovie, ninthMovie, eighthMovie, seventhMovie, sixthMovie, fifthMovie, forthMovie};
        assertArrayEquals(actual, expected);
    }

    @Test
    void showLastAddedMoviesIfTheirAmountBelowTen() { // если фильмов меньше 10, то выведутся все имеющиеся при использовании дефолтного конструктора
        MovieManager manager = new MovieManager();
        MovieItem firstMovie = new MovieItem(1, 1, "Fleabag", "sitcom");
        MovieItem secondMovie = new MovieItem(2, 2, "Gentelmen", "action movie");
        manager.addMovie(firstMovie);
        manager.addMovie(secondMovie);
        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{secondMovie, firstMovie};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldShowAllMoviesIfTheirAmountLessThanRequired() { // если фильмов меньше чем то значение, которое мы хотим получить, то будут отображаться все имеющиеся фильмы
        MovieManager manager = new MovieManager(6);
        MovieItem firstMovie = new MovieItem(1, 1, "Fleabag", "sitcom");
        MovieItem secondMovie = new MovieItem(2, 2, "Gentelmen", "action movie");
        manager.addMovie(firstMovie);
        manager.addMovie(secondMovie);
        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{secondMovie, firstMovie};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldShowTheRequiredAmountOfMoviesIfTheirAmountMoreThanRequired() { // если фильмов больше чем то значение, которое мы хотим получить, то будет отображаться желаемое значение
        MovieManager manager = new MovieManager(1);
        MovieItem firstMovie = new MovieItem(1, 1, "Fleabag", "sitcom");
        MovieItem secondMovie = new MovieItem(2, 2, "Gentelmen", "action movie");
        manager.addMovie(firstMovie);
        manager.addMovie(secondMovie);
        MovieItem[] actual = manager.getLastMovies();
        MovieItem[] expected = new MovieItem[]{secondMovie};
        assertArrayEquals(actual, expected);
    }
}
