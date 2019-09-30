package frc.team2158.robot.command.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;
import frc.team2158.robot.subsystem.lift.LiftSubsystem;

import java.util.logging.Logger;

public class MoveLift extends Command {
    private static final Logger LOGGER = Logger.getLogger(MoveLift.class.getName());
    private LiftSubsystem.Direction direction;
    private double speed;


    public MoveLift(LiftSubsystem.Direction direction, double speed) {
        requires(Robot.getLiftSubsystem());
        this.direction = direction;
        this.speed = speed;
    }


    @Override
    protected void initialize() {
        Robot.getLiftSubsystem().moveLift(direction, speed);
    }

    @Override
    protected void execute() {
        Robot.getLiftSubsystem().moveLift(direction, speed);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
