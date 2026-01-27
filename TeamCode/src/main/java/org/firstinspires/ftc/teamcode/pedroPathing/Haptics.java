package org.firstinspires.ftc.teamcode.pedroPathing;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Haptics implements Features{
    private DistanceSensor sensor = null;
    private Servo led = null;


    @Override
    public void init(HardwareMap hardwareMap) {
        sensor = hardwareMap.get(DistanceSensor.class, "distance");
        led = hardwareMap.get(Servo.class, "led");
        led.setPosition(0);

    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        if(sensor.getDistance(DistanceUnit.CM) <= 10) {
            led.setPosition(GobuildaLEDColor.GREEN.getValue());
        }else{
            led.setPosition(0);
        }


        List <String> telemetryData = new ArrayList<>();
        telemetryData.add("Distance: " + sensor.getDistance(DistanceUnit.CM));
        telemetryData.add("LED Is: " + led.getPosition());
        return telemetryData;
    }
}
