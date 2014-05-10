package net.goeller.trackerfx.task;

import org.junit.Test;

public class TaskTest {

    @Test
    public void test() throws Exception {
        Task t = new Task("Test");

        t.start();

        Thread.sleep(3000);
        System.out.println(t);

        Thread.sleep(3000);
        System.out.println(t);
        t.stop();
        Thread.sleep(3000);

        t.start();
        Thread.sleep(3000);
        t.stop();
        System.out.println(t);

    }

}