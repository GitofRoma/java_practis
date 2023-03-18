package tests.homework1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Page implements Searchable{
    Link pageLink;
    int pageWeight;
    int pageHight;

    ArrayList<Link> listLinks;

    ArrayList<Picture> listPictures;

    ArrayList<String> listTexts;


    @Override
    public int[] search(String str) {
        // поиск на странице
        return new int[2];
    }

    @Override
    public void show(int[] location) {
        //выделяет результат поиска
    }
}
