package ru.all_mind.servlet.objects;

public class Human {
    private String name;
    private String second_name;

    public Human(String name, String second_name){
        this.name = name;
        this.second_name = second_name;
    }

    public String getName(){
        return name;

    }

    public String getSecond_name() {
        return second_name;
    }
}
