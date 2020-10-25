package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void test(){
        Man newMan = new Man("a", "a", "1", "1");
        assertEquals(newMan.toJSon(), "{\"name\":\"a\",\"sec_name\":\"a\",\"age\":\"1\",\"height\":\"1\"}");
    }
}