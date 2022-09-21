package org;

import lombok.extern.log4j.Log4j2;

public class InterfaceSegregationPrinciple {
}

interface Instrument {

}

interface Printer {
    void print();
}

interface Fax {
    void sendFax();
}

@Log4j2
class BasicPrinter implements Printer {

    @Override
    public void print() {
        log.info("Basic Printing work");
    }
}

@Log4j2
class AdvancePrinter implements Printer, Fax {

    @Override
    public void print() {
        log.info("Advance Printing work");
    }

    @Override
    public void sendFax() {
        log.info("Advance Faxing work");
    }
}


