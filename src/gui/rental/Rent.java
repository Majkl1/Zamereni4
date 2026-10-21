package gui.rental;

public class Rent {
    private String customerName;
    private int roomNumber;
    private boolean studentDiscount;
    private SkiType skiType;
    private int rentalDays;

    public Rent(String customerName, int roomNumber, boolean studentDiscount, SkiType skiType, int rentalDays) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.studentDiscount = studentDiscount;
        this.skiType = skiType;
        this.rentalDays = rentalDays;
    }

    public String[] returnAsTableRow(){
        return new String[]{
                customerName,
                String.valueOf(roomNumber),
                studentDiscount ? "Yes" : "No",
                skiType.toString(),
                String.valueOf(rentalDays)
        };
    }
}

enum SkiType {
    SKI("Ski"),
    SNOWBOARD("Snowboard"),
    CROSSCOUNTRY("Cross-country skis");

    private final String name;

    public static SkiType getTypeByCode(int code) {
        switch (code) {
            case 0 -> {
                return SKI;
            }
            case 1 -> {
                return SNOWBOARD;
            }
            default -> {
                return CROSSCOUNTRY;
            }
        }
    }

    SkiType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}