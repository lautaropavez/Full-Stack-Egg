package Enum;

public enum RazaPerro {
    BEAGLE(1234,"Beagle"),COCKER(22222,"Cocker"),PITBULL(3333,"Pitbull"),BORDER_COLLIE(545454,"Collie");
    
    private Integer codigo;
    private String valor;

    private RazaPerro(Integer codigo, String valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getValor() {
        return valor;
    }


}
