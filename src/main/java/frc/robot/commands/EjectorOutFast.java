/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class EjectorOutFast extends CommandGroup {
    /**
     * LAUNCH THE BALL AT MAXIMUM SPEED AS GOD INTENDED
     */
    public EjectorOutFast() {
        if(Robot.ejector.getEjectorSpeed() != 1) {
            addSequential(new SetEjectorSpeed(1));
        }
        addSequential(new EjectorControlledSpin(false));
    }
}
