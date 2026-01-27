package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class Paths {

    public Pose redStartHigh = new Pose(120.000, 120.000);
    public Pose redStartLow = new Pose(84.000, 12.000);
    public Pose blueStartHigh = new Pose(24.000, 120.000);
    public Pose blueStartLow = new Pose(56.000, 8.000);

    public PathChain firstBalls;
    public PathChain firstShoot;
    public PathChain secondBalls;
    public PathChain secondShoot;
    public PathChain thirdBalls;
    public PathChain thirdShoot;
    public PathChain redLow;
    public PathChain redHigh;
    public PathChain blueLow;
    public PathChain blueHigh;
    public Paths(Follower follower) {
        blueLow = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(56.000, 8.000),
                                new Pose(59.000, 39.000),
                                new Pose(41.000, 36.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                .build();

        blueHigh = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(24.000, 120.000),
                                new Pose(45.800, 106.000),
                                new Pose(44.000, 84.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(180))
                .build();
        redLow = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(84.000, 12.000), new Pose(84.000, 48.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(0))
                .build();
        redHigh = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(120.000, 120.000), new Pose(82.000, 120.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(270))
                .build();
        firstBalls = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(56.000, 8.000),
                                new Pose(65.000, 36.000),
                                new Pose(22.000, 36.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                .build();

        firstShoot = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(22.000, 36.000),
                                new Pose(76.000, 27.000),
                                new Pose(34.000, 108.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(135))
                .build();

        secondBalls = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(34.000, 108.000),
                                new Pose(65.000, 55.000),
                                new Pose(22.000, 60.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(135), Math.toRadians(180))
                .build();

        secondShoot = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(22.000, 60.000),
                                new Pose(65.000, 55.000),
                                new Pose(34.000, 108.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(135))
                .build();

        thirdBalls = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(34.000, 108.000),
                                new Pose(56.000, 78.000),
                                new Pose(22.000, 84.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(135), Math.toRadians(180))
                .build();

        thirdShoot = follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(22.000, 84.000),
                                new Pose(56.000, 78.000),
                                new Pose(34.000, 108.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(135))
                .build();
    }
}
