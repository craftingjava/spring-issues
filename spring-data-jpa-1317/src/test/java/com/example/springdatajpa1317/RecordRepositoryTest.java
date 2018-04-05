package com.example.springdatajpa1317;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecordRepositoryTest {

    @Autowired
    private RecordRepository recordRepository;

    private Record record;

    @Before
    public void setUp() throws Exception {
        record = recordRepository.save(new Record());
    }

    @Test
    public void testDateCreated() {
        assertNotNull(record.getDateCreated());
    }

    @Test
    public void testId() {
        assertNotNull(record.getId());
    }

}
