/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Generic Subsystem for a generic solenoid. Trying to avoid refrencing
 * instances in the Robot directly with this, we'll see how it goes.
 */
public class GenericSolenoid extends Subsystem {
    int solenoidId;
    Solenoid thisSol;

    /**
     * A solenoid that isn't strictly part of a subsystem, and therefore
     * doesn't need any special treatment.
     * 
     * @param solId Solenoid port ID on the PCM.
     */
    public GenericSolenoid(int solId) {
        this.solenoidId = solId;
        System.out.printf("Trying to create solenoid %d%n", solId);
        this.thisSol = new Solenoid(solenoidId);
        System.out.printf("Created solenoid %d!%n", solId);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    /**
     * Set if the solenoid is extended or retracted.
     * @param state
     */
    public void set(boolean state){
        thisSol.set(state);
    }
}
