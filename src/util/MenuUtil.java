package util;

public class MenuUtil {
    public static byte entryMenu(){
        System.out.println("""
                [0] -> Exit.
                [1] -> Admin.
                [2] -> Passenger.""");
        return InputUtil.getInstance().inputByte("Choose Option:");
    }
    public static int adminMenu(){
        System.out.println("""
               [0] -> Exit.
               [1] -> Back.
               [2] -> Add Flight.
               [3] -> View Tickets.
               [4] -> View Passenger.
               [5] -> View Notice Board.
               [6] -> View Flight.
               [7] -> Search All.""");
        return InputUtil.getInstance().inputInt("Choose Option:");
    }
    public static byte passengerMenu(){
        System.out.println("""
                [0] -> Exit.
                [1] -> Back.
                [2] -> View Flight.
                [3] -> Order Ticket.
                [4] -> Cancel Order.""");
        return InputUtil.getInstance().inputByte("Choose Option:");
    }
    public static byte orderMenu(){
        System.out.println("""
                [0] -> Back.
                [1] -> Buy Ticket.
                [2] -> Search Flights.""");
        return InputUtil.getInstance().inputByte("Choose Option:");
    }
    public static byte addOrBack(){
        System.out.println("""
                [0] -> Back
                [1] -> Add Flight""");
        return InputUtil.getInstance().inputByte("Choose Option:");
    }
}
