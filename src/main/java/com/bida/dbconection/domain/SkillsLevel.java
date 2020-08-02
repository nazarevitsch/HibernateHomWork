package com.bida.dbconection.domain;

public enum SkillsLevel{
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");

    private final String name;

    SkillsLevel(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
