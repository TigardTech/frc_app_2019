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

public class OpenSolenoid extends Command {
    private GenericSolenoid ourSol;
    private boolean runningForGeneric = false;


    /**
     * Run OpenSolenoid with a hardcoded Solenoid
     */
    @Deprecated
    public OpenSolenoid() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.intakeSol);
    }

    /**
     * Run OpenSolenoid with a specific Solenoid, passed to the command.
     * @param gs The solenoid.
     */
    public OpenSolenoid(GenericSolenoid gs) {
        requires(gs);
        ourSol = gs;
        runningForGeneric = true;
    }

    @Override
    protected boolean isFinished() {
        if(runningForGeneric) {
            ourSol.set(true);
        } else { 
            Robot.intakeSol.set(true);
        }
        return true;
    }
}