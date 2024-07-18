package com.agriculture_platform.Authentication.Config;

public class JwtLocalStorage {
    private static String jwt;

    public static String getJwt() {
        if (jwt == null) {
            return null;
        }
        return jwt;
    }

    public static void setJwt(String jwt) {
        JwtLocalStorage.jwt = jwt;
    }

    public static void removeJwt() {
        JwtLocalStorage.jwt = null;
    }
}
