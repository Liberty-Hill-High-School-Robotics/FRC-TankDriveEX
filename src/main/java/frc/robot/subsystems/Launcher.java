package frc.robot.subsystems;

import static frc.robot.Constants.LauncherConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {
  private WPI_VictorSPX launchMotor;
  private WPI_VictorSPX feedMotor;

  public Launcher() {
    launchMotor = new WPI_VictorSPX(kLauncherID);
    feedMotor = new WPI_VictorSPX(kFeederID);
  }

  public void setLaunchWheel(double speed) {
    launchMotor.set(speed);
  }

  public void setFeedWheel(double speed) {
    feedMotor.set(speed);
  }

  public void intake(double Lspeed, double Fspeed) {
    launchMotor.set(Lspeed);
    feedMotor.set(Fspeed);
  }

  public void stop() {
    launchMotor.set(0);
    feedMotor.set(0);
  }
}
