package com.jorry.task.design_02.prototype.deep;

public class Main {

    public static void main(String[] args) {
        try {
            QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
            System.out.println("深克隆：" + (qiTianDaSheng.jinGuBang == clone.jinGuBang));

            QiTianDaSheng q = new QiTianDaSheng();
            QiTianDaSheng n = q.shallowClone(q);
            System.out.println("浅克隆：" + (q.jinGuBang == n.jinGuBang));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
