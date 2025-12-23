package org.firstinspires.ftc.teamcode.pedroPathing;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.HeadingInterpolator;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;


public class Intake implements Features {


    DcMotor intake = null;

    double speed = 0;
    double cap = 100;

    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class, "intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake.setDirection(DcMotorSimple.Direction.FORWARD)
        ;
    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) {
        if (gamepad1.dpadDownWasPressed()) {
            speed -= 1;
        }
        if (gamepad1.dpadUpWasPressed()) {
            speed += 1;
        }
        if (speed >= cap) {
            speed = cap;
        }
        if (speed <= 0) {
            speed = 0;
        }
        intake.setPower(speed);

        return Collections.emptyList();
    }

}
