package academy.ystavasovellus.entities;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static List<Users> filterWithAge(List<Users> filtered, int filteredMinAge, int filteredMaxAge) {
        List<Users> foundAge = new ArrayList<>();
        for (Users filt : filtered) {
            if (filteredMinAge <= filt.getAge() && filt.getAge() <= filteredMaxAge) {
                foundAge.add(filt);
            }
        } return foundAge;
    }

    public static List<Users> filterWithMaakunta(List<Users> filtered, String maakunta) {
        List<Users> foundMaakunta = new ArrayList<>();
        for (Users filt: filtered) {
            if (maakunta.equals(filt.getMaakunta())) {
                foundMaakunta.add(filt);
            }
        } return foundMaakunta;
    }
/*
    public static List<Users> filteredWithSport(List<Users> filtered) {
        List<Users> foundSports = new ArrayList<>();
        for (Users filt : filtered) {
            if (filt.isSportinterest() == true) {
                foundSports.add(filt);
            }
        } return foundSports;
    }

    public static List<Users> filteredWithFreetime(List<Users> filtered) {
        List<Users> foundFreetime = new ArrayList<>();
        for (Users filt : filtered) {
            if (filt.isFreetime() == true) {
                foundFreetime.add(filt);
            }
        } return foundFreetime;
    }
*/
}
