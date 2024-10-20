package com.ticket.project.data.repository;

import com.ticket.project.data.entity.Screening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ScreeningRepositoryIntegrationTest {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    TestEntityManager testEntityManager;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /*
    @Test
    public void findByScreeningDate() {
        Date date;
        try {
            date = DATE_FORMAT.parse("2018-05-25");
        } catch (ParseException | java.text.ParseException e) {
            date = new Date();
        }

        List<Screening> foundScreenings = screeningRepository.findByScreeningDate(new java.sql.Date(date.getTime()));

        assertNotNull(foundScreenings);
        assertNotEquals(foundScreenings.size(), 0);
    }

    @Test
    public void findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime() {
        Screening foundScreening = screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime("Deadpool 2",
                1, java.sql.Date.valueOf("2018-05-25"), java.sql.Time.valueOf("10:00:00"));

        assertNotNull(foundScreening);
        assertEquals(foundScreening.getMovieName(), "Deadpool 2");
    }*/
}
