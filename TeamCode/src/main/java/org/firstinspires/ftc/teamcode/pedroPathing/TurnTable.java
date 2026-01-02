package org.firstinspires.ftc.teamcode.pedroPathing;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TurnTable implements Features{
    private CRServo turnTable;
    public double pos;
    public boolean isOn;
//    private TurnSensor sensor;
    public double distance;
    private double power;
    public ColorRangeSensor colorRangeSensor;
    private List <String> telemetryData;
//    private boolean isOn = false;
    @Override
    public void init(HardwareMap hardwareMap) {
        turnTable = hardwareMap.get(CRServo.class, "turn");

//        colorRangeSensor = hardwareMap.get(ColorRangeSensor.class, "sensor");
        power = 0;
        pos = 0;

    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) {
//        distance = colorRangeSensor.getDistance(DistanceUnit.INCH);
        if(!isOn){
            power = 0;
        }
        if(!gamepad1.left_bumper){
            isOn = false;
            power = 0;
        }else{
            isOn = true;
            power = 0.1;
        }
        if(!gamepad1.right_bumper){
            isOn = false;
            power = 0;
        }else {
            isOn = true;
            power = 0.1;
        }
        turnTable.setPower(power);
        telemetryData = new ArrayList<>();
        telemetryData.add(String.format(Locale.ENGLISH, "Servo Power: %4.2f", turnTable.getPower()));
        telemetryData.add(String.format("distance: %4.2f", distance));
        telemetryData.add("Is on: " + (String.valueOf(isOn)));

        return telemetryData;
    }
}
