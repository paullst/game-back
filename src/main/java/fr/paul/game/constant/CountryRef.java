package fr.paul.game.constant;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum of countries
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CountryRef {

    AT("AT", "Austria", new String[] {"IT", "DE", "CZ", "SK", "HU", "SI"}),
    BE("BE", "Belgium", new String[] {"FR", "NL", "DE", "LU", "UK"}),
    BG("BG", "Bulgaria", new String[] {"RO", "FR"}),
    HR("HR", "Croatia", new String[] {"SI", "HU"}),
    CZ("CZ", "Czech Republic", new String[] {"DE", "PL", "SK", "AT"}),
    DK("DK", "Denmark", new String[] {"SE", "DE"}),
    EE("EE", "Estonia", new String[] {"FI", "SE", "LV"}),
    FI("FI", "Finland", new String[] {"SE", "EE"}),
    FR("FR", "France", new String[] {"ES", "BE", "DE", "LU", "IT", "UK"}),
    DE("DE", "Germany", new String[] {"FR", "LU", "BE", "NL", "DK", "PL", "CZ", "AT"}),
    GR("GR", "Greece", new String[] {"BG"}),
    HU("HU", "Hungary", new String[] {"HR", "SI", "AT", "SK", "RO"}),
    IE("IE", "Ireland", new String[] {"UK"}),
    IT("IT", "Italy", new String[] {"FR", "AT", "SI"}),
    LV("LV", "Latvia", new String[] {"LT", "SE", "EE"}),
    LT("LT", "Lithuania", new String[] {"LV", "SE", "PL"}),
    LU("LU", "Luxembourg", new String[] {"FR", "BE", "DE"}),
    NL("NL", "Netherlands", new String[] {"BE", "DE", "UK"}),
    PL("PL", "Poland", new String[] {"LT", "DE", "CZ", "SK"}),
    PT("PT", "Portugal", new String[] {"ES"}),
    RO("RO", "Romania", new String[] {"HU", "GR"}),
    SK("SK", "Slovakia", new String[] {"HU", "AT", "CZ", "PL"}),
    SI("SI", "Slovenia", new String[] {"IT", "AT", "HU", "HR"}),
    ES("ES", "Spain", new String[] {"FR", "PT"}),
    SE("SE", "Sweden", new String[] {"DK", "FI", "EE", "LV", "LT"}),
    GB("GB", "United Kingdom", new String[] {"IE", "FR", "NL", "BE"});

    private final String id;
    private final String label;
    private final String[] neighbors;


    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String[] getNeighbors() {
        return neighbors;
    }

    CountryRef(String iso, String label,  String[] neighbors) {
        this.id = iso;
        this.label = label;
        this.neighbors = neighbors;
    }

    /**
     * Get ref country
     * @param iso
     * @return country if exists, null otherwise
     */
    public static CountryRef getCountryRefByIso(String iso) {

        Optional<CountryRef> optCountry =
                Arrays.asList(CountryRef.values())
                        .stream()
                        .filter(c -> c.getId().equals(iso))
                        .findFirst();

        if (optCountry.isPresent()){
            return optCountry.get();
        } else {
            return null;
        }

    }

}
