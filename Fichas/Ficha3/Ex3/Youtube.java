package Fichas.Ficha3.Ex3;

import java.time.LocalDate;
import java.util.*;

public class Youtube {

    // Object variables -----------------------------------------------------
    private String name;
    private List<Byte> video;
    private LocalDate date;
    private String resolution;
    private final int [] time;
    private List<String> comments;
    private int like;
    private int dislike;
    // ----------------------------------------------------------------------

    public Youtube () {
        this.name = "Java Full Course";
        this.video = new ArrayList<>();
        this.date = LocalDate.of(2020, 11, 9);
        this.resolution = "720p";
        this.time = new int[]{719,59}; // min; seg
        this.comments = new ArrayList<>();
        this.like = 23000;
        this.dislike = 106;
    }

    public Youtube(String name, List<Byte> video, LocalDate date,
                   String resolution, int [] time,
                   List<String> comments, int like, int dislike) {
        this.name = name;
        this.video = new ArrayList<>(video);
        this.date = date;
        this.resolution = resolution;
        this.time = time;
        this.comments = new ArrayList<>(comments);
        this.like = like;
        this.dislike = dislike;
    }

    public Youtube (Youtube y) {
        this.name = y.getName();
        this.video = y.getVideo();
        this.date = y.getDate();
        this.resolution = y.getResolution();
        this.time = y.getTime();
        this.comments = y.getComments();
        this.like = y.getLike();
        this.dislike = y.getDislike();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Byte> getVideo() {
        return new ArrayList<>(this.video);
    }

    public void setVideo(List<Byte> video) {
        this.video = new ArrayList<>(video);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int [] getTime() {
        return Arrays.copyOf(this.time, this.time.length);
    }


    public List<String> getComments() {
        return new ArrayList<>(this.comments);
    }

    public void setComments(List<String> comments) {
        this.comments = new ArrayList<>(comments);
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    // b)
    public void insertComment (String comentario) {
        this.comments.add(comentario);
    }

    // c) -> ?

    // d)
    public void thumbsUp() {
        this.like += 1;
    }

    // e) -> ?

    public Youtube clone () {
        return new Youtube(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Youtube youtube = (Youtube) o;
        return like == youtube.like && dislike == youtube.dislike && Objects.equals(name, youtube.name) && Objects.equals(video, youtube.video) && Objects.equals(date, youtube.date) && Objects.equals(resolution, youtube.resolution) && Objects.equals(time, youtube.time) && Objects.equals(comments, youtube.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, video, date, resolution, time, comments, like, dislike);
    }

    @Override
    public String toString() {
        return "Youtube{" +
                "name='" + name + '\'' +
                ", video=" + video +
                ", date=" + date +
                ", resolution='" + resolution + '\'' +
                ", time=" + Arrays.toString(time) +
                ", comments=" + comments +
                ", like=" + like +
                ", dislike=" + dislike +
                '}';
    }
}
