package com.pizzaworld.common.test;


import com.pizzaworld.common.test.config.TestApplicationConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestApplicationConfiguration.class)
@TestPropertySource(locations = "classpath:test.properties")
public class AbstractTest {

    protected String getRandomString() {
        return UUID.randomUUID().toString();
    }
}
