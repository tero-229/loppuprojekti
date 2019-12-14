package academy.ystavasovellus.service;

import academy.ystavasovellus.entities.Users;

import java.util.ArrayList;
import java.util.List;

public class Filter {
/*
    public static List<Users> filterWithAge(List<Users> filtered, int filteredMinAge, int filteredMaxAge) {
        List<Users> foundAge = new ArrayList<>();
        for (Users filt : filtered) {
            if (filteredMinAge <= filt.getAge() && filt.getAge() <= filteredMaxAge) {
                foundAge.add(filt);
            }
        } return foundAge;
    }

 */

    public static List<Users> filterWithState(List<Users> filtered, String state) {
        List<Users> foundState = new ArrayList<>();
        state.toUpperCase();
        for (Users filt : filtered) {
            if (state.equals(filt.getState().toUpperCase())) {
                foundState.add(filt);
            }
        }
        return foundState;
    }

    public static List<Users> filteredWithSport(List<Users> filtered) {
        List<Users> foundSports = new ArrayList<>();
        for (Users filt : filtered) {
            if (filt.getSports() == true) {
                foundSports.add(filt);
            }
        }
        return foundSports;
    }

    public static List<Users> filteredWithFreetime(List<Users> filtered) {
        List<Users> foundFreetime = new ArrayList<>();
        for (Users filt : filtered) {
            if (filt.getFreetime() == true) {
                foundFreetime.add(filt);
            }
        }
        return foundFreetime;
    }

    public static List<Users> noFilter(List<Users> filtered) {
        return filtered;
    }
}
