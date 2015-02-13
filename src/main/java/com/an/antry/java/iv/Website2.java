package com.an.antry.java.iv;

public class Website2 {
    interface ProgrammerInterview {
        public void read();
    }

    class Website {
        ProgrammerInterview p = new ProgrammerInterview() {
            public void read() {
                System.out.println("interface ProgrammerInterview anonymous class implementer");
            }
        };
    }
}
