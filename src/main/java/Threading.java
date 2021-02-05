class TestOddEvenAnonymousThread {

    public static void main(String[] args) {
        TestOddEvenAnonymousThread t = new TestOddEvenAnonymousThread();
        Thread oddT = (new Thread("Odd") {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 1) {
                        synchronized (t) {
                            t.notifyAll();
                            System.out.println("Odd : " + i);
                            try {
                                if (i != 100)
                                    t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread eventT = (new Thread("Even") {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        synchronized (t) {
                            t.notifyAll();
                            System.out.println("Even: " + i);
                            try {
                                if (i != 100)
                                    t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
                oddT.start();
                eventT.start();
    }


}
