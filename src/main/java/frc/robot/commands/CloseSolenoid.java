/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CloseSolenoid extends Command {
    public CloseSolenoid() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.intakeSol);
    }

    @Override
    protected boolean isFinished() {
        Robot.intakeSol.set(false);
        return true;
    }
}