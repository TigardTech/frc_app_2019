/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Spinny motor lad, he spin, he win
 */
public class BallIntake extends Subsystem {
    WPI_VictorSPX ballIntake = new WPI_VictorSPX(RobotMap.BALL_INTAKE_MOTOR);
    //Solenoid intakeSol1 = new Solenoid(RobotMap.INTAKE_SOLENOID);

    public BallIntake() {
        ballIntake.setInverted(true);
    }
        
    /**
     * Normalize a value in the range [-1, 1] to the range
     * [0, 1].
     * @return normalized value
     */
    private double normalize(double x){
        // lots of final consts so this is easy
        final double X_RANGE_MAX = 1;
        final double X_RANGE_MIN = -1;
        final double NEW_RANGE_MAX = 1;
        final double NEW_RANGE_MIN = 0;

        return this.normalize(X_RANGE_MIN, X_RANGE_MAX, NEW_RANGE_MIN, NEW_RANGE_MAX, x);
    }
        
    /**
     * Normalize a value in the range [X_RANGE_MIN, 
     * X_RANGE_MAX] to the range [NEW_RANGE_MIN, 
     * NEW_RANGE_MAX].
     * @return normalized value
     */
    private double normalize(double X_RANGE_MIN, double X_RANGE_MAX, double NEW_RANGE_MIN, double NEW_RANGE_MAX, double x){
        return (NEW_RANGE_MAX - NEW_RANGE_MIN) * (
            (x - X_RANGE_MIN) / (X_RANGE_MAX - X_RANGE_MIN)
        ) + NEW_RANGE_MIN;
    }

    /**
     * Spin the motor(s) attached to the intake, automagically
     * scaling the input from [-1, 1] to [0, 1] to keep things
     * going the right way around
     */
    public void spin(double quickness) {
        ballIntake.set(ControlMode.PercentOutput, normalize(quickness));
    }

    /**
        * tell the motor to do absolutely nothing
        */
    public void stop() {
        final double ADVANCED_NOTHING = 0;
        ballIntake.set(ControlMode.PercentOutput, ADVANCED_NOTHING);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

}