package org.firstinspires.ftc.teamcode.pedroPathing;

public enum GobuildaLEDColor {
    BLACK("black", 0.0),
    RED("red", 0.279),
    BLUE("blue", 0.611),
    YELLOW("yellow", 0.388),
    GREEN("green", 0.500),
    PURPLE("purple", 0.722),

    ;

    private final String description;

    private final double value;
    private GobuildaLEDColor(String description, double value) {
        this.description = description;
        this.value = value;
    }
    public double getValue() {
        return value;
    }

    public String toString() {
        return description;
    }
}
