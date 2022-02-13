package com.logicmojo.service;

import java.util.ArrayList;

class XMiBolt extends XMiModel {
    @Override
    public int Price() {
        System.out.println("$250");
        return 250;
    }
}

class XMiFire extends XMiModel {
    @Override
    public int Price() {
        System.out.println("$350");
        return 350;
    }
}

abstract class XMiModel {
    public abstract int Price();
}

abstract class SubscriptionModel extends XMiModel {
    public abstract int Price();
    public abstract void Duration();
}

class Annual extends SubscriptionModel {
    @Override
    public int Price() {
        System.out.println("$100");
        return 100;
    }
    @Override
    public void Duration() {
        System.out.println("12 months");
    }
}

class Quarter extends SubscriptionModel {
    @Override
    public int Price() {
        System.out.println("$30");
        return 30;
    }
    @Override
    public void Duration() {
        System.out.println("3 months");
    }
}

class Assembly {
    ArrayList<XMiModel> models = new ArrayList<>();
    public float showCost() {
        int cost = 0;
        for (XMiModel model : models) {
            cost += model.Price();
        }
        return cost;
    }
}

class Builder {
    public Assembly assembleMobile(String subscription) {
        Assembly am = new Assembly();
        if (subscription.equalsIgnoreCase("Premium")) {
            am.models.add(new XMiFire());
            am.models.add(new XMiBolt());
            am.models.add(new Quarter());
        }
        else if (subscription.equalsIgnoreCase("Gold")) {
            am.models.add(new XMiFire());
            am.models.add(new XMiBolt());
            am.models.add(new Annual());
        }
        return am;
    }
}

public class BuilderDesign {
    public static void main(String[] args) {
        Builder builder = new Builder();
        Assembly assembly = builder.assembleMobile("Premium");
        System.out.println("$" + assembly.showCost());
    }
}
