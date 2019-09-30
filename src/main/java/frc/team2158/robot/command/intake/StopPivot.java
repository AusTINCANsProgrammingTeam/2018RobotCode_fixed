package frc.team2158.robot.command.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;

import java.util.logging.Logger;

public class StopPivot extends Command {
    private static final Logger LOGGER = Logger.getLogger(StopPivot.class.getName());


    public StopPivot() {
        requires(Robot.getIntakeSubsystem());
    }


    @Override
    protected void initialize() {
        Robot.getIntakeSubsystem().stopPivot();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
