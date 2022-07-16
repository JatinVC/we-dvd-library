package com.mthree.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mthree.dto.Dvd;

public class DvdView {
    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Dvd's");
        io.print("2. Create New Dvd");
        io.print("3. View a Dvd");
        io.print("4. Edit a dvd");
        io.print("5. Remove a Dvd");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Dvd getDvdInfo() throws ParseException{
        int dvdId = io.readInt("Please enter the dvd id");
        String title = io.readString("Please enter the title of the dvd");
        Date releaseDate = new SimpleDateFormat("dd/mm/yyyy").parse(io.readString("Please enter date in dd/mm/yyyy format"));
        int mpaaRating = io.readInt("Please enter the mpaaRating");
        String directorName = io.readString("Please enter the name of the director");
        String studio = io.readString("Please enter the studio");
        String userRating = io.readString("Please enter your personal rating");

        Dvd newDvd = new Dvd(dvdId, title, releaseDate, mpaaRating, directorName, studio, userRating);
        
        return newDvd;
    }

    public void printCreateSuccessBanner(){
        io.print("=== Added New DVD ===");
    }

    public void displayAllDvds(List<Dvd> dvds){
        for(Dvd dvd : dvds){
            String dvdInfo = String.format("%s : \n Director: %s \n Studio : %s \n Release Date: %s \n MPAA Rating: %s \n Personal Rating: %s",
                dvd.getTitle(),
                dvd.getDirectorName(),
                dvd.getStudio(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Press enter to continue");
    }

    public void displayAllBanner(){
        io.print("=== Display all Dvds ===");
    }

    public void displayDvd(Dvd dvd){
        String dvdInfo = String.format("%s : \n Director: %s \n Studio : %s \n Release Date: %s \n MPAA Rating: %s \n Personal Rating: %s",
            dvd.getTitle(),
            dvd.getDirectorName(),
            dvd.getStudio(),
            dvd.getReleaseDate(),
            dvd.getMpaaRating(),
            dvd.getUserRating());
        io.print(dvdInfo);

        io.readString("Press enter to continue");
    }

    public void displayDvdBanner(){
        io.print("=== Display Dvd Info ===");
    }

    public void displayRemoveBanner(){
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(Dvd dvd){
        if(dvd != null){
            io.print("Dvd was successfully removed");
        }else{
            io.print("No such dvd");
        }
        io.readString("Please hit enter to continue");
    }

    public int getDvdIdChoice(){
        return io.readInt("Please enter the dvd id");
    }

    public int printEditMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Edit title");
        io.print("2. Edit release date");
        io.print("3. Edit mpaa rating");
        io.print("4. Edit director name");
        io.print("5. Edit studio name");
        io.print("6. Edit user rating");
        io.print("7. Exit system");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public Dvd getEditedDvd(Dvd oldDvd) throws ParseException{
        int choice = 0;

        while(choice != 7){
            choice = printEditMenuAndGetSelection();
            switch(choice){
                case 1:
                    // change dvd title
                    String newTitle = io.readString("Please enter the new title");
                    oldDvd.setTitle(newTitle);
                    break;
                case 2:
                    // change dvd release date
                    Date releaseDate = new SimpleDateFormat("dd/mm/yyyy").parse(io.readString("Please enter date in dd/mm/yyyy format"));
                    oldDvd.setReleaseDate(releaseDate);
                    break;
                case 3:
                    // change dvd mpaaRating
                    int mpaaRating = io.readInt("Please enter the mpaa rating");
                    oldDvd.setMpaaRating(mpaaRating);
                    break;
                case 4:
                    // change dvd director name
                    String directorName = io.readString("Please enter the directors name");
                    oldDvd.setDirectorName(directorName);
                    break;
                case 5:
                    // change dvd studio
                    String studio = io.readString("Please enter the studio name");
                    oldDvd.setStudio(studio);
                    break;
                case 6:
                    // change dvd userRating
                    String userRating = io.readString("Please enter user rating");
                    oldDvd.setUserRating(userRating);
                    break;
                default:
                    io.print("INVALID CHOICE, PLEASE CHOOSE AGAIN");
                    break;
            }
            choice = io.readInt("Please enter your choice: ");
        }

        io.print("content of edited dvd: ");
        this.displayDvd(oldDvd);
        return oldDvd;
    }

    public void printEditSuccessBanner() {
        io.print("=== SUCCESSFUL EDIT ===");
    }
}
