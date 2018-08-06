package com.company;

import java.util.ArrayList;
import java.util.List;

public class BusObj {

    class marketUnit {
        String name;
        String typ;
        String group;
        String edinica;
        String tiker;
        String ref;
        String id;


        public marketUnit(String name, String typ, String group, String edinica, String tiker, String ref, String id) {
            this.name = name;
            this.typ = typ;
            this.group = group;
            this.edinica = edinica;
            this.tiker = tiker;
            this.ref = ref;
            this.id = id;
        }
    }

    List<marketUnit> units;

    public BusObj() {
        units = new ArrayList<>(1);
        units.add(new marketUnit("Фьючерс на золото", "Товар", "Металлы", "1 тройская унция", "GCQ8", "https://ru.investing.com/commodities/gold-historical-data", "8830"));
        units.add(new marketUnit("Фьючерс на медь", "Товар", "Металлы", "1 фунт", "HGU8", "https://ru.investing.com/commodities/copper-historical-data", "8831"));
        units.add(new marketUnit("Фьючерс на кофе США С", "Товар", "Сельское хозяйство", "1 фунт", "KCU8", "https://ru.investing.com/commodities/us-coffee-c-historical-data", "8832"));
        units.add(new marketUnit("Фьючерс на нефть Brent", "Товар", "Энергетика", "1 баррель", "LCOU8", "https://ru.investing.com/commodities/brent-oil-historical-data", "8833"));
        units.add(new marketUnit("Фьючерс на серебро", "Товар", "Металлы", "1 тройская унция", "SIU8", "https://ru.investing.com/commodities/silver-historical-data", "8836"));
        units.add(new marketUnit("Фьючерсы на нефть WTI", "Товар", "Энергетика", "1 баррель", "CLQ8", "https://ru.investing.com/commodities/crude-oil-historical-data", "8849"));
        units.add(new marketUnit("Фьючерс на хлопок США №2", "Товар", "Сельское хозяйство", "1 фунт", "CTZ8", "https://ru.investing.com/commodities/us-cotton-no.2-historical-data", "8851"));
        units.add(new marketUnit("Фьючерс на природный газ", "Товар", "Энергетика", "1 Mmbtu", "NGQ8", "https://ru.investing.com/commodities/natural-gas-historical-data", "8862"));
        units.add(new marketUnit("Фьючерс на сахар США №11", "Товар", "Сельское хозяйство", "1 фунт", "SBV8", "https://ru.investing.com/commodities/us-sugar-no11-historical-data", "8869"));
        units.add(new marketUnit("Фьючерс на палладий", "Товар", "Металлы", "1 тройская унция", "PAU8", "https://ru.investing.com/commodities/palladium-historical-data", "8883"));
        units.add(new marketUnit("Фьючерс на платину", "Товар", "Металлы", "1 тройская унция", "PLV8", "https://ru.investing.com/commodities/platinum-historical-data", "8910"));
        units.add(new marketUnit("Фьючерс на живой скот", "Товар", "Сельское хозяйство", "1 фунт", "LEQ8", "https://ru.investing.com/commodities/live-cattle-historical-data", "8914"));
        units.add(new marketUnit("Фьючерс на пшеницу США", "Товар", "Сельское хозяйство", "1 бушель", "ZWU8", "https://ru.investing.com/commodities/us-wheat-historical-data", "8917"));
        units.add(new marketUnit("Фьючерс на кукурузу США", "Товар", "Сельское хозяйство", "1 бушель", "ZCU8", "https://ru.investing.com/commodities/us-corn-historical-data", "8918"));
        units.add(new marketUnit("Фьючерс на соевую муку США", "Товар", "Сельское хозяйство", "1 тонна", "ZMQ8", "https://ru.investing.com/commodities/us-soybean-meal-historical-data", "8919"));
        units.add(new marketUnit("Фьючерс на алюминий", "Товар", "Металлы", "1 тонна", "MALc1", "https://ru.investing.com/commodities/aluminum-historical-data", "49768"));
        units.add(new marketUnit("Фьючерс на свинец", "Товар", "Металлы", "1 Kg", "MLDN8", "https://ru.investing.com/commodities/lead-historical-data", "49784"));
        units.add(new marketUnit("Фьючерс на бензин RBOB", "Товар", "Энергетика", "1 галлон", "RBQ8", "https://ru.investing.com/commodities/gasoline-rbob-historical-data", "954867"));
        units.add(new marketUnit("Фьючерс на цинк", "Товар", "Металлы", "1 метрическая тонна", "MZNc1", "https://ru.investing.com/commodities/zinc-historical-data?cid=956470", "956470"));
        units.add(new marketUnit("Фьючерс на овес", "Товар", "Сельское хозяйство", "", "Oc1", "https://ru.investing.com/commodities/oats-historical-data", "959199"));
        units.add(new marketUnit("Фьючерс на никель", "Товар", "Металлы", "", "NICKELc1", "https://ru.investing.com/commodities/nickel-historical-data?cid=959208", "959208"));
        units.add(new marketUnit("Фьючерс на олово", "Товар", "Металлы", "", "TINc1", "https://ru.investing.com/commodities/tin-historical-data", "959209"));

    }


}
