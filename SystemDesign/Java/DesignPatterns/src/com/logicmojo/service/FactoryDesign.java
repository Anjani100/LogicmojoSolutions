package com.logicmojo.service;

class MiBolt extends MiModel {
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

class MiFire extends MiModel {
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

class MiFactoryMethodClass {
    static MiModel getInstance(String model) {
        MiModel mobile = null;
        if (model.equalsIgnoreCase("MiBolt")) {
            mobile = new MiBolt();
        }
        else if (model.equalsIgnoreCase("MiFire")) {
            mobile = new MiFire();
        }
        return mobile;
    }
}

class MiModelFactoryImpl {
    public static MiModel produceMobile(String model) {
        MiModel mobile = MiFactoryMethodClass.getInstance(model);
        return mobile;
    }
}

abstract class MiModel {
    public abstract void CPU();
    public abstract void RAM();
    public abstract void Price();
}

public class FactoryDesign {
    public static void main(String[] args) {
        MiModel MiBoltMobile = MiModelFactoryImpl.produceMobile("MiBolt");
        MiBoltMobile.CPU();
        MiBoltMobile.RAM();
        MiBoltMobile.Price();

        MiModel MiFireMobile = MiModelFactoryImpl.produceMobile("MiFire");
        MiFireMobile.CPU();
        MiFireMobile.RAM();
        MiFireMobile.Price();
    }
}
