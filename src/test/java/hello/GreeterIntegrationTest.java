package hello;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreeterIntegrationTest {
    @Test
    public void shallBeTwoRecords() {
        assertEquals(2, new Greeter().countLines());
    }
}