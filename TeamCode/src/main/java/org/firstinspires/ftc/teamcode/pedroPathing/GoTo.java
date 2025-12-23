package org.firstinspires.ftc.teamcode.pedroPathing;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.HeadingInterpolator;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class GoTo implements Features{
    public Pose goToA = new Pose(72,72/3);
    public Pose goToB = new Pose(72,72/2);
    public Pose goToC = new Pose(72,72);
    private Pose start = new Pose(72,0, Math.toRadians(90));

    boolean resetFlag = false;
    public int drivePos = 0;


    public static Pose startingPose; //See ExampleAuto to understand how to use this
    public boolean automatedDrive;
    private Supplier<PathChain> pathChainMiddle;
    private Supplier<PathChain> pathChainLow;
    private Supplier<PathChain> pathChainHigh;

    public Follower follower;

    public void init(HardwareMap hardwareMap) {

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(start == null ? new Pose() : start);
        follower.update();

        pathChainMiddle = () -> follower.pathBuilder() //Lazy Curve Generation
                .addPath(new Path(new BezierLine(start, goToA)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, Math.toRadians(45), 0.8))
                .build();
        pathChainLow = () -> follower.pathBuilder() //Lazy Curve Generation
                .addPath(new Path(new BezierLine(follower::getPose, goToB)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, Math.toRadians(45), 0.8))
                .build();
        pathChainHigh = () -> follower.pathBuilder() //Lazy Curve Generation
                .addPath(new Path(new BezierLine(follower::getPose, goToC)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, Math.toRadians(45), 0.8))
                .build();
    }

    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) {

        if (gamepad1.aWasPressed()) {
            drivePos += 1;


            switch (drivePos) {
                case 1:
                    follower.followPath(pathChainLow.get());
                    automatedDrive = true;
                    break;
                case 2:
                    follower.followPath(pathChainMiddle.get());
                    automatedDrive = true;
                    break;
                case 3:
                    follower.followPath(pathChainHigh.get());
                    automatedDrive = true;
                    break;
                case 4:
                    drivePos = 1;
            }
        }
        //Stop automated following if the follower is done
        if (automatedDrive && (gamepad1.bWasPressed() || !follower.isBusy())) {
            follower.startTeleopDrive();
            automatedDrive = false;
        }
        return Collections.emptyList();
    }
}
