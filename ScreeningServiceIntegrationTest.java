package com.ticket.project.business.service;

import com.ticket.project.business.domain.MovieScreening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScreeningServiceIntegrationTest {

    @Autowired
    ScreeningService screeningService;

    @Test
    public void testBookSeats() {
        MovieScreening aMovieScreening = new MovieScreening();
        aMovieScreening.setMovieName("Race 3");
        aMovieScreening.setScreeningDate("2018-05-25");
        aMovieScreening.setScreeningTime("18:00:00");
        aMovieScreening.setTheaterCity("PUNE");
        aMovieScreening.setTheaterName("INOX");
        aMovieScreening.setNumSeats(5);

        int expectedBookedSeats = screeningService.getBookedSeats(aMovieScreening)+5;

        int actualBookedSeats = screeningService.bookSeats(aMovieScreening, expectedBookedSeats);

        assertEquals(actualBookedSeats, expectedBookedSeats);
    }

    @Test
    public void testGetBookedSeats() {
        MovieScreening aMovieScreening = new MovieScreening();
        aMovieScreening.setMovieName("Race 3");
        aMovieScreening.setScreeningDate("2018-05-25");
        aMovieScreening.setScreeningTime("18:00:00");
        aMovieScreening.setTheaterCity("PUNE");
        aMovieScreening.setTheaterName("INOX");

        assertEquals(5, screeningService.getBookedSeats(aMovieScreening));
    }

    @Test
    public void testGetTotalSeats() {
        MovieScreening aMovieScreening = new MovieScreening();
        aMovieScreening.setMovieName("Race 3");
        aMovieScreening.setScreeningDate("2018-05-25");
        aMovieScreening.setScreeningTime("18:00:00");
        aMovieScreening.setTheaterCity("PUNE");
        aMovieScreening.setTheaterName("INOX");

        assertEquals(100, screeningService.getTotalSeats(aMovieScreening));
    }

    @Test
    public void getMovieScreeningsByDate() {
    }
}