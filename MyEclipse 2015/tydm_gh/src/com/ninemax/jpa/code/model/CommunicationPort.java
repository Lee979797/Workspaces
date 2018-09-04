package com.ninemax.jpa.code.model;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-21
 * Time: ÏÂÎç2:28
 * To change this template use File | Settings | File Templates.
 */
public enum CommunicationPort {

    COM1(1),
    COM2(2),
    COM3(3),
    COM4(4),
    COM5(5),
    COM6(6),
    COM7(7),
    COM8(8);
    private Short value;

    CommunicationPort(Integer name) {
        this.value = name.shortValue();
    }


    public String getStatus() {
        return toString();
    }


    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return super.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
