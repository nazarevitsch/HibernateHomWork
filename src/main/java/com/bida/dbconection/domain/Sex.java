package com.bida.dbconection.domain;

public enum Sex {
    MALE("MALE"), FEMALE("FEMALE");

    private String name;

    Sex(String name){
        this.name = name;
    }

    public static Sex getSex(String sex) {
        Sex[] s = Sex.values();
        for (int i = 0; i < s.length; i++) {
            if (sex.equals(s[i].name())) {
                return s[i];
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }
}
