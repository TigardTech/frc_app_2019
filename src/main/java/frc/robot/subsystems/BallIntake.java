/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Spinny motor lad, he spin, he win
 */
public class BallIntake extends Subsystem {
  WPI_TalonSRX ballIntake = new WPI_TalonSRX(RobotMap.BALL_INTAKE_MOTOR);
  
  /**
   * Normalize a value in the range [-1, 1] to the range
   * [0, 1]. You may ask a very important question:
   * why is this hardcoded
   * @return normalized value
   */
  private double normalize(double x){
    // lots of final consts so this is easy
    // to port. sure, I could write the function properly
    // but then I wouldn't be able to just call normalize()
    final double X_RANGE_MAX = 1;
    final double X_RANGE_MIN = -1;
    final double NEW_RANGE_MAX = 1;
    final double NEW_RANGE_MIN = 0;

    return (NEW_RANGE_MAX - NEW_RANGE_MIN)*((x - X_RANGE_MIN)/(X_RANGE_MAX-X_RANGE_MIN))+NEW_RANGE_MIN;
  }

  /**
   * Spin the motor(s) attached to the intake, automagically
   * scaling the input from [-1, 1] to [0, 1] to keep things
   * going the right way around
   */
   public void spin(double quickness){
    ballIntake.set(ControlMode.PercentOutput, normalize(quickness));
   }

   /**
    * tell the motor to do absolutely nothing
    */
    public void stop(){
      final double ADVANCED_NOTHING = 0;
      ballIntake.set(ControlMode.PercentOutput, ADVANCED_NOTHING);
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
