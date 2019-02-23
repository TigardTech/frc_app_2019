/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pair of pneumatic pistons for getting the discusii
 */
@Deprecated
public class PlatePistons extends Subsystem {
    enum Extended {
        SHOVE, GRAB, BOTH, NONE, OVERRIDE
    }
    int grabID, shoveID;
    Extended currentState = Extended.OVERRIDE;

    public PlatePistons(int grabID, int shoveID){
        this.grabID = grabID;
        this.shoveID = shoveID;
    }

    GenericSolenoid plateGrab = new GenericSolenoid(grabID);
    GenericSolenoid plateShove = new GenericSolenoid(shoveID);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void cycleState() {
        // minecraft
    }

    public void setGrab(boolean extended) {
        plateGrab.set(extended);
    }

    public void setShove(boolean extended) {
        plateShove.set(extended);
    }
}
