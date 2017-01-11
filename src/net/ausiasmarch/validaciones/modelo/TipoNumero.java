package net.ausiasmarch.validaciones.modelo;

public enum TipoNumero {
    INTEGER, DOUBLE;

    @Override
    public String toString() {
        String cad = "";

        switch (this) {
            case INTEGER:
                cad = "Integer";
                break;
            case DOUBLE:
                cad = "Double";

        }
        return cad;
    }
}
