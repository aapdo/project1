package main;

import main.java.Items;
import main.java.Vending_Machine;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main( String[] args ) {ㅎ
        PrintStream out = System.out;
        ArrayList<Items> init_items = new ArrayList<>();
        init_items.add(new Items(1, "cola", 5, 1500));
        init_items.add(new Items(2, "sidar", 5, 1800));
        init_items.add(new Items(3, "doctor pepper", 5, 1600));
        init_items.add(new Items(4, "coffe", 5, 1300));
        init_items.add(new Items(5, "milk", 5, 1000));
        String input_name;
        int input_qty;
        int input_price;
        int input_idx;
        int select_number;
        Items target_item;

        Scanner in = new Scanner(System.in);


        Vending_Machine vending_machine = new Vending_Machine();
        vending_machine.set_items(init_items);

        while (true) {

            out.println("===========원하는 동작을 선택하세요.===========");
            out.println("0. 프로그램 종료");
            out.println("1. 메뉴 추가");
            out.println("2. 메뉴 변경");
            out.println("3. 재고 추가");
            out.println("4. 가격 변경");
            out.println("5. 상품 구매");
            out.println("=========================================");
            select_number = in.nextInt();
            if(select_number == 0){
                break;
            }
            switch (select_number) {
                case 1:
                    out.println("상품의 이름을 입력하세요:");
                    in.nextLine();
                    input_name = in.nextLine();
                    out.println("상품의 재고를 입력하세요:");
                    input_qty = in.nextInt();
                    out.println("상품의 가격을 입력하세요:");
                    input_price = in.nextInt();
                    ArrayList<Items> pre_items = vending_machine.get_items();
                    vending_machine.add_item(pre_items.size() + 1, input_name, input_qty, input_price);
                    break;
                case 2:
                    out.println("변경할 메뉴를 선택하세요.");
                    vending_machine.print_items();
                    input_idx = in.nextInt() - 1;
                    target_item = vending_machine.get_item(input_idx);
                    out.println("무엇을 변경하시겠습니까?.");
                    out.println("1. 이름");
                    out.println("2. 재고");
                    out.println("3. 가격");
                    switch (in.nextInt()) {
                        case 1:
                            in.nextLine();
                            out.println("변경할 이름을 입력해주세요.");
                            input_name = in.nextLine();
                            target_item.name = input_name;// value가 아니라 reference 였다..??
                            break;
                        case 2:
                            in.nextLine();
                            out.println("변경할 재고를 입력해주세요.");
                            input_qty = in.nextInt();
                            target_item.qty = input_qty;
                            break;
                        case 3:
                            in.nextLine();
                            out.println("변경할 가격을 입력해주세요.");
                            input_price = in.nextInt();
                            target_item.price = input_price;
                            break;
                        default:
                            break;
                    }
                    vending_machine.print_items();
                    break;
                case 3:

                    break;
                default:
                    break;
            }

            //vending_machine.add_item(3, "doctor pepper", 3, 1700);


        }
    }
}
