package org.un.mapz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Item 객체
class Item {
    private String name;
    private String regDate;
    private int price;
    private int rank;

    public Item() {
    }

    ;

    public Item(String name, String regDate, int price, int rank) {
        setName(name);
        setRegDate(regDate);
        setPrice(price);
        setRank(rank);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", regDate='" + regDate + '\'' +
                ", price=" + price +
                ", rank=" + rank +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

// 정렬자
class Store implements Comparator<Item> {
    public static final int ORDER_BY_DATE = 1;
    public static final int ORDER_BY_PRICE_DESC = 2;
    public static final int ORDER_BY_PRICE_ASC = 3;
    public static final int ORDER_BY_RANK = 4;
    public static final int EXIT = 5;

    private Item[] itemList;
    private int mode;

    @Override
    public int compare(Item item1, Item item2) {
        int result = 0;
        if (mode == ORDER_BY_DATE) {
            result = item1.getRegDate().compareTo(item2.getRegDate());
        } else if (mode == ORDER_BY_PRICE_DESC) {
            result = item2.getPrice() - item1.getPrice();
        } else if (mode == ORDER_BY_PRICE_ASC) {
            result = item1.getPrice() - item2.getPrice();
        } else if (mode == ORDER_BY_RANK) {
            result = item1.getRank() - item2.getRank();
        }
        return result;
    }

    public void showList() {
        Scanner stdIn = new Scanner(System.in);
        String[] menu = {"1. 등록일 순", "2. 높은 가격 순", "3. 낮은 가격순", "4. 상품 랭킹 순", "5. 종료", "*선택하시오(1 ~ 5 이외의번호 입력시 자동종료됩니다. "};
        do {
            for (String view : menu) {
                System.out.println(view);
            }
            mode = stdIn.nextInt();
            if (mode < 1 || mode > 4) {
                mode = EXIT;
            }
            if (mode != EXIT) {
                Arrays.sort(itemList, this);
                for (Item item : itemList) {
                    System.out.println(item);
                }
            }
        } while (mode != EXIT);
        System.out.println("Good bye~");
    }


    public Store(Item... itemList) {
        setItemList(itemList);
    }

    public Item[] getItemList() {
        return itemList;
    }

    public void setItemList(Item[] itemList) {
        this.itemList = itemList;
    }
}


public class SortEx {
    public static void main(String[] args) {
        Store store = new Store (
                new Item("럭셔리 구두", "2019-09-01", 300000, 5),
                new Item("루이비똥 구두", "2018-09-01", 13000, 6),
                new Item("구찌 구두", "2022-09-01", 3300, 1),
                new Item("시장 구두", "2012-09-01", 5600, 2),
                new Item("보통 구두", "2019-08-01", 120000, 4),
                new Item("이..이게뭐 구두", "2019-08-03", 420000, 3)
        );
        store.showList();
    }
}
