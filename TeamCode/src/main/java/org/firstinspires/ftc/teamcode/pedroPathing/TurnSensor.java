package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TurnSensor implements Features{
    public ColorRangeSensor colorRangeSensor;
    public double distance;

    @Override
    public void init(HardwareMap hardwareMap) {
        colorRangeSensor = hardwareMap.get(ColorRangeSensor.class, "sensor");

    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) {
        distance = colorRangeSensor.getDistance(DistanceUnit.CM);

        List <String> telemetryData = new ArrayList<>();
        telemetryData.add(String.format(Locale.ENGLISH, "Distance: %4.2f", distance));
        return telemetryData;
    }
}
