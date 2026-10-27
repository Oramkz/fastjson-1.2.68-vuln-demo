package com.example.vulndemo.service;

import javax.naming.Context;
import javax.naming.InitialContext;

public class SafeUrlChecker implements AutoCloseable {

    private final String url;

    public SafeUrlChecker(String url) {
        this.url = url;
        System.out.println("[SafeUrlChecker] " + url);
        try {
            Context ctx = new InitialContext();
            Object object = ctx.lookup(url);
        } catch (Exception e) {
            System.out.println("[SafeUrlChecker] " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public void close() {
    }
}
