package academy.ystavasovellus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static academy.ystavasovellus.service.Parse.stringToListLong;

@SpringBootTest
class YstavasovellusApplicationTests {

	@Test
	void contextLoads() {
	}
/*
	@Test
	boolean testStringtoListLogin() {
		List<Long> friends = new ArrayList<>();
		List<Long> comparison = new ArrayList<>();

		String test = "1,2,3,4,5";
		friends = stringToListLong(test);
		if (friends == comparison) {
		}
*/

		//Mahdollisia testejä: 1) yhteys DB:hen toimii (esim. getillä), 2) listAllUsers-funktion tuoma lista on saman mittainen kuin DB, 3) edit-toiminnallisuus toimii eli vanha vs uusi tieto, 4) filtterit toimivat
		//listToHTML(longListToUsers(stringToListLong(friends))) -kokonaisuuden testaaminen

	}


