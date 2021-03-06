package com.cqz.dm;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * 开发者赚钱平台:www.uuwise.com
 * 更多函数细节：dll.uuwise.com
 */

public class Main {


    public static void main(String[] args) throws Exception {


        //________________初始化接口类需要的参数，或者直接写到UUAPI。java文件里面________________

        UUAPI.SOFTID = 109966;
        UUAPI.SOFTKEY = "4c1e6682a3c647018e96918aedce1ba6";    //KEY 获取方式：http://dll.uuwise.com/index.php?n=ApiDoc.GetSoftIDandKEY
        UUAPI.DLLVerifyKey = "3F0CC8F8-5413-4A33-810A-9902CF778BEF";//校验API文件是否被篡改，实际上此值不参与传输，关系软件安全，高手请实现复杂的方法来隐藏此值，防止反编译,获取方式也是在后台获取软件ID和KEY一个地方

        UUAPI.USERNAME = "zhangweisjz";        //用户帐号和密码(非开发者帐号)，在打码之前，需要先设置好，给用户留一个输入帐号和密码的地方
        UUAPI.PASSWORD = "sai123456";


        boolean status = UUAPI.checkAPI();    //校验API，必须调用一次，校验失败，打码不成功

        if (!status) {
            System.out.print("API文件校验失败，无法使用打码服务");
            return;
        }

        //________________初始化参数结束，上面的操作只需要设置一次________________

        System.out.println("Please input file name");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        String picPath = "img\\" + name;    //测试图片的位置

        //识别开始
        String result[] = UUAPI.easyDecaptcha(picPath, 1004);//picPath是图片路径,1004是codeType,http://www.uuwise.com/price.html

        System.out.println("this img codeID:" + result[0]);
        System.out.println("return recongize Result:" + result[1]);

    }


}




