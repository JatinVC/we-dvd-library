package com.mthree.dao;

import java.util.List;

import com.mthree.dto.Dvd;

public interface DvdDao {
    /**
     * returns a list of all dvds in the collection.
     * @return List containing all dvds in the collection.
     */
    List<Dvd> getAllDvds();

    /**
     * Returns the dvd object associated with the given dvd id
     * Returns null if no such dvd exists.
     * 
     * @param dvdId ID of the dvd to retrieve
     * @return the dvd object associated with the given dvd id,
     * null if no such dvd exists.
     */
    Dvd getDvd(int dvdId);

    /**
     * Returns the dvd object associated with the given dvd title
     * returns null if no such dvd exists.
     * 
     * @param title of the dvd to retrive
     * @return the dvd object associated with the given dvd title,
     * null if no such dvd exists.
     */
    Dvd getDvd(String title);

    /**
     * Adds the given dvd to the collection and associates it with the given
     * dvd id. If there is already a dvd associated with the given
     * dvd id it will return that dvd object, otherwise it will return null.
     * 
     * @param dvdId id with which the dvd is to be associated
     * @param dvd dvd to be added to the collection
     * @return the dvd object previously  associated with the given
     * dvd id if it exists, or null.
     */
    Dvd addDvd(int dvdId, Dvd dvd);

    /**
     * Edit the given dvd and reassociate it with the given dvd id.
     * return the edited dvd object
     * @param dvdId id with which the dvd object is to be edited.
     * @param dvd edited dvd data that needs to be reassociated with the given
     * dvd id.
     * @return dvd object that was edited.
     */
    Dvd editDvd(int dvdId, Dvd dvd);

    /**
     * Removes the dvd with the given dvd id from the collection
     * Returns the dvd object that is being removed or null
     * if there is no dvd associated with the given dvd id.
     * 
     * @param dvdId id of the dvd to be removed.
     * @return dvd object that was removed or null if no dvd 
     * was associated with the given dvd id.
     */
    Dvd removeDvd(int dvdId);
}
