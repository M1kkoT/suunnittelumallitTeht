package Facade;

public class ComputerFacade {
    private CPU cpu_;
    private Memory memory_;
    private HardDrive hard_drive_;
    private final long kBootAddress = 0;
    private final long kBootSector = 0;
    private final int kSectorSize = 32;

    public ComputerFacade() {
        cpu_ = new CPU();
        memory_ = new Memory();
        hard_drive_ = new HardDrive();
    }

    public void Start() {
        cpu_.Freeze();
        memory_.Load(kBootAddress, hard_drive_.Read(kBootSector, kSectorSize));
        cpu_.Jump(kBootAddress);
        cpu_.Execute();
    }
}
