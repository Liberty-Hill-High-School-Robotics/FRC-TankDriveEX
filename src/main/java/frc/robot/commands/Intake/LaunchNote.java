package frc.robot.commands.Intake;

import static frc.robot.Constants.LauncherConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Launcher;

public class LaunchNote extends Command {
  Launcher m_launcher;

  public LaunchNote(Launcher launcher) {
    m_launcher = launcher;

    addRequirements(m_launcher);
  }

  // The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set the wheels to launching speed
    m_launcher.setLaunchWheel(kLauncherSpeed);
    m_launcher.setFeedWheel(kLaunchFeederSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_launcher.stop();
  }
}
