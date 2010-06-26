package com.adina.vo;

public class FunctieVO {

    private Long id;
    private String name;

    public FunctieVO(Long idFunctie, String numeFunctie) {
        this.id = idFunctie;
        this.name = numeFunctie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
