package exemplo.aula.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class TransferInterface {

    static Scanner input = new Scanner(System.in);

    public static int readOriginAccount() {
        System.out.print("ID da conta de origem: ");
        return Integer.parseInt(input.nextLine());
    }

    public static int readDestinationAccount() {
        System.out.print("ID da conta de destino: ");
        return Integer.parseInt(input.nextLine());
    }

    public static BigDecimal readAmount() {
        System.out.print("Valor da transferência: ");
        return new BigDecimal(input.nextLine());
    }
}


