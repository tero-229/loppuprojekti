package academy.ystavasovellus.service;
import academy.ystavasovellus.entities.Users;


import java.util.ArrayList;
import java.util.List;

public class Parse {

    public static String listToHTML(List<Users> listed) {
        String toReturn = "";
        for (Users list : listed) {
            toReturn = toReturn + "<tr> <br/>" + "<td> <a href=" + ">" + list.getName() + "</a> </td> <td>" + list.getAge() + "</td> <td>" + list.getMaakunta() + "</td> <td>" + list.getInfo() + "</td></tr>";
        }
        return toReturn;
    }

    public static List<Long> stringToListLong(String friendlist) {
        List<Long> friends = new ArrayList<>();
        String[] temporary = friendlist.split(",");
        for (String temp : temporary) {
            friends.add(Long.valueOf(temp));
        }
        return friends;
    }

}