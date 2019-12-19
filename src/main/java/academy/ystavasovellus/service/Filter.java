package academy.ystavasovellus.service;

import academy.ystavasovellus.entities.Users;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static List<Users> filterWithState(List<Users> filtered, String state) {
        List<Users> foundState = new ArrayList<>();
        for (Users filt : filtered) {
            if (state.equals(filt.getState())) {
                foundState.add(filt);
            }
        }
            return foundState;
        }



    // Ottaa listan käyttäjiä ja Stringinä asuinpaikan. Palauttaa listan käyttäjistä, jotka asuvat annetulla asuinpaikalla. toUpperCase muutos etsinnän kohteelle ja etsittäville puuttuu eli case sensitive.

    public static List<Users> filteredWithSport(List<Users> filtered) {
        List<Users> foundSports = new ArrayList<>();
        for (Users filt : filtered) {
            if (filt.getSports() == true) {
                foundSports.add(filt);
            }
        }
        return foundSports;
    }

    // Ottaa sisään listan käyttäjistä ja palauttaa listan käyttäjistä, jotka ovat kiinnostuneita urheiluseurasta

    public static List<Users> filteredWithFreetime(List<Users> filtered) {
        List<Users> foundFreetime = new ArrayList<>();
        for (Users filt : filtered) {
            if (filt.getFreetime() == true) {
                foundFreetime.add(filt);
            }
        }
        return foundFreetime;
    }

    // Ottaa sisään listan käyttäjistä ja palauttaa listan käyttäjistä, jotka ovat kiinnostuneita vapaa-ajan seurasta.

    public static List<Users> noFilter(List<Users> filtered) {
        return filtered;
    }

    // Filtteri ilman filtteriä. Eli palauttaa mitä saa.
}
