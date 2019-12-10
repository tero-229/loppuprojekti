package academy.ystavasovellus.entities;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static List<User> filterWithAge(List<User> filtered, int filteredMinAge, int filteredMaxAge) {
        List<User> foundAge = new ArrayList<>();
        for (User filt : filtered) {
            if (filteredMinAge <= filt.getAge() && filt.getAge() <= filteredMaxAge) {
                foundAge.add(filt);
            }
        } return foundAge;
    }

    public static List<User> filterWithMaakunta(List<User> filtered, String maakunta) {
        List<User> foundMaakunta = new ArrayList<>();
        for (User filt: filtered) {
            if (maakunta.equals(filt.getMaakunta())) {
                foundMaakunta.add(filt);
            }
        } return foundMaakunta;
    }

    public static List<User> filteredWithSport(List<User> filtered) {
        List<User> foundSports = new ArrayList<>();
        for (User filt : filtered) {
            if (filt.isSportinterest() == true) {
                foundSports.add(filt);
            }
        } return foundSports;
    }

    public static List<User> filteredWithFreetime(List<User> filtered) {
        List<User> foundFreetime = new ArrayList<>();
        for (User filt : filtered) {
            if (filt.isFreetime() == true) {
                foundFreetime.add(filt);
            }
        } return foundFreetime;
    }

}
