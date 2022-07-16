package com.mthree.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mthree.dto.Dvd;

public class DvdDaoImpl implements DvdDao{

    private Map<Integer, Dvd> dvds = new HashMap<>();
    private final String DVD_FILE = "collection.txt";


    @Override
    public List<Dvd> getAllDvds() {
        loadCollection();
        return new ArrayList<Dvd>(this.dvds.values());
    }

    @Override
    public Dvd getDvd(int dvdId) {
        loadCollection();
        return this.dvds.get(dvdId);
    }

    @Override
    public Dvd getDvd(String title) {
        loadCollection();
        for(Dvd dvd : this.dvds.values()){
            if(dvd.getTitle().equals(title)){
                return dvd;
            }
        }
        return null;
    }

    @Override
    public Dvd addDvd(int dvdId, Dvd dvd) {
        loadCollection();
        Dvd prevDvd = dvds.put(dvdId, dvd);
        writeCollection();
        return prevDvd;
    }

    @Override
    public Dvd editDvd(int dvdId, Dvd dvd) {
        loadCollection();
        Dvd editedDvd = dvds.put(dvdId, dvd);
        writeCollection();
        return editedDvd;
    }

    @Override
    public Dvd removeDvd(int dvdId) {
        loadCollection();
        Dvd removedDvd = dvds.remove(dvdId);
        writeCollection();
        return removedDvd;
    }

    private Dvd unmarshallDvd(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(",");
        
        int dvdId = Integer.parseInt(dvdTokens[0]);
        String title = dvdTokens[1];
        Date releaseDate = null;
        try {
            releaseDate = new SimpleDateFormat("dd/mm/yyyy").parse(dvdTokens[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int mpaaRating = Integer.parseInt(dvdTokens[3]);
        String directorName = dvdTokens[4];
        String studio = dvdTokens[5];
        String userRating = dvdTokens[6];

        Dvd dvd = new Dvd(dvdId, title, releaseDate, mpaaRating, directorName, studio, userRating);
        return dvd;
    }

    private void loadCollection(){
        Scanner input = null;

        try{
            input = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        String currentLine;
        Dvd currentDvd;

        while(input.hasNextLine()){
            currentLine = input.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            dvds.put(currentDvd.getDvdId(), currentDvd);
        }

        input.close();
    }

    private String marshallDvd(Dvd dvd){
        String dvdText = dvd.getDvdId() + ",";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        dvdText += dvd.getTitle() + ",";
        dvdText += dateFormat.format(dvd.getReleaseDate()) + ",";
        dvdText += dvd.getMpaaRating() + ",";
        dvdText += dvd.getDirectorName() + ",";
        dvdText += dvd.getStudio() + ",";
        dvdText += dvd.getUserRating() + ",";

        return dvdText;
    }

    private void writeCollection(){
        PrintWriter output = null;

        try{
            output = new PrintWriter(new FileWriter(DVD_FILE));
        }catch(IOException e){
            e.printStackTrace();
        }

        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for(Dvd currentDvd : dvdList){
            dvdAsText = marshallDvd(currentDvd);
            output.println(dvdAsText);
            output.flush();
        }

        output.close();
    }
}
