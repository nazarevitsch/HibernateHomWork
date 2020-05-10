package com.bida.dbconection.domain;

public enum ProgramingLanguage {
    Java("Java"),
    JavaScript("JavaScript"),
    CSH("C#"),
    CPP("C++");

    private String name;

    private ProgramingLanguage(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
