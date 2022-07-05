package com.xsk.framework;

import java.util.List;
import java.util.Random;

/**
 * ｜,;,,;
 * ｜                 ,;;'(    社
 * ｜        __      ,;;' ' \  会
 * ｜    /'  '\'~~'~' \ /'\.)  主
 * ｜  ,;(      )    /  |.     义
 * ｜ ,;' \    /-.,,(   ) \    码
 * ｜      ) /       ) / )|    农
 * ｜      ||        ||  \)
 * ｜      (_\       (_
 *
 * @Author Mr.Xu
 * @description:
 * @Time 2022-07-05 17:46
 */
public class LoadBalance {

    public static URL random(List<URL> list){
        return list.get(new Random().nextInt(list.size())) ;
    }
}
