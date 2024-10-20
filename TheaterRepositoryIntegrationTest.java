package com.ticket.project.data.repository;

import com.ticket.project.data.entity.Screening;
import com.ticket.project.data.entity.Theater;
import org.junit.Before;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TheaterRepositoryIntegrationTest {
    @Autowired
    private TheaterRepository TheaterRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Before
    public void init() {
        Theater aNewTheater = new Theater();
        aNewTheater.setTheaterName("RAHUL");
        aNewTheater.setTheaterCity("PUNE");

        testEntityManager.persist(aNewTheater);
        testEntityManager.flush();
    }

    @Test
    public void testFindByTheaterId() {
        Theater foundTheater = com.ticket.project.data.repository.TheaterRepository.findByTheaterId(2L);

        assertNotNull(foundTheater);
        assertEquals(foundTheater.getTheaterName(), "INOX");
    }

    @Test
    public void testFindByTheaterNameAndTheaterCity() {
        Theater foundTheater = TheaterRepository.findByTheaterNameAndTheaterCity("RAHUL", "PUNE");

        assertNotNull(foundTheater);
        assertThat(foundTheater.getTheaterName(), is(equalTo("RAHUL")));
    }
}