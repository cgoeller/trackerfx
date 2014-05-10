package net.goeller.trackerfx.task;

import java.time.Duration;

public class WorkUnitTest {

    @org.junit.Test
    public void testGetDuration() throws Exception {
        WorkUnit event = new WorkUnit();
        System.out.println(event);

        Thread.sleep(5000);

        event.stopEvent();
        Duration dur = event.getDuration();
        System.out.println(dur);
        System.out.println(event);
    }
}