package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos.ShootNoteAndMove;
import frc.robot.commands.Drive.DriveArcade;
import frc.robot.commands.Drive.DriveBack;
import frc.robot.commands.Intake.Intake;
import frc.robot.commands.Intake.LaunchNote;
import frc.robot.commands.Intake.PrepLaunch;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Launcher;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems are defined here.
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Launcher m_launcher = new Launcher();
  private static RobotContainer m_robotContainer = new RobotContainer();

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  // The driver's controller
  XboxController m_driverController = new XboxController(OperatorConstants.kDriverControllerPort);
  // The operator's controller
  XboxController m_operatorController = new XboxController(OperatorConstants.kOperatorControllerPort);

  // The container for the robot. Contains subsystems, OI devices, and commands.

  public RobotContainer() {

    SmartDashboard.putData("DriveBack Command", new DriveBack(m_drivetrain));
    SmartDashboard.putData("Intake Command", new Intake(m_launcher));
    SmartDashboard.putData("LaunchNote Command", new LaunchNote(m_launcher));
    SmartDashboard.putData("PrepLaunch Command", new PrepLaunch(m_launcher));

    // Configure the controller bindings
    configureBindings();

    m_chooser.addOption("Shoot Note and drive back", new ShootNoteAndMove(m_drivetrain, m_launcher));

    SmartDashboard.putData("Auto Chooser", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  public XboxController getdriverJoystick() {
    return m_driverController;
  }

  public XboxController getOperatorController() {
    return m_operatorController;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureBindings() {
    // Set the default command
    m_drivetrain.setDefaultCommand((new DriveArcade(m_drivetrain)));

    // Driver controller buttons

    // Operator controller buttons
    final Trigger LaunchNote = new JoystickButton(m_operatorController, 5);
    LaunchNote.whileTrue(new LaunchNote(m_launcher));

    final Trigger PrepLaunch = new JoystickButton(m_operatorController, 6);
    PrepLaunch.toggleOnTrue(new PrepLaunch(m_launcher));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
}
