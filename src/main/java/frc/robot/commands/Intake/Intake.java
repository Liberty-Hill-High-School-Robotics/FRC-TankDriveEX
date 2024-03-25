package frc.robot.commands.Intake;

import static frc.robot.Constants.LauncherConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Launcher;

public class Intake extends Command {
  Launcher m_launcher;

  public Intake(Launcher launcher) {

    m_launcher = launcher;

    addRequirements(m_launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Spins both weels in revese to intake note.
    m_launcher.intake(kIntakeLauncherSpeed, kIntakeFeederSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_launcher.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
