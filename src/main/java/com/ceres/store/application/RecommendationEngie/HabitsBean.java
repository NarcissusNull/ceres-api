package com.ceres.store.application.RecommendationEngie;

public class HabitsBean extends BasicBean {
    private int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HabitsBean() {
        this(-1);
    }

    public HabitsBean(int id) {
        this.id = id;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("HabitBean " + this.id + " :");
        str.append(super.toString());
        return str.toString();
    }

}