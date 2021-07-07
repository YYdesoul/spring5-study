package com.soul.staticProxy;

public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("Host rent the apartment");
    }
}
