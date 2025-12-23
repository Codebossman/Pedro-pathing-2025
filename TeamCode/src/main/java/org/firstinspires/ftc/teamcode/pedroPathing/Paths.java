package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class Paths {

    public PathChain firstBalls;
    public PathChain firstShoot;
    public PathChain secondBalls;
    public PathChain secondShoot;
    public PathChain thirdBalls;
    public PathChain thirdShoot;

    public Paths(Follower follower) {
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
