package com.company;

public class ShowThreads {
    public static String countParents(ThreadGroup group){
        String str = "";
        ThreadGroup group_p = null;
        group_p = group.getParent();
        if (group_p != null)
            str += countParents(group_p) + "    ";
        else return "";
        return str;
    }

    public static void showThread(ThreadGroup group) {
        System.out.println("SHOW: group" + group.getName());
        while (group.activeCount() > 0) {
            try {
                String result = "";
                Thread[] threads = new Thread[group.activeCount()];
                int count = group.enumerate(threads);
                for (int i = 0; i < count; i++) {
                    result = result + threads[i];
                }
                String levelspace = countParents(group);
                System.out.println(levelspace + "Group " + group.getName() + "; " + "Threads: " + result + " ");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Thread showallThreads(ThreadGroup group) {
        Runnable show = () -> {
            showThread(group);
        };
        Thread recordThread = new Thread(show);
        recordThread.start();
        return recordThread;
    }
}
