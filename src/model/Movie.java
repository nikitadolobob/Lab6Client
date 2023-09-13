package model;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Movie implements Comparable<Movie>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int oscarsCount; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person director; //Поле не может быть null

    public Movie(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, int oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person director) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.director = director;
    }

    public Movie(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(int oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    @Override
    public int compareTo(Movie movie) {
        if(this.genre.getGenreRating() + this.oscarsCount == movie.genre.getGenreRating() + movie.oscarsCount){
            return this.name.compareTo(movie.name);
        }
        else{
            if(this.genre.getGenreRating() + this.oscarsCount > movie.genre.getGenreRating() + movie.oscarsCount){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    @Override
    public String toString(){
        return "Movie name: " + name + "\n" + "ID: " + id + "\n" + "X coordinate: " + coordinates.getX() + "\n" + "Y coordinate:  " + coordinates.getY() + "\n" + "Creation date: " + creationDate + "\n" + "Amount of oscar nominations: " + oscarsCount + "\n" +
                "Genre: " + genre + "\n" + "Mpaa rating: " + mpaaRating + "\n" + "Director info" + "\n" + "Name: " + director.getName() + "\n" + "Weight: " + director.getWeight() + "\n" + "Color of eyes: " + director.getEyeColor() + "\n" +
                "Color of hair: " + director.getHairColor() + "\n" + "Country of origin: " + director.getNationality() + "\n" + "Abscis location: " + director.getLocation().getX() + "\n" + "Ordinat location: " + director.getLocation().getY() + "\n" + "Aplicat location: " + director.getLocation().getZ();
    }
}