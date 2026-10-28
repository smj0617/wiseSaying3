package com.back;

public class Main {
    public static void main(String[] args) {
        AppContext.renew();
        App app= new App();
        app.run();
    }
}
