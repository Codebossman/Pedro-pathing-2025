package org.firstinspires.ftc.teamcode.pedroPathing;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TurnTable implements Features{
    public final double POWER = 0.2;
    private CRServo turnTable;
    public double pos;
    public boolean isOn;
//    private TurnSensor sensor;
    public double distance;
    private double power;
    public ColorRangeSensor colorRangeSensor;
    private List <String> telemetryData;
    private double deltaTime;
    private double time;
    double delay;
    private ElapsedTime runtime = new ElapsedTime();
    boolean tickFlag;
    private ServoEncoder encoder = new ServoEncoder();
    double rightAngle = 2000;
    double ticks;
    @Override
    public void init(HardwareMap hardwareMap) {
        turnTable = hardwareMap.get(CRServo.class, "turn");
        encoder.init(hardwareMap);
        encoder.setEncoderPos(0);
//        colorRangeSensor = hardwareMap.get(ColorRangeSensor.class, "sensor");
        power = 0;
        ticks = 0;
        pos = 0;
        delay = 0.42;
        time = runtime.time();
    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        ticks = encoder.encoderPos;


        if(gamepad2.right_bumper){
            power = POWER;
        }else{
            power = 0;
        }
        if(gamepad2.left_bumper){
            power = -1*POWER;
        }

//        double current = runtime.time();
//
//
//        // Increment or decrement the slide target based on button input
//        if (current > time + delay) {
//
//            if (gamepad2.dpad_right) {
//                isOn = true;
//                time = current;
//            }else{
//                isOn = false;
//            }
//        }
//
//
//        if(isOn){
//            power = 0.15;
//        }else{
//            power = 0;
//        }



        turnTable.setPower(power);
        telemetryData = new ArrayList<>();
        telemetryData.add(String.format(Locale.ENGLISH, "Servo Power: %4.2f", turnTable.getPower()));
//        telemetryData.add(String.format("distance: %4.2f", distance));
        telemetryData.add("Is on: " + (String.valueOf(isOn)));
//        telemetryData.add("tick Flag: " + tickFlag);
//        telemetryData.add("saved Pos: " + ticks);
//        telemetryData.add("current Pos: " + encoder.encoderPos);
//        telemetryData.add(String.format(Locale.ENGLISH, "Delta time: %4.2f", deltaTime));
//        telemetryData.add(String.format(Locale.ENGLISH, "Time plus Delay: %4.2f", (time + delay)));

        return telemetryData;
    }
    public double getPos(){
        return power;
    }
    public double getPOWER(){
        return POWER;
    }
    public double getTicks(){
        return ticks;
    }
    public void setPos(double newPos){
        this.power = newPos;
    }
}
