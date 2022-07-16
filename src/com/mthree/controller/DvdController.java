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

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void getDvdFromTitle(){
        view.displayDvdBanner();
        String title = io.readString("Please enter the title of the dvd you would like to find");
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void listDvds(){
        view.displayAllBanner();
        List<Dvd> dvds = dao.getAllDvds();
        view.displayAllDvds(dvds);
    }

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

    private void removeDvd(){
        view.displayRemoveBanner();
        int dvdId = view.getDvdIdChoice();
        Dvd removedDvd = dao.removeDvd(dvdId);
        view.displayRemoveResult(removedDvd);
    }

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
