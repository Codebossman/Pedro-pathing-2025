package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MagneticSensor implements Features{
//    DcMotor sensor1 = null;
    TouchSensor sensor = null;
    @Override
    public void init(HardwareMap hardwareMap) {
        sensor = hardwareMap.get(TouchSensor.class, "mag");
//        sensor1 = hardwareMap.get(DcMotor.class, "mag");
//        sensor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {



        List <String> telemetryData = new ArrayList<>();
        telemetryData.add("Magnetic sensor: "+ sensor.isPressed());
        return telemetryData;
    }
}
