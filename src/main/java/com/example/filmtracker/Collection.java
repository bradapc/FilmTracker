package com.example.filmtracker;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;

public class Collection {

    static ArrayList<Movie> collection = new ArrayList<Movie>();

    public static ListView<String> collectionListView;
    public static Label collectionListLabel;

    public static void saveCollection() {
        try {
            FileOutputStream file = new FileOutputStream("collection.col");
            ObjectOutputStream out = new ObjectOutputStream(file);
            for (int i = 0; i < collection.size(); i++) {
                out.writeObject(collection.get(i));
                System.out.println("Wrote " + collection.get(i).getName() + " to collection.col");
            }
            out.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException caught while saving.");
        }
    }

    public static void loadCollection() {
        boolean keepLoading = true;
        try {
            FileInputStream file = new FileInputStream("collection.col");
            ObjectInputStream in = new ObjectInputStream(file);
            while (keepLoading) {
                collection.add((Movie)in.readObject());
            }
            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException caught while loading.");
            keepLoading = false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (!collection.isEmpty()) {
            updateCollectionDisplay(collection);
        }
    }

    public static void updateCollectionDisplay(ArrayList<Movie> c) {
        collectionListView.getItems().clear();
        if (c.isEmpty()) {
            return;
        }
        String filterMode = FilterButton.getFilterMode();
        String direction = FilterButton.getDirection();
        if (filterMode.equals("ID")) {

        } else if (filterMode.equals("title")) {
            if (direction.equals("ascending")) {
                c.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            } else {
                c.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
            }
        } else if (filterMode.equals("author")) {
            if (direction.equals("ascending")) {
                c.sort((o1, o2) -> o1.getAuthor().compareTo(o2.getName()));
            } else {
                c.sort((o1, o2) -> o2.getAuthor().compareTo(o1.getName()));
            }
        }   else if (filterMode.equals("year")) {
            if (direction.equals("ascending")) {
                c.sort((o1, o2) -> {
                    if (o1.getYear() > o2.getYear()) {
                        return 1;
                    } else if (o1.getYear() < o2.getYear()) {
                        return -1;
                    } else {
                        return 0;
                    }
                });
            } else {
                c.sort((o1, o2) -> {
                    if (o2.getYear() > o1.getYear()) {
                        return 1;
                    } else if (o2.getYear() < o1.getYear()) {
                        return -1;
                    } else {
                        return 0;
                    }
                });
            }
        }
        for (int i = 0; i < c.size(); i++) {
            String movieEntry = c.get(i).getID() + ": " + c.get(i).getName()
                    + " (" + c.get(i).getYear() + ")";
            collectionListView.getItems().add(movieEntry);
        }
        collectionListLabel.setText("Film Collection (" + Collection.getCollectionSize() + " films)");
    }

    public static Movie getMovieByID(int id) {
        Movie movie = null;
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getID() == id) {
                movie = collection.get(i);
            }
        }
        return movie;
    }

    public static boolean isValidMovieEntries(String name, String author, int year, String genre, int rating) {
        if (name.length() < 3) return false;
        if (author.length() < 3) return false;
        if (year < 1900) return false;
        //add genre validation
        if (rating < 0 || rating > 5) return false;
        return true;
    }

    public static void updateMovieInfo(int movieID, String name, String author, int year, String genre, int rating, String newComments, boolean isRecommended) {
        Movie m = getMovieByID(movieID);
        m.setName(name);
        m.setAuthor(author);
        m.setYear(year);
        m.setGenre(genre);
        m.setRating(rating);
        m.setComments(newComments);
        m.setRecommendToFriend(isRecommended);
        updateCollectionDisplay(collection);
    }

    static void updateMovieIDs() {
        for (int i = 0; i < collection.size(); i++) {
            collection.get(i).setID(i);
        }
    }

    public static void removeMovieByID(int id) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getID() == id) {
                collection.remove(i);
            }
        }
        updateMovieIDs();
        updateCollectionDisplay(collection);
    }

    public static void addToCollection(Movie m)
    {
        m.setID(collection.size());
        collection.add(m);
        updateCollectionDisplay(collection);
    }

    public static int getCollectionSize() {
        return collection.size();
    }

    public static ArrayList<Movie> getCollection() {
        return collection;
    }

}