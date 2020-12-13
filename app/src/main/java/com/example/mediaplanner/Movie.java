package com.example.mediaplanner;

public class Movie {

    private String poster;
    private String title;
    private String director;
    private String runtime;
    private String actors;

    public Movie(String poster, String title, String director, String runtime, String actors) {
        this.poster = poster;
        this.title = title;
        this.director = director;
        this.runtime = runtime;
        this.actors = actors;
    }

    public Movie(){
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
