package lab3;

//В молодом возрасте дракон каждый год отращивает по три головы (а может и
//больше), но после того, как ему исполнится 200 лет–только по две (или другое
//количество голов), а после 300 лет–лишь по одной.Разработайте программу,которая высчитывала бы,
//сколько голов и глаз у дракона, которому N лет?
public class Drakon {

    public static String solve(int n) {

        int heads;
        int eyes;
        if (n < 200) {
            heads = n * 3;
            eyes = heads * 2;
            return "Heads and eyes:" + heads + " and " + eyes;
        }
        if (n >= 200 & n < 300) {
            heads = 199 * 3 + (n - 199) * 2;
            eyes = heads * 2;
            return "Heads and eyes:" + heads + " and " + eyes;
        }
        if (n >= 300) {
            heads = 199 * 3 + (n - 199) * 2 + (n - 299);
            eyes = heads * 2;
            return "Heads and eyes:" + heads + " and " + eyes;
        }
        return "\n";
    }
}
