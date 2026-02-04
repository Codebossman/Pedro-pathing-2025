package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.List;

public class ServoEncoder implements Features{
    private DcMotor encoder = null;
    double encoderPos;
    double RIGHTANGLE = 2000;
    @Override
    public void init(HardwareMap hardwareMap) {
        encoder = hardwareMap.get(DcMotor.class, "encoder");
        encoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        encoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        encoderPos = encoder.getCurrentPosition();

        List <String> telemetryData = new ArrayList<>();
        telemetryData.add("Encoder: " + encoderPos);
        return telemetryData;
    }
    public double getEncoderPos(){
        return encoderPos;
    }
    public double getRIGHTANGLE(){
        return RIGHTANGLE;
    }
    public void setEncoderPos(double newPos){
        this.encoderPos = newPos;
    }
}