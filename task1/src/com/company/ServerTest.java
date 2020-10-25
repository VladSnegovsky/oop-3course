package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {
    @Test
    public void test(){
        Man newMan = new Man("a", "a", "1", "1");
        assertEquals(Server.deserialize("{\"name\":\"a\",\"sec_name\":\"a\",\"age\":\"1\",\"height\":\"1\"}").show(), newMan.show());
    }
}