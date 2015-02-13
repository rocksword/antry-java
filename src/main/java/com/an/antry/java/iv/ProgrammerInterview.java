package com.an.antry.java.iv;

class ProgrammerInterview {
    public void read() {
        System.out.println("Programmer Interview!");
    }
}

class Website {
    //
    // pInstance is actually a superclass reference type that refers to a subclass object.
    //
    /* This creates an anonymous inner class: */
    ProgrammerInterview pInstance = new ProgrammerInterview() {
        public void read() {
            System.out.println("anonymous ProgrammerInterview");
        }

        public void learn() {
            System.out.println("anonymous, learn ProgrammerInterview");
        }
    };

    public void readIt() {
        /*
         * This is legal:
         */
        pInstance.read();
        /*
         * Compiler error, the learn method is not also defined inside the ProgrammerInterview class:
         */
        // pInstance.learn();
    }
}
