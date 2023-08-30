// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
  public static final class DriverConstants {
  public static final int PPR = 42; //ticks for 1 motor revolution
  public static final double gearRatio = (1/10);
  public static final int diameter = (1/4 );// the diameter in meters
  

     

  }

  public static final int kDriverControllerPort = 0;
  }
  public static class ArmPidConstants{
    public static final int F = 0;
  public static final int P = 0 ;
  public static final int I = 0 ;
  public static final int D = 0;
  public static final int motorID = 1; 
  public static final int kSlotIdx = 0;
  public static int kTimeoutMs = 30;
  public static final PIDController ArmPID = new PIDController(P, I, D);



  }
  
  
  public static int DriveTrainConstants;

}
