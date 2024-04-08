package com.proyecto.abogado.security;

public class TokenHolder {

    private static final ThreadLocal<String> dniHolder = new ThreadLocal<>();

    public static void setDni(String dni){
        dniHolder.set(dni);
    }

    public static String getDni(){
        return dniHolder.get();
    }

    public static void clear(){
        dniHolder.remove();
    }

}