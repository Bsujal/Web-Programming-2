package com.ticket.project.business.service;

import com.ticket.project.business.domain.MovieScreening;
import com.ticket.project.data.entity.Screening;
import com.ticket.project.data.entity.Theater;
import com.ticket.project.data.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Date;
import java.sql.Time;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScreeningServiceUnitTest {

    @Mock
    private ScreeningRepository screeningRepository;

    @Mock
    private TheaterRepository theaterRepository;

    @InjectMocks
    private ScreeningService screeningService;

    @Before
    public void setUp() {
        // Mocks are already initialized by @RunWith(MockitoJUnitRunner.class)
    }

    @Test
    public void testBookSeats() {
        Theater aMockTheater = new Theater();
        aMockTheater.setTheaterName("INOX");
        aMockTheater.setTheaterCity("PUNE");
        aMockTheater.setTheaterId(2L);

        when(theaterRepository.findByTheaterNameAndTheaterCity(anyString(), anyString()))
                .thenReturn(aMockTheater);

        Screening aMockScreening = new Screening();
        aMockScreening.setMovieName("Race 3");
        aMockScreening.setScreenId(2L);
        aMockScreening.setScreeningDate(Date.valueOf("2018-05-25"));
        aMockScreening.setScreeningTime(Time.valueOf("18:00:00"));
        aMockScreening.setScreeningId(1L);
        aMockScreening.setBookedTickets(0);

        when(screeningRepository.findByMovieNameAndTheaterIdAndScreeningDateAndScreeningTime(
                anyString(), anyLong(), any(Date.class), any(Time.class)))
                .thenReturn(aMockScreening);

        MovieScreening aMovieScreening = new MovieScreening();
        int actualBookedSeats = screeningService.bookSeats(aMovieScreening, 5);

        assertEquals(5, actualBookedSeats);
    }

    @Test
    public void testGetBookedSeats() {
        MovieScreening aMovieScreening = new MovieScreening();

        assertEquals(5, screeningService.getBookedSeats(aMovieScreening));
    }

    @Test
    public void testGetTotalSeats() {
        MovieScreening aMovieScreening = new MovieScreening();

        assertEquals(100, screeningService.getTotalSeats(aMovieScreening));
    }

    @Test
    public void getMovieScreeningsByDate() {
        // Implement your test logic here
    }
}
