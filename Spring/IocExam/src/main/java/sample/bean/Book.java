package sample.bean;

import org.springframework.stereotype.Component;

@Component("b") // 생략시 클래스명 첫글자 소문자로 바꾼것으로 자동 설정 됨
public class Book {
    private String title;
    private int price;

    public Book(){
        System.out.println("book generate");
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}