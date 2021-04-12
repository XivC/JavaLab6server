package com.xivs.lab;

import com.xivs.parameters.numericalParameters.DoubleParameter;
import com.xivs.parameters.numericalParameters.LongParameter;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private Long x; //Поле не может быть null
    private Double y; //Максимальное значение поля: 139, Поле не может быть null
    public static Coordinates DEFAULT = new Coordinates(0L, 0D);

    public static class Params {
        public static LongParameter x = new LongParameter(0L);
        public static DoubleParameter y = new DoubleParameter(0D).setUpperBound(139D);
    }

    public Coordinates(Long x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }


}

