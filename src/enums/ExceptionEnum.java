package enums;

public enum ExceptionEnum {
    INVALID_LOGIN_EXCEPTION("Invalid Login!"),
    UNSUCCESSFULLY_REGISTER("Unsuccessfully Register!"),
    EMPTY_LIST_EXCEPTION("Data Not Found!"),
    INVALID_CHOICE_EXCEPTION("Invalid Order Choice!"),
    FLIGHT_NOT_FOUND_EXCEPTION("Flight not found!"),
    PASSENGER_NOT_FOUND_EXCEPTION("Customer Not Found"),
    INSUFFICIENT_BALANCE_EXCEPTION("Low Balance Exception!"),
    TICKET_NOT_FOUND_EXCEPTION("Ticket Not Found!!");
    String message;

    ExceptionEnum(String message){
        this.message = message;
    }


    public String getMessage(){
        return message;
    }
}
