package org.firstinspires.ftc.teamcode.pedroPathing;

import androidx.core.text.util.LocalePreferences;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name="motor tests", group="Robot")
public class MotorTune extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor lb = hardwareMap.get(DcMotor.class, "lb");
        DcMotor lf = hardwareMap.get(DcMotor.class, "lf");
        DcMotor rb = hardwareMap.get(DcMotor.class, "rb");
        DcMotor rf = hardwareMap.get(DcMotor.class, "rf");


        lb.setDirection(DcMotorSimple.Direction.REVERSE);
        lf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.FORWARD);
        rf.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()){
            if (gamepad1.x) {
                lb.setPower(1);
                lf.setPower(1);
                rf.setPower(1);
                rb.setPower(1);
            }
            if (gamepad1.b) {
                lb.setPower(0);
                lf.setPower(0);
                rf.setPower(0);
                rb.setPower(0);
            }

        }
    }
}
