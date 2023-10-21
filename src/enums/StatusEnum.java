package enums;

public enum StatusEnum {
    FLIGHT_ADDED_SUCCESSFULLY("FLIGHT(S) ADDED SUCCESSFULLY"),
    FLIGHT_SUCCESSFULLY_DELETED("FLIGHT DELETED SUCCESSFULLY!"),
    PASSENGER_ADDED_SUCCESSFULLY("PASSENGER SUCCESSFULLY ADDED!"),
    TICKET_ORDER_SUCCESSFULLY("TICKET ORDER SUCCESSFULLY!");
    String message;

    StatusEnum(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
