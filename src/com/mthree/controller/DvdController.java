/*
 * This file holds the code for the controller for the dvd collection program.
 */

package com.mthree.controller;

import java.text.ParseException;
import java.util.List;

import com.mthree.dao.DvdDao;
import com.mthree.dto.Dvd;
import com.mthree.view.DvdView;
import com.mthree.view.UserIO;

public class DvdController {
    private UserIO io;
    private DvdView view;
    private DvdDao dao;

    public DvdController(UserIO io, DvdView view, DvdDao dao){
        this.io = io;
        this.view = view;
        this.dao = dao;
    }

    /**
     * A method to run the program continuously.
     */
    public void run(){
        int menuSelection = 0;
        while(menuSelection != 6){
            menuSelection = getMenuSelection();

            switch(menuSelection){
                case 1:
                    this.listDvds();
                    break;
                case 2:
                    this.addDvd();
                    break;
                case 3:
                    this.getDvdFromTitle();
                    break;
                case 4:
                    this.editDvd();
                    break;
                case 5:
                    this.removeDvd();
                    break;
                case 6:
                    break;
                default:
                    io.print("UNKOWN COMMAND");
                    break;
            }
        }
        io.print("GOODBYE");
    }

    /**
     * Helper method to get a choice from the user
     * @return an integer that signifies the menu choice the user has made.
     */
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    /**
     * Helper method to retrieve a dvd from its title and display it.
     */
    private void getDvdFromTitle(){
        view.displayDvdBanner();
        String title = io.readString("Please enter the title of the dvd you would like to find");
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    /**
     * Helper method to list all dvd's in the system.
     */
    private void listDvds(){
        view.displayAllBanner();
        List<Dvd> dvds = dao.getAllDvds();
        view.displayAllDvds(dvds);
    }

    /**
     * Helper method to add a new dvd to the system.
     */
    private void addDvd(){
        Dvd newDvd;
        try{
            newDvd = view.getDvdInfo();
            this.dao.addDvd(newDvd.getDvdId(), newDvd);
            view.printCreateSuccessBanner();
        }catch(ParseException pe){
            pe.printStackTrace();
        }
    }

    /**
     * Helper method to remove a dvd from the system by taking in the dvd id.
     */
    private void removeDvd(){
        view.displayRemoveBanner();
        int dvdId = view.getDvdIdChoice();
        Dvd removedDvd = dao.removeDvd(dvdId);
        view.displayRemoveResult(removedDvd);
    }

    /**
     * Helper method to edit a dvd by its dvd id.
     */
    private void editDvd(){
        int dvdId = view.getDvdIdChoice();
        try {
            Dvd dvd = dao.getDvd(dvdId);
            view.getEditedDvd(dvd);
            dao.editDvd(dvd.getDvdId(), dvd);
            view.printEditSuccessBanner();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
