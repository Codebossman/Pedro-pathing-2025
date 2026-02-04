package org.firstinspires.ftc.teamcode.pedroPathing.Auto;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedroPathing.ServoEncoder;
import org.firstinspires.ftc.teamcode.pedroPathing.TurnTable;

public class TurnTableAuto {
    private TurnTable turnTable = null;
    private ServoEncoder encoder = null;
    boolean whileFlag = true;
    public void init(){
        turnTable = new TurnTable();

    }
    public void driveLoop(){

    }
}
