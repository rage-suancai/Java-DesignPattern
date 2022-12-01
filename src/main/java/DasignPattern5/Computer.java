package DasignPattern5;

/**
 * @author YXS
 * @PackageName: DasignPattern5
 * @ClassName: Computer
 * @Desription:
 * @date 2022/11/23 11:00
 */
public class Computer implements SmartDevice {

    @Override
    public String getCpu() {
        return "i9-12900K";
    }

    @Override
    public String getType() {
        return "电脑";
    }

    @Override
    public String getMemory() {
        return "32G DDR5";
    }

}
