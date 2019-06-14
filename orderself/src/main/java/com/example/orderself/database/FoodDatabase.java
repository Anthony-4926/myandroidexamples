package com.example.orderself.database;

import com.example.orderself.R;
import com.example.orderself.entity.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-14 9:23
 */
public class FoodDatabase {
    protected static List<Food> Foods=initFoods();


    /**
     * 获取所有食物
     * @return所有食物
     */
    public static List<Food> getFoods() {
        return Foods;
    }

    /**
     * 初始化食物数据库
     * @return
     */
    protected static List<Food> initFoods(){
        List<Food> allFood = new ArrayList<>();
        allFood.add(new Food(allFood.size(),
                30,
                "锅包肉",
                "锅包肉，原名“锅爆肉”，出自哈尔滨道台府府尹杜学赢专用厨师，“滨江膳祖”———郑兴文之手。由于用急火快炒，把铁锅烧热，把汁淋到锅里，浸透到肉里，所以起名叫“锅爆肉”。俄罗斯人发“爆”这个音为包，时间一长，“锅爆肉”就变成了“锅包肉”。在西安事变以前，由于东三省归属张氏家族管辖，所以道台府的很多菜，都属于禁菜、私菜。1911年在奉天（今沈阳）召开的万国鼠疫研究会上郑兴文以高超的厨艺受到与会各国代表的高度赞誉，获得大会颁发的荣誉牌匾《滨江膳祖》。日本占领黑龙江以后，张学良对东北部部分地区控制渐松，一些民间工艺、美食菜谱逐渐外流，锅包肉也开始在哈尔滨以及外部流传。后来到了辽宁，辽宁人对其加入了自己的改造，最后一步改用番茄酱或者番茄沙司，外观像极了哈尔滨的“樱桃肉”，减少了锅包肉（锅爆肉）原有的香酥金黄。龙泉山庄的厨师曾在全国电视厨艺大赛上，展现过沈阳版本的“锅包肉”。“滨江膳祖”的曾孙在哈尔滨花园街43号开办了美食店。",
                5,
                true,
                0,
                "待做",
                R.drawable.guobaoro));
        allFood.add(new Food(allFood.size(),
                30,
                "东坡肉",
                "东坡肉，杭州名菜，流行于江浙。相传为北宋诗人苏东坡所创制。制作方法：将五花肉切成大块，用葱姜垫锅底，加上酒、糖、酱油，用水在文火上慢焖即可。东坡肉是杭州名菜，用猪肉炖制而成。其色、香、味俱佳，深受人们喜爱。慢火，少水，多酒，是制作这道菜的诀窍。一般是一块约二寸许的方正形猪肉，一半为肥肉，一半为瘦肉，入口香糯、肥而不腻，带有酒香，色泽红亮，味醇汁浓，酥烂而形不碎，十分美味。",
                10,
                false,
                0,
                "待做",
                R.drawable.dongporo));
        return allFood;
    }

}
