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
public class Page {
    Link pageLink;
    int pageWeight;
    int pageHight;

    ArrayList<Link> listLinks;

    ArrayList<Picture> listPictures;

    ArrayList<String> listTexts;


}
