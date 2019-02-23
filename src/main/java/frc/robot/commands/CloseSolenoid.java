/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.GenericSolenoid;

public class CloseSolenoid extends Command {
    private GenericSolenoid ourSol;
    private boolean runningForGeneric = false;

    /**
     * Run CloseSolenoid with a hardcoded Solenoid
     */
    @Deprecated
    public CloseSolenoid() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.intakeSol);
        this.setInterruptible(true);
    }

    /**
     * Run CloseSolenoid with a specific solenoid, passed to the command.
     * @param gs The solenoid to * A C T U A T E *
     */
    public CloseSolenoid(GenericSolenoid gs) {
        requires(gs);
        ourSol = gs;
        runningForGeneric = true;
    }

    @Override
    protected boolean isFinished() {
        if(runningForGeneric) {
            ourSol.set(false);
        } else {
            Robot.intakeSol.set(false);
        }
        return true;
    }
}