package com.soul.staticProxy;

public class Proxy implements Rent{

    Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        this.visitApartment();
        host.rent();
        this.makeContract();
    }

    public void makeContract() {
        System.out.println("proxy make contract");
    }

    public void visitApartment() {
        System.out.println("proxy lead you to visit apartment.");
    }
}
