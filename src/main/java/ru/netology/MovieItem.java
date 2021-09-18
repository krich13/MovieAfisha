package ru.netology;

public class MovieItem {
    private int imageId;
    private int movieId;
    private String MovieName;
    private String MovieGenre;

    public int getImageId() {
        return imageId;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return MovieName;
    }

    public String getMovieGenre() {
        return MovieGenre;
    }

    public MovieItem(int imageId, int movieId, String movieName, String movieGenre) {
        this.imageId = imageId;
        this.movieId = movieId;
        MovieName = movieName;
        MovieGenre = movieGenre;
    }
}
