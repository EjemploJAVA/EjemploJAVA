/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.validaciones.modelo;

/**
 * Email.java validador de direcciones de correo
 *
 * @author a023315568p
 */
public class Email {

    public static void valida(String email) throws Exception {
        final String expReg = "^[A-Za-z0-9\\-\\._]+@[A-Za-z0-9\\-\\._]+\\.[A-Za-z]{2,}$";

        if (!email.matches(expReg)) {
            throw new RuntimeException("Formato de e-mail no válido");
        }

    }

}
