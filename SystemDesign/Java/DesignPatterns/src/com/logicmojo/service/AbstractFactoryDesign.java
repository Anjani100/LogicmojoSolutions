package com.logicmojo.service;

class XiaomiBolt extends XiaomiModel {
    @Override
    public void CPU() {
        System.out.println("C3");
    }
    @Override
    public void RAM() {
        System.out.println("4GB");
    }
    @Override
    public void Price() {
        System.out.println("$250");
    }
}

class XiaomiFire extends XiaomiModel {
    @Override
    public void CPU() {
        System.out.println("C4");
    }
    @Override
    public void RAM() {
        System.out.println("8GB");
    }
    @Override
    public void Price() {
        System.out.println("$350");
    }
}

class XiaomiPlus extends XiaomiModel {
    @Override
    public void CPU() {
        System.out.println("C5");
    }
    @Override
    public void RAM() {
        System.out.println("12GB");
    }
    @Override
    public void Price() {
        System.out.println("$450");
    }
}

abstract class XiaomiFactory {
    public abstract XiaomiModel produceMobile(String model);

    public XiaomiModel configureMobile(String model) {
        XiaomiModel mobile = produceMobile(model);
        return mobile;
    }
}

class LondonFactory extends XiaomiFactory {
    @Override
    public XiaomiModel produceMobile(String model) {
        XiaomiModel mobile = null;
        if (model.equalsIgnoreCase("MiBolt")) {
            mobile = new XiaomiBolt();
        }
        else if (model.equalsIgnoreCase("MiFire")) {
            mobile = new XiaomiFire();
        }
        return mobile;
    }
}

class NYFactory extends XiaomiFactory {
    @Override
    public XiaomiModel produceMobile(String model) {
        XiaomiModel mobile = null;
        if (model.equalsIgnoreCase("MiPlus")) {
            mobile = new XiaomiPlus();
        }
        else if (model.equalsIgnoreCase("MiFire")) {
            mobile = new XiaomiFire();
        }
        return mobile;
    }
}

abstract class XiaomiModel {
    public abstract void CPU();
    public abstract void RAM();
    public abstract void Price();
}

public class AbstractFactoryDesign {
    public static void main(String[] args) {
        XiaomiFactory londonFactory = new LondonFactory();
        XiaomiModel fireMobile = londonFactory.configureMobile("MiFire");
        fireMobile.CPU();
        fireMobile.RAM();
        fireMobile.Price();

        XiaomiFactory nyFactory = new NYFactory();
        XiaomiModel plusMobile = nyFactory.configureMobile("MiPlus");
        plusMobile.CPU();
        plusMobile.RAM();
        plusMobile.Price();
    }
}
