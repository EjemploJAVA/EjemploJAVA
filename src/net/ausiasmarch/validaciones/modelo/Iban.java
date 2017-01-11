/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.validaciones.modelo;

import java.math.BigInteger;

/**
 *
 * @author a023315568p
 */
public class Iban {
    
    private final static String PAIS = "ES";
    private final static String FORMATO = "\\d{20}";
    private final static BigInteger MODULO = new BigInteger("97");
    
    private static String cuenta;
    private static String mensaje;

    public static void valida(String iban) throws Exception {
        final String expReg = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}";

        if (!iban.matches(expReg)) {
            throw new RuntimeException("Formato de IBAN no válido.");
        }

    }
}
