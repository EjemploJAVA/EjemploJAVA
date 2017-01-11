package net.ausiasmarch.validaciones.modelo;

/**
 * Nif.java Validador NIF-NIE
 *
 * @author a023315568p
 */
public class Nif {

    // private static String mensaje;
    public static void valida(String nifnie) throws Exception {
        final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        final String regExp = "^[XYZxyz](-|\\s)?\\d{7}(-|\\s)?[A-Za-z]|"
                + "\\d?\\d{7}(-|\\s)?[A-Za-z]$";
        int dni;
        char letra;
        StringBuilder sb = new StringBuilder();
        // sb.append(nifnie);
        // Si no tiene un formato valida
        if (!nifnie.matches(regExp)) {
            throw new RuntimeException("NIF/NIE con formato no valido");
        }

        // Si es un NIE
        /*
        
         */
        //Si lo primero que se introduce es X , Y o Z..
        if (nifnie.startsWith("X")
                || nifnie.startsWith("Y")
                || nifnie.startsWith("Z")) {
            //Sustituye la letra por su valor correspondiente.
            switch (nifnie.charAt(0)) {
                case 'X':
                    nifnie = nifnie.replace('X', '0');
                    break;
                case 'Y':
                    nifnie = nifnie.replace('Y', '1');
                    break;
                case 'Z':
                    nifnie = nifnie.replace('Z', '2');
                    break;
            }

            //Si detecta '-' o ' ' almacena posicion(0)+(2-n)-2           
            if (nifnie.charAt(1) == ' ' || nifnie.charAt(1) == '-') {

                sb.append(nifnie.charAt(0))
                        .append(nifnie.substring(2, nifnie.length() - 2));
                dni = Integer.parseInt(sb.toString());
            } else {
                // Opera con un nie sin '-' y resta la letra final   
                sb.append(nifnie.substring(0, nifnie.length() - 1));
                dni = Integer.parseInt(sb.toString());
            }

            // Es un NIF
        } else if (nifnie.indexOf('-') >= 0 || nifnie.indexOf(' ') >= 0) {
            dni = Integer.parseInt(nifnie.substring(0, nifnie.length() - 2));
        } else {
            dni = Integer.parseInt(nifnie.substring(0, nifnie.length() - 1));
        }

        letra = letras.charAt(dni % 23);
        nifnie = nifnie.toUpperCase();

        if (!nifnie.endsWith(" " + letra) && !nifnie.endsWith("-" + letra)
                && !nifnie.endsWith("" + letra)) {
            throw new RuntimeException("La letra del NIF o NIE no es correcta");
        }

    }
}
