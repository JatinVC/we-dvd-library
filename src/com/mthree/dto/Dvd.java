package com.mthree.dto;

import java.util.Date;
import java.util.Objects;

public class Dvd {
    private int dvdId;
    private String title;
    private Date releaseDate;
    private int mpaaRating;
    private String directorName;
    private String studio;
    private String userRating;


    public Dvd() {
    }

    public Dvd(int dvdId, String title, Date releaseDate, int mpaaRating, String directorName, String studio, String userRating) {
        this.dvdId = dvdId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.userRating = userRating;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMpaaRating() {
        return this.mpaaRating;
    }

    public void setMpaaRating(int mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return this.directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return this.studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return this.userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public Dvd title(String title) {
        setTitle(title);
        return this;
    }

    public Dvd releaseDate(Date releaseDate) {
        setReleaseDate(releaseDate);
        return this;
    }

    public Dvd mpaaRating(int mpaaRating) {
        setMpaaRating(mpaaRating);
        return this;
    }

    public Dvd directorName(String directorName) {
        setDirectorName(directorName);
        return this;
    }

    public Dvd studio(String studio) {
        setStudio(studio);
        return this;
    }

    public Dvd userRating(String userRating) {
        setUserRating(userRating);
        return this;
    }

    public int getDvdId() {
        return this.dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public Dvd dvdId(int dvdId) {
        setDvdId(dvdId);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dvd)) {
            return false;
        }
        Dvd dvd = (Dvd) o;
        return dvdId == dvd.dvdId && Objects.equals(title, dvd.title) && Objects.equals(releaseDate, dvd.releaseDate) && mpaaRating == dvd.mpaaRating && Objects.equals(directorName, dvd.directorName) && Objects.equals(studio, dvd.studio) && Objects.equals(userRating, dvd.userRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dvdId, title, releaseDate, mpaaRating, directorName, studio, userRating);
    }

    @Override
    public String toString() {
        return "{" +
            " dvdId='" + getDvdId() + "'" +
            ", title='" + getTitle() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", mpaaRating='" + getMpaaRating() + "'" +
            ", directorName='" + getDirectorName() + "'" +
            ", studio='" + getStudio() + "'" +
            ", userRating='" + getUserRating() + "'" +
            "}";
    }

}
