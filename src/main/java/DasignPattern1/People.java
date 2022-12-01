package DasignPattern1;

import lombok.Data;

/**
 * @author YXS
 * @PackageName: DasignPattern1
 * @ClassName: People
 * @Desription:
 * @date 2022/11/22 14:58
 */
@Data
public class People {

    class Coder {
        public void coding(){

            System.out.println("int mian() {");
            System.out.println("    printf(\"Holle Wrold\");");
            System.out.println("}");
            System.out.println("啊勒 怎么运行不起? 明明照着老师敲的啊");

        }
    }

    class Worker {
        public void work() {

            System.out.println("真开心 能进入到富士康打螺丝");
            System.out.println("哎 怎么工友都提桶跑路了");

        }
    }

    class Rider {
        public void ride() {

            System.out.println("今天终于通过美团最终面 加入了梦寐以求的大厂");
            System.out.println("感觉面试挺简单的 就是不知道为啥我同学是现场做一道力口接雨水 我是现场问会不会骑车");
            System.out.println("(迫不及待穿上外外卖服)");

        }
    }

}
