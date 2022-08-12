package com.example.demo1;

public class Compras {
    private Integer id = null;
    private String constructora = null;
    private String BancoVinculado = null;

    public Compras(Integer id, String constructora, String bancoVinculado) {
        this.id = id;
        this.constructora = constructora;
        BancoVinculado = bancoVinculado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getBancoVinculado() {
        return BancoVinculado;
    }

    public void setBancoVinculado(String bancoVinculado) {
        BancoVinculado = bancoVinculado;
    }
}
