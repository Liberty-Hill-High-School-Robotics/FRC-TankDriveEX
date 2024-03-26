package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.kLeftFrontID;
import static frc.robot.Constants.DrivetrainConstants.kLeftRearID;
import static frc.robot.Constants.DrivetrainConstants.kRightFrontID;
import static frc.robot.Constants.DrivetrainConstants.kRightRearID;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private WPI_VictorSPX leftFront;
  private WPI_VictorSPX leftRear;
  private WPI_VictorSPX rightFront;
  private WPI_VictorSPX rightRear;
  private DifferentialDrive m_drivetrain;

  public Drivetrain() {

    leftFront = new WPI_VictorSPX(kLeftFrontID);
    leftRear = new WPI_VictorSPX(kLeftRearID);
    rightFront = new WPI_VictorSPX(kRightFrontID);
    rightRear = new WPI_VictorSPX(kRightRearID);

    leftFront.setInverted(false);
    rightFront.setInverted(true);

    leftRear.setInverted(true);
    rightRear.setInverted(true);

    rightRear.follow(rightFront);
    leftRear.follow(leftFront);

    rightFront.setInverted(true);
    leftFront.setInverted(true);

    m_drivetrain = new DifferentialDrive(leftFront, rightFront);
    m_drivetrain.setSafetyEnabled(true);
    m_drivetrain.setExpiration(0.1);
    m_drivetrain.setMaxOutput(1.0);
  }

  public void driveArcade(double leftStick, double rightStick) {
    m_drivetrain.tankDrive(leftStick, rightStick);
  }

  public void driveBack(double speed) {
    rightFront.set(speed);
    leftFront.set(speed);
  }

  public void stop() {
    rightFront.stopMotor();
    leftFront.stopMotor();
  }

  @Override
  public void periodic() {
     SmartDashboard.putNumber("LeftRear", leftRear.get());
     SmartDashboard.putNumber("LeftFront", leftFront.get());
     SmartDashboard.putNumber("RightRear", rightRear.get());
     SmartDashboard.putNumber("RightFront", rightFront.get());
  }
}
