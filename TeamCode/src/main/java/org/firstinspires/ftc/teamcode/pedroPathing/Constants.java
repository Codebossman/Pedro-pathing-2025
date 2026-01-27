package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.ftc.localization.constants.TwoWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


/*
    lb is 0
    lf is 1
    rf is 2
    rb is 3

 */

public class Constants {


    public static FollowerConstants followerConstants = new FollowerConstants()
            .forwardZeroPowerAcceleration(-109.89)
            .lateralZeroPowerAcceleration(-66.28)
            .mass(5)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.04, 0, 0.001, 0.029))
            .headingPIDFCoefficients(new PIDFCoefficients(0.3, 0, 0.004, 0.025))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.5, 0, 0.0001, 0.6, 0.025))
            ;


    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 2, 1);


    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .xVelocity(54.0)
            .yVelocity(50.345338)
            .rightFrontMotorName("rf")
            .rightRearMotorName("rb")
            .leftRearMotorName("lb")
            .leftFrontMotorName("lf")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD);


    public static PinpointConstants localizerConstantsPinpoint = new PinpointConstants()
            .forwardPodY(2.5)
            .strafePodX(0)

            .distanceUnit(DistanceUnit.INCH)
            .hardwareMapName("pinpoint")
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pinpointLocalizer(localizerConstantsPinpoint)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .build();
    }

}


